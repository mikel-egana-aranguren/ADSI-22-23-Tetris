package com.zetcode;

import java.util.ArrayList;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.json.JSONArray;
import org.json.JSONObject;

public class Gestor {
    public static JSONArray obtenerPremios() {
        GestorUsuario gu = GestorUsuario.getGestorUsuario();
        Usuario usuario = gu.obtenerUsuarioActual();
        String nombreUsuario = gu.getNombreUsuario(usuario);
        ArrayList<Premio> premios = GestorPremios.obtenerPremios(nombreUsuario);
        JSONArray premiosjson = new JSONArray(premios.stream().map(
            premio -> {
                JSONObject json = new JSONObject();
                json.put("nombrePremio", premio.getNombre());
                json.put("progreso", premio.getProgreso());
                json.put("progresoMax", premio.getProgresoMax());
                return json;
            }).collect(Collectors.toList()
        ));
        return premiosjson;
    }

    public static JSONObject obtenerDescripcionPremio(String nombrePremio) {
        GestorUsuario gu = GestorUsuario.getGestorUsuario();
        Usuario usuario = gu.obtenerUsuarioActual();
        gu.getNombreUsuario(usuario);
        return GestorPremios.obtenerDescripcionPremio(nombrePremio);
    }

    public static void comprobarProgresoPremios() {
        GestorPremios.comprobarProgresoPremios();
    }

    public static void comprobarProgresoPremiosFinalPartida() {
        GestorPremios.comprobarProgresoPremiosFinalPartida();
    }

	public static void addPuntos(int puntos) {
		GestorUsuario gu = GestorUsuario.getGestorUsuario();
        Usuario usuario = gu.obtenerUsuarioActual();
		Partida par = gu.obtenerPartidaUsuario(usuario);
		GestorPartida.addPuntos(par, puntos);
	}

    private String getRankingGlobal() {
        // TODO
        return "";
    }

    private String getRankingGlobalFiltrado(int i1) {
        // TODO
        return "";
    }

    private String getRankingPersonal(String st1) {
        // TODO
        return "";
    }

    private String getRankingPersonalFiltrado(int i1, String st1) {
        // TODO
        return "";
    }

    private boolean comprobarContraseña(String pwd1, String pwd2) {
        // TODO
        return false;
    }

    private void registrarse(String usu, String email, String pwd1) {
        // TODO
    }

    private String identificarse(String usu, String pwd) {
        // TODO
        return "";
    }

    private boolean recuperar(String textoIntroducido) {
        // TODO
        return false;
    }

    private boolean comprobar(String usu, String pwdVieja, String pwd1, String pwd2) {
        // TODO
        return false;
    }

    private void cambiar(String usu, String pwdVieja, String pwd) {
        // TODO
    }

    private void eliminarUsuario(String usu) {
        // TODO
    }

    private int mostarDificultad(String nombreUsuario, int dificultad) {
        // TODO
        return 0;
    }

    private void actualizarDificultad(String nombreUsuario, int dificultad) {
        // TODO
    }

    private String mostrarPersonalizacion(String nombreUsuario) {
        // TODO
        return "";
    }

    private String actualizarPersonalizacion(String nombreUsuario) {
        // TODO
        return "";
    }

    public static void guardarPartida() {
		ResultSet resultado;
		//Obtener los datos necesarios
		Usuario usuario = GestorUsuario.getGestorUsuario().obtenerUsuarioActual();
		String nombreUsuario = GestorUsuario.getGestorUsuario().getNombreUsuario(usuario);
		Partida partidaUsuario = GestorUsuario.getGestorUsuario().obtenerPartidaUsuario(usuario);
		int idPartida = GestorPartida.obtenerIdPartida(partidaUsuario);
		int puntos = GestorPartida.obtenerPuntos(partidaUsuario);
		JSONObject estadoTableroJSON = GestorPartida.obtenerEstadoTablero(partidaUsuario); //Guardar el JSON como un string en la base de datos y luego parsear al cargar
		String estadoTableroString = estadoTableroJSON.toString();
		String dificultad = GestorDificultad.buscarDificultad(usuario).getNombre();
		GestorPremios.comprobarProgresoPremios(); //Comprobar el progreso de los premios
		ArrayList<Premio> listaPremios = GestorPremios.obtenerPremios(nombreUsuario);
		resultado = SGBD.execResultSQL("SELECT * FROM PARTIDA WHERE id =="+idPartida);
		if (resultado == null) { //INSERT
			SGBD.execVoidSQL(String.format("INSERT INTO PARTIDA VALUES(%d,%d,%s,%s,%s)",idPartida,puntos,estadoTableroString,nombreUsuario,dificultad));
		} else { //UPDATE
			SGBD.execVoidSQL(String.format("UPDATE PARTIDA SET puntos=%d, estadoTablero='%s' WHERE id=%d)",puntos,estadoTableroString,idPartida));
		}
		for (Premio premio : listaPremios) {
			String nombrePremio = premio.getNombre();
			int progreso = premio.getProgreso();
			resultado = SGBD.execResultSQL("SELECT * FROM PREMIOSENPARTIDA WHERE id =="+idPartida+"nombrePremio="+nombrePremio);
			if (resultado == null) { //INSERT
				SGBD.execVoidSQL(String.format("INSERT INTO PREMIOSENPARTIDA VALUES(%d,'%s',%d)",idPartida,nombrePremio,progreso));
			} else { //UPDATE
				SGBD.execVoidSQL(String.format("UPDATE PREMIOSENPARTIDA SET progreso=%d)",progreso));
			}
		}
	}
	
	public static void cargarPartida(int pIdPartida) {
		ResultSet resultado;
		try {
			resultado = SGBD.execResultSQL("SELECT * FROM PARTIDA WHERE id="+pIdPartida);
			resultado.next();
			int id = pIdPartida;
			int puntos = resultado.getInt("puntos");
			String estadoTableroString = resultado.getString("estadoTablero");
			Usuario usuario = GestorUsuario.getGestorUsuario().obtenerUsuarioActual();
			String nombreUsuario = GestorUsuario.getGestorUsuario().getNombreUsuario(usuario);
			String dificultad = resultado.getString("dificultad");
			resultado = SGBD.execResultSQL("SELECT * FROM PREMIOSENPARTIDA WHERE idPartida="+pIdPartida);
			resultado.next();
			String nombrePremio = resultado.getString("nombrePremio");
			int progreso = resultado.getInt("progreso");
			Gson jsonParser = new Gson();
			JSONObject estadoTableroJson = jsonParser.fromJson(estadoTableroString, JSONObject.class);
			//Meter todos los datos en las clases
			Partida partidaUsuario = new Partida();
			GestorPartida.setIdPartida(partidaUsuario,pIdPartida);
			GestorPartida.setPuntosPartida(partidaUsuario,puntos);
			GestorPartida.setEstadoTablero(partidaUsuario,estadoTableroJson);
			GestorUsuario.getGestorUsuario().setPartidaUsuario(usuario,partidaUsuario);
		} catch (Exception e) {
			Menu.getMenu().ponerMensaje("Error: " + e);
		}
	}

    private void gestionarEvento(String evento) {
        // TODO
    }

    private void publicarResultados(String st1) {
        // TODO
    }

    private String configurarMensaje(String nombreUsuario, int puntos, ArrayList<String> listNombresPrem) {
        // TODO
        return "";
    }

    public static void addFilas(int filas) {
        GestorUsuario gu = GestorUsuario.getGestor();
        Usuario usuario = gu.obtenerUsuarioActual();
        Partida partida = gu.obtenerPartidaUsuario(usuario);

        GestorPartida.addFilas(partida, filas);
    }

    public static void addTetrises(int tetrises) {
        GestorUsuario gu = GestorUsuario.getGestor();
        Usuario usuario = gu.obtenerUsuarioActual();
        Partida partida = gu.obtenerPartidaUsuario(usuario);

        GestorPartida.addTetrises(partida, tetrises);
    }

    public static void contarFicha() {
        GestorUsuario gu = GestorUsuario.getGestor();
        Usuario usuario = gu.obtenerUsuarioActual();
        Partida partida = gu.obtenerPartidaUsuario(usuario);

        GestorPartida.contarFicha(partida);
    }
}

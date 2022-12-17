package com.zetcode;

import java.sql.ResultSet;
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

    public static void guardarPartida(String pEstadoTablero) {
		ResultSet resultado;
		//Obtener los datos necesarios
		Usuario usuario = GestorUsuario.getGestorUsuario().obtenerUsuarioActual();
		String nombreUsuario = GestorUsuario.getGestorUsuario().getNombreUsuario(usuario);
		Partida partidaUsuario = GestorUsuario.getGestorUsuario().obtenerPartidaUsuario(usuario);
		int idPartida = GestorPartida.obtenerIdPartida(partidaUsuario);
		int puntos = GestorPartida.obtenerPuntos(partidaUsuario);
		String estadoTablero = pEstadoTablero;
		String dificultad = GestorDificultad.buscarDificultad(usuario).getNombre();
		GestorPremios.comprobarProgresoPremios(); //Comprobar el progreso de los premios
		ArrayList<Premio> listaPremios = GestorPremios.obtenerPremios(nombreUsuario);
		resultado = SGBD.execResultSQL("SELECT * FROM PARTIDA WHERE id =="+idPartida);
		if (resultado == null) { //INSERT
			SGBD.execVoidSQL(String.format("INSERT INTO PARTIDA VALUES(%d,%d,%s,%s,%s)",idPartida,puntos,estadoTablero,nombreUsuario,dificultad));
		} else { //UPDATE
			SGBD.execVoidSQL(String.format("UPDATE PARTIDA SET puntos=%d, estadoTablero='%s' WHERE id=%d)",puntos,estadoTablero,idPartida));
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
		resultado.close();
	}
	
	public static void cargarPartida(int pIdPartida) {
		ResultSet resultado;
		Usuario usuario = GestorUsuario.getGestorUsuario().obtenerUsuarioActual();
		Partida partidaUsuario = new Partida();
		String estadoTablero = null;
		try {
			//Cargar los datos de PARTIDA
			resultado = SGBD.execResultSQL("SELECT * FROM PARTIDA WHERE id="+pIdPartida);
			if (resultado.next()) {
				int id = pIdPartida;
				int puntos = resultado.getInt("puntos");
				estadoTablero = resultado.getString("estadoTablero");
				String nombreUsuario = GestorUsuario.getGestorUsuario().getNombreUsuario(usuario);
				String dificultad = resultado.getString("dificultad");
				GestorPartida.setIdPartida(partidaUsuario,pIdPartida);
				GestorPartida.setPuntosPartida(partidaUsuario,puntos);
				GestorPartida.setEstadoTablero(partidaUsuario,estadoTablero);
				GestorUsuario.getGestorUsuario().setPartidaUsuario(usuario,partidaUsuario);
				GestorDificultad.cambiarDificultad(dificultad);
			}
			resultado.close();
			
			//Cargar datos de PREMIOS EN PARTIDA
			resultado = SGBD.execResultSQL("SELECT * FROM PREMIOSENPARTIDA WHERE idPartida="+pIdPartida);
			while (resultado.next()) {
				String nombrePremio = resultado.getString("nombrePremio");
				int progreso = resultado.getInt("progreso");
				Premio premio = new Premio(nombrePremio,progreso,null);
				GestorPartida.anadirPremioPartida(partidaUsuario, premio);
			}
			resultado.close();
			Tetris.getTetris().start(estadoTablero);
		} catch (Exception e) {
			Menu.getMenu().ponerMensaje("Error: " + e);
		}
	}
	
	public static JSONObject obtenerPartidasUsuarioActual() {
		Usuario usuario = GestorUsuario.getGestorUsuario().obtenerUsuarioActual();
		String nombreUsuario = GestorUsuario.getGestorUsuario().getNombreUsuario(usuario);
		JSONObject[] arrayPartidas = {};
		JSONObject partida;
		try {
			ResultSet resultado = SGBD.execResultSQL("SELECT * FROM PARTIDA WHERE nombreUsuario ="+nombreUsuario);
			while (resultado.next()) {
				int id = resultado.getInt("idPartida");
				int puntos = resultado.getInt("puntos");
				partida = new JSONObject();
				partida.put("id", id);
				partida.put("puntos", puntos);
				arrayPartidas[arrayPartidas.length] = partida;
			}
			resultado.close();
		} catch (Exception e) {
			System.err.println(e);
		}
		JSONObject listaPartidas = new JSONObject();
		listaPartidas.put("listaPartidas", arrayPartidas);
		return listaPartidas;
	}
	
	public void nuevaPartida() {
		Tetris.getTetris().start(null);
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
        GestorUsuario gu = GestorUsuario.getGestorUsuario();
        Usuario usuario = gu.obtenerUsuarioActual();
        Partida partida = gu.obtenerPartidaUsuario(usuario);

        GestorPartida.addFilas(partida, filas);
    }

    public static void addTetrises(int tetrises) {
        GestorUsuario gu = GestorUsuario.getGestorUsuario();
        Usuario usuario = gu.obtenerUsuarioActual();
        Partida partida = gu.obtenerPartidaUsuario(usuario);

        GestorPartida.addTetrises(partida, tetrises);
    }

    public static void contarFicha() {
        GestorUsuario gu = GestorUsuario.getGestorUsuario();
        Usuario usuario = gu.obtenerUsuarioActual();
        Partida partida = gu.obtenerPartidaUsuario(usuario);

        GestorPartida.contarFicha(partida);
    }
}

package com.zetcode;

import java.util.ArrayList;

public class Gestor {
    private static Gestor miGestor = null;
    
    private Gestor() {
    
    }
	
    public static Gestor getGestor() {
	if (miGestor == null) {
            miGestor = new Gestor();
        }
        return miGestor;
    }
    
    private String obtenerPremios() {
        // TODO
        return "";
    }

    private String obtenerDescripcionPremio(String st1) {
        // TODO
        return "";
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

    public void guardarPartida() {
		ResultSet resultado;
		//Obtener los datos necesarios
		Usuario usuario = GestorUsuario.getGestorUsuario().obtenerUsuarioActual();
		String nombreUsuario = GestorUsuario.getGestorUsuario().getNombreUsuario(usuario);
		Partida partidaUsuario = GestorUsuario.getGestorUsuario().obtenerPartidaUsuario(usuario);
		int idPartida = GestorPartida.getGestorPartida().obtenerIdPartida(partidaUsuario);
		int puntos = GestorPartida.getGestorPartida().obtenerPuntos(partidaUsuario);
		JSONObject estadoTableroJSON = GestorPartida.getGestorPartida().obtenerEstadoTablero(partidaUsuario); //Guardar el JSON como un string en la base de datos y luego parsear al cargar
		String estadoTableroString = estadoTableroJSON.toString();
		String dificultad = GestorDificultad.getGestorDificultad().buscarDificultad(usuario).getNombre();
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
	
	public void cargarPartida(int pIdPartida) {
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
			GestorPartida.getGestorPartida().setIdPartida(partidaUsuario,pIdPartida);
			GestorPartida.getGestorPartida().setPuntosPartida(partidaUsuario,puntos);
			GestorPartida.getGestorPartida().setEstadoTablero(partidaUsuario,estadoTableroJson);
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
}

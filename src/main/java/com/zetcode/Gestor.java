package com.zetcode;

import java.util.ArrayList;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.json.JSONArray;
import org.json.JSONObject;

public class Gestor {
    public static JSONArray obtenerPremios() {
        GestorUsuario gu = GestorUsuario.getGestor();
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
        GestorUsuario gu = GestorUsuario.getGestor();
        Usuario usuario = gu.obtenerUsuarioActual();
        gu.getNombreUsuario(usuario);
        return GestorPremios.obtenerDescripcionPremio(nombrePremio);
    }

    public static void comprobarProgresoPremios() {
        GestorPremios.comprobarProgresoPremios();
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

    private void guardarPartida() {
        // TODO
    }

    private void cargarPartida(String st1) {
        // TODO
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

package com.zetcode;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.json.JSONObject;

public class GestorPremios {
    public static ArrayList<Premio> obtenerPremios(String nombreUsuario) {
        ArrayList<Premio> listaPremios = new ArrayList<Premio>();

        ResultSet resultado;

        resultado = SGBD.execResultSQL(String.format(""
        + "SELECT nombrepremio, progreso, progresoMax "
        + "FROM Premio JOIN PremioObtenido "
        + "ON PremioObtenido.nombrepremio=Premio.Nombre "
        + "WHERE PremioObtenido.nombreusuario='%s'",
        nombreUsuario
        ));
        try {
            while (resultado.next()) {
                String nombre = resultado.getString("nombre");
                Integer progreso = resultado.getInt("progreso");
                Integer progresoMax = resultado.getInt("progresoMax");
                Premio premio = new Premio(nombre, progreso, progresoMax);
    
                listaPremios.add(premio);
            };
        } catch(SQLException e) { 
            e.printStackTrace();
        }

        resultado = SGBD.execResultSQL(""
            + "SELECT nombrepremio, progresoMax "
            + "FROM Premio");
        try {
            while (resultado.next()) {
                String nombre = resultado.getString("nombre");
                Integer progresoMax = resultado.getInt("progresoMax");
                Premio premio = new Premio(nombre, 0, progresoMax);
    
                listaPremios.add(premio);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 

        return listaPremios;
    }

    public static JSONObject obtenerDescripcionPremio(String nombrePremio) {
        ResultSet resultado;
        JSONObject json = null;

        resultado = SGBD.execResultSQL(String.format(""
            + "SELECT descripcion, progreso, progresoMax "
            + "FROM Premio JOIN PremioObtenido "
                + "ON PremioObtenido.nombrepremio=Premio.Nombre "
            + "WHERE PremioObtenido.nombrepremio='%s'", nombrePremio));

        String descripcion = null;
        Integer progreso = null;
        Integer progresoMax = null;
        try {
            descripcion = resultado.getString("descripcion");
            progreso = resultado.getInt("progreso");
            progresoMax = resultado.getInt("progresoMax");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        json = new JSONObject();
    
        json.put("nombre", nombrePremio);
        json.put("descripcion", descripcion);
        json.put("progreso", progreso);
        json.put("ProgresoMax", progresoMax);

        return json;
    }

    private static void comprobarProgresoPremios() {
        ArrayList<Premio> premios = obtenerPremiosProgresados();
        guardarProgresoPremios(premios);
    }

    private static ArrayList<Premio> obtenerPremiosProgresados() {
        Premio pcf = obtenerPremioColocarFichas();
        Premio pef = obtenerPremioEliminarFilas();
        Premio pht = obtenerPremioHacerTetris();

        ArrayList<Premio> listaPremios = new ArrayList<Premio>();
        if (pcf != null) {
            listaPremios.add(pcf);
        }
        if (pef != null) {
            listaPremios.add(pef);
        }
        if (pht != null) {
            listaPremios.add(pht);
        }

        return listaPremios;
    }

    private static Premio obtenerPremioColocarFichas() {
        GestorUsuario gu = GestorUsuario.getGestor();

        Usuario usuario = gu.obtenerUsuarioActual();
        Partida partida = gu.obtenerPartidaUsuario(usuario);
        Integer fichas = GestorPartida.fichasColocadas(partida);

        Premio p = null;
        if (fichas > 0) {
            p = new Premio("fichas colocadas", fichas, null);
        }

        return p;
    }

    private static Premio obtenerPremioEliminarFilas() {
        GestorUsuario gu = GestorUsuario.getGestor();

        Usuario usuario = gu.obtenerUsuarioActual();
        Partida partida = gu.obtenerPartidaUsuario(usuario);
        Integer filas = GestorPartida.filasEliminadas(partida);

        Premio p = null;
        if (filas > 0) {
            p = new Premio("filas eliminadas", filas, null);
        }

        return p;
    }

    private static Premio obtenerPremioHacerTetris() {
        GestorUsuario gu = GestorUsuario.getGestor();

        Usuario usuario = gu.obtenerUsuarioActual();
        Partida partida = gu.obtenerPartidaUsuario(usuario);
        Integer tetrises = GestorPartida.tetrisHechos(partida);

        Premio p = null;
        if (tetrises > 0) {
            p = new Premio("tetris hechos", tetrises, null);
        }

        return p;
    }

    private static void guardarProgresoPremios(ArrayList<Premio> premios) {
        GestorUsuario gu = GestorUsuario.getGestor();

        Usuario usuario = gu.obtenerUsuarioActual();
        Partida partida = gu.obtenerPartidaUsuario(usuario);
        GestorPartida.anadirPremios(partida, premios);
    }

    private static void comprobarProgresoPremiosFinalPartida() {
        ArrayList<Premio> premios = obtenerPremiosProgresadosFinalPartida();
        premios.forEach(premio -> progresarPremio(premio));
    }

    private static ArrayList<String> obtenerPremiosCompletados(String usu, ArrayList<Premio> listaPremios) {
        // TODO
        return null;
    }

    private static ArrayList<Premio> obtenerPremiosProgresadosFinalPartida() {
        GestorUsuario gu = GestorUsuario.getGestor();

        Usuario usuario = gu.obtenerUsuarioActual();
        Partida partida = gu.obtenerPartidaUsuario(usuario);
        obtenerPremioDificultad(partida, usuario);
        obtenerPremioPuntos(partida);
        comprobarProgresoPremios();
        return GestorPartida.obtenerPremios(partida);
    }

    private static Premio obtenerPremioDificultad(Partida partida, Usuario usuario) {
        Integer puntos = GestorPartida.obtenerPuntos(partida);
        Dificultad dificultad = GestorDificultad.buscarDificultad(usuario);

        Premio p = new Premio("%dependiendo de la dificultad", puntos, null); // TODO
        return p;
    }

    private static Premio obtenerPremioPuntos(Partida partida) {
        Integer puntos = GestorPartida.obtenerPuntos(partida);

        Premio p = new Premio("puntos totales obtenidos", puntos, null);
        return p;
    }

    private static void progresarPremio(Premio premio) {
        GestorUsuario gu = GestorUsuario.getGestor();

        Usuario usuario = gu.obtenerUsuarioActual();
        String nusuario = gu.getNombreUsuario(usuario);
        String npremio = premio.getNombre();
        Integer progreso = premio.getProgreso();
        SGBD.execVoidSQL(String.format(""
            + "INSERT INTO PremioObtenido(nombrepremio, nombreusuario, progreso "
            + "VALUES ('%s', '%s', 0) "
            + "WHERE '%s' NOT IN "
                + "(SELECT nombrepremio "
                + "FROM PremioObtenido "
                + "WHERE nombreusuario='%s')",
            npremio, nusuario,
            npremio,


            nusuario
        ));

        SGBD.execVoidSQL(String.format(""
            + "UPDATE PremioObtenido "
            + "SET progreso=progreso+%s "
            + "WHERE nombrepremio='%s' "
                + "AND nombreusuario='%s'",
            progreso,
            npremio,
            nusuario
        ));
    }
}

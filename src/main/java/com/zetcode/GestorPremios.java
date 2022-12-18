package com.zetcode;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.json.JSONObject;

public class GestorPremios {
    /**
     * Obtiene todos los premios del usuario.
     * Tanto si se han completado como si no.
    */
    public static ArrayList<Premio> obtenerPremios(String nombreUsuario) {
        ArrayList<Premio> listaPremios = new ArrayList<Premio>();

        ResultSet resultado;

        // Todos los premios en los que ha progresado el usuario
        resultado = SGBD.execResultSQL(String.format(""
            + "SELECT nombrepremio, progreso, progresoMax "
            + "FROM Premio JOIN PremioObtenido "
            + "ON PremioObtenido.nombrepremio=Premio.Nombre "
            + "WHERE PremioObtenido.nombreusuario='%s'",
                nombreUsuario
        ));
        try {
            while (resultado.next()) {
                String nombre = resultado.getString("nombrepremio");
                Integer progreso = resultado.getInt("progreso");
                Integer progresoMax = resultado.getInt("progresoMax");
                Premio premio = new Premio(nombre, progreso, progresoMax);
    
                listaPremios.add(premio);
            };
        } catch(SQLException e) { 
            e.printStackTrace();
        }

        // Todos los premios en los que no ha progresado el usuario
        resultado = SGBD.execResultSQL(String.format(""
            + "SELECT nombre, progresoMax "
            + "FROM Premio WHERE nombre NOT IN ("
                + "SELECT nombrepremio "
                + "FROM Premio JOIN PremioObtenido "
                + "ON PremioObtenido.nombrepremio=Premio.Nombre "
                + "WHERE PremioObtenido.nombreusuario='%s'"
            + ")",
                nombreUsuario
        ));
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

    /**
     * Obtiene todo lo necesario para mostrar la descripción de un premio.
     * 
     * Esto es la descripción, su progreso, su nombre y su progreso máximo.
     */
    public static JSONObject obtenerDescripcionPremio(String nombrePremio) {
        GestorUsuario gu = GestorUsuario.getGestorUsuario();
        Usuario usuario = gu.obtenerUsuarioActual();
        String nombreUsuario = gu.getNombreUsuario(usuario);

        ResultSet resultado;
        JSONObject json = null;

        resultado = SGBD.execResultSQL(String.format(""
            + "SELECT descripcion, progreso, progresoMax "
            + "FROM Premio JOIN PremioObtenido "
                + "ON PremioObtenido.nombrePremio=Premio.nombre "
            + "WHERE PremioObtenido.nombrePremio='%s' "
            + "AND nombreUsuario='%s'",
                nombrePremio,
                nombreUsuario
            ));

        String descripcion = null;
        Integer progreso = null;
        Integer progresoMax = null;
        try {
            if (resultado.next()) {
                descripcion = resultado.getString("descripcion");
                progreso = resultado.getInt("progreso");
                progresoMax = resultado.getInt("progresoMax");
            } else {
                resultado = SGBD.execResultSQL(String.format(""
                    + "SELECT descripcion, progresoMax "
                    + "FROM Premio "
                    + "WHERE Premio.nombre='%s'", nombrePremio));
                resultado.next();

                descripcion = resultado.getString("descripcion");
                progreso = 0;
                progresoMax = resultado.getInt("progresoMax");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        json = new JSONObject();
    
        json.put("nombre", nombrePremio);
        json.put("descripcion", descripcion);
        json.put("progreso", progreso);
        json.put("progresoMax", progresoMax);

        return json;
    }

    /**
     * Si el usuario ha progresado en un premio, se registra en su partida
     */
    public static void comprobarProgresoPremios() {
        ArrayList<Premio> premios = obtenerPremiosProgresados();
        guardarProgresoPremios(premios);
    }

    /**
     * Los premios en los que el usuario ha progresado en esta partida
     * desde que se llamó a esta función por última vez
     */
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

    /**
     * Devuelve un premio si ha progresado en él
     * 
     * Si no, null
     */
    private static Premio obtenerPremioColocarFichas() {
        GestorUsuario gu = GestorUsuario.getGestorUsuario();

        Usuario usuario = gu.obtenerUsuarioActual();
        Partida partida = gu.obtenerPartidaUsuario(usuario);
        Integer fichas = GestorPartida.fichasColocadas(partida);

        Premio p = null;
        if (fichas > 0) {
            p = new Premio("Colocador de Fichas", fichas, null);
        }

        return p;
    }

    /**
     * Devuelve un premio si ha progresado en él
     * 
     * Si no, null
     */
    private static Premio obtenerPremioEliminarFilas() {
        GestorUsuario gu = GestorUsuario.getGestorUsuario();

        Usuario usuario = gu.obtenerUsuarioActual();
        Partida partida = gu.obtenerPartidaUsuario(usuario);
        Integer filas = GestorPartida.filasEliminadas(partida);

        Premio p = null;
        if (filas > 0) {
            p = new Premio("Eliminador de Filas", filas, null);
        }

        return p;
    }

    /**
     * Devuelve un premio si ha progresado en él
     * 
     * Si no, null
     */
    private static Premio obtenerPremioHacerTetris() {
        GestorUsuario gu = GestorUsuario.getGestorUsuario();

        Usuario usuario = gu.obtenerUsuarioActual();
        Partida partida = gu.obtenerPartidaUsuario(usuario);
        Integer tetrises = GestorPartida.tetrisHechos(partida);

        Premio p = null;
        if (tetrises > 0) {
            p = new Premio("Maestro del TETRIS", tetrises, null);
        }

        return p;
    }

    /**
     * Añade los premios a la partida actual
     */
    private static void guardarProgresoPremios(ArrayList<Premio> premios) {
        GestorUsuario gu = GestorUsuario.getGestorUsuario();

        Usuario usuario = gu.obtenerUsuarioActual();
        Partida partida = gu.obtenerPartidaUsuario(usuario);
        GestorPartida.anadirPremios(partida, premios);
    }

    /**
     * Progresa en todos los premios, tanto de final de partida
     * como los normales.
     * 
     * Después, actualiza la base de datos
     */
    public static void comprobarProgresoPremiosFinalPartida() {
        ArrayList<Premio> premios = obtenerPremiosProgresadosFinalPartida();
        premios.forEach(premio -> progresarPremio(premio));
    }

    public static ArrayList<String> obtenerPremiosCompletados(String nomUsu, ArrayList<Premio> premiosPartida)
    {
        ArrayList<String> listaNombres = new ArrayList<String>();
        ArrayList<Premio> premiosTotales = obtenerPremios(nomUsu);
        int i = 0;
        while (i<premiosPartida.size())
        {
            int s = 0;
            boolean found = false;
            while (s<premiosTotales.size() && !found)
            {
                if (premiosTotales.get(s).getNombre().equals(premiosPartida.get(i).getNombre()))
                {
                    int progPartida = premiosPartida.get(i).getProgreso();
                    int progTotal = premiosTotales.get(s).getProgreso();
                    int progMax = premiosTotales.get(s).getProgresoMax();
                    if ((progPartida + progTotal) == progMax)
                    {
                        listaNombres.add(premiosTotales.get(s).getNombre());
                    }
                    found = true;
                }
                s++;
            }
            i++;
        }
        return listaNombres;
    }

    /**
     * Progresa en todos los premios, tanto de final de partida
     * como los normales.
     */
    private static ArrayList<Premio> obtenerPremiosProgresadosFinalPartida() {
        GestorUsuario gu = GestorUsuario.getGestorUsuario();

        Usuario usuario = gu.obtenerUsuarioActual();
        Partida partida = gu.obtenerPartidaUsuario(usuario);
        Premio pd = obtenerPremioDificultad(partida, usuario);
        Premio pp = obtenerPremioPuntos(partida);
        ArrayList<Premio> premios = new ArrayList<Premio>();
        if (pd != null) {
            premios.add(pd);
        }
        if (pp != null) {
            premios.add(pp);
        }
        GestorPartida.anadirPremios(partida, premios);
        comprobarProgresoPremios();
        return GestorPartida.obtenerPremios(partida);
    }

    /**
     * Devuelve un premio si ha progresado en él
     * 
     * Si no, null
     */
    private static Premio obtenerPremioDificultad(Partida partida, Usuario usuario) {
        Integer puntos = GestorPartida.obtenerPuntos(partida);
        int dificultad = GestorDificultad.getDificultad();

        Premio p = null;
        if (dificultad == 0 && puntos >= 5000) {
            p = new Premio("Aprendiz", 1, null);
        } else if (dificultad == 1 && puntos >= 10000) {
            p = new Premio("Veterano", 1, null);
        } else if (dificultad == 2 && puntos >= 30000) {
            p = new Premio("Maestro", 1, null);
        }

        return p;
    }

    /**
     * Devuelve el premio de obtener puntos
     */
    private static Premio obtenerPremioPuntos(Partida partida) {
        Integer puntos = GestorPartida.obtenerPuntos(partida);

        Premio p = new Premio("Puntuador Extremo", puntos, null);
        return p;
    }

    /**
     * Actualiza la base de datos con el progreso del premio
     */
    private static void progresarPremio(Premio premio) {
        GestorUsuario gu = GestorUsuario.getGestorUsuario();

        Usuario usuario = gu.obtenerUsuarioActual();
        String nusuario = gu.getNombreUsuario(usuario);
        String npremio = premio.getNombre();
        Integer progreso = premio.getProgreso();
        ResultSet result = SGBD.execResultSQL(String.format(""
            + "SELECT nombrePremio FROM PremioObtenido "
            + "WHERE nombrePremio='%s' "
                + "AND nombreusuario='%s'",
            npremio,
            nusuario
        ));

        try {
            if (result.next()) {
                SGBD.execVoidSQL(String.format(""
                    + "UPDATE PremioObtenido "
                    + "SET progreso=progreso+%s "
                    + "WHERE nombrepremio='%s' "
                        + "AND nombreusuario='%s'",
                    progreso,
                    npremio,
                    nusuario
                ));
            } else {
                SGBD.execVoidSQL(String.format(""
                + "INSERT INTO PremioObtenido(nombrepremio, nombreusuario, progreso) "
                    + "VALUES ('%s', '%s', %s) ",
                    npremio, nusuario, progreso
                ));
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
}

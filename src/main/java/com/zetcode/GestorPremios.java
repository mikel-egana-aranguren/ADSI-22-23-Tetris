package com.zetcode;

import java.util.ArrayList;

public class GestorPremios {
    public ArrayList<Premio> obtenerPremios(String nombreUsuario) {
        String resultado; // TODO
        resultado = execSQL(String.format(""
            + "SELECT nombrepremio, progreso, progresoMax "
            + "FROM Premio JOIN PremioObtenido "
                + "ON PremioObtenido.nombrepremio=Premio.Nombre "
            + "WHERE PremioObtenido.nombreusuario='%s'"
            , nombreUsuario));
        resultado.next();
        String nombre = resultado.getSring("nombre");
        Integer progreso = resultado.getInt("progreso");
        Integer progresoMax = resultado.getInt("progresoMax");
        Premio premio = new Premio(nombre, progreso, progresoMax);
        resultado = execSQL(""
            + "SELECT nombrepremio, progresoMax "
            + "FROM Premio");
        resultado.next();
        nombre = resultado.getString("nombre");
        progresoMax = resultado.getInt("progresoMax");
        new Premio(nombre, 0, progresoMax);
        // TODO
        return null;
    }

    public String obtenerDescripcionPremio(String nombrePremio) {
        String resultado; // TODO
        resultado = execSQL(String.format(""
            + "SELECT descripcion, progreso, progresoMax "
            + "FROM Premio JOIN PremioObtenido "
                + "ON PremioObtenido.nombrepremio=Premio.Nombre "
            + "WHERE PremioObtenido.nombrepremio='%s'", nombrePremio));
        
        String descripcion = resultado.getString("descripcion");
        Integer progreso = resultado.getInt("progreso");
        Integer progresoMax = resultado.getInt("progresoMax");
        // TODO
        return "";
    }

    private void comprobarProgresoPremios() {
        ArrayList<Premio> premios = obtenerPremiosProgresados();
        guardarProgresoPremios(premios);
    }

    private ArrayList<Premio> obtenerPremiosProgresados() {
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

    private Premio obtenerPremioColocarFichas() {
        GestorUsuario gu = null; // TODO
        GestorPartida gpar = null; // TODO

        Usuario usuario = gu.obtenerUsuarioActual();
        Partida partida = gu.obtenerPartidaUsuario(usuario);
        Integer fichas = gpar.fichasColocadas(partida);

        Premio p = null;
        if (fichas > 0) {
            p = new Premio("fichas colocadas", fichas, null);
        }

        return p;
    }

    private Premio obtenerPremioEliminarFilas() {
        GestorUsuario gu = null; // TODO
        GestorPartida gpar = null; // TODO

        Usuario usuario = gu.obtenerUsuarioActual();
        Partida partida = gu.obtenerPartidaUsuario(usuario);
        Integer filas = gpar.filasEliminadas(partida);

        Premio p = null;
        if (filas > 0) {
            p = new Premio("filas eliminadas", filas, null);
        }

        return p;
    }

    private Premio obtenerPremioHacerTetris() {
        GestorUsuario gu = null; // TODO
        GestorPartida gpar = null; // TODO

        Usuario usuario = gu.obtenerUsuarioActual();
        Partida partida = gu.obtenerPartidaUsuario(usuario);
        Integer tetrises = gpar.tetrisHechos(partida);

        Premio p = null;
        if (tetrises > 0) {
            p = new Premio("tetris hechos", tetrises, null);
        }

        return p;
    }

    private void guardarProgresoPremios(ArrayList<Premio> premios) {
        GestorUsuario gu = null; // TODO
        GestorPartida gpar = null; // TODO

        Usuario usuario = gu.obtenerUsuarioActual();
        Partida partida = gu.obtenerPartidaUsuario(usuario);
        gpar.anadirPremios(partida, premios);
    }

    private void comprobarProgresoPremiosFinalPartida() {
        ArrayList<Premio> premios = obtenerPremiosProgresadosFinalPartida();
        premios.forEach(premio -> progresarPremio(premio));
    }

    private ArrayList<String> obtenerPremiosCompletados(String usu, ArrayList<Premio> listaPremios) {
        // TODO
        return null;
    }

    private ArrayList<Premio> obtenerPremiosProgresadosFinalPartida() {
        GestorUsuario gu = null; // TODO
        GestorPartida gpar = null; // TODO

        Usuario usuario = gu.obtenerUsuarioActual();
        Partida partida = gu.obtenerPartidaUsuario(usuario);
        obtenerPremioDificultad(partida, usuario);
        obtenerPremioPuntos(partida);
        comprobarProgresoPremios();
        return gpar.obtenerPremios(partida);
    }

    private Premio obtenerPremioDificultad(Partida partida, Usuario usuario) {
        GestorPartida gpar = null; // TODO
        GestorDificultad gdif = null; // TODO

        Integer puntos = gpar.obtenerPuntos(partida);
        Dificultad dificultad = gdif.buscarDificultad(usuario);

        Premio p = new Premio("%dependiendo de la dificultad", puntos, null); // TODO
        return p;
    }

    private Premio obtenerPremioPuntos(Partida partida) {
        GestorPartida gpar = null; // TODO

        Integer puntos = gpar.obtenerPuntos(partida);

        Premio p = new Premio("puntos totales obtenidos", puntos, null); // TODO
        return p;
    }

    private void progresarPremio(Premio premio) {
        GestorUsuario gu = null; // TODO

        Usuario usuario = gu.obtenerUsuarioActual();
        String nusuario = gu.getNombreUsuario(usuario);
        String npremio = premio.getNombre();
        Integer progreso = premio.getProgreso();
        execSQL(String.format(""
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
        execSQL(String.format(""
                + "UPDATE PremioObtenido "
                + "SET progreso=progreso+%s "
                + "WHERE nombrepremio='%s' "
                    + "AND nombreusuario='%s'",
                progreso,
                npremio,
                nusuario
            ));
        // TODO
    }
}

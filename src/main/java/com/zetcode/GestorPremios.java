package com.zetcode;

import java.util.ArrayList;

public class GestorPremios {
    private ArrayList<Premio> obtenerPremios(String nombreUsuario) {
        resultado = esecSQL("""
            SELECT nombrepremio, progreso, progresoMax
            FROM Premio JOIN PremioObtenido
                ON PremioObtenido.nombrepremio=Premio.Nombre
            WHERE PremioObtenido.nombreusuario=%nombreUsuario%
            """);
        resultado.next()
        nombre = resultado.getSring("nombre")
        progreso = resultado.getInt("progreso")
        progresoMax = resultado.getInt("progresoMax")
        new Premio(nombre, progreso, progresoMax)
        resultado = execSQL("""
            SELECT nombrepremio, progresoMax
            FROM Premio""")
        resultado.next()
        nombre = resultado.getString("nombre")
        progresoMax = resultado.getInt("progresoMax")
        new Premio(nombre, 0, progresoMax)
        // TODO
        return null;
    }

    private String obtenerDescripcionPremio(String nombrePremio) {
        resultado = execSQL("""
            SELECT descripcion, progreso, progresoMax
            FROM Premio JOIN PremioObtenido
                ON PremioObtenido.nombrepremio=Premio.Nombre
            WHERE PremioObtenido.nombrepremio=%nombrePRemio%
            """)
        
        descripcion = resultado.getString("descripcion")
        progreso = resultado.getInt("progreso")
        progresoMax = resultado.getInt("progresoMax")
        // TODO
        return "";
    }

    private void comprobarProgresoPremios() {
        premios = obtenerPremiosProgresados()
        guardarProgresoPremios(premios)
        // TODO
    }

    private ArrayList<Premio> obtenerPremiosProgresados() {
        obtenerPremioColocarFichas()
        obtenerPremioEliminarFilas()
        obtenerPremioHacerTetris()
        // TODO
        return null;
    }

    private Premio obtenerPremioColocarFichas() {
        usuario = obtenerUsuarioActual()
        partida = obtenerPartidaUsuario(usuario)
        fichas = fichasColocadas(partida)
        if fichas > 0 {
            new Premio("fichas colocadas", fichas, null)
        }
        // TODO
        return null;
    }

    private Premio obtenerPremioEliminarFilas() {
        usuario = obtenerUsuarioActual()
        partida = obtenerPartidaUsuario(usuario)
        filas = filasEliminadas(partida)
        if filas > 0 {
            new Premio("filas eliminadas", filas, null)
        }
        // TODO
        return null;
    }

    private Premio obtenerPremioHacerTetris(String st1) {
        usuario = obtenerUsuarioActual()
        partida = obtenerPartidaUsuario(usuario)
        tetrises = tetrisHechos(partida)
        if tetrises > 0 {
            new Premio("tetris hechos", tetrises, null)
        }
        // TODO
        return null;
    }

    private void guardarProgresoPremios(ArrayList<Premio> ar1) {
        usuario = obtenerUsuarioActual()
        partida = obtenerPartidaUsuario(usuario)
        añadirPremios(partida, premios)
        // TODO
    }

    private void comprobarProgresoPremiosFinalPartida() {
        premios = obtenerPremiosProgresadosFinalPartida()
        progresarPremio(premios[i])
        // TODO
    }

    private ArrayList<String> obtenerPremiosCompletados(String usu, ArrayList<Premio> listaPremios) {
        // TODO
        return null;
    }

    private ArrayList<Premio> obtenerPremiosProgresadosFinalPartida() {
        usuario = obtenerUsuarioActual()
        partida = obtenerPartidaUsuario(usuario)
        obtenerPremioDificultad(partida, usuario)
        obtenerPremioPuntos(partida)
        comprobarProgresoPremios()
        obtenerPremios(partida)
        // TODO
        return null;
    }

    private Premio obtenerPremioDificultad(Partida p1, Usuario u1) {
        puntos = obtenerPuntos(partida)
        dificultad = buscarDificultad(usuario)
        new Premio("%dependiendo de la dificultad", puntos, null)
        // TODO
        return null;
    }

    private Premio obtenerPremioPuntos(Partida p1) {
        puntos = obtenerPuntos(partida)
        new Premio("puntos totales obtenidos", puntos, null)
        // TODO
        return null;
    }

    private void progresarPremio(Premio p1) {
        usuario = obtenerUsuarioActual()
        nusuario = getNombreUsuario(usuario)
        npremio = getNombre()
        progreso = getProgreso()
        execSQL("""
            INSERT INTO PremioObtenido(nombrepremio, nombreusuario, progreso
            VALUES (%npremio%, %nusuario%, 0)
            WHERE %npremio% NOT IN
                (SELECT nombrepremio
                FROM PremioObtenido
                WHERE nombreusuario=%nusuario%)
                """)
        execSQL("""
                UPDATE PremioObtenido
                SET progreso=progreso+%progreso%
                WHERE nombrepremio=%npremio%
                    AND nombreusuario=%nusuario%
                """;)
        // TODO
    }
}

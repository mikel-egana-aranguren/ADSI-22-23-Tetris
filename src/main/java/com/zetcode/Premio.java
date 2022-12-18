package com.zetcode;

public class Premio {
    private String nombre;
    private int progreso;
    private Integer progresoMax;

    public Premio(String pNombre, int pProgreso, Integer pProgresoMax) {
        nombre = pNombre;
        progreso = pProgreso;
        progresoMax = pProgresoMax;
    }

    public String getNombre() {
        return nombre;
    }

    public int getProgreso() {
        return progreso;
    }

    public int getProgresoMax() {
        return progresoMax;
    }
}

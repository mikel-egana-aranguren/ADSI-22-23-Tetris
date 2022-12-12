package com.zetcode;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class Gestor {
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

    public boolean comprobarDatosRegistro(String pEmail, String pwd1, String pwd2) {
    	if (pwd1.equals(pwd2)== true) {
			Pattern emailPat = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+"[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
	    	Matcher matcher = emailPat.matcher(pEmail);
			if (matcher.find()==true) {
	    		final JOptionPane option = new JOptionPane();
	    		option.showMessageDialog(null, "Te has registrado correctamente", "ÉXITO", JOptionPane.INFORMATION_MESSAGE);
				return true;
			} else {
				final JOptionPane option = new JOptionPane();
				option.showMessageDialog(null, "El email introducido no es válido", "ERROR",JOptionPane.ERROR_MESSAGE);
				return false;
			}
		} else {
			final JOptionPane option = new JOptionPane();
			option.showMessageDialog(null, "Las contraseñas no son iguales", "ERROR",JOptionPane.ERROR_MESSAGE);
			return false;
		} 
    }
    
    public boolean comprobarDatosCambiarContraseña(String usuario, String pwd1, String pwd2) {
    	if (pwd1.equals(pwd2)== true) {
    		final JOptionPane option = new JOptionPane();
    		option.showMessageDialog(null, "Te has registrado correctamente", "ÉXITO", JOptionPane.INFORMATION_MESSAGE);
			return true;
		} else {
			final JOptionPane option = new JOptionPane();
			option.showMessageDialog(null, "Las contraseñas no son iguales", "ERROR",JOptionPane.ERROR_MESSAGE);
			return false;
		} 
    }

    private void registrarse(String usu, String email, String pwd1) {
        
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
}

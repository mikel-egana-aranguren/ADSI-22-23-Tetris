package com.zetcode;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import org.h2.engine.Session;

//import javax.mail.*;

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

    public boolean comprobarDatosRegistro(String usuario, String pEmail, String pwd1, String pwd2) {
    	JOptionPane option = new JOptionPane();
    	if (usuario.length()!=0 || pEmail.length()!=0 || pwd1.length()!=0 || pwd2.length()!=0) {
    		if (usuario.length()>2) {
        		if (pwd1.length()>3 && pwd2.length()>3) {
        			if (pwd1.equals(pwd2)== true) {
        				Pattern emailPat = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+"[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        				Matcher matcher = emailPat.matcher(pEmail);
        				if (matcher.find()==true) {
        					GestorUsuario GU = new GestorUsuario();
        					if (GU.existeUsuario(usuario) == false && GU.existeEmail(pEmail) == false) {
        						option.showMessageDialog(null, "Te has registrado correctamente", "ÉXITO", JOptionPane.INFORMATION_MESSAGE);
        						return true;
        					} else {
        						option.showMessageDialog(null, "El usuario introducido ya existe", "ERROR",JOptionPane.ERROR_MESSAGE);
        						return false;
        					}
        				} else {
        					option.showMessageDialog(null, "El email introducido no es válido", "ERROR",JOptionPane.ERROR_MESSAGE);
        					return false;
        				}
        			} else {
        				option.showMessageDialog(null, "Las contraseñas no son iguales", "ERROR",JOptionPane.ERROR_MESSAGE);
        				return false;
        			} 
    			} else {
    				option.showMessageDialog(null, "La contraseña introducida debe contener al menos 4 caracteres", "ERROR",JOptionPane.ERROR_MESSAGE);
    				return false;
    			}
    		} else {
    			option.showMessageDialog(null, "El nombre de usuario debe contener al menos 3 caracteres", "ERROR",JOptionPane.ERROR_MESSAGE);
    			return false;
    		}
		} else {
			option.showMessageDialog(null, "Por favor, rellene todos los campos", "ERROR",JOptionPane.ERROR_MESSAGE);
			return false;
		}
    }
    
    public boolean comprobarDatosCambiarContraseña(String usuario, String pwdOld, String pwd1, String pwd2) {
    	JOptionPane option = new JOptionPane();
    	GestorUsuario GU = new GestorUsuario();
    	if (usuario !="admin") {
    		if (usuario.length()!=0 || pwdOld.length()!=0 || pwd1.length()!=0 || pwd2.length()!=0) {
        		if (GU.existeUsuario(usuario)) {
            		if (!pwdOld.equals(pwd1) && !pwdOld.equals(pwd2)) {
                		if (pwd1.length()>3 && pwd2.length()>3) {
                    		if (pwd1.equals(pwd2)== true) {
                        		option.showMessageDialog(null, "La contraseña se ha cambiado correctamente", "ÉXITO", JOptionPane.INFORMATION_MESSAGE);
                    			return true;
                    		} else {
                    			option.showMessageDialog(null, "Las contraseñas no son iguales", "ERROR",JOptionPane.ERROR_MESSAGE);
                    			return false;
                    		} 
                		} else {
                			option.showMessageDialog(null, "La contraseña introducida debe contener al menos 4 caracteres", "ERROR",JOptionPane.ERROR_MESSAGE);
                			return false;
                		}
            		} else {
            			option.showMessageDialog(null, "La nueva contraseña debe ser diferente a la anterior", "ERROR",JOptionPane.ERROR_MESSAGE);
            			return false;
            		}
        		} else {
        			option.showMessageDialog(null, "El usuario introducido no existe", "ERROR",JOptionPane.ERROR_MESSAGE);
        			return false;
        		}
    		} else {
    			option.showMessageDialog(null, "Por favor, rellene todos los campos", "ERROR",JOptionPane.ERROR_MESSAGE);
    			return false;
    		}
		} else {
			option.showMessageDialog(null, "No seas pillo, la del admin no se puede cambiar bobi", "ERROR",JOptionPane.ERROR_MESSAGE);
			return false;
		}
    }

    public void registrarse(String usu, String email, String pwd1, String pwd2) {
    	GestorUsuario GU = new GestorUsuario();
    	if (comprobarDatosRegistro(usu, email, pwd1, pwd2)) {
    		GU.registrarse(usu, email, pwd1);
		}
    }

    public boolean identificarse(String usu, String pwd) {
    	JOptionPane option = new JOptionPane();
    	GestorUsuario GU = new GestorUsuario();
        if (usu.length()!=0 || pwd.length()!=0) {
        	if (GU.existeUsuario(usu, pwd)) {
            	return true;
            } else {
    			option.showMessageDialog(null, "Las credenciales introducidas no son correctas \nVuelve a intentarlo", "ERROR",JOptionPane.ERROR_MESSAGE);
    			return false;
    		}
		} else {
			option.showMessageDialog(null, "Por favor, rellene todos los campos", "ERROR",JOptionPane.ERROR_MESSAGE);
			return false;
		}
    }

    private boolean recuperar(String textoIntroducido) {
    	//Session session = new
        return false;
    }

    public void cambiar(String usu, String pwdOld, String pwd1, String pwd2) {
        GestorUsuario GU = new GestorUsuario();
        if (comprobarDatosCambiarContraseña(usu, pwdOld, pwd1, pwd2)) {
			GU.cambiarContraseña(usu, pwd1);
		}
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

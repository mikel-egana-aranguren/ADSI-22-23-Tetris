package com.zetcode;

import java.sql.ResultSet;

public class GestorUsuario {
    private Usuario usuarioActual;
    private static GestorUsuario miGestor;
    
    // VARIABLES PARA EVITAR SQL INJECTION
    private String SELECT = " SELECT ";
    private String FROM = " FROM ";
    private String WHERE = " WHERE ";
    private String INSERT = " INSERT ";
    private String INTO = " INTO ";
    private String VALUES = " VALUES ";
    private String AND = " AND ";
    private String UPDATE = " UPDATE ";
    private String SET = " SET ";
    private String DELETE = " DELETE ";
    
    public static GestorUsuario getGestor() {
        if (miGestor == null) {
            miGestor = new GestorUsuario();
        }

        return miGestor;
    }

    public Usuario obtenerUsuarioActual() {
        // TODO
        return null;
    }

    public String getNombreUsuario(Usuario a1) {
        //TODO
        return "";
    }

    public Partida obtenerPartidaUsuario(Usuario a1) {
        // TODO
        return null;
    }
    
    public void registrarse(String usu, String email, String pwd1) {
		String consulta =  String.format(INSERT + INTO + "USUARIO " + VALUES + "('%s', '%s', '%s')", usu,pwd1,email);
		SGBD.execVoidSQL(consulta);
    }
    
    public boolean existeUsuario(String usu, String pwd) {
    	String existe = String.format(SELECT + "*" + FROM + "USUARIO" + WHERE + "nombreUsuario = '%s'" + AND + "contrasena = '%s'", usu,pwd);
	    ResultSet result = SGBD.execResultSQL(existe);
	    try {
	    	if (result.next()) {
	    		return true;
	    	} else {
				return false;
			}
    	} catch (Exception e) {
			System.exit(1);
			return false;
		}
    }
    
    public boolean existeUsuario(String usu) {
    	String existe = String.format(SELECT + "*" + FROM + "USUARIO" + WHERE + "nombreUsuario = '%s'", usu);
	    ResultSet result = SGBD.execResultSQL(existe);
	    try {
	    	if (result.next()) {
	    		return true;
	    	} else {
				return false;
			}
    	} catch (Exception e) {
			System.exit(1);
			return false;
		}
    }
    
    public boolean existeEmail(String email) {
    	String existe = String.format(SELECT + "email" + FROM + "USUARIO" + WHERE + "email = '%s'", email);
	    ResultSet result = SGBD.execResultSQL(existe);
	    try {
	    	if (result.next()) {
	    		return true;
	    	} else {
				return false;
			}
    	} catch (Exception e) {
			System.exit(1);
			return false;
		}
    }
    
    public String getContrasena(String usuario) {
    	String existe = String.format(SELECT + "contrasena" + FROM + "USUARIO" + WHERE + "nombreUsuario = '%s'", usuario);
	    ResultSet result = SGBD.execResultSQL(existe);
	    try {
	    	if (result.next()) {
	    		System.out.println(result.getString("contrasena"));
	    		return result.getString("contrasena");
	    	} else {
				return null;
			}
    	} catch (Exception e) {
			System.exit(1);
			return null;
		}
    }
    
    public void cambiarContrasena(String usu, String pwd1) {
    	String consulta =  String.format(UPDATE + "USUARIO" + SET + "contrasena = '%s'" + WHERE + "nombreUsuario = '%s'", pwd1,usu);
		SGBD.execVoidSQL(consulta);
    }
    
    public void eliminarUsuario(String usu) {
    	String consulta = String.format(DELETE + FROM + "USUARIO" + WHERE + "nombreUsuario = '%s'", usu);
    	SGBD.execVoidSQL(consulta);
    }

    public String[] obtenerDatos(String correo) {
      String consulta = String.format(SELECT + "nombreUsuario, contrasena, email" + FROM + "USUARIO" + WHERE + "email = '%s'", correo);
      ResultSet resultado = SGBD.execResultSQL(consulta);
      String[] usu = null;

      if (resultado!=null) {
        usu = new String[3];
        try {
          while (resultado.next()) {
            usu[0] = resultado.getString("nombreUsuario");
            usu[1] = resultado.getString("contrasena");
            usu[2] = resultado.getString("email");
          }
        } catch (Exception e) {
          // TODO: handle exception
          e.printStackTrace();
        }
      }
      return usu;
    }
}
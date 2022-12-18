package com.zetcode;

public class GestorUsuario {
    private Usuario usuarioActual;
    private static GestorUsuario miGestorUsuario;
    
    private GestorUsuario() {
        
    }
    
    public static GestorUsuario getGestorUsuario() {
        if (miGestorUsuario == null) {
            miGestorUsuario = new GestorUsuario();
        }

        return miGestorUsuario;
    }
    
    public String getNombreUsuario(Usuario pUsuario) {
        return pUsuario.getNombre();
    }
    
    public Partida obtenerPartidaUsuario(Usuario pUsuario) {
        return pUsuario.obtenerPartida();
    }
    
    public void setPartidaUsuario(Usuario pUsuario, Partida pPartida) {
        pUsuario.setPartida(pPartida);
    }

    public Usuario obtenerUsuarioActual() {
        return usuarioActual;
    }

    public void setUsuario(Usuario usu) {
      // TODO: Esto lo he puesto para un test
      usuarioActual = usu;
    }
    
    public String getNombreUsuario() {
        
        return usuarioActual.getNombre();
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
    
    public void cambiarContraseña(String usu, String pwd1) {
    	String consulta =  String.format(UPDATE + "USUARIO" + SET + "contrasena = '%s'" + WHERE + "nombreUsuario = '%s'", pwd1,usu);
		SGBD.execVoidSQL(consulta);
    }
    
    public void eliminarUsuario(String usu) {
    	String consulta = String.format(DELETE + FROM + "USUARIO" + WHERE + "nombreUsuario = '%s'", usu);
    	SGBD.execVoidSQL(consulta);
    }

    public String[] obtenerDatos(String correo) {
      String consulta = String.format(SELECT + "email, nombreUsuario, contrasena" + FROM + "USUARIO" + WHERE + "email = '%s'", correo);
      ResultSet resultado = SGBD.execResultSQL(consulta);
      String[] usu = null;

      if (resultado!=null) {
        usu = new String[3];
        try {
          while (resultado.next()) {
            usu[0] = resultado.getString("email");
            usu[1] = resultado.getString("nombreUsuario");
            usu[2] = resultado.getString("contrasena");
          }
        } catch (Exception e) {
          // TODO: handle exception
          e.printStackTrace();
        }
      }
      return usu;
    }
}

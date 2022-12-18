package eus.ehu.lsi.adsi;

import static org.junit.Assert.*;

import org.junit.Test;

import com.zetcode.Gestor;

public class IdentificacionTest {
	
	/**
	 * SI TODAS LAS PRUEBAS SE EJECUTAN SEGUIDAS, ES PROBABLE QUE MAS DE UNA DE ERROR, POR QUE LA UNA PERJUDICA A LA OTRA
	 * ASI QUE MIRAR BIEN QUE HACE CADA UNA Y SI NO INTERFIERE EN LA OTRA ;)
	 */
	
	Gestor gestor = new Gestor();
	@Test
	public void test1UsuarioUsuarioNo_IS() {
		boolean resultado = gestor.identificarse("usuInexistente", "pwdInexistente");
		assertEquals(false, resultado);
	}
	@Test
	public void test2UsuarioSiContrasenaNo_IS() {
		boolean resultado = gestor.identificarse("tetrixadmin", "pwdIncorrecta");
		assertEquals(false, resultado);
	}
	@Test
	public void test3Exito_IS() {
		boolean resultado = gestor.identificarse("tetrixadmin", "tetrixsa22");
		assertEquals(true, resultado);
	}
	@Test
	public void test4EmailFormatoIncorrecto_R() {
		boolean resultado = gestor.comprobarDatosRegistro("usuario", "emailSinFormato", "contrasena", "contrasena");
		assertEquals(false, resultado);
	}
	@Test
	public void test5EmailExistente_R() {
		boolean resultado = gestor.comprobarDatosRegistro("usuario", "adsitetrix@gmail.com", "contrasena", "contrasena");
		assertEquals(false, resultado);
	}
	@Test
	public void test6UsuarioExistente_R() {
		boolean resultado = gestor.comprobarDatosRegistro("tetrixadmin", "ejemplo@gmail.com", "contrasena", "contrasena");
		assertEquals(false, resultado);
	}
	@Test
	public void test6ContrasenasDiferentes_R() {
		boolean resultado = gestor.comprobarDatosRegistro("usuario", "ejemplo@gmail.com", "contrasena", "diferente");
		assertEquals(false, resultado);
	}
	@Test
	public void test7EmailVacio_R() {
		boolean resultado = gestor.comprobarDatosRegistro("usuario", "", "contrasena", "contrasena");
		assertEquals(false, resultado);
	}
	@Test
	public void test8UsuarioVacio_R() {
		boolean resultado = gestor.comprobarDatosRegistro("", "ejemplo@gmail.com", "contrasena", "contrasena");
		assertEquals(false, resultado);
	}
	@Test
	public void test9ContrasenasVacias_R() {
		boolean resultado = gestor.comprobarDatosRegistro("usuario", "ejemplo@gmail.com", "", "");
		assertEquals(false, resultado);
	}
	@Test
	public void test10Exito_R() {
		boolean resultado = gestor.comprobarDatosRegistro("usuario", "ejemplo@gmail.com", "contrasena", "contrasena");
		assertEquals(true, resultado);
	}
	@Test
	public void test11EmailFormatoIncorrecto_RC() {
		int resultado = gestor.enviarEmail("adsitetrix@gmail.com");
		assertEquals(1, resultado);
	}
	/** 
	 * PRUEBAS REALIZADAS CON OTRO NOMBRE QUE NO ES EL DEL ADMINISTRADOR (EN LA BASE
	 * DE DATOS POR DEFECTO SOLO EXISTE ESE USUARIO, CREADO EL USUARIO "unai" 
	 * EXCLUSIVAMENTE PARA LAS PRUEBAS)
	 * **/
	@Test
	public void test12UsuarioNoExiste_CC() {
		int resultado = gestor.cambiar("unai", "contrasenaAntigua", "contrasenaNueva", "contrasenaNueva");
		assertEquals(0, resultado);
	}
	@Test
	public void test13ContrasenaIncorrecta_CC() {
		int resultado = gestor.cambiar("unai", "incorrecta", "contrasenaNueva", "contrasenaNueva");
		assertEquals(0, resultado);
	}
	@Test
	public void test14ContrasenaIncorrecta_CC() {
		int resultado = gestor.cambiar("unai", "1234", "contrasenaNueva", "contrasenaNuevaDiferente");
		assertEquals(0, resultado);
	}
	@Test
	public void test15Exito_CC() {
		int resultado = gestor.cambiar("unai", "1234", "contrasenaNueva", "contrasenaNueva");
		assertEquals(1, resultado);
	}
	@Test
	public void test16Exito_EU() {
		int resultado = gestor.eliminarUsuario("unai");
		assertEquals(1, resultado);
	}
	@Test
	public void test16Error_EU() {
		int resultado = gestor.eliminarUsuario("usuarioInexistente");
		assertEquals(0, resultado);
	}
}

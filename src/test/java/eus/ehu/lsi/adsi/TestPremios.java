package eus.ehu.lsi.adsi;

import org.junit.Test;

import com.zetcode.Gestor;
import com.zetcode.GestorPartida;
import com.zetcode.GestorUsuario;
import com.zetcode.Partida;
import com.zetcode.Premio;
import com.zetcode.PremioDescripcion;
import com.zetcode.SGBD;
import com.zetcode.Tetris;
import com.zetcode.Usuario;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.After;
import org.junit.Before;

public class TestPremios {

    @Before  
    public void setUp() {
        SGBD.inicializarTest();
        SGBD.execVoidSQL("INSERT INTO USUARIO(nombreUsuario,contrasena,email) VALUES ('usuariotest','contr','test@gmail.com')");
        GestorUsuario gu = GestorUsuario.getGestorUsuario();

        Usuario usu = new Usuario("usuariotest");
        Partida par = new Partida();
        usu.setPartida(par);
        gu.setUsuario(usu);
    }

    @After  
    public void tearDown() {
        SGBD.execVoidSQL("DELETE FROM PREMIOOBTENIDO WHERE nombreUsuario='usuariotest'");
        SGBD.execVoidSQL("DELETE FROM USUARIO WHERE nombreUsuario='usuariotest'");
    }   

    /**
     * <h2>Test 6.0</h2>
     * 
     * <h4>Descripción</h4> <p>Se completa el desafío asociado a un premio</p>
     * 
     * <h4>Reslutado esperado</h4> <p>Al mirar los premios aparece como obtenido</p>
     */
    @Test
	public void CompletarDesafio() {
        GestorUsuario gu = GestorUsuario.getGestorUsuario();
        Partida par = gu.obtenerPartidaUsuario(gu.obtenerUsuarioActual());
        GestorPartida.addFilas(par, 50);
        Gestor.comprobarProgresoPremiosFinalPartida();

        ArrayList<Premio> premios = par.obtenerPremios();
        assertEquals(premios.size(), 2);

        JSONObject premio = Gestor.obtenerDescripcionPremio("Eliminador de Filas");
        assertTrue(premio.getInt("progreso") >= premio.getInt("progresoMax"));
        premio = Gestor.obtenerDescripcionPremio("Puntuador Extremo");
        assertEquals(premio.getInt("progreso"), 0);
	}

    /**
     * <h2>Test 6.1</h2>
     * 
     * <h4>Descripción</h4> <p>Se termina la partida sin haber completado ningún desafío</p>
     * 
     * <h4>Reslutado esperado</h4> <p>Se abre el menú de fin de partida sin mostrar ningún premio</p>
     */
    @Test
	public void SinCompletarDesafio() {
        GestorUsuario gu = GestorUsuario.getGestorUsuario();
        Partida par = gu.obtenerPartidaUsuario(gu.obtenerUsuarioActual());
        Gestor.comprobarProgresoPremiosFinalPartida();

        ArrayList<Premio> premios = par.obtenerPremios();
        assertEquals(premios.size(), 1); // Siempre se avanza en el premio por puntos, aunque se avance 0
        assertEquals(premios.get(0).getNombre(), "Puntuador Extremo");

        JSONObject premio = Gestor.obtenerDescripcionPremio("Puntuador Extremo");
        assertEquals(premio.getInt("progreso"), 0);
	}

    /**
     * <h2>Test 6.2</h2>
     * 
     * <h4>Descripción</h4> <p>Se termina la partida habiendo completado algún desafío</p>
     * 
     * <h4>Reslutado esperado</h4> <p>Se muestran todos los logros obtenidos en esa partida</p>
     */
    @Test
	public void AlgunDesafio() {
        GestorUsuario gu = GestorUsuario.getGestorUsuario();
        Partida par = gu.obtenerPartidaUsuario(gu.obtenerUsuarioActual());
        GestorPartida.addFilas(par, 50);
        GestorPartida.addTetrises(par, 15);
        GestorPartida.addPuntos(par, 1000000);
        for (int i = 0; i < 287; i++) { // 287 no son suficientes para obtener el premio
            GestorPartida.contarFicha(par);
        }
        Gestor.comprobarProgresoPremiosFinalPartida();

        ArrayList<Premio> premios = par.obtenerPremios();
        premios.forEach(premio -> System.out.println(premio.getNombre()));
        assertEquals(premios.size(), 5); // además de los 4, tambien se obtiene el logro de dificultad

        JSONObject premio = Gestor.obtenerDescripcionPremio("Eliminador de Filas");
        assertTrue(premio.getInt("progreso") >= premio.getInt("progresoMax"));
        premio = Gestor.obtenerDescripcionPremio("Maestro del TETRIS");
        assertTrue(premio.getInt("progreso") >= premio.getInt("progresoMax"));
        premio = Gestor.obtenerDescripcionPremio("Puntuador Extremo");
        assertTrue(premio.getInt("progreso") >= premio.getInt("progresoMax"));
        premio = Gestor.obtenerDescripcionPremio("Aprendiz");
        assertTrue(premio.getInt("progreso") >= premio.getInt("progresoMax"));
        premio = Gestor.obtenerDescripcionPremio("Colocador de Fichas");
        assertFalse(premio.getInt("progreso") >= premio.getInt("progresoMax"));
	}

    /**
     * <h2>Test 6.3</h2>
     * 
     * <h4>Descripción</h4> <p>Se termina la partida habiendo completado solo desafíos que se completan al finalizar.</p>
     * 
     * <h4>Reslutado esperado</h4> <p>Se muestran todos los logros obtenidos en esa partida</p>
     */
    @Test
	public void SoloAlFinalizar() {
        GestorUsuario gu = GestorUsuario.getGestorUsuario();
        Partida par = gu.obtenerPartidaUsuario(gu.obtenerUsuarioActual());
        GestorPartida.addPuntos(par, 1000000);
        Gestor.comprobarProgresoPremiosFinalPartida();

        ArrayList<Premio> premios = par.obtenerPremios();
        assertEquals(premios.size(), 2);

        JSONObject premio = Gestor.obtenerDescripcionPremio("Puntuador Extremo");
        assertTrue(premio.getInt("progreso") >= premio.getInt("progresoMax"));
        premio = Gestor.obtenerDescripcionPremio("Aprendiz");
        assertTrue(premio.getInt("progreso") >= premio.getInt("progresoMax"));
	}

    /**
     * <h2>Test 6.4</h2>
     * 
     * <h4>Descripción</h4> <p>Se termina la partida habiendo completado solo desafíos que se completan durante la partida.</p>
     * 
     * <h4>Reslutado esperado</h4> <p>Se muestran todos los logros obtenidos en esa partida</p>
     */
    @Test
	public void SoloDurante() {
        GestorUsuario gu = GestorUsuario.getGestorUsuario();
        Partida par = gu.obtenerPartidaUsuario(gu.obtenerUsuarioActual());
        GestorPartida.addFilas(par, 50);
        Gestor.comprobarProgresoPremiosFinalPartida();

        ArrayList<Premio> premios = par.obtenerPremios();
        assertEquals(premios.size(), 2);

        JSONObject premio = Gestor.obtenerDescripcionPremio("Eliminador de Filas");
        assertTrue(premio.getInt("progreso") >= premio.getInt("progresoMax"));
        premio = Gestor.obtenerDescripcionPremio("Puntuador Extremo");
        assertEquals(premio.getInt("progreso"), 0);
	}

    /**
     * <h2>Test 6.5</h2>
     * 
     * <h4>Descripción</h4> <p>Se avanza el desafío asociado a un premio</p>
     * 
     * <h4>Reslutado esperado</h4> <p>Al mirar los premios aparece cuánto falta para completarlo.</p>
     */
    @Test
	public void AvanceDesafio() {
        GestorUsuario gu = GestorUsuario.getGestorUsuario();
        Partida par = gu.obtenerPartidaUsuario(gu.obtenerUsuarioActual());
        GestorPartida.addFilas(par, 37);
        Gestor.comprobarProgresoPremiosFinalPartida();

        ArrayList<Premio> premios = par.obtenerPremios();
        assertEquals(premios.size(), 2); // Siempre se añade 1 premio (de puntos) aunque solo se obtengan 0 puntos

        JSONObject premio = Gestor.obtenerDescripcionPremio("Eliminador de Filas");
        assertFalse(premio.getInt("progreso") >= premio.getInt("progresoMax"));

        premio = Gestor.obtenerDescripcionPremio("Eliminador de Filas");
        assertEquals(premio.getInt("progreso"), 37);

        premio = Gestor.obtenerDescripcionPremio("Puntuador Extremo");
        assertEquals(premio.getInt("progreso"), 0);
	}

    /**
     * <h2>Test 6.6</h2>
     * 
     * <h4>Descripción</h4> <p>Se avanza el desafío de un premio que ya se había completado</p>
     * 
     * <h4>Reslutado esperado</h4> <p>Al mirar premios su progreso no supera su límite superior.</p>
     */
    @Test
	public void AvanceDesafioCompletado() {
        GestorUsuario gu = GestorUsuario.getGestorUsuario();
        Partida par = gu.obtenerPartidaUsuario(gu.obtenerUsuarioActual());
        GestorPartida.addFilas(par, 50);
        Gestor.comprobarProgresoPremiosFinalPartida();
        GestorPartida.addFilas(par, 20);
        Gestor.comprobarProgresoPremiosFinalPartida();

        ArrayList<Premio> premios = par.obtenerPremios();
        assertEquals(premios.size(), 2);

        JSONObject premio = Gestor.obtenerDescripcionPremio("Eliminador de Filas");
        int progreso = premio.getInt("progreso");
        int progresoMax = premio.getInt("progresoMax");
        assertTrue(progreso >= progresoMax);

        int progresoFinal = progreso * 100 / progresoMax;
		if (progresoFinal > 100) {
			progresoFinal = 100;
		}

        assertEquals(progresoFinal, 100);

        premio = Gestor.obtenerDescripcionPremio("Puntuador Extremo");
        assertEquals(premio.getInt("progreso"), 0);
	}

    /**
     * <h2>Test 6.7</h2>
     * 
     * <h4>Descripción</h4> <p>Se entra a mirar los premios en una cuenta que no ha jugado ninguna partida</p>
     * 
     * <h4>Reslutado esperado</h4> <p>Se muestran todos los premios sin ningún progreso</p>
     */
    @Test
	public void SinJugarPartidas() {
        JSONArray premios = Gestor.obtenerPremios();
        assertEquals(premios.length(), 8);
	}
}

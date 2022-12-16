package eus.ehu.lsi.adsi;

import org.junit.Test;

import com.zetcode.Gestor;
import com.zetcode.GestorPartida;
import com.zetcode.GestorUsuario;
import com.zetcode.Partida;
import com.zetcode.PremioDescripcion;
import com.zetcode.SGBD;
import com.zetcode.Tetris;
import com.zetcode.Usuario;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;

public class TestPremios {

    @Before  
    public void setUp() {
        SGBD.inicializarTest();
        SGBD.execVoidSQL("INSERT INTO USUARIO(nombreUsuario,contrasena,email) VALUES ('usuariotest','contr','test@gmail.com')");
        GestorUsuario gu = GestorUsuario.getGestorUsuario();
        Usuario usu = new Usuario("test");
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
        Gestor.comprobarProgresoPremios();
        Gestor.comprobarProgresoPremiosFinalPartida();

        System.out.println("Comprube que el premio \"Eliminador de filas\" se ha completado (y ningun otro)");
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
        System.out.println("No hagas nada, espera a perder la partida");
        System.out.println("Comprueba que el menu de fin de partida no menciona haber obtenido ningún premio");
        System.out.println("Luego ve al menu de premios");
        System.out.println("Comprueba que no hay progreso en ningún premio");

        /* var game = new Tetris();
        game.setVisible(true); */
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
        // Pasos:
        // 1. Empezar una nueva partida
        // 2. Alterar los datos de la partida para asegurarse de que se va a completar un desafío
        // 3. Llenar el tablero de ladrillos para que acabe rápido
        // 4. Imprimir un mensaje para que el tester no haga nada, simplemente pierda
        // 5. Imprimir un mensaje con los logros que se van a obtener
        // 5. Imprimir un mensaje para que el tester compruebe que se han completado los logros dichos anteriormente 

        System.out.println("Para ejecutar este test lanza el programa con el argumento \"test1\"");

        Tetris.main(null);
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
        // Pasos:
        // 1. Empezar una nueva partida
        // 2. Alterar los datos de la partida para asegurarse de que se va a completar un desafío
        // 3. Llenar el tablero de ladrillos para que acabe rápido
        // 4. Imprimir un mensaje para que el tester no haga nada, simplemente pierda
        // 5. Imprimir un mensaje con los logros que se van a obtener
        // 5. Imprimir un mensaje para que el tester compruebe que se han completado los logros dichos anteriormente
        fail("Not yet implemented");
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
        // Pasos:
        // 1. Empezar una nueva partida
        // 2. Alterar los datos de la partida para asegurarse de que se va a completar un desafío
        // 3. Llenar el tablero de ladrillos para que acabe rápido
        // 4. Imprimir un mensaje para que el tester no haga nada, simplemente pierda
        // 5. Imprimir un mensaje con los logros que se van a obtener
        // 5. Imprimir un mensaje para que el tester compruebe que se han completado los logros dichos anteriormente
        fail("Not yet implemented");
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
        // Pasos:
        // 1. execSQL para avanzar (sin completar) un premio premio
        // 2. Abrir la ventana de los premios
        // 3. Imprimir un mensaje para que el tester compruebe que aparece un progreso
        // 4. Borrar el progreso del premio
        fail("Not yet implemented");
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
        // Pasos:
        // 1. execSQL para completar un premio premio
        // 2. execSQL para avanzar un premio premio
        // 3. Abrir la ventana de los premios
        // 4. Imprimir un mensaje para que el tester compruebe que el progreso se meustra correctamente
        // 5. Borrar el progreso del premio
        fail("Not yet implemented");
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
        // Pasos:
        // 1. Abrir la ventana de los premios
        // 2. Imprimir un mensaje para que el tester compruebe que todos los progresos están vacíos
        fail("Not yet implemented");
	}
}
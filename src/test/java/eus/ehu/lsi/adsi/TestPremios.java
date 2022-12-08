package eus.ehu.lsi.adsi;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestPremios {

    /**
     * <h2>Test 6.0</h2>
     * 
     * <h4>Descripción</h4> <p>Se completa el desafío asociado a un premio</p>
     * 
     * <h4>Reslutado esperado</h4> <p>Al mirar los premios aparece como obtenido</p>
     */
    @Test
	public void CompletarDesafio() {
        // Pasos:
        // 1. execSQL para completar el premio
        // 2. Abrir la ventana de los premios
        // 3. Imprimir un mensaje para que el tester compruebe que aparece como obtenido
        // 4. Borrar el progreso del premio
        fail("Not yet implemented");
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
        // Pasos:
        // 1. Empezar una nueva partida
        // 2. Llenar el tablero de ladrillos para que acabe rápido
        // 3. Imprimir un mensaje para que el tester no haga nada, simplemente pierda
        // 4. Imprimir un mensaje para que el tester compruebe que en el mení de fin de partida no se muestre ningún premio obtenido
        fail("Not yet implemented");
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
        fail("Not yet implemented");
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

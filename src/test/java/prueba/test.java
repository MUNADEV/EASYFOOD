/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba;

import Enumeraciones.Estados;
import Interfaces.Disponible;
import Interfaces.Principal;
import org.junit.After;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class test {
       Principal principal;
       Disponible disponible;
       int numeroMesa = 1;

    public test() {
        principal = new Principal();
        disponible = new Disponible(principal, true, principal.getRestaurant());
    }

    @Before
    public void setUp() {     
    
    }

    @Test
    public void testCreacion() {
        /*
        Al iniciar Principal, se inicia y con ello se comprueba el estado exitente de los elementos
        */
        
        assertNotNull(principal.getBotones());
        assertNotNull(principal.getEstados());
        assertNotNull(principal.getMesas());
        assertNotNull(principal.getRestaurant().getClientes());
        assertNotNull(principal.getRestaurant().getMesas());
        assertNotNull(principal.getRestaurant());
        
    }
    
     @Test
    public void testEstadosMesas() {
        /*
       Al iniciar el codigo deben estar disponible los botones, ejemplo con algunos botones al azar
         */
        boolean a = Estados.DISPONIBLE.getEstado().equalsIgnoreCase(principal.getRestaurant().getMesas()[numeroMesa - 1].getEstado());
        boolean b = Estados.DISPONIBLE.getEstado().equalsIgnoreCase(principal.getRestaurant().getMesas()[numeroMesa + 5].getEstado());
        boolean c = Estados.DISPONIBLE.getEstado().equalsIgnoreCase(principal.getRestaurant().getMesas()[numeroMesa + 10].getEstado());
        boolean d = Estados.DISPONIBLE.getEstado().equalsIgnoreCase(principal.getRestaurant().getMesas()[numeroMesa + 14].getEstado());
        boolean e = Estados.DISPONIBLE.getEstado().equalsIgnoreCase(principal.getRestaurant().getMesas()[numeroMesa + 20].getEstado());

        assertTrue(a);
        assertTrue(b);
        assertTrue(c);
        assertTrue(d);
        assertTrue(e);

    }

    @Test
    public void testVerificacion(){
        /*
       En disponible se encuentran dos metodos para la verificacion 
        de codigo de la tabla menu
        */
        
        //Prueba1 retorna  falso
        assertFalse(disponible.verificadorErrorString("prueba"));    // "prueba" no es codigo del menu
        assertFalse(disponible.verificarCodigo(1000));   //"1000" no es codigo del menu
        
        //Prueba2 retorna verdadero
         assertTrue(disponible.verificadorErrorString("500"));//es parte del codigo
         assertTrue(disponible.verificarCodigo(500));
    }

    @After
    public void tearDown() {
    }
}

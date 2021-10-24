package Diagrama;

//Clase principal dentro del paquete
import Diagrama.comidas.Principales;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Restaurant {

    private Mesa mesas[];
    private ArrayList<Cliente> clientes;

    public Restaurant() {
        this.mesas = new Mesa[25];
        this.clientes = new ArrayList<>();
    }

    public void iniciar() {
        /*
        Creacion de mesa, estas mesas corresponden al restaurante
        donde luego, cada mesa tendra su menu
        */
        Mesa mesa1 = new Mesa();
        Mesa mesa2 = new Mesa();
        Mesa mesa3 = new Mesa();
        Mesa mesa4 = new Mesa();
        Mesa mesa5 = new Mesa();
        Mesa mesa6 = new Mesa();
        Mesa mesa7 = new Mesa();
        Mesa mesa8 = new Mesa();
        Mesa mesa9 = new Mesa();
        Mesa mesa10 = new Mesa();
        Mesa mesa11 = new Mesa();
        Mesa mesa12 = new Mesa();
        Mesa mesa13 = new Mesa();
        Mesa mesa14 = new Mesa();
        Mesa mesa15 = new Mesa();
        Mesa mesa16 = new Mesa();
        Mesa mesa17 = new Mesa();
        Mesa mesa18 = new Mesa();
        Mesa mesa19 = new Mesa();
        Mesa mesa20 = new Mesa();
        Mesa mesa21 = new Mesa();
        Mesa mesa22 = new Mesa();
        Mesa mesa23 = new Mesa();
        Mesa mesa24 = new Mesa();
        mesas[0] = mesa1;
        mesas[1] = mesa2;
        mesas[2] = mesa3;
        mesas[3] = mesa4;
        mesas[4] = mesa5;
        mesas[5] = mesa6;
        mesas[6] = mesa7;
        mesas[7] = mesa8;
        mesas[8] = mesa9;
        mesas[9] = mesa10;
        mesas[10] = mesa11;
        mesas[11] = mesa12;
        mesas[12] = mesa13;
        mesas[13] = mesa14;
        mesas[14] = mesa15;
        mesas[15] = mesa16;
        mesas[16] = mesa17;
        mesas[17] = mesa18;
        mesas[18] = mesa19;
        mesas[19] = mesa20;
        mesas[20] = mesa21;
        mesas[21] = mesa22;
        mesas[22] = mesa23;
        mesas[23] = mesa24;

        
          /*Crea las clases correspondiente al manejo de comida
        asi creando el menu en la mesa, donde luego lo pone en cada mesa
        */
        Menu menu = new Menu();
        Comidas comida = new Comidas();

     
        comida.crearComestible();
        menu.setComidas(comida);
        menu.crearComestible();
        //settear menu
        mesa1.setMenu(menu);
        mesa2.setMenu(menu);
        mesa3.setMenu(menu);
        mesa4.setMenu(menu);
        mesa5.setMenu(menu);
        mesa6.setMenu(menu);
        mesa7.setMenu(menu);
        mesa8.setMenu(menu);
        mesa9.setMenu(menu);
        mesa10.setMenu(menu);
        mesa11.setMenu(menu);
        mesa12.setMenu(menu);
        mesa13.setMenu(menu);
        mesa14.setMenu(menu);
        mesa15.setMenu(menu);
        mesa16.setMenu(menu);
        mesa17.setMenu(menu);
        mesa18.setMenu(menu);
        mesa19.setMenu(menu);
        mesa20.setMenu(menu);
        mesa21.setMenu(menu);
        mesa22.setMenu(menu);
        mesa23.setMenu(menu);
        mesa24.setMenu(menu);
    }

    //getters and setters
    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public Mesa[] getMesas() {
        return mesas;
    }
    
}

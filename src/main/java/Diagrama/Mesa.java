package Diagrama;

import Enumeraciones.*;

public class Mesa {

    private int numeroMesa;
    private String estado;
    private Cliente cliente;
    private Menu menu;

    public Mesa() {
        this.estado = Estados.DISPONIBLE.getEstado();
    }

    public void agregarCliente(Cliente cliente) {//Agrega cliente a la mesa
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        String cadena = "\n";
        cadena += "\nNumero mesa: " + (numeroMesa + 1);
        cadena += "\nEstado: " + estado;
        cadena += "\nCliente: " + cliente;
        return cadena;
    }
    
    //getters and setters
    public int getNumeroMesa() {
        return numeroMesa;
    }

    public void setNumeroMesa(int numeroMesa) {
        this.numeroMesa = numeroMesa;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

}

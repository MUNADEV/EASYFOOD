package Diagrama;

import java.time.LocalDateTime;
import Diagrama.comidas.*;
//se crea dentor de cliente

public class Boleta {

    private Cliente cliente;
    private int numeroBoleta;
    private int numeroMesa;
    private int precio;
    private String nombreCliente;
    private String comidas;
    private LocalDateTime fecha;

    public Boleta(Cliente cliente) {
        this.cliente = cliente;
    }

    public Boleta() {
    }

    public String listaComidas() { //utilizado para imprimir la informacion para el JDialog lista de comidas
        String cadena = "";
        cadena += "\n===PEDIDOS====";
        for (int i = 0; i < cliente.getPedidos().size(); i++) {
            if (cliente.getPedidos().get(i) != null) { 
                cadena += "\n" + cliente.getPedidos().get(i).toString();

            }
        }
        int pago = 0;
        for (int i = 0; i < cliente.getPedidos().size(); i++) {
            if (cliente.getPedidos().get(i) != null) {

                pago = pago + cliente.getPedidos().get(i).getPrecio();
            }
        }
        cadena += "\n\n\t\tTotal a pagar: $" + pago;
        return cadena;
    }

    public String toString() { //Es utilizado para imprimir la informacin correspondiente a la boleta del cliente
        String cadena = "";
        cadena += "\n" + cliente.getNombre();
        cadena += "\nDireccion: Avda. Santa Lucia";
        cadena += "\nEmail: restaurante@restaurante.cl";
        cadena += "\nFecha Emision: " + LocalDateTime.now().getDayOfMonth() + "/" + LocalDateTime.now().getMonthValue() + "/" + LocalDateTime.now().getYear();

        cadena += "\nMesa: " + (cliente.getNumeroMesa() + 1);

        cadena += "\n===PEDIDOS====";
        for (int i = 0; i < cliente.getPedidos().size(); i++) {
            if (cliente.getPedidos().get(i) != null) {
                cadena += "\n" + cliente.getPedidos().get(i).toString();

            }
        }
        int pago = 0;
        for (int i = 0; i < cliente.getPedidos().size(); i++) {
            if (cliente.getPedidos().get(i) != null) {

                pago = pago + cliente.getPedidos().get(i).getPrecio();
            }
        }

        cadena += "\n\n\t\tTotal a pagar: $" + pago;
        return cadena;
    }

    public String toString2() { //Es utilizado para imprimir la informacion en JDialog EnEspera
        String cadena = "";
        cadena += "\n" + cliente.getNombre();
        cadena += "\nFecha Emision: " + LocalDateTime.now().getDayOfMonth() + "/" + LocalDateTime.now().getMonthValue() + "/" + LocalDateTime.now().getYear();
        cadena += "\nHora pedido: " + LocalDateTime.now().getHour() + ":" + LocalDateTime.now().getMinute();
        cadena += "\nMesa: " + (cliente.getNumeroMesa() + 1);

        cadena += "\n===PEDIDOS====";
        for (int i = 0; i < cliente.getPedidos().size(); i++) {
            if (cliente.getPedidos().get(i) != null) {
                cadena += "\n" + cliente.getPedidos().get(i).toString();

            }
        }
        int pago = 0;
        for (int i = 0; i < cliente.getPedidos().size(); i++) {
            if (cliente.getPedidos().get(i) != null) {

                pago = pago + cliente.getPedidos().get(i).getPrecio();
            }
        }

        cadena += "\n\n\t\tTotal a pagar: $" + pago;
        return cadena;
    }

    //getters and setters
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getNumeroBoleta() {
        return numeroBoleta;
    }

    public void setNumeroBoleta(int numeroBoleta) {
        this.numeroBoleta = numeroBoleta;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public int getNumeroMesa() {
        return numeroMesa;
    }

    public void setNumeroMesa(int numeroMesa) {
        this.numeroMesa = numeroMesa;
    }

    public String getComidas() {
        return comidas;
    }

    public void setComidas(String comidas) {
        this.comidas = comidas;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

}

package Diagrama.comidas;

import Diagrama.*;

public class Bebestible extends Comidas {

    private int codigo;
    private String nombre;
    private int precio;
    private int cantidadCC;

    public Bebestible(String nombre, int cantidadCC, int precio, int codigo) {

        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidadCC = cantidadCC;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidadCC() {
        return cantidadCC;
    }

    @Override
    public int getPrecio() {
        return precio;
    }

    public int getCodigo() {
        return codigo;
    }

    @Override
    public String toString() {
        return nombre + " " + cantidadCC + "cc" + "\tPrecio: $" + precio + "";
    }

}

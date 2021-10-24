package Diagrama.comidas;

import Diagrama.*;

public class Agregado extends Comidas {

    private int codigo;
    private int precio;
    private String nombre;

    public Agregado(String nombre, int precio, int codigo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
    }

    //getters and setters
    @Override
    public String toString() {
        return nombre + "\t Precio: $" + precio + "";
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public int getPrecio() {
        return precio;
    }

    public int getCodigo() {
        return codigo;
    }

}

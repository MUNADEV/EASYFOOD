package Diagrama.comidas;

import Diagrama.*;

public class Postre extends Comidas {

    private int codigo;

    private int precio;
    private String nombre;

    public Postre(String nombre, int precio, int codigo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public int getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return nombre + "\tPrecio: $" + precio + "";
    }

    public int getCodigo() {
        return codigo;
    }

}

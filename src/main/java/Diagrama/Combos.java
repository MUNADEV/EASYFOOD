package Diagrama;

import Diagrama.comidas.*;
import java.util.ArrayList;

public class Combos extends Comidas {

    private String nombre;
    private int precio;
    private int codigo;
    private Ensalada ensaladas;
    private Postre postres;
    private Principales principales;
    private Bebestible bebestibles;
    private Agregado agregados;

    public Combos(String nombre, int precio, int codigo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
    }
    
    @Override
    public String toString() {
        return nombre + "\t\tPrecio: $" + precio + "";
    }

    public String toString2() { //es utilizado para ordenar apropiadamente todos los tipo Comidas
        String cadena = "";
        cadena += "\n[" + nombre + "]";
        if (principales != null) {
            cadena += "-" + principales.getNombre();
        }
        if (ensaladas != null) {
            cadena += "-" + ensaladas.getNombre();
        }
        if (postres != null) {
            cadena += "-" + postres.getNombre();
        }
        if (agregados != null) {
            cadena += "-" + agregados.getNombre();
        }
        if (bebestibles != null) {
            cadena += "-" + bebestibles.getNombre();
        }

        return cadena;
    }
    //getters and setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setEnsaladas(Ensalada ensaladas) {
        this.ensaladas = ensaladas;
    }

    public void setPostres(Postre postres) {
        this.postres = postres;
    }

    public void setPrincipales(Principales principales) {
        this.principales = principales;
    }

    public void setBebestibles(Bebestible bebestibles) {
        this.bebestibles = bebestibles;
    }

    public void setAgregados(Agregado agregados) {
        this.agregados = agregados;
    }

}

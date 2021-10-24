package Diagrama.comidas;

import Diagrama.*;

public class Ensalada extends Comidas {

    private int codigo;
    private int precio;
    private String nombre;

    public Ensalada(String nombre, int precio, int codigo) {
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

    public int getCodigo() {
        return codigo;
    }

    @Override
    public String toString() {
        //experimento para limitar la cantidad de palabras en el menu
        char cadena[] = new char[20];
        int cont = 0;
        for (int i = 0; i < cadena.length; i++) {
            if (nombre.charAt(i) == ' ') {
                cont++;
                if (cont == 2) {
                    cadena[i] = ' ';
                }
            }
            if (cont < 2) {
                cadena[i] = nombre.charAt(i);
            }
        }
        String palabraNombre = "";
        for (int i = 0; i < cadena.length; i++) {
            palabraNombre += cadena[i];
        }
        return palabraNombre + "\t\tPrecio: $" + precio + "";
    }

}

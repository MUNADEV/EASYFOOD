package Diagrama;

import java.util.ArrayList;

public class Cliente {

    private String nombre;
    private String comidas;
    private int numeroMesa;
    private Boleta boleta;

    private ArrayList<Comidas> pedidos;//PEDIDOS 
    private boolean banderaLista = false;

    public Cliente() {
        this.pedidos = new ArrayList<>();
    }

    
    public Comidas agregarComida(int numeroMesa, int codigo, Restaurant restaurant) { 
    //Agrega la comida y a la vez comprueba los errores posibles

        //Comprueba los codigos de  comidas Principales
        for (int i = 0; i < restaurant.getMesas()[numeroMesa].getMenu().getComidas().getPrincipales().size(); i++) {
            if (restaurant.getMesas()[numeroMesa].getMenu().getComidas().getPrincipales().get(i) != null) {
                if (codigo == restaurant.getMesas()[numeroMesa].getMenu().getComidas().getPrincipales().get(i).getCodigo()) {
                    return restaurant.getMesas()[numeroMesa].getMenu().getComidas().getPrincipales().get(i);
                }
            }
        }
          //Comprueba los codigos de Ensaladas
        for (int i = 0; i < restaurant.getMesas()[numeroMesa].getMenu().getComidas().getEnsaladas().size(); i++) {
            if (restaurant.getMesas()[numeroMesa].getMenu().getComidas().getEnsaladas().get(i) != null) {
                if (codigo == restaurant.getMesas()[numeroMesa].getMenu().getComidas().getEnsaladas().get(i).getCodigo()) {
                    return restaurant.getMesas()[numeroMesa].getMenu().getComidas().getEnsaladas().get(i);
                }
            }
        }
          //Comprueba los codigos Agregados
        for (int i = 0; i < restaurant.getMesas()[numeroMesa].getMenu().getComidas().getAgregados().size(); i++) {
            if (restaurant.getMesas()[numeroMesa].getMenu().getComidas().getAgregados().get(i) != null) {
                if (codigo == restaurant.getMesas()[numeroMesa].getMenu().getComidas().getAgregados().get(i).getCodigo()) {
                    return restaurant.getMesas()[numeroMesa].getMenu().getComidas().getAgregados().get(i);
                }
            }
        }
          //Comprueba los codigos de los Postres
        for (int i = 0; i < restaurant.getMesas()[numeroMesa].getMenu().getComidas().getPostres().size(); i++) {
            if (restaurant.getMesas()[numeroMesa].getMenu().getComidas().getPostres().get(i) != null) {
                if (codigo == restaurant.getMesas()[numeroMesa].getMenu().getComidas().getPostres().get(i).getCodigo()) {
                    return restaurant.getMesas()[numeroMesa].getMenu().getComidas().getPostres().get(i);
                }
            }
        }
          //Comprueba los codigos de los bebestibles
        for (int i = 0; i < restaurant.getMesas()[numeroMesa].getMenu().getComidas().getBebestibles().size(); i++) {
            if (restaurant.getMesas()[numeroMesa].getMenu().getComidas().getBebestibles().get(i) != null) {
                if (codigo == restaurant.getMesas()[numeroMesa].getMenu().getComidas().getBebestibles().get(i).getCodigo()) {
                    return restaurant.getMesas()[numeroMesa].getMenu().getComidas().getBebestibles().get(i);
                }
            }
        }
          //Comprueba los codigos de los combos
        for (int i = 0; i < restaurant.getMesas()[numeroMesa].getMenu().getCombos().size(); i++) {
            if (restaurant.getMesas()[numeroMesa].getMenu().getCombos().get(i) != null) {
                if (codigo == restaurant.getMesas()[numeroMesa].getMenu().getCombos().get(i).getCodigo()) {
                    return restaurant.getMesas()[numeroMesa].getMenu().getCombos().get(i);
                }
            }
        }
        return null; 
    }

    //getters and setters
    
    public boolean isBanderaLista() {
        return banderaLista;
    }

    public void setBanderaLista(boolean banderaLista) {
        this.banderaLista = banderaLista;
    }

    public ArrayList<Comidas> getPedidos() {
        return pedidos;
    }

    public void setPedidos(ArrayList<Comidas> pedidos) {
        this.pedidos = pedidos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getComidas() {
        return comidas;
    }

    public void setComidas(String comidas) {
        this.comidas = comidas;
    }

    public int getNumeroMesa() {
        return numeroMesa;
    }

    public void setNumeroMesa(int numeroMesa) {
        this.numeroMesa = numeroMesa;
    }

    public Boleta getBoleta() {
        return boleta;
    }

    public void setBoleta(Boleta boleta) {
        this.boleta = boleta;
    }

    @Override
    public String toString() {
        String cadena = "";
        cadena += "\n==Cliente==";
        cadena += "\nNombre: " + nombre;
        cadena += "\nMesa:" + (this.numeroMesa + 1);

//        cadena += "\nBoleta" +boleta;//´problema
        return cadena;
    }
}

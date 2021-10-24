package Diagrama;

import Diagrama.comidas.*;
import java.util.ArrayList;

public class Menu implements Creable {

    private ArrayList<Combos> combos;///seteralo
    private Comidas comidas;

    public Menu() {
        combos = new ArrayList<>();
        crearComestible();
    }

    @Override
    public void crearComestible() {
        /*
        Metodo correspondiente en la creacion de combos
         */

        //Combo 1
        Combos combo1 = new Combos("Pioleichon ", 1800, 600);
        combo1.setPrincipales(new Principales("Italiano", 1700, 1));
        combo1.setBebestibles(new Bebestible("Soda ", 350, 300, 5));
        combo1.setAgregados(new Agregado("Nuggets/Empanadas(3 Un)", 300, 6));
        combos.add(combo1);
        //Combo 2
        Combos combo2 = new Combos("Pioleichon XL", 2300, 601);
        combo2.setPrincipales(new Principales("Italiano", 1700, 2));
        combo2.setBebestibles(new Bebestible("Soda", 350, 300, 5));
        combo2.setAgregados(new Agregado("Empanadas(3 Un)", 300, 5));
        combo2.setPostres(new Postre("Helado", 500, 5));
        combos.add(combo2);
        //Combo3
        Combos combo3 = new Combos("PA2", 2500, 602);
        combo3.setPrincipales(new Principales("2 Completos", 3000, 3));
        combo3.setBebestibles(new Bebestible("2 Sodas", 350, 600, 5));
        combos.add(combo3);
        //Combo4
        Combos combo4 = new Combos("Diabetes", 2500, 603);
        combo4.setPrincipales(new Principales("Una torta", 3000, 4));
        combo4.setBebestibles(new Bebestible("2 Sodas ", 350, 600, 6));
        combos.add(combo4);

    }

    //getters and setters
    public ArrayList<Combos> getCombos() {
        return combos;
    }

    public void setCombos(ArrayList<Combos> combos) {
        this.combos = combos;
    }

    public Comidas getComidas() {
        return comidas;
    }

    public void setComidas(Comidas comidas) {
        this.comidas = comidas;
    }

}

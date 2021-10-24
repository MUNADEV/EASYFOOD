package Diagrama;

import Diagrama.comidas.*;
import java.util.ArrayList;

//crearComestible  --> crear main
public class Comidas implements Creable {

    private ArrayList<Ensalada> ensaladas;
    private ArrayList<Postre> postres;
    private ArrayList<Principales> principales;
    private ArrayList<Bebestible> bebestibles;
    private ArrayList<Agregado> agregados;

    public Comidas() {
        this.ensaladas = new ArrayList<>();
        this.postres = new ArrayList<>();
        this.principales = new ArrayList<>();
        this.bebestibles = new ArrayList<>();
        this.agregados = new ArrayList<>();

    }

    public int getPrecio() {
        return 1;//requisito
    }

    @Override
    public void crearComestible() {
        /*
        Metodo principal en donde se generan las comidas, aqui es donde se puede modificar el menu
        teniendo especial cuidado con el orden
         */

        //Principales
        Principales churrasco1 = new Principales("Churrasco Italiano", 1700, 100);
        Principales churrasco2 = new Principales("Churrasco Barros Luco", 1700, 101);
        Principales churrasco3 = new Principales("Churrasco Barro Jarpa", 1700, 102);
        Principales churrasco4 = new Principales("Churrasco Arrollado Huaso", 1700, 103);
        Principales churrasco5 = new Principales("Churrasco Potito", 1700, 104);
        Principales churrasco6 = new Principales("Churrasco Lomito", 1700, 105);
        Principales completo1 = new Principales("Completo Italiano", 1500, 106);
        Principales completo2 = new Principales("Completo Aleman", 1500, 107);
        Principales completo3 = new Principales("Completo Ranchero", 1500, 108);
        Principales completo4 = new Principales("Completo Napolitano", 1500, 109);
        Principales completo5 = new Principales("Completo Barros Luco", 1500, 110);
        Principales pizza1 = new Principales("Pizza Napolitana M (15)", 2000, 111);
        Principales pizza2 = new Principales("Pizza Napilitana XL(20)", 2400, 112);
        Principales pizza3 = new Principales("Pizza Pepperoni M(15)", 2000, 113);
        Principales pizza4 = new Principales("Pizza Pepperoni XL(20)", 2400, 114);
        Principales pizza5 = new Principales("Pizza Tocino M(15)", 2000, 115);
        Principales pizza6 = new Principales("Pizza Tocino XL(20)", 2400, 116);
        Principales pizza7 = new Principales("Pizza Pollo M(15)", 2000, 117);
        Principales pizza8 = new Principales("Pizza Pollo XL(20)", 2400, 118);

        principales.add(churrasco1);
        principales.add(churrasco2);
        principales.add(churrasco3);
        principales.add(churrasco4);
        principales.add(churrasco5);
        principales.add(churrasco6);

        principales.add(completo1);
        principales.add(completo2);
        principales.add(completo3);
        principales.add(completo4);
        principales.add(completo5);

        principales.add(pizza1);
        principales.add(pizza2);
        principales.add(pizza3);
        principales.add(pizza4);
        principales.add(pizza5);
        principales.add(pizza6);
        principales.add(pizza7);
        principales.add(pizza8);
        //Ensaladas
        Ensalada comun = new Ensalada("Ensalada  (Tomate/Lechuga/Repollo/Veterraga)", 500, 200);
        Ensalada mix1 = new Ensalada("Mix Chileno (Tomate-Cebolla-Cilantro)", 500, 201);
        Ensalada mix2 = new Ensalada("Mix premium gold (Lechuga-Quesillo-Palta)", 600, 202);
        ensaladas.add(comun);
        ensaladas.add(mix1);
        ensaladas.add(mix2);
        //Bebestibles                                                                  mm -precio-codigo
        Bebestible bebida1 = new Bebestible("Bebidas CCU", 350, 500, 300);
        Bebestible bebida2 = new Bebestible("Bebidas CCU", 500, 700, 301);
        Bebestible bebida3 = new Bebestible("Bebidas CCU", 1000, 1200, 302);
        Bebestible bebida4 = new Bebestible("Cervezas variedad", 500, 1200, 303);
        Bebestible bebida5 = new Bebestible("Pisco                        ", 500, 1200, 304);
        Bebestible bebida6 = new Bebestible("Vodka                        ", 500, 2500, 305);
        Bebestible bebida7 = new Bebestible("Personalizado a pedido", 500, 2500, 306);
        bebestibles.add(bebida1);
        bebestibles.add(bebida2);
        bebestibles.add(bebida3);
        bebestibles.add(bebida4);
        bebestibles.add(bebida5);
        bebestibles.add(bebida6);
        bebestibles.add(bebida7);
        //Agregados
        Agregado agregado1 = new Agregado("Empanada de queso", 300, 400);
        Agregado agregado2 = new Agregado("1/2 Porcion de papas fritas", 500, 401);
        Agregado agregado3 = new Agregado("Condimentos premium", 500, 402);
        agregados.add(agregado1);
        agregados.add(agregado2);
        agregados.add(agregado3);
        //Postres
        Postre postre1 = new Postre("Tazón de helado (Variedad)", 300, 500);
        Postre postre2 = new Postre("Crema catalana", 500, 501);
        Postre postre3 = new Postre("Cheesecake                   ", 500, 502);
        Postre postre4 = new Postre("Baklavas                    ", 550, 503);
        Postre postre5 = new Postre("Tazón de arroz con leche", 550, 504);
        Postre postre6 = new Postre("Alfajor                        ", 600, 505);
        postres.add(postre1);
        postres.add(postre2);
        postres.add(postre3);
        postres.add(postre4);
        postres.add(postre5);
        postres.add(postre6);
    }

    //getters and setters
    public void setEnsaladas(ArrayList<Ensalada> ensaladas) {
        this.ensaladas = ensaladas;
    }

    public void setPostres(ArrayList<Postre> postres) {
        this.postres = postres;
    }

    public void setPrincipales(ArrayList<Principales> principales) {
        this.principales = principales;
    }

    public void setBebestibles(ArrayList<Bebestible> bebestibles) {
        this.bebestibles = bebestibles;
    }

    public void setAgregados(ArrayList<Agregado> agregados) {
        this.agregados = agregados;
    }

    public ArrayList<Ensalada> getEnsaladas() {
        return ensaladas;
    }

    public ArrayList<Postre> getPostres() {
        return postres;
    }

    public ArrayList<Principales> getPrincipales() {
        return principales;
    }

    public ArrayList<Bebestible> getBebestibles() {
        return bebestibles;
    }

    public ArrayList<Agregado> getAgregados() {
        return agregados;
    }

}

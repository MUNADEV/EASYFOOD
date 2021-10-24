package Interfaces;

import Diagrama.*;
import Diagrama.Comidas.*;
import Enumeraciones.*;
import java.awt.Color;
import java.util.ArrayList;
import Interfaces.*;
import java.awt.Image;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.accessibility.AccessibleContext;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Principal extends javax.swing.JFrame {

    Restaurant restaurant;
    private ArrayList<javax.swing.JButton> botones;
    private ArrayList<Mesa> mesas;
    private ArrayList<javax.swing.JLabel> estados;
    Guardado ward;

    public Principal() {
        apariencia();
        this.restaurant = new Restaurant();
        restaurant.iniciar();//Inicio de todo lo relacionado con la clase restaurant y sus subclases
        ward = new Guardado();//Inicio a la clase que guarda las boletas en el equipo

        this.estados = new ArrayList<>();
        this.botones = new ArrayList<>();
        this.mesas = new ArrayList<>();

        initComponents();//propio de editor de netbeans
        initComponents2();//inicia los botones y etiquetas en disponible
        comprobarEstado();//comprueba el estado de los botones y etiquetas
        

    }

    public void apariencia() { //Es solo para la apariencia del programa
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (ClassNotFoundException ex) {
            // Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            //Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            //Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            //Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void initComponents2() {
        /*
        Se utiliza un array para botones y etiquetas para la optima 
        revisión de sus estados, en el metodo comprobar estado y tambien para
        inicializarlos en disponible al comienzo del programa
         */
        {
            botones.add(boton_Mesa1);
            botones.add(boton_Mesa2);
            botones.add(boton_Mesa3);
            botones.add(boton_Mesa4);
            botones.add(boton_Mesa5);
            botones.add(boton_Mesa6);
            botones.add(boton_Mesa7);
            botones.add(boton_Mesa8);
            botones.add(boton_Mesa9);
            botones.add(boton_Mesa10);
            botones.add(boton_Mesa11);
            botones.add(boton_Mesa12);
            botones.add(boton_Mesa13);
            botones.add(boton_Mesa14);
            botones.add(boton_Mesa15);
            botones.add(boton_Mesa16);
            botones.add(boton_Mesa17);
            botones.add(boton_Mesa18);
            botones.add(boton_Mesa19);
            botones.add(boton_Mesa20);
            botones.add(boton_Mesa21);
            botones.add(boton_Mesa22);
            botones.add(boton_Mesa23);
            botones.add(boton_Mesa24);

            /*
            desde la clase restaurante se asocian su clase mesas
            al array de mesas,esto para la correcta modificaciones que
            pueda utilizar en un futuro
             */
            mesas.add(restaurant.getMesas()[0]);
            mesas.add(restaurant.getMesas()[1]);
            mesas.add(restaurant.getMesas()[2]);
            mesas.add(restaurant.getMesas()[3]);
            mesas.add(restaurant.getMesas()[4]);
            mesas.add(restaurant.getMesas()[5]);
            mesas.add(restaurant.getMesas()[6]);
            mesas.add(restaurant.getMesas()[7]);
            mesas.add(restaurant.getMesas()[8]);
            mesas.add(restaurant.getMesas()[9]);
            mesas.add(restaurant.getMesas()[10]);
            mesas.add(restaurant.getMesas()[11]);
            mesas.add(restaurant.getMesas()[12]);
            mesas.add(restaurant.getMesas()[13]);
            mesas.add(restaurant.getMesas()[14]);
            mesas.add(restaurant.getMesas()[15]);
            mesas.add(restaurant.getMesas()[16]);
            mesas.add(restaurant.getMesas()[17]);
            mesas.add(restaurant.getMesas()[18]);
            mesas.add(restaurant.getMesas()[19]);
            mesas.add(restaurant.getMesas()[20]);
            mesas.add(restaurant.getMesas()[21]);
            mesas.add(restaurant.getMesas()[22]);
            mesas.add(restaurant.getMesas()[23]);

            estados.add(estado_Mesa1);
            estados.add(estado_Mesa2);
            estados.add(estado_Mesa3);
            estados.add(estado_Mesa4);
            estados.add(estado_Mesa5);
            estados.add(estado_Mesa6);
            estados.add(estado_Mesa7);
            estados.add(estado_Mesa8);
            estados.add(estado_Mesa9);
            estados.add(estado_Mesa10);
            estados.add(estado_Mesa11);
            estados.add(estado_Mesa12);
            estados.add(estado_Mesa13);
            estados.add(estado_Mesa14);
            estados.add(estado_Mesa15);
            estados.add(estado_Mesa16);
            estados.add(estado_Mesa17);
            estados.add(estado_Mesa18);
            estados.add(estado_Mesa19);
            estados.add(estado_Mesa20);
            estados.add(estado_Mesa21);
            estados.add(estado_Mesa22);
            estados.add(estado_Mesa23);
            estados.add(estado_Mesa24);

        }
        //Iniciando Mesas
        for (int i = 0; i < botones.size(); i++) {
            botones.get(i).setText("MESA " + (i + 1));
        }
    }

    public void comprobarEstado() {
        /*
        Cada vez que se manda a llamar este metodo
        se comprueba la situacion de las etiquetas y de los botones
        para la disponibilidad
         */
        for (int i = 0; i < mesas.size(); i++) {
            if (botones.get(i) != null && mesas.get(i) != null) {
                if (restaurant.getMesas()[i].getEstado() != null) {
                    if (restaurant.getMesas()[i].getEstado().equalsIgnoreCase(Estados.DISPONIBLE.getEstado())) {
                        botones.get(i).setBackground(Color.green);
                        estados.get(i).setText(Estados.DISPONIBLE.getEstado());//==Disponible
                    }
                    if (restaurant.getMesas()[i].getEstado().equalsIgnoreCase(Estados.OCUPADO.getEstado())) {
                        botones.get(i).setBackground(Color.red);
                        estados.get(i).setText(Estados.OCUPADO.getEstado());
                    }
                    if (restaurant.getMesas()[i].getEstado().equalsIgnoreCase(Estados.EN_ESPERA.getEstado())) {
                        botones.get(i).setBackground(Color.ORANGE);
                        estados.get(i).setText(Estados.EN_ESPERA.getEstado());
                    }
                } else {
                    System.out.println("error ");
                }
            }
        }
    }

    public void ventanaRegistrar_InitComponents(Disponible ventana_Registrar2) {
        /*
        Metodo correspondiente a llenar la tabla de datos del JDialog "Disponible"
        donde muestra los tipos de comidas, precios y codigos
         */

        ventana_Registrar2.getTablaMenu().setValueAt(restaurant.getMesas()[0].getMenu().getComidas().getPrincipales().get(0).getNombre(), 1, 0);
        int contPrincipales = 0;
        int contEnsaladas = 0;
        int contAgregados = 0;
        int contPostres = 0;
        int contBebestibles = 0;
        int contCombos = 0;

        for (int i = 0; i < ventana_Registrar2.getTablaMenu().getColumnCount(); i++) {
            for (int j = 0; j < ventana_Registrar2.getTablaMenu().getRowCount(); j++) {

                if (contPrincipales < restaurant.getMesas()[0].getMenu().getComidas().getPrincipales().size()) {
                    ventana_Registrar2.getTablaMenu().setValueAt(restaurant.getMesas()[0].getMenu().getComidas().getPrincipales().get(contPrincipales).getNombre(), j, i);
                    ventana_Registrar2.getTablaMenu().setValueAt(restaurant.getMesas()[0].getMenu().getComidas().getPrincipales().get(contPrincipales).getPrecio(), j, i + 1);
                    ventana_Registrar2.getTablaMenu().setValueAt(restaurant.getMesas()[0].getMenu().getComidas().getPrincipales().get(contPrincipales).getCodigo(), j, i + 2);
                    contPrincipales++;
                } else if (contEnsaladas < restaurant.getMesas()[0].getMenu().getComidas().getEnsaladas().size()) {
                    ventana_Registrar2.getTablaMenu().setValueAt(restaurant.getMesas()[0].getMenu().getComidas().getEnsaladas().get(contEnsaladas).getNombre(), j, i);
                    ventana_Registrar2.getTablaMenu().setValueAt(restaurant.getMesas()[0].getMenu().getComidas().getEnsaladas().get(contEnsaladas).getPrecio(), j, i + 1);
                    ventana_Registrar2.getTablaMenu().setValueAt(restaurant.getMesas()[0].getMenu().getComidas().getEnsaladas().get(contEnsaladas).getCodigo(), j, i + 2);
                    contEnsaladas++;

                } else if (contBebestibles < restaurant.getMesas()[0].getMenu().getComidas().getBebestibles().size()) {
                    ventana_Registrar2.getTablaMenu().setValueAt(restaurant.getMesas()[0].getMenu().getComidas().getBebestibles().get(contBebestibles).getNombre(), j, i);
                    ventana_Registrar2.getTablaMenu().setValueAt(restaurant.getMesas()[0].getMenu().getComidas().getBebestibles().get(contBebestibles).getPrecio(), j, i + 1);
                    ventana_Registrar2.getTablaMenu().setValueAt(restaurant.getMesas()[0].getMenu().getComidas().getBebestibles().get(contBebestibles).getCodigo(), j, i + 2);
                    contBebestibles++;

                } else if (contAgregados < restaurant.getMesas()[0].getMenu().getComidas().getAgregados().size()) {
                    ventana_Registrar2.getTablaMenu().setValueAt(restaurant.getMesas()[0].getMenu().getComidas().getAgregados().get(contAgregados).getNombre(), j, i);
                    ventana_Registrar2.getTablaMenu().setValueAt(restaurant.getMesas()[0].getMenu().getComidas().getAgregados().get(contAgregados).getPrecio(), j, i + 1);
                    ventana_Registrar2.getTablaMenu().setValueAt(restaurant.getMesas()[0].getMenu().getComidas().getAgregados().get(contAgregados).getCodigo(), j, i + 2);
                    contAgregados++;
                } else if (contPostres < restaurant.getMesas()[0].getMenu().getComidas().getPostres().size()) {
                    ventana_Registrar2.getTablaMenu().setValueAt(restaurant.getMesas()[0].getMenu().getComidas().getPostres().get(contPostres).getNombre(), j, i);
                    ventana_Registrar2.getTablaMenu().setValueAt(restaurant.getMesas()[0].getMenu().getComidas().getPostres().get(contPostres).getPrecio(), j, i + 1);
                    ventana_Registrar2.getTablaMenu().setValueAt(restaurant.getMesas()[0].getMenu().getComidas().getPostres().get(contPostres).getCodigo(), j, i + 2);
                    contPostres++;
                } else if (contCombos < restaurant.getMesas()[0].getMenu().getCombos().size() - (restaurant.getMesas()[0].getMenu().getCombos().size() / 2)) {
                    System.out.println(restaurant.getMesas()[0].getMenu().getCombos().size());
                    ventana_Registrar2.getTablaMenu().setValueAt(restaurant.getMesas()[0].getMenu().getCombos().get(contCombos).toString2(), j, i);
                    ventana_Registrar2.getTablaMenu().setValueAt(restaurant.getMesas()[0].getMenu().getCombos().get(contCombos).getPrecio(), j, i + 1);
                    ventana_Registrar2.getTablaMenu().setValueAt(restaurant.getMesas()[0].getMenu().getCombos().get(contCombos).getCodigo(), j, i + 2);
                    contCombos++;
                }

            }
        }
    }

    public void initMesa(int numeroMesa) {
        //___________DISPONIBLE___________
        if (restaurant.getMesas()[numeroMesa].getEstado().equalsIgnoreCase(Estados.DISPONIBLE.getEstado())) {

            Disponible registrar = new Disponible(this, true, restaurant); //Al crear la ventana se asocia con el mismo restaurant del JFrame
            registrar.setNumeroMesa(numeroMesa); // Asocia la clase con la mesa
            ventanaRegistrar_InitComponents(registrar);//Se utiliza este metodo para ordenar el menu  en la tabla del JDialog

            // Visibilidad de ventana
            registrar.getPanel1().setVisible(true);// Panel1: Registro del cliente
            registrar.getPanel2().setVisible(false);//Panel2: Registro del pedido
            registrar.setVisible(true);
            if (registrar.isRegistrado() == true) {//Si el usuario pidio algo:
                comprobarEstado();//Se comprueba la disponibilidad de las mesas
            }
            //_______________EN ESPERA________________
        } else if (restaurant.getMesas()[numeroMesa].getEstado().equalsIgnoreCase(Estados.EN_ESPERA.getEstado())) {

            EnEspera ventanaEspera = new EnEspera(this, true, restaurant);
            ventanaEspera.setNumeroMesa(numeroMesa);//Asocia la clase con la mesa        
            ventanaEspera.getEtiqueta_Cliente().setText("Cliente: " + restaurant.getMesas()[numeroMesa].getCliente().getNombre());
            String cadena = ""; //acumulador de informacion

            Boleta boleta = new Boleta(restaurant.getMesas()[numeroMesa].getCliente());//Se crea una boleta para el cliente de la mesa
            cadena += boleta.toString2();
            ventanaEspera.getjTextArea1().setText(cadena);//imprime la informacion cuando se requiere 

            ventanaEspera.setVisible(true);

            if (ventanaEspera.isEntregado() == true) {//Si se utilizó correctamente:
                comprobarEstado();//comprueba la disponibilidad de las mesas
            }
            //_______________OCUPADO________________
        } else if (restaurant.getMesas()[numeroMesa].getEstado().equalsIgnoreCase(Estados.OCUPADO.getEstado())) {

            Ocupado ventanaOcupado = new Ocupado(this, true);//En este caso no se manda el restaurant porque solo se necesita emitir la boleta para el cosumidor
            ventanaOcupado.getEtiqueta_Cliente().setText("Cliente: " + restaurant.getMesas()[numeroMesa].getCliente().getNombre());
            ventanaOcupado.setVisible(true);

            if (ventanaOcupado.isGenerarBoleta() == true) { //si se utilizo correctamente:
                restaurant.getMesas()[numeroMesa].setEstado(Estados.DISPONIBLE.getEstado());//cambiar el estado de la mesa a diponbile
                comprobarEstado();//comprobar el estado de las emsas
            }
            if (ventanaOcupado.isGenerarBoleta() == true) {//si se utilizo correctamente de igual forma:

                Boletear ventanaBoleta = new Boletear(this, true);//imprime la boleta en la pantalla 
                String cadena = "";
                Boleta boleta = new Boleta(restaurant.getMesas()[numeroMesa].getCliente());
                cadena += boleta.toString();//acumula la informacion 

                ward.init(cadena);//clase init guarda la informacion del pedido en una direccion especifica del equipo
                ventanaBoleta.getAreaTexto().setText(cadena);//Le manda la cadena para que se muestre
                ventanaBoleta.setVisible(true);//se muestra la ventana con la cadena
            }

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        panel = new javax.swing.JPanel();
        boton_Mesa1 = new javax.swing.JButton();
        boton_Mesa2 = new javax.swing.JButton();
        boton_Mesa3 = new javax.swing.JButton();
        boton_Mesa4 = new javax.swing.JButton();
        boton_Mesa5 = new javax.swing.JButton();
        boton_Mesa6 = new javax.swing.JButton();
        boton_Mesa7 = new javax.swing.JButton();
        boton_Mesa8 = new javax.swing.JButton();
        boton_Mesa9 = new javax.swing.JButton();
        boton_Mesa10 = new javax.swing.JButton();
        boton_Mesa11 = new javax.swing.JButton();
        boton_Mesa12 = new javax.swing.JButton();
        boton_Mesa13 = new javax.swing.JButton();
        boton_Mesa14 = new javax.swing.JButton();
        boton_Mesa15 = new javax.swing.JButton();
        boton_Mesa16 = new javax.swing.JButton();
        boton_Mesa17 = new javax.swing.JButton();
        boton_Mesa18 = new javax.swing.JButton();
        boton_Mesa19 = new javax.swing.JButton();
        boton_Mesa20 = new javax.swing.JButton();
        boton_Mesa21 = new javax.swing.JButton();
        boton_Mesa22 = new javax.swing.JButton();
        boton_Mesa23 = new javax.swing.JButton();
        boton_Mesa24 = new javax.swing.JButton();
        etiquetaEspacio1 = new javax.swing.JLabel();
        etiquetaEspacio2 = new javax.swing.JLabel();
        estado_Mesa1 = new javax.swing.JLabel();
        estado_Mesa2 = new javax.swing.JLabel();
        estado_Mesa3 = new javax.swing.JLabel();
        estado_Mesa4 = new javax.swing.JLabel();
        estado_Mesa5 = new javax.swing.JLabel();
        estado_Mesa6 = new javax.swing.JLabel();
        estado_Mesa7 = new javax.swing.JLabel();
        estado_Mesa8 = new javax.swing.JLabel();
        estado_Mesa9 = new javax.swing.JLabel();
        estado_Mesa10 = new javax.swing.JLabel();
        estado_Mesa11 = new javax.swing.JLabel();
        estado_Mesa12 = new javax.swing.JLabel();
        estado_Mesa13 = new javax.swing.JLabel();
        estado_Mesa14 = new javax.swing.JLabel();
        estado_Mesa15 = new javax.swing.JLabel();
        estado_Mesa16 = new javax.swing.JLabel();
        estado_Mesa17 = new javax.swing.JLabel();
        estado_Mesa18 = new javax.swing.JLabel();
        estado_Mesa19 = new javax.swing.JLabel();
        estado_Mesa20 = new javax.swing.JLabel();
        estado_Mesa21 = new javax.swing.JLabel();
        estado_Mesa22 = new javax.swing.JLabel();
        estado_Mesa23 = new javax.swing.JLabel();
        estado_Mesa24 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("EASYFOOD");
        setBackground(new java.awt.Color(255, 153, 0));
        setBounds(new java.awt.Rectangle(100, 200, 1280, 780));
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setLocation(new java.awt.Point(0, 0));
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setSize(new java.awt.Dimension(0, 0));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        panel.setBackground(new java.awt.Color(255, 153, 0));
        panel.setBorder(new javax.swing.border.MatteBorder(null));
        panel.setForeground(new java.awt.Color(255, 153, 0));
        panel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panel.setMinimumSize(new java.awt.Dimension(1280, 780));
        panel.setOpaque(false);
        panel.setPreferredSize(new java.awt.Dimension(1920, 1080));
        panel.setVerifyInputWhenFocusTarget(false);
        panel.setLayout(new java.awt.GridBagLayout());

        boton_Mesa1.setText("Mesa 1");
        boton_Mesa1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_Mesa1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.ipady = 50;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(35, 25, 0, 25);
        panel.add(boton_Mesa1, gridBagConstraints);

        boton_Mesa2.setText("Mesa 2");
        boton_Mesa2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_Mesa2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.ipady = 50;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(35, 25, 0, 25);
        panel.add(boton_Mesa2, gridBagConstraints);

        boton_Mesa3.setText("Mesa 3");
        boton_Mesa3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_Mesa3ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 11;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.ipady = 50;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(35, 25, 0, 25);
        panel.add(boton_Mesa3, gridBagConstraints);

        boton_Mesa4.setText("Mesa 4");
        boton_Mesa4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_Mesa4ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 14;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.ipady = 50;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(35, 25, 0, 25);
        panel.add(boton_Mesa4, gridBagConstraints);

        boton_Mesa5.setText("Mesa 5");
        boton_Mesa5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_Mesa5ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 17;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.ipady = 50;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(35, 25, 0, 25);
        panel.add(boton_Mesa5, gridBagConstraints);

        boton_Mesa6.setText("Mesa 6");
        boton_Mesa6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_Mesa6ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 20;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.ipady = 50;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(35, 25, 0, 25);
        panel.add(boton_Mesa6, gridBagConstraints);

        boton_Mesa7.setText("Mesa 7");
        boton_Mesa7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_Mesa7ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.ipady = 50;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(35, 25, 0, 25);
        panel.add(boton_Mesa7, gridBagConstraints);

        boton_Mesa8.setText("Mesa 8");
        boton_Mesa8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_Mesa8ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.ipady = 50;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(35, 25, 0, 25);
        panel.add(boton_Mesa8, gridBagConstraints);

        boton_Mesa9.setText("Mesa 9");
        boton_Mesa9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_Mesa9ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 11;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.ipady = 50;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(35, 25, 0, 25);
        panel.add(boton_Mesa9, gridBagConstraints);

        boton_Mesa10.setText("Mesa 10");
        boton_Mesa10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_Mesa10ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 14;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.ipady = 50;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(35, 25, 0, 25);
        panel.add(boton_Mesa10, gridBagConstraints);

        boton_Mesa11.setText("Mesa 11");
        boton_Mesa11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_Mesa11ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 17;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.ipady = 50;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(35, 25, 0, 25);
        panel.add(boton_Mesa11, gridBagConstraints);

        boton_Mesa12.setText("Mesa 12");
        boton_Mesa12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_Mesa12ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 20;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.ipady = 50;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(35, 25, 0, 25);
        panel.add(boton_Mesa12, gridBagConstraints);

        boton_Mesa13.setText("Mesa 13");
        boton_Mesa13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_Mesa13ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.ipady = 50;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(35, 25, 0, 25);
        panel.add(boton_Mesa13, gridBagConstraints);

        boton_Mesa14.setText("Mesa 14");
        boton_Mesa14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_Mesa14ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.ipady = 50;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(35, 25, 0, 25);
        panel.add(boton_Mesa14, gridBagConstraints);

        boton_Mesa15.setText("Mesa 15");
        boton_Mesa15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_Mesa15ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 11;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.ipady = 50;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(35, 25, 0, 25);
        panel.add(boton_Mesa15, gridBagConstraints);

        boton_Mesa16.setText("Mesa 16");
        boton_Mesa16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_Mesa16ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 14;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.ipady = 50;
        gridBagConstraints.insets = new java.awt.Insets(35, 25, 0, 25);
        panel.add(boton_Mesa16, gridBagConstraints);

        boton_Mesa17.setText("Mesa 17");
        boton_Mesa17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_Mesa17ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 17;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.ipady = 50;
        gridBagConstraints.insets = new java.awt.Insets(35, 25, 0, 25);
        panel.add(boton_Mesa17, gridBagConstraints);

        boton_Mesa18.setText("Mesa 18");
        boton_Mesa18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_Mesa18ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 20;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.ipady = 50;
        gridBagConstraints.insets = new java.awt.Insets(35, 25, 0, 25);
        panel.add(boton_Mesa18, gridBagConstraints);

        boton_Mesa19.setText("Mesa 19");
        boton_Mesa19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_Mesa19ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 18;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.ipady = 50;
        gridBagConstraints.insets = new java.awt.Insets(35, 25, 0, 25);
        panel.add(boton_Mesa19, gridBagConstraints);

        boton_Mesa20.setText("Mesa 20");
        boton_Mesa20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_Mesa20ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 18;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.ipady = 50;
        gridBagConstraints.insets = new java.awt.Insets(35, 25, 0, 25);
        panel.add(boton_Mesa20, gridBagConstraints);

        boton_Mesa21.setText("Mesa 21");
        boton_Mesa21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_Mesa21ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 11;
        gridBagConstraints.gridy = 18;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.ipady = 50;
        gridBagConstraints.insets = new java.awt.Insets(35, 25, 0, 25);
        panel.add(boton_Mesa21, gridBagConstraints);

        boton_Mesa22.setText("Mesa 22");
        boton_Mesa22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_Mesa22ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 14;
        gridBagConstraints.gridy = 18;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.ipady = 50;
        gridBagConstraints.insets = new java.awt.Insets(35, 25, 0, 25);
        panel.add(boton_Mesa22, gridBagConstraints);

        boton_Mesa23.setText("Mesa 23");
        boton_Mesa23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_Mesa23ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 17;
        gridBagConstraints.gridy = 18;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.ipady = 50;
        gridBagConstraints.insets = new java.awt.Insets(35, 25, 0, 25);
        panel.add(boton_Mesa23, gridBagConstraints);

        boton_Mesa24.setText("Mesa 24");
        boton_Mesa24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_Mesa24ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 20;
        gridBagConstraints.gridy = 18;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.ipady = 50;
        gridBagConstraints.insets = new java.awt.Insets(35, 25, 0, 25);
        panel.add(boton_Mesa24, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(0, 75, 75, 75);
        panel.add(etiquetaEspacio1, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 25;
        gridBagConstraints.gridy = 21;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(0, 75, 75, 75);
        panel.add(etiquetaEspacio2, gridBagConstraints);

        estado_Mesa1.setText("estado1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 20);
        panel.add(estado_Mesa1, gridBagConstraints);

        estado_Mesa2.setText("estado2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 20);
        panel.add(estado_Mesa2, gridBagConstraints);

        estado_Mesa3.setText("estado3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 11;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 20);
        panel.add(estado_Mesa3, gridBagConstraints);

        estado_Mesa4.setText("estado4");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 14;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 20);
        panel.add(estado_Mesa4, gridBagConstraints);

        estado_Mesa5.setText("estado5");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 17;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 20);
        panel.add(estado_Mesa5, gridBagConstraints);

        estado_Mesa6.setText("estado6");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 20;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 20);
        panel.add(estado_Mesa6, gridBagConstraints);

        estado_Mesa7.setText("estado7");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 20);
        panel.add(estado_Mesa7, gridBagConstraints);

        estado_Mesa8.setText("estado8");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 20);
        panel.add(estado_Mesa8, gridBagConstraints);

        estado_Mesa9.setText("estado9");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 11;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 20);
        panel.add(estado_Mesa9, gridBagConstraints);

        estado_Mesa10.setText("estado10");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 14;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 20);
        panel.add(estado_Mesa10, gridBagConstraints);

        estado_Mesa11.setText("estado11");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 17;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 20);
        panel.add(estado_Mesa11, gridBagConstraints);

        estado_Mesa12.setText("estado12");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 20;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 20);
        panel.add(estado_Mesa12, gridBagConstraints);

        estado_Mesa13.setText("estado13");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 16;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 20);
        panel.add(estado_Mesa13, gridBagConstraints);

        estado_Mesa14.setText("estado14");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 16;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 20);
        panel.add(estado_Mesa14, gridBagConstraints);

        estado_Mesa15.setText("estado15");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 11;
        gridBagConstraints.gridy = 16;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 20);
        panel.add(estado_Mesa15, gridBagConstraints);

        estado_Mesa16.setText("estado16");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 14;
        gridBagConstraints.gridy = 16;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 20);
        panel.add(estado_Mesa16, gridBagConstraints);

        estado_Mesa17.setText("estado17");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 17;
        gridBagConstraints.gridy = 16;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 20);
        panel.add(estado_Mesa17, gridBagConstraints);

        estado_Mesa18.setText("estado18");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 20;
        gridBagConstraints.gridy = 16;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 20);
        panel.add(estado_Mesa18, gridBagConstraints);

        estado_Mesa19.setText("estado19");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 20;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.ABOVE_BASELINE;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 20);
        panel.add(estado_Mesa19, gridBagConstraints);

        estado_Mesa20.setText("estado20");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 20;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.ABOVE_BASELINE;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 20);
        panel.add(estado_Mesa20, gridBagConstraints);

        estado_Mesa21.setText("estado21");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 11;
        gridBagConstraints.gridy = 20;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.ABOVE_BASELINE;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 20);
        panel.add(estado_Mesa21, gridBagConstraints);

        estado_Mesa22.setText("estado22");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 14;
        gridBagConstraints.gridy = 20;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.ABOVE_BASELINE;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 20);
        panel.add(estado_Mesa22, gridBagConstraints);

        estado_Mesa23.setText("estado23");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 17;
        gridBagConstraints.gridy = 20;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.ABOVE_BASELINE;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 20);
        panel.add(estado_Mesa23, gridBagConstraints);

        estado_Mesa24.setText("estado24");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 20;
        gridBagConstraints.gridy = 20;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.ABOVE_BASELINE;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 20);
        panel.add(estado_Mesa24, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        getContentPane().add(panel, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boton_Mesa18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_Mesa18ActionPerformed
        int numeroMesa = 18;//num-1
        initMesa(numeroMesa - 1); //acortado de codigo
    }//GEN-LAST:event_boton_Mesa18ActionPerformed

    private void boton_Mesa1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_Mesa1ActionPerformed

        int numeroMesa = 1;//num-1
        initMesa(numeroMesa - 1); //acortado de codigo

    }//GEN-LAST:event_boton_Mesa1ActionPerformed

    private void boton_Mesa2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_Mesa2ActionPerformed
        int numeroMesa = 2;//num-1
        initMesa(numeroMesa - 1); //acortado de codigo
    }//GEN-LAST:event_boton_Mesa2ActionPerformed

    private void boton_Mesa3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_Mesa3ActionPerformed
        int numeroMesa = 3;//num-1
        initMesa(numeroMesa - 1); //acortado de codigo
    }//GEN-LAST:event_boton_Mesa3ActionPerformed

    private void boton_Mesa4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_Mesa4ActionPerformed
        int numeroMesa = 4;//num-1
        initMesa(numeroMesa - 1); //acortado de codigo

    }//GEN-LAST:event_boton_Mesa4ActionPerformed

    private void boton_Mesa5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_Mesa5ActionPerformed
        int numeroMesa = 5;//num-1
        initMesa(numeroMesa - 1); //acortado de codigo
    }//GEN-LAST:event_boton_Mesa5ActionPerformed

    private void boton_Mesa6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_Mesa6ActionPerformed
        int numeroMesa = 6;//num-1
        initMesa(numeroMesa - 1); //acortado de codigo
    }//GEN-LAST:event_boton_Mesa6ActionPerformed

    private void boton_Mesa7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_Mesa7ActionPerformed
        int numeroMesa = 7;//num-1
        initMesa(numeroMesa - 1); //acortado de codigo
    }//GEN-LAST:event_boton_Mesa7ActionPerformed

    private void boton_Mesa8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_Mesa8ActionPerformed
        int numeroMesa = 8;//num-1
        initMesa(numeroMesa - 1); //acortado de codigo
    }//GEN-LAST:event_boton_Mesa8ActionPerformed

    private void boton_Mesa9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_Mesa9ActionPerformed
        int numeroMesa = 9;//num-1
        initMesa(numeroMesa - 1); //acortado de codigo
    }//GEN-LAST:event_boton_Mesa9ActionPerformed

    private void boton_Mesa10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_Mesa10ActionPerformed
        int numeroMesa = 10;//num-1
        initMesa(numeroMesa - 1); //acortado de codigo
    }//GEN-LAST:event_boton_Mesa10ActionPerformed

    private void boton_Mesa11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_Mesa11ActionPerformed
        int numeroMesa = 11;//num-1
        initMesa(numeroMesa - 1); //acortado de codigo
    }//GEN-LAST:event_boton_Mesa11ActionPerformed

    private void boton_Mesa12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_Mesa12ActionPerformed
        int numeroMesa = 12;//num-1
        initMesa(numeroMesa - 1); //acortado de codigo
    }//GEN-LAST:event_boton_Mesa12ActionPerformed

    private void boton_Mesa13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_Mesa13ActionPerformed
        int numeroMesa = 13;//num-1
        initMesa(numeroMesa - 1); //acortado de codigo
    }//GEN-LAST:event_boton_Mesa13ActionPerformed

    private void boton_Mesa14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_Mesa14ActionPerformed
        int numeroMesa = 14;//num-1
        initMesa(numeroMesa - 1); //acortado de codigo
    }//GEN-LAST:event_boton_Mesa14ActionPerformed

    private void boton_Mesa15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_Mesa15ActionPerformed
        int numeroMesa = 15;//num-1
        initMesa(numeroMesa - 1); //acortado de codigo
    }//GEN-LAST:event_boton_Mesa15ActionPerformed

    private void boton_Mesa16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_Mesa16ActionPerformed
        int numeroMesa = 16;//num-1
        initMesa(numeroMesa - 1); //acortado de codigo
    }//GEN-LAST:event_boton_Mesa16ActionPerformed

    private void boton_Mesa17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_Mesa17ActionPerformed
        int numeroMesa = 17;//num-1
        initMesa(numeroMesa - 1); //acortado de codigo
    }//GEN-LAST:event_boton_Mesa17ActionPerformed

    private void boton_Mesa19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_Mesa19ActionPerformed
        int numeroMesa = 19;//num-1
        initMesa(numeroMesa - 1); //acortado de codigo
    }//GEN-LAST:event_boton_Mesa19ActionPerformed

    private void boton_Mesa20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_Mesa20ActionPerformed
        int numeroMesa = 20;//num-1
        initMesa(numeroMesa - 1); //acortado de codigo
    }//GEN-LAST:event_boton_Mesa20ActionPerformed

    private void boton_Mesa21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_Mesa21ActionPerformed
        int numeroMesa = 21;//num-1
        initMesa(numeroMesa - 1); //acortado de codigo
    }//GEN-LAST:event_boton_Mesa21ActionPerformed

    private void boton_Mesa22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_Mesa22ActionPerformed
        int numeroMesa = 22;//num-1
        initMesa(numeroMesa - 1); //acortado de codigo
    }//GEN-LAST:event_boton_Mesa22ActionPerformed

    private void boton_Mesa23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_Mesa23ActionPerformed
        int numeroMesa = 23;//num-1
        initMesa(numeroMesa - 1); //acortado de codigo
    }//GEN-LAST:event_boton_Mesa23ActionPerformed

    private void boton_Mesa24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_Mesa24ActionPerformed
        int numeroMesa = 24;//num-1
        initMesa(numeroMesa - 1); //acortado de codigo
    }//GEN-LAST:event_boton_Mesa24ActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton_Mesa1;
    private javax.swing.JButton boton_Mesa10;
    private javax.swing.JButton boton_Mesa11;
    private javax.swing.JButton boton_Mesa12;
    private javax.swing.JButton boton_Mesa13;
    private javax.swing.JButton boton_Mesa14;
    private javax.swing.JButton boton_Mesa15;
    private javax.swing.JButton boton_Mesa16;
    private javax.swing.JButton boton_Mesa17;
    private javax.swing.JButton boton_Mesa18;
    private javax.swing.JButton boton_Mesa19;
    private javax.swing.JButton boton_Mesa2;
    private javax.swing.JButton boton_Mesa20;
    private javax.swing.JButton boton_Mesa21;
    private javax.swing.JButton boton_Mesa22;
    private javax.swing.JButton boton_Mesa23;
    private javax.swing.JButton boton_Mesa24;
    private javax.swing.JButton boton_Mesa3;
    private javax.swing.JButton boton_Mesa4;
    private javax.swing.JButton boton_Mesa5;
    private javax.swing.JButton boton_Mesa6;
    private javax.swing.JButton boton_Mesa7;
    private javax.swing.JButton boton_Mesa8;
    private javax.swing.JButton boton_Mesa9;
    private javax.swing.JLabel estado_Mesa1;
    private javax.swing.JLabel estado_Mesa10;
    private javax.swing.JLabel estado_Mesa11;
    private javax.swing.JLabel estado_Mesa12;
    private javax.swing.JLabel estado_Mesa13;
    private javax.swing.JLabel estado_Mesa14;
    private javax.swing.JLabel estado_Mesa15;
    private javax.swing.JLabel estado_Mesa16;
    private javax.swing.JLabel estado_Mesa17;
    private javax.swing.JLabel estado_Mesa18;
    private javax.swing.JLabel estado_Mesa19;
    private javax.swing.JLabel estado_Mesa2;
    private javax.swing.JLabel estado_Mesa20;
    private javax.swing.JLabel estado_Mesa21;
    private javax.swing.JLabel estado_Mesa22;
    private javax.swing.JLabel estado_Mesa23;
    private javax.swing.JLabel estado_Mesa24;
    private javax.swing.JLabel estado_Mesa3;
    private javax.swing.JLabel estado_Mesa4;
    private javax.swing.JLabel estado_Mesa5;
    private javax.swing.JLabel estado_Mesa6;
    private javax.swing.JLabel estado_Mesa7;
    private javax.swing.JLabel estado_Mesa8;
    private javax.swing.JLabel estado_Mesa9;
    private javax.swing.JLabel etiquetaEspacio1;
    private javax.swing.JLabel etiquetaEspacio2;
    private javax.swing.JPanel panel;
    // End of variables declaration//GEN-END:variables
    public Guardado getWard() {
        return ward;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public static int getEXIT_ON_CLOSE() {
        return EXIT_ON_CLOSE;
    }

    public JRootPane getRootPane() {
        return rootPane;
    }

    public boolean isRootPaneCheckingEnabled() {
        return rootPaneCheckingEnabled;
    }

    public AccessibleContext getAccessibleContext() {
        return accessibleContext;
    }

    public ArrayList<JButton> getBotones() {
        return botones;
    }

    public ArrayList<Mesa> getMesas() {
        return mesas;
    }

    public ArrayList<JLabel> getEstados() {
        return estados;
    }

    public JButton getBoton_Mesa1() {
        return boton_Mesa1;
    }

    public void setBoton_Mesa1(JButton boton_Mesa1) {
        this.boton_Mesa1 = boton_Mesa1;
    }

    public JButton getBoton_Mesa10() {
        return boton_Mesa10;
    }

    public void setBoton_Mesa10(JButton boton_Mesa10) {
        this.boton_Mesa10 = boton_Mesa10;
    }

    public JButton getBoton_Mesa11() {
        return boton_Mesa11;
    }

    public void setBoton_Mesa11(JButton boton_Mesa11) {
        this.boton_Mesa11 = boton_Mesa11;
    }

    public JButton getBoton_Mesa12() {
        return boton_Mesa12;
    }

    public void setBoton_Mesa12(JButton boton_Mesa12) {
        this.boton_Mesa12 = boton_Mesa12;
    }

    public JButton getBoton_Mesa13() {
        return boton_Mesa13;
    }

    public void setBoton_Mesa13(JButton boton_Mesa13) {
        this.boton_Mesa13 = boton_Mesa13;
    }

    public JButton getBoton_Mesa14() {
        return boton_Mesa14;
    }

    public void setBoton_Mesa14(JButton boton_Mesa14) {
        this.boton_Mesa14 = boton_Mesa14;
    }

    public JButton getBoton_Mesa15() {
        return boton_Mesa15;
    }

    public void setBoton_Mesa15(JButton boton_Mesa15) {
        this.boton_Mesa15 = boton_Mesa15;
    }

    public JButton getBoton_Mesa16() {
        return boton_Mesa16;
    }

    public void setBoton_Mesa16(JButton boton_Mesa16) {
        this.boton_Mesa16 = boton_Mesa16;
    }

    public JButton getBoton_Mesa17() {
        return boton_Mesa17;
    }

    public void setBoton_Mesa17(JButton boton_Mesa17) {
        this.boton_Mesa17 = boton_Mesa17;
    }

    public JButton getBoton_Mesa18() {
        return boton_Mesa18;
    }

    public void setBoton_Mesa18(JButton boton_Mesa18) {
        this.boton_Mesa18 = boton_Mesa18;
    }

    public JButton getBoton_Mesa19() {
        return boton_Mesa19;
    }

    public void setBoton_Mesa19(JButton boton_Mesa19) {
        this.boton_Mesa19 = boton_Mesa19;
    }

    public JButton getBoton_Mesa2() {
        return boton_Mesa2;
    }

    public void setBoton_Mesa2(JButton boton_Mesa2) {
        this.boton_Mesa2 = boton_Mesa2;
    }

    public JButton getBoton_Mesa20() {
        return boton_Mesa20;
    }

    public void setBoton_Mesa20(JButton boton_Mesa20) {
        this.boton_Mesa20 = boton_Mesa20;
    }

    public JButton getBoton_Mesa21() {
        return boton_Mesa21;
    }

    public void setBoton_Mesa21(JButton boton_Mesa21) {
        this.boton_Mesa21 = boton_Mesa21;
    }

    public JButton getBoton_Mesa22() {
        return boton_Mesa22;
    }

    public void setBoton_Mesa22(JButton boton_Mesa22) {
        this.boton_Mesa22 = boton_Mesa22;
    }

    public JButton getBoton_Mesa23() {
        return boton_Mesa23;
    }

    public void setBoton_Mesa23(JButton boton_Mesa23) {
        this.boton_Mesa23 = boton_Mesa23;
    }

    public JButton getBoton_Mesa24() {
        return boton_Mesa24;
    }

    public void setBoton_Mesa24(JButton boton_Mesa24) {
        this.boton_Mesa24 = boton_Mesa24;
    }

    public JButton getBoton_Mesa3() {
        return boton_Mesa3;
    }

    public void setBoton_Mesa3(JButton boton_Mesa3) {
        this.boton_Mesa3 = boton_Mesa3;
    }

    public JButton getBoton_Mesa4() {
        return boton_Mesa4;
    }

    public void setBoton_Mesa4(JButton boton_Mesa4) {
        this.boton_Mesa4 = boton_Mesa4;
    }

    public JButton getBoton_Mesa5() {
        return boton_Mesa5;
    }

    public void setBoton_Mesa5(JButton boton_Mesa5) {
        this.boton_Mesa5 = boton_Mesa5;
    }

    public JButton getBoton_Mesa6() {
        return boton_Mesa6;
    }

    public void setBoton_Mesa6(JButton boton_Mesa6) {
        this.boton_Mesa6 = boton_Mesa6;
    }

    public JButton getBoton_Mesa7() {
        return boton_Mesa7;
    }

    public void setBoton_Mesa7(JButton boton_Mesa7) {
        this.boton_Mesa7 = boton_Mesa7;
    }

    public JButton getBoton_Mesa8() {
        return boton_Mesa8;
    }

    public void setBoton_Mesa8(JButton boton_Mesa8) {
        this.boton_Mesa8 = boton_Mesa8;
    }

    public JButton getBoton_Mesa9() {
        return boton_Mesa9;
    }

    public void setBoton_Mesa9(JButton boton_Mesa9) {
        this.boton_Mesa9 = boton_Mesa9;
    }

    public JLabel getEstado_Mesa1() {
        return estado_Mesa1;
    }

    public void setEstado_Mesa1(JLabel estado_Mesa1) {
        this.estado_Mesa1 = estado_Mesa1;
    }

    public JLabel getEstado_Mesa10() {
        return estado_Mesa10;
    }

    public void setEstado_Mesa10(JLabel estado_Mesa10) {
        this.estado_Mesa10 = estado_Mesa10;
    }

    public JLabel getEstado_Mesa11() {
        return estado_Mesa11;
    }

    public void setEstado_Mesa11(JLabel estado_Mesa11) {
        this.estado_Mesa11 = estado_Mesa11;
    }

    public JLabel getEstado_Mesa12() {
        return estado_Mesa12;
    }

    public void setEstado_Mesa12(JLabel estado_Mesa12) {
        this.estado_Mesa12 = estado_Mesa12;
    }

    public JLabel getEstado_Mesa13() {
        return estado_Mesa13;
    }

    public void setEstado_Mesa13(JLabel estado_Mesa13) {
        this.estado_Mesa13 = estado_Mesa13;
    }

    public JLabel getEstado_Mesa14() {
        return estado_Mesa14;
    }

    public void setEstado_Mesa14(JLabel estado_Mesa14) {
        this.estado_Mesa14 = estado_Mesa14;
    }

    public JLabel getEstado_Mesa15() {
        return estado_Mesa15;
    }

    public void setEstado_Mesa15(JLabel estado_Mesa15) {
        this.estado_Mesa15 = estado_Mesa15;
    }

    public JLabel getEstado_Mesa16() {
        return estado_Mesa16;
    }

    public void setEstado_Mesa16(JLabel estado_Mesa16) {
        this.estado_Mesa16 = estado_Mesa16;
    }

    public JLabel getEstado_Mesa17() {
        return estado_Mesa17;
    }

    public void setEstado_Mesa17(JLabel estado_Mesa17) {
        this.estado_Mesa17 = estado_Mesa17;
    }

    public JLabel getEstado_Mesa18() {
        return estado_Mesa18;
    }

    public void setEstado_Mesa18(JLabel estado_Mesa18) {
        this.estado_Mesa18 = estado_Mesa18;
    }

    public JLabel getEstado_Mesa19() {
        return estado_Mesa19;
    }

    public void setEstado_Mesa19(JLabel estado_Mesa19) {
        this.estado_Mesa19 = estado_Mesa19;
    }

    public JLabel getEstado_Mesa2() {
        return estado_Mesa2;
    }

    public void setEstado_Mesa2(JLabel estado_Mesa2) {
        this.estado_Mesa2 = estado_Mesa2;
    }

    public JLabel getEstado_Mesa20() {
        return estado_Mesa20;
    }

    public void setEstado_Mesa20(JLabel estado_Mesa20) {
        this.estado_Mesa20 = estado_Mesa20;
    }

    public JLabel getEstado_Mesa21() {
        return estado_Mesa21;
    }

    public void setEstado_Mesa21(JLabel estado_Mesa21) {
        this.estado_Mesa21 = estado_Mesa21;
    }

    public JLabel getEstado_Mesa22() {
        return estado_Mesa22;
    }

    public void setEstado_Mesa22(JLabel estado_Mesa22) {
        this.estado_Mesa22 = estado_Mesa22;
    }

    public JLabel getEstado_Mesa23() {
        return estado_Mesa23;
    }

    public void setEstado_Mesa23(JLabel estado_Mesa23) {
        this.estado_Mesa23 = estado_Mesa23;
    }

    public JLabel getEstado_Mesa24() {
        return estado_Mesa24;
    }

    public void setEstado_Mesa24(JLabel estado_Mesa24) {
        this.estado_Mesa24 = estado_Mesa24;
    }

    public JLabel getEstado_Mesa3() {
        return estado_Mesa3;
    }

    public void setEstado_Mesa3(JLabel estado_Mesa3) {
        this.estado_Mesa3 = estado_Mesa3;
    }

    public JLabel getEstado_Mesa4() {
        return estado_Mesa4;
    }

    public void setEstado_Mesa4(JLabel estado_Mesa4) {
        this.estado_Mesa4 = estado_Mesa4;
    }

    public JLabel getEstado_Mesa5() {
        return estado_Mesa5;
    }

    public void setEstado_Mesa5(JLabel estado_Mesa5) {
        this.estado_Mesa5 = estado_Mesa5;
    }

    public JLabel getEstado_Mesa6() {
        return estado_Mesa6;
    }

    public void setEstado_Mesa6(JLabel estado_Mesa6) {
        this.estado_Mesa6 = estado_Mesa6;
    }

    public JLabel getEstado_Mesa7() {
        return estado_Mesa7;
    }

    public void setEstado_Mesa7(JLabel estado_Mesa7) {
        this.estado_Mesa7 = estado_Mesa7;
    }

    public JLabel getEstado_Mesa8() {
        return estado_Mesa8;
    }

    public void setEstado_Mesa8(JLabel estado_Mesa8) {
        this.estado_Mesa8 = estado_Mesa8;
    }

    public JLabel getEstado_Mesa9() {
        return estado_Mesa9;
    }

    public void setEstado_Mesa9(JLabel estado_Mesa9) {
        this.estado_Mesa9 = estado_Mesa9;
    }

    public JLabel getEtiquetaEspacio1() {
        return etiquetaEspacio1;
    }

    public void setEtiquetaEspacio1(JLabel etiquetaEspacio1) {
        this.etiquetaEspacio1 = etiquetaEspacio1;
    }

    public JLabel getEtiquetaEspacio2() {
        return etiquetaEspacio2;
    }

    public void setEtiquetaEspacio2(JLabel etiquetaEspacio2) {
        this.etiquetaEspacio2 = etiquetaEspacio2;
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

}

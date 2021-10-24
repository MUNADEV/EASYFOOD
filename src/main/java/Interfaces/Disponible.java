package Interfaces;

import Diagrama.*;
import Enumeraciones.*;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Disponible extends javax.swing.JDialog {

    private boolean registrado = false;
    private String nombreCliente;
    private Restaurant restaurant;
    private int numeroMesa;

    private ListaComidas listado = new ListaComidas(this, true);

    public Disponible(java.awt.Frame parent, boolean modal, Restaurant restaurant) {
        super(parent, modal);
        apariencia();
        listado.setVisible(false);
        this.restaurant = restaurant;
        this.numeroMesa = numeroMesa;
        initComponents();

        this.boton_AceptarP2.setEnabled(false);
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
    public boolean verificarCodigo(int codigo) {

        /*
        metodo en donde se verifica si el codigo ingresado desde una 
        area te texto correponde a un codigo del menu
         */
        for (int i = 0; i < restaurant.getMesas()[numeroMesa].getMenu().getComidas().getPrincipales().size(); i++) {
            if (restaurant.getMesas()[numeroMesa].getMenu().getComidas().getPrincipales().get(i) != null) {
                if (codigo == restaurant.getMesas()[numeroMesa].getMenu().getComidas().getPrincipales().get(i).getCodigo()) {
                    return true;
                }
            }
        }
        for (int i = 0; i < restaurant.getMesas()[numeroMesa].getMenu().getComidas().getEnsaladas().size(); i++) {
            if (restaurant.getMesas()[numeroMesa].getMenu().getComidas().getEnsaladas().get(i) != null) {
                if (codigo == restaurant.getMesas()[numeroMesa].getMenu().getComidas().getEnsaladas().get(i).getCodigo()) {
                    return true;
                }
            }
        }
        for (int i = 0; i < restaurant.getMesas()[numeroMesa].getMenu().getComidas().getAgregados().size(); i++) {
            if (restaurant.getMesas()[numeroMesa].getMenu().getComidas().getAgregados().get(i) != null) {
                if (codigo == restaurant.getMesas()[numeroMesa].getMenu().getComidas().getAgregados().get(i).getCodigo()) {
                    return true;
                }
            }
        }
        for (int i = 0; i < restaurant.getMesas()[numeroMesa].getMenu().getComidas().getPostres().size(); i++) {
            if (restaurant.getMesas()[numeroMesa].getMenu().getComidas().getPostres().get(i) != null) {
                if (codigo == restaurant.getMesas()[numeroMesa].getMenu().getComidas().getPostres().get(i).getCodigo()) {
                    return true;
                }
            }
        }
        for (int i = 0; i < restaurant.getMesas()[numeroMesa].getMenu().getComidas().getBebestibles().size(); i++) {
            if (restaurant.getMesas()[numeroMesa].getMenu().getComidas().getBebestibles().get(i) != null) {
                if (codigo == restaurant.getMesas()[numeroMesa].getMenu().getComidas().getBebestibles().get(i).getCodigo()) {
                    return true;
                }
            }
        }
        for (int i = 0; i < restaurant.getMesas()[numeroMesa].getMenu().getCombos().size(); i++) {
            if (restaurant.getMesas()[numeroMesa].getMenu().getCombos().get(i) != null) {
                if (codigo == restaurant.getMesas()[numeroMesa].getMenu().getCombos().get(i).getCodigo()) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean verificadorErrorString(String palabra) {
        /*
        verifica si el string es un numero del 1 al 10 o si es distinto
         */
        int cont = 0;
        int contExito = 0;
        String temporal;
        char codigo[] = new char[palabra.length()];

        for (int i = 0; i < palabra.length(); i++) {
            codigo[i] = palabra.charAt(i);
        }

        for (int i = 0; i < palabra.length(); i++) {
            cont = 0;
            for (int j = 0; j <= 9; j++) { //numeracion
                temporal = String.valueOf(j);
                if (palabra.charAt(i) == temporal.charAt(0)) {
                    contExito++;//solo puede ser 1 exito;
                } else {
                    cont++;
                }
            }
        }
        if (contExito == (codigo.length)) {
            return true;//es un numero
        }
        return false;
    }

    public void actualizacionComidas(ListaComidas ventanaLista) {
        /*
        Metodo utilizado para imprimir la informacion en una ventana secundaria, esto
        para simplificar el proceso y tener una pre-boleta al cliente
         */
        String cadena = "";

        Boleta boleta = new Boleta(restaurant.getMesas()[numeroMesa].getCliente()); //CREA LA BOLETA "SOBREESCRIBIENDOLA"
        cadena += boleta.listaComidas();//ACCEDE AL STRING DE LA CLASE BOLETA PARA OBTENER LA COTIZACION PREVIA
        double precio = 0;//CAMBIAR A INT?
        //Los ciclos for se utilizan para obtener el precio de lo que escogio el cliente, lo obtiene de la clase cliente->pedidos->clase de comida->precio
        for (int i = 0; i < restaurant.getMesas()[numeroMesa].getCliente().getPedidos().get(i).getPrincipales().size(); i++) {
            precio = precio + restaurant.getMesas()[numeroMesa].getCliente().getPedidos().get(i).getPrincipales().get(i).getPrecio();
        }
        for (int i = 0; i < restaurant.getMesas()[numeroMesa].getCliente().getPedidos().get(i).getEnsaladas().size(); i++) {
            precio = precio + restaurant.getMesas()[numeroMesa].getCliente().getPedidos().get(i).getEnsaladas().get(i).getPrecio();
        }
        for (int i = 0; i < restaurant.getMesas()[numeroMesa].getCliente().getPedidos().get(i).getAgregados().size(); i++) {
            precio = precio + restaurant.getMesas()[numeroMesa].getCliente().getPedidos().get(i).getAgregados().get(i).getPrecio();
        }
        for (int i = 0; i < restaurant.getMesas()[numeroMesa].getCliente().getPedidos().get(i).getPostres().size(); i++) {
            precio = precio + restaurant.getMesas()[numeroMesa].getCliente().getPedidos().get(i).getPostres().get(i).getPrecio();
        }
        for (int i = 0; i < restaurant.getMesas()[numeroMesa].getCliente().getPedidos().get(i).getBebestibles().size(); i++) {
            precio = precio + restaurant.getMesas()[numeroMesa].getCliente().getPedidos().get(i).getBebestibles().get(i).getPrecio();
        }

        ventanaLista.getAreaTexto().setText(cadena);//ACTUALIZA LA VENTANA DE COTIZACION PREVIA

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new javax.swing.JPanel();
        etiqueta_ClienteP1 = new javax.swing.JLabel();
        boton_IngresarP1 = new javax.swing.JToggleButton();
        areaTextoP1 = new javax.swing.JTextField();
        panel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaMenu = new javax.swing.JTable();
        areaTextoP2 = new javax.swing.JTextField();
        boton_IngresarP2 = new javax.swing.JToggleButton();
        etiqueta_IngresarP2 = new javax.swing.JLabel();
        etiqueta_ClienteP2 = new javax.swing.JLabel();
        boton_AceptarP2 = new javax.swing.JButton();
        boton_CancelarP2 = new javax.swing.JButton();
        etiqueta_ErrorP2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setBounds(new java.awt.Rectangle(15, 15, 930, 630));
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setMinimumSize(new java.awt.Dimension(930, 630));
        setName("Disponible"); // NOI18N

        panel1.setMaximumSize(new java.awt.Dimension(400, 400));
        panel1.setMinimumSize(new java.awt.Dimension(320, 260));
        panel1.setPreferredSize(new java.awt.Dimension(320, 260));

        etiqueta_ClienteP1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        etiqueta_ClienteP1.setText("Cliente");

        boton_IngresarP1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        boton_IngresarP1.setText("Ingresar");
        boton_IngresarP1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_IngresarP1ActionPerformed(evt);
            }
        });

        areaTextoP1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                areaTextoP1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(etiqueta_ClienteP1))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(areaTextoP1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(boton_IngresarP1)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap(55, Short.MAX_VALUE)
                .addComponent(etiqueta_ClienteP1)
                .addGap(18, 18, 18)
                .addComponent(areaTextoP1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(boton_IngresarP1)
                .addGap(83, 83, 83))
        );

        panel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panel2.setMaximumSize(new java.awt.Dimension(500, 380));
        panel2.setMinimumSize(new java.awt.Dimension(490, 350));
        panel2.setPreferredSize(new java.awt.Dimension(500, 400));

        tablaMenu.setAutoCreateRowSorter(true);
        tablaMenu.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        tablaMenu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Comida", "Precio", "Codigo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaMenu.setColumnSelectionAllowed(true);
        tablaMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane2.setViewportView(tablaMenu);
        tablaMenu.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        if (tablaMenu.getColumnModel().getColumnCount() > 0) {
            tablaMenu.getColumnModel().getColumn(0).setPreferredWidth(250);
            tablaMenu.getColumnModel().getColumn(1).setResizable(false);
            tablaMenu.getColumnModel().getColumn(1).setPreferredWidth(5);
            tablaMenu.getColumnModel().getColumn(2).setResizable(false);
            tablaMenu.getColumnModel().getColumn(2).setPreferredWidth(5);
        }

        areaTextoP2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                areaTextoP2ActionPerformed(evt);
            }
        });

        boton_IngresarP2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        boton_IngresarP2.setText("Ingresar");
        boton_IngresarP2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_IngresarP2ActionPerformed(evt);
            }
        });

        etiqueta_IngresarP2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        etiqueta_IngresarP2.setText("Ingrese el codigo del producto");

        etiqueta_ClienteP2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        etiqueta_ClienteP2.setText("Cliente");

        boton_AceptarP2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        boton_AceptarP2.setText("Aceptar");
        boton_AceptarP2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_AceptarP2ActionPerformed(evt);
            }
        });

        boton_CancelarP2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        boton_CancelarP2.setText("Cancelar");
        boton_CancelarP2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_CancelarP2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 603, Short.MAX_VALUE)
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addComponent(areaTextoP2, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(boton_IngresarP2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(etiqueta_ErrorP2)
                        .addContainerGap())))
            .addGroup(panel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(etiqueta_IngresarP2)
                    .addComponent(etiqueta_ClienteP2, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(boton_CancelarP2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(boton_AceptarP2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(180, 180, 180))
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(etiqueta_ClienteP2)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(etiqueta_IngresarP2)
                        .addGap(18, 18, 18)
                        .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(areaTextoP2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boton_IngresarP2)
                            .addComponent(etiqueta_ErrorP2))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(187, Short.MAX_VALUE))
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(boton_CancelarP2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boton_AceptarP2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(109, 109, 109))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 946, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(315, 315, 315)
                    .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(311, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(210, 210, 210)
                    .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, 615, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(121, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 630, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(183, 183, 183)
                    .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(187, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(45, 45, 45)
                    .addComponent(panel2, javax.swing.GroupLayout.DEFAULT_SIZE, 579, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boton_IngresarP1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_IngresarP1ActionPerformed

        if (areaTextoP1.getText() == null || " ".equals(areaTextoP1.getText()) || "".equals(areaTextoP1.getText())) {
            etiqueta_ClienteP1.setText("Ingrese algún nombre valido");//primera verificacion del nombre
        } else {
            this.nombreCliente = areaTextoP1.getText();
            restaurant.getMesas()[numeroMesa].setCliente(new Cliente());//asocia el cliente a la mesa del restaurant6
            restaurant.getMesas()[numeroMesa].setEstado(Estados.EN_ESPERA.getEstado());
            restaurant.getMesas()[numeroMesa].getCliente().setNombre(nombreCliente);
            //Boton aceptar

            panel1.setVisible(false);//si es correcto, se oculta el panel de pedido de nombre
            restaurant.getMesas()[numeroMesa].getCliente().setNumeroMesa(numeroMesa);

            etiqueta_ClienteP2.setText("Cliente: " + nombreCliente);
            restaurant.getMesas()[numeroMesa].setEstado(Estados.EN_ESPERA.getEstado());

            panel2.setVisible(true);//luego de que este todo correcto, se muestra el panel2 con nuevas indicaciones
        }

    }//GEN-LAST:event_boton_IngresarP1ActionPerformed

    private void areaTextoP1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_areaTextoP1ActionPerformed

    }//GEN-LAST:event_areaTextoP1ActionPerformed

    private void areaTextoP2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_areaTextoP2ActionPerformed


    }//GEN-LAST:event_areaTextoP2ActionPerformed

    private void boton_IngresarP2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_IngresarP2ActionPerformed
        etiqueta_ErrorP2.setText("");

        if (verificadorErrorString(areaTextoP2.getText()) == false) {//verifica si es un número, si lo es:
            etiqueta_ErrorP2.setText("Error: No es un número");
            areaTextoP2.setText(null);
            this.boton_AceptarP2.setEnabled(false);

        } else if (verificarCodigo(Integer.parseInt(areaTextoP2.getText())) == true) {//verifica si es error:
            etiqueta_ErrorP2.setText("");

            restaurant.getMesas()[numeroMesa].getCliente().getPedidos().add(restaurant.getMesas()[numeroMesa].
                    getCliente().agregarComida(numeroMesa, Integer.parseInt(areaTextoP2.getText()), restaurant));//aqui se le agrega la comida al cliente de la mesa, la mesa del restaurant

            areaTextoP2.setText(null);
            etiqueta_ClienteP2.setText("Cliente: " + nombreCliente);

            actualizacionComidas(listado);//listado es la clase ListaComidsa, por lo que mostrará los datos del pedido a confirmar en otra ventana
            listado.setVisible(true);
            
            this.boton_AceptarP2.setEnabled(true);
        } else {
            //sino es un codigo, entonces:
            etiqueta_ErrorP2.setText("");
            etiqueta_ErrorP2.setText("Error: Codigo invalido");
            areaTextoP2.setText(null);
            this.boton_AceptarP2.setEnabled(false);
        }

    }//GEN-LAST:event_boton_IngresarP2ActionPerformed

    private void boton_AceptarP2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_AceptarP2ActionPerformed

        if (restaurant.getMesas()[numeroMesa].getCliente().getPedidos() != null) { //SI LOS PEDIDOS DEL CLIENTE SON NULOS

            this.registrado = true;//se activa el interruptor de que fue un exito todo
            listado.dispose();
            this.dispose();
        }

    }//GEN-LAST:event_boton_AceptarP2ActionPerformed

    private void boton_CancelarP2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_CancelarP2ActionPerformed

        restaurant.getMesas()[numeroMesa].setEstado(Estados.DISPONIBLE.getEstado());//cambio del estado de la mesa a de nuevo disponible
        this.listado.dispose();
        this.dispose();
    }//GEN-LAST:event_boton_CancelarP2ActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Disponible.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Disponible.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Disponible.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Disponible.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Disponible dialog = new Disponible(new javax.swing.JFrame(), true, new Restaurant());
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField areaTextoP1;
    private javax.swing.JTextField areaTextoP2;
    private javax.swing.JButton boton_AceptarP2;
    private javax.swing.JButton boton_CancelarP2;
    private javax.swing.JToggleButton boton_IngresarP1;
    private javax.swing.JToggleButton boton_IngresarP2;
    private javax.swing.JLabel etiqueta_ClienteP1;
    private javax.swing.JLabel etiqueta_ClienteP2;
    private javax.swing.JLabel etiqueta_ErrorP2;
    private javax.swing.JLabel etiqueta_IngresarP2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel panel1;
    private javax.swing.JPanel panel2;
    private javax.swing.JTable tablaMenu;
    // End of variables declaration//GEN-END:variables

    //getters and setters
    public ListaComidas getListado() {
        return listado;
    }

    public void setListado(ListaComidas listado) {
        this.listado = listado;
    }

    public javax.swing.JTextField getAreaTextoP1() {
        return areaTextoP1;
    }

    public void setAreaTextoP1(javax.swing.JTextField areaTextoP1) {
        this.areaTextoP1 = areaTextoP1;
    }

    public javax.swing.JTextField getAreaTextoP2() {
        return areaTextoP2;
    }

    public void setAreaTextoP2(javax.swing.JTextField areaTextoP2) {
        this.areaTextoP2 = areaTextoP2;
    }

    public javax.swing.JButton getBoton_AceptarP2() {
        return boton_AceptarP2;
    }

    public void setBoton_AceptarP2(javax.swing.JButton boton_AceptarP2) {
        this.boton_AceptarP2 = boton_AceptarP2;
    }

    public javax.swing.JButton getBoton_CancelarP2() {
        return boton_CancelarP2;
    }

    public void setBoton_CancelarP2(javax.swing.JButton boton_CancelarP2) {
        this.boton_CancelarP2 = boton_CancelarP2;
    }

    public javax.swing.JToggleButton getBoton_IngresarP1() {
        return boton_IngresarP1;
    }

    public void setBoton_IngresarP1(javax.swing.JToggleButton boton_IngresarP1) {
        this.boton_IngresarP1 = boton_IngresarP1;
    }

    public javax.swing.JToggleButton getBoton_IngresarP2() {
        return boton_IngresarP2;
    }

    public void setBoton_IngresarP2(javax.swing.JToggleButton boton_IngresarP2) {
        this.boton_IngresarP2 = boton_IngresarP2;
    }

    public javax.swing.JLabel getEtiqueta_ClienteP1() {
        return etiqueta_ClienteP1;
    }

    public void setEtiqueta_ClienteP1(javax.swing.JLabel etiqueta_ClienteP1) {
        this.etiqueta_ClienteP1 = etiqueta_ClienteP1;
    }

    public javax.swing.JLabel getEtiqueta_ErrorP2() {
        return etiqueta_ErrorP2;
    }

    public void setEtiqueta_ErrorP2(javax.swing.JLabel etiqueta_ErrorP2) {
        this.etiqueta_ErrorP2 = etiqueta_ErrorP2;
    }

    public javax.swing.JLabel getEtiqueta_IngresarP2() {
        return etiqueta_IngresarP2;
    }

    public void setEtiqueta_IngresarP2(javax.swing.JLabel etiqueta_IngresarP2) {
        this.etiqueta_IngresarP2 = etiqueta_IngresarP2;
    }

    public javax.swing.JScrollPane getjScrollPane2() {
        return jScrollPane2;
    }

    public void setjScrollPane2(javax.swing.JScrollPane jScrollPane2) {
        this.jScrollPane2 = jScrollPane2;
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

    public boolean isRegistrado() {
        return registrado;
    }

    public void setBandera(boolean bandera) {
        this.registrado = bandera;
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public void setPanel1(JPanel panel1) {
        this.panel1 = panel1;
    }

    public JPanel getPanel2() {
        return panel2;
    }

    public void setPanel2(JPanel panel2) {
        this.panel2 = panel2;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public JTable getTablaMenu() {
        return tablaMenu;
    }

    public void setTablaMenu(JTable tablaMenu) {
        this.tablaMenu = tablaMenu;
    }

    public JLabel getEtiqueta_ClienteP2() {
        return etiqueta_ClienteP2;

    }

}

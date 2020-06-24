package graficos;

import arbolB.estructura;
import arbolB.obtenerCamino;
import grafo.lugares;
import grafo.origen;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import manejadorArchivo.salidaArbol;
import manejadorArchivo.salidaMapa;

public class principal extends javax.swing.JFrame {

    public principal() {
        initComponents();
        setListadosSegunMovilidad(0);
        botonMapaPanel.setToolTipText("No cargara imagenes de gran cantidad, usar boton de abrir mapa en editor.");
        panelMapa.setToolTipText("Se mostrar el mapa en caso sea de cantidad moderada");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dialogoEntrada = new javax.swing.JDialog();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        textoArchivoEntrada = new javax.swing.JTextArea();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        botonMapaPanel = new javax.swing.JButton();
        labelMapa = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        radioAuto = new javax.swing.JRadioButton();
        radioCaminando = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        listaPosicionActual = new javax.swing.JComboBox<>();
        botonAux = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        listaDestino = new javax.swing.JComboBox<>();
        listadoMejorRuta = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        radioMejorRuta = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        botonObtenerRuta = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        areaRutasRecorridas = new javax.swing.JTextArea();
        panelMapa = new javax.swing.JTabbedPane();
        jButton3 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        dialogoEntrada.setSize(new java.awt.Dimension(936, 441));

        jButton1.setText("Aceptar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        textoArchivoEntrada.setColumns(20);
        textoArchivoEntrada.setFont(new java.awt.Font("Padauk", 0, 24)); // NOI18N
        textoArchivoEntrada.setRows(5);
        jScrollPane1.setViewportView(textoArchivoEntrada);

        javax.swing.GroupLayout dialogoEntradaLayout = new javax.swing.GroupLayout(dialogoEntrada.getContentPane());
        dialogoEntrada.getContentPane().setLayout(dialogoEntradaLayout);
        dialogoEntradaLayout.setHorizontalGroup(
            dialogoEntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogoEntradaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dialogoEntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dialogoEntradaLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 912, Short.MAX_VALUE))
                .addContainerGap())
        );
        dialogoEntradaLayout.setVerticalGroup(
            dialogoEntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dialogoEntradaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        botonMapaPanel.setText("Ver Mapa");
        botonMapaPanel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonMapaPanelActionPerformed(evt);
            }
        });

        labelMapa.setFont(new java.awt.Font("Open Sans Extrabold", 0, 17)); // NOI18N
        labelMapa.setForeground(new java.awt.Color(214, 33, 33));

        jLabel1.setText("Tipo movilizacion:");

        buttonGroup1.add(radioAuto);
        radioAuto.setSelected(true);
        radioAuto.setText("Automovil");
        radioAuto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioAutoActionPerformed(evt);
            }
        });

        buttonGroup1.add(radioCaminando);
        radioCaminando.setText("Caminando");
        radioCaminando.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioCaminandoActionPerformed(evt);
            }
        });

        jLabel2.setText("Ubicacion actual:");

        botonAux.setText("Ver rutas");
        botonAux.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAuxActionPerformed(evt);
            }
        });

        jLabel3.setText("Destino:");

        jLabel4.setText("Obtener Segun:");

        buttonGroup2.add(radioMejorRuta);
        radioMejorRuta.setSelected(true);
        radioMejorRuta.setText("Mejor Ruta");

        buttonGroup2.add(jRadioButton2);
        jRadioButton2.setText("Peor Ruta");

        botonObtenerRuta.setText("Obtener Ruta");
        botonObtenerRuta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonObtenerRutaActionPerformed(evt);
            }
        });

        areaRutasRecorridas.setEditable(false);
        areaRutasRecorridas.setColumns(20);
        areaRutasRecorridas.setFont(new java.awt.Font("Open Sans Light", 1, 18)); // NOI18N
        areaRutasRecorridas.setRows(5);
        jScrollPane2.setViewportView(areaRutasRecorridas);

        jButton3.setText("Cargar Mapa a editor");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jMenu1.setText("Archivo");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Abrir");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(botonMapaPanel)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelMapa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botonAux)
                .addGap(32, 32, 32))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(radioAuto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(radioCaminando)
                        .addGap(24, 24, 24)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(listaPosicionActual, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(listaDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 214, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(listadoMejorRuta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(botonObtenerRuta))
                            .addComponent(jLabel4)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(radioMejorRuta)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButton2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2)))
                .addContainerGap())
            .addComponent(panelMapa)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonMapaPanel)
                    .addComponent(labelMapa)
                    .addComponent(botonAux)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelMapa, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(radioAuto)
                    .addComponent(radioCaminando)
                    .addComponent(jLabel2)
                    .addComponent(listaPosicionActual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(listaDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(listadoMejorRuta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonObtenerRuta))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(radioMejorRuta)
                            .addComponent(jRadioButton2))
                        .addGap(0, 96, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        String ruta = manejadorArchivo.manejador.fileChooser();
        if (ruta != null) {
            textoArchivoEntrada.setText("");
            List<String> entradaTexto = manejadorArchivo.manejador.recuperarTexto(ruta);
            for (int i = 0; i < entradaTexto.size(); i++) {
                textoArchivoEntrada.setText(textoArchivoEntrada.getText() + entradaTexto.get(i) + "\n");
            }
            dialogoEntrada.setVisible(true);
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed
    private origen origenes[];
    private List<String> datosOrigen;
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (!textoArchivoEntrada.getText().isEmpty()) {
            int opcion = JOptionPane.showConfirmDialog(null, "Desea guardar cambios?");
            if (opcion == JOptionPane.YES_OPTION) {
                manejadorArchivo.manejador.voidGuardarArchivo(textoArchivoEntrada.getText());
            }
            lugares manejadorLugares = new lugares(textoArchivoEntrada);
            listaPosicionActual = manejadorLugares.listados(listaPosicionActual);
            listaDestino = manejadorLugares.listados(listaDestino);
            origenes = manejadorLugares.getOrigenes();
            datosOrigen = manejadorLugares.getDatosOrigen();
            dialogoEntrada.setVisible(false);
            graphiz.GraphvizJava.dibujar("../mapa.dot", "../mapa.png");
        } else if (JOptionPane.showConfirmDialog(null, "No se analizara nada, desea continuar?") == 0) {
            dialogoEntrada.setVisible(false);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void botonMapaPanelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMapaPanelActionPerformed
        try {
            if (origenes != null) {
                panelMapa.removeAll();
                panelMapa.add("Mapa", new panel("mapa"));
                panelMapa.repaint();
                panelMapa.setVisible(true);
        } else {
            labelMapa.setText("No se ha ingresado algun mapa aun");
        }
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Error en imagen se cargara desde el editor");
            manejadorArchivo.manejador.abrirArchivo1("../mapa.png");
        }
    }//GEN-LAST:event_botonMapaPanelActionPerformed

    private void botonAuxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAuxActionPerformed
        //double datos[] = {10,20,30,40,50,60,70,80,90,100,110,120,130,140,150,160,170};
        double datos[] = {170,160,150,140,130,120,110,100,90,80,70,60,50,40,30,20,10,9,8,7};
        arbolB.estructura insertar[] = new estructura[5];
        for (int i = 0; i < datos.length; i++) {
            insertar = arbolB.insertar.insetarDato(datos[i], insertar, false, null);
        }
        String salida = salidaArbol.estructurarDot(insertar,"",0,0);
        graphiz.GraphvizJava.dibujar("../arbol.dot", "../arbol.png");
        System.out.println("termino");
        //salidaArbol.escribirArbol(insertar);
    }//GEN-LAST:event_botonAuxActionPerformed
    private void setListadosSegunMovilidad(int tipo) {
        //tipo 0 es carro tipo 1 es persona
        listadoMejorRuta.removeAllItems();
        switch (tipo) {
            case 0:
                listadoMejorRuta.addItem("Tiempo en Vehiculo");
                listadoMejorRuta.addItem("Consumo en Vehiculo");
                listadoMejorRuta.addItem("Distancia");
                break;
            case 1:
                listadoMejorRuta.addItem("Tiempo caminando");
                listadoMejorRuta.addItem("Consumo Caminando");
                listadoMejorRuta.addItem("Distancia");
                break;
        }
    }
    private void radioAutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioAutoActionPerformed
        setListadosSegunMovilidad(0);
    }//GEN-LAST:event_radioAutoActionPerformed

    private void radioCaminandoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioCaminandoActionPerformed
        setListadosSegunMovilidad(1);
    }//GEN-LAST:event_radioCaminandoActionPerformed

    private void botonObtenerRutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonObtenerRutaActionPerformed
        origen aux = null;
        if(origenes!=null)aux = grafo.manejador.buscarOrigen(listaPosicionActual.getSelectedItem().toString(), origenes);
        int posicionFinal [] = new int[3];
        arbolB.estructura entrada[] = null;
        ArrayList<String> ruta = null;
        String errorRuta = null;
        boolean banderaCaminando = false;
        if (aux != null) {
            entrada = grafo.manejador.getRutas(datosOrigen, listaPosicionActual.getSelectedItem().toString(), origenes, listaDestino.getSelectedItem().toString(), aux, 0, radioAuto.isSelected());
            if (entrada[0] != null) {
                ruta=(obtenerCamino.obtenerRuta(entrada, radioMejorRuta.isSelected()));
                posicionFinal[0]=ruta.size()-1;
                //salidaArbol.escribirArbol(entrada);
            }
            entrada = grafo.manejador.getRutas(datosOrigen, listaPosicionActual.getSelectedItem().toString(), origenes, listaDestino.getSelectedItem().toString(), aux, 1, radioAuto.isSelected());
            if (entrada[0] != null) {
                ruta.addAll(obtenerCamino.obtenerRuta(entrada, radioMejorRuta.isSelected()));
                posicionFinal[1]=ruta.size()-1;
                //salidaArbol.escribirArbol(entrada);
            }
            
            entrada = grafo.manejador.getRutas(datosOrigen, listaPosicionActual.getSelectedItem().toString(), origenes, listaDestino.getSelectedItem().toString(), aux, 2, radioAuto.isSelected());
            if (entrada[0] != null) {
                ruta.addAll(obtenerCamino.obtenerRuta(entrada, radioMejorRuta.isSelected()));
                posicionFinal[2]=ruta.size()-1;
            }else if (radioCaminando.isSelected()) {
            aux = grafo.manejador.buscarOrigen(listaDestino.getSelectedItem().toString(), origenes);
            entrada = grafo.manejador.getRutas(datosOrigen, listaDestino.getSelectedItem().toString(), origenes, listaPosicionActual.getSelectedItem().toString(), aux, 0, radioAuto.isSelected());
                if (entrada[0] != null && aux != null) {
                    if (entrada[0] != null) {
                    ruta=(obtenerCamino.obtenerRuta(entrada, radioMejorRuta.isSelected()));
                    posicionFinal[0]=ruta.size()-1;
                    //salidaArbol.escribirArbol(entrada);
                }
                entrada = grafo.manejador.getRutas(datosOrigen, listaDestino.getSelectedItem().toString(), origenes, listaPosicionActual.getSelectedItem().toString(), aux, 1, radioAuto.isSelected());
                if (entrada[0] != null) {
                    ruta.addAll(obtenerCamino.obtenerRuta(entrada, radioMejorRuta.isSelected()));
                    posicionFinal[1]=ruta.size()-1;
                    //salidaArbol.escribirArbol(entrada);
                }

                entrada = grafo.manejador.getRutas(datosOrigen, listaDestino.getSelectedItem().toString(), origenes, listaPosicionActual.getSelectedItem().toString(), aux, 2, radioAuto.isSelected());
                if (entrada[0] != null) {
                    ruta.addAll(obtenerCamino.obtenerRuta(entrada, radioMejorRuta.isSelected()));
                    posicionFinal[2]=ruta.size()-1;
                }
                banderaCaminando = true;
            } else {
                errorRuta = "No existe Ruta";
            }
        }            
        } else if (radioCaminando.isSelected()) {
            aux = grafo.manejador.buscarOrigen(listaDestino.getSelectedItem().toString(), origenes);
            entrada = grafo.manejador.getRutas(datosOrigen, listaDestino.getSelectedItem().toString(), origenes, listaPosicionActual.getSelectedItem().toString(), aux, 0, radioAuto.isSelected());
                if (entrada[0] != null && aux != null) {
                    if (entrada[0] != null) {
                    ruta=(obtenerCamino.obtenerRuta(entrada, radioMejorRuta.isSelected()));
                    posicionFinal[0]=ruta.size()-1;
                    //salidaArbol.escribirArbol(entrada);
                }
                entrada = grafo.manejador.getRutas(datosOrigen, listaDestino.getSelectedItem().toString(), origenes, listaPosicionActual.getSelectedItem().toString(), aux, 1, radioAuto.isSelected());
                if (entrada[0] != null) {
                    ruta.addAll(obtenerCamino.obtenerRuta(entrada, radioMejorRuta.isSelected()));
                    posicionFinal[1]=ruta.size()-1;
                    //salidaArbol.escribirArbol(entrada);
                }

                entrada = grafo.manejador.getRutas(datosOrigen, listaDestino.getSelectedItem().toString(), origenes, listaPosicionActual.getSelectedItem().toString(), aux, 2, radioAuto.isSelected());
                if (entrada[0] != null) {
                    ruta.addAll(obtenerCamino.obtenerRuta(entrada, radioMejorRuta.isSelected()));
                    posicionFinal[2]=ruta.size()-1;
                }
                banderaCaminando = true;
            } else {
                errorRuta = "No existe Ruta";
            }
        } else {
            errorRuta = "No existe ruta";
        }
        String informeAterior = areaRutasRecorridas.getText();
        if(errorRuta!=null)areaRutasRecorridas.setText(informeAterior+errorRuta+"\n");
        if(ruta!=null){
            if(radioCaminando.isSelected()){
                if(banderaCaminando)ruta = obtenerCamino.invertidor(ruta,posicionFinal);
                salidaMapa.escribirMapa_Mejor_Peor_Ruta(ruta,posicionFinal,"Persona");
                graphiz.GraphvizJava.dibujar("../mapaPersona.dot","../mapaPersona.png");
            }else{
                salidaMapa.escribirMapa_Mejor_Peor_Ruta(ruta,posicionFinal,"Vehiculo");
                graphiz.GraphvizJava.dibujar("../mapaVehiculo.dot","../mapaVehiculo.png");
            }
        }else areaRutasRecorridas.setText(informeAterior+errorRuta+"\n");
    }//GEN-LAST:event_botonObtenerRutaActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if(origenes!=null)manejadorArchivo.manejador.abrirArchivo1("../mapa.png");
    }//GEN-LAST:event_jButton3ActionPerformed

    public origen[] getOrigenes() {
        return origenes;
    }

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaRutasRecorridas;
    private javax.swing.JButton botonAux;
    private javax.swing.JButton botonMapaPanel;
    private javax.swing.JButton botonObtenerRuta;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JDialog dialogoEntrada;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelMapa;
    private javax.swing.JComboBox<String> listaDestino;
    private javax.swing.JComboBox<String> listaPosicionActual;
    private javax.swing.JComboBox<String> listadoMejorRuta;
    private javax.swing.JTabbedPane panelMapa;
    private javax.swing.JRadioButton radioAuto;
    private javax.swing.JRadioButton radioCaminando;
    private javax.swing.JRadioButton radioMejorRuta;
    private javax.swing.JTextArea textoArchivoEntrada;
    // End of variables declaration//GEN-END:variables
}

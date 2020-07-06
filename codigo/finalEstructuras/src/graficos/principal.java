package graficos;

import arbolB.estructura;
import arbolB.obtenerCamino;
import grafo.lugares;
import grafo.origen;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import manejadorArchivo.salidaArbol;
import manejadorArchivo.salidaMapa;
import rutaFav.rutaFavorita;

public class principal extends javax.swing.JFrame {

    public principal() {
        initComponents();
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
        radioMejorRuta = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        botonObtenerRuta = new javax.swing.JButton();
        panelMapa = new javax.swing.JTabbedPane();
        jButton3 = new javax.swing.JButton();
        labelErrorRuta = new javax.swing.JLabel();
        listadoRutasFav = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

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

        buttonGroup2.add(radioMejorRuta);
        radioMejorRuta.setForeground(new java.awt.Color(181, 155, 155));
        radioMejorRuta.setSelected(true);
        radioMejorRuta.setText("Mejor Ruta");

        buttonGroup2.add(jRadioButton2);
        jRadioButton2.setForeground(new java.awt.Color(176, 157, 157));
        jRadioButton2.setText("Peor Ruta");

        botonObtenerRuta.setText("Obtener Ruta");
        botonObtenerRuta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonObtenerRutaActionPerformed(evt);
            }
        });

        jButton3.setText("Cargar Mapa a editor");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        listadoRutasFav.setFont(new java.awt.Font("Open Sans Extrabold", 0, 18)); // NOI18N

        jLabel4.setText("Rutas favoritas");

        jButton2.setText("Ver Arbol");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
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

        jMenu2.setText("Ayuda");

        jMenuItem2.setText("No carga el mapa");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuBar1.add(jMenu2);

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
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(listadoRutasFav, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botonAux)
                .addGap(32, 32, 32))
            .addComponent(panelMapa)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(401, 401, 401)
                        .addComponent(labelErrorRuta))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(botonObtenerRuta))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
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
                                .addComponent(listaDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(radioMejorRuta)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButton2)))))
                .addContainerGap(139, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonMapaPanel)
                    .addComponent(labelMapa)
                    .addComponent(botonAux)
                    .addComponent(jButton3)
                    .addComponent(listadoRutasFav, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelMapa, javax.swing.GroupLayout.PREFERRED_SIZE, 602, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelErrorRuta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(radioAuto)
                    .addComponent(radioCaminando)
                    .addComponent(jLabel2)
                    .addComponent(listaPosicionActual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(listaDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonObtenerRuta)
                    .addComponent(radioMejorRuta)
                    .addComponent(jRadioButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        double datos[] = {10,11,12,13,14,15,16,20,30,40,50,60,70,80,90,100,110,120,130,140,150,160,170,0,1,2,3,4,5,6,7,21,22,23,24,25,26,27};
        arbolB.estructura insertar[] = new estructura[5];
        for (int i = 0; i < datos.length; i++) {
            insertar = arbolB.insertar.insetarDato(datos[i], insertar, false, null);
        }
        salidaArbol.estructurarDot(insertar);
        graphiz.GraphvizJava.dibujar("../arbol.dot", "../arbol.png");
        System.out.println("termino");
        //salidaArbol.escribirArbol(insertar);
    }//GEN-LAST:event_botonAuxActionPerformed
    
    private void radioAutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioAutoActionPerformed
        
    }//GEN-LAST:event_radioAutoActionPerformed

    private void radioCaminandoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioCaminandoActionPerformed
        
    }//GEN-LAST:event_radioCaminandoActionPerformed
    private ArrayList<String> rutasFavoritas = new ArrayList<>();
    private ArrayList<Integer> contadorRutasFavoritas = new ArrayList<>();
    private rutaFavorita rutasFav = null;
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
            }
        } 
        if(ruta!=null){
            salidaArbol.estructurarDot(entrada);
            labelErrorRuta.setText("");
            String nombreImagen;
            if(radioCaminando.isSelected()){
                if(banderaCaminando)ruta = obtenerCamino.invertidor(ruta,posicionFinal);
                if(rutasFavoritas.contains(ruta))
                salidaMapa.escribirMapa_Mejor_Peor_Ruta(ruta,posicionFinal,"Persona");
                graphiz.GraphvizJava.dibujar("../mapaPersona.dot","../mapaPersona.png");
                nombreImagen = "mapaPersona";
                rutasFav = rutaFavorita.verificarRuta(listaDestino.getSelectedItem().toString()+"-"+listaPosicionActual.getSelectedItem().toString(), rutasFav);
            }else{
                salidaMapa.escribirMapa_Mejor_Peor_Ruta(ruta,posicionFinal,"Vehiculo");
                graphiz.GraphvizJava.dibujar("../mapaVehiculo.dot","../mapaVehiculo.png");
                nombreImagen = "mapaVehiculo";
                rutasFav = rutaFavorita.verificarRuta(listaPosicionActual.getSelectedItem().toString()+"-"+listaDestino.getSelectedItem().toString(), rutasFav);
            }
            try {
                Thread.sleep(250);
            } catch (InterruptedException ex) {
                Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
            }            
            if(origenes!=null)manejadorArchivo.manejador.abrirArchivo1("../"+nombreImagen+".png");
            graphiz.GraphvizJava.dibujar("../arbol.dot", "../arbol.png");
        }else {
            labelErrorRuta.setText("No existe ruta");            
        }
        insertarListaFav();
    }//GEN-LAST:event_botonObtenerRutaActionPerformed
    
    private void insertarListaFav(){
        rutasFavoritas = rutaFavorita.rutasFav(rutasFav, rutasFavoritas);
        listadoRutasFav.removeAllItems();
        for (int i = 0; i < rutasFavoritas.size(); i++) {
            listadoRutasFav.addItem(rutasFavoritas.get(i));
        }
        if(rutasFavoritas.size()==0){
            listadoRutasFav.addItem("Sin rutas fav");
        }
    }
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if(origenes!=null)manejadorArchivo.manejador.abrirArchivo1("../mapa.png");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        JOptionPane.showMessageDialog(null, "Si la imagen es muy grande no podra ser vista en el panel, debera cargar a su editor de imagenes");
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        manejadorArchivo.manejador.abrirArchivo1("../arbol.png");
    }//GEN-LAST:event_jButton2ActionPerformed

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
    private javax.swing.JButton botonAux;
    private javax.swing.JButton botonMapaPanel;
    private javax.swing.JButton botonObtenerRuta;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JDialog dialogoEntrada;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelErrorRuta;
    private javax.swing.JLabel labelMapa;
    private javax.swing.JComboBox<String> listaDestino;
    private javax.swing.JComboBox<String> listaPosicionActual;
    private javax.swing.JComboBox<String> listadoRutasFav;
    private javax.swing.JTabbedPane panelMapa;
    private javax.swing.JRadioButton radioAuto;
    private javax.swing.JRadioButton radioCaminando;
    private javax.swing.JRadioButton radioMejorRuta;
    private javax.swing.JTextArea textoArchivoEntrada;
    // End of variables declaration//GEN-END:variables
}

package Capa_Presentacion;

import Capa_Negocio.neg_personalTropa;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;



public final class frmPersonalTropa extends javax.swing.JFrame {

   
    private neg_personalTropa negocioTropa = new neg_personalTropa();
    
    public frmPersonalTropa() {
        initComponents();
        this.setLocationRelativeTo(this);
        lblSerie.setText("T-" + String.format("%08d", negocioTropa.contarPersonal() + 1));
        cargarTabla();
    }

   
   private Date obtenerFecha(String fechaTexto) {
        try {
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            return formato.parse(fechaTexto);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Fecha inválida. Use el formato aaaa-mm-dd.");
            return null;
        }
    }
   
   private void limpiarCampos() {
        lblSerie.setText("");
        txtnomape.setText("");
        txtFecNac.setText("");
        cboRango.setSelectedIndex(0);
        txtAño_promo.setText("");
        cboMesPromo.setSelectedIndex(0);
        cboCuerpo.setSelectedIndex(0);
        cboGrupoAereo.setSelectedIndex(0);
    }
   
    private void cargarTabla() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new String[]{"Serie", "Nombre", "Fecha Nac", "Rango", "Año Promo", "Mes Promo", "Cuerpo", "Grupo Aereo"});
        
        negocioTropa.listarPersonal().forEach(tropa -> {
            modelo.addRow(new Object[]{
                tropa.getIdTropa(),
                tropa.getNomApe(),
                new SimpleDateFormat("yyyy-MM-dd").format(tropa.getFechaNac()),
                tropa.getRango(),
                tropa.getaPromo(),
                tropa.getMesPromo(),
                tropa.getCuerpo(),
                tropa.getGrupoAereo()
            });
        });
        tblTropa.setModel(modelo);
    }
    
    
    
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgEstado = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtnomape = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtFecNac = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtAño_promo = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        cboRango = new javax.swing.JComboBox<>();
        cboMesPromo = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        cboCuerpo = new javax.swing.JComboBox<>();
        cboGrupoAereo = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        lblSerie = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTropa = new javax.swing.JTable();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("MANTENIMIENTO PERSONAL DE TROPA");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Serie:");

        txtnomape.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Nombre y Apellido:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Rango:");

        txtFecNac.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Fecha Nacimiento:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("aaaa-mm-dd");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Año Promocion:");

        txtAño_promo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setText("Mes Promocion:");

        cboRango.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Avionero", "Cabo", "Sargento 2", "Sargento 1" }));

        cboMesPromo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "enero", "febero", "marzo", "abril", "mayo", "junio", "julio" }));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setText("Cuerpo:");

        cboCuerpo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Policía Aérea", "Escuadrón de Fuerzas Especiales", "Furriel" }));

        cboGrupoAereo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Grupo Aéreo Nro. 6 – Chiclayo", "Grupo Aéreo Nro. 7 – Piura", "Grupo Aéreo Nro. 11 – Talara", "Grupo Aéreo Nro. 8 – Callao", "Grupo Aéreo Nro. 2 – Vitor", "Grupo Aéreo Nro. 4 – La Joya", "Grupo Aéreo Nro. 42 – Iquitos" }));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setText("Grupo Aereo:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtnomape, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblSerie, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtFecNac, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cboRango, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtAño_promo, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                                    .addComponent(cboMesPromo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cboCuerpo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cboGrupoAereo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(0, 226, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblSerie, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtnomape, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtFecNac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cboRango, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtAño_promo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(cboMesPromo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboCuerpo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(cboGrupoAereo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        btnAgregar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        tblTropa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblTropa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTropaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblTropa);

        btnActualizar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnNuevo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed

                                              
    // Generar un nuevo ID basado en el conteo actual
    String nuevoID = "T-" + String.format("%08d", negocioTropa.contarPersonal() + 1);
    lblSerie.setText(nuevoID);

    String idTropa = lblSerie.getText();
    String nomApe = txtnomape.getText();
    String fecNacTexto = txtFecNac.getText();
    Date fechaNac = obtenerFecha(fecNacTexto);

    String rango = (cboRango.getSelectedItem() != null) ? cboRango.getSelectedItem().toString() : "";
    String anioPromo = txtAño_promo.getText();
    String mesPromo = (cboMesPromo.getSelectedItem() != null) ? cboMesPromo.getSelectedItem().toString() : "";
    String cuerpo = (cboCuerpo.getSelectedItem() != null) ? cboCuerpo.getSelectedItem().toString() : "";
    String grupoAereo = (cboGrupoAereo.getSelectedItem() != null) ? cboGrupoAereo.getSelectedItem().toString() : "";

    if (!idTropa.isEmpty() && !nomApe.isEmpty() && fechaNac != null && !rango.isEmpty() && !anioPromo.isEmpty() && !mesPromo.isEmpty() && !cuerpo.isEmpty() && !grupoAereo.isEmpty()) {
        boolean resultado = negocioTropa.agregarPersonal(idTropa, nomApe, fechaNac, rango, anioPromo, mesPromo, cuerpo, grupoAereo);
        if (resultado) {
            JOptionPane.showMessageDialog(this, "Personal agregado correctamente.");
            limpiarCampos();
            cargarTabla();  // Actualizar la tabla
            // Generar nuevo ID para el siguiente registro
            lblSerie.setText("T-" + String.format("%08d", negocioTropa.contarPersonal() + 1));
        } else {
            JOptionPane.showMessageDialog(this, "Error al agregar personal.");
        }
    } else {
        JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos antes de agregar.");
    }


    }//GEN-LAST:event_btnAgregarActionPerformed

    private void tblTropaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTropaMouseClicked
         int filaSeleccionada = tblTropa.getSelectedRow();
        if (filaSeleccionada >= 0) {
            lblSerie.setText(tblTropa.getValueAt(filaSeleccionada, 0).toString());
            txtnomape.setText(tblTropa.getValueAt(filaSeleccionada, 1).toString());
            txtFecNac.setText(tblTropa.getValueAt(filaSeleccionada, 2).toString());
            cboRango.setSelectedItem(tblTropa.getValueAt(filaSeleccionada, 3).toString());
            txtAño_promo.setText(tblTropa.getValueAt(filaSeleccionada, 4).toString());
            cboMesPromo.setSelectedItem(tblTropa.getValueAt(filaSeleccionada, 5).toString());
            cboCuerpo.setSelectedItem(tblTropa.getValueAt(filaSeleccionada, 6).toString());
            cboGrupoAereo.setSelectedItem(tblTropa.getValueAt(filaSeleccionada, 7).toString());
        }
    }//GEN-LAST:event_tblTropaMouseClicked

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        String idTropa = lblSerie.getText();
    String nomApe = txtnomape.getText();
    String fecNacTexto = txtFecNac.getText();
    Date fechaNac = obtenerFecha(fecNacTexto);
    String rango = (cboRango.getSelectedItem() != null) ? cboRango.getSelectedItem().toString() : "";
    String anioPromo = txtAño_promo.getText();
    String mesPromo = (cboMesPromo.getSelectedItem() != null) ? cboMesPromo.getSelectedItem().toString() : "";
    String cuerpo = (cboCuerpo.getSelectedItem() != null) ? cboCuerpo.getSelectedItem().toString() : "";
    String grupoAereo = (cboGrupoAereo.getSelectedItem() != null) ? cboGrupoAereo.getSelectedItem().toString() : "";

    if (!idTropa.isEmpty() && !nomApe.isEmpty() && fechaNac != null && !rango.isEmpty() && !anioPromo.isEmpty() && !mesPromo.isEmpty() && !cuerpo.isEmpty() && !grupoAereo.isEmpty()) {
        boolean resultado = negocioTropa.actualizarPersonal(idTropa, nomApe, fechaNac, rango, anioPromo, mesPromo, cuerpo, grupoAereo);
        if (resultado) {
            JOptionPane.showMessageDialog(this, "Personal actualizado correctamente.");
            limpiarCampos();
            cargarTabla();  // Actualizar la tabla
            // Generar nuevo ID para el siguiente registro
            lblSerie.setText("T-" + String.format("%08d", negocioTropa.contarPersonal() + 1));
        } else {
            JOptionPane.showMessageDialog(this, "Error al actualizar personal.");
        }
    } else {
        JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos antes de actualizar.");
    }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
                                           
    String idTropa = lblSerie.getText();
    
    boolean resultado = negocioTropa.eliminarPersonal(idTropa);
    if (resultado) {
        JOptionPane.showMessageDialog(this, "Personal eliminado correctamente.");
        limpiarCampos();
        cargarTabla();  // Actualizar la tabla
        // Generar nuevo ID para el siguiente registro
        lblSerie.setText("T-" + String.format("%08d", negocioTropa.contarPersonal() + 1));
    } else {
        JOptionPane.showMessageDialog(this, "Error al eliminar personal.");
    }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
           limpiarCampos();
           lblSerie.setText("T-" + String.format("%08d", negocioTropa.contarPersonal() + 1));
    }//GEN-LAST:event_btnNuevoActionPerformed
    
    
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
            java.util.logging.Logger.getLogger(frmPersonalTropa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmPersonalTropa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmPersonalTropa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmPersonalTropa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
              new frmPersonalTropa().setVisible(true);  
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgEstado;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JComboBox<String> cboCuerpo;
    private javax.swing.JComboBox<String> cboGrupoAereo;
    private javax.swing.JComboBox<String> cboMesPromo;
    private javax.swing.JComboBox<String> cboRango;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblSerie;
    private javax.swing.JTable tblTropa;
    private javax.swing.JTextField txtAño_promo;
    private javax.swing.JTextField txtFecNac;
    private javax.swing.JTextField txtnomape;
    // End of variables declaration//GEN-END:variables
}

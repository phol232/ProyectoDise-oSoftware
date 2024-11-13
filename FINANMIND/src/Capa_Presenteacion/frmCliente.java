
package Capa_Presenteacion;

import Capa_Datos.ingresos;
import Capa_Negocio.neg_ingreso;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class frmCliente extends javax.swing.JFrame {

    private String idUsuarioActual;
    
    public frmCliente(String idUsuario) {
        initComponents();
        configurarMenuNavegacion();
        this.setSize(1060, 630);
        this.setLocationRelativeTo(null);
        DNI.setText(idUsuario);
        listarIngresos();
        DNI.setEditable(false);
        String nuevoId = generarIdIngreso();
        idingreso.setText(nuevoId);
        idingreso.setEditable(false);
        btnGuardar.addActionListener(e -> guardarIngreso());
        btnActualizar.addActionListener(e -> actualizarIngreso());
        btnEliminar.addActionListener(e -> eliminarIngreso());
        btnNuevo.addActionListener(e -> limpiarCampos());

    }
    public frmCliente() {
        initComponents();
        configurarMenuNavegacion();
        this.setSize(1060, 630); 
        this.setLocationRelativeTo(null);
        btnGuardar.addActionListener(e -> guardarIngreso());
        btnActualizar.addActionListener(e -> actualizarIngreso());
        btnEliminar.addActionListener(e -> eliminarIngreso());
        btnNuevo.addActionListener(e -> limpiarCampos());
        DNI.setText(idUsuarioActual);
        listarIngresos();
    }
    
    private void configurarMenuNavegacion() {
        jList1.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                 String seleccion = jList1.getSelectedValue();

                switch (seleccion) {
                    case "REGISTRO DATOS":
                    menudinamico.setSelectedComponent(PANELREGISTROS);
                    break;
                    case "ANALISIS DATOS":
                    menudinamico.setSelectedComponent(PANELANALISIS);
                    break;
                    case "ECONOMICO":
                    menudinamico.setSelectedComponent(PANELECONOMICO);
                    break;
                    case "DASHBOARD HISTÓRICO":
                    menudinamico.setSelectedComponent(PANELDASHBOARDHISTORICO);
                    break;
                    case "DASHBOARD PREDICTIVO":
                    menudinamico.setSelectedComponent(PANELDAASHBOARDPREDICTIVO);
                    break;
                    case "CONSEJOS":
                    menudinamico.setSelectedComponent(PANELCONEJOS);
                    break;
                    case "CONFIGURACION":
                    menudinamico.setSelectedComponent(PANELCONFIGURACION);
                    break;
                    default:
                    break;
                }
            }
        });
    }
    
    

    private void guardarIngreso() {
    // Obtener datos de los campos
    String idIngreso = idingreso.getText();
    String idUsuario = DNI.getText();
    String montoStr = txtMonto1.getText();
    String fechaIngreso = txtFecha.getText();
    String tipoIngreso = txtTipo.getText();
    String descripcion = txtDescripcion.getText();

    // Validar campos obligatorios
    if (idUsuario.isEmpty() || montoStr.isEmpty() || fechaIngreso.isEmpty() || tipoIngreso.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Todos los campos excepto la descripción son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    try {
        double monto = Double.parseDouble(montoStr);

        // Llamar a la capa de negocio
        neg_ingreso negocio = new neg_ingreso();
        boolean resultado = negocio.agregarIngreso(idIngreso, idUsuario, monto, fechaIngreso, tipoIngreso, descripcion);

        if (resultado) {
            JOptionPane.showMessageDialog(this, "Ingreso guardado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            listarIngresos(); // Actualizar tabla
            limpiarCampos(); // Limpiar campos para nuevo registro
        } else {
            JOptionPane.showMessageDialog(this, "Error al guardar el ingreso.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "El monto debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}

private void actualizarIngreso() {
    // Obtener datos de los campos
    String idIngreso = idingreso.getText();
    String idUsuario = DNI.getText();
    String montoStr = txtMonto1.getText();
    String fechaIngreso = txtFecha.getText();
    String tipoIngreso = txtTipo.getText();
    String descripcion = txtDescripcion.getText();

    // Validar campos obligatorios
    if (idIngreso.isEmpty() || idUsuario.isEmpty() || montoStr.isEmpty() || fechaIngreso.isEmpty() || tipoIngreso.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Todos los campos excepto la descripción son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    try {
        double monto = Double.parseDouble(montoStr);

        // Llamar a la capa de negocio
        neg_ingreso negocio = new neg_ingreso();
        boolean resultado = negocio.actualizarIngreso(idIngreso, idUsuario, monto, fechaIngreso, tipoIngreso, descripcion);

        if (resultado) {
            JOptionPane.showMessageDialog(this, "Ingreso actualizado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            listarIngresos(); // Actualizar tabla
            limpiarCampos(); // Limpiar campos para nuevo registro
        } else {
            JOptionPane.showMessageDialog(this, "Error al actualizar el ingreso.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "El monto debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}


    private void eliminarIngreso() {
        String idIngreso = idingreso.getText();

        if (idIngreso.isEmpty()) {
            JOptionPane.showMessageDialog(this, "El ID del ingreso es obligatorio para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        neg_ingreso negocio = new neg_ingreso();
        boolean resultado = negocio.eliminarIngreso(idIngreso);

        if (resultado) {
            JOptionPane.showMessageDialog(this, "Ingreso eliminado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            listarIngresos(); // Actualizar tabla
            limpiarCampos(); // Limpiar campos después de eliminar
        } else {
            JOptionPane.showMessageDialog(this, "Error al eliminar el ingreso.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

private String generarIdIngreso() {
        String prefijo = "ING";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String fecha = sdf.format(new Date());
        Random random = new Random();
        int numeroAleatorio = 1000 + random.nextInt(9000);
        return prefijo + fecha + numeroAleatorio;
    }

    private void limpiarCampos() {
        idingreso.setText(generarIdIngreso()); // Generar nuevo ID de ingreso
        txtMonto1.setText("");
        txtFecha.setText("");
        txtTipo.setText("");
        txtFuente.setText("");
        txtDescripcion.setText("");
    }

private void listarIngresos() {
    neg_ingreso negocio = new neg_ingreso();
    List<ingresos> lista = negocio.listarIngresos();

    DefaultTableModel modelo = (DefaultTableModel) tablaIngresos.getModel();
    modelo.setRowCount(0); 

    for (ingresos ingreso : lista) {
        modelo.addRow(new Object[]{ingreso.getIdIngreso(),ingreso.getIdUsuario(), ingreso.getMonto(), ingreso.getFechaIngreso(), ingreso.getTipoIngreso()});
    }
}


    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        PRINCIPAL = new javax.swing.JSplitPane();
        menunavegacion = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        menudinamico = new javax.swing.JTabbedPane();
        PANELREGISTROS = new javax.swing.JTabbedPane();
        ingresos = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtMonto1 = new javax.swing.JFormattedTextField();
        txtFecha = new javax.swing.JTextField();
        txtTipo = new javax.swing.JTextField();
        txtFuente = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        btnGuardar = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaIngresos = new javax.swing.JTable();
        idingreso = new javax.swing.JTextField();
        DNI = new javax.swing.JTextField();
        btnNuevo = new javax.swing.JButton();
        gastos = new javax.swing.JPanel();
        ficha = new javax.swing.JPanel();
        metas = new javax.swing.JPanel();
        PANELANALISIS = new javax.swing.JTabbedPane();
        prediccion = new javax.swing.JPanel();
        almacenamiento = new javax.swing.JPanel();
        PANELECONOMICO = new javax.swing.JTabbedPane();
        estadoeconomico = new javax.swing.JPanel();
        resumenfinanciero = new javax.swing.JPanel();
        PANELDASHBOARDHISTORICO = new javax.swing.JTabbedPane();
        diagramapie = new javax.swing.JPanel();
        curvas = new javax.swing.JPanel();
        histograma = new javax.swing.JPanel();
        ranking = new javax.swing.JPanel();
        PANELDAASHBOARDPREDICTIVO = new javax.swing.JTabbedPane();
        diagramapiep = new javax.swing.JPanel();
        curvasp = new javax.swing.JPanel();
        histogramap = new javax.swing.JPanel();
        rankingp = new javax.swing.JPanel();
        PANELCONEJOS = new javax.swing.JTabbedPane();
        consejosper = new javax.swing.JPanel();
        videos = new javax.swing.JPanel();
        PANELCONFIGURACION = new javax.swing.JTabbedPane();
        perfil = new javax.swing.JPanel();
        accesibilidad = new javax.swing.JPanel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1021, 579));

        PRINCIPAL.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "REGISTRO DATOS", "ANALISIS DATOS", "ECONOMICO", "DASHBOARD HISTÓRICO", "DASHBOARD PREDICTIVO", "CONSEJOS", "CONFIGURACION" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        javax.swing.GroupLayout menunavegacionLayout = new javax.swing.GroupLayout(menunavegacion);
        menunavegacion.setLayout(menunavegacionLayout);
        menunavegacionLayout.setHorizontalGroup(
            menunavegacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menunavegacionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        menunavegacionLayout.setVerticalGroup(
            menunavegacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menunavegacionLayout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        PRINCIPAL.setLeftComponent(menunavegacion);

        PANELREGISTROS.setAlignmentX(20.0F);
        PANELREGISTROS.setAlignmentY(30.0F);

        ingresos.setBackground(new java.awt.Color(226, 255, 220));
        ingresos.setAlignmentX(50.0F);
        ingresos.setAlignmentY(50.0F);
        ingresos.setMinimumSize(new java.awt.Dimension(300, 300));

        jLabel1.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        jLabel1.setText("INGRESOS");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("IDINGRESO:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("DNI:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("MONTO:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("FUENTE:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("FECHA:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("TIPO:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setText("DESCRIPCION :");

        txtFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaActionPerformed(evt);
            }
        });

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        jScrollPane2.setViewportView(txtDescripcion);

        btnGuardar.setBackground(new java.awt.Color(153, 255, 255));
        btnGuardar.setText("GUARDAR");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        jLabel11.setText("yyyy-mm-d");

        btnActualizar.setBackground(new java.awt.Color(153, 255, 255));
        btnActualizar.setText("ACTUALIZAR");

        btnEliminar.setBackground(new java.awt.Color(153, 255, 255));
        btnEliminar.setText("ELIMINAR");

        tablaIngresos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "IDINGRESO", "DNI", "MONTO", "FECHA", "TIPO"
            }
        ));
        tablaIngresos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaIngresosMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tablaIngresos);

        btnNuevo.setBackground(new java.awt.Color(153, 255, 255));
        btnNuevo.setText("NUEVO");

        javax.swing.GroupLayout ingresosLayout = new javax.swing.GroupLayout(ingresos);
        ingresos.setLayout(ingresosLayout);
        ingresosLayout.setHorizontalGroup(
            ingresosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ingresosLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(ingresosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ingresosLayout.createSequentialGroup()
                        .addComponent(btnGuardar)
                        .addGap(31, 31, 31)
                        .addGroup(ingresosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(ingresosLayout.createSequentialGroup()
                                .addComponent(btnActualizar)
                                .addGap(36, 36, 36)
                                .addComponent(btnEliminar)
                                .addGap(31, 31, 31)
                                .addGroup(ingresosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnNuevo)))))
                    .addGroup(ingresosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(ingresosLayout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(48, 48, 48)
                            .addComponent(idingreso, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(ingresosLayout.createSequentialGroup()
                            .addGap(16, 16, 16)
                            .addComponent(jLabel1))
                        .addGroup(ingresosLayout.createSequentialGroup()
                            .addGap(116, 116, 116)
                            .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel11))
                        .addGroup(ingresosLayout.createSequentialGroup()
                            .addGroup(ingresosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(ingresosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4))
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(67, 67, 67)
                            .addGroup(ingresosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(DNI, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtFuente, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtMonto1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ingresosLayout.createSequentialGroup()
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(73, 73, 73)))
                    .addGroup(ingresosLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(ingresosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ingresosLayout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(67, 67, 67)
                                .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(203, Short.MAX_VALUE))
        );
        ingresosLayout.setVerticalGroup(
            ingresosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ingresosLayout.createSequentialGroup()
                .addGroup(ingresosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ingresosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(9, 9, 9)
                        .addGroup(ingresosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(idingreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(ingresosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(DNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(ingresosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMonto1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(ingresosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtFuente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13)
                        .addGroup(ingresosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addGap(18, 18, 18)
                        .addGroup(ingresosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(ingresosLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ingresosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ingresosLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(ingresosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnActualizar)
                    .addComponent(btnEliminar)
                    .addComponent(btnNuevo))
                .addGap(84, 84, 84))
        );

        PANELREGISTROS.addTab("REGISTRO GASTOS", ingresos);

        gastos.setBackground(new java.awt.Color(255, 255, 204));
        gastos.setAlignmentX(50.0F);
        gastos.setAlignmentY(50.0F);
        gastos.setMinimumSize(new java.awt.Dimension(300, 300));

        javax.swing.GroupLayout gastosLayout = new javax.swing.GroupLayout(gastos);
        gastos.setLayout(gastosLayout);
        gastosLayout.setHorizontalGroup(
            gastosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 858, Short.MAX_VALUE)
        );
        gastosLayout.setVerticalGroup(
            gastosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 510, Short.MAX_VALUE)
        );

        PANELREGISTROS.addTab("REGISTRO INGRESOS", gastos);

        ficha.setBackground(new java.awt.Color(204, 255, 255));
        ficha.setAlignmentX(50.0F);
        ficha.setAlignmentY(50.0F);
        ficha.setMinimumSize(new java.awt.Dimension(300, 300));

        javax.swing.GroupLayout fichaLayout = new javax.swing.GroupLayout(ficha);
        ficha.setLayout(fichaLayout);
        fichaLayout.setHorizontalGroup(
            fichaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 858, Short.MAX_VALUE)
        );
        fichaLayout.setVerticalGroup(
            fichaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 510, Short.MAX_VALUE)
        );

        PANELREGISTROS.addTab("FICHA PSICOLÓGICA", ficha);

        metas.setBackground(new java.awt.Color(255, 255, 255));
        metas.setMinimumSize(new java.awt.Dimension(300, 300));

        javax.swing.GroupLayout metasLayout = new javax.swing.GroupLayout(metas);
        metas.setLayout(metasLayout);
        metasLayout.setHorizontalGroup(
            metasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 858, Short.MAX_VALUE)
        );
        metasLayout.setVerticalGroup(
            metasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 510, Short.MAX_VALUE)
        );

        PANELREGISTROS.addTab("METAS", metas);

        menudinamico.addTab("REGISTRO DATOS", PANELREGISTROS);

        prediccion.setBackground(new java.awt.Color(204, 255, 255));

        javax.swing.GroupLayout prediccionLayout = new javax.swing.GroupLayout(prediccion);
        prediccion.setLayout(prediccionLayout);
        prediccionLayout.setHorizontalGroup(
            prediccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        prediccionLayout.setVerticalGroup(
            prediccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        PANELANALISIS.addTab("PROCESAR PREDDICION", prediccion);

        almacenamiento.setBackground(new java.awt.Color(204, 255, 204));

        javax.swing.GroupLayout almacenamientoLayout = new javax.swing.GroupLayout(almacenamiento);
        almacenamiento.setLayout(almacenamientoLayout);
        almacenamientoLayout.setHorizontalGroup(
            almacenamientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        almacenamientoLayout.setVerticalGroup(
            almacenamientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        PANELANALISIS.addTab("PREDICCIONES HECHAS", almacenamiento);

        menudinamico.addTab("ANALISIS DATOS", PANELANALISIS);

        javax.swing.GroupLayout estadoeconomicoLayout = new javax.swing.GroupLayout(estadoeconomico);
        estadoeconomico.setLayout(estadoeconomicoLayout);
        estadoeconomicoLayout.setHorizontalGroup(
            estadoeconomicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        estadoeconomicoLayout.setVerticalGroup(
            estadoeconomicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        PANELECONOMICO.addTab("ESTADO ECONOMICO", estadoeconomico);

        javax.swing.GroupLayout resumenfinancieroLayout = new javax.swing.GroupLayout(resumenfinanciero);
        resumenfinanciero.setLayout(resumenfinancieroLayout);
        resumenfinancieroLayout.setHorizontalGroup(
            resumenfinancieroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        resumenfinancieroLayout.setVerticalGroup(
            resumenfinancieroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        PANELECONOMICO.addTab("RESUMEN FINANCIERO", resumenfinanciero);

        menudinamico.addTab("ECONOMICO", PANELECONOMICO);

        javax.swing.GroupLayout diagramapieLayout = new javax.swing.GroupLayout(diagramapie);
        diagramapie.setLayout(diagramapieLayout);
        diagramapieLayout.setHorizontalGroup(
            diagramapieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        diagramapieLayout.setVerticalGroup(
            diagramapieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        PANELDASHBOARDHISTORICO.addTab("DIAGRAMA PIE", diagramapie);

        javax.swing.GroupLayout curvasLayout = new javax.swing.GroupLayout(curvas);
        curvas.setLayout(curvasLayout);
        curvasLayout.setHorizontalGroup(
            curvasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        curvasLayout.setVerticalGroup(
            curvasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        PANELDASHBOARDHISTORICO.addTab("DIAGRAMA CURVAS", curvas);

        javax.swing.GroupLayout histogramaLayout = new javax.swing.GroupLayout(histograma);
        histograma.setLayout(histogramaLayout);
        histogramaLayout.setHorizontalGroup(
            histogramaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        histogramaLayout.setVerticalGroup(
            histogramaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        PANELDASHBOARDHISTORICO.addTab("DIAGRAMA HISTOGRAMA", histograma);

        javax.swing.GroupLayout rankingLayout = new javax.swing.GroupLayout(ranking);
        ranking.setLayout(rankingLayout);
        rankingLayout.setHorizontalGroup(
            rankingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        rankingLayout.setVerticalGroup(
            rankingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        PANELDASHBOARDHISTORICO.addTab("DIAGRAMA RANKING", ranking);

        menudinamico.addTab("DASHBOARD HISTORICO", PANELDASHBOARDHISTORICO);

        javax.swing.GroupLayout diagramapiepLayout = new javax.swing.GroupLayout(diagramapiep);
        diagramapiep.setLayout(diagramapiepLayout);
        diagramapiepLayout.setHorizontalGroup(
            diagramapiepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        diagramapiepLayout.setVerticalGroup(
            diagramapiepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        PANELDAASHBOARDPREDICTIVO.addTab("DIAGRAMA PIE", diagramapiep);

        javax.swing.GroupLayout curvaspLayout = new javax.swing.GroupLayout(curvasp);
        curvasp.setLayout(curvaspLayout);
        curvaspLayout.setHorizontalGroup(
            curvaspLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        curvaspLayout.setVerticalGroup(
            curvaspLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        PANELDAASHBOARDPREDICTIVO.addTab("DIAGRAMA CURVAS", curvasp);

        javax.swing.GroupLayout histogramapLayout = new javax.swing.GroupLayout(histogramap);
        histogramap.setLayout(histogramapLayout);
        histogramapLayout.setHorizontalGroup(
            histogramapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        histogramapLayout.setVerticalGroup(
            histogramapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        PANELDAASHBOARDPREDICTIVO.addTab("HISTOGRAMA", histogramap);

        javax.swing.GroupLayout rankingpLayout = new javax.swing.GroupLayout(rankingp);
        rankingp.setLayout(rankingpLayout);
        rankingpLayout.setHorizontalGroup(
            rankingpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        rankingpLayout.setVerticalGroup(
            rankingpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        PANELDAASHBOARDPREDICTIVO.addTab("DIAGRAMA RANKING", rankingp);

        menudinamico.addTab("DASHBOARD PREDICTIVO", PANELDAASHBOARDPREDICTIVO);

        javax.swing.GroupLayout consejosperLayout = new javax.swing.GroupLayout(consejosper);
        consejosper.setLayout(consejosperLayout);
        consejosperLayout.setHorizontalGroup(
            consejosperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 858, Short.MAX_VALUE)
        );
        consejosperLayout.setVerticalGroup(
            consejosperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 510, Short.MAX_VALUE)
        );

        PANELCONEJOS.addTab("RECOMENDACIONES PERSONALIZADAS", consejosper);

        javax.swing.GroupLayout videosLayout = new javax.swing.GroupLayout(videos);
        videos.setLayout(videosLayout);
        videosLayout.setHorizontalGroup(
            videosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 858, Short.MAX_VALUE)
        );
        videosLayout.setVerticalGroup(
            videosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 510, Short.MAX_VALUE)
        );

        PANELCONEJOS.addTab("VIDEOS", videos);

        menudinamico.addTab("CONSEJOS", PANELCONEJOS);

        javax.swing.GroupLayout perfilLayout = new javax.swing.GroupLayout(perfil);
        perfil.setLayout(perfilLayout);
        perfilLayout.setHorizontalGroup(
            perfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 858, Short.MAX_VALUE)
        );
        perfilLayout.setVerticalGroup(
            perfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 510, Short.MAX_VALUE)
        );

        PANELCONFIGURACION.addTab("PERFIL", perfil);

        javax.swing.GroupLayout accesibilidadLayout = new javax.swing.GroupLayout(accesibilidad);
        accesibilidad.setLayout(accesibilidadLayout);
        accesibilidadLayout.setHorizontalGroup(
            accesibilidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 858, Short.MAX_VALUE)
        );
        accesibilidadLayout.setVerticalGroup(
            accesibilidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 510, Short.MAX_VALUE)
        );

        PANELCONFIGURACION.addTab("ACCESIBILIDAD", accesibilidad);

        menudinamico.addTab("CONFIGURACION", PANELCONFIGURACION);

        PRINCIPAL.setRightComponent(menudinamico);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PRINCIPAL)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PRINCIPAL)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaActionPerformed

    private void tablaIngresosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaIngresosMouseClicked
        int filaSeleccionada = tablaIngresos.getSelectedRow();
        if (filaSeleccionada >= 0) {
            // Asignar los valores de la fila seleccionada a los campos
        idingreso.setText(tablaIngresos.getValueAt(filaSeleccionada, 0).toString());
        DNI.setText(tablaIngresos.getValueAt(filaSeleccionada, 1).toString());
        txtMonto1.setText(tablaIngresos.getValueAt(filaSeleccionada, 2).toString());
        txtFecha.setText(tablaIngresos.getValueAt(filaSeleccionada, 3).toString());
        txtTipo.setText(tablaIngresos.getValueAt(filaSeleccionada, 4).toString());
    }
    }//GEN-LAST:event_tablaIngresosMouseClicked

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
            java.util.logging.Logger.getLogger(frmCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField DNI;
    private javax.swing.JTabbedPane PANELANALISIS;
    private javax.swing.JTabbedPane PANELCONEJOS;
    private javax.swing.JTabbedPane PANELCONFIGURACION;
    private javax.swing.JTabbedPane PANELDAASHBOARDPREDICTIVO;
    private javax.swing.JTabbedPane PANELDASHBOARDHISTORICO;
    private javax.swing.JTabbedPane PANELECONOMICO;
    private javax.swing.JTabbedPane PANELREGISTROS;
    private javax.swing.JSplitPane PRINCIPAL;
    private javax.swing.JPanel accesibilidad;
    private javax.swing.JPanel almacenamiento;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JPanel consejosper;
    private javax.swing.JPanel curvas;
    private javax.swing.JPanel curvasp;
    private javax.swing.JPanel diagramapie;
    private javax.swing.JPanel diagramapiep;
    private javax.swing.JPanel estadoeconomico;
    private javax.swing.JPanel ficha;
    private javax.swing.JPanel gastos;
    private javax.swing.JPanel histograma;
    private javax.swing.JPanel histogramap;
    private javax.swing.JTextField idingreso;
    private javax.swing.JPanel ingresos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTabbedPane menudinamico;
    private javax.swing.JPanel menunavegacion;
    private javax.swing.JPanel metas;
    private javax.swing.JPanel perfil;
    private javax.swing.JPanel prediccion;
    private javax.swing.JPanel ranking;
    private javax.swing.JPanel rankingp;
    private javax.swing.JPanel resumenfinanciero;
    private javax.swing.JTable tablaIngresos;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtFuente;
    private javax.swing.JFormattedTextField txtMonto1;
    private javax.swing.JTextField txtTipo;
    private javax.swing.JPanel videos;
    // End of variables declaration//GEN-END:variables
}

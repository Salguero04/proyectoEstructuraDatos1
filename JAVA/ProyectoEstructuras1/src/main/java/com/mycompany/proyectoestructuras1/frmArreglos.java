/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.proyectoestructuras1;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.CardLayout;
import java.awt.Image;

/**
 * Formulario de Arreglos - CRUD de vehículos.
 * @author PC_Mario
 */
public class frmArreglos extends javax.swing.JFrame {

    private final VehiculoService servicio = VehiculoService.getInstancia();
    private DefaultTableModel modeloTabla;

    public frmArreglos() {
        initComponents();
        setLocationRelativeTo(null);
        cargarLogos();
        modeloTabla = (DefaultTableModel) tblVehiculos.getModel();
        cargarTabla();
        mostrarPanel("pnlVacio");
    }

    private void cargarLogos() {
        try {
            ImageIcon icon = new ImageIcon(getClass().getResource("/images/logo-vertical.png"));
            Image imgPeq = icon.getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH);
            lblLogoHeader.setIcon(new ImageIcon(imgPeq));
        } catch (Exception e) {
            lblLogoHeader.setText("UG");
        }
    }

    private void cargarTabla() {
        modeloTabla.setRowCount(0);
        Vehiculo[] vehiculos = servicio.obtenerTodos();
        for (int i = 0; i < vehiculos.length; i++) {
            modeloTabla.addRow(new Object[]{i, vehiculos[i].getPlaca(), vehiculos[i].getPropietario()});
        }
    }

    private void mostrarPanel(String nombre) {
        CardLayout cl = (CardLayout) pnlFormularios.getLayout();
        cl.show(pnlFormularios, nombre);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlHeader = new javax.swing.JPanel();
        lblLogoHeader = new javax.swing.JLabel();
        lblTituloHeader = new javax.swing.JLabel();
        pnlSidebar = new javax.swing.JPanel();
        btnInsertar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        pnlCentral = new javax.swing.JPanel();
        pnlFormularios = new javax.swing.JPanel();
        pnlVacio = new javax.swing.JPanel();
        lblInfo = new javax.swing.JLabel();
        pnlInsertar = new javax.swing.JPanel();
        lblPlacaIns = new javax.swing.JLabel();
        txtPlacaIns = new javax.swing.JTextField();
        lblPropIns = new javax.swing.JLabel();
        txtPropIns = new javax.swing.JTextField();
        btnEjecutarInsertar = new javax.swing.JButton();
        pnlEliminar = new javax.swing.JPanel();
        lblPlacaElim = new javax.swing.JLabel();
        txtPlacaElim = new javax.swing.JTextField();
        btnEjecutarEliminar = new javax.swing.JButton();
        pnlModificar = new javax.swing.JPanel();
        lblIndiceMod = new javax.swing.JLabel();
        spnIndiceMod = new javax.swing.JSpinner();
        lblPlacaMod = new javax.swing.JLabel();
        txtPlacaMod = new javax.swing.JTextField();
        lblPropMod = new javax.swing.JLabel();
        txtPropMod = new javax.swing.JTextField();
        btnEjecutarModificar = new javax.swing.JButton();
        pnlBuscar = new javax.swing.JPanel();
        lblPlacaBusc = new javax.swing.JLabel();
        txtPlacaBusc = new javax.swing.JTextField();
        btnEjecutarBuscar = new javax.swing.JButton();
        lblResultado = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVehiculos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Arreglos - Proyecto Estructura de Datos");
        setPreferredSize(new java.awt.Dimension(950, 600));
        getContentPane().setLayout(new java.awt.BorderLayout());

        // === HEADER ===
        pnlHeader.setBackground(new java.awt.Color(230, 236, 245));
        pnlHeader.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(100, 160, 220)));
        pnlHeader.setPreferredSize(new java.awt.Dimension(950, 50));
        pnlHeader.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 7));
        pnlHeader.add(lblLogoHeader);

        lblTituloHeader.setFont(new java.awt.Font("Segoe UI", 3, 14));
        lblTituloHeader.setForeground(new java.awt.Color(20, 50, 100));
        lblTituloHeader.setText("PROYECTO DE ESTRUCTURA DE DATOS - ARREGLOS");
        pnlHeader.add(lblTituloHeader);
        getContentPane().add(pnlHeader, java.awt.BorderLayout.NORTH);

        // === SIDEBAR ===
        pnlSidebar.setBackground(new java.awt.Color(230, 236, 245));
        pnlSidebar.setPreferredSize(new java.awt.Dimension(165, 500));
        pnlSidebar.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 15));

        btnInsertar.setBackground(new java.awt.Color(70, 130, 200));
        btnInsertar.setFont(new java.awt.Font("Segoe UI", 1, 13));
        btnInsertar.setForeground(java.awt.Color.WHITE);
        btnInsertar.setText("Insertar");
        btnInsertar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInsertar.setPreferredSize(new java.awt.Dimension(140, 35));
        btnInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) { btnInsertarActionPerformed(evt); }
        });
        pnlSidebar.add(btnInsertar);

        btnEliminar.setBackground(new java.awt.Color(70, 130, 200));
        btnEliminar.setFont(new java.awt.Font("Segoe UI", 1, 13));
        btnEliminar.setForeground(java.awt.Color.WHITE);
        btnEliminar.setText("Eliminar");
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminar.setPreferredSize(new java.awt.Dimension(140, 35));
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) { btnEliminarActionPerformed(evt); }
        });
        pnlSidebar.add(btnEliminar);

        btnModificar.setBackground(new java.awt.Color(70, 130, 200));
        btnModificar.setFont(new java.awt.Font("Segoe UI", 1, 13));
        btnModificar.setForeground(java.awt.Color.WHITE);
        btnModificar.setText("Modificar");
        btnModificar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnModificar.setPreferredSize(new java.awt.Dimension(140, 35));
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) { btnModificarActionPerformed(evt); }
        });
        pnlSidebar.add(btnModificar);

        btnBuscar.setBackground(new java.awt.Color(70, 130, 200));
        btnBuscar.setFont(new java.awt.Font("Segoe UI", 1, 13));
        btnBuscar.setForeground(java.awt.Color.WHITE);
        btnBuscar.setText("Buscar");
        btnBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscar.setPreferredSize(new java.awt.Dimension(140, 35));
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) { btnBuscarActionPerformed(evt); }
        });
        pnlSidebar.add(btnBuscar);

        btnSalir.setBackground(new java.awt.Color(70, 130, 200));
        btnSalir.setFont(new java.awt.Font("Segoe UI", 1, 13));
        btnSalir.setForeground(java.awt.Color.WHITE);
        btnSalir.setText("Salir");
        btnSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalir.setPreferredSize(new java.awt.Dimension(140, 35));
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) { btnSalirActionPerformed(evt); }
        });
        pnlSidebar.add(btnSalir);

        getContentPane().add(pnlSidebar, java.awt.BorderLayout.WEST);

        // === CENTRAL ===
        pnlCentral.setBackground(java.awt.Color.WHITE);
        pnlCentral.setLayout(new java.awt.BorderLayout(0, 10));

        // Panel de formularios con CardLayout
        pnlFormularios.setBackground(java.awt.Color.WHITE);
        pnlFormularios.setPreferredSize(new java.awt.Dimension(700, 200));
        pnlFormularios.setLayout(new java.awt.CardLayout());

        // Card: Vacío
        pnlVacio.setBackground(java.awt.Color.WHITE);
        pnlVacio.setLayout(new java.awt.GridBagLayout());
        lblInfo.setFont(new java.awt.Font("Segoe UI", 2, 14));
        lblInfo.setForeground(new java.awt.Color(150, 150, 150));
        lblInfo.setText("Seleccione una acción del menú lateral.");
        pnlVacio.add(lblInfo, new java.awt.GridBagConstraints());
        pnlFormularios.add(pnlVacio, "pnlVacio");

        // Card: Insertar
        pnlInsertar.setBackground(java.awt.Color.WHITE);
        pnlInsertar.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Insertar Vehículo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(20, 50, 100)));
        pnlInsertar.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 10));
        lblPlacaIns.setFont(new java.awt.Font("Segoe UI", 1, 13));
        lblPlacaIns.setText("Placa:");
        pnlInsertar.add(lblPlacaIns);
        txtPlacaIns.setPreferredSize(new java.awt.Dimension(120, 28));
        pnlInsertar.add(txtPlacaIns);
        lblPropIns.setFont(new java.awt.Font("Segoe UI", 1, 13));
        lblPropIns.setText("Propietario:");
        pnlInsertar.add(lblPropIns);
        txtPropIns.setPreferredSize(new java.awt.Dimension(150, 28));
        pnlInsertar.add(txtPropIns);
        btnEjecutarInsertar.setBackground(new java.awt.Color(40, 120, 70));
        btnEjecutarInsertar.setFont(new java.awt.Font("Segoe UI", 1, 13));
        btnEjecutarInsertar.setForeground(java.awt.Color.WHITE);
        btnEjecutarInsertar.setText("INSERTAR");
        btnEjecutarInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) { btnEjecutarInsertarActionPerformed(evt); }
        });
        pnlInsertar.add(btnEjecutarInsertar);
        pnlFormularios.add(pnlInsertar, "pnlInsertar");

        // Card: Eliminar
        pnlEliminar.setBackground(java.awt.Color.WHITE);
        pnlEliminar.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Eliminar Vehículo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(20, 50, 100)));
        pnlEliminar.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 10));
        lblPlacaElim.setFont(new java.awt.Font("Segoe UI", 1, 13));
        lblPlacaElim.setText("Placa a eliminar:");
        pnlEliminar.add(lblPlacaElim);
        txtPlacaElim.setPreferredSize(new java.awt.Dimension(150, 28));
        pnlEliminar.add(txtPlacaElim);
        btnEjecutarEliminar.setBackground(new java.awt.Color(200, 50, 50));
        btnEjecutarEliminar.setFont(new java.awt.Font("Segoe UI", 1, 13));
        btnEjecutarEliminar.setForeground(java.awt.Color.WHITE);
        btnEjecutarEliminar.setText("ELIMINAR");
        btnEjecutarEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) { btnEjecutarEliminarActionPerformed(evt); }
        });
        pnlEliminar.add(btnEjecutarEliminar);
        pnlFormularios.add(pnlEliminar, "pnlEliminar");

        // Card: Modificar
        pnlModificar.setBackground(java.awt.Color.WHITE);
        pnlModificar.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Modificar Vehículo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(20, 50, 100)));
        pnlModificar.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 10));
        lblIndiceMod.setFont(new java.awt.Font("Segoe UI", 1, 13));
        lblIndiceMod.setText("Índice:");
        pnlModificar.add(lblIndiceMod);
        spnIndiceMod.setPreferredSize(new java.awt.Dimension(60, 28));
        pnlModificar.add(spnIndiceMod);
        lblPlacaMod.setFont(new java.awt.Font("Segoe UI", 1, 13));
        lblPlacaMod.setText("Placa:");
        pnlModificar.add(lblPlacaMod);
        txtPlacaMod.setPreferredSize(new java.awt.Dimension(100, 28));
        pnlModificar.add(txtPlacaMod);
        lblPropMod.setFont(new java.awt.Font("Segoe UI", 1, 13));
        lblPropMod.setText("Propietario:");
        pnlModificar.add(lblPropMod);
        txtPropMod.setPreferredSize(new java.awt.Dimension(130, 28));
        pnlModificar.add(txtPropMod);
        btnEjecutarModificar.setBackground(new java.awt.Color(200, 150, 0));
        btnEjecutarModificar.setFont(new java.awt.Font("Segoe UI", 1, 13));
        btnEjecutarModificar.setForeground(java.awt.Color.WHITE);
        btnEjecutarModificar.setText("MODIFICAR");
        btnEjecutarModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) { btnEjecutarModificarActionPerformed(evt); }
        });
        pnlModificar.add(btnEjecutarModificar);
        pnlFormularios.add(pnlModificar, "pnlModificar");

        // Card: Buscar
        pnlBuscar.setBackground(java.awt.Color.WHITE);
        pnlBuscar.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Buscar Vehículo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(20, 50, 100)));
        pnlBuscar.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 10));
        lblPlacaBusc.setFont(new java.awt.Font("Segoe UI", 1, 13));
        lblPlacaBusc.setText("Placa a buscar:");
        pnlBuscar.add(lblPlacaBusc);
        txtPlacaBusc.setPreferredSize(new java.awt.Dimension(150, 28));
        pnlBuscar.add(txtPlacaBusc);
        btnEjecutarBuscar.setBackground(new java.awt.Color(30, 100, 180));
        btnEjecutarBuscar.setFont(new java.awt.Font("Segoe UI", 1, 13));
        btnEjecutarBuscar.setForeground(java.awt.Color.WHITE);
        btnEjecutarBuscar.setText("BUSCAR");
        btnEjecutarBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) { btnEjecutarBuscarActionPerformed(evt); }
        });
        pnlBuscar.add(btnEjecutarBuscar);
        lblResultado.setFont(new java.awt.Font("Segoe UI", 1, 13));
        lblResultado.setForeground(new java.awt.Color(20, 100, 50));
        pnlBuscar.add(lblResultado);
        pnlFormularios.add(pnlBuscar, "pnlBuscar");

        pnlCentral.add(pnlFormularios, java.awt.BorderLayout.NORTH);

        // Tabla
        tblVehiculos.setModel(new DefaultTableModel(
            new Object[][]{},
            new String[]{"Índice", "Placa", "Propietario"}
        ) {
            boolean[] canEdit = new boolean[]{false, false, false};
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        tblVehiculos.setFont(new java.awt.Font("Segoe UI", 0, 13));
        tblVehiculos.setRowHeight(25);
        tblVehiculos.getTableHeader().setFont(new java.awt.Font("Segoe UI", 1, 13));
        jScrollPane1.setViewportView(tblVehiculos);

        pnlCentral.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        getContentPane().add(pnlCentral, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertarActionPerformed
        txtPlacaIns.setText("");
        txtPropIns.setText("");
        mostrarPanel("pnlInsertar");
    }//GEN-LAST:event_btnInsertarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        txtPlacaElim.setText("");
        mostrarPanel("pnlEliminar");
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        txtPlacaMod.setText("");
        txtPropMod.setText("");
        spnIndiceMod.setValue(0);
        mostrarPanel("pnlModificar");
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        txtPlacaBusc.setText("");
        lblResultado.setText("");
        mostrarPanel("pnlBuscar");
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        new frmOpciones().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnEjecutarInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEjecutarInsertarActionPerformed
        try {
            servicio.insertar(txtPlacaIns.getText(), txtPropIns.getText());
            JOptionPane.showMessageDialog(this, "Vehículo insertado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            txtPlacaIns.setText("");
            txtPropIns.setText("");
            cargarTabla();
        } catch (VehiculoException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEjecutarInsertarActionPerformed

    private void btnEjecutarEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEjecutarEliminarActionPerformed
        try {
            servicio.eliminarPorPlaca(txtPlacaElim.getText());
            JOptionPane.showMessageDialog(this, "Vehículo eliminado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            txtPlacaElim.setText("");
            cargarTabla();
        } catch (VehiculoException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEjecutarEliminarActionPerformed

    private void btnEjecutarModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEjecutarModificarActionPerformed
        try {
            int indice = (Integer) spnIndiceMod.getValue();
            servicio.modificar(indice, txtPlacaMod.getText(), txtPropMod.getText());
            JOptionPane.showMessageDialog(this, "Vehículo modificado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            txtPlacaMod.setText("");
            txtPropMod.setText("");
            cargarTabla();
        } catch (VehiculoException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEjecutarModificarActionPerformed

    private void btnEjecutarBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEjecutarBuscarActionPerformed
        try {
            Vehiculo v = servicio.buscarPorPlaca(txtPlacaBusc.getText());
            if (v != null) {
                lblResultado.setForeground(new java.awt.Color(20, 100, 50));
                lblResultado.setText("Encontrado: " + v.toString());
            } else {
                lblResultado.setForeground(new java.awt.Color(200, 100, 0));
                lblResultado.setText("No se encontró vehículo con esa placa.");
            }
        } catch (VehiculoException ex) {
            lblResultado.setForeground(java.awt.Color.RED);
            lblResultado.setText(ex.getMessage());
        }
    }//GEN-LAST:event_btnEjecutarBuscarActionPerformed

    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmArreglos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(() -> new frmArreglos().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEjecutarBuscar;
    private javax.swing.JButton btnEjecutarEliminar;
    private javax.swing.JButton btnEjecutarInsertar;
    private javax.swing.JButton btnEjecutarModificar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnInsertar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblIndiceMod;
    private javax.swing.JLabel lblInfo;
    private javax.swing.JLabel lblLogoHeader;
    private javax.swing.JLabel lblPlacaBusc;
    private javax.swing.JLabel lblPlacaElim;
    private javax.swing.JLabel lblPlacaIns;
    private javax.swing.JLabel lblPlacaMod;
    private javax.swing.JLabel lblPropIns;
    private javax.swing.JLabel lblPropMod;
    private javax.swing.JLabel lblResultado;
    private javax.swing.JLabel lblTituloHeader;
    private javax.swing.JPanel pnlBuscar;
    private javax.swing.JPanel pnlCentral;
    private javax.swing.JPanel pnlEliminar;
    private javax.swing.JPanel pnlFormularios;
    private javax.swing.JPanel pnlHeader;
    private javax.swing.JPanel pnlInsertar;
    private javax.swing.JPanel pnlModificar;
    private javax.swing.JPanel pnlSidebar;
    private javax.swing.JPanel pnlVacio;
    private javax.swing.JSpinner spnIndiceMod;
    private javax.swing.JTable tblVehiculos;
    private javax.swing.JTextField txtPlacaBusc;
    private javax.swing.JTextField txtPlacaElim;
    private javax.swing.JTextField txtPlacaIns;
    private javax.swing.JTextField txtPlacaMod;
    private javax.swing.JTextField txtPropIns;
    private javax.swing.JTextField txtPropMod;
    // End of variables declaration//GEN-END:variables
}

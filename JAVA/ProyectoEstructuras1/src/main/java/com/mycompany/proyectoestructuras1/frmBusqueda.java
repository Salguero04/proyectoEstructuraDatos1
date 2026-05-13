/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.proyectoestructuras1;

import javax.swing.ImageIcon;
import java.awt.Image;

/**
 * Formulario de Búsqueda.
 * @author PC_Mario
 */
public class frmBusqueda extends javax.swing.JFrame {

    public frmBusqueda() {
        initComponents();
        setLocationRelativeTo(null);
        cargarLogos();
    }

    private void cargarLogos() {
        try {
            ImageIcon icon = new ImageIcon(getClass().getResource("/images/logo-vertical.png"));
            Image imgPeq = icon.getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH);
            lblLogoHeader.setIcon(new ImageIcon(imgPeq));
            Image imgGrande = icon.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
            lblLogoCentral.setIcon(new ImageIcon(imgGrande));
        } catch (Exception e) {
            lblLogoHeader.setText("UG");
            lblLogoCentral.setText("UNIVERSIDAD DE GUAYAQUIL");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlHeader = new javax.swing.JPanel();
        lblLogoHeader = new javax.swing.JLabel();
        lblTituloHeader = new javax.swing.JLabel();
        pnlSidebar = new javax.swing.JPanel();
        btnBinaria = new javax.swing.JButton();
        btnSecuencial = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        pnlContent = new javax.swing.JPanel();
        lblLogoCentral = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Búsqueda - Proyecto Estructura de Datos");
        setPreferredSize(new java.awt.Dimension(900, 550));
        getContentPane().setLayout(new java.awt.BorderLayout());

        pnlHeader.setBackground(new java.awt.Color(230, 236, 245));
        pnlHeader.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(100, 160, 220)));
        pnlHeader.setPreferredSize(new java.awt.Dimension(900, 50));
        pnlHeader.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 7));
        pnlHeader.add(lblLogoHeader);
        lblTituloHeader.setFont(new java.awt.Font("Segoe UI", 3, 14));
        lblTituloHeader.setForeground(new java.awt.Color(20, 50, 100));
        lblTituloHeader.setText("PROYECTO DE ESTRUCTURA DE DATOS - BÚSQUEDA");
        pnlHeader.add(lblTituloHeader);
        getContentPane().add(pnlHeader, java.awt.BorderLayout.NORTH);

        pnlSidebar.setBackground(new java.awt.Color(230, 236, 245));
        pnlSidebar.setPreferredSize(new java.awt.Dimension(180, 500));
        pnlSidebar.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 15));

        btnBinaria.setBackground(new java.awt.Color(70, 130, 200));
        btnBinaria.setFont(new java.awt.Font("Segoe UI", 1, 13));
        btnBinaria.setForeground(java.awt.Color.WHITE);
        btnBinaria.setText("Búsqueda Binaria");
        btnBinaria.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBinaria.setPreferredSize(new java.awt.Dimension(160, 35));
        pnlSidebar.add(btnBinaria);

        btnSecuencial.setBackground(new java.awt.Color(70, 130, 200));
        btnSecuencial.setFont(new java.awt.Font("Segoe UI", 1, 13));
        btnSecuencial.setForeground(java.awt.Color.WHITE);
        btnSecuencial.setText("Búsqueda Secuencial");
        btnSecuencial.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSecuencial.setPreferredSize(new java.awt.Dimension(160, 35));
        pnlSidebar.add(btnSecuencial);

        btnSalir.setBackground(new java.awt.Color(70, 130, 200));
        btnSalir.setFont(new java.awt.Font("Segoe UI", 1, 13));
        btnSalir.setForeground(java.awt.Color.WHITE);
        btnSalir.setText("Salir");
        btnSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalir.setPreferredSize(new java.awt.Dimension(160, 35));
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) { btnSalirActionPerformed(evt); }
        });
        pnlSidebar.add(btnSalir);
        getContentPane().add(pnlSidebar, java.awt.BorderLayout.WEST);

        pnlContent.setBackground(java.awt.Color.WHITE);
        pnlContent.setLayout(new java.awt.GridBagLayout());
        lblLogoCentral.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pnlContent.add(lblLogoCentral, new java.awt.GridBagConstraints());
        getContentPane().add(pnlContent, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        new frmOpciones().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) { javax.swing.UIManager.setLookAndFeel(info.getClassName()); break; }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmBusqueda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(() -> new frmBusqueda().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBinaria;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnSecuencial;
    private javax.swing.JLabel lblLogoCentral;
    private javax.swing.JLabel lblLogoHeader;
    private javax.swing.JLabel lblTituloHeader;
    private javax.swing.JPanel pnlContent;
    private javax.swing.JPanel pnlHeader;
    private javax.swing.JPanel pnlSidebar;
    // End of variables declaration//GEN-END:variables
}

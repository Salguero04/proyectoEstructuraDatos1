package com.mycompany.proyectoestructuras1;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.BorderLayout;
import java.util.Arrays;

public class MetodosBusqueda extends JFrame {
    private JTextField txtNumeros;
    private JTextField txtBuscar;
    private JTextField txtResultado;
    private int[] arreglo;

    public MetodosBusqueda() {
        setTitle("Métodos de Búsqueda");
        setSize(600, 450);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel pnlHeader = new JPanel();
        pnlHeader.setBackground(new Color(230, 236, 245));
        pnlHeader.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(100, 160, 220)));
        pnlHeader.setPreferredSize(new java.awt.Dimension(getWidth(), 50));
        pnlHeader.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 7));

        JLabel lblLogoHeader = new JLabel();
        try {
            javax.swing.ImageIcon icon = new javax.swing.ImageIcon(getClass().getResource("/images/logo-vertical.png"));
            java.awt.Image imgPeq = icon.getImage().getScaledInstance(35, 35, java.awt.Image.SCALE_SMOOTH);
            lblLogoHeader.setIcon(new javax.swing.ImageIcon(imgPeq));
        } catch (Exception e) {
            lblLogoHeader.setText("UG");
        }
        pnlHeader.add(lblLogoHeader);

        JLabel lblTituloHeader = new JLabel("PROYECTO DE ESTRUCTURA DE DATOS - BÚSQUEDA");
        lblTituloHeader.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 14));
        lblTituloHeader.setForeground(new Color(20, 50, 100));
        pnlHeader.add(lblTituloHeader);

        add(pnlHeader, BorderLayout.NORTH);

        JPanel pnlContent = new JPanel();
        pnlContent.setLayout(null);
        pnlContent.setBackground(new Color(240, 240, 240));
        add(pnlContent, BorderLayout.CENTER);

        JLabel lblNumeros = new JLabel("Ingrese números (separados por comas):");
        lblNumeros.setBounds(30, 30, 300, 30);
        lblNumeros.setFont(new Font("Segoe UI", Font.BOLD, 14));
        pnlContent.add(lblNumeros);

        txtNumeros = new JTextField();
        txtNumeros.setBounds(30, 60, 520, 35);
        txtNumeros.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        pnlContent.add(txtNumeros);

        JLabel lblBuscar = new JLabel("Número a buscar:");
        lblBuscar.setBounds(30, 110, 150, 30);
        lblBuscar.setFont(new Font("Segoe UI", Font.BOLD, 14));
        pnlContent.add(lblBuscar);

        txtBuscar = new JTextField();
        txtBuscar.setBounds(160, 110, 100, 35);
        txtBuscar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        pnlContent.add(txtBuscar);

        JButton btnSecuencial = new JButton("Búsqueda Secuencial");
        btnSecuencial.setBounds(30, 170, 200, 40);
        btnSecuencial.setBackground(new Color(70, 130, 200));
        btnSecuencial.setForeground(Color.WHITE);
        btnSecuencial.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnSecuencial.setFocusPainted(false);
        pnlContent.add(btnSecuencial);

        JButton btnBinaria = new JButton("Búsqueda Binaria");
        btnBinaria.setBounds(250, 170, 200, 40);
        btnBinaria.setBackground(new Color(70, 130, 200));
        btnBinaria.setForeground(Color.WHITE);
        btnBinaria.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnBinaria.setFocusPainted(false);
        pnlContent.add(btnBinaria);

        JLabel lblRes = new JLabel("Resultado:");
        lblRes.setBounds(30, 240, 100, 30);
        lblRes.setFont(new Font("Segoe UI", Font.BOLD, 14));
        pnlContent.add(lblRes);

        txtResultado = new JTextField();
        txtResultado.setBounds(110, 240, 440, 35);
        txtResultado.setFont(new Font("Segoe UI", Font.BOLD, 14));
        txtResultado.setEditable(false);
        pnlContent.add(txtResultado);

        JButton btnSalir = new JButton("Volver");
        btnSalir.setBounds(450, 310, 100, 35);
        pnlContent.add(btnSalir);

        btnSalir.addActionListener(e -> {
            new frmOpciones().setVisible(true);
            dispose();
        });

        btnSecuencial.addActionListener(e -> buscarSecuencial());
        btnBinaria.addActionListener(e -> buscarBinaria());
    }

    private void leerArreglo() {
        try {
            String[] partes = txtNumeros.getText().split(",");
            arreglo = new int[partes.length];
            for (int i = 0; i < partes.length; i++) {
                arreglo[i] = Integer.parseInt(partes[i].trim());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al leer los números. Asegúrese de que estén separados por comas.");
            arreglo = null;
        }
    }

    private void buscarSecuencial() {
        leerArreglo();
        if (arreglo == null) return;
        try {
            int objetivo = Integer.parseInt(txtBuscar.getText().trim());
            for (int i = 0; i < arreglo.length; i++) {
                if (arreglo[i] == objetivo) {
                    txtResultado.setText("Encontrado en el índice " + i + " mediante Búsqueda Secuencial");
                    return;
                }
            }
            txtResultado.setText("No encontrado");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Ingrese un número válido a buscar.");
        }
    }

    private void buscarBinaria() {
        leerArreglo();
        if (arreglo == null) return;
        try {
            int objetivo = Integer.parseInt(txtBuscar.getText().trim());
            Arrays.sort(arreglo); // Requisito para la binaria
            txtNumeros.setText(Arrays.toString(arreglo).replace("[", "").replace("]", "")); // mostrar ordenado
            
            int inicio = 0;
            int fin = arreglo.length - 1;
            while (inicio <= fin) {
                int medio = inicio + (fin - inicio) / 2;
                if (arreglo[medio] == objetivo) {
                    txtResultado.setText("Encontrado en el índice " + medio + " (después de ordenar) mediante B. Binaria");
                    return;
                }
                if (arreglo[medio] < objetivo) {
                    inicio = medio + 1;
                } else {
                    fin = medio - 1;
                }
            }
            txtResultado.setText("No encontrado");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Ingrese un número válido a buscar.");
        }
    }
}

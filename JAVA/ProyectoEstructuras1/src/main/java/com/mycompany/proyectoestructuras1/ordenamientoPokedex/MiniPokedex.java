package com.mycompany.proyectoestructuras1.ordenamientoPokedex;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.BorderLayout;
import java.util.Arrays;

public class MiniPokedex extends JFrame {
    private JTextArea txtSalida;
    private int[] niveles = {45, 12, 89, 5, 23, 67, 34, 90, 2, 18};

    public MiniPokedex() {
        setTitle("Mini Pokédex - Métodos de Ordenamiento");
        setSize(700, 550);
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

        JLabel lblTituloHeader = new JLabel("PROYECTO DE ESTRUCTURA DE DATOS - ORDENAMIENTO");
        lblTituloHeader.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 14));
        lblTituloHeader.setForeground(new Color(20, 50, 100));
        pnlHeader.add(lblTituloHeader);

        add(pnlHeader, BorderLayout.NORTH);

        JPanel pnlContent = new JPanel();
        pnlContent.setLayout(null);
        pnlContent.setBackground(new Color(220, 20, 60)); // Crimson red
        add(pnlContent, BorderLayout.CENTER);

        JLabel titulo = new JLabel("Mini Pokédex - Ordenamiento de Niveles");
        titulo.setBounds(150, 20, 400, 30);
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 20));
        titulo.setForeground(Color.WHITE);
        pnlContent.add(titulo);

        txtSalida = new JTextArea();
        txtSalida.setFont(new Font("Consolas", Font.PLAIN, 14));
        txtSalida.setEditable(false);
        JScrollPane scroll = new JScrollPane(txtSalida);
        scroll.setBounds(50, 70, 600, 250);
        pnlContent.add(scroll);

        JButton btnBurbuja = new JButton("Burbuja");
        btnBurbuja.setBounds(50, 350, 120, 40);
        btnBurbuja.addActionListener(e -> ordenarBurbuja());
        pnlContent.add(btnBurbuja);

        JButton btnSeleccion = new JButton("Selección");
        btnSeleccion.setBounds(190, 350, 120, 40);
        btnSeleccion.addActionListener(e -> ordenarSeleccion());
        pnlContent.add(btnSeleccion);

        JButton btnInsercion = new JButton("Inserción");
        btnInsercion.setBounds(330, 350, 120, 40);
        btnInsercion.addActionListener(e -> ordenarInsercion());
        pnlContent.add(btnInsercion);

        JButton btnQuicksort = new JButton("Quicksort");
        btnQuicksort.setBounds(470, 350, 120, 40);
        btnQuicksort.addActionListener(e -> ordenarQuicksort());
        pnlContent.add(btnQuicksort);

        JButton btnSalir = new JButton("Salir");
        btnSalir.setBounds(270, 410, 100, 35);
        btnSalir.addActionListener(e -> {
            new com.mycompany.proyectoestructuras1.frmOpciones().setVisible(true);
            dispose();
        });
        pnlContent.add(btnSalir);

        mostrarArreglo("Arreglo Original:");
    }

    private void mostrarArreglo(String mensaje) {
        txtSalida.append(mensaje + "\n");
        txtSalida.append(Arrays.toString(niveles) + "\n\n");
    }

    private void reiniciarArreglo() {
        niveles = new int[]{45, 12, 89, 5, 23, 67, 34, 90, 2, 18};
        txtSalida.setText("");
        mostrarArreglo("Arreglo Reiniciado:");
    }

    private void ordenarBurbuja() {
        reiniciarArreglo();
        txtSalida.append("Ejecutando Ordenamiento Burbuja...\n");
        int n = niveles.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (niveles[j] > niveles[j + 1]) {
                    int temp = niveles[j];
                    niveles[j] = niveles[j + 1];
                    niveles[j + 1] = temp;
                }
            }
        }
        mostrarArreglo("Resultado Final (Burbuja):");
    }

    private void ordenarSeleccion() {
        reiniciarArreglo();
        txtSalida.append("Ejecutando Ordenamiento por Selección...\n");
        int n = niveles.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (niveles[j] < niveles[minIdx]) {
                    minIdx = j;
                }
            }
            int temp = niveles[minIdx];
            niveles[minIdx] = niveles[i];
            niveles[i] = temp;
        }
        mostrarArreglo("Resultado Final (Selección):");
    }

    private void ordenarInsercion() {
        reiniciarArreglo();
        txtSalida.append("Ejecutando Ordenamiento por Inserción...\n");
        int n = niveles.length;
        for (int i = 1; i < n; ++i) {
            int key = niveles[i];
            int j = i - 1;
            while (j >= 0 && niveles[j] > key) {
                niveles[j + 1] = niveles[j];
                j = j - 1;
            }
            niveles[j + 1] = key;
        }
        mostrarArreglo("Resultado Final (Inserción):");
    }

    private void ordenarQuicksort() {
        reiniciarArreglo();
        txtSalida.append("Ejecutando Ordenamiento Quicksort...\n");
        quicksort(niveles, 0, niveles.length - 1);
        mostrarArreglo("Resultado Final (Quicksort):");
    }

    private void quicksort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = particion(arr, low, high);
            quicksort(arr, low, pi - 1);
            quicksort(arr, pi + 1, high);
        }
    }

    private int particion(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
}

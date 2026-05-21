package com.mycompany.proyectoestructuras1;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JPanel;
import java.awt.BorderLayout;

public class SimuladorRecursividad extends JFrame {
    private JTextField txtNumero;
    private JTextArea consola;
    private JLabel lblResultado;
    private JLabel lblLlamadas;
    private int contador = 0;

    public SimuladorRecursividad() {
        this.setTitle("RECURSIVE SYSTEM.EXE");
        this.setSize(1000, 750);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());

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

        JLabel lblTituloHeader = new JLabel("PROYECTO DE ESTRUCTURA DE DATOS - RECURSIVIDAD");
        lblTituloHeader.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 14));
        lblTituloHeader.setForeground(new Color(20, 50, 100));
        pnlHeader.add(lblTituloHeader);

        this.add(pnlHeader, BorderLayout.NORTH);

        JPanel pnlContent = new JPanel();
        pnlContent.setLayout(null);
        pnlContent.setBackground(new Color(13, 13, 13));
        this.add(pnlContent, BorderLayout.CENTER);

        JLabel titulo = new JLabel("RECURSIVE SYSTEM.EXE");
        titulo.setBounds(250, 20, 500, 40);
        titulo.setForeground(Color.CYAN);
        titulo.setFont(new Font("Consolas", Font.BOLD, 30));
        pnlContent.add(titulo);

        JLabel subtitulo = new JLabel("SIMULADOR VISUAL DE RECURSIVIDAD");
        subtitulo.setBounds(300, 60, 400, 20);
        subtitulo.setForeground(Color.GREEN);
        subtitulo.setFont(new Font("Consolas", Font.PLAIN, 14));
        pnlContent.add(subtitulo);

        JLabel lblNumero = new JLabel("INGRESE UN NÚMERO:");
        lblNumero.setBounds(350, 120, 300, 30);
        lblNumero.setForeground(Color.GREEN);
        lblNumero.setFont(new Font("Consolas", Font.BOLD, 18));
        pnlContent.add(lblNumero);

        this.txtNumero = new JTextField();
        this.txtNumero.setBounds(370, 160, 200, 40);
        this.txtNumero.setBackground(Color.BLACK);
        this.txtNumero.setForeground(Color.GREEN);
        this.txtNumero.setCaretColor(Color.GREEN);
        this.txtNumero.setFont(new Font("Consolas", Font.BOLD, 20));
        this.txtNumero.setHorizontalAlignment(JTextField.CENTER);
        pnlContent.add(this.txtNumero);

        JButton btnFactorial = this.crearBoton("FACTORIAL", 150, 240);
        JButton btnFibonacci = this.crearBoton("FIBONACCI", 350, 240);
        JButton btnLimpiar = this.crearBoton("LIMPIAR", 550, 240);
        JButton btnSalir = this.crearBoton("SALIR", 750, 240);

        pnlContent.add(btnFactorial);
        pnlContent.add(btnFibonacci);
        pnlContent.add(btnLimpiar);
        pnlContent.add(btnSalir);

        this.lblResultado = new JLabel("RESULTADO FINAL: ---");
        this.lblResultado.setBounds(300, 320, 500, 30);
        this.lblResultado.setForeground(Color.CYAN);
        this.lblResultado.setFont(new Font("Consolas", Font.BOLD, 22));
        pnlContent.add(this.lblResultado);

        this.lblLlamadas = new JLabel("LLAMADAS RECURSIVAS: 0");
        this.lblLlamadas.setBounds(350, 360, 400, 30);
        this.lblLlamadas.setForeground(Color.GREEN);
        this.lblLlamadas.setFont(new Font("Consolas", Font.PLAIN, 18));
        pnlContent.add(this.lblLlamadas);

        this.consola = new JTextArea();
        this.consola.setBackground(Color.BLACK);
        this.consola.setForeground(Color.GREEN);
        this.consola.setFont(new Font("Consolas", Font.PLAIN, 14));
        this.consola.setEditable(false);

        JScrollPane scroll = new JScrollPane(this.consola);
        scroll.setBounds(120, 420, 750, 180);
        pnlContent.add(scroll);

        btnFactorial.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int n = Integer.parseInt(txtNumero.getText());
                    if (n < 0) {
                        JOptionPane.showMessageDialog(null, "Ingrese un número positivo.");
                        return;
                    }
                    contador = 0;
                    consola.setText("");
                    int resultado = factorial(n);
                    lblResultado.setText("RESULTADO FINAL: " + resultado);
                    lblLlamadas.setText("LLAMADAS RECURSIVAS: " + contador);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Ingrese un número válido");
                }
            }
        });

        btnFibonacci.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int n = Integer.parseInt(txtNumero.getText());
                    if (n < 0) {
                        JOptionPane.showMessageDialog(null, "Ingrese un número positivo.");
                        return;
                    }
                    contador = 0;
                    consola.setText("");
                    int resultado = fibonacci(n);
                    lblResultado.setText("RESULTADO FINAL: " + resultado);
                    lblLlamadas.setText("LLAMADAS RECURSIVAS: " + contador);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Ingrese un número válido");
                }
            }
        });

        btnLimpiar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                txtNumero.setText("");
                consola.setText("");
                lblResultado.setText("RESULTADO FINAL: ---");
                lblLlamadas.setText("LLAMADAS RECURSIVAS: 0");
            }
        });

        btnSalir.addActionListener(e -> {
            new frmOpciones().setVisible(true);
            dispose();
        });
    }

    private JButton crearBoton(String texto, int x, int y) {
        JButton boton = new JButton(texto);
        boton.setBounds(x, y, 150, 45);
        boton.setBackground(new Color(40, 40, 40));
        boton.setForeground(Color.WHITE);
        boton.setFocusPainted(false);
        boton.setFont(new Font("Consolas", Font.BOLD, 14));
        return boton;
    }

    private int factorial(int n) {
        contador++;
        this.consola.append("> factorial(" + n + ")\n");
        if (n == 0 || n == 1) {
            this.consola.append("> Caso base alcanzado (return 1)\n");
            return 1;
        }
        return n * this.factorial(n - 1);
    }

    private int fibonacci(int n) {
        contador++;
        this.consola.append("> fibonacci(" + n + ")\n");
        if (n <= 1) {
            return n;
        }
        return this.fibonacci(n - 1) + this.fibonacci(n - 2);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SimuladorRecursividad().setVisible(true));
    }
}

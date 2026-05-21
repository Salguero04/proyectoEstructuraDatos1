package ordenamientoPokedex;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.imageio.ImageIO;

public class MiniPokedex extends JFrame {

    private JPanel panelPokemon;
    private JTextArea areaLog;
    private List<Pokemon> poolCompleto;
    private List<Pokemon> listaActual;
    private java.util.Map<Integer, ImageIcon> cacheSprites = new java.util.HashMap<>();

    private JButton btnBurbuja, btnSeleccion, btnInsercion, btnQuicksort, btnNuevos;
    private Timer timer;

    // Barra de título personalizada
    private JPanel titleBar;
    private JButton btnMin, btnMax, btnClose;
    private boolean maximized = false;
    private int normalX, normalY, normalW, normalH;

    public MiniPokedex() {
        setTitle("Pokédex");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 720);
        setLocationRelativeTo(null);
        setUndecorated(true);
        setShape(new RoundRectangle2D.Double(0, 0, 1000, 720, 30, 30));

        // Panel principal con fondo degradado rojo
        JPanel mainPanel = new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                GradientPaint gp = new GradientPaint(0, 0, new Color(200, 30, 30), 0, getHeight(), new Color(120, 20, 20));
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        mainPanel.setOpaque(false);
        setContentPane(mainPanel);

        // Crear barra de título
        crearTitleBar();
        mainPanel.add(titleBar, BorderLayout.NORTH);

        // Contenido principal con margen
        JPanel content = new JPanel(new BorderLayout());
        content.setOpaque(false);
        content.setBorder(new EmptyBorder(10, 10, 10, 10));

        // Título grande
        JLabel lblTitulo = new JLabel("POKÉDEX", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Monospaced", Font.BOLD, 40));
        lblTitulo.setForeground(Color.YELLOW);
        lblTitulo.setBorder(new EmptyBorder(0, 0, 15, 0));
        content.add(lblTitulo, BorderLayout.NORTH);

        // Botones de algoritmos
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        panelBotones.setOpaque(false);
        btnBurbuja = crearBoton("BURBUJA");
        btnSeleccion = crearBoton("SELECCIÓN");
        btnInsercion = crearBoton("INSERCIÓN");
        btnQuicksort = crearBoton("QUICKSORT");
        btnNuevos = crearBoton("NUEVOS 6");
        panelBotones.add(btnBurbuja);
        panelBotones.add(btnSeleccion);
        panelBotones.add(btnInsercion);
        panelBotones.add(btnQuicksort);
        panelBotones.add(btnNuevos);
        content.add(panelBotones, BorderLayout.CENTER);

        // Pantalla central (fondo oscuro)
        JPanel screen = new JPanel(new BorderLayout());
        screen.setBackground(new Color(40, 40, 50));
        screen.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(Color.BLACK, 3),
                new EmptyBorder(10, 10, 10, 10)
        ));
        screen.setOpaque(true);

        // Grid de 6 Pokémon
        panelPokemon = new JPanel(new GridLayout(1, 6, 15, 15));
        panelPokemon.setBackground(new Color(30, 30, 40));
        panelPokemon.setBorder(new EmptyBorder(10, 10, 10, 10));
        JScrollPane scrollPokemon = new JScrollPane(panelPokemon);
        scrollPokemon.setBorder(null);
        scrollPokemon.getViewport().setBackground(new Color(30, 30, 40));
        screen.add(scrollPokemon, BorderLayout.CENTER);

        // Área de log (estilo LCD)
        areaLog = new JTextArea(10, 50);
        areaLog.setEditable(false);
        areaLog.setBackground(Color.BLACK);
        areaLog.setForeground(Color.GREEN);
        areaLog.setFont(new Font("Monospaced", Font.PLAIN, 13));
        areaLog.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(Color.GRAY, 2),
                new EmptyBorder(5, 5, 5, 5)
        ));
        JScrollPane scrollLog = new JScrollPane(areaLog);
        scrollLog.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.CYAN, 2),
                " REGISTRO DE ORDENAMIENTO ",
                TitledBorder.CENTER,
                TitledBorder.TOP,
                new Font("Monospaced", Font.BOLD, 12),
                Color.CYAN
        ));
        scrollLog.setPreferredSize(new Dimension(800, 180));
        screen.add(scrollLog, BorderLayout.SOUTH);

        content.add(screen, BorderLayout.SOUTH);
        mainPanel.add(content, BorderLayout.CENTER);

        // Cargar lista de 20 Pokémon
        cargarPool();
        elegirNuevos6();
        precargarSprites(poolCompleto);

        // Eventos
        btnNuevos.addActionListener(e -> elegirNuevos6());
        btnBurbuja.addActionListener(e -> iniciarOrdenamiento(new AnimadorBurbuja(listaActual, areaLog)));
        btnSeleccion.addActionListener(e -> iniciarOrdenamiento(new AnimadorSeleccion(listaActual, areaLog)));
        btnInsercion.addActionListener(e -> iniciarOrdenamiento(new AnimadorInsercion(listaActual, areaLog)));
        btnQuicksort.addActionListener(e -> iniciarOrdenamiento(new AnimadorQuicksort(listaActual, areaLog)));
    }

    private void crearTitleBar() {
        titleBar = new JPanel(new BorderLayout());
        titleBar.setBackground(new Color(50, 50, 60));
        titleBar.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        titleBar.setPreferredSize(new Dimension(getWidth(), 35));

        // Título
        JLabel lblTitle = new JLabel("  🎮 ORDEN POKEDEX");
        lblTitle.setFont(new Font("Monospaced", Font.BOLD, 16));
        lblTitle.setForeground(Color.WHITE);
        titleBar.add(lblTitle, BorderLayout.WEST);

        // Botones de ventana
        JPanel panelWin = new JPanel(new FlowLayout(FlowLayout.RIGHT, 5, 0));
        panelWin.setOpaque(false);

        btnMin = crearBotonWin("─");
        btnMax = crearBotonWin("□");
        btnClose = crearBotonWin("✖");

        btnMin.addActionListener(e -> setExtendedState(JFrame.ICONIFIED));
        btnMax.addActionListener(e -> toggleMaximize());
        btnClose.addActionListener(e -> System.exit(0));

        panelWin.add(btnMin);
        panelWin.add(btnMax);
        panelWin.add(btnClose);
        titleBar.add(panelWin, BorderLayout.EAST);

        // Arrastrar ventana
        MouseAdapter drag = new MouseAdapter() {
            int x, y;
            @Override
            public void mousePressed(MouseEvent e) { x = e.getX(); y = e.getY(); }
            @Override
            public void mouseDragged(MouseEvent e) {
                if (!maximized) {
                    Point p = getLocation();
                    setLocation(p.x + e.getX() - x, p.y + e.getY() - y);
                }
            }
        };
        titleBar.addMouseListener(drag);
        titleBar.addMouseMotionListener(drag);
    }

    private JButton crearBotonWin(String simbolo) {
        JButton b = new JButton(simbolo);
        b.setFont(new Font("Monospaced", Font.BOLD, 14));
        b.setForeground(Color.WHITE);
        b.setBackground(new Color(70, 70, 80));
        b.setFocusPainted(false);
        b.setBorder(BorderFactory.createEmptyBorder(2, 8, 2, 8));
        b.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        if (simbolo.equals("✖")) {
            b.addMouseListener(new MouseAdapter() {
                @Override public void mouseEntered(MouseEvent e) { b.setBackground(new Color(200, 50, 50)); }
                @Override public void mouseExited(MouseEvent e) { b.setBackground(new Color(70, 70, 80)); }
            });
        } else {
            b.addMouseListener(new MouseAdapter() {
                @Override public void mouseEntered(MouseEvent e) { b.setBackground(new Color(90, 90, 100)); }
                @Override public void mouseExited(MouseEvent e) { b.setBackground(new Color(70, 70, 80)); }
            });
        }
        return b;
    }

    private void toggleMaximize() {
        if (maximized) {
            setBounds(normalX, normalY, normalW, normalH);
            setShape(new RoundRectangle2D.Double(0, 0, normalW, normalH, 30, 30));
            maximized = false;
        } else {
            normalX = getX(); normalY = getY();
            normalW = getWidth(); normalH = getHeight();
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            Rectangle bounds = ge.getMaximumWindowBounds();
            setBounds(bounds);
            setShape(new RoundRectangle2D.Double(0, 0, bounds.width, bounds.height, 0, 0));
            maximized = true;
        }
    }

    private JButton crearBoton(String texto) {
        JButton b = new JButton(texto);
        b.setFont(new Font("Monospaced", Font.BOLD, 14));
        b.setForeground(Color.WHITE);
        b.setBackground(new Color(60, 60, 80));
        b.setFocusPainted(false);
        b.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(Color.BLACK, 2),
                new EmptyBorder(8, 15, 8, 15)
        ));
        b.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        return b;
    }

    private void cargarPool() {
        poolCompleto = new ArrayList<>();
        String[] nombres = {
            "Bulbasaur", "Ivysaur", "Venusaur", "Charmander", "Charmeleon", "Charizard",
            "Squirtle", "Wartortle", "Blastoise", "Caterpie", "Metapod", "Butterfree",
            "Weedle", "Kakuna", "Beedrill", "Pidgey", "Pidgeotto", "Pidgeot", "Rattata", "Raticate"
        };
        for (int i = 1; i <= 20; i++) {
            poolCompleto.add(new Pokemon(i, nombres[i-1]));
        }
    }

    private void elegirNuevos6() {
        if (timer != null && timer.isRunning()) timer.stop();
        List<Pokemon> temp = new ArrayList<>(poolCompleto);
        Collections.shuffle(temp);
        listaActual = new ArrayList<>(temp.subList(0, 6));
        actualizarPanel();
        areaLog.setText("✅ Nuevos 6 Pokémon (desordenados).\n");
        habilitarBotones(true);
    }

    private void precargarSprites(List<Pokemon> lista) {
        new Thread(() -> {
            for (Pokemon p : lista) {
                if (!cacheSprites.containsKey(p.getId())) {
                    try {
                        URL url = new URL(p.getSpriteUrl());
                        BufferedImage img = ImageIO.read(url);
                        if (img != null) {
                            Image scaled = img.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
                            cacheSprites.put(p.getId(), new ImageIcon(scaled));
                        }
                    } catch (Exception e) {
                        System.err.println("Error sprite " + p.getNombre());
                    }
                }
                p.setSprite(cacheSprites.get(p.getId()));
            }
            SwingUtilities.invokeLater(() -> actualizarPanel());
        }).start();
    }

    private void actualizarPanel() {
        panelPokemon.removeAll();
        for (Pokemon p : listaActual) {
            JPanel tarjeta = new JPanel(new BorderLayout());
            tarjeta.setBackground(new Color(50, 50, 70));
            tarjeta.setBorder(BorderFactory.createCompoundBorder(
                    new LineBorder(Color.BLACK, 2),
                    new EmptyBorder(5, 5, 5, 5)
            ));
            tarjeta.setPreferredSize(new Dimension(130, 150));

            JLabel lblImg = new JLabel();
            if (p.getSprite() != null) lblImg.setIcon(p.getSprite());
            else lblImg.setText("🌀");
            lblImg.setHorizontalAlignment(SwingConstants.CENTER);
            tarjeta.add(lblImg, BorderLayout.CENTER);

            JPanel info = new JPanel(new GridLayout(2, 1));
            info.setBackground(new Color(50, 50, 70));
            JLabel num = new JLabel("#" + p.getId(), SwingConstants.CENTER);
            num.setFont(new Font("Monospaced", Font.BOLD, 12));
            num.setForeground(Color.CYAN);
            JLabel nom = new JLabel(p.getNombre(), SwingConstants.CENTER);
            nom.setFont(new Font("Monospaced", Font.PLAIN, 11));
            nom.setForeground(Color.WHITE);
            info.add(num);
            info.add(nom);
            tarjeta.add(info, BorderLayout.SOUTH);

            panelPokemon.add(tarjeta);
        }
        panelPokemon.revalidate();
        panelPokemon.repaint();
    }

    private void habilitarBotones(boolean enabled) {
        btnBurbuja.setEnabled(enabled);
        btnSeleccion.setEnabled(enabled);
        btnInsercion.setEnabled(enabled);
        btnQuicksort.setEnabled(enabled);
        btnNuevos.setEnabled(enabled);
    }

    private void iniciarOrdenamiento(Animador anim) {
        if (timer != null && timer.isRunning()) return;
        habilitarBotones(false);
        areaLog.append("\n--- " + anim.getNombre() + " ---\n");
        timer = new Timer(350, e -> {
            if (!anim.avanzar()) {
                timer.stop();
                habilitarBotones(true);
                areaLog.append(anim.getNombre() + " completado.\n");
                areaLog.setCaretPosition(areaLog.getDocument().getLength());
            }
            listaActual = anim.getListaActual();
            actualizarPanel();
            areaLog.setCaretPosition(areaLog.getDocument().getLength());
        });
        timer.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MiniPokedex().setVisible(true));
    }
}
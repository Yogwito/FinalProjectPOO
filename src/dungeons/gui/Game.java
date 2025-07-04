package dungeons.gui;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import Class.Dungeon;
import java.awt.Image;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JFrame;

/**
 * La clase Game representa la ventana principal del juego y gestiona la lógica de actualización y renderizado.
 * Implementa la interfaz Drawable, permitiendo que el dungeon se dibuje y se actualice en la interfaz gráfica.
 * Utiliza doble buffering para evitar parpadeos y un temporizador para actualizar el estado del juego periódicamente.
 * También gestiona la interacción del usuario mediante eventos de teclado.
 *
 * @author Juan Sebastian Arias
 * @author Juan Jose Trujillo
 * @author Juan Jose Cardona
 * @version 1.0.2
 */
public class Game extends javax.swing.JFrame implements Drawable {
    /**
     * El mapa del juego.
     */
    private final Dungeon map;
    
    /**
     * Panel que contiene el dungeon (puede ser null si no se usa).
     */
    private DungeonPanel dungeonPanel;

    /**
     * Imagen fuera de pantalla utilizada para el doble buffering.
     */
    private Image offScreenImage;

    /**
     * Gráficos fuera de pantalla utilizados para el doble buffering.
     */
    private Graphics offScreenGraphics;

    /**
     * Constructor de la clase Game.
     * Inicializa los componentes de la interfaz de usuario y establece el mapa del juego.
     * También inicia un temporizador que actualiza la puntuación y redibuja el mapa cada segundo.
     *
     * @param map El mapa del juego.
     */
    public Game(Dungeon map) {
        initComponents();
        this.map = map;
        this.map.setDrawable(this); // ← esto es obligatorio

        this.map.setGame(this);

        // Asegura que el JFrame reciba eventos de teclado
        this.setFocusable(true);
        this.requestFocusInWindow();

        // Configura la ventana
        this.setTitle("Scavenger Hunt");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 850);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        // Inicia el temporizador de actualización del juego
        Timer timer = new Timer(true);
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                map.setScore();
                map.redraw();

                // Opcional: cerrar ventana solo si se confirma que todo terminó
                if (!map.isActive()) {
                    // dispose(); // Puedes activarlo si todo está bien con reintento
                }
            }
        }, 1000, 1000);
    }


    /**
     * Este método se utiliza para actualizar la pantalla del juego.
     * Llama al método paint para redibujar la pantalla.
     * @param g Los gráficos en los que se dibuja.
     */
    public void update(Graphics g) {
        paint(g);
    }
    
    /**
     * Este método se utiliza para dibujar la pantalla del juego.
     * Utiliza un enfoque de doble buffering para evitar el parpadeo.
     * @param g Los gráficos en los que se dibuja.
     */
    @Override
    public void paint(Graphics g) {
    if (offScreenImage == null) {
        offScreenImage = createImage(getWidth(), getHeight());
        offScreenGraphics = offScreenImage.getGraphics();
    }

        // Clear the off-screen image
        offScreenGraphics.setColor(getBackground());
        offScreenGraphics.fillRect(0, 0, getWidth(), getHeight());

        // Draw on the off-screen image
        map.draw(offScreenGraphics);  // Draw the dungeon
        // Copy the off-screen image to the screen
        g.drawImage(offScreenImage, 0, 0, this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        Jvida = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 591, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 494, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        Jvida.setBackground(new java.awt.Color(153, 153, 153));
        Jvida.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 12)); // NOI18N
        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(250, 250, 250)
                .addComponent(Jvida, javax.swing.GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(315, 315, 315)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(365, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(561, Short.MAX_VALUE)
                .addComponent(Jvida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        if (!map.isActive()) return;  // Si el mapa está inactivo, no hacer nada
        map.actKnight(evt.getKeyCode());
    }//GEN-LAST:event_formKeyPressed

    /**
     * Redibuja la ventana del juego llamando a repaint().
     */
    @Override
    public void redraw() {
        repaint();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Jvida;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}

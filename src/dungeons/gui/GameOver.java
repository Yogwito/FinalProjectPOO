/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package dungeons.gui;

import Class.Dungeon;
import Class.RegistroPartida;
import dungeons.gui.Game;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 * Clase GameOver que representa el cuadro de diálogo mostrado cuando el jugador pierde la partida.
 * Permite mostrar la imagen de Game Over, guardar el puntaje y reiniciar el juego si el usuario lo desea.
 * Hereda de javax.swing.JDialog y utiliza componentes Swing para la interfaz gráfica.
 *
 * @author Juan Sebastian Arias
 * @author Juan Jose Trujillo
 * @author Juan Jose Cardona
 * @version 1.0.2
 */
public class GameOver extends javax.swing.JDialog {
    /**
     * Nombre del nivel jugado.
     */
    private String nivel;
    /**
     * Tipo de caballero seleccionado.
     */
    private String tipo;
    /**
     * Nombre del jugador.
     */
    private String nombreJugador;
    /**
     * Referencia al juego anterior (puede ser null).
     */
    private Game juegoAnterior;

    /**
     * Crea una nueva instancia del diálogo GameOver.
     * @param parent Ventana padre.
     * @param modal Indica si el diálogo es modal.
     * @param nivel Nombre del nivel jugado.
     * @param tipo Tipo de caballero seleccionado.
     * @param nombreJugador Nombre del jugador.
     * @param juegoAnterior Referencia al juego anterior (puede ser null).
     */
    public GameOver(java.awt.Frame parent, boolean modal, String nivel, String tipo, String nombreJugador, Game juegoAnterior) {
        super(parent, modal);
        
        initComponents();
        this.nivel = nivel;
        this.tipo = tipo;
        this.nombreJugador = nombreJugador;
        this.juegoAnterior = juegoAnterior;

        jLabel2.setIcon(new ImageIcon(getClass().getResource("/Img/Gameover.png")));

        RegistroPartida registro = new RegistroPartida();
        int puntajeFinal = 0;
        registro.guardar(nombreJugador, puntajeFinal);
    }

    /**
     * Sobrecarga del constructor para crear el diálogo GameOver sin referencia al juego anterior.
     * @param parent Ventana padre.
     * @param modal Indica si el diálogo es modal.
     * @param nivel Nombre del nivel jugado.
     * @param tipo Tipo de caballero seleccionado.
     * @param nombreJugador Nombre del jugador.
     */
    public GameOver(java.awt.Frame parent, boolean modal, String nivel, String tipo, String nombreJugador) {
        this(parent, modal, nivel, tipo, nombreJugador, null);
    }

    /**
     * Inicializa los componentes gráficos del diálogo.
     * Este método es generado automáticamente por el Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButtonReintentar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Gameover.png"))); // NOI18N

        jButtonReintentar.setText("Reintentar");
        jButtonReintentar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReintentarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addComponent(jButtonReintentar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonReintentar)
                .addGap(0, 23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Acción ejecutada al presionar el botón "Reintentar".
     * Reinicia la partida y cierra la ventana de Game Over.
     * @param evt Evento de acción del botón.
     */
    private void jButtonReintentarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReintentarActionPerformed
        // TODO add your handling code here:
        java.awt.Window[] windows = java.awt.Window.getWindows();
        for (java.awt.Window w : windows) {
            if (w instanceof Game) {
                w.dispose();
            }
        }

        // Crea la nueva partida
        Dungeon nuevoMapa = new Dungeon(0, 0, 800, 800, tipo, nivel, nombreJugador);
        Game nuevaPartida = new Game(nuevoMapa);
        nuevaPartida.setTitle("Scavenger Hunt");
        nuevaPartida.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        nuevaPartida.setSize(800, 850); 
        nuevaPartida.setLocationRelativeTo(null);
        nuevaPartida.setVisible(true);
        nuevaPartida.requestFocus(); // Recibe eventos de teclado

        // Cierra la ventana actual de GameOver
        dispose();

    }//GEN-LAST:event_jButtonReintentarActionPerformed

    /**
     * Método principal para ejecutar el diálogo GameOver de forma independiente.
     * @param args Argumentos de línea de comandos (no utilizados).
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
            java.util.logging.Logger.getLogger(GameOver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GameOver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GameOver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameOver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                GameOver dialog = new GameOver(new javax.swing.JFrame(), true, "nivel", "tipo", null);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonReintentar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}

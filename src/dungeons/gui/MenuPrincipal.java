/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package dungeons.gui;

import javax.swing.JFrame;
import java.io.IOException;

/**
 * Clase MenuPrincipal que representa la ventana principal del menú del juego.
 * Permite al usuario iniciar el juego, salir de la aplicación y muestra la imagen principal.
 * Hereda de javax.swing.JFrame y utiliza componentes Swing para la interfaz gráfica.
 *
 * @author Juan Sebastian Arias
 * @author Juan Jose Trujillo
 * @author Juan Jose Cardona
 * @version 1.0.2
 */
public class MenuPrincipal extends javax.swing.JFrame {
    /**
     * Tipo de caballero seleccionado (puede ser null si no se ha seleccionado).
     */
    private String type = null;

    /**
     * Crea una nueva instancia del menú principal.
     * Inicializa los componentes y reproduce la música de fondo.
     */
    public MenuPrincipal() {
        initComponents();
        try {
    PlayerSoundPrincipal musica = new PlayerSoundPrincipal("Medievalmusic.wav");
    Thread hiloMusica = new Thread(musica);
    hiloMusica.start();
    } catch (IOException ex) {
    ex.printStackTrace(); // Muestra si el archivo no se encuentra
}
    }

    /**
     * Inicializa los componentes gráficos del menú principal.
     * Este método es generado automáticamente por el Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jbQuit = new javax.swing.JButton();
        jbStart = new javax.swing.JButton();
        imagen = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jbQuit.setBackground(new java.awt.Color(0, 0, 0));
        jbQuit.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 18)); // NOI18N
        jbQuit.setForeground(new java.awt.Color(255, 255, 0));
        jbQuit.setText("Quit");
        jbQuit.setBorder(null);
        jbQuit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbQuitActionPerformed(evt);
            }
        });

        jbStart.setBackground(new java.awt.Color(0, 0, 0));
        jbStart.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 18)); // NOI18N
        jbStart.setForeground(new java.awt.Color(255, 255, 0));
        jbStart.setText("Start");
        jbStart.setBorder(null);
        jbStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbStartActionPerformed(evt);
            }
        });

        imagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/scavengerhunts.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(imagen)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jbQuit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbStart, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imagen)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jbStart, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbQuit, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Acción ejecutada al presionar el botón "Start".
     * Abre la ventana de selección de niveles y cierra el menú principal.
     * @param evt Evento de acción del botón.
     */
    private void jbStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbStartActionPerformed
        Levels levelselection = new Levels();
        levelselection.setVisible(true);
        JFrame frame  = new JFrame("Levels");
        frame.setContentPane(levelselection);
        frame.pack();
        frame.setVisible(true);
        
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_jbStartActionPerformed

    /**
     * Acción ejecutada al presionar el botón "Quit".
     * Sale de la aplicación.
     * @param evt Evento de acción del botón.
     */
    private void jbQuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbQuitActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jbQuitActionPerformed

    /**
     * Método principal para ejecutar el menú principal de forma independiente.
     * @param args Argumentos de línea de comandos (no utilizados).
     */
    public static void main(String args[]) {
      MenuPrincipal ventana = new MenuPrincipal();
        ventana.setSize(587, 492);
        ventana.setVisible(true);
    }

    /**
     * Establece el tipo de caballero seleccionado.
     * @param type El tipo de caballero a establecer.
     */
    public void setType(String type) {
        this.type = type;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel imagen;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbQuit;
    private javax.swing.JButton jbStart;
    // End of variables declaration//GEN-END:variables

    
}

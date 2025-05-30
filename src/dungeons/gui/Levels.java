package dungeons.gui;

import Class.Dungeon;
import javax.swing.JFrame;

/**
 * Clase Levels que representa el panel de selección de niveles del juego.
 * Permite al usuario elegir entre diferentes niveles y regresar al menú principal.
 * Hereda de javax.swing.JPanel y utiliza componentes Swing para la interfaz gráfica.
 *
 * @author Juan Sebastian Arias
 * @author Juan Jose Trujillo
 * @author Juan Jose Cardona
 * @version 1.0.2
 */
public class Levels extends javax.swing.JPanel {
    /**
     * Nombre del caballero seleccionado para el nivel.
     */
    private String knight = null;

    /**
     * Crea una nueva instancia del panel Levels.
     */
    public Levels() {
        initComponents();
    }

    /**
     * Inicializa los componentes gráficos del panel.
     * Este método es generado automáticamente por el Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Level1jButton = new javax.swing.JButton();
        Level2jButton = new javax.swing.JButton();
        Level3jButton = new javax.swing.JButton();
        Level4jButton = new javax.swing.JButton();
        LevelfinaljButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 0, 0));
        setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(102, 102, 0)));

        Level1jButton.setBackground(new java.awt.Color(102, 102, 0));
        Level1jButton.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 12)); // NOI18N
        Level1jButton.setForeground(new java.awt.Color(255, 255, 255));
        Level1jButton.setText("Lvl 1");
        Level1jButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Level1jButtonActionPerformed(evt);
            }
        });

        Level2jButton.setBackground(new java.awt.Color(102, 102, 0));
        Level2jButton.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 12)); // NOI18N
        Level2jButton.setForeground(new java.awt.Color(255, 255, 255));
        Level2jButton.setText("Lvl 2");
        Level2jButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Level2jButtonActionPerformed(evt);
            }
        });

        Level3jButton.setBackground(new java.awt.Color(102, 102, 0));
        Level3jButton.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 12)); // NOI18N
        Level3jButton.setForeground(new java.awt.Color(255, 255, 255));
        Level3jButton.setText("Lvl 3");
        Level3jButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Level3jButtonActionPerformed(evt);
            }
        });

        Level4jButton.setBackground(new java.awt.Color(102, 102, 0));
        Level4jButton.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 12)); // NOI18N
        Level4jButton.setForeground(new java.awt.Color(255, 255, 255));
        Level4jButton.setText("Lvl 4");
        Level4jButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Level4jButtonActionPerformed(evt);
            }
        });

        LevelfinaljButton.setBackground(new java.awt.Color(102, 102, 0));
        LevelfinaljButton.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 12)); // NOI18N
        LevelfinaljButton.setForeground(new java.awt.Color(255, 255, 255));
        LevelfinaljButton.setText("Final Lvl");
        LevelfinaljButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LevelfinaljButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 153, 0));
        jLabel1.setText("Level Selection");

        jButton1.setBackground(new java.awt.Color(51, 51, 51));
        jButton1.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(153, 153, 0));
        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(LevelfinaljButton)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Level1jButton)
                            .addComponent(Level3jButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Level2jButton)
                            .addComponent(Level4jButton))
                        .addGap(62, 62, 62))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(jLabel1)
                .addContainerGap(98, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Level1jButton)
                    .addComponent(Level2jButton))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Level4jButton)
                    .addComponent(Level3jButton))
                .addGap(35, 35, 35)
                .addComponent(LevelfinaljButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Acción ejecutada al presionar el botón para el Nivel 1.
     * Abre la selección de personaje y asigna el archivo de nivel correspondiente.
     * @param evt Evento de acción del botón.
     */
    private void Level1jButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Level1jButtonActionPerformed
        // TODO add your handling code here:
        CharacterSelection selection = new CharacterSelection();
        selection.setVisible(true);
        setKnight(selection.getKnight());
        selection.setLevel("MapaPruebas.txt");
        
        JFrame frame = (JFrame) javax.swing.SwingUtilities.getWindowAncestor(this);
        frame.dispose();
    }//GEN-LAST:event_Level1jButtonActionPerformed

    /**
     * Acción ejecutada al presionar el botón "Back".
     * Regresa al menú principal y cierra la ventana actual.
     * @param evt Evento de acción del botón.
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:  private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {               
        MenuPrincipal menu = new MenuPrincipal();
        menu.setType(getKnight());
        menu.setSize(587, 492);
        menu.setVisible(true);
        this.setVisible(false);
        
        JFrame frame = (JFrame) javax.swing.SwingUtilities.getWindowAncestor(this);
        frame.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * Acción ejecutada al presionar el botón para el Nivel 2.
     * Abre la selección de personaje y asigna el archivo de nivel correspondiente.
     * @param evt Evento de acción del botón.
     */
    private void Level2jButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Level2jButtonActionPerformed
        // TODO add your handling code here:
        CharacterSelection selection = new CharacterSelection();
        selection.setVisible(true);
        selection.setLevel("Level2.txt");
        
        JFrame frame = (JFrame) javax.swing.SwingUtilities.getWindowAncestor(this);
        frame.dispose();
    }//GEN-LAST:event_Level2jButtonActionPerformed

    /**
     * Acción ejecutada al presionar el botón para el Nivel 3.
     * Abre la selección de personaje y asigna el archivo de nivel correspondiente.
     * @param evt Evento de acción del botón.
     */
    private void Level3jButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Level3jButtonActionPerformed
        // TODO add your handling code here:
        CharacterSelection selection = new CharacterSelection();
        selection.setVisible(true);
        selection.setLevel("Level3.txt");
        
        JFrame frame = (JFrame) javax.swing.SwingUtilities.getWindowAncestor(this);
        frame.dispose();
    }//GEN-LAST:event_Level3jButtonActionPerformed

    /**
     * Acción ejecutada al presionar el botón para el Nivel 4.
     * Abre la selección de personaje y asigna el archivo de nivel correspondiente.
     * @param evt Evento de acción del botón.
     */
    private void Level4jButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Level4jButtonActionPerformed
        // TODO add your handling code here:
        CharacterSelection selection = new CharacterSelection();
        selection.setVisible(true);
        selection.setLevel("Level4.txt");
        
        JFrame frame = (JFrame) javax.swing.SwingUtilities.getWindowAncestor(this);
        frame.dispose();
    }//GEN-LAST:event_Level4jButtonActionPerformed

    /**
     * Acción ejecutada al presionar el botón para el Nivel Final.
     * Abre la selección de personaje y asigna el archivo de nivel correspondiente.
     * @param evt Evento de acción del botón.
     */
    private void LevelfinaljButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LevelfinaljButtonActionPerformed
        // TODO add your handling code here:
        CharacterSelection selection = new CharacterSelection();
        selection.setVisible(true);
        selection.setLevel("Level5.txt");
        
        JFrame frame = (JFrame) javax.swing.SwingUtilities.getWindowAncestor(this);
        frame.dispose();
    }//GEN-LAST:event_LevelfinaljButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Level1jButton;
    private javax.swing.JButton Level2jButton;
    private javax.swing.JButton Level3jButton;
    private javax.swing.JButton Level4jButton;
    private javax.swing.JButton LevelfinaljButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

    /**
     * Obtiene el nombre del caballero seleccionado.
     * @return El nombre del caballero.
     */
    public String getKnight() {
        return knight;
    }

    /**
     * Establece el nombre del caballero seleccionado.
     * @param knight El nombre del caballero a establecer.
     */
    public void setKnight(String knight) {
        this.knight = knight;
    }
}

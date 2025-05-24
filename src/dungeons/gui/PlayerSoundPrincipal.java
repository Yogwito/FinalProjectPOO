/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dungeons.gui;

import java.io.IOException;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;

/**
 *
 * @author Juan Sebastian Arias
 * @author Juan Jose Trujillo
 * @author Juan Jose Cardona
 * @version 1.0.2
 */
public class PlayerSoundPrincipal extends PlayerSound implements Runnable{
    
    /**
     * Constructor de la clase PlayerSoundPrincipal.
     * Carga el sonido principal y abre el clip para su reproducción.
     *
     * @param name El nombre del archivo de sonido a cargar.
     * @throws java.io.IOException
     */
    public PlayerSoundPrincipal(String name) throws IOException {
        super(name);
        setPrincipalSound(loadClip(name));
        try {
            setClip(AudioSystem.getClip());
        } catch (LineUnavailableException ex) {
            // Manejo de excepción si la línea de audio no está disponible.
        }
        try {
            getClip().open(getPrincipalSound());
        } catch (LineUnavailableException ex) {
            // Manejo de excepción si la línea de audio no está disponible.
        } catch (IOException ex) {
            // Manejo de excepción si ocurre un error de entrada/salida.
        }
    }
  
    /**
     * Inicia la reproducción del sonido en un hilo de ejecución separado.
     */
    @Override
    public void run() {
        while (true) {
            if (getPrincipalSound() != null) {
                try {
                    getClip().setFramePosition(0);
                    getClip().start();
                    Thread.sleep(21800);
                } catch (InterruptedException ex) {
                    System.out.println("Error al pausar");
                }
            }
        }
    }
}

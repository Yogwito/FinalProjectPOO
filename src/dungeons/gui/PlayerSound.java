/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dungeons.gui;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.sound.sampled.AudioInputStream;


/**
 * Clase abstracta que maneja la reproducción de sonidos en el juego.
 * Permite cargar, reproducir y detener clips de audio utilizando la API de Java Sound.
 *
 * @author Juan Sebastian Arias
 * @author Juan Jose Trujillo
 * @author Juan Jose Cardona
 * @version 1.0.2
 */
public abstract class PlayerSound {
    /**
     * Flujo de entrada de audio principal utilizado para cargar el sonido.
     */
    private AudioInputStream principalSound;
    /**
     * Clip de audio que se reproduce.
     */
    private Clip clip;

    /**
     * Constructor de la clase PlayerSound.
     * Carga el clip de audio y lo abre para su reproducción.
     *
     * @param name Nombre del archivo de audio a cargar.
     */
    public PlayerSound(String name) {
        this.principalSound = loadClip(name);
        try {
            this.clip = AudioSystem.getClip();
        } catch (LineUnavailableException ex) {
            // Manejo silencioso, el error se ignora
        }
        try {
            clip.open(principalSound);
        } catch (LineUnavailableException | IOException ex) {
            // Manejo silencioso, el error se ignora
        }
    }

    /**
     * Carga un clip de audio desde un archivo.
     *
     * @param name Nombre del archivo de audio a cargar.
     * @return Flujo de entrada de audio del archivo cargado, o null si ocurre un error.
     */
    public AudioInputStream loadClip(String name) {
        AudioInputStream audioStream = null;
        try {
            File audioFile = new File(name);
            audioStream = AudioSystem.getAudioInputStream(audioFile);
            return audioStream;
        } catch (UnsupportedAudioFileException | IOException ex) {
            System.out.println("Error al cargar");
        }
        return audioStream;
    }

    /**
     * Detiene la reproducción del sonido actual.
     */
    public void stopSound() {
        getClip().stop();
    }

    /**
     * Obtiene el flujo de entrada de audio principal.
     * @return El flujo de entrada de audio principal.
     */
    public AudioInputStream getPrincipalSound() {
        return principalSound;
    }

    /**
     * Establece el flujo de entrada de audio principal.
     * @param principalSound El nuevo flujo de entrada de audio principal.
     */
    public void setPrincipalSound(AudioInputStream principalSound) {
        this.principalSound = principalSound;
    }

    /**
     * Obtiene el clip de audio.
     * @return El clip de audio.
     */
    public Clip getClip() {
        return clip;
    }

    /**
     * Establece el clip de audio.
     * @param clip El nuevo clip de audio.
     */
    public void setClip(Clip clip) {
        this.clip = clip;
    }
}

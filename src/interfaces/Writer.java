/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaces;

/**
 * Interfaz Writer para guardar información, como puntajes de jugadores.
 * Define el método para guardar el nombre del jugador y su puntaje.
 *
 * @author juans
 */
public interface Writer {
    /**
     * Guarda el nombre del jugador y su puntaje.
     * @param nombreJugador Nombre del jugador.
     * @param puntaje Puntaje a guardar.
     */
    void guardar(String nombreJugador, int puntaje);
}

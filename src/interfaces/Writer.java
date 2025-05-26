/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaces;

/**
 *
 * @author juans
 */
import java.util.ArrayList;

public interface Writer {
    boolean guardar(String filePath, ArrayList<String> lines);
}

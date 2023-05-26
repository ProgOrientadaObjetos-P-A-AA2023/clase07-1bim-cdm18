/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete5;

import java.io.Serializable;

/**
 *
 * @author SALA I
 */
public class Ciudad implements Serializable {
    private String provincia;
    private String nombre;

    public Ciudad(String p, String n) {
        provincia = p;
        nombre = n;
    }

    public void establecerProvincia(String p) {
        provincia = p;
    }

    public void establecerNombre(String n) {
        nombre = n;
    }

    public String obtenerProvincia() {
        return provincia;
    }

    public String obtenerNombre() {
        return nombre;
    }
    
    
    
    
    
}

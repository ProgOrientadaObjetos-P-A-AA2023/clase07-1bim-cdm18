/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete5;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author reroes
 */
public class Hospital implements Serializable {

    private String nombre;
    private int numeroCamas;
    private double presupuesto;
    private Ciudad ciudad; // 2 caracteristicas

    public Hospital(String n, int nC, double pres, Ciudad ciu) {
        nombre = n;
        numeroCamas = nC;
        presupuesto = pres;
        ciudad = ciu;
    }

    public void establecerNombre(String n) {
        nombre = n;
    }

    public void establecerNumeroCamas(int nC) {
        numeroCamas = nC;
    }

    public void establecerPresupuesto(double pres) {
        presupuesto = pres;
    }

    public void establecerCiudad(Ciudad ciu) {
        ciudad = ciu;
    }

    public String obtenerNombre() {
        return nombre;
    }

    public int obtenerNumeroCamas() {
        return numeroCamas;
    }

    public double obtenerPresupuesto() {
        return presupuesto;
    }

    public Ciudad obtenerCiudad() {
        return ciudad;
    }

    /*
        
    @Override
    public String toString() {
        
        String mensaje;
        mensaje = String.format ("%s;%d;%.2f;%s;%s",
                obtenerNombre(),
                obtenerNumeroCamas(),
                obtenerPresupuesto(),
                obtenerCiudad().obtenerNombre(),
                obtenerCiudad().obtenerProvincia());
        
        return mensaje;
    }
    
     */
}

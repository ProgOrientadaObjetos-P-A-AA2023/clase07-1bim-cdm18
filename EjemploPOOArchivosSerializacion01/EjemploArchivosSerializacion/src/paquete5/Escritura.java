/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete5;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author SALA I
 */
public class Escritura {

    private Hospital [] listaHospitales;
    private String nombreArchivo;
    private ObjectOutputStream salida;
    private Hospital registroHospital;

    public Escritura(Hospital [] h, String nombreAr) {
        listaHospitales = h;
        nombreArchivo = nombreAr;

        establecerListaHospitales();

        try // abre el archivo
        {
            salida = new ObjectOutputStream(
                    new FileOutputStream(nombreArchivo));
            // proceso para ingresar nuevamente los valores del archivo
            if (obtenerListaHospitales().size() > 0) {
                for (int i = 0; i < obtenerListaHospitales().size(); i++) {
                    listaHospitales.get(i);
                    establecerSalida();
                }
            }
        } // fin de try
        catch (IOException ioException) {
            System.err.println("Error al abrir el archivo.");
        } // fin de catch

    }
    
     public void establecerRegistro(Hospital j) {
        registroHospital = j;
    }
    
    public void cerrarArchivo() {
        try // cierra el archivo
        {
            if (salida != null) {
                salida.close();
            }
        } // fin de try
        catch (IOException ioException) {
            System.err.println("Error al cerrar el archivo.");

        } // fin de catch
    }

    public void establecerSalida() {
        try {
            salida.writeObject(listaHospitales); // envía el registro como 
            // objeto al archivo
        } catch (IOException ex) {
            System.err.println("Error al escribir en el archivo.");
        }
    }

    public void establecerListaHospitales() {
        Lectura l
                = new Lectura(obtenerNombreArchivo());
        l.establecerListaHospitales();
        listaHospitales = l.obtenerListaHospitales();
    }

    public void establecerNombreArchivo(String n) {
        nombreArchivo = n;
    }

    public ArrayList<Hospital> obtenerListaHospitales() {
        return listaHospitales;
    }

    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }

}

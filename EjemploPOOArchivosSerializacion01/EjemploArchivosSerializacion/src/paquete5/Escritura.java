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
    private String nombreArchivo;
    private ObjectOutputStream salida; // envía los datos a un archivo
    private Hospital registro;
    private ArrayList<Hospital> listaH;
    
   

    public Escritura(String nombreAr) {
        // listaHospitales = h;
        nombreArchivo = nombreAr;

        establecerListaHospitales();

        try // abre el archivo
        {
            salida = new ObjectOutputStream(
                    new FileOutputStream(nombreArchivo));
            // proceso para ingresar nuevamente los valores del archivo
            if (obtenerListaHospitales().size() > 0) {
                for (int i = 0; i < obtenerListaHospitales().size(); i++) {
                    establecerRegistro(obtenerListaHospitales().get(i));
                    establecerSalida();
                }
            }
        } // fin de try
        catch (IOException ioException) {
            System.err.println("Error al abrir el archivo.");
        } // fin de catch

    }
    
     public void establecerRegistro(Hospital ho) {
        registro = ho;
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
            salida.writeObject(registro); // envía el registro como salida
        
         } catch (IOException ex) {
            System.err.println("Error al escribir en el archivo.");
        }
    }

    public void establecerListaHospitales() {
        Lectura l = new Lectura(obtenerNombreArchivo());
        l.establecerListaHospitales();
        listaH = l.obtenerListaHospitales();
    }

    public void establecerNombreArchivo(String n) {
        nombreArchivo = n;
    }

    public ArrayList<Hospital> obtenerListaHospitales() {
        return listaH;
    }

    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }
    
     public ObjectOutputStream obtenerSalida(){
        return salida;
    }
     
     

}

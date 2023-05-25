/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete5;

import java.util.ArrayList;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 *
 * @author SALA I
 */
public class Lectura {

    private ObjectInputStream entrada;
    private String nombreArchivo;
    private ArrayList<Hospital> listaH;

    public Lectura(String n) {
        nombreArchivo = n;
        File f = new File(obtenerNombreArchivo());
        if (f.exists()) {
            try // abre el archivo
            {
                entrada = new ObjectInputStream(
                        new FileInputStream(n));
            } // fin de try
            catch (IOException ioException) {
                System.err.println("Error al abrir el archivo.");

            } // fin de catch
        }
    }

    public void establecerListaHospitales() {
        listaH = new ArrayList<>();
        File f = new File(obtenerNombreArchivo());
        if (f.exists()) {

            while (true) {
                try {
                    Hospital registro = (Hospital) entrada.readObject();
                    listaH.add(registro);
                } catch (EOFException endOfFileException) {
                    return; // se llegó al fin del archivo

                } catch (IOException ex) {
                    System.err.println("Error al leer el archivo: " + ex);
                } catch (ClassNotFoundException ex) {
                    System.err.println("No se pudo crear el objeto: " + ex);
                } catch (Exception ex) {
                    // System.err.println("No hay datos en el archivo: " + ex);
                    break;
                }
            }
        }

    }
    public void cerrarArchivo() {
        try // cierra el archivo y sale
        {
            if (entrada != null) {
                entrada.close();
            }
            System.exit(0);
        } // fin de try
        catch (IOException ioException) {
            System.err.println("Error al cerrar el archivo.");
            System.exit(1);
        } // fin de catch
    } // fin del método cerrarArchivo
    

    public void establecerNombreArchivo(String nA) {
        nombreArchivo = nA;
    }

    public ArrayList<Hospital> obtenerListaHospitales() {
        return listaH;
    }

    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }

   
    @Override
    public String toString() {

        String cadena = "Lista de hospitales\n";

        for (int i = 0; i < obtenerListaHospitales().size(); i++) {

            Hospital h = obtenerListaHospitales().get(i);
            cadena = String.format("%s;%d;%s;%d;%.2f;%s;%s\n", cadena,
                    i + 1,
                    h.obtenerNombre(),
                    h.obtenerNumeroCamas(),
                    h.obtenerPresupuesto(),
                    h.obtenerCiudad().obtenerProvincia(),
                    h.obtenerCiudad().obtenerNombre());
        }

        return cadena;
    }
}

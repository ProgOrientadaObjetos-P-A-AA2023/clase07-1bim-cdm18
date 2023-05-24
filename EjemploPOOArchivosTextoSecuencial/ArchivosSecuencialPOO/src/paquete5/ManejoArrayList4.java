/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete5;

import java.util.ArrayList;
import java.util.Arrays;
import paquete1.Calificacion;
import paquete1.Profesor;

/**
 *
 * @author cdm
 */
public class ManejoArrayList4 {

    public static void main(String[] args) {
        String linea = "Tara Hernandez;contratado";
        // linea debe convertirse en una estructura dinamica
        ArrayList<String> linea_partes = new ArrayList<>(
                Arrays.asList(linea.split(";")) // ["Tara Hernandez", "contratado"]
        );
        Profesor p = new Profesor(linea_partes.get(0), // Tara Hernandez
                linea_partes.get(1)); // contratado;

        System.out.println(p);
    }

}

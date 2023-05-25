/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete5;

import paquete4.EscrituraArchivoSecuencial;
import java.util.ArrayList;

/**
 *
 * @author SALA I
 */
public class Ejecutor {

    public static void main(String[] args) {
        String nombreArchivo = "data/hospital.data";
        Ciudad ciudad1 = new Ciudad("Pichincha", "Quito");
        Hospital hosp1 = new Hospital("San Juan", 500, 400.5, ciudad1);

        Ciudad ciudad2 = new Ciudad("Loja", "Loja");
        Hospital hosp2 = new Hospital("San Isidro", 300, 1202.5, ciudad2);

        Ciudad ciudad3 = new Ciudad("El oro", "Zaruma");
        Hospital hosp3 = new Hospital("San Pedro", 200, 4421.5, ciudad3);

        Ciudad ciudad4 = new Ciudad("Zamora Chinchipe", "Zamora");
        Hospital hosp4 = new Hospital("San Ismael", 100, 3220.5, ciudad4);

        Ciudad ciudad5 = new Ciudad("Azuay", "Cuenca");
        Hospital hosp5 = new Hospital("Santa Teresa", 50, 2000.5, ciudad5);

        ArrayList<Hospital> listaHospitales = new ArrayList();

        listaHospitales.add(hosp1);
        listaHospitales.add(hosp2);
        listaHospitales.add(hosp3);
        listaHospitales.add(hosp4);
        listaHospitales.add(hosp5);

        Escritura archivo
                = new Escritura(listaHospitales, nombreArchivo);

       
        archivo.cerrarArchivo();
        
        
        
        Lectura leer = new Lectura(nombreArchivo);
        leer.establecerListaHospitales();
        
        for (int i = 0; i < listaHospitales.size(); i++) {
            archivo.establecerRegistro(listaHospitales.get(i));
        }
        
        System.out.println(leer);

    }
}

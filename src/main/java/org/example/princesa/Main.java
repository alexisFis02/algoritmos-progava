package org.example.princesa;

import java.io.File;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try{
            Solucion solucion = CargaArchivo.cargarArchivoIn("princesa.in");

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
package org.example.princesa;

import java.io.File;
import java.util.*;

public class CargaArchivo {
    public static Solucion cargarArchivoIn(String path) throws Exception{
        File f = new File(path);
        Scanner scanner = new Scanner(f);

        int c,s,d;

        c = scanner.nextInt(); //claros
        s = scanner.nextInt(); //senderos
        d = scanner.nextInt(); // dragones


        System.out.println("Claros: " + c);
        System.out.println("Senderos: " + s);
        System.out.println("Dragones: " + d);


        int cf ; // princesa
        int cm ; // principe

        cf = scanner.nextInt();
        cm = scanner.nextInt();

        System.out.println("Princesa: " + cf);
        System.out.println("Principe: " + cm);


        Set<Integer> dragones = new HashSet<>();
        for (int i = 0; i < d; i++) {
            dragones.add(scanner.nextInt());
        }

        System.out.print("Nodosdragon: ");
        for (Integer dra : dragones.stream().toList()){
            System.out.print(dra + "|");
        }
        System.out.println();


        int [][] mapa = new int [c][c];

        for (int i = 0; i < s; i++) {
            int ci = scanner.nextInt() - 1;
            int sendero_cf = scanner.nextInt() - 1;
            int l = scanner.nextInt();
            mapa[ci][sendero_cf] = l;
            mapa[sendero_cf][ci] = l;
        }

        for (int i= 0; i < c; i++) {
            System.out.print(i + 1 + "|");
        }
        System.out.println();
        System.out.println("__________________________");
        for (int [] fila : mapa){
            for (int celda : fila){
                System.out.print(celda + "|");
            }
            System.out.println();
        }

        scanner.close();

        return new Solucion(dragones, mapa, cf, cm , c);

    }
}

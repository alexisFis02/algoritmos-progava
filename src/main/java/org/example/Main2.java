package org.example;

//import java.util.Arrays;

import static org.example.AlgoritmosGrafos.*;
import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        
        Map<Integer, List<Integer>> grafo = new HashMap<>();
        grafo.put(0, Arrays.asList(1, 2, 3));
        grafo.put(1, Arrays.asList(0, 2));
        grafo.put(2, Arrays.asList(0, 1));
        grafo.put(3, Arrays.asList(2));

        System.out.println("Depth-First Search desde el nodo 2:");
        algoritmoDFS(grafo, 2);
        
        System.out.println("Breadth-First Search desde el nodo 2:");
        Map<Integer, Integer> distancias = algoritmoBFS(grafo, 2);
        for (Map.Entry<Integer, Integer> entrada : distancias.entrySet()) {
            System.out.println("Nodo " + entrada.getKey() + " - Distancia: " + entrada.getValue());
        }
        
        Map<Integer, List<NodoPeso>> grafoPeso = new HashMap<>();
        grafoPeso.put(0, Arrays.asList(new NodoPeso(1, 4), new NodoPeso(2, 1)));
        grafoPeso.put(1, Arrays.asList(new NodoPeso(3, 1)));
        grafoPeso.put(2, Arrays.asList(new NodoPeso(1, 2), new NodoPeso(3, 5)));
        grafoPeso.put(3, Arrays.asList());

        algoritmoDjikstra(grafoPeso, 0);

        
    	}
}
package org.example;

import java.util.*;

public class DFS {

    public static void algoritmoDFS(Map<Integer, List<Integer>> grafo, int nodoInicial) {
        boolean[] visitados = new boolean[grafo.size()];
        Stack<Integer> aVisitar = new Stack<>();
        
        aVisitar.push(nodoInicial);
        visitados[nodoInicial] = true;

        while (!aVisitar.isEmpty()) {
            int nodoActual = aVisitar.pop();
            System.out.print(" Estoy en el nodo " + nodoActual + "\n"); // Procesar el nodo

            for (int nodoAdyacente : grafo.getOrDefault(nodoActual, new ArrayList<>())) {
                if (!visitados[nodoAdyacente]) {
                    aVisitar.push(nodoAdyacente);
                    visitados[nodoAdyacente] = true;
                }
            }
        }

    }
}
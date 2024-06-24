package org.example;

import java.util.*;

public class BFS {

    public static Map<Integer, Integer> algoritmoBFS(Map<Integer, List<Integer>> grafo, int nodoInicial) {
        Map<Integer, Integer> distanciasDelNodoInicial = new HashMap<>();
        Queue<Integer> aVisitar = new LinkedList<>();
        Set<Integer> visitados = new HashSet<>();

        aVisitar.add(nodoInicial);
        visitados.add(nodoInicial);
        distanciasDelNodoInicial.put(nodoInicial, 0);

        while (!aVisitar.isEmpty()) {
            int nodoActual = aVisitar.poll();
            int distanciaActual = distanciasDelNodoInicial.get(nodoActual);

            for (int nodoAdyacente : grafo.getOrDefault(nodoActual, new ArrayList<>())) {
                if (!visitados.contains(nodoAdyacente)) {
                    aVisitar.add(nodoAdyacente);
                    visitados.add(nodoAdyacente);
                    distanciasDelNodoInicial.put(nodoAdyacente, distanciaActual + 1);
                }
            }
        }

        return distanciasDelNodoInicial;
    }
}
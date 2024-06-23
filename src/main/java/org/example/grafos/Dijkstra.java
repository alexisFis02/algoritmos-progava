package org.example.grafos;

import java.sql.SQLOutput;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Dijkstra {
    /**
     * Implementacion del algoritmo de Dijkstra para encontrar los caminos mas cortos desde un vertice inicial
     * a todos los demas vertices en un grafo ponderado con pesos positivos.
     *
     * @param grafo           El grafo sobre el cual se ejecuta el algoritmo.
     * @param verticeInicial  El vértice desde el cual se calculan los caminos más cortos.
     */
    public static void dijkstra(Grafo grafo, int verticeInicial) {
        int cantidadVertices = grafo.getCantidadVertices();
        boolean[] visitados = new boolean[cantidadVertices]; // Array para marcar los vertices visitados
        int[] distancias = new int[cantidadVertices]; // Array para almacenar la distancia minima desde el vertice inicial
        int[] predecesor = new int[cantidadVertices]; // Array para almacenar el predecesor de cada vertice en el camino mas corto para asi reconstruir el camino

        // Cola de prioridad para seleccionar el vertice con la menor distancia estimada
        PriorityQueue<Arista> colaPrioridad = new PriorityQueue<>(cantidadVertices, Comparator.comparingInt(Arista::getDistancia));

        // Inicializar las distancias a infinito y los predecesores a -1 (no definidos)
        for (int i = 0; i < cantidadVertices; i++) {
            distancias[i] = Integer.MAX_VALUE;
            predecesor[i] = -1;
        }

        // La distancia al vertice inicial es 0
        colaPrioridad.add(new Arista(verticeInicial, 0));
        distancias[verticeInicial] = 0;

        while (!colaPrioridad.isEmpty()) {
            // Seleccionar el vartice con la menor distancia estimada
            Arista aristaActual = colaPrioridad.poll();
            int destinoActual = aristaActual.getDestino();

            // Procesar el vertice solo si no ha sido visitado aun
            if (!visitados[destinoActual]) {
                visitados[destinoActual] = true;

                // Recorrer los vertices adyacentes al vertice actual, para cada actualizo las distancias si es que hay un
                // camino mas corto pasando por el vertice actual
                LinkedList<Arista> aristasDestinoActual = grafo.getAdyacencias()[destinoActual];
                for (Arista arista : aristasDestinoActual) {
                    int destinoAdyacenteActual = arista.getDestino();
                    int distanciaDestinoAdyacenteActual = arista.getDistancia();

                    if (!visitados[destinoAdyacenteActual]) {
                        // Calcular la nueva distancia posible a traves del vertice actual
                        int nuevaDistancia = distancias[destinoActual] + distanciaDestinoAdyacenteActual;
                        if (nuevaDistancia < distancias[destinoAdyacenteActual]) {
                            distancias[destinoAdyacenteActual] = nuevaDistancia;
                            colaPrioridad.add(new Arista(destinoAdyacenteActual, distancias[destinoAdyacenteActual]));
                            predecesor[destinoAdyacenteActual] = destinoActual;
                        }
                    }
                }
            }
        }
    }

    private static void imprimirSolucion(int[] distancia, int[] predecesor, int verticeInicial) {
        System.out.println("Vertice inicial: " + verticeInicial);
        System.out.println("Vertice\t Distancia\t Camino");
        for (int i = 0; i < distancia.length; i++) {
            if (i != verticeInicial) {
                System.out.print(i + " \t\t " + distancia[i] + "\t\t\t\t\t ");
                imprimirCamino(i, predecesor);
                System.out.println();
            }
        }
    }

    private static void imprimirCamino(int verticeActual, int[] predecesor) {
        if (verticeActual == -1) {
            return;
        }
        imprimirCamino(predecesor[verticeActual], predecesor);
        System.out.print(verticeActual + " ");
    }
}


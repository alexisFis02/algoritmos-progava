package prograva.grafos;

import java.util.Arrays;

public class Dijkstra {
    /**
     * @param grafo           El grafo sobre el cual se ejecuta el algoritmo.
     * @param origen El nodo desde el cual se calculan los caminos más cortos.
     * @return double[] array de distancias a cada nodo desde origen
     */
    public static double[] dijkstra(Grafo grafo, int origen) {
        int n = grafo.getCantidadDeVertices();
        double[] distancias = new double[n];
        boolean[] visitados = new boolean[n];
        Arrays.fill(distancias, Double.POSITIVE_INFINITY);

        distancias[origen] = 0; // para comenzar por este

        for (int i = 0; i < n; i++) { // se tienen que visitar todos los nodos
            int w = getNodoConMenorDistancia(distancias, visitados);
            visitados[w] = true;
            for (int v : grafo.getAdyacentes(w)) {
                double peso = grafo.getPesoArista(w, v);
                // si tengo una distancia a v menor pasando por w la actualizo la distancia a v
                if (!visitados[v] && distancias[w] + peso < distancias[v]) {
                    distancias[v] = distancias[w] + peso;
                }
            }
        }

        return distancias;
    }

    private static int getNodoConMenorDistancia(double[] distancias, boolean[] visitados) {
        double min = Double.POSITIVE_INFINITY;
        int nodo = -1;
        for (int i = 0; i < distancias.length; i++) {
            if (!visitados[i] && distancias[i] < min) {
                min = distancias[i];
                nodo = i;
            }
        }
        return nodo;
    }
}


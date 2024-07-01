package prograva.grafos;

import java.util.LinkedList;

public class Grafo {
    private int cantidadVertices;
    private LinkedList<Arista>[] adyacencias;

    public Grafo(int vertices) {
        this.cantidadVertices = vertices;
        adyacencias = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adyacencias[i] = new LinkedList<>();
        }
    }

    public void agregarArista(int origen, int destino, int peso) {
        adyacencias[origen].add(new Arista(destino, peso));
        adyacencias[destino].add(new Arista(origen, peso)); // Para grafo no dirigido
    }

    public int getCantidadVertices() {
        return cantidadVertices;
    }

    public LinkedList<Arista>[] getAdyacencias() {
        return adyacencias;
    }
}

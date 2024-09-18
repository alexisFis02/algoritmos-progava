package prograva.grafos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GrafoLista implements Grafo {

    private int cantNodos;
    private final Map<Integer, List<Arista>> listaAdyacencia;

    private static class Arista {
        int destino;
        double peso;

        Arista(int destino, double peso) {
            this.destino = destino;
            this.peso = peso;
        }
    }

    /**
     * @param cantNodos Cantidad de nodos en el grafo.
     */
    public GrafoLista(int cantNodos) {
        this.cantNodos = cantNodos;
        listaAdyacencia = new HashMap<>();

        // Inicializar la lista de adyacencia para cada nodo.
        for (int i = 0; i < cantNodos; i++) {
            listaAdyacencia.put(i, new ArrayList<>());
        }
    }

    @Override
    public int getCantidadDeVertices() {
        return cantNodos;
    }

    @Override
    public void insertarArista(int origen, int destino, double peso) {
        validarNodo(origen);
        validarNodo(destino);
        // Remover cualquier arista existente entre los nodos para evitar duplicados.
        eliminarArista(origen, destino);
        listaAdyacencia.get(origen).add(new Arista(destino, peso));
    }

    @Override
    public boolean existeArista(int origen, int destino) {
        validarNodo(origen);
        validarNodo(destino);
        for (Arista arista : listaAdyacencia.get(origen)) {
            if (arista.destino == destino) {
                return true;
            }
        }
        return false;
    }

    @Override
    public double getPesoArista(int origen, int destino) {
        validarNodo(origen);
        validarNodo(destino);
        for (Arista arista : listaAdyacencia.get(origen)) {
            if (arista.destino == destino) {
                return arista.peso;
            }
        }
        return Double.POSITIVE_INFINITY;
    }

    @Override
    public void eliminarArista(int origen, int destino) {
        validarNodo(origen);
        validarNodo(destino);
        listaAdyacencia.get(origen).removeIf(arista -> arista.destino == destino);
    }

    @Override
    public List<Integer> getAdyacentes(int nodo) {
        validarNodo(nodo);
        List<Integer> adyacentes = new ArrayList<>();
        for (Arista arista : listaAdyacencia.get(nodo)) {
            adyacentes.add(arista.destino);
        }
        return adyacentes;
    }

    /**
     * Valida la existencia de un nodo.
     *
     * @param nodo Nodo a validar.
     * @throws IllegalArgumentException Si el nodo no es válido.
     */
    private void validarNodo(int nodo) {
        if (nodo < 0 || nodo >= cantNodos) {
            throw new IllegalArgumentException("Nodo inválido: " + nodo);
        }
    }
}

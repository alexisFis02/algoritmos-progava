package prograva.grafos;

import java.util.ArrayList;
import java.util.List;

public class GrafoMatriz implements Grafo {

    private final int cantNodos;
    private final double[][] matrizAdyacencia;

    /**
     * @param cantNodos Cantidad de nodos del grafo.
     */
    public GrafoMatriz(int cantNodos) {
        this.cantNodos = cantNodos;
        matrizAdyacencia = new double[cantNodos][cantNodos];
        for (int i = 0; i < cantNodos; i++) {
            for (int j = 0; j < cantNodos; j++) {
                matrizAdyacencia[i][j] = Double.POSITIVE_INFINITY;
            }
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
        matrizAdyacencia[origen][destino] = peso;
    }

    @Override
    public boolean existeArista(int origen, int destino) {
        validarNodo(origen);
        validarNodo(destino);
        return matrizAdyacencia[origen][destino] != Double.POSITIVE_INFINITY;
    }

    @Override
    public double getPesoArista(int origen, int destino) {
        validarNodo(origen);
        validarNodo(destino);
        return matrizAdyacencia[origen][destino];
    }

    @Override
    public void eliminarArista(int origen, int destino) {
        validarNodo(origen);
        validarNodo(destino);
        matrizAdyacencia[origen][destino] = Double.POSITIVE_INFINITY;
    }

    @Override
    public List<Integer> getAdyacentes(int nodos) {
        validarNodo(nodos);
        List<Integer> adyacentes = new ArrayList<>();
        for (int i = 0; i < cantNodos; i++) {
            if (matrizAdyacencia[nodos][i] != Double.POSITIVE_INFINITY) {
                adyacentes.add(i);
            }
        }
        return adyacentes;
    }

    /**
     * Valida la existencia de un nodo.
     *
     * @param nodo nodo a validar.
     * @throws IllegalArgumentException Si el nodo no existe.
     */
    private void validarNodo(int nodo) {
        if (nodo < 0 || nodo >= cantNodos) {
            throw new IllegalArgumentException("Nodo inválido: " + nodo);
        }
    }
}

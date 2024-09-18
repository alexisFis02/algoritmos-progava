package prograva.grafos;

import java.util.List;

public interface Grafo {

    /**
     * Retorna la cantidad de vértices en el grafo.
     *
     * @return Número de vértices.
     */
    int getCantidadDeVertices();

    /**
     * Inserta una arista dirigida con un peso específico entre dos vértices.
     *
     * @param origen Vértice de origen.
     * @param destino Vértice de destino.
     * @param peso Peso de la arista.
     */
    void insertarArista(int origen, int destino, double peso);

    /**
     * Verifica si existe una arista dirigida desde el vértice origen al vértice destino.
     *
     * @param origen Vértice de origen.
     * @param destino Vértice de destino.
     * @return `true` si la arista existe, `false` en caso contrario.
     */
    boolean existeArista(int origen, int destino);

    /**
     * Obtiene el peso de la arista dirigida desde el vértice origen al vértice destino.
     *
     * @param origen Vértice de origen.
     * @param destino Vértice de destino.
     * @return Peso de la arista, o `Double.POSITIVE_INFINITY` si no existe la arista.
     */
    double getPesoArista(int origen, int destino);

    /**
     * Elimina la arista dirigida desde el vértice origen al vértice destino.
     *
     * @param origen Vértice de origen.
     * @param destino Vértice de destino.
     */
    void eliminarArista(int origen, int destino);

    /**
     * Obtiene una lista de los vértices adyacentes al vértice dado.
     *
     * @param vertice Vértice del cual se obtienen los adyacentes.
     * @return Lista de vértices adyacentes.
     */
    List<Integer> getAdyacentes(int vertice);
}

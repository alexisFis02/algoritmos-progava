package prograva.grafos;

import java.util.*;

public class AlgoritmosGrafos {

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
    
    
    public static void algoritmoDjikstra(Map<Integer, List<NodoPeso>> grafo, int nodoInicial) {
        PriorityQueue<NodoPeso> pq = new PriorityQueue<>(Comparator.comparingInt(NodoPeso -> NodoPeso.peso));
        Map<Integer, Integer> distancias = new HashMap<>();
        Map<Integer, Integer> predecesor =  new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        
        for (Integer nodoGrafo : grafo.keySet()) {
            distancias.put(nodoGrafo, Integer.MAX_VALUE);// La distancia inicial de cada nodo es infinito
            predecesor.put(nodoGrafo, -1); // El predecesor inicial es -1
        }
        
        distancias.put(nodoInicial, 0);
        pq.add(new NodoPeso(nodoInicial, 0));
        
        while (!pq.isEmpty()) {
            NodoPeso nodoPesoActual = pq.poll();
            int nodoActual = nodoPesoActual.nodo;
            if (visited.contains(nodoActual)) {
                continue;
            }
            visited.add(nodoActual);
            
            for (NodoPeso nodoAdyacente : grafo.getOrDefault(nodoActual, new ArrayList<>())) {
                if (!visited.contains(nodoAdyacente.nodo)) {
                    int newDist = distancias.get(nodoActual) + nodoAdyacente.peso;
                    if (newDist < distancias.get(nodoAdyacente.nodo)) {
                        distancias.put(nodoAdyacente.nodo, newDist);
                        predecesor.put(nodoAdyacente.nodo, nodoActual);
                        pq.add(new NodoPeso(nodoAdyacente.nodo, newDist));
                    }
                }
            }
        }
        System.out.println("Djikstra Pesos y Predecesores:");
        for (Map.Entry<Integer, Integer> entrada : predecesor.entrySet()) {
        System.out.println("Nodo " + entrada.getKey() + " - Predecesor: " + entrada.getValue() + " Costo: " + distancias.getOrDefault(entrada.getKey(), Integer.MAX_VALUE));
        }
        
    }
}
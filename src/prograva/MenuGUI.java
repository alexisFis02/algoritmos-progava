package prograva;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import prograva.grafos.*;
import prograva.ordenamiento.OrdenamientoStats;

public class MenuGUI {
	public void iniciar() {
		Scanner scanner = new Scanner(System.in);
		String op;
		do {
			this.mostrarMenu();
			op = scanner.next();
			try {
				this.mostrarOpciones(op);
				this.mostrarEspacios();
			}catch (Exception e) {
				System.err.println(e.getMessage());
			}
		} while(!op.equalsIgnoreCase("0"));
		
		System.out.println("Has salido del programa.");
		scanner.close();
	}
	
	private void mostrarMenu() {
		System.out.println("-------------------------------------");
		System.out.println("MENU Algoritmos Programacion Avanzada");
		System.out.println("_____________________________________");
		System.out.println("		Ingresar opcion.");
		System.out.println("_____________________________________");
		System.out.println("1) Estadisticas de ordenamiento.");
		System.out.println("2) Algoritmo Dijkstra.");
		System.out.println("3) Algoritmo DFS/BFS.");
		System.out.println("0) Salir.");
		System.out.println("_____________________________________");
		System.out.println();
		System.out.print("> ");
	}
	
	private void mostrarEspacios() {
		System.out.println();
		System.out.println();
	}
	
	private void mostrarOpciones(String opcion) {
		switch (opcion) {
		case "0":
			break;
		case "1":
			this.opcionEstadisticasOrdenamiento();
			break;
		case "2":
			this.opcionDijkstra();
			break;
		case "3":
			this.opcionBFS_DFS();
			break;
		default:
			throw new IllegalArgumentException("Valor no valido: " + opcion);
		}
	}
	
	private void opcionEstadisticasOrdenamiento() {
		OrdenamientoStats.mostrarEstadisticasOrdenamiento();
	}
	
	private void opcionBFS_DFS() {
		Map<Integer, List<Integer>> grafo = new HashMap<>();
        grafo.put(0, Arrays.asList(1, 2, 3));
        grafo.put(1, Arrays.asList(0, 2));
        grafo.put(2, Arrays.asList(0, 1));
        grafo.put(3, Arrays.asList(2));

        System.out.println("Depth-First Search desde el nodo 2:");
        AlgoritmosGrafos.algoritmoDFS(grafo, 2);

        System.out.println("Breadth-First Search desde el nodo 2:");
        Map<Integer, Integer> distancias = AlgoritmosGrafos.algoritmoBFS(grafo, 2);
        for (Map.Entry<Integer, Integer> entry : distancias.entrySet()) {
            System.out.println("Nodo " + entry.getKey() + " - Distancia: " + entry.getValue());
        }
	}
	
	private void opcionDijkstra() {
		Grafo grafo = new GrafoLista(4);

		grafo.insertarArista(0, 1, 7.0);
		grafo.insertarArista(0, 2, 3.0);

		grafo.insertarArista(1, 3, 2.0);

		grafo.insertarArista(2, 1, 2.0);
		grafo.insertarArista(2, 3, 8.0);


        double[] distancias = Dijkstra.dijkstra(grafo, 0);
		System.out.println("Dijkstra desde el nodo 0:");
		for (int i = 0; i < distancias.length; i++) {
			System.out.println("Nodo " + i + " - Distancia: " + distancias[i]);
		}
	}
}

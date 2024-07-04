package prograva;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import prograva.grafos.AlgoritmosGrafos;
import prograva.grafos.NodoPeso;
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
		Map<Integer, List<NodoPeso>> grafoPeso = new HashMap<>();
        grafoPeso.put(0, Arrays.asList(new NodoPeso(1, 4), new NodoPeso(2, 1)));
        grafoPeso.put(1, Arrays.asList(new NodoPeso(3, 1)));
        grafoPeso.put(2, Arrays.asList(new NodoPeso(1, 2), new NodoPeso(3, 5)));
        grafoPeso.put(3, Arrays.asList());

        AlgoritmosGrafos.algoritmoDjikstra(grafoPeso, 0);
	}
}

package prograva;

import java.util.Scanner;

import prograva.ordenamiento.OrdenamientoStats;

public class MenuGUI {
	public void iniciar() {
		Scanner scanner = new Scanner(System.in);
		String op;
		do {
			this.mostrarMenu();
			op = scanner.next();
			
		} while(!op.equalsIgnoreCase("0"));
		
		System.out.println("Has salido del programa.");
		scanner.close();
	}
	
	private void mostrarMenu() {
		System.out.println("MENU Algoritmos Programacion Avanzada");
		System.out.println("_____________________________________");
		System.out.println("		Ingresar opcion.");
		System.out.println("_____________________________________");
		System.out.println();
		System.out.print("> ");
	}
	
	private void mostrarOpciones(String opcion) {
		if(opcion.equals("1"))
			OrdenamientoStats.mostrarEstadisticasOrdenamiento();
	}
}

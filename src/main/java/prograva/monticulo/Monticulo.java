package prograva.monticulo;

import java.util.ArrayList;

public class Monticulo {

	private ArrayList<Integer> monticulo;
	private int tam;
	
	public Monticulo( ArrayList<Integer> monticulo) {
		this.monticulo = monticulo;
		this.tam = monticulo.size();
		this.verificarCondicion();
	}
	
	private void verificarCondicion() {
		for (int i = 0; i < this.tam; i++)
			subirNodo(i);
	}
	
	public void insertar(int valor) {
		this.monticulo.add(valor);
		int pos = this.tam;
		subirNodo(pos);
		this.tam++;
	}
	
	public int obtenerTope() {
		return monticulo.get(0);
	}
	
	private void subirNodo(int pos) {
		while(pos > 0 && monticulo.get(pos) < monticulo.get((int)(pos-1)/2)) {
			int aux = monticulo.get(pos);
			monticulo.set(pos, monticulo.get((int)((pos-1)/2)));
			monticulo.set((int)((pos-1)/2), aux);
			pos = (int)((pos-1)/2);
		}
	}
	
	
	

	public int eliminar() {
		
		
		int tope = this.monticulo.remove(0);
		this.tam--;
		this.monticulo.add(0,monticulo.remove(tam-1));
		int pos = 0;
		
		int izq,
			der,
			padre;
		
		do {
			
			izq = 2 * pos + 1;
			der = 2 * pos + 2;
			padre = pos;
			if(izq < tam && monticulo.get(izq) <monticulo.get(pos))
				pos = izq;
			if(der < tam && monticulo.get(der) < monticulo.get(pos))
				pos = der;
			if(pos != padre) {
				int aux = monticulo.get(pos);
				monticulo.set(pos, monticulo.get(padre));
				monticulo.set(padre, aux);
			}
			
		} while(pos != padre);
		return tope;
	}
	

	
}
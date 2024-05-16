package org.prograva;

import static org.prograva.sorting.AlgoritmosOrdenamiento.*;

import org.prograva.sorting.AlgoritmosOrdenamiento;
import org.prograva.varilla.CortesVarillaClivio;
import org.prograva.varilla.Varillable;

public class Main {
    public static void main(String[] args) {
    	int[] cortes = {1,3,4,5};
    	int n = 7;
    	
    	Varillable varillaSolucion = new CortesVarillaClivio();
    	
    	int output = varillaSolucion.costoMinimoCortes(n, cortes);
    	
    	System.out.println("Solucion = " + output);
    }

}
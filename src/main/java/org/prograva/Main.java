package org.prograva;

import static org.prograva.AlgoritmosOrdenamiento.*;

public class Main {
    public static void main(String[] args) {
    	
        System.out.println(testearAlgoritmo(1000,1000,AlgoritmosOrdenamiento::shellSort));
        System.out.println(testearAlgoritmo(1000,1000,AlgoritmosOrdenamiento::selectionSort));
        System.out.println(testearAlgoritmo(1000,1000,AlgoritmosOrdenamiento::insertionSort));
        System.out.println(testearAlgoritmo(1000,1000,AlgoritmosOrdenamiento::mergeSort));
        System.out.println(testearAlgoritmo(1000,1000,AlgoritmosOrdenamiento::quickSort));
    }

}
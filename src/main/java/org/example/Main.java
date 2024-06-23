package org.example;

import org.example.ordenamiento.*;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        mostrarEstadisticasOrdenamiento();
    }

    private static void mostrarEstadisticasOrdenamiento() {
        int numberOfTests = 10;  // Número de pruebas a realizar
        int maxArraySize = 10000; // Tamaño máximo del array

        AlgoritmoOrdenamiento[] algoritmos = {
                new BubbleSort(),
                new InsertionSort(),
                new MergeSort(),
                new QuickSort(),
                new SelectionSort(),
                new ShellSort()
        };

        for (AlgoritmoOrdenamiento algoritmo : algoritmos) {
            long totalTime = 0;
            for (int t = 0; t < numberOfTests; t++) {
                int[] array = generarArrayAleatorio(maxArraySize);

                long startTime = System.nanoTime();
                algoritmo.sort(array);
                long endTime = System.nanoTime();
                long duration = endTime - startTime;

                totalTime += duration;
            }
            double avgTimeMs = ( totalTime / numberOfTests ) / 1_000_000;
            System.out.printf("%s tiempo promedio: %.2f ms%n", algoritmo.getClass().getSimpleName(), avgTimeMs);
        }
    }

    public static int[] generarArrayAleatorio(int maxArraySize) {
        Random random = new Random();
        int arraySize = random.nextInt(maxArraySize) + 1;
        int[] array = new int[arraySize];

        for (int i = 0; i < arraySize; i++) {
            array[i] = random.nextInt(1000); // Valores aleatorios entre 0 y 999
        }

        return array;
    }

}
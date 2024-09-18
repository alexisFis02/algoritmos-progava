package prograva.ordenamiento;

import java.util.Random;

public class OrdenamientoStats {

    public static void mostrarEstadisticasOrdenamiento() {
        int numberOfTests = 15;  // Número de pruebas a realizar
        int maxArraySize = 10000; // Tamaño máximo del array

        System.out.println("Cantidad de elementos maxima por array: " + maxArraySize +1 +" ,Cantidad de tests efectuados por algoritmo: " + numberOfTests);

        AlgoritmoOrdenamiento<Integer>[] algoritmos = new AlgoritmoOrdenamiento[]{
                new BubbleSort<>(),
                new InsertionSort<>(),
                new MergeSort<>(),
                new QuickSort<>(),
                new SelectionSort<>(),
                new ShellSort<>()
        };

        for (AlgoritmoOrdenamiento<Integer> algoritmo : algoritmos) {
            long totalTime = 0;
            for (int t = 0; t < numberOfTests; t++) {
                Integer[] array = generarArrayAleatorio(maxArraySize);

                long startTime = System.nanoTime();
                algoritmo.sort(array);
                long endTime = System.nanoTime();
                long duration = endTime - startTime;

                totalTime += duration;
            }
            double avgTimeMs = (double) (totalTime / numberOfTests) / 1_000_000;
            System.out.printf("%s tiempo promedio: %.2f ms%n", algoritmo.getClass().getSimpleName(), avgTimeMs);
        }
    }

    public static Integer[] generarArrayAleatorio(int maxArraySize) {
        Random random = new Random();
        int arraySize = random.nextInt(maxArraySize) + 1;
        Integer[] array = new Integer[arraySize];

        for (int i = 0; i < arraySize; i++) {
            array[i] = random.nextInt(1000); // Valores aleatorios entre 0 y 999
        }

        return array;
    }
}
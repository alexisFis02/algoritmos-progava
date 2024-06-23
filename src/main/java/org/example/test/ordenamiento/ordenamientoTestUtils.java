package org.example.test.ordenamiento;

import org.example.ordenamiento.AlgoritmoOrdenamiento;

import java.util.Arrays;

import static org.example.Main.generarArrayAleatorio;
import static org.junit.Assert.assertTrue;

public class ordenamientoTestUtils {

    public static void runSortTest(AlgoritmoOrdenamiento algoritmo, int numberOfTests, int maxArraySize) {
        for (int t = 0; t < numberOfTests; t++) {
            int[] array = generarArrayAleatorio(maxArraySize);
            int[] arrayCopy = array.clone();

            algoritmo.sort(array);
            Arrays.sort(arrayCopy);

            assertTrue(Arrays.equals(array, arrayCopy));
        }
    }

}

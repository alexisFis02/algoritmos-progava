package prograva.test.ordenamiento;

import java.util.Arrays;

import prograva.ordenamiento.AlgoritmoOrdenamiento;
import prograva.ordenamiento.OrdenamientoStats;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

public class ordenamientoTestUtils {

    public static void runSortTest(AlgoritmoOrdenamiento<Integer> algoritmo, int numberOfTests, int maxArraySize) {
        for (int t = 0; t < numberOfTests; t++) {
            Integer[] array = OrdenamientoStats.generarArrayAleatorio(maxArraySize);
            Integer[] arrayCopy = array.clone();

            algoritmo.sort(array);
            Arrays.sort(arrayCopy);

            assertArrayEquals(array, arrayCopy);
        }
    }

}

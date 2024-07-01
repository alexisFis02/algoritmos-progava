package prograva.test.ordenamiento;

import java.util.Arrays;

import prograva.ordenamiento.AlgoritmoOrdenamiento;
import prograva.ordenamiento.OrdenamientoStats;

import static org.junit.Assert.assertTrue;

public class ordenamientoTestUtils {

    public static void runSortTest(AlgoritmoOrdenamiento algoritmo, int numberOfTests, int maxArraySize) {
        for (int t = 0; t < numberOfTests; t++) {
            int[] array = OrdenamientoStats.generarArrayAleatorio(maxArraySize);
            int[] arrayCopy = array.clone();

            algoritmo.sort(array);
            Arrays.sort(arrayCopy);

            assertTrue(Arrays.equals(array, arrayCopy));
        }
    }

}

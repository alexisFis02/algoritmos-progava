package prograva.test.ordenamiento;

import static prograva.test.ordenamiento.ordenamientoTestUtils.runSortTest;

import org.junit.Test;

import prograva.ordenamiento.InsertionSort;

public class InsertionSortTest {

    @Test
    public void testInsertionSortArraysAleatorios() {
        runSortTest(new InsertionSort<>(), 1000, 100);
    }

}

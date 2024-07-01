package prograva.test.ordenamiento;

import static prograva.test.ordenamiento.ordenamientoTestUtils.runSortTest;

import org.junit.Test;

import prograva.ordenamiento.SelectionSort;

public class SelectionSortTest {

    @Test
    public void testSelectionSortArraysAleatorios() {
        runSortTest(new SelectionSort(), 1000, 100);
    }
}

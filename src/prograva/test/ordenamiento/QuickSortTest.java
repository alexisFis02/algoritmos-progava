package prograva.test.ordenamiento;

import static prograva.test.ordenamiento.ordenamientoTestUtils.runSortTest;

import org.junit.Test;

import prograva.ordenamiento.QuickSort;

public class QuickSortTest {

    @Test
    public void testQuickSortArraysAleatorios() {
        runSortTest(new QuickSort<>(), 1000, 100);
    }
}

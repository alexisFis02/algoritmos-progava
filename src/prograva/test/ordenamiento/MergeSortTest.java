package prograva.test.ordenamiento;

import static prograva.test.ordenamiento.ordenamientoTestUtils.runSortTest;

import org.junit.Test;

import prograva.ordenamiento.InsertionSort;
import prograva.ordenamiento.MergeSort;

public class MergeSortTest {

    @Test
    public void testMergeSortArraysAleatorios() {
        runSortTest(new MergeSort<>(), 1000, 100);
    }
}

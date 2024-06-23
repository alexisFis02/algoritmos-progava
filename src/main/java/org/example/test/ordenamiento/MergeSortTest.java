package org.example.test.ordenamiento;

import org.example.ordenamiento.InsertionSort;
import org.example.ordenamiento.MergeSort;
import org.junit.Test;

import static org.example.test.ordenamiento.ordenamientoTestUtils.runSortTest;

public class MergeSortTest {

    @Test
    public void testMergeSortArraysAleatorios() {
        runSortTest(new MergeSort(), 1000, 100);
    }
}

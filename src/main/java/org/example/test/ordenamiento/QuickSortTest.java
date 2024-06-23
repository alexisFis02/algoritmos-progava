package org.example.test.ordenamiento;

import org.example.ordenamiento.QuickSort;
import org.junit.Test;

import static org.example.test.ordenamiento.ordenamientoTestUtils.runSortTest;

public class QuickSortTest {

    @Test
    public void testQuickSortArraysAleatorios() {
        runSortTest(new QuickSort(), 1000, 100);
    }
}

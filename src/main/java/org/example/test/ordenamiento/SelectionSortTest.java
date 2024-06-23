package org.example.test.ordenamiento;

import org.example.ordenamiento.SelectionSort;
import org.junit.Test;

import static org.example.test.ordenamiento.ordenamientoTestUtils.runSortTest;

public class SelectionSortTest {

    @Test
    public void testSelectionSortArraysAleatorios() {
        runSortTest(new SelectionSort(), 1000, 100);
    }
}

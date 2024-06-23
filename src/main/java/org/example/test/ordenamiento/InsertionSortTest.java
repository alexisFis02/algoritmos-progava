package org.example.test.ordenamiento;

import org.example.ordenamiento.InsertionSort;
import org.junit.Test;

import static org.example.test.ordenamiento.ordenamientoTestUtils.runSortTest;

public class InsertionSortTest {

    @Test
    public void testInsertionSortArraysAleatorios() {
        runSortTest(new InsertionSort(), 1000, 100);
    }

}

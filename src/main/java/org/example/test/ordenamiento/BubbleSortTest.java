package org.example.test.ordenamiento;

import org.example.ordenamiento.BubbleSort;
import org.junit.Test;

import static org.example.test.ordenamiento.ordenamientoTestUtils.runSortTest;

public class BubbleSortTest {

    @Test
    public void testBubbleSortArraysAleatorios() {
        runSortTest(new BubbleSort(), 1000, 100);
    }
}

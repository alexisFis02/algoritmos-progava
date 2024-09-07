package prograva.test.ordenamiento;

import static prograva.test.ordenamiento.ordenamientoTestUtils.runSortTest;

import org.junit.Test;

import prograva.ordenamiento.BubbleSort;

public class BubbleSortTest {

    @Test
    public void testBubbleSortArraysAleatorios() {
        runSortTest(new BubbleSort<>(), 1000, 100);
    }
}

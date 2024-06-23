package org.example.test.ordenamiento;

import org.example.ordenamiento.ShellSort;
import org.junit.Test;

import static org.example.test.ordenamiento.ordenamientoTestUtils.runSortTest;

public class ShellSortTest {

    @Test
    public void testShellSortArraysAletorios() {
        runSortTest(new ShellSort(), 1000, 100);
    }
}

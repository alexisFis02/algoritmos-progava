package prograva.test.ordenamiento;

import static prograva.test.ordenamiento.ordenamientoTestUtils.runSortTest;

import org.junit.Test;

import prograva.ordenamiento.ShellSort;

public class ShellSortTest {

    @Test
    public void testShellSortArraysAletorios() {
        runSortTest(new ShellSort(), 1000, 100);
    }
}

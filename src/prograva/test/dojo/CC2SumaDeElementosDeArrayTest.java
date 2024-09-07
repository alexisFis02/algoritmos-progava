package prograva.test.dojo;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class CC2SumaDeElementosDeArrayTest {

    @Test
    public void testSumDyC() {
        List<Integer> l = List.of(1, 2, 3, 4, 5);
        int r = CC2SumaDeElementosDeArray.sumDyC(l);
        assertEquals(15, r);
    }

    @Test
    public void testSumDyCConUnSoloElemento() {
        List<Integer> l = List.of(42);
        int r = CC2SumaDeElementosDeArray.sumDyC(l);
        assertEquals(42, r);
    }

    @Test
    public void testSumDyCConListaVacia() {
        List<Integer> l = List.of();
        int r = CC2SumaDeElementosDeArray.sumDyC(l);
        assertEquals(0,r);
    }

    @Test
    public void testSumDyCConNegativosYPositivos() {
        List<Integer> l= List.of(-10, 20, -30, 40);
        int r = CC2SumaDeElementosDeArray.sumDyC(l);
        assertEquals(20, r);
    }

    @Test
    public void testSumRecursiva() {
        List<Integer> l = List.of(1, 2, 3, 4, 5);
        int r = CC2SumaDeElementosDeArray.sumRecursiva(l);
        assertEquals(15, r);
    }

    @Test
    public void testSumRecursivaConUnSoloElemento() {
        List<Integer> l = List.of(42);
        int r = CC2SumaDeElementosDeArray.sumRecursiva(l);
        assertEquals(42, r);
    }

    @Test
    public void testSumRecursivaConListaVacia() {
        List<Integer> l = List.of();
        int r = CC2SumaDeElementosDeArray.sumRecursiva(l);
        assertEquals(0,r);
    }

    @Test
    public void testSumRecursivaConNegativosYPositivos() {
        List<Integer> l= List.of(-10, 20, -30, 40);
        int r = CC2SumaDeElementosDeArray.sumRecursiva(l);
        assertEquals(20, r);
    }

    @Test
    public void testSumIterativa() {
        List<Integer> l = List.of(1, 2, 3, 4, 5);
        int r = CC2SumaDeElementosDeArray.sumIterativa(l);
        assertEquals(15, r);
    }

    @Test
    public void testSumIterativaConUnSoloElemento() {
        List<Integer> l = List.of(42);
        int r = CC2SumaDeElementosDeArray.sumIterativa(l);
        assertEquals(42, r);
    }

    @Test
    public void testSumIterativaConListaVacia() {
        List<Integer> l = List.of();
        int r = CC2SumaDeElementosDeArray.sumIterativa(l);
        assertEquals(0,r);
    }

    @Test
    public void testSumIterativaConNegativosYPositivos() {
        List<Integer> l= List.of(-10, 20, -30, 40);
        int r = CC2SumaDeElementosDeArray.sumIterativa(l);
        assertEquals(20, r);
    }
}

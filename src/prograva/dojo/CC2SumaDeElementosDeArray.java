package prograva.dojo;

import java.util.List;

public class CC2SumaDeElementosDeArray {

    public static int sumDyC(List<Integer> l) {
        if(l.isEmpty())
            return 0;
        return sumDyC(l, 0, l.size() - 1);
    }

    private static int sumDyC(List<Integer> l, int ini, int fin) {
        if (ini == fin)
            return l.get(ini);
        int mid = (ini + fin) / 2;
        return sumDyC(l, ini, mid) + sumDyC(l, mid + 1, fin);
    }

    public static int sumRecursiva(List<Integer> l) {
        if(l.isEmpty())
            return 0;
        return sumRecursiva(l, 0);
    }

    private static int sumRecursiva(List<Integer> l, int i) {
        if (i == l.size() - 1) {
            return l.get(i);
        }
        return sumRecursiva(l, i + 1) + l.get(i);
    }

    public static int sumIterativa(List<Integer> l) {
        int sum = 0;
        for (Integer e: l) {
            sum += e;
        }
        return sum;
    }
}

package prograva.ordenamiento;

import java.util.Arrays;

public class ShellSort<T extends Comparable<T>> extends AlgoritmoOrdenamiento<T> {

    /*
     * Inserción iterativa sobre elementos que distan un valor de la serie de Shell
     */
    @Override
    public void sort(T[] a) { // TODO: revisar complejidad
        int[] serieShell = getSerieShell(a.length);
        int i, j, k, shell;

        for (i = serieShell.length - 1; i >= 0; --i) { // Itero sobre la serie de Shell
            shell = serieShell[i]; // Valor de la serie

            for (int l = 0; l < shell; l++) { // Todos los elementos que distan shell están continuos

                // Selección sobre el subarray que distan shell
                for (j = l + shell; j < a.length; j += shell) {
                    T act = a[j];
                    k = j;
                    while (k >= shell && act.compareTo(a[k - shell]) < 0) { // Itero desde el índice del actual hasta el inicio
                        a[k] = a[k - shell];
                        k -= shell;
                    }
                    a[k] = act;
                }
            }
        }
    }

    public static int[] getSerieShell(int n) {
        int[] ret = new int[n];
        ret[0] = 1;
        int i = 0;
        while (ret[i] < n - 1) {
            ret[i + 1] = ret[i] * 3 + 1;
            ++i;
        }
        return Arrays.copyOfRange(ret, 0, i);
    }
}
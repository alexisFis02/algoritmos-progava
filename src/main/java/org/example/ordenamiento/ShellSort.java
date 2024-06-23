package org.example.ordenamiento;
import java.util.Arrays;

public class ShellSort extends AlgoritmoOrdenamiento{
    /*
     * Insersion interativa sobre elementos que distan un valor de la serie de shell
     * */
    @Override
    public void sort(int[] a) { // TODO: revisar complejiodad
        int[] serieShell = getSerieShell(a.length);
        int i,j,k,act,shell,elementos,l;

        for(i = serieShell.length-1; i>=0; --i){ // itero sobre la serie de shell
            shell = serieShell[i]; // valor de la serie

            elementos = a.length-shell+1; // cantidad de elementos que distan shell en el array

            for(l = 0 ; l < elementos; l++) { // todos los elementos que distan shell estan continuos

                // seleccion sobre el subarray que distan shell
                for (j = l; j < a.length; j += shell) {
                    act = a[j];
                    for (k = j; k >= 0; k -= shell) { // itero desde el indice del actual hasta el inicio
                        if (k == l || act > a[k - shell]) { // si el actual es mayor al anterior lo inserto
                            a[k] = act;
                            break;
                        } else { // sino se desplaza el anterior hacia delante
                            a[k] = a[k - serieShell[i]];
                        }
                    }
                }
            }
        }
    }

    public static int[] getSerieShell(int n){
        int[] ret = new int[n];
        ret[0] = 1;
        int i = 0;
        while(ret[i] < n ){
            ret[i+1] = ret[i] * 3+1;
            ++i;
        }
        return Arrays.copyOfRange(ret, 0, i);
    }
}

package org.example.ordenamiento;

import java.util.Arrays;

public class MergeSort extends AlgoritmoOrdenamiento{

    @Override
    public void sort(int[] a) {
        if (a.length <= 1) return;
        int mid = a.length / 2;
        int[] arrayIzq = Arrays.copyOfRange(a, 0, mid);
        int[] arrayDer = Arrays.copyOfRange(a, mid, a.length);
        sort(arrayIzq);
        sort(arrayDer);
        int[] ordenado = merge(arrayIzq, arrayDer);
        System.arraycopy(ordenado, 0, a, 0, a.length);
    }

    /*
     * Fuciona los dos arrays ordenados en un unico array ordenado
     * */
    public static int[] merge(int[] l,int[] r) {
        int[] ret = new int[ l.length + r.length ];
        int i = 0,j = 0,k = 0;
        while( i < l.length && j < r.length) ret[k++] = ( l[i] <= r[j] ) ? l[i++] : r[j++];
        while ( i < l.length ) ret[k++] = l[i++];
        while ( j < r.length) ret[k++] = r[j++];
        return ret;
    }
}
/*
            (####)
          (#######)
        (#########)
       (#########)
      (#########)
     (#########)
    (#########)
   (#########)
  (#########)
   (o)(o)(##)
 ,_C     (##)
/___,   (##)
  \     (#)
   |    |
   OOOOOO
  /      \

 */
package prograva.ordenamiento;

import java.util.Arrays;

public class MergeSort<T extends Comparable<T>> extends AlgoritmoOrdenamiento<T>{

    @Override
    public void sort(T[] a) {
        if (a.length <= 1)
            return;
        int mid = a.length / 2;

        T[] arrayIzq = Arrays.copyOfRange(a, 0, mid);
        T[] arrayDer = Arrays.copyOfRange(a, mid, a.length);

        sort(arrayIzq);
        sort(arrayDer);

        T[] ordenado = merge(arrayIzq, arrayDer);

        System.arraycopy(ordenado, 0, a, 0, a.length);
    }

    /*
     * Fuciona los dos arrays ordenados en un unico array ordenado
     * */
    private T[] merge(T[] izq, T[] der) {
        int i = 0,j = 0,k = 0;

        T[] ret = Arrays.copyOf(izq, izq.length + der.length);

        while( i < izq.length && j < der.length)
            ret[k++] = ( izq[i].compareTo(der[j]) <= 0) ? izq[i++] : der[j++];

        while ( i < izq.length )
            ret[k++] = izq[i++];
        while ( j < der.length)
            ret[k++] = der[j++];

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
package org.example.ordenamiento;

public class InsertionSort extends AlgoritmoOrdenamiento {
    @Override
    public void sort(int[] a) {
        int i, j;
        int act;
        for (i = 1; i < a.length; i++) {
            act = a[i];
            for (j = i; j >= 0; j--) { // itero desde el indice del actual hasta el inicio
                if (j == 0 || act > a[j - 1]) { // si el actual es mayor al anterior lo inserto
                    a[j] = act;
                    break;
                } else { // sino se desplaza el anterior hacia delante
                    a[j] = a[j - 1];
                }
            }
        }
    }
}

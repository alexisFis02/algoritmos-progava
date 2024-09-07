package prograva.ordenamiento;

public class SelectionSort<T extends Comparable<T>> extends AlgoritmoOrdenamiento<T> {

    /*
     * Ordenamiento por seleccion
     * recorre el array buscando e intercambiando el menor elemento en la parte izquierda del array desde el actual
     * */
    @Override
    public void sort(T[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j].compareTo(a[min]) < 0) {
                    min = j;
                }
            }
            swap(a, i, min);
        }
    }

}
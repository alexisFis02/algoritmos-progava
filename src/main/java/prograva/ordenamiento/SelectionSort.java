package prograva.ordenamiento;

public class SelectionSort extends AlgoritmoOrdenamiento{
    /*
     * Ordenamiento por seleccion
     * recorre el array buscando e intercambiando el menor elemento en la parte izquierda del array desde el actual
     * */
    @Override
    public void sort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if ( a[j] < a[min])
                    min = j;
            }
            swap(a, i, min);
        }
    }
}

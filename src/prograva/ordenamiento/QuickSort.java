package prograva.ordenamiento;

public class QuickSort<T extends Comparable<T>> extends AlgoritmoOrdenamiento<T> {

    @Override
    public void sort(T[] a) {
        quickSortImp(a, 0, a.length - 1);
    }

    /*
     * Implementación de quicksort con pivote en el medio
     */
    private void quickSortImp(T[] a, int inf, int sup) {
        if (inf >= sup) return;
        int pivotIndex = (sup + inf) / 2;
        T pivot = a[pivotIndex];
        int i = inf;
        int j = sup;
        swap(a, pivotIndex, sup); // Llevo el pivote hasta el final
        while (i < j) {
            while (i < sup && a[i].compareTo(pivot) < 0) i++;
            while (j > inf && a[j].compareTo(pivot) >= 0) j--;
            if (i < j) swap(a, i, j);
        }
        swap(a, i, sup);
        quickSortImp(a, inf, i - 1); // Ordeno parte izquierda
        quickSortImp(a, i + 1, sup); // Ordeno parte derecha
    }

}

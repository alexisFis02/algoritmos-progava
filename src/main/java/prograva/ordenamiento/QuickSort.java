package prograva.ordenamiento;

public class QuickSort extends AlgoritmoOrdenamiento{
    @Override
    public void sort(int[] a) {
        quickSortImp(a, 0, a.length - 1);
    }

    /*
     * Implementacion de quick sort con pivot en el medio
     */
    public static void quickSortImp(int[] a, int inf,int sup) {
        if (inf >= sup) return;
        int pivotIndex = (sup + inf) / 2;
        int pivot = a[pivotIndex];
        int i = inf;
        int j = sup;
        swap(a, pivotIndex, sup); // llevo el pivote hasta al final
        while (i < j) {
            while (i < sup && a[i] < pivot) i++;
            while (j > inf && a[j] >= pivot) j--;
            if (i < j) swap(a, i, j);
        }
        swap(a, i, sup);
        quickSortImp(a, inf, i - 1); // ordeno parte izquierda
        quickSortImp(a, i + 1, sup); // ordeno parte derecha
    }
}

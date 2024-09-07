package prograva.ordenamiento;

public class InsertionSort<T extends Comparable<T>> extends AlgoritmoOrdenamiento<T> {

    @Override
    public void sort(T[] a) {
        int j,n = a.length;
        for (int i = 1; i < n; i++) {
            T current = a[i];
            j = i;
            while (j > 0 && current.compareTo(a[j - 1]) < 0) {
                a[j] = a[j - 1];
                j--;
            }
            a[j] = current;
        }
    }
}
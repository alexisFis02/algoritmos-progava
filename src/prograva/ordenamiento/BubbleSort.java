package prograva.ordenamiento;

public class BubbleSort<T extends Comparable<T>> extends AlgoritmoOrdenamiento<T> {

    @Override
    public void sort(T[] a) {
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (a[j].compareTo(a[j + 1]) > 0) {
                    swap(a, j, j + 1);
                }
            }
        }
    }
}
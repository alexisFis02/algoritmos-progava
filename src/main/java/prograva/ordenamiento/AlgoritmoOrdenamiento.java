package prograva.ordenamiento;

public abstract class AlgoritmoOrdenamiento {
    abstract public void sort(int[] a);

    static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}

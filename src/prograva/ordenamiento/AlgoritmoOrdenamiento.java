package prograva.ordenamiento;

public abstract class AlgoritmoOrdenamiento<T extends Comparable<T>>{
    abstract public void sort(T[] array);

    static <T> void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}

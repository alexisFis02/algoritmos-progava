package prograva.ordenamiento;

public class BubbleSort extends AlgoritmoOrdenamiento {

    @Override
    public void sort(int[] a) {
        int i, j;
        for (i = 0; i < a.length ; i++) {
            for (j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j + 1])
                    swap(a,j,j+1);
            }
        }
    }
}

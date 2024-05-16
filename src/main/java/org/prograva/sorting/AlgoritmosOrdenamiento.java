package org.prograva.sorting;

import java.util.*;

public class AlgoritmosOrdenamiento {


    public static void quickSort(int[]a, int n) {
        quickSortImp(a,0,n-1);
    }

    /*
    * Implementacion de quick sort con pivot en el medio
    */
    public static void quickSortImp(int[] a, int inf,int sup) {

        if(sup - inf <= 1) return;
        int pivot = a[((sup-inf)/2) + inf];
        int i = inf, j = sup-1;

        swap(a,sup,((sup-inf)/2) + inf); // ahora el pivot esta al final

        while(i<=j){

            while(a[i] < pivot && i < sup){
                i++;
            }

            while(a[j] > pivot && j > inf){
                j--;
            }

            if(i < j)
                swap(a,i,j);
            i++;
            j--;
        }
        swap(a,i-1,sup);

        quickSortImp(a,inf, i-2);
        quickSortImp(a,i,sup);
    }

    /*
    * Insersion interativa sobre elementos que distan un valor de la serie de shell
    * */
    public static void shellSort(int[]a, int n){
        int[] serieShell = getSerieShell(n);
        int i,j,k,act,shell,elementos,l;

        for(i = serieShell.length-1; i>=0; --i){ // itero sobre la serie de shell
            shell = serieShell[i]; // valor de la serie

            elementos = n-shell+1; // cantidad de elementos que distan shell en el array

            for(l = 0 ; l < elementos; l++) { // todos los elementos que distan shell estan continuos

                // seleccion sobre el subarray que distan shell
                for (j = l; j < n; j += shell) {
                    act = a[j];
                    for (k = j; k >= 0; k -= shell) { // itero desde el indice del actual hasta el inicio
                        if (k == l || act > a[k - shell]) { // si el actual es mayor al anterior lo inserto
                            a[k] = act;
                            break;
                        } else { // sino se desplaza el anterior hacia delante
                            a[k] = a[k - serieShell[i]];
                        }
                    }
                }
            }
        }
    }

    public static int[] getSerieShell(int n){
        int[] ret = new int[n];
        ret[0] = 1;
        int i = 0;
        while(ret[i] < n ){
            ret[i+1] = ret[i] * 3+1;
            ++i;
        }
        return Arrays.copyOfRange(ret, 0, i);
    }

    /*
    * Wrapper del merge sort
    * Por que la implementacion require devolver int[]
    * */
    public static void mergeSort(int[]a, int n){
        System.arraycopy(mergeSortImp(a,n),0,a,0,n);
    }

    /*
    * merge sort
    * */
    public static int[] mergeSortImp(int[] a, int n) {
        if(n==1){
            return a;
        }
        int mid = n / 2;

        int[] arrayIzq = Arrays.copyOfRange(a, 0, mid);
        int[] arrayDer = Arrays.copyOfRange(a, mid, n);

        int[] ordenadoIzq = mergeSortImp(arrayIzq, mid);
        int[] ordenadoDer = mergeSortImp(arrayDer, n - mid);

        return merge(ordenadoDer,n-mid, ordenadoIzq, mid);
    }

    /*
    * Fuciona los dos arrays ordenados en un unico array ordenado
    * */
    public static int[] merge(int[] der,int lenDer, int[]izq , int lenIzq) {
        int[] ret = new int[ lenIzq + lenDer];

        int i = 0,j = 0,k = 0;

        while( i < lenDer && j < lenIzq ) ret[k++] = ( der[i] < izq[j] ) ? der[i++] : izq[j++];

        while ( i < lenDer ) ret[k++] = der[i++];

        while ( j < lenIzq ) ret[k++] = izq[j++];

        return ret;
    }

    /*
    * Ordenamiento por seleccion
    * recorre el array buscando e intercambiando el menor elemento en la parte izquierda del array desde el actual
    * */
    public static void selectionSort(int[] a, int n) {
        int iact, j, imenor;
        int act;
        for (iact = 0; iact < n; iact++) {
            imenor = iact;
            for (j = iact; j < n; j++) {
                if(a[imenor] - a[j] > 0) imenor = j;
            }
            swap(a,iact,imenor);
        }
    }

    /*
    * Ordenamiento por insercion
    * recorre el array comparando el actual con cada uno de los anteriores desplanzandolos hacia adelante
    * cuando encuenta uno menos al actual en el anteriores lo inserta
    * */
    public static void insertionSort(int[] a, int n) {
        int i, j;
        int act;
        for (i = 1; i < n; i++) {
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

    public static void bubbleSort(int[] a, int[] n) {
        // TODO: completar
    }

    /**
     * Prueba el algoritmo de ordenamiento dado utilizando arrays aleatorios.
     *
     * @param n              El número de pruebas a realizar.
     * @param maxElements    El máximo número de elementos en cada array aleatorio.
     * @param algoritmo      La interfaz que define el algoritmo de ordenamiento a probar.
     * @return               true si todas las pruebas pasan satisfactoriamente, false en caso contrario.
     */
    public static boolean testearAlgoritmo(int n, int maxElements, AlgoritmosOrdenamientoInterface algoritmo) {
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            int elementos = random.nextInt(maxElements) + 1;

            int[] original = generarArrayAleatorio(elementos);
            int[] aOrdenar = original.clone();

            algoritmo.sort(aOrdenar, elementos);

            if (!verificarOrden(aOrdenar,original)){
                System.out.println("FALLO");
                System.out.println("Original: " + Arrays.toString(original));
                System.out.println("Ordenado: " + Arrays.toString(aOrdenar));
                return false;
            }
        }
        return true;
    }

    public static int[] generarArrayAleatorio(int longitud) {
        Random random = new Random();
        int[] array = new int[longitud];
        for (int i = 0; i < longitud; i++) {
            array[i] = random.nextInt(100);
        }
        return array;
    }

    public static boolean verificarOrden(int[] ordenado, int[] original) {
        if (ordenado == null || original == null || original.length != ordenado.length) return false;
        Arrays.sort(original);
        return Arrays.equals(ordenado, original);
    }

    /*
    * Intercambia el valor en la posicion i con el valor de la posicion j en el array
    * */
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public interface AlgoritmosOrdenamientoInterface {
        void sort(int[] array,int n);
    }
}
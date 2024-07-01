package prograva.mst;
// A Java program for Prim's Minimum Spanning Tree (MST)
// algorithm. The program is for adjacency matrix
// representation of the graph
 
class Prim {
    private void imprimirMST(int pre[], int matrizGrafo[][], int vertices)
    {
        System.out.println("Edge \tWeight");
        for (int i = 1; i < vertices; i++)
            System.out.println(pre[i] + " - " + i + "\t"
                               + matrizGrafo[i][pre[i]]);
    }
	
	
    private int minimaArista(int aristas[], Boolean esMst[], int vertices)
    {

        int min = Integer.MAX_VALUE;
        int indice_min = -1;
 
        for (int v = 0; v < vertices; v++)
            if (esMst[v] == false && aristas[v] < min) {
                min = aristas[v];
                indice_min = v;
            }
 
        return indice_min;
    }
 
    private void inicializarValores(int aristas[], Boolean verticesSet[], int vertices) {
        for (int i = 0; i < vertices; i++) {
            aristas[i] = Integer.MAX_VALUE;
            verticesSet[i] = false;
        }
    }
    
    public void obtenerMST(int matriz[][], int vertices)
    {
        int mst[] = new int[vertices];//parent
        int aristas[] = new int[vertices];//key
        Boolean verticesSet[] = new Boolean[vertices];//mstset
        this.inicializarValores(aristas, verticesSet, vertices);
 
        aristas[0] = 0;
        mst[0] = -1;
 
        for (int i = 0; i < vertices - 1; i++) {
            int min = minimaArista(aristas, verticesSet, vertices);
            verticesSet[min] = true;
 
            for (int v = 0; v < vertices; v++)
                if (matriz[min][v] != 0 && verticesSet[v] == false
                    && matriz[min][v] < aristas[v]) {
                    mst[v] = min;
                    aristas[v] = matriz[min][v];
                }
        }

        imprimirMST(mst, matriz, vertices);
    }
}


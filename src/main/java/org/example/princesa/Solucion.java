package org.example.princesa;

import java.util.*;

public class Solucion {
    private final Set<Integer> dragones;
    private final int[][] grafo ;
    private final int cantNodos;
    private final int nodoPrincipe;
    private final int nodoPrincesa;

    public Solucion(Set<Integer> dragones, int[][] grafo, int claroPrincipe, int claroPrincesa, int cantNodos) {
        this.dragones = dragones;
        this.grafo = grafo;
        this.nodoPrincipe = claroPrincipe;
        this.nodoPrincesa = claroPrincesa;
        this.cantNodos = cantNodos;
    }

    public int[] getSolucion(){
        int[] solucion = new int[cantNodos];
        int[] pred = new int[cantNodos];
        int[] dist = new int[cantNodos];
        Arrays.fill(dist,Integer.MAX_VALUE);

        PriorityQueue<Arista> v_s = new PriorityQueue<>(Comparator.comparingInt(arista -> arista.largo));
        v_s.offer(new Arista(nodoPrincipe, 0));

        for(int i=0; i<cantNodos; i++){
           if(grafo[nodoPrincipe][i] != 0){
               dist[i] = grafo[nodoPrincipe][i];
               v_s.offer(new Arista(i,dist[i]));
           }
        }

        dist[nodoPrincipe] = 0;

        while(!v_s.isEmpty()){
            Arista actual = v_s.poll();
            int c = actual.claro;

            for(int i=0; i < cantNodos; i++){
                if(grafo[c][i] != 0 ){

                    // Agarrar el minimo
                    

                    if (dist[i] > dist[c] + grafo[c][i]) {

                        dist[i] = dist[c] + grafo[c][i];
                        pred[i] = c;

//                        TODO: insertar en la cola
                    }
                }
            }
        }




        return solucion;
    }


//    public static Integer getDist(Integer a, Integer b){
//        return 1;
//    }

//    // TODO: ACA!!!
//    if( arista.largo < w.largo + getDist(w.claro,arista.claro)){
//        dist.put(arista.claro,arista.largo);
//        pred.put(arista.claro,arista.claro);
//    } else {
//        dist.put(arista.claro, w.largo + getDist(w.claro,arista.claro));
//        pred.put(arista.claro,w.claro);
//    }
}

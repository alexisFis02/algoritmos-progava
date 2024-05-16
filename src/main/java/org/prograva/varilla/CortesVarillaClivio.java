package org.prograva.varilla;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CortesVarillaClivio implements Varillable{
	
    private int[][] memoria;
    
    public int costoMinimoCortes(int n, int[] cortes) {
    	List<Integer> pCortes = new ArrayList<>();
    	
        for(int i = 0; i < cortes.length -1 ; i++){
            pCortes.add(cortes[i]);
        }
        pCortes.add(0);
        pCortes.add(n);

        
        
        Collections.sort(pCortes);
 
        memoria = new int
        		[pCortes.size()]
        		[pCortes.size()];

        for(int i = 0; i < memoria.length-1  ; i++) {
        	for(int j = 0; j < memoria[i].length -1 ; j++)
        		memoria[i][j] = -1;
        }
  
        return partir(0, pCortes.size() - 1, pCortes);    
    }

    private int partir(int ini, int fin, List<Integer> pCortes){
    
        if(memoria[ini][fin] == -1){
  
            if(fin == ini + 1){
                memoria[ini][fin] = 0;
            }
            else{
                int minCosto = Integer.MAX_VALUE;
                for(int i = ini + 1; i < fin; i++){
                    minCosto = Math.min(
                    		minCosto, 
                    		pCortes.get(fin) - pCortes.get(fin) + partir(ini, i, pCortes) + partir(i, fin, pCortes)
                    		);
                }
                memoria[ini][fin] = minCosto;
            }
        }

        return memoria[ini][fin];
    }
}

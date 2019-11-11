package objeto;

import java.util.ArrayList;
import java.util.List;

public class tsp {
    private int inicio;
    private int[][] distancias;
    private int[] temp;
    private List<Integer> t2;
    public tsp(int nodoInicial,int[][]distancias){
        this.inicio = nodoInicial;
        this.distancias = distancias;
        temp  = new int[distancias.length];
        t2 = new ArrayList<>();
        System.out.println(algoritmo(0,nodoInicial));
    }

    private int algoritmo(int n,int j){
        if(j>=0) { t2.add(j);}
        if(!t2.contains(n)){ 
            //Ejemplo: w(A,B) + g(B,{C,D}) distancias[inicio][n]
           System.out.println();
           System.out.println(distancias[t2.get(t2.size()-1)][n]);
           temp[n] = distancias[t2.get(t2.size()-1)][n]+algoritmo(0, n);
           System.out.println(distancias[t2.get(t2.size()-1)][n]);
        }
        
        if(n<distancias.length-1){
        n++;
        algoritmo(n,-1);
        }
        int aux=temp[0];
            for(int i=0;i<temp.length;i++){
            if(aux>temp[i]){
                aux = temp[i];
            }
            }
            return aux;
        
    }

}
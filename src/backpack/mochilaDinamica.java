package backpack;

import java.util.ArrayList;
import objeto.item;

public class mochilaDinamica {
    
    private ArrayList<item> articulos;
    private ArrayList<item> Solucion;
    private double[][] mBeneficios;
    private int peso,maximoB;

    public mochilaDinamica(ArrayList<item> items, int _W) {
        this.articulos = items;
        this.peso = _W;
        generarMatrizB();
    }


    private void generarMatrizB() {
        // Inicializamos la matriz de beneficios con el tamaño y pesos
        mBeneficios = new double[this.articulos.size()+1][peso+1];
        // Inicializamos en 0s
        for(int i=0;i<this.articulos.size();i++){
            mBeneficios[0][i] = 0;
        }
        for(int j=0;j<this.peso;j++){
            mBeneficios[j][0]=0;
        }
        resolver();
    }
    
    
    public void resolver(){
        
       for (int i=1;i <= this.articulos.size();i++)
           for(int w=0; w<= this.peso;w++){
// verificamos si el item puede ser parte de la solucion
               if  (this.articulos.get(i-1).getPeso()<= w){
               
                   if ((this.articulos.get(i-1).getValor()+
                           this.mBeneficios[i-1][w-this.articulos.get(i-1).getPeso()])
                           >this.mBeneficios[i-1][w]){
                   
                       this.mBeneficios[i][w] = this.articulos.get(i-1).getValor()+
                               this.mBeneficios[i-1][w-this.articulos.get(i-1).getPeso()];
                       
                   }else{
                   
                        this.mBeneficios[i][w] = this.mBeneficios[i-1][w];
                   
                   }
               
               }else{
               this.mBeneficios[i][w] = this.mBeneficios[i-1][w];
               }
           
           }
       this.maximoB = (int)this.mBeneficios[articulos.size()][peso];
       this.Solucion = new ArrayList<>();
       // calcular los elementos utilizados para _W
       
       int i = this.articulos.size();
       int j = this.peso;

       while (i > 0 && j > 0){
           double val = this.mBeneficios[i][j];
          if( val != this.mBeneficios[i-1][j]){
              this.Solucion.add(this.articulos.get(i-1));
              // imprimir el articulo
              String aux =this.articulos.get(i-1).toString();
              System.out.println(aux);
              i--;
              j = j - this.articulos.get(i).getPeso();
          } else {
            i--;
          }
                   
       }       
       System.out.println();
        }    
}
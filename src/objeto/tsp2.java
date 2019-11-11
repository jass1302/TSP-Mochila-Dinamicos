package objeto;
import java.util.ArrayList;

public class tsp2{
    private ArrayList<Integer> salida = new ArrayList<Integer>();
    
    private int g[][], p[][], npow, N, d[][];
    
    public static long time;

    public tsp2(){

    }

    public ArrayList<Integer> resolver(int[][]matriz,int n){
        long inicio = System.nanoTime();
        N=n;
        npow=(int)Math.pow(2,n);
        g = new int[n][npow];
        p = new int[n][npow];
        d=matriz;
        for(int i=0;i<n;i++){
            for(int j=0;j<npow;j++){
                g[i][j] = -1;
                p[i][j]=-1;
            }
        }
        // Inicializar matriz de distancias
        for(int i=0;i<n;i++){
            g[i][0] = matriz[i][0];
        }
        int resultado = tsp(0,npow-2);
        salida.add(0);
        obtenerCamino(0,npow-2);
        salida.add(resultado);

        long fin = System.nanoTime();
        time = (fin - inicio)/1000;
        return salida;
    }

    private int tsp(int inicio, int set){
        int masked, mask, result = -1, temp;

        if(g[inicio][set]!=-1){
            return g[inicio][set];
        }else{
            for(int x =0;x<N;x++){
                mask = npow -1 - (int) Math.pow(2,x);
                masked = set & mask;
                if(masked!=set){
                    temp = d[inicio][x] + tsp(x,masked);
                    if(result==-1 || result>temp){
                        result=temp;
                        p[inicio][set]=x;
                    }
                }
            }
            g[inicio][set]=result;
            return result;
        }
    }
    
    private void obtenerCamino(int ini, int set){
        if(p[ini][set]==-1){
            return;
        }
        int x = p[ini][set];
        int mask = npow - 1 - (int) Math.pow(2,x);
        int masked = set & mask;
        salida.add(x);
        obtenerCamino(x, masked);
    }
}
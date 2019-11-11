package main;

import java.util.ArrayList;
import java.util.Random;

import backpack.mochilaDinamica;
import objeto.item;
import objeto.tsp;
import objeto.tsp2;

public class mainTSP {
    public static void main(String[] args) throws Exception {
        
        Random p = new Random();
        ArrayList<item> items = new ArrayList<>();
        for(int i=0;i<10;i++){
            item x = new item(p.nextInt(15),p.nextInt(120));
            items.add(x);
        }
        mochilaDinamica prueba = new mochilaDinamica(items,items.size());
        System.out.println("");
       
    }
}
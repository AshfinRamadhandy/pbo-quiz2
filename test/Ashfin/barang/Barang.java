/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ashfin.barang;

import java.util.HashMap;
import java.util.ArrayList;

/**
 *
 * @author Dhandy
 */
public class Barang {
    private HashMap<String , Float> items = new HashMap<>();
    //model menampilkan barang dan harga
    public  Barang(){
        this.items.put ("Kopi" , new Float (10000));
        this.items.put ("Susu" , new Float (20000));
        this.items.put ("Gula" , new Float (30000));
    }
    //membuat arraylist
    public ArrayList<String> getNames(){
        ArrayList <String> brg = new ArrayList<>();
        for(String item : this.items.keySet()){
            brg.add(item);
        }
        return brg;
    }
    
    public ArrayList <Float> getPrices(){
        ArrayList<Float> hrg = new ArrayList<>();
        for (float item : this.items.values()){
            hrg.add(item);
        }
        return hrg;
    }
     
    public void addItem(String name, float harga){
        this.items.put (name,harga);
    }
}

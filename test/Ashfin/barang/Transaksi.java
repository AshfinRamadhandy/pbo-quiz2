/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ashfin.barang;

/**
 *
 * @author Dhandy
 */
import java.util.*;
public class Transaksi {
     // variable kode untuk menampilkan kode item
    private final String kode ;
    // variable item untuk menampilkan item yang dibeli
    private ArrayList<Item> items = new ArrayList<>() ;
    // variable total untuk menampilkan total pembelian
    private float total ; 

    //konstruktor
    public Transaksi(String kode, ArrayList<Item> items) {
        this.kode = kode;
        this.items = items;
    }
    
    //setter total
    public void setTotal(){
        float total = 0;
        for (Item item : this.items){
            total += item.getTotal();
        }
        this.total = total;
    }
    
    
    
}

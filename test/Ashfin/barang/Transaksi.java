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
    
    //hasil transaiksi
    public String Pembayaran(){
        setTotal();
        String itm = "";
       itm += "Kode\t\t : " + this.kode + "\n";
        itm += "Daftar Belanja : \n" ;
        
        for (Item item : this.items){
            itm += "\t" + item.getName() + "(x" + item.getJumlah()+ ") : " + item.getTotal()+ "\n";
        }
        itm += "Total\t\t : " +this.total;
        return itm;
    }
    
}

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
import javax.swing.table.* ;
public class TableItems extends DefaultTableModel {
     //array untuk menyimpan nama kolom
    private String[] kolom ;
    
    // Konstruktor
    public TableItems() {
        this.kolom = new String [] {
            "Nama" , "Harga" , "Jumlah"
        } ;
    }
    
    // getter  KolomNama
    public String[] getKolomNama () {
        return this.kolom ;
    }
    
}

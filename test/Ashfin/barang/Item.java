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
//Deklarasi class item untuk mempresentasikan barang
//yang akan dimasukan dalam daftar belanja.
public class Item {
    //atribut yg digunkana untuk menyimpan nama barang
    private String name;
    //atribut untuk menyimpan jumlah barang yg di beli
    private int jumlah;
    //atribut untuk menyimpan harga barang
    private float harga;

    //konstruktor
    public Item(String name, int jumlah, float harga) {
        this.name = name;
        this.jumlah = jumlah;
        this.harga = harga;
        switch (name){
            case "Kopi" : this.harga = 10000;
            break;
            case "Gula" : this.harga = 20000;
            break;
            case "Susu" : this.harga = 30000;
            break;
        }
    }
    
    public Item(String name,int jumlah){
        this.name = name;
        this.jumlah = jumlah;
    }

    
    //getter nama
    public String getName() {
        return name;
    }

    //setter nama
    public void setName(String name) {
        this.name = name;
    }

    //getter jumlah
    public int getJumlah() {
        return jumlah;
    }

    //setter jumlah
    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    //getter harga
    public float getHarga() {
        return harga;
    }

    //setter harga
    public void setHarga(float harga) {
        this.harga = harga;
    }
    
    public String toString(){
        return this.name;
    } 
    
    public float getTotal(){
        return this.harga*this.jumlah;
                
    }
}


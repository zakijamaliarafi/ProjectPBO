/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectpbo;

/**
 *
 * @author arafi
 */
public class transaksi {
    private String jenis;
    private String nama;
    private int nominal;
    
    public transaksi(String jenis, String nama, int nominal){
        this.jenis = jenis;
        this.nama = nama;
        this.nominal = nominal;
    }
    
    public String getJenis(){
        return jenis;
    }
    
    public String getNama(){
        return nama;
    }
    
    public int getNominal(){
        return nominal;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectpbo;

/**
 *
 * @author arafi
 */
import java.util.ArrayList;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class keuangan {
    private int saldo;
    private static ArrayList<transaksi> daftarTransaksi;
    
    public keuangan(){
        saldo = 0;
        daftarTransaksi = new ArrayList<transaksi>();
    }
    
    public void tambahPemasukan(String nama, int nominal){
        daftarTransaksi.add(new transaksi("pemasukan",nama,nominal));
        saldo += nominal;
    }
    
    public void tambahPengeluaran(String nama, int nominal){
        daftarTransaksi.add(new transaksi("pengeluaran",nama,nominal));
        saldo -= nominal;
    }
    
    public int getSaldo(){
        return saldo;
    }
    
    public void tampilData(){
        for(transaksi listTransaksi:daftarTransaksi){
            if(listTransaksi.getJenis()=="pemasukan"){
                System.out.println("Pemasukan "+listTransaksi.getNama()+" "+listTransaksi.getNominal());
            } else {
                System.out.println("Pengeluaran "+listTransaksi.getNama()+" "+listTransaksi.getNominal());
            }
        }
    }
    
    public void reset(){
        saldo = 0;
        daftarTransaksi.clear();
    }
    
    public void tulis() {
        try {
            File csvFile = new File("data.csv"); //ganti dengan absolute path file csv
            PrintWriter out = new PrintWriter(csvFile);
            for(transaksi listTransaksi:daftarTransaksi){
                out.println(listTransaksi.getJenis()+","+listTransaksi.getNama()+","+listTransaksi.getNominal());
            }
            out.close();
//            System.out.println("sukses");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }
    
    public void baca(){
        try {
            saldo = 0;
            daftarTransaksi.clear();
            Scanner input = new Scanner(new File("data.csv")); //ganti dengan absolute path file csv
            input.useDelimiter(",|\n");
            
            while(input.hasNext()){
                String jenis = input.next();
                String nama = input.next();
                int nominal = input.nextInt();
                
                if(jenis.equals("pemasukan")){
                    daftarTransaksi.add(new transaksi("pemasukan",nama,nominal));
                    saldo += nominal;
                } else{
                    daftarTransaksi.add(new transaksi("pengeluaran",nama,nominal));
                    saldo -= nominal;
                }
            }   
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}

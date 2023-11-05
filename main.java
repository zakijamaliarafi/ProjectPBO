/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectpbo;

/**
 *
 * @author arafi
 */
public class main {
    public static void main(String[] args) {
        keuangan k = new keuangan();
        
        k.tambahPemasukan("uang bulanan",1000000);
        k.tambahPengeluaran("sewa kos", 500000);
        k.tambahPengeluaran("cheese roll", 10000);
        k.tulis();
        k.baca();
        k.tampilData();
        System.out.println(k.getSaldo());
    }
}

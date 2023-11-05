/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectpbo;

/**
 *
 * @author arafi
 */
import java.awt.*; 
import javax.swing.*; 
import static projectpbo.keuangan.daftarTransaksi;

public class gui {
    
    keuangan k;
    DefaultListModel<String> l1;
    
    public gui(){
        k = new keuangan();
        k.baca();
        JFrame frame =new JFrame();//creating instance of JFrame  
        
        JPanel header = new JPanel(new GridBagLayout());
        header.setBounds(10,10,580,150);    
        header.setBackground(Color.gray);
        
        header.setLayout(new GridBagLayout());
        JLabel nama = new JLabel("Nama Aplikasi");
        nama.setFont(new Font("Serif", Font.PLAIN, 30));
        header.add(nama);
        
        JPanel content = new JPanel();
        content.setBounds(10,170,580,600);    
        content.setBackground(Color.gray);
        
        l1 = new DefaultListModel<>();
        JList<String> list = new JList<>(l1);
        list.setFixedCellWidth(500);
        list.setFixedCellHeight(50);
        content.add(list); 
        
        for(transaksi listTransaksi:daftarTransaksi){
            if(listTransaksi.getJenis()=="pemasukan"){
                l1.addElement(listTransaksi.getNama()+" = + Rp."+listTransaksi.getNominal());
            } else {
                l1.addElement(listTransaksi.getNama()+" = - Rp."+listTransaksi.getNominal());
            }
        }
        
        JPanel footer = new JPanel();
        footer.setBounds(10,780,580,150);    
        footer.setBackground(Color.gray);
        
        JButton pemasukan =new JButton("Tambah Pemasukan");
        JButton pengeluaran =new JButton("Tambah Pengeluaran");
        JButton saldo =new JButton("Hitung Saldo");
        JButton reset =new JButton("Reset");
        
        pemasukan.addActionListener(e ->{
            input("pemasukan");   
        });
        
        pengeluaran.addActionListener(e ->{
            input("pengeluaran");   
        });
        
        saldo.addActionListener(e ->{
            tampilSaldo();
        });
        
        reset.addActionListener(e ->{
            k.reset();
            l1.removeAllElements();
        });
        
        footer.add(pemasukan);
        footer.add(pengeluaran);
        footer.add(saldo);
        footer.add(reset);
        
        footer.setLayout(new GridLayout(2,2)); 
        
        
        frame.add(header);
        frame.add(content);
        frame.add(footer);
          
        frame.setSize(600,980);//400 width and 500 height  
        frame.setLayout(null);//using no layout managers  
        frame.setVisible(true);//making the frame visible 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void input(String jenis){
            JFrame framePopup = new JFrame();
            
            JLabel labelNama = new JLabel("Nama");
            labelNama.setBounds(50,30, 100,30);
            
            JTextField inputNama = new JTextField();
            inputNama.setBounds(50, 80, 200, 30);
            
            JLabel labelNominal = new JLabel("Nominal");
            labelNominal.setBounds(50,150, 100,30);
            
            JTextField inputNominal = new JTextField();
            inputNominal.setBounds(50, 180, 200, 30);
            
            JButton ok = new JButton("Ok");
            ok.setBounds(100,250,75,75);
            
            ok.addActionListener(e ->{
            String nama = inputNama.getText();
            int nominal = Integer.valueOf(inputNominal.getText());
            
            if(jenis.equals("pemasukan")){
                k.tambahPemasukan(nama, nominal);
                k.tulis();
                l1.addElement(nama + " = + Rp." + nominal);
                framePopup.dispose();
            } else{
                k.tambahPengeluaran(nama, nominal);
                k.tulis();
                l1.addElement(nama + " = - Rp." + nominal);
                framePopup.dispose();
            }
            });
            
            framePopup.add(labelNama);
            framePopup.add(inputNama);
            framePopup.add(labelNominal);
            framePopup.add(inputNominal);
            framePopup.add(ok);
            
            framePopup.setSize(300,400);//400 width and 500 height  
            framePopup.setLayout(null);//using no layout managers  
            framePopup.setVisible(true);//making the frame visible 
            framePopup.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
    public void tampilSaldo(){
        JFrame framePopup = new JFrame();
            
        JLabel text = new JLabel("Saldo anda adalah:");
        text.setBounds(75,30, 200,30);
            
        JLabel jumlahSaldo = new JLabel("Rp."+Integer.toString(k.getSaldo()));
        jumlahSaldo.setBounds(100,80, 200,30);
            
        framePopup.add(text);
        framePopup.add(jumlahSaldo);
            
        framePopup.setSize(300,200);//400 width and 500 height  
        framePopup.setLayout(null);//using no layout managers  
        framePopup.setVisible(true);//making the frame visible 
        framePopup.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
    public static void main(String[] args) {  
         new gui();
    }  
}

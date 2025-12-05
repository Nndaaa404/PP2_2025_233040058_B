/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.praktikumpemrograman2.Modul08.view;

/**
 *
 * @author nndaa404
 */
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class PersegiPanjangView extends JFrame {
    // Komponen UI sebagai atribut
    private JTextField txtPanjang = new JTextField(10);
    private JTextField txtLebar = new JTextField(10);
    private JLabel lblHasil = new JLabel("-");
    private JLabel lblHasilKeliling = new JLabel("-"); // Untuk Label Keliling Latihan ke 2 
    private JButton btnHitung = new JButton("Hitung Luas");
    private JButton btnHitungKeliling = new JButton("Hitung Keliling"); // Tombol Baru untuk hitung keliling
    private JButton btnReset = new JButton("Reset"); // Tombol Reset Latihan ke 3


    public PersegiPanjangView() {
        //Inisialisasi UI
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 350);
        this.setLayout(new GridLayout(6, 2, 10, 10)); // Grid di ubah jadi 5 baris
        this.setTitle("MVC Kalkulator");

        this.add(new JLabel("Panjang:"));
        this.add(txtPanjang);
        this.add(new JLabel("Lebar:"));
        this.add(txtLebar);
        
        // Baris 3: Tombol Eksekusi
        this.add(btnHitung);
        this.add(btnHitungKeliling); // Menambahkan tombol keliling di sini
        
        this.add(new JLabel("Hasil Luas:"));
        this.add(lblHasil);

        // Baris baru untuk Keliling Latihan 2
        this.add(new JLabel("Hasil Keliling:"));
        this.add(lblHasilKeliling);
        
        // Baris baru untuk tombol reset Latihan 3
        this.add(btnReset); 
        this.add(new JLabel("")); // Spacer kosong
    }
    
    // Mengambil nilai panjang dari Textfield
    public double getPanjang() {
        return Double.parseDouble(txtPanjang.getText());
    }

    // Mengambil nilai lebar dari Textfield
    public double getLebar() {
        return Double.parseDouble(txtLebar.getText());
    }

    // Menampilkan hasil ke Label
    public void setHasil(double hasil) {
        lblHasil.setText(String.valueOf(hasil));
    }
    
    // Menampilkan hasil keliling untuk Latihan 2
    public void setHasilKeliling(double keliling) {
        lblHasilKeliling.setText(String.valueOf(keliling));
    }

    // Method untuk menghapus inputan Latihan 3
    public void clearInput() {
        txtPanjang.setText("");
        txtLebar.setText("");
        lblHasil.setText("-");
        lblHasilKeliling.setText("-");
        txtPanjang.requestFocus();
    }

    // Menampilkan pesan error (jika input bukan angka)
    public void tampilkanPesanError(String pesan) {
        JOptionPane.showMessageDialog(this, pesan);
    }

    // Mendaftarkan Listener untuk tombol (Controller yang akan memberikan aksinya)
    public void addHitungListener(ActionListener listener) {
        btnHitung.addActionListener(listener);
    }
    
    // Listener untuk tombol reset Latihan 3
    public void addResetListener(ActionListener listener) {
        btnReset.addActionListener(listener);
    }
    
    // Listener Tombol Keliling (BARU)
    public void addHitungKelilingListener(ActionListener listener) {
        btnHitungKeliling.addActionListener(listener);
    }
}
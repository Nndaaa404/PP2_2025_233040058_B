/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.praktikumpemrograman2.Modul08.controller;

/**
 *
 * @author nndaa404
 */
import id.ac.unpas.praktikumpemrograman2.Modul08.model.PersegiPanjangModel;
import id.ac.unpas.praktikumpemrograman2.Modul08.view.PersegiPanjangView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PersegiPanjangController {
    // Model dan view sebagai atribut kelas
    private PersegiPanjangModel model;
    private PersegiPanjangView view;

    public PersegiPanjangController(PersegiPanjangModel model, PersegiPanjangView view) {
        this.model = model;
        this.view = view;

        // Menghubungkan tombol di View dengan logic di Controller
        this.view.addHitungListener(new HitungListener());
        
        // Listener untuk Hitung Keliling Latihan 2
        this.view.addHitungKelilingListener(new HitungKelilingListener());
        
        // Menghubungkan tombol Reset untuk Latihan 3
        this.view.addResetListener(new ResetListener());
    }

    // Inner class untuk menangani event klik tombol
    class HitungListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                // 1. Ambil data dari View
                double p = view.getPanjang();
                double l = view.getLebar();

                // 2. Kirim data ke Model
                model.setPanjang(p);
                model.setLebar(l);

                // 3. Jalankan logika bisnis di Model
                model.hitungLuas();

                // 4. Ambil hasil dari Model dan tampilkan kembali di View
                view.setHasil(model.getLuas());

            } catch (NumberFormatException ex) {
                // Handle jika user memasukkan huruf
                view.tampilkanPesanError("Masukkan angka yang valid!");
            }
        }
    }
    
    // Inner Class khusus untuk Keliling Latihan 2
    class HitungKelilingListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                // 1. Ambil data dari View
                double p = view.getPanjang();
                double l = view.getLebar();
                
                // 2. Kirim data ke Model
                model.setPanjang(p);
                model.setLebar(l);
                
                // 3. Jalankan logika bisnis di Model
                model.hitungKeliling();
                
                // 4. Ambil hasil dari Model dan tampilkan kembali di View
                view.setHasilKeliling(model.getKeliling());
                
            } catch (NumberFormatException ex) {
                // Handle jika user memasukan huruf
                view.tampilkanPesanError("Masukkan angka yang valid!");
            }
        }
    }
    
    // Inner class untuk menangani tombol Reset (Latihan 3)
    class ResetListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Memanggil method clearInput di View
            view.clearInput();
        }
    }
}

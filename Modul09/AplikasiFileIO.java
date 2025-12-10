/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.praktikumpemrograman2.Modul09;

/**
 *
 * @author nndaa404
 */

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class AplikasiFileIO extends JFrame {
    
    // Komponen UI
    private JTextArea textArea;
    private JButton btnOpenText, btnSaveText;
    private JButton btnSaveBinary, btnLoadBinary, btnAppendText;
    private JFileChooser fileChooser;
    
    public AplikasiFileIO() {
        super("Tutorial File IO & Exception Handling");
        setSize(700, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Inisialisasi Komponen
        textArea = new JTextArea();
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 27));
        fileChooser = new JFileChooser();

        // Panel Tombol
        JPanel buttonPanel = new JPanel();
        btnOpenText = new JButton("Buka Text");
        btnSaveText = new JButton("Simpan Text");
        btnAppendText = new JButton("Append Text"); // Latihan 4
        btnSaveBinary = new JButton("Simpan Config (Binary)");
        btnLoadBinary = new JButton("Muat Config (Binary)");

        buttonPanel.add(btnOpenText);
        buttonPanel.add(btnSaveText);
        buttonPanel.add(btnAppendText); // Latihan 4
        buttonPanel.add(btnSaveBinary);
        buttonPanel.add(btnLoadBinary);

        // Layout
        add(new JScrollPane(textArea), BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);


        // --- Event Handling ---

        // 1. MEMBACA FILE TEKS (Text Stream)
        btnOpenText.addActionListener(e -> bukaFileTeks());

        // 2. MENULIS FILE TEKS (Text Stream)
        btnSaveText.addActionListener(e -> simpanFileTeks());

        // 3. MENULIS FILE BINARY (Byte Stream)
        btnSaveBinary.addActionListener(e -> simpanConfigBinary());

        // 4. MEMBACA FILE BINARY (Byte Stream)
        btnLoadBinary.addActionListener(e -> muatConfigBinary());
        
        // 5. MENAMBAH TEXT DI BAWAH TEKS LAMA (Append) Latihan 4 
        btnAppendText.addActionListener(e -> tambahFileTeks());
        
        // Latihan 2
        // ketika aplikasi dibuka, otomatis membaca file bernama last_notes.txt jika ada, dan menampilkannya di TextArea.
        try (BufferedReader reader = new BufferedReader(new FileReader("last_notes.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                textArea.append(line + "\n");
            }
        } catch (IOException e) {
            // jika file tidak ada, aplikasi tidak akan error (hanya diam saja)
        }
    }
    
    // Contoh: Membaca File Teks dengan Try-Catch-Finally Konvensional
    private void bukaFileTeks() {
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            BufferedReader reader = null; // Deklarasi di luar try agar bisa diakses di finally

            try {
                // Membuka stream
                reader = new BufferedReader(new FileReader(file));
                textArea.setText(""); // Kosongkan area

                String line;
                // Baca baris demi baris
                while ((line = reader.readLine()) != null) {
                    textArea.append(line + "\n");
                }

                JOptionPane.showMessageDialog(this, "File berhasil dimuat!");

            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(this, "File tidak ditemukan: " + ex.getMessage());
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Gagal membaca file: " + ex.getMessage());
            } finally {
                // Blok Finally: Selalu dijalankan untuk menutup resource
                try {
                    if (reader != null) {
                        reader.close(); // PENTING: Menutup stream
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
    
    // Contoh: Menulis File Teks menggunakan Try-With-Resources (Lebih Modern)
    private void simpanFileTeks() {
        if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();

            // Try-with-resources otomatis menutup stream tanpa blok finally manual
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                writer.write(textArea.getText());
                JOptionPane.showMessageDialog(this, "File berhasil disimpan!");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Gagal menyimpan file: " + ex.getMessage());
            }
        }
    }
    
    // Latihan 4
    private void tambahFileTeks() {
        if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            
            // Parameter 'true' pada FileWriter menandakan mode APPEND
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
                
                writer.newLine();
                writer.write(textArea.getText());
                
                JOptionPane.showMessageDialog(this, "Teks berhasil ditambahkan di baris baru!");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Gagal menambahkan text: " + ex.getMessage());
            }
        }
    }
    
    // Latihan 3
    private void simpanConfigBinary() {
        // 1. Siapkan Objek yang mau disimpan
        UserConfig config = new UserConfig();
        config.setUsername("Nndaaa404"); // Contoh data username
        config.setFontsize(textArea.getFont().getSize()); // Ambil ukuran font saat ini

        // 2. Gunakan ObjectOutputStream untuk menyimpan file .obj atau .ser
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("user.cfg"))) {
            
            oos.writeObject(config); // Menulis seluruh objek ke file
            
            JOptionPane.showMessageDialog(this, "Objek berhasil disimpan ke user.cfg!\n" +
                                                "Username: " + config.getUsername() + "\n" +
                                                "FontSize: " + config.getFontsize());
            
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Gagal menyimpan objek: " + ex.getMessage());
            ex.printStackTrace();
        }
    }


    private void muatConfigBinary() {
        // 1. Gunakan ObjectInputStream untuk membaca file
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user.cfg"))) {
            
            // 2. Baca objek dan lakukan Casting (Pengubahan tipe data) ke UserConfig
            UserConfig config = (UserConfig) ois.readObject();

            // 3. Terapkan konfigurasi dari objek yang dibaca
            textArea.setFont(new Font("Monospaced", Font.PLAIN, config.getFontsize()));
            
            JOptionPane.showMessageDialog(this, "Objek berhasil dimuat!\n" +
                                                "Username: " + config.getUsername() + "\n" +
                                                "Font Size diterapkan: " + config.getFontsize());
            
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "File konfigurasi (user.cfg) belum dibuat!");
        } catch (IOException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Gagal membaca objek: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new AplikasiFileIO().setVisible(true);
        });
    }

}

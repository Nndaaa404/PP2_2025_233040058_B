/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.praktikumpemrograman2.Modul05;

import java.awt.BorderLayout;
import javax.swing.*;

/**
 *
 * @author nndaa404
 */
public class Tugas {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("Contoh BorderLayout");
                frame.setSize(400, 300);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
                // 1. Atur Layout Manager ke BorderLayout
                // Sebenarnya ini tidak perlu
                // Karena Borderlayout adalah Layout Manager default
                frame.setLayout(new BorderLayout());
                                                                                    
                // 2. Buat komponen
                JLabel label = new JLabel("Label ada di Atas (NORTH)");
                JButton buttonS = new JButton("Label ada di Bawah (SOUTH)");
                JButton buttonW = new JButton("WEST");
                JButton buttonE = new JButton("EAST");
                JButton buttonC = new JButton("CENTER");
                
                // 3. Tambahkan Aksi (ActionListener) ke tombol
                buttonS.addActionListener(e -> {
                    label.setText("Tombol di SOUTH diklik!");
                });
                buttonW.addActionListener(e -> {
                    label.setText("Tombol di WEST diklik!");
                });
                buttonE.addActionListener(e -> {
                    label.setText("Tombol di EAST diklik!");
                });
                buttonC.addActionListener(e -> {
                    label.setText("Tombol di CENTER diklik!");
                });
                
                // 4. Tambahkan komponen ke frame DENGAN POSISI
                frame.add(label, BorderLayout.NORTH);
                frame.add(buttonS, BorderLayout.SOUTH);
                frame.add(buttonW, BorderLayout.WEST);
                frame.add(buttonE, BorderLayout.EAST);
                frame.add(buttonC, BorderLayout.CENTER);

                
                frame.setVisible(true);
            }
        });
    }
}

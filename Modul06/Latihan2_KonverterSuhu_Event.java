/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.praktikumpemrograman2.Modul06;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author nndaa404
 */
public class Latihan2_KonverterSuhu_Event {
    public static void main(String[] args) {
        // 1. Buat Frame dan Komponen
        JFrame frame = new JFrame("Konverter Suhu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.setLayout(new GridLayout(2, 3, 10, 10));

        JLabel celsiusLabel = new JLabel("Celcius:");
        JTextField celsiusField = new JTextField();
        JButton convertButton = new JButton("Konversi");
        JLabel fahrenheitLabel = new JLabel("Fahrenheit:");
        JLabel resultLabel = new JLabel("");

        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String celsiusText = celsiusField.getText();
                    double celcius = Double.parseDouble(celsiusText);                    
                    double fahrenheit = (celcius * 9 / 5) + 32;
                    resultLabel.setText(String.format("%.2f", fahrenheit));
                    
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Input salah!");                    
                }
            }
        });

        frame.add(celsiusLabel);
        frame.add(celsiusField);
        frame.add(convertButton);
        frame.add(fahrenheitLabel); 
        frame.add(resultLabel);   

        frame.pack(); 
        frame.setLocationRelativeTo(null); 
        frame.setVisible(true);
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.praktikumpemrograman2.Modul06;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

/**
 *
 * @author nndaa404
 */
public class Latihan1_KalkulatorSederhana_Layout {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Kalkulator Sederhana");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 400);
        
        frame.setLayout(new BorderLayout(10, 10));

        JTextField displayField = new JTextField();
        displayField.setEditable(false); 
        displayField.setHorizontalAlignment(JTextField.RIGHT);
        
        displayField.setPreferredSize(new Dimension(280, 50));
        frame.add(displayField, BorderLayout.NORTH);
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4, 5, 5)); 

        String[] buttonLabels = {
            "1", "2", "3", "/",
            "4", "5", "6", "*",
            "7", "8", "9", "-",
            "0", ".", "=", "+"
        };

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            buttonPanel.add(button);
        }

        frame.add(buttonPanel, BorderLayout.CENTER);

        frame.setVisible(true);
    }
}

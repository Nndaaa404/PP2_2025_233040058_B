/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.praktikumpemrograman2.Modul09;

/**
 *
 * @author nndaa404
 */

import java.io.Serializable;

public class UserConfig implements Serializable {
    
    // Implementasi Serializable wajib ada untuk Object Stream
    private static final long serialVersionUID = 1L; 
    
    private String username;
    private int fontsize;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getFontsize() {
        return fontsize;
    }

    public void setFontsize(int fontsize) {
        this.fontsize = fontsize;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author DELL
 */
public class Supplier {
    private String scode;
    private String sname;
    private String saddress;
    private int colab;

    public Supplier() {
    }

    public Supplier(String scode, String sname, String saddress, int colab) {
        this.scode = scode;
        this.sname = sname;
        this.saddress = saddress;
        this.colab = colab;
    }

    public String getScode() {
        return scode;
    }

    public void setScode(String scode) {
        this.scode = scode;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSaddress() {
        return saddress;
    }

    public void setSaddress(String saddress) {
        this.saddress = saddress;
    }

    public int getColab() {
        return colab;
    }

    public void setColab(int colab) {
        this.colab = colab;
    }
    
}

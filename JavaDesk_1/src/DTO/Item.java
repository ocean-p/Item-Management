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
public class Item {
    private String icode;
    private String iname;
    private String iscode;
    private String isname;
    private String iunit;
    private float iprice;
    private int supplying;

    public Item() {
    }

    public Item(String icode, String iname, String iscode, String isname, String iunit, float iprice, int supplying) {
        this.icode = icode;
        this.iname = iname;
        this.iscode = iscode;
        this.isname = isname;
        this.iunit = iunit;
        this.iprice = iprice;
        this.supplying = supplying;
    }

    public String getIcode() {
        return icode;
    }

    public void setIcode(String icode) {
        this.icode = icode;
    }

    public String getIname() {
        return iname;
    }

    public void setIname(String iname) {
        this.iname = iname;
    }

    public String getIscode() {
        return iscode;
    }

    public void setIscode(String iscode) {
        this.iscode = iscode;
    }

    public String getIsname() {
        return isname;
    }

    public void setIsname(String isname) {
        this.isname = isname;
    }

    public String getIunit() {
        return iunit;
    }

    public void setIunit(String iunit) {
        this.iunit = iunit;
    }

    public float getIprice() {
        return iprice;
    }

    public void setIprice(float iprice) {
        this.iprice = iprice;
    }

    public int getSupplying() {
        return supplying;
    }

    public void setSupplying(int supplying) {
        this.supplying = supplying;
    }

    
    
}

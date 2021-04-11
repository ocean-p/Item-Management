/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Item;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class ItemDAO {
    public static ArrayList<Item> getItems() throws SQLException{
        ArrayList<Item> list=new ArrayList<>();
        Connection cn=MyConnection.makeConnection();
        if(cn!=null){
            String sql="select i.itemCode, i.itemName, s.supCode, s.supName,\n" +
                                "i.unit, i.price, i.supplying\n" +
                                "from tblSuppliers s, tblItems i\n" +
                                "where s.supCode=i.supCode";
            PreparedStatement pst=cn.prepareStatement(sql);
            ResultSet rs=pst.executeQuery();
            while(rs.next()){
                list.add(new Item(rs.getString(1), rs.getString(2), rs.getString(3),
                                    rs.getString(4),rs.getString(5), rs.getFloat(6),
                                    rs.getInt(7)));
            }
            cn.close();
        }
        return list;
    }
    public static int insertItems(String code, String name, String unit,
                            float price, int supplying, String supCode) throws SQLException{
        Connection cn=MyConnection.makeConnection();
        int result=0;
        if(cn!=null){
            String sql="insert tblItems\n" +
                        "values(?,?,?,?,?,?)";
            PreparedStatement pst=cn.prepareStatement(sql);
            pst.setString(1, code);
            pst.setString(2, name);
            pst.setString(3, unit);
            pst.setFloat(4, price);
            pst.setInt(5, supplying);
            pst.setString(6, supCode);
            result=pst.executeUpdate();
            cn.close();
        }
        return result;
    }
    
    public static int updateItems(String code, String name, String unit,
                            float price, int supplying, String supCode) throws SQLException{
        Connection cn=MyConnection.makeConnection();
        int result=0;
        if(cn!=null){
            String sql="update tblItems\n" +
                        "set itemName=?, unit=?,price=?,\n" +
                        "	supplying=?,supCode=?\n" +
                        "where itemCode=?";
            PreparedStatement pst=cn.prepareStatement(sql);
            pst.setString(1, name);
            pst.setString(2, unit);
            pst.setFloat(3, price);
            pst.setInt(4, supplying);
            pst.setString(5, supCode);
            pst.setString(6, code);
            result=pst.executeUpdate();
            cn.close();
        }
        return result;
    }
    
    public static int deleteItems(String code) throws SQLException{
        Connection cn=MyConnection.makeConnection();
        int result=0;
        if(cn!=null){
            String sql="delete tblItems\n" +
                        "where itemCode=?";
            PreparedStatement pst=cn.prepareStatement(sql);
            pst.setString(1, code);
            result=pst.executeUpdate();
            cn.close();
        }
        return result;
    }
}

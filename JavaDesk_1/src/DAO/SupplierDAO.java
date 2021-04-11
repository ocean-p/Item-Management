/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Supplier;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class SupplierDAO {
    //lay cac supplier trong database
    //tra ve danh sach cac supplier
    public static ArrayList<Supplier> getSuppliers() throws SQLException{
        ArrayList<Supplier> list=new ArrayList<>();
        Connection cn=MyConnection.makeConnection();
        if(cn!=null){
            String sql="select *\n" +
                        "from tblSuppliers";
            PreparedStatement pst=cn.prepareStatement(sql);
            ResultSet rs=pst.executeQuery();
            while(rs.next()){
                list.add(new Supplier(rs.getString(1), rs.getString(2),
                                        rs.getString(3), rs.getInt(4)));
            }
            cn.close();
        }
        return list;
    }
    
    public static int getCollab(String code) throws SQLException{
        int result=-1;
        Connection cn=MyConnection.makeConnection();
        if(cn!=null){
            String sql="select collaborating\n" +
                            "from tblSuppliers\n" +
                            "where supCode=?";
            PreparedStatement pst=cn.prepareStatement(sql);
            pst.setString(1, code);
            ResultSet rs=pst.executeQuery();
            while(rs.next()){
                result=rs.getInt(1);
            }
            cn.close();
        }
        return result;
    }
    
    //chen 1 record vao bang supplier
    //tra ve 1 neu thanh cong, tra ve 0 neu that bai
    public static int insertSuppliers(String code, String name, 
                                      String address, int collab) throws SQLException{
        Connection cn=MyConnection.makeConnection();
        int result=0;
        if(cn!=null){
            String sql="insert tblSuppliers\n" +
                       "values(?,?,?,?)";
            PreparedStatement pst=cn.prepareStatement(sql);
            pst.setString(1, code);
            pst.setString(2, name);
            pst.setString(3, address);
            pst.setInt(4, collab);
            result=pst.executeUpdate();
            cn.close();
        }
        return result;
    }
    
    public static int updateSuppliers(String code,String name, String address, int collab) throws SQLException{
        Connection cn=MyConnection.makeConnection();
        int result=0;
        if(cn!=null){
            String sql="update tblSuppliers\n" +
                        "set supName=?,address=?,collaborating=?\n" +
                        "where supCode=?";
            PreparedStatement pst=cn.prepareStatement(sql);
            pst.setString(1, name);
            pst.setString(2, address);
            pst.setInt(3, collab);
            pst.setString(4, code);
            result=pst.executeUpdate();
            cn.close();
        }
        return result;
    }
    
    public static int deleteSuppliers(String code) throws SQLException{
        Connection cn=MyConnection.makeConnection();
        int result=0;
        if(cn!=null){
            String sql="delete tblSuppliers\n" +
                        "where supCode=?";
            PreparedStatement pst=cn.prepareStatement(sql);
            pst.setString(1, code);
            result=pst.executeUpdate();
            cn.close();
        }
        return result;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author DELL
 */
public class UserDAO {
    //check userid vs password có trong table user hay ko
    //tra ve ten user login, tra ve rong neu fail
    public static String checkLogin(String uid, String pass) throws SQLException{
        String result="";
        Connection cn=null;
        //tao connection
        cn=MyConnection.makeConnection();
        if(cn!=null){
            String sql="select fullName\n" +
                        "from tblUsers\n" +
                        "where userID=? and password=?";
            //thuc hien lenh sql
            PreparedStatement pst=cn.prepareStatement(sql);
            pst.setString(1, uid);
            pst.setString(2, pass);
            ResultSet rs=pst.executeQuery();
            //xu li ket qua tren
            if(rs.next()){
                result=rs.getString(1);
            }
            cn.close();
        }
        return result;
    }
}

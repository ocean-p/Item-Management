/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author DELL
 */
public class MyConnection {
    //ham nay de lien ket voi sql server
    public static Connection makeConnection(){
        Connection cn=null;
        try {
            //nap driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //tao ket noi
            String url="jdbc:sqlserver://localhost:1433;databaseName=ItemManagement";
            cn=DriverManager.getConnection(url,"sa","123987");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cn;
    }
}

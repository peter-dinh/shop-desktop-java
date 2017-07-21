/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dinh Truong
 */
public class ConnectMysql {
    public  Connection con = null;
    public  ResultSet rs = null;
    
    
    public void Get_Connect()
    {
        try
        {
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/sales_manager?useUnicode=true&characterEncoding=UTF-8", "root", "");
            System.out.println("kết nối thành công");
            Statement st = con.createStatement();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.out.println("lỗi");
        }
    }

    
    public void Close_Connect()
    {
        try {
            if(con != null)
                con.close();
            System.out.println("Đã ngắt kết nối");
        } catch (SQLException ex) {
            Logger.getLogger(ConnectMysql.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

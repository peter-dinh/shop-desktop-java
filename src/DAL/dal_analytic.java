/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author dinhtruong
 */
public class dal_analytic {
    DAL.ConnectMysql con = new DAL.ConnectMysql();
    
    //--------------------------    Analytic Product     ------------------------------
    
 
    
    public ResultSet Analytic_Type_Product()
    {
        try
        {
            con.Get_Connect();
            String query = "SELECT type_product.id, type_product.name , count(product.id) as number FROM `product` RIGHT JOIN `type_product` on type_product.id = product.id_type GROUP By type_product.id"; 
            Statement cmd = con.con.createStatement();
            ResultSet rs = cmd.executeQuery(query);
            return rs;
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        return null;
    }
    
    public ResultSet Analytic_Count_Bill_Of_Product()
    {
        try
        {
            con.Get_Connect();
            String query = "SELECT product.id, product.name, product.price, product.sale, count(id_bill) as number_bill FROM product LEFT JOIN bill_info on product.id = bill_info.id_product GROUP BY id"; 
            Statement cmd = con.con.createStatement();
            ResultSet rs = cmd.executeQuery(query);
            return rs;
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        return null;
    }
    
    public ResultSet Analytic_Check_Count_Product_1()
    {
        try
        {
            con.Get_Connect();
            String query = "SELECT * FROM `product` WHERE COUNT <= 10"; 
            Statement cmd = con.con.createStatement(); 
            ResultSet rs = cmd.executeQuery(query);
            return rs;
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        return null;
    }
    
    public ResultSet Analytic_Check_Count_Product_2()
    {
        try
        {
            con.Get_Connect();
            String query = "SELECT * FROM `product` WHERE COUNT = 0"; 
            Statement cmd = con.con.createStatement();
            ResultSet rs = cmd.executeQuery(query);
            return rs;
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        return null;
    }
    
    public ResultSet Analytic_Check_Sales_Product()
    {
        try
        {
            con.Get_Connect();
            String query = "SELECT sale , count(*) as number FROM `product` GROUP BY sale"; 
            Statement cmd = con.con.createStatement();
            ResultSet rs = cmd.executeQuery(query);
            return rs;
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        return null;
    }
    
    public ResultSet Analytic_Producer_Of_Product()
    {
        try
        {
            con.Get_Connect();
            String query = "SELECT producer.id, producer.name_producer , count(*) as number FROM `product` RIGHT JOIN producer on producer.id = product.id_producer GROUP BY producer.id"; 
            Statement cmd = con.con.createStatement();
            ResultSet rs = cmd.executeQuery(query);
            return rs;
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        return null;
    }
    //--------------------------------------------------------------------------------
    
    
    //-------------------------------------         Analytic Customer    ---------------------------
    
    public ResultSet Analytic_Customer()
    {
        try
        {
            con.Get_Connect();
            String query = "select * from customer"; 
            Statement cmd = con.con.createStatement();
            ResultSet rs = cmd.executeQuery(query);
            return rs;
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        return null;
    }
    
    
    public ResultSet Analytic_Customer_Local()
    {
        try
        {
            con.Get_Connect();
            String query = "SELECT district.id, district.name_district, district.name_city, COUNT(customer.id) AS number FROM district LEFT JOIN customer on district.id = customer.id_district GROUP BY district.id";
            Statement cmd = con.con.createStatement();
            ResultSet rs = cmd.executeQuery(query);
            return rs;
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        return null;
    }
    
    
    public ResultSet Analytic_Customer_Rank()
    {
        try
        {
            con.Get_Connect();
            String query = "SELECT rank.id, rank.name, rank.sale, rank.rules, COUNT(customer.id) AS number FROM rank LEFT JOIN customer on rank.id = customer.id_rank GROUP BY rank.id";
            Statement cmd = con.con.createStatement();
            ResultSet rs = cmd.executeQuery(query);
            return rs;
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        return null;
    }
    
    
    //--------------------------------------------------------------------------------------
    
    //-------------------------------------         Analytic Staff    ---------------------------
    
    public ResultSet Analytic_Staff()
    {
        try
        {
            con.Get_Connect();
            String query = "SELECT * FROM `staff`"; 
            Statement cmd = con.con.createStatement();
            ResultSet rs = cmd.executeQuery(query);
            return rs;
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        return null;
    }
    
    
    public ResultSet Analytic_Staff_Role()
    {
        try
        {
            con.Get_Connect();
            String query = "SELECT type_staff.id, type_staff.name, COUNT(staff.id) as number FROM type_staff LEFT JOIN staff on type_staff.id = staff.id_type GROUP BY type_staff.id";
            Statement cmd = con.con.createStatement();
            ResultSet rs = cmd.executeQuery(query);
            return rs;
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        return null;
    }
    
    
    public ResultSet Analytic_Staff_Salary()
    {
        try
        {
            con.Get_Connect();
            String query = "SELECT type_staff.salary, COUNT(staff.id) as number FROM type_staff LEFT JOIN staff on type_staff.id = staff.id_type GROUP BY type_staff.salary";
            Statement cmd = con.con.createStatement();
            ResultSet rs = cmd.executeQuery(query);
            return rs;
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        return null;
    }
    
    //--------------------------------------------------------------------------------------
    
    //-------------------------------------         Analytic Bill    ---------------------------
    
    public ResultSet Analytic_Bill()
    {
        try
        {
            con.Get_Connect();
            String query = "select * from bill"; 
            Statement cmd = con.con.createStatement();
            ResultSet rs = cmd.executeQuery(query);
            return rs;
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        return null;
    }
    
    
    public ResultSet Analytic_Bill_Customer()
    {
        try
        {
            con.Get_Connect();
            String query = "SELECT customer.id, customer.first_name, customer.last_name, customer.accumulation , COUNT(bill.id) as number from customer LEFT JOIN bill on customer.id = bill.id_customer GROUP BY customer.id";
            Statement cmd = con.con.createStatement();
            ResultSet rs = cmd.executeQuery(query);
            return rs;
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        return null;
    }
    
    
    public ResultSet Analytic_Bill_Staff()
    {
        try
        {
            con.Get_Connect();
            String query = "SELECT staff.id, staff.first_name, staff.last_name, staff.username , COUNT(bill.id) AS number FROM staff LEFT JOIN bill on staff.id = bill.id_staff GROUP BY staff.id";
            Statement cmd = con.con.createStatement();
            ResultSet rs = cmd.executeQuery(query);
            return rs;
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        return null;
    }
    public ResultSet Analytic_Bill_Product()
    {
        try
        {
            con.Get_Connect();
            String query = "SELECT bill.id,bill.datetime, COUNT(bill_info.id_bill) as number FROM bill LEFT JOIN bill_info on bill.id = bill_info.id_bill GROUP BY bill_info.id_bill"; 
            Statement cmd = con.con.createStatement();
            ResultSet rs = cmd.executeQuery(query);
            return rs;
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        return null;
    }
    
    
    public ResultSet Analytic_Bill_Sales()
    {
        try
        {
            con.Get_Connect();
            String query = "SELECT COUNT(bill.id) as number, sum(sum_bill) as sum_bill, sum(shell_out) as shell_out , DAY(NOW()) AS day FROM bill WHERE month(datetime) = month(now())";
            Statement cmd = con.con.createStatement();
            ResultSet rs = cmd.executeQuery(query);
            return rs;
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        return null;
    }
    
   
    //--------------------------------------------------------------------------------------
    
    //-------------------------------------         Analytic Receive    ---------------------------
    
    public ResultSet Analytic_Receive()
    {
        try
        {
            con.Get_Connect();
            String query = "select * from receive"; 
            Statement cmd = con.con.createStatement();
            ResultSet rs = cmd.executeQuery(query);
            return rs;
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        return null;
    }
    
    
    public ResultSet Analytic_Receive_Producer()
    {
        try
        {
            con.Get_Connect();
            String query = "SELECT receive.id, COUNT(producer.id) as number FROM producer RIGHT JOIN receive on producer.id = receive.id_producer GROUP BY producer.id ORDER BY receive.id DESC";
            Statement cmd = con.con.createStatement();
            ResultSet rs = cmd.executeQuery(query);
            return rs;
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        return null;
    }
    
    
    public ResultSet Analytic_Receive_Staff()
    {
        try
        {
            con.Get_Connect();
            String query = "SELECT staff.id, staff.username , COUNT(receive.id) as number FROM staff LEFT JOIN receive on staff.id = receive.id_staff GROUP BY staff.id ";
            Statement cmd = con.con.createStatement();
            ResultSet rs = cmd.executeQuery(query);
            return rs;
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        return null;
    }
    public ResultSet Analytic_Receive_Product()
    {
        try
        {
            con.Get_Connect();
            String query = "SELECT receive.id, receive.date_time, receive.sum_receive , COUNT(receive_info.id_receive) as number FROM receive LEFT JOIN receive_info on receive.id = receive_info.id_receive GROUP BY receive.id"; 
            Statement cmd = con.con.createStatement();
            ResultSet rs = cmd.executeQuery(query);
            return rs;
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        return null;
    }
    
    
    public ResultSet Analytic_Receive_Capital()
    {
        try
        {
            con.Get_Connect();
            String query = "SELECT COUNT(receive.id) as number, sum(receive.sum_receive) as sum, DAY(NOW()) AS day FROM receive WHERE month(receive.date_time) = month(now())";
            Statement cmd = con.con.createStatement();
            ResultSet rs = cmd.executeQuery(query);
            return rs;
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        return null;
    }
    
    
    
    //--------------------------------------------------------------------------------------
    
    
    
    
    public long[] Analytic_dashboard()
    {
        long[] dashboard = new long[9];
        try
        {
            con.Get_Connect();
            String query = "SELECT sum(bill.shell_out) as sum FROM bill WHERE month(bill.datetime) = month(now())";
            Statement cmd = con.con.createStatement();
            ResultSet rs = cmd.executeQuery(query);
            rs.first();
            dashboard[0] = (rs.getLong("sum"));
            
            query = "SELECT sum(receive.sum_receive)as sum FROM receive WHERE month(receive.date_time) = month(now())";
            rs = cmd.executeQuery(query);
            rs.first();
            dashboard[1] = (rs.getLong("sum"));
            
            query = "SELECT COUNT(*) AS number FROM product";
            rs = cmd.executeQuery(query);
            rs.first();
            dashboard[2] = (rs.getLong("number"));
            
            query = "SELECT COUNT(*) AS number FROM customer";
            rs = cmd.executeQuery(query);
            rs.first();
             dashboard[3] = (rs.getLong("number"));
            
            query = "SELECT COUNT(*) AS number FROM staff";
            rs = cmd.executeQuery(query);
            rs.first();
             dashboard[4] = (rs.getLong("number"));
            
            
            query = "SELECT COUNT(*) AS number FROM bill";
            rs = cmd.executeQuery(query);
            rs.first();
             dashboard[5] = (rs.getLong("number"));
            
            query = "SELECT COUNT(*) AS number FROM receive";
            rs = cmd.executeQuery(query);
            rs.first();
             dashboard[6] = (rs.getLong("number"));
            
            query = "SELECT COUNT(*) AS number FROM district";
            rs = cmd.executeQuery(query);
            rs.first();
             dashboard[7] = (rs.getLong("number"));
            
            
            query = "SELECT COUNT(*) AS number FROM producer";
            rs = cmd.executeQuery(query);
            rs.first();
             dashboard[8] = (rs.getLong("number"));
            
            return dashboard;
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        return null;
    }
}

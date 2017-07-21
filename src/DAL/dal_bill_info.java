/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author dinhtruong
 */
public class dal_bill_info implements  INTERFACE.bill_info {
    DAL.ConnectMysql con = new DAL.ConnectMysql();
    
    private DTO.bill_info GetBillInfoFromResultSet(ResultSet rs) throws SQLException
    {
        DTO.bill_info bill_info = new DTO.bill_info();
        bill_info.setId_bill(rs.getInt("id_bill"));
        bill_info.setId_product(rs.getString("id_product"));
        bill_info.setCount(rs.getInt("count"));
        bill_info.setPrice(rs.getLong("price"));
        bill_info.setSale(rs.getInt("sale"));
        bill_info.setSum(rs.getLong("sum"));
        return bill_info;
    }
    
    public ArrayList <DTO.bill_info> List_Bill_Info(int id_bill)
    {

        try
        {
            con.Get_Connect();
            PreparedStatement ps = con.con.prepareStatement("select * from bill_info where id_bill=?  order by id_product desc");
            ps.setInt(1, id_bill);
            ResultSet rs = ps.executeQuery();
            int n = 0;
            rs.last();
            n = rs.getRow();
            rs.first();
            ArrayList<DTO.bill_info> list_bill_info = new ArrayList<DTO.bill_info>();
            for( int i = 0; i < n; i++)
            {
                list_bill_info.add(GetBillInfoFromResultSet(rs));
                rs.next();
            }
            return list_bill_info;
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            con.Close_Connect();
        }
        return null;
    }
    
    public DTO.bill_info Info_Bill_Info (int id_bill, String id_product)
    {
        try
        {
            con.Get_Connect();
            DTO.bill_info bill_info = new DTO.bill_info();
            String query = "select * from bill_info where id_bill = ? and id_product = ?;";
            PreparedStatement ps = con.con.prepareStatement(query);
            ps.setInt(1,id_bill);
            ps.setString(2, id_product);
            ResultSet rs = ps.executeQuery();
            rs.first();
            bill_info = GetBillInfoFromResultSet(rs);
            return bill_info;
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            con.Close_Connect();
        }
        return null;
    }

    
    public boolean Add(DTO.bill_info bill_info, int id_bill)
    {
        try
        {
            con.Get_Connect();
            PreparedStatement ps = con.con.prepareStatement("INSERT INTO `bill_info` (`id_bill`, `id_product`, `count`, `price`, `sale`, `sum`) VALUES (?,?,?,?,?,?)");
            ps.setInt(1, id_bill);
            ps.setString(2, bill_info.getId_product());
            ps.setInt(3, bill_info.getCount());
            ps.setLong(4, bill_info.getPrice());
            ps.setInt(5, bill_info.getSale());
            ps.setLong(6, bill_info.getSum());
            
            int x = ps.executeUpdate();
            if(x == 1)
            return true;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            con.Close_Connect();
        }
        return false;
    }
    

    public boolean Update(DTO.bill_info bill_info, int id_bill) // update count product
    {
        try
        {
            con.Get_Connect();
            PreparedStatement ps = con.con.prepareStatement("Select * from `bill_info` WHERE `id_bill` = ? and `id_product` = ?");
            ps.setInt(2, id_bill);
            ps.setString(3, bill_info.getId_product());
            ps.setInt(1, bill_info.getCount());
            int x = ps.executeUpdate();
            if(x == 1)
            return true;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            con.Close_Connect();
        }
        return false;
    }
    

    public boolean Del (DTO.bill_info bill_info, int id_bill)
    {
        try
        {
            con.Get_Connect();
            PreparedStatement ps = con.con.prepareStatement("DELETE FROM `bill_info` WHERE  `id_bill` = ? and `id_product` = ?");
            ps.setInt(1, id_bill);
            ps.setString(2, bill_info.getId_product());
            System.out.println(ps.toString());
            int x = ps.executeUpdate();
            if(x == 1 )
                return true;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            con.Close_Connect();
        }
        return false;
    }
    
    public int Count_Bill_Info(int id_bill)
    {
        try
        {
            con.Get_Connect();
            PreparedStatement ps = con.con.prepareStatement("select * from bill_info where id_bill =?");
            ps.setInt(1, id_bill);
            ResultSet rs = ps.executeQuery();
            rs.last();
            return rs.getRow();
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            con.Close_Connect();
        }
        return 0;
    }
    
    public boolean  Check_Bill_Info(int id_bill, String id_product)
    {
        try
        {
            con.Get_Connect();
            PreparedStatement ps = con.con.prepareStatement("select * FROM `bill_info` WHERE  `id_bill` = ? and `id_product` = ?");
            ps.setInt(1, id_bill);
            ps.setString(2, id_product);
            ResultSet rs = ps.executeQuery();
            if(rs.first() == false )
                return true;
            else
            {
                JOptionPane.showMessageDialog(null, "Product exist in bill");
                return false;
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            con.Close_Connect();
        }
        return false;
    }
    
    
    
    public boolean Del_All_Bill_Product(int id_bill)
    {
        try
        {
            con.Get_Connect();
            PreparedStatement ps = con.con.prepareStatement("DELETE FROM `bill_info` WHERE  `id_bill` = ?");
            ps.setInt(1, id_bill);
            System.out.println(ps.toString());
            int x = ps.executeUpdate();
            if(x == 1 )
                return true;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            con.Close_Connect();
        }
        return false;
    }
    
    public long Sum_Bill(int id_bill)
    {
        try
        {
            con.Get_Connect();
            PreparedStatement ps = con.con.prepareStatement("select * FROM `bill_info` WHERE  `id_bill` = ?");
            ps.setInt(1, id_bill);
            ResultSet rs = ps.executeQuery();
            if(rs.first() == false) return 0;
            else
            {
                int n = 0;
                long sum = 0;
                rs.last();
                n = rs.getRow();
                rs.first();
                for(int i = 0 ; i < n; i++)
                {
                    System.out.println(rs.getLong("sum"));
                    sum = sum + rs.getLong("sum");
                    rs.next();
                }
                System.out.println(sum);
                return sum;
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            con.Close_Connect();
        }
        return 0;
    }
    
}

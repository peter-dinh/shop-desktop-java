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
public class dal_receive_info implements INTERFACE.receive_info{
    DAL.ConnectMysql con = new DAL.ConnectMysql();
    
    private DTO.receive_info GetReceiveInfoFromResultSet(ResultSet rs) throws SQLException
    {
        DTO.receive_info receive_info = new DTO.receive_info();
        receive_info.setId_receive(rs.getInt("id_receive"));
        receive_info.setId_product(rs.getString("id_product"));
        receive_info.setCount(rs.getInt("count"));
        receive_info.setCost(rs.getLong("cost"));
        receive_info.setSum(rs.getLong("sum"));
        return receive_info;
    }
    
    public ArrayList <DTO.receive_info> List_Receive_Info(int id_receive)
    {

        try
        {
            con.Get_Connect();
             
            PreparedStatement ps = con.con.prepareStatement("select * from receive_info where id_receive = ?");
            ps.setInt(1, id_receive);
            ResultSet rs = ps.executeQuery();
            int n = 0;
            rs.last();
            n = rs.getRow();
            rs.first();
            ArrayList<DTO.receive_info> list_receive_info = new ArrayList<DTO.receive_info>();
            for( int i = 0; i < n; i++)
            {
                list_receive_info.add(GetReceiveInfoFromResultSet(rs));
                rs.next();
            }
            return list_receive_info;
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
    
    public DTO.receive_info Info_Receive_Info (int id_receive, String id_product) 
    {
        try
        {
            con.Get_Connect();
            DTO.receive_info receive_info = new DTO.receive_info();
            String query = "select * from receive_info where id_receive = ? and id_product = ?";
            PreparedStatement ps = con.con.prepareStatement(query);
            ps.setInt(1,id_receive);
            ps.setString(2, id_product);
            ResultSet rs = ps.executeQuery();
            rs.first();
            receive_info = GetReceiveInfoFromResultSet(rs);
            return receive_info;
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

    
    public boolean Add(DTO.receive_info receive_info)
    {
        try
        {
            con.Get_Connect();
            PreparedStatement ps = con.con.prepareStatement("INSERT INTO `receive_info`(`id_receive`, `id_product`, `count`, `cost`, `sum`) VALUES (?,?,?,?,?)");
            ps.setInt(1, receive_info.getId_receive());
            ps.setString(2, receive_info.getId_product());
            ps.setInt(3, receive_info.getCount());
            ps.setLong(4, receive_info.getCost());
            ps.setLong(5, receive_info.getSum());
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
    

    public boolean Update(DTO.receive_info receive_info)
    {
        try
        {
            con.Get_Connect();
            PreparedStatement ps = con.con.prepareStatement("UPDATE `receive_info` SET  `count`= ? WHERE `id_receive`= ? and `id_product`= ?");
            ps.setInt(2, receive_info.getId_receive());
            ps.setString(3, receive_info.getId_product());
            ps.setInt(1, receive_info.getCount());
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
    

    public boolean Del (DTO.receive_info receive_info)
    {
        try
        {
            con.Get_Connect();
            PreparedStatement ps = con.con.prepareStatement("DELETE FROM `receive_info` WHERE  `id_receive` = ? and `id_product`= ?");
            ps.setInt(1, receive_info.getId_receive());
            ps.setString(2, receive_info.getId_product());
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
    
    public boolean Del_All_Receive_Info(int id_receive)
    {
        try
        {
            con.Get_Connect();
            PreparedStatement ps = con.con.prepareStatement("DELETE FROM `receive_info` WHERE  `id_receive` = ?");
            ps.setInt(1, id_receive);
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
    
    
    public long Sum_Receive(int id_receive)
    {
        try
        {
            con.Get_Connect();
            PreparedStatement ps = con.con.prepareStatement("select * FROM `receive_info` WHERE  `id_receive` = ?");
            ps.setInt(1, id_receive);
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
    

    public boolean  Check_Receive_Info(int id_receive, String id_product)
    {
        try
        {
            con.Get_Connect();
            PreparedStatement ps = con.con.prepareStatement("select * FROM `receive_info` WHERE  `id_receive` = ? and `id_product` = ?");
            ps.setInt(1, id_receive);
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
}

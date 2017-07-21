/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author dinhtruong
 */
public class dal_receive implements INTERFACE.receive {
    DAL.ConnectMysql con = new DAL.ConnectMysql();
    
    private DTO.receive GetReceiveFromResultSet(ResultSet rs) throws SQLException
    {
        DTO.receive receive = new DTO.receive();
        receive.setId(rs.getInt("id"));
        receive.setId_producer(rs.getInt("id_producer"));
        receive.setId_staff(rs.getString("id_staff"));
        receive.setDate_time(rs.getString("date_time"));
        receive.setSum_receive(rs.getLong("sum_receive"));
        return receive;
    }
    
    
    public ArrayList <DTO.receive> List_Receive()
    {

        try
        {
            con.Get_Connect();
            String query = "select * from receive order by id desc"; 
            Statement cmd = con.con.createStatement();
            ResultSet rs = cmd.executeQuery(query);
            int n = 0;
            rs.last();
            n = rs.getRow();
            rs.first();
            ArrayList<DTO.receive> list_receive = new ArrayList<DTO.receive>();
            for( int i = 0; i < n; i++)
            {
                list_receive.add(GetReceiveFromResultSet(rs));
                rs.next();
            }
            return list_receive;
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
    
    public DTO.receive Info_Receive (int id) 
    {
        try
        {
            con.Get_Connect();
            DTO.receive receive = new DTO.receive();
            String query = "select * from receive where id = ?;";
            PreparedStatement ps = con.con.prepareStatement(query);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            rs.first();
            receive = GetReceiveFromResultSet(rs);
            return receive;
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

    
    public boolean Add(DTO.receive receive)
    {
        try
        {
            con.Get_Connect();
            PreparedStatement ps = con.con.prepareStatement("INSERT INTO `receive`(`id`, `id_producer`, `id_staff`, `date_time`, `sum_receive`) VALUES (?,?,?,?,?)");
            ps.setInt(1, receive.getId());
            ps.setInt(2, receive.getId_producer());
            ps.setString(3, receive.getId_staff());
            ps.setString(4, receive.getDate_time());
            ps.setLong(5, receive.getSum_receive());
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
    

    public boolean Update(DTO.receive receive)
    {
        try
        {
            con.Get_Connect();
            PreparedStatement ps = con.con.prepareStatement("UPDATE `receive` SET `id_producer`=?,`id_staff`=?,`date_time`=?,`sum_receive`=? WHERE `id`= ?");
            ps.setInt(5, receive.getId());
            ps.setInt(1, receive.getId_producer());
            ps.setString(2, receive.getId_staff());
            ps.setString(3, receive.getDate_time());
            ps.setLong(4, receive.getSum_receive());
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
    

    public boolean Del (DTO.receive receive)
    {
        try
        {
            con.Get_Connect();
            PreparedStatement ps = con.con.prepareStatement("DELETE FROM `receive` WHERE  `id` = ?");
            ps.setInt(1, receive.getId());
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
    
    
    public ArrayList<DTO.receive> List_Search(int numParameter, String query, String keyword) 
    {
        try
        {
            con.Get_Connect();
            PreparedStatement ps = con.con.prepareStatement(query);
            for(int i = 1; i <= numParameter; i++)
               ps.setString(i,("%"+ keyword +"%"));

            ResultSet rs = ps.executeQuery();
            int n = 0;
            rs.last();
            n = rs.getRow();
            rs.first();
            ArrayList<DTO.receive> list_search = new ArrayList<DTO.receive>();
            for ( int i = 0 ; i < n; i++)
            {
                list_search.add(GetReceiveFromResultSet(rs));
                rs.next();
            }
            return list_search;
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
    
    public int Get_Max_ID_Receive()
    {
        try
        {
            con.Get_Connect();
            String query = "select * from receive order by id desc"; 
            Statement cmd = con.con.createStatement();
            ResultSet rs = cmd.executeQuery(query);
            if(rs.first() == false) return 1;
            else
            {
                rs.first();
                int n = rs.getInt("id");
                return n+1;
            }
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            con.Close_Connect();
        }
        return 1;
    }
}

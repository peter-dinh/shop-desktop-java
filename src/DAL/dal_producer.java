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
public class dal_producer implements INTERFACE.producer {
    DAL.ConnectMysql con = new DAL.ConnectMysql();
    
    private DTO.producer GetProducerFromResultSet(ResultSet rs) throws SQLException
    {
        DTO.producer producer = new DTO.producer();
        producer.setId(rs.getInt("id"));
        producer.setName_producer(rs.getString("name_producer"));
        producer.setAddress(rs.getString("address"));
        producer.setPhone(rs.getString("phone"));
        producer.setMail(rs.getString("mail"));
        return producer;
    }
    
    public ArrayList <DTO.producer> List_Producer() 
    {

        try
        {
            con.Get_Connect();
            String query = "select * from producer order by id desc"; 
            Statement cmd = con.con.createStatement();
            ResultSet rs = cmd.executeQuery(query);
            int n = 0;
            rs.last();
            n = rs.getRow();
            rs.first();
            ArrayList<DTO.producer> list_producer = new ArrayList<DTO.producer>();
            for( int i = 0; i < n; i++)
            {
                list_producer.add(GetProducerFromResultSet(rs));
                rs.next();
            }
            return list_producer;
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
    
    public DTO.producer Info_Producer (int id)
    {
        try
        {
            con.Get_Connect();
            DTO.producer producer = new DTO.producer();
            String query = "select * from producer where id = ?;";
            PreparedStatement ps = con.con.prepareStatement(query);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            rs.first();
            producer = GetProducerFromResultSet(rs);
            return producer;
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

    
    public boolean Add(DTO.producer producer)
    {
        try
        {
            con.Get_Connect();
            PreparedStatement ps = con.con.prepareStatement("INSERT INTO `producer`(`id`, `name_producer`, `address`, `phone`, `mail`) VALUES (?,?,?,?,?)");
            ps.setInt(1, producer.getId());
            ps.setString(2, producer.getName_producer());
            ps.setString(3, producer.getAddress());
            ps.setString(4, producer.getPhone());
            ps.setString(5, producer.getMail());
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
    

    public boolean Update(DTO.producer producer)
    {
        try
        {
            con.Get_Connect();
            PreparedStatement ps = con.con.prepareStatement("UPDATE `producer` SET `name_producer`=?,`address`=?,`phone`=?,`mail`=?  WHERE `id`= ?");
            ps.setInt(5, producer.getId());
            ps.setString(1, producer.getName_producer());
            ps.setString(2, producer.getAddress());
            ps.setString(3, producer.getPhone());
            ps.setString(4, producer.getMail());
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
    

    public boolean Del (DTO.producer producer)
    {
        try
        {
            con.Get_Connect();
            PreparedStatement ps = con.con.prepareStatement("DELETE FROM `producer` WHERE  `id` = ?");
            ps.setInt(1, producer.getId());
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
    
    
    public ArrayList<DTO.producer> List_Search(int numParameter, String query, String keyword)
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
            ArrayList<DTO.producer> list_search = new ArrayList<DTO.producer>();
            for ( int i = 0 ; i < n; i++)
            {
                list_search.add(GetProducerFromResultSet(rs));
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
    
    
    public int Get_Max_ID_Producer()
    {
        try
        {
            con.Get_Connect();
            String query = "select * from producer order by id desc"; 
            Statement cmd = con.con.createStatement();
            ResultSet rs = cmd.executeQuery(query);
            if (rs.first() == false) return 1;
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
    
    
    public ArrayList<String> List_Name_Producer()
    {
        try
        {
            con.Get_Connect();
            String query = "select * from `producer`"; 
            Statement cmd = con.con.createStatement();
            ResultSet rs = cmd.executeQuery(query);
            int n = 0;
            rs.last();
            n = rs.getRow();
            rs.first();
            ArrayList<String> list_name_producer = new ArrayList<String>();
            ArrayList<DTO.producer> list_producer = new ArrayList<DTO.producer>();
            
            for( int i = 0; i < n; i++)
            {
                list_producer.add(GetProducerFromResultSet(rs));
                rs.next();
            }
            
            for(DTO.producer producer : list_producer)
            {
                String str = String.format("%1$02d", producer.getId())+" | "+producer.getName_producer();
                list_name_producer.add(str);
            }
            return list_name_producer;
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
    
    public ArrayList<String> List_Name_Producer_By_ID(int id_producer)
    {
        try
        {
            con.Get_Connect();
            String query = "select * from `producer` where id =?"; 
            PreparedStatement ps = con.con.prepareStatement("select * from `producer` where id =?");
            ps.setInt(1, id_producer);
            ResultSet rs = ps.executeQuery();
            int n = 0;
            rs.last();
            n = rs.getRow();
            rs.first();
            ArrayList<String> list_name_producer = new ArrayList<String>();
            ArrayList<DTO.producer> list_producer = new ArrayList<DTO.producer>();
            
            for( int i = 0; i < n; i++)
            {
                list_producer.add(GetProducerFromResultSet(rs));
                rs.next();
            }
            
            for(DTO.producer producer : list_producer)
            {
                String str = String.format("%1$02d", producer.getId())+" | "+producer.getName_producer();
                list_name_producer.add(str);
            }
            return list_name_producer;
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
}

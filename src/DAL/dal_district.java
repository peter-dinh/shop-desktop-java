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
public class dal_district implements INTERFACE.district {
    DAL.ConnectMysql con = new DAL.ConnectMysql();
    
    private DTO.district GetDistrictFromResultSet(ResultSet rs) throws SQLException
    {
        DTO.district district = new DTO.district();
        district.setId(rs.getInt("id"));
        district.setName_district(rs.getString("name_district"));
        district.setName_city(rs.getString("name_city"));
        return district;
    }
    
    public ArrayList <DTO.district> List_District()
    {

        try
        {
            con.Get_Connect();
            String query = "select * from district order by id desc"; 
            Statement cmd = con.con.createStatement();
            ResultSet rs = cmd.executeQuery(query);
            int n = 0;
            rs.last();
            n = rs.getRow();
            rs.first();
            ArrayList<DTO.district> list_district = new ArrayList<DTO.district>();
            for( int i = 0; i < n; i++)
            {
                list_district.add(GetDistrictFromResultSet(rs));
                rs.next();
            }
            return list_district;
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
    
    public DTO.district Info_District (int id)
    {
        try
        {
            con.Get_Connect();
            DTO.district district = new DTO.district();
            String query = "select * from district where id = ?;";
            PreparedStatement ps = con.con.prepareStatement(query);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            rs.first();
            district = GetDistrictFromResultSet(rs);
            return district;
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

    
    public boolean Add(DTO.district district)
    {
        try
        {
            con.Get_Connect();
            PreparedStatement ps = con.con.prepareStatement("INSERT INTO `district`(`id`, `name_district`, `name_city`) VALUES (?,?,?)");
            ps.setInt(1, district.getId());
            ps.setString(2, district.getName_district());
            ps.setString(3, district.getName_city());
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
    

    public boolean Update(DTO.district district)
    {
        try
        {
            con.Get_Connect();
            PreparedStatement ps = con.con.prepareStatement("UPDATE `district` SET `name_district`=?,`name_city`=? WHERE `id`= ?");
            ps.setInt(3, district.getId());
            ps.setString(1, district.getName_district());
            ps.setString(2, district.getName_city());
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
    

    public boolean Del (DTO.district district)
    {
        try
        {
            con.Get_Connect();
            PreparedStatement ps = con.con.prepareStatement("DELETE FROM `district` WHERE  `id` = ?");
            ps.setInt(1, district.getId());
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
    
    
    public ArrayList<DTO.district> List_Search(int numParameter, String query, String keyword)
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
            ArrayList<DTO.district> list_search = new ArrayList<DTO.district>();
            for ( int i = 0 ; i < n; i++)
            {
                list_search.add(GetDistrictFromResultSet(rs));
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
    
    public int Get_Max_ID_District()
    {
        try
        {
            con.Get_Connect();
            String query = "select * from district order by id desc"; 
            Statement cmd = con.con.createStatement();
            ResultSet rs = cmd.executeQuery(query);
            if(rs.first() == false) System.out.print("null");
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

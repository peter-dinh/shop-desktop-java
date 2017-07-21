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
public class dal_type_product implements INTERFACE.type_product {
    private ConnectMysql con = new ConnectMysql();
    
    private DTO.type_product GetTypeProductFromResultSet(ResultSet rs) throws SQLException
    {
            DTO.type_product type_product = new DTO.type_product();
            type_product.setId(rs.getInt("id"));
            type_product.setName(rs.getString("name"));

            return type_product;
    }
    
    
    public ArrayList<DTO.type_product> List_Type_Product()
    {
        try
        {
            con.Get_Connect();
            String query = "SELECT * FROM `type_product` order by id desc";
            Statement st = con.con.createStatement();
            ResultSet rs = st.executeQuery(query);
            int n = 0;
            rs.last();
            n = rs.getRow();
            rs.first();
            ArrayList<DTO.type_product> list = new ArrayList<DTO.type_product>();
            for(int i = 0 ;i < n; i++)
            {
                list.add(GetTypeProductFromResultSet(rs));
                rs.next();
            }
            return list;
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
    
    
   
    
    public boolean Add(DTO.type_product type_product)
    {
        try
        {
            con.Get_Connect();
            String query ="INSERT INTO `type_product`(`id`, `name`) VALUES (?,?)";
            PreparedStatement ps = con.con.prepareStatement(query);
            ps.setInt(1, type_product.getId());
            ps.setString(2, type_product.getName());
            int n = ps.executeUpdate();
            if(n == 1) return true; 
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            con.Close_Connect();
        }
        return false;
    }
    
    
    public boolean Update(DTO.type_product type_product)
    {
        try
        {
            con.Get_Connect();
            String query ="UPDATE `type_product` SET `name`=? WHERE `id`=?";
            PreparedStatement ps = con.con.prepareStatement(query);
            
            ps.setString(2, String.valueOf(type_product.getId()));
            ps.setString(1, type_product.getName());

            int n = ps.executeUpdate();
            if(n == 1) return true; 
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            con.Close_Connect();
        }
        return false;
    }
    

    public boolean Del(DTO.type_product type_product)
    {
        try
        {
            con.Get_Connect();
            String query ="DELETE FROM `type_product` WHERE `id` = ?";
            PreparedStatement ps = con.con.prepareStatement(query);
            ps.setInt(1,type_product.getId());         
            int n = ps.executeUpdate();
            if(n == 1) return true; 
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            con.Close_Connect();
        }
        return false;
    }

    
    
    public ArrayList<DTO.type_product> List_Search(int numParameter, String query, String keyword ) throws SQLException
    {
        try
        {
            con.Get_Connect();
            PreparedStatement ps = con.con.prepareStatement(query);
            for(int i = 1 ; i <= numParameter; i++ )
            {
                ps.setString(i, "%" + keyword + "%");
            }
            ResultSet rs = ps.executeQuery();
            int n =0;
            rs.last();
            n = rs.getRow();
            rs.first();
            ArrayList<DTO.type_product> list_search = new ArrayList<DTO.type_product>();
            for ( int i = 0 ; i < n; i++)
            {
                list_search.add(GetTypeProductFromResultSet(rs));
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

    
    public DTO.type_product Info_Type_Product(int id)
    {
        try
        {
            con.Get_Connect();
            String query = "select * from type_product where `id` = ?";
            PreparedStatement ps = con.con.prepareStatement(query);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            rs.first();
            DTO.type_product type_product = GetTypeProductFromResultSet(rs);
            return type_product;
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
    
    public int Get_Max_ID_Type_Product()
    {
        try
        {
            con.Get_Connect();
            String query = "select * from type_product order by id desc";
            Statement st= con.con.createStatement();
            ResultSet rs = st.executeQuery(query);
            int n = 0;
            rs.last();
            n = rs.getInt("id");
            return n+1;
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

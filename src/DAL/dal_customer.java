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
public class dal_customer implements INTERFACE.customer {
    DAL.ConnectMysql con = new DAL.ConnectMysql();
    
    private DTO.customer GetCustomerFromResultSet(ResultSet rs)
    {
        try {
            DTO.customer customer = new DTO.customer();
            customer.setId_customer(rs.getString("id"));
            customer.setFirst_name(rs.getString("first_name"));
            customer.setLast_name(rs.getString("last_name"));
            customer.setAddress(rs.getString("address"));
            customer.setId_district(rs.getInt("id_district"));
            customer.setPhone(rs.getString("phone"));
            customer.setAccumulation(rs.getLong("accumulation"));
            customer.setId_rank(rs.getInt("id_rank"));
            customer.setDate_regiter(rs.getString("date_register"));
            return customer;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public ArrayList <DTO.customer> List_Customer()
    {

        try
        {
            con.Get_Connect();
            String query = "select * from customer order by id desc"; 
            Statement cmd = con.con.createStatement();
            ResultSet rs = cmd.executeQuery(query);
            int n = 0;
            rs.last();
            n = rs.getRow();
            rs.first();
            ArrayList<DTO.customer> list_customer = new ArrayList<DTO.customer>();
            for( int i = 0; i < n; i++)
            {
                list_customer.add(GetCustomerFromResultSet(rs));
                rs.next();
            }
            return list_customer;
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
    
    public DTO.customer Info_Customer (String id)
    {
        try
        {
            con.Get_Connect();
            String query = "select * from customer where id = ?";
            PreparedStatement ps = con.con.prepareStatement(query);
            ps.setString(1,id);
            ResultSet rs = ps.executeQuery();
            if(rs.first() == false) return null;
            else
            {
                rs.first();
                DTO.customer customer = GetCustomerFromResultSet(rs);
                return customer;
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
        return null;
    }

    
    public boolean Add(DTO.customer customer)
    {
        try
        {
            con.Get_Connect();
            PreparedStatement ps = con.con.prepareStatement("INSERT INTO `customer`(`id`, `first_name`, `last_name`, `address`, `id_district`, `phone`, `accumulation`, `id_rank`, `date_register`) VALUES (?,?,?,?,?,?,'0','10',?)");
            ps.setString(1, customer.getId_customer());
            ps.setString(2, customer.getFirst_name());
            ps.setString(3, customer.getLast_name());
            ps.setString(4, customer.getAddress());
            ps.setInt(5, customer.getId_district());
            ps.setString(6, customer.getPhone());
            ps.setString(7, customer.getDate_regiter());
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
    

    public boolean Update(DTO.customer customer)
    {
        try
        {
            con.Get_Connect();
            PreparedStatement ps = con.con.prepareStatement("UPDATE `customer` SET `first_name`=?,`last_name`=?,`address`=?,`phone`=?, `id_district`=? WHERE `id`= ?");
            ps.setString(6, customer.getId_customer());
            ps.setString(1, customer.getFirst_name());
            ps.setString(2, customer.getLast_name());
            ps.setString(3, customer.getAddress());
            ps.setString(4, customer.getPhone());
            ps.setInt(5, customer.getId_district());
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
    

    public boolean Del (DTO.customer customer)
    {
        try
        {
            con.Get_Connect();
            PreparedStatement ps = con.con.prepareStatement("DELETE FROM `customer` WHERE `id`= ?");
            ps.setString(1, customer.getId_customer());
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
    
    
    public ArrayList<DTO.customer> List_Search(int numParameter, String query, String keyword)
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
            ArrayList<DTO.customer> list_search = new ArrayList<DTO.customer>();
            for ( int i = 0 ; i < n; i++)
            {
                list_search.add(GetCustomerFromResultSet(rs));
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

    
    
    //---------------------------      UPdate  use frame other       ---------------------------------
    
    public boolean Update_Accumulation(String id_customer, long add)
    {
        DTO.customer customer = Info_Customer(id_customer);
        long accumulation_cur = customer.getAccumulation()+ add;
        try
        {
            con.Get_Connect();
            PreparedStatement ps = con.con.prepareStatement("update customer set accumulation=? where id = ?");
            ps.setString(2, id_customer);
            ps.setLong(1, accumulation_cur);
            int x = ps.executeUpdate();
            if(x == 1) return true;
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
    
    public boolean Grownup_Rank(String id_customer)
    {
        DTO.customer customer = Info_Customer(id_customer);
        long x = customer.getAccumulation();
        int xl = 10;
        if(x <= 1000000 && x > 0)
            xl = 10;
        else
            if(x > 1000000 && x <= 5000000)
                xl = 20;
            else
                if(x>5000000 && x <= 10000000)
                    xl = 30;
                else
                    if(x>10000000 && x <= 20000000)
                        xl = 40;
                    else
                        if(x > 20000000 && x <= 50000000)
                            xl = 50;
                        else 
                            if(x > 50000000)
                                xl = 60;
        try
        {
            con.Get_Connect();
            PreparedStatement ps = con.con.prepareStatement("update customer set id_rank = ? where id=?");
            ps.setInt(1, xl);
            ps.setString(2, id_customer);
            int up = ps.executeUpdate();
            if(up == 1) return true;
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
    
    public int Check_Rank (String id_customer)
    {
        try
        {
            con.Get_Connect();
            PreparedStatement ps = con.con.prepareStatement("select * from customer where id = ?");
            ps.setString(1, id_customer);
            ResultSet rs = ps.executeQuery();
            rs.first();
            return rs.getInt("id_rank");
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
    
    
    // ----------------------------           END           ------------------------------------------

    @Override
    public String Check_Name_Rank(int id_rank) {
        try
        {
            con.Get_Connect();
            PreparedStatement ps = con.con.prepareStatement("select * from rank where id = ?");
            ps.setInt(1, id_rank);
            ResultSet rs = ps.executeQuery();
            rs.first();
            return rs.getString("name");
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
    
    public boolean Check_ID_Customer(String id_customer)
    {
        try
        {
            con.Get_Connect();
            PreparedStatement ps = con.con.prepareStatement("select * from customer where id = ?");
            ps.setString(1, id_customer);
            ResultSet rs = ps.executeQuery();
            if(rs.first() == false )
            return true;
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
}

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
public class dal_staff implements INTERFACE.staff {
    private ConnectMysql con = new ConnectMysql();
    
    private DTO.staff GetStaffFromResultSet(ResultSet rs) throws SQLException
    {
            DTO.staff staff = new DTO.staff();
            staff.setId(rs.getString("id"));
            staff.setFirst_name(rs.getString("first_name"));
            staff.setLast_name(rs.getString("last_name"));
            staff.setSex(rs.getString("sex"));
            staff.setBirthday(rs.getString("birthday"));
            staff.setAddress(rs.getString("address"));
            staff.setPhone(rs.getString("phone"));
            staff.setCredit_card(rs.getString("credit_card"));
            staff.setOnline(rs.getInt("online"));
            staff.setUsername(rs.getString("username"));
            staff.setPassword(rs.getString("password"));
            staff.setId_type(rs.getInt("id_type"));
            return staff;
    }
    
    
    public ArrayList<DTO.staff> List_Staff()
    {
        try
        {
            con.Get_Connect();
            String query = "SELECT * FROM `staff` order by id desc";
            Statement st = con.con.createStatement();
            ResultSet rs = st.executeQuery(query);
            int n = 0;
            rs.last();
            n = rs.getRow();
            rs.first();
            ArrayList<DTO.staff> list = new ArrayList<DTO.staff>();
            for(int i = 0 ;i < n; i++)
            {
                list.add(GetStaffFromResultSet(rs));
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
    
    
   
    
    public boolean Add(DTO.staff staff)
    {
        try
        {
            con.Get_Connect();
            String query ="INSERT INTO `staff`(`id`, `first_name`, `last_name`, `sex`, `birthday`, `address`, `phone`, `credit_card`, `online`, `username`, `password`, `id_type`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.con.prepareStatement(query);
            ps.setString(1,staff.getId());
            ps.setString(2,staff.getFirst_name());
            ps.setString(3,staff.getLast_name());
            ps.setString(4,staff.getSex());
            ps.setString(5,staff.getBirthday());
            ps.setString(6,staff.getAddress());
            ps.setString(7, staff.getPhone());
            ps.setString(8, staff.getCredit_card());
            ps.setInt(9,staff.getOnline());
            ps.setString(10,staff.getUsername());
            ps.setString(11,staff.getPassword());
            ps.setInt(12,staff.getId_type());
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
    
    
    public boolean Update(DTO.staff staff)
    {
        try
        {
            con.Get_Connect();
            String query ="UPDATE `staff` SET `first_name`=?,`last_name`=?,`sex`=?,`birthday`=?,`address`=?,`phone`=?,`credit_card`=?,`online`=?,`username`=?,`password`=?,`id_type`=? WHERE `id`=?";
            PreparedStatement ps = con.con.prepareStatement(query);
            ps.setString(12,staff.getId());
            ps.setString(1,staff.getFirst_name());
            ps.setString(2,staff.getLast_name());
            ps.setString(3,staff.getSex());
            ps.setString(4,staff.getBirthday());
            ps.setString(5,staff.getAddress());
            ps.setString(6, staff.getPhone());
            ps.setString(7, staff.getCredit_card());
            ps.setInt(8,staff.getOnline());
            ps.setString(9,staff.getUsername());
            ps.setString(10,staff.getPassword());
            ps.setInt(11,staff.getId_type());
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
    

    public boolean Del(DTO.staff staff)
    {
        try
        {
            con.Get_Connect();
            String query ="DELETE FROM `staff` WHERE `id` = ?";
            PreparedStatement ps = con.con.prepareStatement(query);
            ps.setString(1,staff.getId());         
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

    
    
    public ArrayList<DTO.staff> List_Search(int numParameter, String query, String keyword )
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
            ArrayList<DTO.staff> list_search = new ArrayList<DTO.staff>();
            for ( int i = 0 ; i < n; i++)
            {
                list_search.add(GetStaffFromResultSet(rs));
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

    
    public DTO.staff Info_Staff(String id)
    {
        try
        {
            con.Get_Connect();
            String query = "select * from staff where `id` = ?";
            PreparedStatement ps = con.con.prepareStatement(query);
            ps.setString(1,id);
            ResultSet rs = ps.executeQuery();
            rs.first();
            DTO.staff staff = GetStaffFromResultSet(rs);
            return staff;
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
    
    //----------------------------         Function use Frame other        ---------------------------
    
    public DTO.staff Info_Staff_By_User_Name(String username)
    {
        try
        {
            con.Get_Connect();
            String query = "select * from staff where `username` = ?";
            PreparedStatement ps = con.con.prepareStatement(query);
            ps.setString(1,username);
            ResultSet rs = ps.executeQuery();
            rs.first();
            DTO.staff staff = GetStaffFromResultSet(rs);
            return staff;
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
    
    public ArrayList<String> List_Staff_Type()
    {
        try
        {
            con.Get_Connect();
            String query = "select * from type_staff";
            Statement st = con.con.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            ArrayList<String> list_staff_type = new ArrayList<String>();
            while(rs.next())
            {
                list_staff_type.add(rs.getInt("id") + " | " + rs.getString("name"));
            }
            return list_staff_type;
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
    
    
    public String Get_ID_Staff(int type)
    {
        try
        {
            con.Get_Connect();
            PreparedStatement ps = con.con.prepareStatement("select * from staff where `id_type` = ? order by id desc");
            ps.setInt(1, type);
            ResultSet rs = ps.executeQuery();
            if(rs.first() != false)
            {
                rs.first();
                int x = Integer.parseInt(rs.getString("id").substring(2,6)) + 1;
                String result = String.valueOf(type) + String.format("%04d", x);
                return result;
            }
            else
            {
                System.out.println("null");
                return String.valueOf(type) + String.format("%04d", 1);
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
        return String.valueOf(type) + String.format("%04d", 1);
    }
    
    
    public boolean Check_User_Name(String user)
    {
        try
        {
            con.Get_Connect();
            PreparedStatement ps = con.con.prepareStatement("select * from staff where username = ?");
            ps.setString(1, user);
            ResultSet rs = ps.executeQuery();
            if(!rs.next()) return true;
            else return false;
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
    
    
    
    
    
    
    public boolean Update_Online(String username, int value)
    {// valuse = 1 online, valse = 0 offline
        try
        {
            con.Get_Connect();
            PreparedStatement ps = con.con.prepareStatement("update staff set online =? where username= ?");
            ps.setInt(1, value);
            ps.setString(2, username);
            int x = ps.executeUpdate();
            if(x == 1)return true;
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
    
    public String Get_Name_Type_Staff(int id_type_staff)
    {
        try
        {
            con.Get_Connect();
            PreparedStatement ps = con.con.prepareStatement("select * from type_staff where id = ?");
            ps.setInt(1, id_type_staff);
            ResultSet rs = ps.executeQuery();
            if(rs.first() == false) return null;
            else
            {
                rs.first();
                return rs.getString("name");
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
    
    //---------------------------------            End             ---------------------------------
}

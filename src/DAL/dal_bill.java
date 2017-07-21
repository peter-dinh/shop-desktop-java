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
public class dal_bill implements INTERFACE.bill {
    DAL.ConnectMysql con = new DAL.ConnectMysql();
    
    private DTO.bill GetBillFromResultSet(ResultSet rs) throws SQLException
    {
        DTO.bill bill = new DTO.bill();
        bill.setId(rs.getInt("id"));
        bill.setId_customer(rs.getString("id_customer"));
        bill.setId_staff(rs.getString("id_staff"));
        bill.setDatetime(rs.getString("datetime"));
        bill.setPayment(rs.getInt("payment"));
        bill.setSum_bill(rs.getLong("sum_bill"));
        bill.setSale(rs.getInt("sale"));
        bill.setShell_out(rs.getLong("shell_out"));
        bill.setNote(rs.getString("note"));
        return bill;
    }
    
    @Override
    public ArrayList <DTO.bill> List_Bill()
    {

        try
        {
            con.Get_Connect();
            String query = "select * from bill order by id desc"; 
            Statement cmd = con.con.createStatement();
            ResultSet rs = cmd.executeQuery(query);
            int n = 0;
            rs.last();
            n = rs.getRow();
            rs.first();
            ArrayList<DTO.bill> list_bill = new ArrayList<DTO.bill>();
            for( int i = 0; i < n; i++)
            {
                list_bill.add(GetBillFromResultSet(rs));
                rs.next();
            }
            return list_bill;
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
    
    @Override
    public DTO.bill Info_Bill(int id)
    {
        try
        {
            con.Get_Connect();
            DTO.bill bill = new DTO.bill();
            String query = "select * from bill where id = ?";
            PreparedStatement ps = con.con.prepareStatement(query);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            rs.first();
            bill = GetBillFromResultSet(rs);
            return bill;
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

    
    @Override
    public boolean Add(DTO.bill bill)
    {
        try
        {
            con.Get_Connect();
            PreparedStatement ps = con.con.prepareStatement("INSERT INTO `bill`(`id`, `id_customer`, `id_staff`, `datetime`, `payment`, `sum_bill`, `sale`,`shell_out`, `note`) VALUES (?,?,?,?,?,?,?,?,?)");
            ps.setInt(1, bill.getId());
            ps.setString(2, bill.getId_customer());
            ps.setString(3, bill.getId_staff());
            ps.setString(4, bill.getDatetime());
            ps.setInt(5, bill.getPayment());
            ps.setLong(6, bill.getSum_bill());
            ps.setInt(7, bill.getSale());
            ps.setLong(8, bill.getShell_out());
            ps.setString(9, bill.getNote());
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
    

    
    
    @Override
    public boolean Update(DTO.bill bill)
    {
        try
        {
            con.Get_Connect();
            PreparedStatement ps = con.con.prepareStatement("UPDATE `bill` SET `id_customer`=?,`datetime`=?,`payment`=?,`sum_bill`=?,`sale`=?, `note`=? ,shell_out = ? WHERE `id`=?");
            ps.setInt(8, bill.getId());
            ps.setString(1, bill.getId_customer());
            ps.setString(2, bill.getDatetime());
            ps.setInt(3, bill.getPayment());
            ps.setLong(4, bill.getSum_bill());
            ps.setLong(5, bill.getSale());
            ps.setString(6, bill.getNote());
            ps.setLong(7, bill.getShell_out());
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

    
    public boolean Update2(DTO.bill bill)
    {
        try
        {
            con.Get_Connect();
            PreparedStatement ps = con.con.prepareStatement("UPDATE `bill` SET `datetime`=?,`payment`=?,`sum_bill`=?,`sale`=?,`note`=?, shell_out = ?  WHERE `id`=?");
            ps.setInt(7, bill.getId());
            ps.setString(1, bill.getDatetime());
            ps.setInt(2, bill.getPayment());
            ps.setLong(3, bill.getSum_bill());
            ps.setLong(4, bill.getSale());
            ps.setString(5, bill.getNote());
            ps.setLong(6, bill.getShell_out());
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

    @Override
    public boolean Del (DTO.bill bill)
    {
        try
        {
            con.Get_Connect();
            PreparedStatement ps = con.con.prepareStatement("DELETE FROM `bill` WHERE  `id` = ?");
            ps.setInt(1, bill.getId());
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
    
    
    public ArrayList<DTO.bill> List_Search(int numParameter, String query, String keyword)
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
            ArrayList<DTO.bill> list_search = new ArrayList<DTO.bill>();
            for ( int i = 0 ; i < n; i++)
            {
                list_search.add(GetBillFromResultSet(rs));
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
    
    
    // ----------------------        Function other frame
    
    @Override
    public int Check_Sale(int rank)
    {
        try
        {
            con.Get_Connect();
            PreparedStatement ps = con.con.prepareStatement("select * from rank where id = ?");
            ps.setInt(1, rank);
            ResultSet rs = ps.executeQuery();
            rs.first();
            return rs.getInt("sale");
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
    
    @Override
    public boolean Check_User_Name(int id)
    {
        try
        {
            con.Get_Connect();
            PreparedStatement ps = con.con.prepareStatement("select * from bill where id =?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            rs.first();
            if(rs.getString("id_kh") == null)
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
    
    @Override
    public int Get_Max_ID_Bill()
    {
        try
        {
            con.Get_Connect();
            String sql = "select * from bill order by id desc";
            Statement st = con.con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if(rs.first() != false)
            {
                rs.first();
                return rs.getInt("id") + 1;
            }
            else
            {
                return 1;
            }
        }
        catch (SQLException ex)
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

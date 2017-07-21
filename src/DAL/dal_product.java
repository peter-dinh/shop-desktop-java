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
public class dal_product implements INTERFACE.product {
    DAL.ConnectMysql con = new DAL.ConnectMysql();
    
    private DTO.product GetProductFromResultSet(ResultSet rs)
    {
        try {
            DTO.product product = new DTO.product();
            product.setId(rs.getString("id"));
            product.setName(rs.getString("name"));
            product.setId_type(rs.getInt("id_type"));
            product.setPrice(rs.getLong("price"));
            product.setSale(rs.getInt("sale"));
            product.setUnit(rs.getString("unit"));
            product.setImage(rs.getString("image"));
            product.setId_producer(rs.getInt("id_producer"));
            product.setCount(rs.getInt("count"));
            return product;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public ArrayList <DTO.product> List_Product()
    {

        try
        {
            con.Get_Connect();
            String query = "select * from product order by id desc"; 
            Statement cmd = con.con.createStatement();
            ResultSet rs = cmd.executeQuery(query);
            int n = 0;
            rs.last();
            n = rs.getRow();
            rs.first();
            ArrayList<DTO.product> list_product = new ArrayList<DTO.product>();
            for( int i = 0; i < n; i++)
            {
                list_product.add(GetProductFromResultSet(rs));
                rs.next();
            }
            return list_product;
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
    
    public DTO.product Info_Product (String id)
    {
        try
        {
            con.Get_Connect();
            DTO.product product = new DTO.product();
            String query = "select * from product where id = ?";
            PreparedStatement ps = con.con.prepareStatement(query);
            ps.setString(1,id);
            ResultSet rs = ps.executeQuery();
            rs.first();
            product = GetProductFromResultSet(rs);
            return product;
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

    
    public boolean Add(DTO.product product)
    {
        try
        {
            con.Get_Connect();
            PreparedStatement ps = con.con.prepareStatement("INSERT INTO `product`(`id`, `name`, `id_type`, `price`, `sale`, `unit`, `image`, `id_producer`,`count`) VALUES (?,?,?,?,?,?,?,?,'0')");
            ps.setString(1, product.getId());
            ps.setString(2, product.getName());
            ps.setInt(3, product.getId_type());
            ps.setLong(4, product.getPrice());
            ps.setInt(5, product.getSale());
            ps.setString(6, product.getUnit());
            ps.setString(7, product.getImage());
            ps.setInt(8, product.getId_producer());
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
    

    public boolean Update(DTO.product product)
    {
        try
        {
            con.Get_Connect();
            PreparedStatement ps = con.con.prepareStatement("UPDATE `product` SET `name`=?, `id_type`=?, `price`=?, `sale`=?, `unit`=?, `image`=?,`id_producer`=? WHERE `id`= ?");
            ps.setString(8, product.getId());
            ps.setString(1, product.getName());
            ps.setInt(2, product.getId_type());
            ps.setLong(3, product.getPrice());
            ps.setInt(4, product.getSale());
            ps.setString(5, product.getUnit());
            ps.setString(6, product.getImage());
            ps.setInt(7, product.getId_producer());
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
    

    public boolean Del (DTO.product product)
    {
        try
        {
            con.Get_Connect();
            PreparedStatement ps = con.con.prepareStatement("DELETE FROM `product` WHERE  `id` = ?");
            ps.setString(1, product.getId());
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
    
    
    public ArrayList<DTO.product> List_Search(int numParameter, String query, String keyword)
    {
        try
        {
            con.Get_Connect();
            PreparedStatement ps = con.con.prepareStatement(query);
            for(int i = 1; i <= numParameter; i++)
               ps.setString(i,("%"+ keyword +"%"));
            System.out.println(ps.toString());
            ResultSet rs = ps.executeQuery();
            int n = 0;
            rs.last();
            n = rs.getRow();
            rs.first();
            ArrayList<DTO.product> list_search = new ArrayList<DTO.product>();
            for ( int i = 0 ; i < n; i++)
            {
                list_search.add(GetProductFromResultSet(rs));
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
    
    
    public String Count_Product(String type, String id_producer)
    {
        try
        {
            con.Get_Connect();
            PreparedStatement ps = con.con.prepareStatement("SELECT * FROM `product` WHERE  `id_producer` = '?' and `type` = '?'");
            ps.setString(1, id_producer);
            ps.setString(2, type);
            ResultSet rs = ps.executeQuery();
            int n = 0;
            rs.last();
            n = rs.getRow();
            String result = String.format("%1$06d", n);
            return result;
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            con.Close_Connect();
        }
        return String.format("%1$06d",1);
    }
    /*
    public String Name_Type_Product(int id_type)
    {
        try
        {
            con.Get_Connect();
            PreparedStatement ps = con.con.prepareStatement("SELECT * FROM `type_product` WHERE  `id` = '?'");
            ps.setInt(1, id_type);
            ResultSet rs = ps.executeQuery();
            rs.first();
            String x = rs.getString("name");
            return x;
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
    
    public String Name_Producer(int id_producer)
    {
        try
        {
            con.Get_Connect();
            PreparedStatement ps = con.con.prepareStatement("SELECT * FROM `producer` WHERE  `id` = '?'");
            ps.setInt(1, id_producer);
            ResultSet rs = ps.executeQuery();
            rs.first();
            String x = rs.getString("name");
            return x;
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
    */
    public int Get_Max_ID_Product(int id_type, int id_producer)
    {
        try
        {
            con.Get_Connect();
            PreparedStatement ps = con.con.prepareStatement("select * from product where id_type =? and id_producer=? order by id desc");
            ps.setInt(1, id_type);
            ps.setInt(2, id_producer);
            ResultSet rs = ps.executeQuery();
            if(rs.first() == false)
            {
                return 1;
            }
            else
            {
                
                rs.first();
                System.out.println(rs.getString("id").substring(4, 10));
                int id = Integer.parseInt(rs.getString("id").substring(4, 10));
                System.out.println(id);
                return id+1;
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
    
    
    
    // ----------------------------      FUNCTION USE JFRAME OUTHER       -----------------------------
    

// lay du lieu o dang "ID | Name" nap vao jcb_product in gia_info.java and handung_info.java
    public ArrayList<String> List_Name_Product()
    {
        try
        {
            con.Get_Connect();
            String query = "select * from `product`"; 
            Statement cmd = con.con.createStatement();
            ResultSet rs = cmd.executeQuery(query);
            int n = 0;
            rs.last();
            n = rs.getRow();
            rs.first();
            ArrayList<String> list_name_product = new ArrayList<String>();
            ArrayList<DTO.product> list_product = new ArrayList<DTO.product>();
            
            for( int i = 0; i < n; i++)
            {
                list_product.add(GetProductFromResultSet(rs));
                rs.next();
            }
            
            for(DTO.product product : list_product)
            {
                String str = product.getId()+" | "+product.getName();
                list_name_product.add(str);
            }
            return list_name_product;
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
    
    
     public ArrayList<String> List_Name_Product_By_Producer(int id_producer)
    {
        try
        {
            con.Get_Connect();
            String query = "select * from `product` where id_producer = ?"; 
            PreparedStatement ps = con.con.prepareStatement(query);
            ps.setInt(1, id_producer);
            ResultSet rs = ps.executeQuery();
            int n = 0;
            rs.last();
            n = rs.getRow();
            rs.first();
            ArrayList<String> list_name_product = new ArrayList<String>();
            ArrayList<DTO.product> list_product = new ArrayList<DTO.product>();
            
            for( int i = 0; i < n; i++)
            {
                list_product.add(GetProductFromResultSet(rs));
                rs.next();
            }
            
            for(DTO.product product : list_product)
            {
                String str = product.getId()+" | "+product.getName();
                list_name_product.add(str);
            }
            return list_name_product;
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
    
    
    // lay Nam bang ID in gia_info.java and handung_info.java
    
    public String Get_Name_Product_By_ID(String id_product)
    {
        try {
            con.Get_Connect();
            PreparedStatement ps = con.con.prepareStatement("select * from `product` where `id` =?");
            ps.setString(1, id_product);
            ResultSet rs = ps.executeQuery();
            rs.first();
            return rs.getString("name");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        finally
        {
            con.Close_Connect();
        }
        return null;
    }
    
    // lay info 1 product o dang "ID | Name" cho vao jcb_product trong chuc nang edit;
    
   
    public String Get_ID_Name_Product_By_ID(String id_product)
    {
        try {
            con.Get_Connect();
            PreparedStatement ps = con.con.prepareStatement("select * from `product` where `id` =?");
            ps.setString(1, id_product);
            ResultSet rs = ps.executeQuery();
            rs.first();
            return rs.getString("id")+" | "+rs.getString("ten");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        finally
        {
            con.Close_Connect();
        }
        return null;
    }
    
    
    public boolean Check_Product(String id)
    {
        try
        {
            con.Get_Connect();
            PreparedStatement ps = con.con.prepareStatement("select * from product where id =? ");
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            rs.last();
            if(rs.getRow() != 0) return true;
            
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
    
    public boolean Update_Count_Product(String id_product, int type, int count)
    {
        try
        {
            con.Get_Connect();
            PreparedStatement ps = con.con.prepareStatement("select * from product where id =? ");
            ps.setString(1, id_product);
            ResultSet rs = ps.executeQuery();
            rs.first();
            int count_cur = rs.getInt("count");
            if(type == 0 ) count_cur -= count;
            else count_cur += count;
            PreparedStatement ps2 = con.con.prepareStatement("UPDATE `product` SET `count`=? WHERE `id`= ?");
            ps2.setInt(1, count_cur);
            ps2.setString(2, id_product);
            int x = ps2.executeUpdate();
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
    
    public boolean Check_Count_Product(String id)
    {
        try
        {
            con.Get_Connect();
            PreparedStatement ps = con.con.prepareStatement("select * from product where id =? ");
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.first() == false) return false;
            else
            {
                if(rs.getInt("count") > 0 ) return true;
                else return false;
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
        return false;
    }
   
    //---------------------------------             END                 -------------------------------------
}

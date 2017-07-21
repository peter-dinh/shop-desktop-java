/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DTO.product;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author dinhtruong
 */
public class bll_product implements INTERFACE.product {
    DAL.dal_product dal =  new DAL.dal_product();

    @Override
    public ArrayList<product> List_Product() {
        return dal.List_Product();
    }

    @Override
    public product Info_Product(String id) {
        return dal.Info_Product(id);
    }

    @Override
    public boolean Add(product product) {
        try
        {
            JOptionPane.showMessageDialog(null, "Add Success");
            return dal.Add(product);
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean Update(product product) {
        try
        {
            JOptionPane.showMessageDialog(null, "Update Success");
            return dal.Update(product);
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean Del(product product) {
        try
        {
            JOptionPane.showMessageDialog(null, "Del Success");
            return dal.Del(product);
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return false;
    }
    
    
     public ArrayList<DTO.product> List_Search( int action , String keyword)
    {
        /*
        action == 0: tim theo ID
        action == 1: tim theo name
        action == 2: tim theo type
        action == 3: tim theo unit
        action == 4: tim theo name_producer
        
        */
        
        switch(action)
        {
            case 0:
            {
                String query = "select * from product where id like ?";
                return dal.List_Search(1, query, keyword);
            }
            case 1:
            {
                String query = " select * from product where name like ?";
                return dal.List_Search(1, query, keyword);
            }
            case 2:
            {
                String query = " select * from product where id_type like ? ";
                return dal.List_Search(1, query, keyword);
            }
            case 3:
            {
                String query = "select * from product where unit like ?";
                return dal.List_Search(1, query, keyword);
            }
            case 4:
            {
                String query = "select * from product, producer where product.id_producer = producer.id and producer.name_producer like ?";
                return dal.List_Search(1, query, keyword);
            }
                
        }
        return null;
    }

    @Override
    public String Count_Product(String type, String id_producer) {
        return dal.Count_Product(type, id_producer);
    }

    @Override
    public int Get_Max_ID_Product(int id_type, int id_producer) {
        return dal.Get_Max_ID_Product(id_type, id_producer);
    }

    @Override
    public ArrayList<String> List_Name_Product() {
        return dal.List_Name_Product();
    }
    
    public ArrayList<String> List_Name_Product_By_Producer(int id_producer)
    {
        return dal.List_Name_Product_By_Producer(id_producer);
    }

    @Override
    public String Get_Name_Product_By_ID(String id_product) {
        return dal.Get_Name_Product_By_ID(id_product);
    }

    @Override
    public String Get_ID_Name_Product_By_ID(String id_product) {
        return dal.Get_ID_Name_Product_By_ID(id_product);
    }

    @Override
    public boolean Check_Product(String id) {
        return dal.Check_Product(id);
    }

    @Override
    public boolean Update_Count_Product(String id_product, int type, int count) {
        return dal.Update_Count_Product(id_product, type, count);
    }
    
    public boolean Check_Count_Product(String id)
    {
        return dal.Check_Count_Product(id);
    }
    
}

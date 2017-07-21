/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DTO.customer;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author dinhtruong
 */
public class bll_customer implements INTERFACE.customer {
    DAL.dal_customer dal = new DAL.dal_customer();

    @Override
    public ArrayList<customer> List_Customer() {
        return dal.List_Customer();
    }

    @Override
    public customer Info_Customer(String id) {
        return dal.Info_Customer(id);
    }

    @Override
    public boolean Add(customer customer) {
        try
        {
            JOptionPane.showMessageDialog(null, "Add Success");
            return dal.Add(customer);
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean Update(customer customer) {
        try
        {
            JOptionPane.showMessageDialog(null, "Update Success");
            return dal.Update(customer);
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean Del(customer customer) {
        try
        {
            JOptionPane.showMessageDialog(null, "Del Success");
            return dal.Del(customer);
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return false;
    }

    
    /*
    
        action == 1 : Search ID;
        action == 2 : Search Name;
        action == 3 : Search Address;
        action == 4 : Search district;
        action == 5 : Search Phone;
        action == 6 : Search Rank;
        action == 7 : Search Date Register;
    
    */
    
    public ArrayList<DTO.customer> List_Search( int action, String keyword ) throws SQLException
    {
        switch(action)
        {
            case 1:
            {
                String query = "select * from customer where id like ?";
                return dal.List_Search(1, query, keyword);
            }
            case 2:
            {
                String query = " select * from customer where first_name like ? or last_name like ?";
                return dal.List_Search(2, query, keyword);
            }
            case 3:
            {
                String query = "select * from customer where address like ?";
                return dal.List_Search(1, query, keyword);
            }
            case 4:
            {
                String query = "select * from customer where id_district like ?";
                return dal.List_Search(1, query, keyword);
            }
            case 5:
            {
                String query ="select * from customer where phone like ?";
                return dal.List_Search(1, query, keyword);
            }
            case 6:
            {
                String query = "select * from customer where id_rank like ?";
                return dal.List_Search(1, query, keyword);
            }
            case 7:
            {
                String query = "select * from customer where date_register like ?";
                return dal.List_Search(1, query, keyword);
            }
        }
        return null;
    }
    

    @Override
    public boolean Update_Accumulation(String id_customer, long add) {
        return dal.Update_Accumulation(id_customer, add);
    }

    @Override
    public boolean Grownup_Rank(String id_customer) {
        return dal.Grownup_Rank(id_customer);
    }

    @Override
    public int Check_Rank(String id_customer) {
        return dal.Check_Rank(id_customer);
    }

    @Override
    public String Check_Name_Rank(int id_rank) {
        return dal.Check_Name_Rank(id_rank);
    }

    @Override
    public boolean Check_ID_Customer(String id_customer) {
        return dal.Check_ID_Customer(id_customer);
    }
    
    
}

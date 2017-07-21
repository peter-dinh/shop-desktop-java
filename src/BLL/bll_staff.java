/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DTO.staff;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author dinhtruong
 */
public class bll_staff implements INTERFACE.staff {
    DAL.dal_staff dal = new DAL.dal_staff();

    @Override
    public ArrayList<staff> List_Staff() {
        return dal.List_Staff();
    }

    @Override
    public boolean Add(staff staff) {
        try
        {
            JOptionPane.showMessageDialog(null, "Add Success");
            return dal.Add(staff);
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean Update(staff staff) {
        try
        {
            JOptionPane.showMessageDialog(null, "Update Success");
            return dal.Update(staff);
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean Del(staff staff) {
        try
        {
            JOptionPane.showMessageDialog(null, "Del Success");
            return dal.Del(staff);
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return false;
    }
    
    /*
    
        action == 1 : Search ID;
        action == 2 : Search UserName;
        action == 3 : Search Name;
        action == 4 : Search Sex;
        action == 5 : Search Date;
        action == 6 : Search Address;
        action == 7 : Search Phone;
        action == 8 : Search Credit Card;
        action == 9 : Search Online;
    
    */
    
    public ArrayList<DTO.staff> List_Search(int action, String keyword ) throws SQLException
    {
        switch(action)
        {
            case 1:
            {
                String query = "select * from staff where id like ?";
                return dal.List_Search(1, query, keyword);
            }
            case 2:
            {
                String query = " select * from staff where username like ?";
                return dal.List_Search(1, query, keyword);
            }
            case 3:
            {
                String query = "select * from staff where id_type like ?";
                return dal.List_Search(1, query, keyword);
            }
            case 4:
            {
                String query ="select * from staff where sex like ?";
                return dal.List_Search(1, query, keyword);
            }
            case 5:
            {
                String query = "select * from staff where birthday like ?";
                return dal.List_Search(1, query, keyword);
            }
            case 6:
            {
                String query = "select * from staff where address like ?";
                return dal.List_Search(1, query, keyword);
            }
            case 7:
            {
                String query = "select * from staff where phone like ?";
                return dal.List_Search(1, query, keyword);
            }
            case 8:
            {
                String query = "select * from staff where credit_card like ?";
                return dal.List_Search(1, query, keyword);
            }
            case 9:
            {
                String query = "select * from staff where online like ?";
                return dal.List_Search(1, query, keyword);
            }
        }
        return null;
    }
    

    @Override
    public staff Info_Staff(String id) {
        return dal.Info_Staff(id);
    }

    @Override
    public staff Info_Staff_By_User_Name(String username) {
        return dal.Info_Staff_By_User_Name(username);
    }

    @Override
    public ArrayList<String> List_Staff_Type() {
        return dal.List_Staff_Type();
    }

    @Override
    public String Get_ID_Staff(int type) {
        return dal.Get_ID_Staff(type);
    }

    @Override
    public boolean Check_User_Name(String user) {
        return dal.Check_User_Name(user);
    }

    @Override
    public boolean Update_Online(String username, int value) {
        return dal.Update_Online(username, value);
    }
    
    public String Get_Name_Type_Staff(int id_type_staff)
    {
        return  dal.Get_Name_Type_Staff(id_type_staff);
    }
}

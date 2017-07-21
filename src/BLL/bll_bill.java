/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DTO.bill;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author dinhtruong
 */
public class bll_bill implements INTERFACE.bill {
    DAL.dal_bill dal = new DAL.dal_bill();
    @Override
    public ArrayList<bill> List_Bill() {
        return dal.List_Bill();
    }

    @Override
    public bill Info_Bill(int id) {
        return dal.Info_Bill(id);
    }

    @Override
    public boolean Add(bill bill) {
        try
        {
            JOptionPane.showMessageDialog(null, "Add Success");
            return dal.Add(bill);
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean Update(bill bill) {
        try
        {
            JOptionPane.showMessageDialog(null, "Update Success");
            return dal.Update(bill);
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean Del(bill bill) {
        try
        {
            JOptionPane.showMessageDialog(null, "Delete Success");
            return dal.Del(bill);
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return false;
    }
    
    /*
        action == 1: Search ID Bill
        action == 2: Search Name Customer
        action == 3: Search Name Staff
        action == 4: Search Date
        action == 5: Search Pay
    */
    
    public ArrayList<DTO.bill> List_Search(int action, String keyword)
    {
        switch(action)
        {
            case 1:
            {
                String query = "select * from bill where id like ?";
                return dal.List_Search(1, query, keyword);
            }
            case 2:
            {
                String query = " SELECT * from customer, bill WHERE customer.id = bill.id_customer and (customer.first_name LIKE ? or customer.last_name LIKE ?)";
                return dal.List_Search(2, query, keyword);
            }
            case 3:
            {
                String query = "SELECT * from staff, bill WHERE staff.id = bill.id_staff and (staff.first_name LIKE ? or staff.last_name LIKE ?)";
                return dal.List_Search(2, query, keyword);
            }
            case 4:
            {
                String query ="select * from bill where datetime like ?";
                return dal.List_Search(1, query, keyword);
            }
            case 5:
            {
                String query = "select * from bill where payment like ?";
                return dal.List_Search(1, query, keyword);
            }
        }
        return null;
    }
    

    @Override
    public int Check_Sale(int rank) {
        return dal.Check_Sale(rank);
    }

    @Override
    public boolean Check_User_Name(int id) {
        return dal.Check_User_Name(id);
    }

    @Override
    public int Get_Max_ID_Bill() {
        return  dal.Get_Max_ID_Bill();
    }
    
    
    public boolean Update2(DTO.bill bill)
    {
        try
        {
            JOptionPane.showMessageDialog(null, "Update Success");
            return dal.Update2(bill);
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return false;
    }
}

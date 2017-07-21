/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DTO.bill_info;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author dinhtruong
 */
public class bll_bill_info implements INTERFACE.bill_info {
    DAL.dal_bill_info dal = new DAL.dal_bill_info();

    @Override
    public ArrayList<bill_info> List_Bill_Info(int id_bill) {
        return dal.List_Bill_Info(id_bill);
    }

    @Override
    public bill_info Info_Bill_Info(int id_bill, String id_product) {
        return dal.Info_Bill_Info(id_bill, id_product);
    }

    @Override
    public boolean Add(bill_info bill_info, int id_bill) {
        try
        {
            JOptionPane.showMessageDialog(null, "Add Success");
            return dal.Add(bill_info, id_bill);
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean Update(bill_info bill_info, int id_bill) {
        try
        {
            JOptionPane.showMessageDialog(null, "Update Success");
            return dal.Update(bill_info, id_bill);
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean Del(bill_info bill_info, int id_bill) {
        try
        {
            JOptionPane.showMessageDialog(null, "Delete Success");
            return dal.Del(bill_info, id_bill);
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public int Count_Bill_Info(int id_bill) {
        return dal.Count_Bill_Info(id_bill);
    }
    
    public boolean  Check_Bill_Info(int id_bill, String id_product)
    {
        return dal.Check_Bill_Info(id_bill, id_product);
    }

    @Override
    public boolean Del_All_Bill_Product(int id_bill) {
        return dal.Del_All_Bill_Product(id_bill);
    }

    @Override
    public long Sum_Bill(int id_bill) {
        return dal.Sum_Bill(id_bill);
    }
}

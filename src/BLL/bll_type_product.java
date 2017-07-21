/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DTO.type_product;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author dinhtruong
 */
public class bll_type_product implements INTERFACE.type_product {
    DAL.dal_type_product dal = new DAL.dal_type_product();

    @Override
    public ArrayList<type_product> List_Type_Product() {
        return dal.List_Type_Product();
    }

    @Override
    public boolean Add(type_product type_product) {
        try
        {
            JOptionPane.showMessageDialog(null, "Add Success");
            return dal.Add(type_product);
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean Update(type_product type_product) {
        try
        {
            JOptionPane.showMessageDialog(null, "Update Success");
            return dal.Update(type_product);
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean Del(type_product type_product) {
        try
        {
            JOptionPane.showMessageDialog(null, "Del Success");
            return dal.Del(type_product);
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public type_product Info_Type_Product(int id) {
        return dal.Info_Type_Product(id);
    }

    @Override
    public int Get_Max_ID_Type_Product() {
        return dal.Get_Max_ID_Type_Product();
    }
    
    
    
}

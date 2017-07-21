/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DTO.district;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author dinhtruong
 */
public class bll_district implements INTERFACE.district {
    DAL.dal_district dal = new DAL.dal_district();

    @Override
    public ArrayList<district> List_District() {
        return dal.List_District();
    }

    @Override
    public district Info_District(int id) {
        return dal.Info_District(id);
    }

    @Override
    public boolean Add(district district) {
        try
        {
            JOptionPane.showMessageDialog(null, "Add Success");
            return dal.Add(district);
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean Update(district district) {
        try
        {
            JOptionPane.showMessageDialog(null, "Update Success");
            return dal.Update(district);
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean Del(district district) {
        try
        {
            JOptionPane.showMessageDialog(null, "Del Success");
            return dal.Del(district);
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public int Get_Max_ID_District() {
        return dal.Get_Max_ID_District();
    }
}

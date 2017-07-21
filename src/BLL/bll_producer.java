/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DTO.producer;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author dinhtruong
 */
public class bll_producer implements INTERFACE.producer {
    DAL.dal_producer dal = new  DAL.dal_producer();

    @Override
    public ArrayList<producer> List_Producer() {
        return dal.List_Producer();
    }

    @Override
    public producer Info_Producer(int id) {
        return dal.Info_Producer(id);
    }

    @Override
    public boolean Add(producer producer) {
        try
        {
            JOptionPane.showMessageDialog(null, "Add Success");
            return dal.Add(producer);
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean Update(producer producer) {
        try
        {
            JOptionPane.showMessageDialog(null, "Update Success");
            return dal.Update(producer);
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean Del(producer producer) {
        try
        {
            JOptionPane.showMessageDialog(null, "Del Success");
            return dal.Del(producer);
        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, "Check data input again");
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public int Get_Max_ID_Producer() {
        return dal.Get_Max_ID_Producer();
    }

    @Override
    public ArrayList<String> List_Name_Producer() {
        return dal.List_Name_Producer();
    }
    
    public ArrayList<String> List_Name_Producer_By_ID(int id_producer)
    {
        return dal.List_Name_Producer_By_ID(id_producer);
    }
}

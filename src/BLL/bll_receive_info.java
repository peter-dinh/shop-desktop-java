/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DTO.receive_info;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author dinhtruong
 */
public class bll_receive_info implements INTERFACE.receive_info {
    DAL.dal_receive_info dal = new DAL.dal_receive_info();

    @Override
    public ArrayList<receive_info> List_Receive_Info(int id_receive) {
        return dal.List_Receive_Info(id_receive);
    }

    @Override
    public receive_info Info_Receive_Info(int id_receive, String id_product) {
        return dal.Info_Receive_Info(id_receive, id_product);
    }

    @Override
    public boolean Add(receive_info receive_info) {
        try
        {
            JOptionPane.showMessageDialog(null, "Add Success");
            return dal.Add(receive_info);
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean Update(receive_info receive_info) {
        try
        {
            JOptionPane.showMessageDialog(null, "Update Success");
            return dal.Update(receive_info);
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean Del(receive_info receive_info) {
        try
        {
            JOptionPane.showMessageDialog(null, "Del Success");
            return dal.Del(receive_info);
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean Del_All_Receive_Info(int id_receive) {
        return dal.Del_All_Receive_Info(id_receive);
    }

    @Override
    public long Sum_Receive(int id_receive) {
        
        return dal.Sum_Receive(id_receive);
    }

    @Override
    public boolean Check_Receive_Info(int id_receive, String id_product) {
        return dal.Check_Receive_Info(id_receive, id_product);
    }
}

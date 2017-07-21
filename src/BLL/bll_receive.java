/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DTO.receive;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author dinhtruong
 */
public class bll_receive implements INTERFACE.receive {
    DAL.dal_receive dal = new DAL.dal_receive();

    @Override
    public ArrayList<receive> List_Receive() {
        return dal.List_Receive();
    }

    @Override
    public receive Info_Receive(int id) {
        return dal.Info_Receive(id);
    }

    @Override
    public boolean Add(receive receive) {
        try
        {
            JOptionPane.showMessageDialog(null, "Add Success");
            return dal.Add(receive);
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean Update(receive receive) {
        try
        {
            JOptionPane.showMessageDialog(null, "Update Success");
            return dal.Update(receive);
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean Del(receive receive) {
        try
        {
            JOptionPane.showMessageDialog(null, "Del Success");
            return dal.Del(receive);
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return false;
    }

    
     /*
        action == 1: Search ID Receive
        action == 2: Search Name Producer
        action == 3: Search Name Staff
        action == 4: Search Date
    */
    
    public ArrayList<DTO.receive> List_Search(int action, String keyword)
    {
        switch(action)
        {
            case 1:
            {
                String query = "select * from receive where id like ?";
                return dal.List_Search(1, query, keyword);
            }
            case 2:
            {
                String query = " SELECT * from producer, receive WHERE producer.id = receive.id_producer and producer.name_producer LIKE ? ";
                return dal.List_Search(1, query, keyword);
            }
            case 3:
            {
                String query = "SELECT * from receive, staff WHERE staff.id = receive.id_staff and (staff.first_name LIKE ? or staff.last_name LIKE ?)";
                return dal.List_Search(2, query, keyword);
            }
            case 4:
            {
                String query ="select * from receive where date_time like ?";
                return dal.List_Search(1, query, keyword);
            }
        }
        return null;
    }
    
    
    @Override
    public int Get_Max_ID_Receive() {
        return dal.Get_Max_ID_Receive();
    }
    
    
}

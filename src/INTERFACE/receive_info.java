/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package INTERFACE;

import java.util.ArrayList;

/**
 *
 * @author dinhtruong
 */
public interface receive_info {
    public ArrayList <DTO.receive_info> List_Receive_Info(int id_receive);
    
    public DTO.receive_info Info_Receive_Info (int id_receive, String id_product);
    
    public boolean Add(DTO.receive_info receive_info);
    
    public boolean Update(DTO.receive_info receive_info);
    
    public boolean Del (DTO.receive_info receive_info);
    
    public boolean Del_All_Receive_Info(int id_receive);
    
     public long Sum_Receive(int id_receive);
     
     public boolean  Check_Receive_Info(int id_receive, String id_product);
}

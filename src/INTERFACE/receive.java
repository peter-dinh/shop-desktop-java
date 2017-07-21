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
public interface receive {
    public ArrayList <DTO.receive> List_Receive();
    
    public DTO.receive Info_Receive (int id) ;
    
    public boolean Add(DTO.receive receive);
    
    public boolean Update(DTO.receive receive);
    
    public boolean Del (DTO.receive receive);
    
    public int Get_Max_ID_Receive();
}

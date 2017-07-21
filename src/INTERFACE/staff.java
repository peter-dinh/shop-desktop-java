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
public interface staff {
    public ArrayList<DTO.staff> List_Staff();
    
    public boolean Add(DTO.staff staff);
    
    public boolean Update(DTO.staff staff);
    
    public boolean Del(DTO.staff staff);
    
    public DTO.staff Info_Staff(String id);
    
    public DTO.staff Info_Staff_By_User_Name(String username);
    
    public ArrayList<String> List_Staff_Type();
    
    public String Get_ID_Staff(int type);
    
    public boolean Check_User_Name(String user);
    
    public boolean Update_Online(String username, int value);
    
    public String Get_Name_Type_Staff(int id_type_staff);
    
}

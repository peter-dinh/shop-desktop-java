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
public interface customer {
    public ArrayList <DTO.customer> List_Customer();
    
    public DTO.customer Info_Customer (String id);
    
    public boolean Add(DTO.customer customer);
    
    public boolean Update(DTO.customer customer);
    
    public boolean Del (DTO.customer customer);
    
    
    public boolean Update_Accumulation(String id_customer, long add);
    
    public boolean Grownup_Rank(String id_customer);
    
    public int Check_Rank (String id_customer);
    
    public String Check_Name_Rank (int id_rank);
    
    public boolean Check_ID_Customer(String id_customer);
}

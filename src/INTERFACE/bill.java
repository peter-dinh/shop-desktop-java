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
public interface bill {
    
    public ArrayList <DTO.bill> List_Bill();
    
    public DTO.bill Info_Bill(int id);
    
    public boolean Add(DTO.bill bill);
    
    public boolean Update(DTO.bill bill);
    
    public boolean Del (DTO.bill bill);
    
    public int Check_Sale(int rank);
    
    public boolean Check_User_Name(int id);
    
    public int Get_Max_ID_Bill();
    
    public boolean Update2(DTO.bill bill);
    
}

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
public interface producer {
    public ArrayList <DTO.producer> List_Producer() ;
    
    public DTO.producer Info_Producer (int id);
    
    public boolean Add(DTO.producer producer);
    
    public boolean Update(DTO.producer producer);
    
    public boolean Del (DTO.producer producer);
    
    public int Get_Max_ID_Producer();
    
    public ArrayList<String> List_Name_Producer();
    
    public ArrayList<String> List_Name_Producer_By_ID(int id_producer);
}

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
public interface district {
    public ArrayList <DTO.district> List_District();
    
    public DTO.district Info_District (int id);
    
    public boolean Add(DTO.district district);
    
    public boolean Update(DTO.district district);
    
    public boolean Del (DTO.district district);
    
    public int Get_Max_ID_District();
}

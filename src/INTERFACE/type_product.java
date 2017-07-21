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
public interface type_product {
    public ArrayList<DTO.type_product> List_Type_Product();
    
    public boolean Add(DTO.type_product type_product);
    
    public boolean Update(DTO.type_product type_product);
    
    public boolean Del(DTO.type_product type_product);
    
    public DTO.type_product Info_Type_Product(int id);
    
    public int Get_Max_ID_Type_Product();
}

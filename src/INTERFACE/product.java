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
public interface product {
    public ArrayList <DTO.product> List_Product();
    
    public DTO.product Info_Product (String id);
    
    public boolean Add(DTO.product product);
    
    public boolean Update(DTO.product product);
    
    public boolean Del (DTO.product product);
    
    public String Count_Product(String type, String id_producer);
    
    public int Get_Max_ID_Product(int id_type, int id_producer);
    
    public ArrayList<String> List_Name_Product();
    
    public String Get_Name_Product_By_ID(String id_product);
    
    public String Get_ID_Name_Product_By_ID(String id_product);
    
    public boolean Check_Product(String id);
    
    public boolean Update_Count_Product(String id_product, int type, int count);
    
    public ArrayList<String> List_Name_Product_By_Producer(int id_producer);
    
    public boolean Check_Count_Product(String id);
}

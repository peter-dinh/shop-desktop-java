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
public interface bill_info {
    
    public ArrayList <DTO.bill_info> List_Bill_Info(int id_bill);
    
    public DTO.bill_info Info_Bill_Info (int id_bill, String id_product);
    
    public boolean Add(DTO.bill_info bill_info, int id_bill);
    
    public boolean Update(DTO.bill_info bill_info, int id_bill);
    
    public boolean Del (DTO.bill_info bill_info, int id_bill);
    
    public int Count_Bill_Info(int id_bill);
    
    public boolean Del_All_Bill_Product(int id_bill);
    
    public long Sum_Bill(int id_bill);
}

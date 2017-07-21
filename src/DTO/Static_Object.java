/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.ArrayList;

/**
 *
 * @author dinhtruong
 */
public class Static_Object {
    //cur : current 
    public static  DTO.product product_cur;
    public static  DTO.producer producer_cur;
    public static  DTO.bill bill_cur;
    public static  DTO.bill_info bill_info_cur;
    public static  DTO.customer customer_cur;
    public static  DTO.district district_cur;
    public static  DTO.date_product date_product_cur;
    public static  DTO.staff staff_cur;
    public static  DTO.type_product type_product_cur;
    public static ArrayList<DTO.bill_info> list_bill_info;
    
    
    //-- User use session work -------------
    
    public static String username;
}

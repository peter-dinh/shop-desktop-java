/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author dinhtruong
 */
public class bll_analytic {
    
    DAL.dal_analytic dal = new DAL.dal_analytic();
    
    public ResultSet Analytic_Type_Product()
    {
        return dal.Analytic_Type_Product();
    }
    
    public ResultSet Analytic_Count_Bill_Of_Product()
    {
        return dal.Analytic_Count_Bill_Of_Product();
    }
    
    public ResultSet Analytic_Check_Count_Product_1()
    {
        return dal.Analytic_Check_Count_Product_1();
    }
    
    public ResultSet Analytic_Check_Count_Product_2()
    {
        return dal.Analytic_Check_Count_Product_2();
    }
    
    public ResultSet Analytic_Check_Sales_Product()
    {
        return dal.Analytic_Check_Sales_Product();
    }
    
    public ResultSet Analytic_Producer_Of_Product()
    {
        return dal.Analytic_Producer_Of_Product();
    }
    
    
    public ResultSet Analytic_Customer()
    {
        return dal.Analytic_Customer();
    }
    
    public ResultSet Analytic_Customer_Local()
    {
        return dal.Analytic_Customer_Local();
    }
    
    public ResultSet Analytic_Customer_Rank()
    {
        return dal.Analytic_Customer_Rank();
    }
    
    
    public ResultSet Analytic_Staff()
    {
        return dal.Analytic_Staff();
    }
    
    public ResultSet Analytic_Staff_Role()
    {
        return dal.Analytic_Staff_Role();
    }
    
    public ResultSet Analytic_Staff_Salary()
    {
        return dal.Analytic_Staff_Salary();
    }
    
    public ResultSet Analytic_Bill()
    {
        return dal.Analytic_Bill();
    }
    
    public ResultSet Analytic_Bill_Customer()
    {
        return dal.Analytic_Bill_Customer();
    }
    
    public ResultSet Analytic_Bill_Staff()
    {
        return dal.Analytic_Bill_Staff();
    }
    public ResultSet Analytic_Bill_Product()
    {
        return dal.Analytic_Bill_Product();
    }
    public ResultSet Analytic_Bill_Sales()
    {
        return dal.Analytic_Bill_Sales();
    }
    
    
    public ResultSet Analytic_Receive()
    {
        return dal.Analytic_Receive();
    }
    public ResultSet Analytic_Receive_Producer()
    {
        return dal.Analytic_Receive_Producer();
    }
    public ResultSet Analytic_Receive_Staff()
    {
        return dal.Analytic_Receive_Staff();
    }
    public ResultSet Analytic_Receive_Product()
    {
        return dal.Analytic_Receive_Product();
    }
    public ResultSet Analytic_Receive_Capital()
    {
        return dal.Analytic_Receive_Capital();
    }
    
    
    
    
    
    public long[] Analytic_dashboard()
    {
        return dal.Analytic_dashboard();
    }
}

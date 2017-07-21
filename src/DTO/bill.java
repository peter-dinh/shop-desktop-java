/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.sql.Date;

/**
 *
 * @author Dinh Truong
 */
public class bill {
   private int id;
   private String id_customer;
   private String id_staff;
   private String datetime;
   private int payment;
   private long sum_bill;
   private int sale;
   private long shell_out;
   private String note;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the id_customer
     */
    public String getId_customer() {
        return id_customer;
    }

    /**
     * @param id_customer the id_customer to set
     */
    public void setId_customer(String id_customer) {
        this.id_customer = id_customer;
    }

    /**
     * @return the id_staff
     */
    public String getId_staff() {
        return id_staff;
    }

    /**
     * @param id_staff the id_staff to set
     */
    public void setId_staff(String id_staff) {
        this.id_staff = id_staff;
    }

    

    /**
     * @return the payment
     */
    public int getPayment() {
        return payment;
    }

    /**
     * @param payment the payment to set
     */
    public void setPayment(int payment) {
        this.payment = payment;
    }

    /**
     * @return the sum_bill
     */
    public long getSum_bill() {
        return sum_bill;
    }

    /**
     * @param sum_bill the sum_bill to set
     */
    public void setSum_bill(long sum_bill) {
        this.sum_bill = sum_bill;
    }

    /**
     * @return the sale
     */
    public int getSale() {
        return sale;
    }

    /**
     * @param sale the sale to set
     */
    public void setSale(int sale) {
        this.sale = sale;
    }

    /**
     * @return the note
     */
    public String getNote() {
        return note;
    }

    /**
     * @param note the note to set
     */
    public void setNote(String note) {
        this.note = note;
    }

    /**
     * @return the datetime
     */
    public String getDatetime() {
        return datetime;
    }

    /**
     * @param datetime the datetime to set
     */
    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    /**
     * @return the shell_out
     */
    public long getShell_out() {
        return shell_out;
    }

    /**
     * @param shell_out the shell_out to set
     */
    public void setShell_out(long shell_out) {
        this.shell_out = shell_out;
    }
   

   

    
}

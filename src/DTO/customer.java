/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Dinh Truong
 */
public class customer {
    private String id_customer;
    private String first_name;
    private String last_name;
    private String address;
    private int id_district;
    private String phone;
    private long accumulation;
    private int id_rank;
    private String date_regiter;

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
     * @return the frist_name
     */
    public String getFirst_name() {
        return first_name;
    }

    /**
     * @param first_name the frist_name to set
     */
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    /**
     * @return the last_name
     */
    public String getLast_name() {
        return last_name;
    }

    /**
     * @param last_name the last_name to set
     */
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the id_district
     */
    public int getId_district() {
        return id_district;
    }

    /**
     * @param id_district the id_district to set
     */
    public void setId_district(int id_district) {
        this.id_district = id_district;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the accumulation
     */
    public long getAccumulation() {
        return accumulation;
    }

    /**
     * @param accumulation the accumulation to set
     */
    public void setAccumulation(long accumulation) {
        this.accumulation = accumulation;
    }

    /**
     * @return the id_rank
     */
    public int getId_rank() {
        return id_rank;
    }

    /**
     * @param id_rank the id_rank to set
     */
    public void setId_rank(int id_rank) {
        this.id_rank = id_rank;
    }

    /**
     * @return the date_regiter
     */
    public String getDate_regiter() {
        return date_regiter;
    }

    /**
     * @param date_regiter the date_regiter to set
     */
    public void setDate_regiter(String date_regiter) {
        this.date_regiter = date_regiter;
    }

  
    
}

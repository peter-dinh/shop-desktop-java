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
public class date_product {
    private int id;
    private String id_product;
    private int count;
    private String manufacture;
    private String expiry;

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
     * @return the id_product
     */
    public String getId_product() {
        return id_product;
    }

    /**
     * @param id_product the id_product to set
     */
    public void setId_product(String id_product) {
        this.id_product = id_product;
    }

    /**
     * @return the count
     */
    public int getCount() {
        return count;
    }

    /**
     * @param count the count to set
     */
    public void setCount(int count) {
        this.count = count;
    }

    /**
     * @return the manufacture
     */
    public String getManufacture() {
        return manufacture;
    }

    /**
     * @param manufacture the manufacture to set
     */
    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    /**
     * @return the expiry
     */
    public String getExpiry() {
        return expiry;
    }

    /**
     * @param expiry the expiry to set
     */
    public void setExpiry(String expiry) {
        this.expiry = expiry;
    }

    
}

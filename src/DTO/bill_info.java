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
public class bill_info {
    private int id_bill;
    private String id_product;
    private int count;
    private long price;
    private int sale;
    private long sum;

    /**
     * @return the id_bill
     */
    public int getId_bill() {
        return id_bill;
    }

    /**
     * @param id_bill the id_bill to set
     */
    public void setId_bill(int id_bill) {
        this.id_bill = id_bill;
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
     * @return the price
     */
    public long getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(long price) {
        this.price = price;
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
     * @return the sum
     */
    public long getSum() {
        return sum;
    }

    /**
     * @param sum the sum to set
     */
    public void setSum(long sum) {
        this.sum = sum;
    }

    
    
}

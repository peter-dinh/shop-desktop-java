/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author dinhtruong
 */
public class receive_info {
    private int id_receive;
    private String id_product;
    private int count;
    private long cost; //price root
    private long sum;

    /**
     * @return the id_receive
     */
    public int getId_receive() {
        return id_receive;
    }

    /**
     * @param id_receive the id_receive to set
     */
    public void setId_receive(int id_receive) {
        this.id_receive = id_receive;
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
     * @return the cost
     */
    public long getCost() {
        return cost;
    }

    /**
     * @param cost the cost to set
     */
    public void setCost(long cost) {
        this.cost = cost;
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

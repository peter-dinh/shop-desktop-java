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
public class receive {
    private int id;
    private int id_producer;
    private String id_staff;
    private String date_time;
    private Long sum_receive;

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
     * @return the id_producer
     */
    public int getId_producer() {
        return id_producer;
    }

    /**
     * @param id_producer the id_producer to set
     */
    public void setId_producer(int id_producer) {
        this.id_producer = id_producer;
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
     * @return the date_time
     */
    public String getDate_time() {
        return date_time;
    }

    /**
     * @param date_time the date_time to set
     */
    public void setDate_time(String date_time) {
        this.date_time = date_time;
    }

    /**
     * @return the sum_receive
     */
    public Long getSum_receive() {
        return sum_receive;
    }

    /**
     * @param sum_receive the sum_receive to set
     */
    public void setSum_receive(Long sum_receive) {
        this.sum_receive = sum_receive;
    }

    
   
    
}

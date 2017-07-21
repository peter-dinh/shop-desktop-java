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
public class product {

    
    private String id;
    private String name;
    private int id_type;
    private long price;
    private int sale;
    private String unit;
    private String image;
    private int id_producer;
    private int count;

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the id_type
     */
    public int getId_type() {
        return id_type;
    }

    /**
     * @param id_type the id_type to set
     */
    public void setId_type(int id_type) {
        this.id_type = id_type;
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
     * @return the unit
     */
    public String getUnit() {
        return unit;
    }

    /**
     * @param unit the unit to set
     */
    public void setUnit(String unit) {
        this.unit = unit;
    }

    /**
     * @return the image
     */
    public String getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(String image) {
        this.image = image;
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
    


}

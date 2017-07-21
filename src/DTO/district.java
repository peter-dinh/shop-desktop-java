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
public class district {
    private int id;
    private String name_district;
    private String name_city;

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
     * @return the name_district
     */
    public String getName_district() {
        return name_district;
    }

    /**
     * @param name_district the name_district to set
     */
    public void setName_district(String name_district) {
        this.name_district = name_district;
    }

    /**
     * @return the name_city
     */
    public String getName_city() {
        return name_city;
    }

    /**
     * @param name_city the name_city to set
     */
    public void setName_city(String name_city) {
        this.name_city = name_city;
    }

   
}

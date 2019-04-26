/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restowa.domain.model;

import javax.persistence.*;

/**
 *
 * @author Amane
 */

@Embeddable
public class Address {
       
    @Column(name = "street")
    private String Street;
    
    @Column(name = "city")
    private String City;
    
    @Column(name = "stateuser")
    private String State;
    
    @Column(name = "zipcode")
    private int ZipCode;
    
    @Column(name = "country")
    private String Country;
    

    public String getStreet() {
        return Street;
    }

    public void setStreet(String Street) {
        this.Street = Street;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public String getState() {
        return State;
    }

    public void setState(String State) {
        this.State = State;
    }

    public int getZipCode() {
        return ZipCode;
    }

    public void setZipCode(int ZipCode) {
        this.ZipCode = ZipCode;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String Country) {
        this.Country = Country;
    }
}

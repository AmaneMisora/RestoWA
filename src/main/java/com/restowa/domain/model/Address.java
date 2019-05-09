/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restowa.domain.model;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

/**
 *
 * @author Amane
 */
@Embeddable
public class Address {
    
    @NotEmpty
    @Column(name = "street")
    private String street;
    
    @NotEmpty
    @Column(name = "city")
    private String city;
    
    @NotEmpty
    @Column(name = "state")
    private String state;
    
    @Min(value=0, message="Les codes postaux négatifs ne sont pas autorisés")
    @Digits(fraction = 0, integer = 10, message ="Un code postal doit être un entier numérique")
    @Column(name = "zipcode")
    private int zipCode;
    
    @NotEmpty
    @Column(name = "country")
    private String country;
    
    public Address() {
        
    }
    
    public Address(String Street,String City,String State,int ZipCode,String Country) {
        this.street = Street;
        this.city = City;
        this.state = State;
        this.zipCode = ZipCode;
        this.country = Country;
    }
    
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}

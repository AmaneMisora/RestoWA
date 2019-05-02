/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restowa.domain.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

/**
 *
 * @author Amane
 */
@Entity
public class Store implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotEmpty
    @Column(name = "key")
    private String key;

    @Embedded
    private OpeningHours openingHours;
    
    @NotEmpty
    @Column(name = "name")
    private String name;
    
    @NotEmpty
    @Column(name = "phonenumber")
    private String phoneNumber;
    
    @NotEmpty
    @Email
    @Column(name = "email")
    private String email;
    
    @NotEmpty
    @Column(name = "lattitude")
    private double lattitude;
    
    @NotEmpty
    @Column(name = "logitude")
    private double logitude;
    
    @NotEmpty
    @Temporal(TemporalType.DATE)
    @Column(name = "lastmodificationdate")
    private LocalDateTime lastModificationDate;
    
    @ManyToOne
    @Column(name = "lastmodifiedby")
    public int lastModifiedBy;
    
    @Embedded
    private Address address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public OpeningHours getOpeningHours() {
        return openingHours;
    }

    public void setOpeningHours(OpeningHours openingHours) {
        this.openingHours = openingHours;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getLattitude() {
        return lattitude;
    }

    public void setLattitude(double lattitude) {
        this.lattitude = lattitude;
    }

    public double getLogitude() {
        return logitude;
    }

    public void setLogitude(double logitude) {
        this.logitude = logitude;
    }

    public LocalDateTime getLastModificationDate() {
        return lastModificationDate;
    }

    public void setLastModificationDate(LocalDateTime lastModificationDate) {
        this.lastModificationDate = lastModificationDate;
    }

    public int getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(int lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    
    
}

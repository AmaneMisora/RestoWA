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

    @Column(name = "keystore")
    private String keyStore;

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
    
    @Column(name = "lattitude")
    private double lattitude;
    
    @Column(name = "longitude")
    private double longitude;
    
    @Column(name = "lastmodificationdate")
    private LocalDateTime lastModificationDate;
    
    @ManyToOne
    @JoinColumn(name = "lastModifiedBy")
    public UserAccount lastModifiedBy;
    
    @ManyToOne
    @JoinColumn(name = "useraccount_id")
    public UserAccount owner;
    
    @Embedded
    private Address address;
    
    public Store() {
        id = -1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKeyStore() {
        return keyStore;
    }

    public void setKeyStore(String keyStore) {
        this.keyStore = keyStore;
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

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public LocalDateTime getLastModificationDate() {
        return lastModificationDate;
    }

    public void setLastModificationDate(LocalDateTime lastModificationDate) {
        this.lastModificationDate = lastModificationDate;
    }

    public UserAccount getLastModifiedBy() {
        return owner;
    }

    public void setLastModifiedBy(UserAccount lastModifiedBy) {
        this.owner = lastModifiedBy;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    
    public boolean contains(String word) {
        if(keyStore.contains(word) || name.contains(word) || phoneNumber.contains(word) || email.contains(word) || address.getCity().contains(word) || address.getCountry().contains(word) || address.getState().contains(word) || address.getStreet().contains(word) || String.valueOf(address.getZipCode()).contains(word) || owner.getFirstName().contains(word) || owner.getLastName().contains(word) || String.valueOf(lattitude).contains(word) || String.valueOf(longitude).contains(word))
            return true;
        return false;
    }
    
}

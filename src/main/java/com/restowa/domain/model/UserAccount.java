package com.restowa.domain.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "useraccounts")
public class UserAccount implements Serializable {

    @Id
    @Column(name = "id")
    private int ID;

    @Column(name = "firstname")
    private String name;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    @Id
//    @Column(name = "CUSTOMER_ID")
//    private int id;
//    
//    @Column(name = "DISCOUNT_CODE")
//    private String DiscountCode;
//    
//    @Column(name = "ZIP")
//    private String Zip;
//    
//    @Column(name = "NAME")
//    private String Name;
//    
//    @Column(name = "ADDRESSLINE1")
//    private String AddressLine1;
//    
//    @Column(name = "ADDRESSLINE2")
//    private String AddressLine2;
//    
//    @Column(name = "CITY")
//    private String City;
//    
//    @Column(name = "STATE")
//    private String State;
//    
//    @Column(name = "PHONE")
//    private String Phone;
//    
//    @Column(name = "FAX")
//    private String Fax;
//    
//    @Column(name = "EMAIL")
//    private String Email;
//    
//    @Column(name = "CREDIT_LIMIT")
//    private String CreditLimit;
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getDiscountCode() {
//        return DiscountCode;
//    }
//
//    public void setDiscountCode(String DiscountCode) {
//        this.DiscountCode = DiscountCode;
//    }
//
//    public String getZip() {
//        return Zip;
//    }
//
//    public void setZip(String Zip) {
//        this.Zip = Zip;
//    }
//
//    public String getName() {
//        return Name;
//    }
//
//    public void setName(String Name) {
//        this.Name = Name;
//    }
//
//    public String getAddressLine1() {
//        return AddressLine1;
//    }
//
//    public void setAddressLine1(String AddressLine1) {
//        this.AddressLine1 = AddressLine1;
//    }
//
//    public String getAddressLine2() {
//        return AddressLine2;
//    }
//
//    public void setAddressLine2(String AddressLine2) {
//        this.AddressLine2 = AddressLine2;
//    }
//
//    public String getCity() {
//        return City;
//    }
//
//    public void setCity(String City) {
//        this.City = City;
//    }
//
//    public String getState() {
//        return State;
//    }
//
//    public void setState(String State) {
//        this.State = State;
//    }
//
//    public String getPhone() {
//        return Phone;
//    }
//
//    public void setPhone(String Phone) {
//        this.Phone = Phone;
//    }
//
//    public String getFax() {
//        return Fax;
//    }
//
//    public void setFax(String Fax) {
//        this.Fax = Fax;
//    }
//
//    public String getEmail() {
//        return Email;
//    }
//
//    public void setEmail(String Email) {
//        this.Email = Email;
//    }
//
//    public String getCreditLimit() {
//        return CreditLimit;
//    }
//
//    public void setCreditLimit(String CreditLimit) {
//        this.CreditLimit = CreditLimit;
//    }
//
}

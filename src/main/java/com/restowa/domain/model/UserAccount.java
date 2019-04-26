package com.restowa.domain.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "useraccounts")
public class UserAccount implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int ID;

    @Column(name = "fistname")
    private String name;
    
    @Column(name = "lastname")
    private String lastname;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "password")
    private String password;
    
    @Column(name = "phonenumber")
    private String phoneNumber;
    
    @Column(name = "active")
    private boolean active;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "creationdate")
    private Date creationDate;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "lastmodificationdate")
    private Date lastModificationDate;
    
    @Column(name = "resetpasswordlink")
    private String resetPasswordLink;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "restelinkvalidatedate")
    private Date resetLinkValidateDate; 
    
    @Column(name = "isremoved")
    private boolean isRemoved;
    
    @Enumerated(EnumType.STRING)
    private TypeEnum type;
   
    @Embedded
    private Address address;

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public void setLastModificationDate(Date lastModificationDate) {
        this.lastModificationDate = lastModificationDate;
    }

    public void setResetPasswordLink(String resetPasswordLink) {
        this.resetPasswordLink = resetPasswordLink;
    }

    public void setResetLinkValidateDate(Date resetLinkValidateDate) {
        this.resetLinkValidateDate = resetLinkValidateDate;
    }

    public void setIsRemoved(boolean isRemoved) {
        this.isRemoved = isRemoved;
    }

    public void setAddress(Address address) {
        this.address = address;
    }  

    public void setType(TypeEnum type) {
        this.type = type;
    }
    
    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public boolean isActive() {
        return active;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public Date getLastModificationDate() {
        return lastModificationDate;
    }

    public String getResetPasswordLink() {
        return resetPasswordLink;
    }

    public Date getResetLinkValidateDate() {
        return resetLinkValidateDate;
    }

    public boolean IsRemoved() {
        return isRemoved;
    }

    public Address getAddress() {
        return address;
    }

    public TypeEnum getType() {
        return type;
    }
}

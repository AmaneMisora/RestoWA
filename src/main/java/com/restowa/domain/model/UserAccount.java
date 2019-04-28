package com.restowa.domain.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class UserAccount implements Serializable {

    @Id
    private int id;

    @NotEmpty
    @Column(name = "firstname")
    private String firstName;
    
    @NotEmpty
    @Column(name = "lastname")
    private String lastName;
    
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
    @Column(name = "type")
    private TypeEnum type;
    
    @Embedded
    private Address address;
    
    public UserAccount() {
        /*
        firstname = "admin";
        lastname = "admin";
        email = "admin@admin.admin";
        password = "admin";
        phoneNumber = "0000000000";
        active = true;
        creationDate = new Date();
        lastModificationDate = new Date();
        resetPasswordLink = "tttt";
        resetLinkValidateDate = new Date();
        isRemoved = false;
        type = TypeEnum.Administrateur;
        */
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getLastModificationDate() {
        return lastModificationDate;
    }

    public void setLastModificationDate(Date lastModificationDate) {
        this.lastModificationDate = lastModificationDate;
    }

    public String getResetPasswordLink() {
        return resetPasswordLink;
    }

    public void setResetPasswordLink(String resetPasswordLink) {
        this.resetPasswordLink = resetPasswordLink;
    }

    public Date getResetLinkValidateDate() {
        return resetLinkValidateDate;
    }

    public void setResetLinkValidateDate(Date resetLinkValidateDate) {
        this.resetLinkValidateDate = resetLinkValidateDate;
    }

    public boolean IsRemoved() {
        return isRemoved;
    }
    
    public void setIsRemoved(boolean isRemoved) {
        this.isRemoved = isRemoved;
    }
    
    public TypeEnum getType() {
        return type;
    }
    
    public void setType(TypeEnum type) {
        this.type = type;
    }
    
    public Address getAddress() {
        return this.address;
    }
    
    public void setAddress(Address address) {
        this.address = address;
    }
}

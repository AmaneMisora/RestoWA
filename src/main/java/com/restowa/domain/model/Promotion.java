/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restowa.domain.model;

import java.time.LocalDate;
import java.util.Date;
import javax.persistence.*;
import static javax.persistence.TemporalType.DATE;
import javax.validation.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Amane
 */
@Entity
public class Promotion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "keypromotion")
    private String keyPromotion;
    
    @NotEmpty
    @Column(name = "title")
    private String title;
    
    @NotEmpty
    @Column(name = "shortdescription")
    private String shortDescription;
    
    @NotEmpty
    @Column(name = "longdescription")
    private String longDescription;
    
    @Column(name = "position")
    private int position;
    
    @Column(name = "disabled")
    private boolean disabled;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "startdate")
    private LocalDate startDate;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "enddate")
    private LocalDate endDate;
    
    @NotEmpty
    @Column(name = "imageurl")
    private String imageURL;

    public Promotion() {
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKeyPromotion() {
        return keyPromotion;
    }

    public void setKeyPromotion(String keyPromotion) {
        this.keyPromotion = keyPromotion;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
    
    public boolean contains(String word) {
        if(keyPromotion.contains(word) || title.contains(word) || shortDescription.contains(word) || longDescription.contains(word) || String.valueOf(position).contains(word) || startDate.toString().contains(word) || endDate.toString().contains(word))
            return true;
        return false;
    }
}

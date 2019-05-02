/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restowa.domain.model;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotEmpty;

/**
 *
 * @author Amane
 */
@Embeddable
public class OpeningHours {
    
    @NotEmpty
    @Column(name = "sunday")
    private StoreDay sunday;
    
    @NotEmpty
    @Column(name = "monday")
    private StoreDay monday;
    
    @NotEmpty
    @Column(name = "tuesday")
    private StoreDay tuesday;
    
    @NotEmpty
    @Column(name = "wednesday")
    private StoreDay wednesday;
    
    @NotEmpty
    @Column(name = "thursday")
    private StoreDay thursday;
    
    @NotEmpty
    @Column(name = "friday")
    private StoreDay friday;
    
    @NotEmpty
    @Column(name = "satursay")
    private StoreDay satursay;

    public StoreDay getSunday() {
        return sunday;
    }

    public void setSunday(StoreDay sunday) {
        this.sunday = sunday;
    }

    public StoreDay getMonday() {
        return monday;
    }

    public void setMonday(StoreDay monday) {
        this.monday = monday;
    }

    public StoreDay getTuesday() {
        return tuesday;
    }

    public void setTuesday(StoreDay tuesday) {
        this.tuesday = tuesday;
    }

    public StoreDay getWednesday() {
        return wednesday;
    }

    public void setWednesday(StoreDay wednesday) {
        this.wednesday = wednesday;
    }

    public StoreDay getThursday() {
        return thursday;
    }

    public void setThursday(StoreDay thursday) {
        this.thursday = thursday;
    }

    public StoreDay getFriday() {
        return friday;
    }

    public void setFriday(StoreDay friday) {
        this.friday = friday;
    }

    public StoreDay getSatursay() {
        return satursay;
    }

    public void setSatursay(StoreDay satursay) {
        this.satursay = satursay;
    }
            
   
}

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
            
            /*
    @NotEmpty
    @Column(name = "openinghoursun")
    private LocalDateTime openingHourSun;
    
    @NotEmpty
    @Column(name = "closinghoursun")
    private LocalDateTime closingHourSun;
    
    @NotEmpty
    @Column(name = "openinghourmon")
    private LocalDateTime openingHourMon;
    
    @NotEmpty
    @Column(name = "closinghourmon")
    private LocalDateTime closingHourMon;
    
    @NotEmpty
    @Column(name = "openinghourtues")
    private LocalDateTime openingHourTues;
    
    @NotEmpty
    @Column(name = "closinghourtues")
    private LocalDateTime closingHourTues;
    
    @NotEmpty
    @Column(name = "openinghourwed")
    private LocalDateTime openingHourWed;
    
    @NotEmpty
    @Column(name = "closinghourwed")
    private LocalDateTime closingHourWed;
    
    @NotEmpty
    @Column(name = "openinghourthu")
    private LocalDateTime openingHourThu;
    
    @NotEmpty
    @Column(name = "closinghourthu")
    private LocalDateTime closingHourThu;
    
    @NotEmpty
    @Column(name = "openinghourfri")
    private LocalDateTime openingHourFri;
    
    @NotEmpty
    @Column(name = "closinghourfri")
    private LocalDateTime closingHourFri;
    
    @NotEmpty
    @Column(name = "openinghoursat")
    private LocalDateTime openingHourSat;
    
    @NotEmpty
    @Column(name = "closinghoursat")
    private LocalDateTime closingHourSat;

    public LocalDateTime getOpeningHourSun() {
        return openingHourSun;
    }

    public void setOpeningHourSun(LocalDateTime openingHourSun) {
        this.openingHourSun = openingHourSun;
    }

    public LocalDateTime getClosingHourSun() {
        return closingHourSun;
    }

    public void setClosingHourSun(LocalDateTime closingHourSun) {
        this.closingHourSun = closingHourSun;
    }

    public LocalDateTime getOpeningHourMon() {
        return openingHourMon;
    }

    public void setOpeningHourMon(LocalDateTime openingHourMon) {
        this.openingHourMon = openingHourMon;
    }

    public LocalDateTime getClosingHourMon() {
        return closingHourMon;
    }

    public void setClosingHourMon(LocalDateTime closingHourMon) {
        this.closingHourMon = closingHourMon;
    }

    public LocalDateTime getOpeningHourTues() {
        return openingHourTues;
    }

    public void setOpeningHourTues(LocalDateTime openingHourTues) {
        this.openingHourTues = openingHourTues;
    }

    public LocalDateTime getClosingHourTues() {
        return closingHourTues;
    }

    public void setClosingHourTues(LocalDateTime closingHourTues) {
        this.closingHourTues = closingHourTues;
    }

    public LocalDateTime getOpeningHourWed() {
        return openingHourWed;
    }

    public void setOpeningHourWed(LocalDateTime openingHourWed) {
        this.openingHourWed = openingHourWed;
    }

    public LocalDateTime getClosingHourWed() {
        return closingHourWed;
    }

    public void setClosingHourWed(LocalDateTime closingHourWed) {
        this.closingHourWed = closingHourWed;
    }

    public LocalDateTime getOpeningHourThu() {
        return openingHourThu;
    }

    public void setOpeningHourThu(LocalDateTime openingHourThu) {
        this.openingHourThu = openingHourThu;
    }

    public LocalDateTime getClosingHourThu() {
        return closingHourThu;
    }

    public void setClosingHourThu(LocalDateTime closingHourThu) {
        this.closingHourThu = closingHourThu;
    }

    public LocalDateTime getOpeningHourFri() {
        return openingHourFri;
    }

    public void setOpeningHourFri(LocalDateTime openingHourFri) {
        this.openingHourFri = openingHourFri;
    }

    public LocalDateTime getClosingHourFri() {
        return closingHourFri;
    }

    public void setClosingHourFri(LocalDateTime closingHourFri) {
        this.closingHourFri = closingHourFri;
    }

    public LocalDateTime getOpeningHourSat() {
        return openingHourSat;
    }

    public void setOpeningHourSat(LocalDateTime openingHourSat) {
        this.openingHourSat = openingHourSat;
    }

    public LocalDateTime getClosingHourSat() {
        return closingHourSat;
    }

    public void setClosingHourSat(LocalDateTime closingHourSat) {
        this.closingHourSat = closingHourSat;
    }
    
    */
}

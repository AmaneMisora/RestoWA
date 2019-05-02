/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restowa.domain.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;

/**
 *
 * @author Amane
 */
public class StoreDay implements Serializable{
    
    @NotEmpty
    @Column(name = "openinghoursun")
    private LocalDateTime openingHour;
    
    @NotEmpty
    @Column(name = "closinghoursun")
    private LocalDateTime closingHour;
    
    @NotEmpty
    @Column(name = "closed")
    private boolean closed;
    
    @NotEmpty
    @Column(name = "allday")
    private boolean allDay;

    public LocalDateTime getOpeningHour() {
        return openingHour;
    }

    public void setOpeningHour(LocalDateTime openingHour) {
        this.openingHour = openingHour;
    }

    public LocalDateTime getClosingHour() {
        return closingHour;
    }

    public void setClosingHour(LocalDateTime closingHour) {
        this.closingHour = closingHour;
    }

    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    public boolean isAllDay() {
        return allDay;
    }

    public void setAllDay(boolean allDay) {
        this.allDay = allDay;
    }

}

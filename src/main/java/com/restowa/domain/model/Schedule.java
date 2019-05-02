/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restowa.domain.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.persistence.Embeddable;
import javax.validation.constraints.AssertTrue;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author yanis
 */
@Embeddable
public class Schedule implements Serializable {
    
    private LocalDateTime mondayStart;
    private Date mondayStop;
    private boolean mondayClosed;
    
    @AssertTrue
    private boolean monday24h = true;
    
    private Date tuesdayStart;
    private Date tuesdayStop;
    private boolean tuesdayClosed;
    private boolean tuesday24h;
    
    private Date wednesdayStart;
    private Date wednesdayStop;
    private boolean wednesdayClosed;
    private boolean wednesday24h;
    
    private Date thursdayStart;
    private Date thursdayStop;
    private boolean thursdayClosed;
    private boolean thursday24h;
    
    private Date fridayStart;
    private Date fridayStop;
    private boolean fridayClosed;
    private boolean friday24h;
    
    private Date saturdayStart;
    private Date saturdayStop;
    private boolean saturdayClosed;
    private boolean saturday24h;
    
    private Date sundayStart;
    private Date sundayStop;
    private boolean sundayClosed;
    private boolean sunday24h;
    
    public Schedule() {
        mondayStart = LocalDateTime.now();
    }

    public LocalDateTime getMondayStart() {
        return mondayStart;
    }

    public void setMondayStart(LocalDateTime mondayStart) {
        this.mondayStart = mondayStart;
    }

    public Date getMondayStop() {
        return mondayStop;
    }

    public void setMondayStop(Date mondayStop) {
        this.mondayStop = mondayStop;
    }

    public boolean isMondayClosed() {
        return mondayClosed;
    }

    public void setMondayClosed(boolean mondayClosed) {
        this.mondayClosed = mondayClosed;
    }

    public boolean isMonday24h() {
        return monday24h;
    }

    public void setMonday24h(boolean monday24h) {
        this.monday24h = monday24h;
    }

    public Date getTuesdayStart() {
        return tuesdayStart;
    }

    public void setTuesdayStart(Date tuesdayStart) {
        this.tuesdayStart = tuesdayStart;
    }

    public Date getTuesdayStop() {
        return tuesdayStop;
    }

    public void setTuesdayStop(Date tuesdayStop) {
        this.tuesdayStop = tuesdayStop;
    }

    public boolean isTuesdayClosed() {
        return tuesdayClosed;
    }

    public void setTuesdayClosed(boolean tuesdayClosed) {
        this.tuesdayClosed = tuesdayClosed;
    }

    public boolean isTuesday24h() {
        return tuesday24h;
    }

    public void setTuesday24h(boolean tuesday24h) {
        this.tuesday24h = tuesday24h;
    }

    public Date getWednesdayStart() {
        return wednesdayStart;
    }

    public void setWednesdayStart(Date wednesdayStart) {
        this.wednesdayStart = wednesdayStart;
    }

    public Date getWednesdayStop() {
        return wednesdayStop;
    }

    public void setWednesdayStop(Date wednesdayStop) {
        this.wednesdayStop = wednesdayStop;
    }

    public boolean isWednesdayClosed() {
        return wednesdayClosed;
    }

    public void setWednesdayClosed(boolean wednesdayClosed) {
        this.wednesdayClosed = wednesdayClosed;
    }

    public boolean isWednesday24h() {
        return wednesday24h;
    }

    public void setWednesday24h(boolean wednesday24h) {
        this.wednesday24h = wednesday24h;
    }

    public Date getThursdayStart() {
        return thursdayStart;
    }

    public void setThursdayStart(Date thursdayStart) {
        this.thursdayStart = thursdayStart;
    }

    public Date getThursdayStop() {
        return thursdayStop;
    }

    public void setThursdayStop(Date thursdayStop) {
        this.thursdayStop = thursdayStop;
    }

    public boolean isThursdayClosed() {
        return thursdayClosed;
    }

    public void setThursdayClosed(boolean thursdayClosed) {
        this.thursdayClosed = thursdayClosed;
    }

    public boolean isThursday24h() {
        return thursday24h;
    }

    public void setThursday24h(boolean thursday24h) {
        this.thursday24h = thursday24h;
    }

    public Date getFridayStart() {
        return fridayStart;
    }

    public void setFridayStart(Date fridayStart) {
        this.fridayStart = fridayStart;
    }

    public Date getFridayStop() {
        return fridayStop;
    }

    public void setFridayStop(Date fridayStop) {
        this.fridayStop = fridayStop;
    }

    public boolean isFridayClosed() {
        return fridayClosed;
    }

    public void setFridayClosed(boolean fridayClosed) {
        this.fridayClosed = fridayClosed;
    }

    public boolean isFriday24h() {
        return friday24h;
    }

    public void setFriday24h(boolean friday24h) {
        this.friday24h = friday24h;
    }

    public Date getSaturdayStart() {
        return saturdayStart;
    }

    public void setSaturdayStart(Date saturdayStart) {
        this.saturdayStart = saturdayStart;
    }

    public Date getSaturdayStop() {
        return saturdayStop;
    }

    public void setSaturdayStop(Date saturdayStop) {
        this.saturdayStop = saturdayStop;
    }

    public boolean isSaturdayClosed() {
        return saturdayClosed;
    }

    public void setSaturdayClosed(boolean saturdayClosed) {
        this.saturdayClosed = saturdayClosed;
    }

    public boolean isSaturday24h() {
        return saturday24h;
    }

    public void setSaturday24h(boolean saturday24h) {
        this.saturday24h = saturday24h;
    }

    public Date getSundayStart() {
        return sundayStart;
    }

    public void setSundayStart(Date sundayStart) {
        this.sundayStart = sundayStart;
    }

    public Date getSundayStop() {
        return sundayStop;
    }

    public void setSundayStop(Date sundayStop) {
        this.sundayStop = sundayStop;
    }

    public boolean isSundayClosed() {
        return sundayClosed;
    }

    public void setSundayClosed(boolean sundayClosed) {
        this.sundayClosed = sundayClosed;
    }

    public boolean isSunday24h() {
        return sunday24h;
    }

    public void setSunday24h(boolean sunday24h) {
        this.sunday24h = sunday24h;
    }
    
    
    
    
}

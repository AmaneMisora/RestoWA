/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restowa.domain.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.LocalTime;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Amane
 */
@Embeddable
public class OpeningHours implements Serializable {
    
    @Column(name = "mondayopeninghour")
    private LocalTime mondayOpeningHour;
    
    @Column(name = "mondayClosinghour")
    private LocalTime mondayClosingHour;
    
    @Column(name = "mondayClosed")
    private boolean mondayClosed;
    
    @Column(name = "mondayallday")
    private boolean mondayAllDay;
    
    @Column(name = "tuesdayopeninghour")
    private LocalTime tuesdayOpeningHour;
    
    @Column(name = "tuesdayClosinghour")
    private LocalTime tuesdayClosingHour;
    
    @Column(name = "tuesdayClosed")
    private boolean tuesdayClosed;
    
    @Column(name = "tuesdayallday")
    private boolean tuesdayAllDay;
    
    @Column(name = "wednesdayopeninghour")
    private LocalTime wednesdayOpeningHour;
    
    @Column(name = "wednesdayClosinghour")
    private LocalTime wednesdayClosingHour;
    
    @Column(name = "wednesdayClosed")
    private boolean wednesdayClosed;
    
    @Column(name = "wednesdayallday")
    private boolean wednesdayAllDay;
    
    @Column(name = "thursdayopeninghour")
    private LocalTime thursdayOpeningHour;
    
    @Column(name = "thursdayClosinghour")
    private LocalTime thursdayClosingHour;
    
    @Column(name = "thursdayClosed")
    private boolean thursdayClosed;
    
    @Column(name = "thursdayallday")
    private boolean thursdayAllDay;
    
    @Column(name = "fridayopeninghour")
    private LocalTime fridayOpeningHour;
    
    @Column(name = "fridayClosinghour")
    private LocalTime fridayClosingHour;
    
    @Column(name = "fridayClosed")
    private boolean fridayClosed;
    
    @Column(name = "fridayallday")
    private boolean fridayAllDay;
    
    @Column(name = "saturdayopeninghour")
    private LocalTime saturdayOpeningHour;
    
    @Column(name = "saturdayClosinghour")
    private LocalTime saturdayClosingHour;
    
    @Column(name = "saturdayClosed")
    private boolean saturdayClosed;
    
    @Column(name = "saturdayallday")
    private boolean saturdayAllDay;
    
    @Column(name = "sundayopeninghour")
    private LocalTime sundayOpeningHour;
    
    @Column(name = "sundayClosinghour")
    private LocalTime sundayClosingHour;
    
    @Column(name = "sundayClosed")
    private boolean sundayClosed;
    
    @Column(name = "sundayallday")
    private boolean sundayAllDay;
    
    public OpeningHours() {
        
    }

    public LocalTime getMondayOpeningHour() {
        return mondayOpeningHour;
    }

    public void setMondayOpeningHour(LocalTime mondayOpeningHour) {
        this.mondayOpeningHour = mondayOpeningHour;
    }

    public LocalTime getMondayClosingHour() {
        return mondayClosingHour;
    }

    public void setMondayClosingHour(LocalTime mondayClosingHour) {
        this.mondayClosingHour = mondayClosingHour;
    }

    public boolean isMondayClosed() {
        return mondayClosed;
    }

    public void setMondayClosed(boolean mondayClosed) {
        this.mondayClosed = mondayClosed;
    }

    public boolean isMondayAllDay() {
        return mondayAllDay;
    }

    public void setMondayAllDay(boolean mondayAllDay) {
        this.mondayAllDay = mondayAllDay;
    }

    public LocalTime getTuesdayOpeningHour() {
        return tuesdayOpeningHour;
    }

    public void setTuesdayOpeningHour(LocalTime tuesdayOpeningHour) {
        this.tuesdayOpeningHour = tuesdayOpeningHour;
    }

    public LocalTime getTuesdayClosingHour() {
        return tuesdayClosingHour;
    }

    public void setTuesdayClosingHour(LocalTime tuesdayClosingHour) {
        this.tuesdayClosingHour = tuesdayClosingHour;
    }

    public boolean isTuesdayClosed() {
        return tuesdayClosed;
    }

    public void setTuesdayClosed(boolean tuesdayClosed) {
        this.tuesdayClosed = tuesdayClosed;
    }

    public boolean isTuesdayAllDay() {
        return tuesdayAllDay;
    }

    public void setTuesdayAllDay(boolean tuesdayAllDay) {
        this.tuesdayAllDay = tuesdayAllDay;
    }

    public LocalTime getWednesdayOpeningHour() {
        return wednesdayOpeningHour;
    }

    public void setWednesdayOpeningHour(LocalTime wednesdayOpeningHour) {
        this.wednesdayOpeningHour = wednesdayOpeningHour;
    }

    public LocalTime getWednesdayClosingHour() {
        return wednesdayClosingHour;
    }

    public void setWednesdayClosingHour(LocalTime wednesdayClosingHour) {
        this.wednesdayClosingHour = wednesdayClosingHour;
    }

    public boolean isWednesdayClosed() {
        return wednesdayClosed;
    }

    public void setWednesdayClosed(boolean wednesdayClosed) {
        this.wednesdayClosed = wednesdayClosed;
    }

    public boolean isWednesdayAllDay() {
        return wednesdayAllDay;
    }

    public void setWednesdayAllDay(boolean wednesdayAllDay) {
        this.wednesdayAllDay = wednesdayAllDay;
    }

    public LocalTime getThursdayOpeningHour() {
        return thursdayOpeningHour;
    }

    public void setThursdayOpeningHour(LocalTime thursdayOpeningHour) {
        this.thursdayOpeningHour = thursdayOpeningHour;
    }

    public LocalTime getThursdayClosingHour() {
        return thursdayClosingHour;
    }

    public void setThursdayClosingHour(LocalTime thursdayClosingHour) {
        this.thursdayClosingHour = thursdayClosingHour;
    }

    public boolean isThursdayClosed() {
        return thursdayClosed;
    }

    public void setThursdayClosed(boolean thursdayClosed) {
        this.thursdayClosed = thursdayClosed;
    }

    public boolean isThursdayAllDay() {
        return thursdayAllDay;
    }

    public void setThursdayAllDay(boolean thursdayAllDay) {
        this.thursdayAllDay = thursdayAllDay;
    }

    public LocalTime getFridayOpeningHour() {
        return fridayOpeningHour;
    }

    public void setFridayOpeningHour(LocalTime fridayOpeningHour) {
        this.fridayOpeningHour = fridayOpeningHour;
    }

    public LocalTime getFridayClosingHour() {
        return fridayClosingHour;
    }

    public void setFridayClosingHour(LocalTime fridayClosingHour) {
        this.fridayClosingHour = fridayClosingHour;
    }

    public boolean isFridayClosed() {
        return fridayClosed;
    }

    public void setFridayClosed(boolean fridayClosed) {
        this.fridayClosed = fridayClosed;
    }

    public boolean isFridayAllDay() {
        return fridayAllDay;
    }

    public void setFridayAllDay(boolean fridayAllDay) {
        this.fridayAllDay = fridayAllDay;
    }

    public LocalTime getSaturdayOpeningHour() {
        return saturdayOpeningHour;
    }

    public void setSaturdayOpeningHour(LocalTime saturdayOpeningHour) {
        this.saturdayOpeningHour = saturdayOpeningHour;
    }

    public LocalTime getSaturdayClosingHour() {
        return saturdayClosingHour;
    }

    public void setSaturdayClosingHour(LocalTime saturdayClosingHour) {
        this.saturdayClosingHour = saturdayClosingHour;
    }

    public boolean isSaturdayClosed() {
        return saturdayClosed;
    }

    public void setSaturdayClosed(boolean saturdayClosed) {
        this.saturdayClosed = saturdayClosed;
    }

    public boolean isSaturdayAllDay() {
        return saturdayAllDay;
    }

    public void setSaturdayAllDay(boolean saturdayAllDay) {
        this.saturdayAllDay = saturdayAllDay;
    }

    public LocalTime getSundayOpeningHour() {
        return sundayOpeningHour;
    }

    public void setSundayOpeningHour(LocalTime sundayOpeningHour) {
        this.sundayOpeningHour = sundayOpeningHour;
    }

    public LocalTime getSundayClosingHour() {
        return sundayClosingHour;
    }

    public void setSundayClosingHour(LocalTime sundayClosingHour) {
        this.sundayClosingHour = sundayClosingHour;
    }

    public boolean isSundayClosed() {
        return sundayClosed;
    }

    public void setSundayClosed(boolean sundayClosed) {
        this.sundayClosed = sundayClosed;
    }

    public boolean isSundayAllDay() {
        return sundayAllDay;
    }

    public void setSundayAllDay(boolean sundayAllDay) {
        this.sundayAllDay = sundayAllDay;
    }
    
}

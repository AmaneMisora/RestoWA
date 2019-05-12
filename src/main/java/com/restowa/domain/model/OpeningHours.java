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
    
    
    //TODO
    @Column(name = "mondayopeninghour")
    private int mondayOpeningHour;
    
    @Column(name = "mondayClosinghour")
    private int mondayClosingHour;
    
    @Column(name = "mondayClosed")
    private boolean mondayClosed;
    
    @Column(name = "mondayallday")
    private boolean mondayAllDay;
    
    @Column(name = "tuesdayopeninghour")
    private int tuesdayOpeningHour;
    
    @Column(name = "tuesdayClosinghour")
    private int tuesdayClosingHour;
    
    @Column(name = "tuesdayClosed")
    private boolean tuesdayClosed;
    
    @Column(name = "tuesdayallday")
    private boolean tuesdayAllDay;
    
    @Column(name = "wednesdayopeninghour")
    private int wednesdayOpeningHour;
    
    @Column(name = "wednesdayClosinghour")
    private int wednesdayClosingHour;
    
    @Column(name = "wednesdayClosed")
    private boolean wednesdayClosed;
    
    @Column(name = "wednesdayallday")
    private boolean wednesdayAllDay;
    
    @Column(name = "thursdayopeninghour")
    private int thursdayOpeningHour;
    
    @Column(name = "thursdayClosinghour")
    private int thursdayClosingHour;
    
    @Column(name = "thursdayClosed")
    private boolean thursdayClosed;
    
    @Column(name = "thursdayallday")
    private boolean thursdayAllDay;
    
    @Column(name = "fridayopeninghour") 
    private int fridayOpeningHour;
    
    @Column(name = "fridayClosinghour")
    private int fridayClosingHour;
    
    @Column(name = "fridayClosed")
    private boolean fridayClosed;
    
    @Column(name = "fridayallday")
    private boolean fridayAllDay;
    
    @Column(name = "saturdayopeninghour")
    private int saturdayOpeningHour;
    
    @Column(name = "saturdayClosinghour")
    private int saturdayClosingHour;
    
    @Column(name = "saturdayClosed")
    private boolean saturdayClosed;
    
    @Column(name = "saturdayallday")
    private boolean saturdayAllDay;
    
    @Column(name = "sundayopeninghour")
    private int sundayOpeningHour;
    
    @Column(name = "sundayClosinghour")
    private int sundayClosingHour;
    
    @Column(name = "sundayClosed")
    private boolean sundayClosed;
    
    @Column(name = "sundayallday")
    private boolean sundayAllDay;
    
    public OpeningHours() {
        
    }

    public LocalTime getMondayOpeningHour() {
        int minute = mondayOpeningHour % 60;
        int hour = (mondayOpeningHour - minute) / 60;
        LocalTime timeToReturn = LocalTime.of(hour , minute);
        return timeToReturn;
    }

    public void setMondayOpeningHour(LocalTime mondayOpeningHour) {
        int intToSet = mondayOpeningHour.getHour() * 60 + mondayOpeningHour.getMinute();
        this.mondayOpeningHour = intToSet;
    }

    public LocalTime getMondayClosingHour() {
        int minute = mondayClosingHour % 60;
        int hour = (mondayClosingHour - minute) / 60;
        LocalTime timeToReturn = LocalTime.of(hour , minute);
        return timeToReturn;
    }

    public void setMondayClosingHour(LocalTime mondayClosingHour) {
        int intToSet = mondayClosingHour.getHour() * 60 + mondayClosingHour.getMinute();
        this.mondayClosingHour = intToSet;
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
        int minute = tuesdayOpeningHour % 60;
        int hour = (tuesdayOpeningHour - minute) / 60;
        LocalTime timeToReturn = LocalTime.of(hour , minute);
        return timeToReturn;
    }

    public void setTuesdayOpeningHour(LocalTime tuesdayOpeningHour) {
        int intToSet = tuesdayOpeningHour.getHour() * 60 + tuesdayOpeningHour.getMinute();
        this.tuesdayOpeningHour = intToSet;
    }

    public LocalTime getTuesdayClosingHour() {
        int minute = tuesdayClosingHour % 60;
        int hour = (tuesdayClosingHour - minute) / 60;
        LocalTime timeToReturn = LocalTime.of(hour , minute);
        return timeToReturn;
    }

    public void setTuesdayClosingHour(LocalTime tuesdayClosingHour) {
        int intToSet = tuesdayClosingHour.getHour() * 60 + tuesdayClosingHour.getMinute();
        this.tuesdayClosingHour = intToSet;
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
        int minute = wednesdayOpeningHour % 60;
        int hour = (wednesdayOpeningHour - minute) / 60;
        LocalTime timeToReturn = LocalTime.of(hour , minute);
        return timeToReturn;
    }

    public void setWednesdayOpeningHour(LocalTime wednesdayOpeningHour) {
        int intToSet = wednesdayOpeningHour.getHour() * 60 + wednesdayOpeningHour.getMinute();
        this.wednesdayOpeningHour = intToSet;
    }

    public LocalTime getWednesdayClosingHour() {
        int minute = wednesdayClosingHour % 60;
        int hour = (wednesdayClosingHour - minute) / 60;
        LocalTime timeToReturn = LocalTime.of(hour , minute);
        return timeToReturn;
    }

    public void setWednesdayClosingHour(LocalTime wednesdayClosingHour) {
        int intToSet = wednesdayClosingHour.getHour() * 60 + wednesdayClosingHour.getMinute();
        this.wednesdayClosingHour = intToSet;
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
        int minute = thursdayOpeningHour % 60;
        int hour = (thursdayOpeningHour - minute) / 60;
        LocalTime timeToReturn = LocalTime.of(hour , minute);
        return timeToReturn;
    }

    public void setThursdayOpeningHour(LocalTime thursdayOpeningHour) {
        int intToSet = thursdayOpeningHour.getHour() * 60 + thursdayOpeningHour.getMinute();
        this.thursdayOpeningHour = intToSet;
    }

    public LocalTime getThursdayClosingHour() {
        int minute = thursdayClosingHour % 60;
        int hour = (thursdayClosingHour - minute) / 60;
        LocalTime timeToReturn = LocalTime.of(hour , minute);
        return timeToReturn;
    }

    public void setThursdayClosingHour(LocalTime thursdayClosingHour) {
        int intToSet = thursdayClosingHour.getHour() * 60 + thursdayClosingHour.getMinute();
        this.thursdayClosingHour = intToSet;
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
        int minute = fridayOpeningHour % 60;
        int hour = (fridayOpeningHour - minute) / 60;
        LocalTime timeToReturn = LocalTime.of(hour , minute);
        return timeToReturn;
    }

    public void setFridayOpeningHour(LocalTime fridayOpeningHour) {
        int intToSet = fridayOpeningHour.getHour() * 60 + fridayOpeningHour.getMinute();
        this.fridayOpeningHour = intToSet;
    }

    public LocalTime getFridayClosingHour() {
        int minute = fridayClosingHour % 60;
        int hour = (fridayClosingHour - minute) / 60;
        LocalTime timeToReturn = LocalTime.of(hour , minute);
        return timeToReturn;
    }

    public void setFridayClosingHour(LocalTime fridayClosingHour) {
        int intToSet = fridayClosingHour.getHour() * 60 + fridayClosingHour.getMinute();
        this.fridayClosingHour = intToSet;
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
        int minute = saturdayOpeningHour % 60;
        int hour = (saturdayOpeningHour - minute) / 60;
        LocalTime timeToReturn = LocalTime.of(hour , minute);
        return timeToReturn;
    }

    public void setSaturdayOpeningHour(LocalTime saturdayOpeningHour) {
        int intToSet = saturdayOpeningHour.getHour() * 60 + saturdayOpeningHour.getMinute();
        this.saturdayOpeningHour = intToSet;
    }

    public LocalTime getSaturdayClosingHour() {
        int minute = saturdayClosingHour % 60;
        int hour = (saturdayClosingHour - minute) / 60;
        LocalTime timeToReturn = LocalTime.of(hour , minute);
        return timeToReturn;
    }

    public void setSaturdayClosingHour(LocalTime saturdayClosingHour) {
        int intToSet = saturdayClosingHour.getHour() * 60 + saturdayClosingHour.getMinute();
        this.saturdayClosingHour = intToSet;
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
        int minute = sundayOpeningHour % 60;
        int hour = (sundayOpeningHour - minute) / 60;
        LocalTime timeToReturn = LocalTime.of(hour , minute);
        return timeToReturn;
    }

    public void setSundayOpeningHour(LocalTime sundayOpeningHour) {
        int intToSet = sundayOpeningHour.getHour() * 60 + sundayOpeningHour.getMinute();
        this.sundayOpeningHour = intToSet;
    }

    public LocalTime getSundayClosingHour() {
        int minute = sundayClosingHour % 60;
        int hour = (sundayClosingHour - minute) / 60;
        LocalTime timeToReturn = LocalTime.of(hour , minute);
        return timeToReturn;
    }

    public void setSundayClosingHour(LocalTime sundayClosingHour) {
        int intToSet = sundayClosingHour.getHour() * 60 + sundayClosingHour.getMinute();
        this.sundayClosingHour = intToSet;
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

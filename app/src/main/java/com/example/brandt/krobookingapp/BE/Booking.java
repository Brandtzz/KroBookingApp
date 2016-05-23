package com.example.brandt.krobookingapp.BE;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by kenne on 08-05-2016.
 */
public class Booking implements Serializable{
    boolean extraBed;
    boolean animal;
    boolean doubleRoom;
    Date arrivalDate;
    Date depatureDate;
    Customer Custemor;

    public Booking(boolean extraBed, boolean animal, boolean doubleRoom, Customer custemor) {
        this.extraBed = extraBed;
        this.animal = animal;
        this.doubleRoom = doubleRoom;
        this.depatureDate = depatureDate;
        this.arrivalDate = arrivalDate;
        Custemor = custemor;
    }

    public boolean isExtraBed() {
        return extraBed;
    }

    public void setExtraBed(boolean extraBed) {
        this.extraBed = extraBed;
    }

    public boolean isAnimal() {
        return animal;
    }

    public void setAnimal(boolean animal) {
        this.animal = animal;
    }

    public boolean isDoubleRoom() {return doubleRoom; }

    public void setDoubleRoom ( boolean doubleRoom ){ this.doubleRoom = doubleRoom; }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public Customer getCustemor() {
        return Custemor;
    }

    public void setCustemor(Customer custemor) {
        Custemor = custemor;
    }

    public Date getDepatureDate() {
        return depatureDate;
    }

    public void setDepatureDate(Date depatureDate) {
        this.depatureDate = depatureDate;
    }
}

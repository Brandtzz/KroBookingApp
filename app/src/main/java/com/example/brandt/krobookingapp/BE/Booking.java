package com.example.brandt.krobookingapp.BE;

import java.util.Date;

/**
 * Created by kenne on 08-05-2016.
 */
public class Booking {
    boolean extraBed;
    boolean animal;
    Date arrivalDate;
    Date depatureDate;
    Customer Custemor;

    public Booking(boolean extraBed, boolean animal, Customer custemor) {
        this.extraBed = extraBed;
        this.animal = animal;
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

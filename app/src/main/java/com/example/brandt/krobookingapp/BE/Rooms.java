package com.example.brandt.krobookingapp.BE;

import java.util.Date;

/**
 * Created by kenne on 27-04-2016.
 */
public class Rooms {

    String id;
    int roomNumber;
    boolean rented;
    boolean doubleRoom;
    boolean extraBed;
    boolean bathroom;
    int roomPrice;
    boolean animal;
    Date arrivalDate;
    Date departureDate;
    Customer customer;

    public Rooms(String id, int roomNumber, boolean rented, boolean doubleRoom, boolean extraBed, boolean bathroom, int roomPrice, boolean animal, Customer custemor) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.rented = rented;
        this.doubleRoom = doubleRoom;
        this.extraBed = extraBed;
        this.bathroom = bathroom;
        this.roomPrice = roomPrice;
        this.animal = animal;
        this.customer = custemor;


    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public boolean isRented() {
        return rented;
    }

    public void setRented(boolean rented) {
        this.rented = rented;
    }

    public boolean isDoubleRoom() {
        return doubleRoom;
    }

    public void setDoubleRoom(boolean doubleRoom) {
        this.doubleRoom = doubleRoom;
    }

    public boolean isExtraBed() {
        return extraBed;
    }

    public void setExtraBed(boolean extraBed) {
        this.extraBed = extraBed;
    }

    public boolean isBathroom() {
        return bathroom;
    }

    public void setBathroom(boolean bathroom) {
        this.bathroom = bathroom;
    }

    public int getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(int roomPrice) {
        this.roomPrice = roomPrice;
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }
}

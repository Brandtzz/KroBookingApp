package com.example.brandt.krobookingapp.BE;

import java.util.Date;

/**
 * Created by kenne on 27-04-2016.
 */
public class Rooms {

    String id;
    int roomNumber;
    boolean rented;
    boolean bathRoom;
    int roomPrice;
    Booking[] booking;

    public Rooms(String id, int roomNumber, boolean rented, boolean bathRoom, int roomPrice, Booking[] booking) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.rented = rented;
        this.bathRoom = bathRoom;
        this.roomPrice = roomPrice;
        this.booking = booking;
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

    public boolean isBathRoom() {
        return bathRoom;
    }

    public void setBathRoom(boolean bathRoom) {
        this.bathRoom = bathRoom;
    }

    public int getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(int roomPrice) {
        this.roomPrice = roomPrice;
    }

    public Booking[] getBooking() {
        return booking;
    }

    public void setBooking(Booking[] booking) {
        this.booking = booking;
    }
}

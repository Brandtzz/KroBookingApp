package com.example.brandt.krobookingapp.BE;

/**
 * Created by kenne on 27-04-2016.
 */
public class Customer {

    String customerName;
    String customerPhoneNumber;
    boolean keybox;
    String notes;
    String custemorEmail;
    Company company;

    public Customer(String customerName, String customerPhoneNumber, boolean keybox, String notes, String custemorEmail, Company company) {

        this.customerName = customerName;
        this.customerPhoneNumber = customerPhoneNumber;
        this.keybox = keybox;
        this.notes = notes;
        this.custemorEmail = custemorEmail;
        this.company = company;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }

    public void setCustomerPhoneNumber(String customerPhoneNumber) {
        this.customerPhoneNumber = customerPhoneNumber;
    }

    public boolean isKeybox() {
        return keybox;
    }

    public void setKeybox(boolean keybox) {
        this.keybox = keybox;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getCustemorEmail() {
        return custemorEmail;
    }

    public void setCustemorEmail(String custemorEmail) {
        this.custemorEmail = custemorEmail;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}

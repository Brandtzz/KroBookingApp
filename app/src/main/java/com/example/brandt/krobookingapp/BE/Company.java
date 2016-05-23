package com.example.brandt.krobookingapp.BE;

import java.io.Serializable;

/**
 * Created by kenne on 27-04-2016.
 */
public class Company implements Serializable{
    String companyName;
    String companyPhoneNumber;
    String companyEmail;



    public Company( String companyName, String companyPhoneNumber, String companyEmail) {
       ;
        this.companyName = companyName;
        this.companyPhoneNumber = companyPhoneNumber;
        this.companyEmail = companyEmail;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyPhoneNumber() {
        return companyPhoneNumber;
    }

    public void setCompanyPhoneNumber(String companyPhoneNumber) {
        this.companyPhoneNumber = companyPhoneNumber;
    }

    public String getCompanyEmail() {
        return companyEmail;
    }

    public void setCompanyEmail(String companyEmail) {
        this.companyEmail = companyEmail;
    }
}
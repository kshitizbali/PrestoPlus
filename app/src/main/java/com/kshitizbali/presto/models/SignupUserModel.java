package com.kshitizbali.presto.models;

import android.util.Patterns;

public class SignupUserModel {

    private String strFirstName;
    private String strLastName;
    private String strEmail;
    private String strPhone;

    public SignupUserModel(String strFirstName, String strLastName, String strEmail, String strPhone) {
        this.strFirstName = strFirstName;
        this.strLastName = strLastName;
        this.strEmail = strEmail;
        this.strPhone = strPhone;
    }


    public String getStrFirstName() {
        return strFirstName;
    }

    public void setStrFirstName(String strFirstName) {
        this.strFirstName = strFirstName;
    }

    public String getStrLastName() {
        return strLastName;
    }

    public void setStrLastName(String strLastName) {
        this.strLastName = strLastName;
    }

    public String getStrEmail() {
        return strEmail;
    }

    public void setStrEmail(String strEmail) {
        this.strEmail = strEmail;
    }

    public String getStrPhone() {
        return strPhone;
    }

    public void setStrPhone(String strPhone) {
        this.strPhone = strPhone;
    }


    public boolean isValidEmail(){
        return getStrEmail().length() > 0 && Patterns.EMAIL_ADDRESS.matcher(getStrEmail()).matches();
    }

    public boolean isValidPhone(){
        return getStrPhone().length() > 0 && getStrPhone().length() == 10 && Patterns.PHONE.matcher(getStrPhone()).matches();
    }
}

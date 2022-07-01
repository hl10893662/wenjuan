package com.eno.baozi.wenjuan.domain;

import java.io.Serializable;

public class PersonalInfo implements Serializable {
    String name;
    String no;
    String birthMonth;
    String education;
    String economic;
    String belief;
    String address;
    String imprisonDate;
    String crime;

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getEconomic() {
        return economic;
    }

    public void setEconomic(String economic) {
        this.economic = economic;
    }

    public String getBelief() {
        return belief;
    }

    public void setBelief(String belief) {
        this.belief = belief;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImprisonDate() {
        return imprisonDate;
    }

    public void setImprisonDate(String imprisonDate) {
        this.imprisonDate = imprisonDate;
    }

    public String getCrime() {
        return crime;
    }

    public void setCrime(String crime) {
        this.crime = crime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getBirthMonth() {
        return birthMonth;
    }

    public void setBirthMonth(String birthMonth) {
        this.birthMonth = birthMonth;
    }
}

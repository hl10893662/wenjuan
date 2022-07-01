package com.eno.baozi.wenjuan.domain.basic;

import com.eno.baozi.wenjuan.common.util.ReferUtil;

import java.io.Serializable;

public class SpecialExperience implements Serializable {
    public String specialExperience1;
    public String specialExperience2;
    public String specialExperience3;
    public String specialExperience4;

    public String getSpecialExperience1() {
        return specialExperience1;
    }

    public void setSpecialExperience1(String specialExperience1) {
        this.specialExperience1 = specialExperience1;
    }

    public String getSpecialExperience2() {
        return specialExperience2;
    }

    public void setSpecialExperience2(String specialExperience2) {
        this.specialExperience2 = specialExperience2;
    }

    public String getSpecialExperience3() {
        return specialExperience3;
    }

    public void setSpecialExperience3(String specialExperience3) {
        this.specialExperience3 = specialExperience3;
    }

    public String getSpecialExperience4() {
        return specialExperience4;
    }

    public void setSpecialExperience4(String specialExperience4) {
        this.specialExperience4 = specialExperience4;
    }

    public String convertToString(){

        return ReferUtil.convertStringToString(this,"specialExperience",4);

    }
    public static SpecialExperience convertToParam(String value) {
        SpecialExperience t = new SpecialExperience();
        ReferUtil.convertStringToParam(t, "specialExperience", 4, value);
        return t;
    }
}

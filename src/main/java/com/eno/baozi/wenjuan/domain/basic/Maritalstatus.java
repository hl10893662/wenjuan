package com.eno.baozi.wenjuan.domain.basic;

import org.springframework.util.StringUtils;

public class Maritalstatus {

    public Unmarried unmarried;
    public Married married;

    public Unmarried getUnmarried() {
        return unmarried;
    }

    public void setUnmarried(Unmarried unmarried) {
        this.unmarried = unmarried;
    }

    public Married getMarried() {
        return married;
    }

    public void setMarried(Married married) {
        this.married = married;
    }

    public String convertToString() {
        return this.unmarried.convertToString()+","+this.married.convertToString();
    }
    public static Maritalstatus convertToParam(String value){
        Maritalstatus maritalstatus = new Maritalstatus();
        if (!StringUtils.isEmpty(value)){
            String[] strArr = value.split(",");
            maritalstatus.setUnmarried(Unmarried.convertToParam(strArr[0]));
            maritalstatus.setMarried(Married.convertToParam(strArr[1]));
        }
        return maritalstatus;
    }
}

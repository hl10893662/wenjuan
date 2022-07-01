package com.eno.baozi.wenjuan.domain.basic;

import com.eno.baozi.wenjuan.common.util.ReferUtil;

public class Married {
    public String married1;
    public String married2;
    public String married3;
    public String married4;
    public String married5;

    public String getMarried1() {
        return married1;
    }

    public void setMarried1(String married1) {
        this.married1 = married1;
    }

    public String getMarried2() {
        return married2;
    }

    public void setMarried2(String married2) {
        this.married2 = married2;
    }

    public String getMarried3() {
        return married3;
    }

    public void setMarried3(String married3) {
        this.married3 = married3;
    }

    public String getMarried4() {
        return married4;
    }

    public void setMarried4(String married4) {
        this.married4 = married4;
    }

    public String getMarried5() {
        return married5;
    }

    public void setMarried5(String married5) {
        this.married5 = married5;
    }

    public String convertToString(){
        return ReferUtil.convertStringToString(this,"married",5);
    }

    public static Married convertToParam(String value){
        Married married = new Married();
        ReferUtil.convertStringToParam(married,"married",5,value);
        return married;
    }
}

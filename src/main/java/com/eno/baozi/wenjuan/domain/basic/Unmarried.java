package com.eno.baozi.wenjuan.domain.basic;

import com.eno.baozi.wenjuan.common.util.ReferUtil;

public class Unmarried {
    public String unmarried1;
    public String unmarried2;
    public String unmarried3;

    public String getUnmarried1() {
        return unmarried1;
    }

    public void setUnmarried1(String unmarried1) {
        this.unmarried1 = unmarried1;
    }

    public String getUnmarried2() {
        return unmarried2;
    }

    public void setUnmarried2(String unmarried2) {
        this.unmarried2 = unmarried2;
    }

    public String getUnmarried3() {
        return unmarried3;
    }

    public void setUnmarried3(String unmarried3) {
        this.unmarried3 = unmarried3;
    }

    public String convertToString(){
        return ReferUtil.convertStringToString(this,"unmarried",3);
    }
    public static Unmarried convertToParam(String value){
        Unmarried unmarried = new Unmarried();
        ReferUtil.convertStringToParam(unmarried,"unmarried",3,value);
        return unmarried;
    }
}

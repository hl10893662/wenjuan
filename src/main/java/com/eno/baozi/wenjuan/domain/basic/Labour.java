package com.eno.baozi.wenjuan.domain.basic;

import com.eno.baozi.wenjuan.common.util.ReferUtil;

import java.io.Serializable;

public class Labour implements Serializable {
    public String labour1;
    public String labour2;
    public String labour3;

    public String getLabour1() {
        return labour1;
    }

    public void setLabour1(String labour1) {
        this.labour1 = labour1;
    }

    public String getLabour2() {
        return labour2;
    }

    public void setLabour2(String labour2) {
        this.labour2 = labour2;
    }

    public String getLabour3() {
        return labour3;
    }

    public void setLabour3(String labour3) {
        this.labour3 = labour3;
    }

    public String convertToString(){
        return ReferUtil.convertStringToString(this,"labour",3);
    }
    public static Labour convertToParam(String value) {
        Labour t = new Labour();
        ReferUtil.convertStringToParam(t, "labour", 3, value);
        return t;
    }
}

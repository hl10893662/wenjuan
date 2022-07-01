package com.eno.baozi.wenjuan.domain.basic;

import com.eno.baozi.wenjuan.common.util.ReferUtil;

import java.io.Serializable;

public class SpecialEconomic implements Serializable {
    public boolean specialEconomic1;
    public boolean specialEconomic2;
    public boolean specialEconomic3;
    public boolean specialEconomic4;

    public boolean isSpecialEconomic1() {
        return specialEconomic1;
    }

    public void setSpecialEconomic1(boolean specialEconomic1) {
        this.specialEconomic1 = specialEconomic1;
    }

    public boolean isSpecialEconomic2() {
        return specialEconomic2;
    }

    public void setSpecialEconomic2(boolean specialEconomic2) {
        this.specialEconomic2 = specialEconomic2;
    }

    public boolean isSpecialEconomic3() {
        return specialEconomic3;
    }

    public void setSpecialEconomic3(boolean specialEconomic3) {
        this.specialEconomic3 = specialEconomic3;
    }

    public boolean isSpecialEconomic4() {
        return specialEconomic4;
    }

    public void setSpecialEconomic4(boolean specialEconomic4) {
        this.specialEconomic4 = specialEconomic4;
    }
    public String convertToString(){
        return ReferUtil.convertBooleanToString(this,"specialEconomic",4);
    }
}

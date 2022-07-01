package com.eno.baozi.wenjuan.domain.basic;

import com.eno.baozi.wenjuan.common.util.ReferUtil;

import java.io.Serializable;

public class SpecialSocial implements Serializable {
    public boolean specialSocial1;
    public boolean specialSocial2;
    public boolean specialSocial3;
    public boolean specialSocial4;

    public boolean isSpecialSocial1() {
        return specialSocial1;
    }

    public void setSpecialSocial1(boolean specialSocial1) {
        this.specialSocial1 = specialSocial1;
    }

    public boolean isSpecialSocial2() {
        return specialSocial2;
    }

    public void setSpecialSocial2(boolean specialSocial2) {
        this.specialSocial2 = specialSocial2;
    }

    public boolean isSpecialSocial3() {
        return specialSocial3;
    }

    public void setSpecialSocial3(boolean specialSocial3) {
        this.specialSocial3 = specialSocial3;
    }

    public boolean isSpecialSocial4() {
        return specialSocial4;
    }

    public void setSpecialSocial4(boolean specialSocial4) {
        this.specialSocial4 = specialSocial4;
    }
    public String convertToString(){
        return ReferUtil.convertBooleanToString(this,"specialSocial",4);
    }
}

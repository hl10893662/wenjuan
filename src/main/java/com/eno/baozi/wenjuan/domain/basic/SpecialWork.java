package com.eno.baozi.wenjuan.domain.basic;

import com.eno.baozi.wenjuan.common.util.ReferUtil;

import java.io.Serializable;

public class SpecialWork implements Serializable {
    public boolean specialWork1;
    public boolean specialWork2;
    public boolean specialWork3;
    public boolean specialWork4;
    public boolean specialWork5;
    public boolean specialWork6;
    public boolean specialWork7;
    public boolean specialWork8;
    public boolean specialWork9;

    public boolean isSpecialWork1() {
        return specialWork1;
    }

    public void setSpecialWork1(boolean specialWork1) {
        this.specialWork1 = specialWork1;
    }

    public boolean isSpecialWork2() {
        return specialWork2;
    }

    public void setSpecialWork2(boolean specialWork2) {
        this.specialWork2 = specialWork2;
    }

    public boolean isSpecialWork3() {
        return specialWork3;
    }

    public void setSpecialWork3(boolean specialWork3) {
        this.specialWork3 = specialWork3;
    }

    public boolean isSpecialWork4() {
        return specialWork4;
    }

    public void setSpecialWork4(boolean specialWork4) {
        this.specialWork4 = specialWork4;
    }

    public boolean isSpecialWork5() {
        return specialWork5;
    }

    public void setSpecialWork5(boolean specialWork5) {
        this.specialWork5 = specialWork5;
    }

    public boolean isSpecialWork6() {
        return specialWork6;
    }

    public void setSpecialWork6(boolean specialWork6) {
        this.specialWork6 = specialWork6;
    }

    public boolean isSpecialWork7() {
        return specialWork7;
    }

    public void setSpecialWork7(boolean specialWork7) {
        this.specialWork7 = specialWork7;
    }

    public boolean isSpecialWork8() {
        return specialWork8;
    }

    public void setSpecialWork8(boolean specialWork8) {
        this.specialWork8 = specialWork8;
    }

    public boolean isSpecialWork9() {
        return specialWork9;
    }

    public void setSpecialWork9(boolean specialWork9) {
        this.specialWork9 = specialWork9;
    }
    public String convertToString(){
        return ReferUtil.convertBooleanToString(this,"specialWork",9);
    }
}

package com.eno.baozi.wenjuan.domain.basic;

import com.eno.baozi.wenjuan.common.util.ReferUtil;

import java.io.Serializable;

public class SpecialMarried  implements Serializable {
    public boolean specialMarried1;
    public boolean specialMarried2;
    public boolean specialMarried3;
    public boolean specialMarried4;
    public boolean specialMarried5;
    public boolean specialMarried6;
    public boolean specialMarried7;
    public boolean specialMarried8;

    public boolean isSpecialMarried1() {
        return specialMarried1;
    }

    public void setSpecialMarried1(boolean specialMarried1) {
        this.specialMarried1 = specialMarried1;
    }

    public boolean isSpecialMarried2() {
        return specialMarried2;
    }

    public void setSpecialMarried2(boolean specialMarried2) {
        this.specialMarried2 = specialMarried2;
    }

    public boolean isSpecialMarried3() {
        return specialMarried3;
    }

    public void setSpecialMarried3(boolean specialMarried3) {
        this.specialMarried3 = specialMarried3;
    }

    public boolean isSpecialMarried4() {
        return specialMarried4;
    }

    public void setSpecialMarried4(boolean specialMarried4) {
        this.specialMarried4 = specialMarried4;
    }

    public boolean isSpecialMarried5() {
        return specialMarried5;
    }

    public void setSpecialMarried5(boolean specialMarried5) {
        this.specialMarried5 = specialMarried5;
    }

    public boolean isSpecialMarried6() {
        return specialMarried6;
    }

    public void setSpecialMarried6(boolean specialMarried6) {
        this.specialMarried6 = specialMarried6;
    }

    public boolean isSpecialMarried7() {
        return specialMarried7;
    }

    public void setSpecialMarried7(boolean specialMarried7) {
        this.specialMarried7 = specialMarried7;
    }

    public boolean isSpecialMarried8() {
        return specialMarried8;
    }

    public void setSpecialMarried8(boolean specialMarried8) {
        this.specialMarried8 = specialMarried8;
    }
    public String convertToString(){
        return ReferUtil.convertBooleanToString(this,"specialMarried",8);
    }
}

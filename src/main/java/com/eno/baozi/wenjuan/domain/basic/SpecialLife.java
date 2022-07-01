package com.eno.baozi.wenjuan.domain.basic;

import com.eno.baozi.wenjuan.common.util.ReferUtil;

import java.io.Serializable;

public class SpecialLife implements Serializable {
    public boolean specialLife1;
    public boolean specialLife2;
    public boolean specialLife3;
    public boolean specialLife4;
    public boolean specialLife5;
    public boolean specialLife6;
    public boolean specialLife7;

    public boolean isSpecialLife1() {
        return specialLife1;
    }

    public void setSpecialLife1(boolean specialLife1) {
        this.specialLife1 = specialLife1;
    }

    public boolean isSpecialLife2() {
        return specialLife2;
    }

    public void setSpecialLife2(boolean specialLife2) {
        this.specialLife2 = specialLife2;
    }

    public boolean isSpecialLife3() {
        return specialLife3;
    }

    public void setSpecialLife3(boolean specialLife3) {
        this.specialLife3 = specialLife3;
    }

    public boolean isSpecialLife4() {
        return specialLife4;
    }

    public void setSpecialLife4(boolean specialLife4) {
        this.specialLife4 = specialLife4;
    }

    public boolean isSpecialLife5() {
        return specialLife5;
    }

    public void setSpecialLife5(boolean specialLife5) {
        this.specialLife5 = specialLife5;
    }

    public boolean isSpecialLife6() {
        return specialLife6;
    }

    public void setSpecialLife6(boolean specialLife6) {
        this.specialLife6 = specialLife6;
    }

    public boolean isSpecialLife7() {
        return specialLife7;
    }

    public void setSpecialLife7(boolean specialLife7) {
        this.specialLife7 = specialLife7;
    }

    public String convertToString(){
        return ReferUtil.convertBooleanToString(this,"specialLife",7);
    }
}

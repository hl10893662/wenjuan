package com.eno.baozi.wenjuan.domain.basic;

import com.eno.baozi.wenjuan.common.util.ReferUtil;

import java.io.Serializable;

public class Guilt implements Serializable {
    public String guilt1;
    public String guilt2;
    public String guilt3;
    public String guilt4;
    public String guilt5;

    public String getGuilt1() {
        return guilt1;
    }

    public void setGuilt1(String guilt1) {
        this.guilt1 = guilt1;
    }

    public String getGuilt2() {
        return guilt2;
    }

    public void setGuilt2(String guilt2) {
        this.guilt2 = guilt2;
    }

    public String getGuilt3() {
        return guilt3;
    }

    public void setGuilt3(String guilt3) {
        this.guilt3 = guilt3;
    }

    public String getGuilt4() {
        return guilt4;
    }

    public void setGuilt4(String guilt4) {
        this.guilt4 = guilt4;
    }

    public String getGuilt5() {
        return guilt5;
    }

    public void setGuilt5(String guilt5) {
        this.guilt5 = guilt5;
    }

    public String convertToString(){

        return ReferUtil.convertStringToString(this,"guilt",5);
    }
    public static Guilt convertToParam(String value){
        Guilt guilt = new Guilt();
        ReferUtil.convertStringToParam(guilt,"guilt",5,value);
        return guilt;
    }
}

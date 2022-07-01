package com.eno.baozi.wenjuan.domain.basic;

import com.eno.baozi.wenjuan.common.util.ReferUtil;

import java.io.Serializable;

public class Social implements Serializable {
    public String social1;
    public String social2;
    public String social3;

    public String getSocial1() {
        return social1;
    }

    public void setSocial1(String social1) {
        this.social1 = social1;
    }

    public String getSocial2() {
        return social2;
    }

    public void setSocial2(String social2) {
        this.social2 = social2;
    }

    public String getSocial3() {
        return social3;
    }

    public void setSocial3(String social3) {
        this.social3 = social3;
    }

    public String convertToString(){
        return ReferUtil.convertStringToString(this,"social",3);
    }
    public static Social convertToParam(String value) {
        Social t = new Social();
        ReferUtil.convertStringToParam(t, "social", 3, value);
        return t;
    }
}

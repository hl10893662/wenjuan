package com.eno.baozi.wenjuan.domain.basic;

import com.eno.baozi.wenjuan.common.util.ReferUtil;

import java.io.Serializable;

public class ParentBeat implements Serializable {
    public String parentBeat1;
    public String parentBeat2;

    public String getParentBeat1() {
        return parentBeat1;
    }

    public void setParentBeat1(String parentBeat1) {
        this.parentBeat1 = parentBeat1;
    }

    public String getParentBeat2() {
        return parentBeat2;
    }

    public void setParentBeat2(String parentBeat2) {
        this.parentBeat2 = parentBeat2;
    }
    public String convertToString(){
        return ReferUtil.convertStringToString(this,"parentBeat",2);
    }
    public static ParentBeat convertToParam(String value) {
        ParentBeat t = new ParentBeat();
        ReferUtil.convertStringToParam(t, "parentBeat", 2, value);
        return t;
    }
}

package com.eno.baozi.wenjuan.domain.basic;

import com.eno.baozi.wenjuan.common.util.ReferUtil;

import java.io.Serializable;

public class ParentHealth implements Serializable {
    public boolean parentHealth1;
    public boolean parentHealth2;
    public boolean parentHealth3;
    public boolean parentHealth4;
    public boolean parentHealth5;

    public boolean isParentHealth1() {
        return parentHealth1;
    }

    public void setParentHealth1(boolean parentHealth1) {
        this.parentHealth1 = parentHealth1;
    }

    public boolean isParentHealth2() {
        return parentHealth2;
    }

    public void setParentHealth2(boolean parentHealth2) {
        this.parentHealth2 = parentHealth2;
    }

    public boolean isParentHealth3() {
        return parentHealth3;
    }

    public void setParentHealth3(boolean parentHealth3) {
        this.parentHealth3 = parentHealth3;
    }

    public boolean isParentHealth4() {
        return parentHealth4;
    }

    public void setParentHealth4(boolean parentHealth4) {
        this.parentHealth4 = parentHealth4;
    }

    public boolean isParentHealth5() {
        return parentHealth5;
    }

    public void setParentHealth5(boolean parentHealth5) {
        this.parentHealth5 = parentHealth5;
    }

    public String convertToString(){
        return ReferUtil.convertBooleanToString(this,"parentHealth",5);
    }

}

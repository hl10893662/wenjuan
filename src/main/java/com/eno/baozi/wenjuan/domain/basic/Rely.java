package com.eno.baozi.wenjuan.domain.basic;

import com.eno.baozi.wenjuan.common.util.ReferUtil;
import com.eno.baozi.wenjuan.common.util.TyperConvert;

import java.io.Serializable;

public class Rely implements Serializable {
    public boolean rely1;
    public boolean rely2;
    public boolean rely3;
    public boolean rely4;
    public boolean rely5;
    public boolean rely6;
    public static String[] MEDICAL_HISTORY_SHOW = new String[]{"出生时早产","癫痫","脑炎","脑膜炎","脑部外伤","甲状腺机能亢进","中毒","其他"};



    public boolean isRely1() {
        return rely1;
    }

    public void setRely1(boolean rely1) {
        this.rely1 = rely1;
    }

    public boolean isRely2() {
        return rely2;
    }

    public void setRely2(boolean rely2) {
        this.rely2 = rely2;
    }

    public boolean isRely3() {
        return rely3;
    }

    public void setRely3(boolean rely3) {
        this.rely3 = rely3;
    }

    public boolean isRely4() {
        return rely4;
    }

    public void setRely4(boolean rely4) {
        this.rely4 = rely4;
    }

    public boolean isRely5() {
        return rely5;
    }

    public void setRely5(boolean rely5) {
        this.rely5 = rely5;
    }

    public boolean isRely6() {
        return rely6;
    }

    public void setRely6(boolean rely6) {
        this.rely6 = rely6;
    }
    public String convertToString(){
//        StringBuffer sb  =new StringBuffer();
//        for (int i = 1; i<=6; i++){
//            sb.append(TyperConvert.boolean2String(ReferUtil.getFieldBooleanValueByFieldName("rely"+i,this)));
//        }
//        return sb.toString();
        return ReferUtil.convertBooleanToString(this,"rely",6);
    }
}

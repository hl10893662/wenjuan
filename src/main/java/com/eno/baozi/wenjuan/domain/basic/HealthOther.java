package com.eno.baozi.wenjuan.domain.basic;

import com.eno.baozi.wenjuan.common.util.ReferUtil;
import com.eno.baozi.wenjuan.common.util.TyperConvert;

import java.io.Serializable;

public class HealthOther implements Serializable {
    public String healthOther1;
    public String healthOther2;
    public String healthOther3;

    public String getHealthOther1() {
        return healthOther1;
    }

    public void setHealthOther1(String healthOther1) {
        this.healthOther1 = healthOther1;
    }

    public String getHealthOther2() {
        return healthOther2;
    }

    public void setHealthOther2(String healthOther2) {
        this.healthOther2 = healthOther2;
    }

    public String getHealthOther3() {
        return healthOther3;
    }

    public void setHealthOther3(String healthOther3) {
        this.healthOther3 = healthOther3;
    }
    public String convertToString(){
//        StringBuffer sb  =new StringBuffer();
//        for (int i = 1; i<=3; i++){
//            sb.append(ReferUtil.getFieldValueByFieldName("healthOther"+i,this));
//        }
//        return sb.toString();
        return ReferUtil.convertStringToString(this,"healthOther",3);
    }
    public static HealthOther convertToParam(String value){
        HealthOther healthOther = new HealthOther();
        ReferUtil.convertStringToParam(healthOther,"healthOther",3,value);
        return healthOther;
    }

    public static void main(String[] args) {
        HealthOther healthOther = new HealthOther();
        healthOther.setHealthOther1("0");
        healthOther.setHealthOther2("0");
        healthOther.setHealthOther3("2");
        System.out.println(healthOther.convertToString());
    }
}

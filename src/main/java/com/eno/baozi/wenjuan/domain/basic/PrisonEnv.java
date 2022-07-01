package com.eno.baozi.wenjuan.domain.basic;

import com.eno.baozi.wenjuan.common.util.ReferUtil;

import java.io.Serializable;

public class PrisonEnv implements Serializable {
    public String prisonEnv1;
    public String prisonEnv2;
    public String prisonEnv3;
    public String prisonEnv4;
    public String prisonEnv5;
    public String prisonEnv6;

    public String getPrisonEnv1() {
        return prisonEnv1;
    }

    public void setPrisonEnv1(String prisonEnv1) {
        this.prisonEnv1 = prisonEnv1;
    }

    public String getPrisonEnv2() {
        return prisonEnv2;
    }

    public void setPrisonEnv2(String prisonEnv2) {
        this.prisonEnv2 = prisonEnv2;
    }

    public String getPrisonEnv3() {
        return prisonEnv3;
    }

    public void setPrisonEnv3(String prisonEnv3) {
        this.prisonEnv3 = prisonEnv3;
    }

    public String getPrisonEnv4() {
        return prisonEnv4;
    }

    public void setPrisonEnv4(String prisonEnv4) {
        this.prisonEnv4 = prisonEnv4;
    }

    public String getPrisonEnv5() {
        return prisonEnv5;
    }

    public void setPrisonEnv5(String prisonEnv5) {
        this.prisonEnv5 = prisonEnv5;
    }

    public String getPrisonEnv6() {
        return prisonEnv6;
    }

    public void setPrisonEnv6(String prisonEnv6) {
        this.prisonEnv6 = prisonEnv6;
    }
    public String convertToString(){
        return ReferUtil.convertStringToString(this,"prisonEnv",6);
    }


    public static PrisonEnv convertToParam(String value) {
        PrisonEnv t = new PrisonEnv();
        ReferUtil.convertStringToParam(t, "prisonEnv", 6, value);
        return t;
    }
}

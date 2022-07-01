package com.eno.baozi.wenjuan.domain.basic;

import com.eno.baozi.wenjuan.common.util.ReferUtil;

import java.io.Serializable;

public class Release implements Serializable {
    public String release1;
    public String release2;
    public String release3;

    public String getRelease1() {
        return release1;
    }

    public void setRelease1(String release1) {
        this.release1 = release1;
    }

    public String getRelease2() {
        return release2;
    }

    public void setRelease2(String release2) {
        this.release2 = release2;
    }

    public String getRelease3() {
        return release3;
    }

    public void setRelease3(String release3) {
        this.release3 = release3;
    }

    public String convertToString(){
        return ReferUtil.convertStringToString(this,"release",3);
    }

    public static Release convertToParam(String value) {
        Release t = new Release();
        ReferUtil.convertStringToParam(t, "release", 3, value);
        return t;
    }
}

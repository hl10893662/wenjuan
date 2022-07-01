package com.eno.baozi.wenjuan.domain.basic;

import com.eno.baozi.wenjuan.common.util.ReferUtil;

import java.io.Serializable;

public class BrotherHealth implements Serializable {
    public boolean brotherHealth1;
    public boolean brotherHealth2;
    public boolean brotherHealth3;

    public boolean isBrotherHealth1() {
        return brotherHealth1;
    }

    public void setBrotherHealth1(boolean brotherHealth1) {
        this.brotherHealth1 = brotherHealth1;
    }

    public boolean isBrotherHealth2() {
        return brotherHealth2;
    }

    public void setBrotherHealth2(boolean brotherHealth2) {
        this.brotherHealth2 = brotherHealth2;
    }

    public boolean isBrotherHealth3() {
        return brotherHealth3;
    }

    public void setBrotherHealth3(boolean brotherHealth3) {
        this.brotherHealth3 = brotherHealth3;
    }
    public String convertToString(){
        return ReferUtil.convertBooleanToString(this,"brotherHealth",3);
    }
}

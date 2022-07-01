package com.eno.baozi.wenjuan.domain.basic;

import com.eno.baozi.wenjuan.common.util.ReferUtil;

import java.io.Serializable;

public class EmotionExperience  implements Serializable {
    public boolean emotionExperience1;
    public boolean emotionExperience2;
    public boolean emotionExperience3;
    public boolean emotionExperience4;
    public boolean emotionExperience5;
    public boolean emotionExperience6;
    public boolean emotionExperience7;
    public boolean emotionExperience8;
    public boolean emotionExperience9;
    public boolean emotionExperience10;
    public boolean emotionExperience11;
    public boolean emotionExperience12;

    public boolean isEmotionExperience1() {
        return emotionExperience1;
    }

    public void setEmotionExperience1(boolean emotionExperience1) {
        this.emotionExperience1 = emotionExperience1;
    }

    public boolean isEmotionExperience2() {
        return emotionExperience2;
    }

    public void setEmotionExperience2(boolean emotionExperience2) {
        this.emotionExperience2 = emotionExperience2;
    }

    public boolean isEmotionExperience3() {
        return emotionExperience3;
    }

    public void setEmotionExperience3(boolean emotionExperience3) {
        this.emotionExperience3 = emotionExperience3;
    }

    public boolean isEmotionExperience4() {
        return emotionExperience4;
    }

    public void setEmotionExperience4(boolean emotionExperience4) {
        this.emotionExperience4 = emotionExperience4;
    }

    public boolean isEmotionExperience5() {
        return emotionExperience5;
    }

    public void setEmotionExperience5(boolean emotionExperience5) {
        this.emotionExperience5 = emotionExperience5;
    }

    public boolean isEmotionExperience6() {
        return emotionExperience6;
    }

    public void setEmotionExperience6(boolean emotionExperience6) {
        this.emotionExperience6 = emotionExperience6;
    }

    public boolean isEmotionExperience7() {
        return emotionExperience7;
    }

    public void setEmotionExperience7(boolean emotionExperience7) {
        this.emotionExperience7 = emotionExperience7;
    }

    public boolean isEmotionExperience8() {
        return emotionExperience8;
    }

    public void setEmotionExperience8(boolean emotionExperience8) {
        this.emotionExperience8 = emotionExperience8;
    }

    public boolean isEmotionExperience9() {
        return emotionExperience9;
    }

    public void setEmotionExperience9(boolean emotionExperience9) {
        this.emotionExperience9 = emotionExperience9;
    }

    public boolean isEmotionExperience10() {
        return emotionExperience10;
    }

    public void setEmotionExperience10(boolean emotionExperience10) {
        this.emotionExperience10 = emotionExperience10;
    }

    public boolean isEmotionExperience11() {
        return emotionExperience11;
    }

    public void setEmotionExperience11(boolean emotionExperience11) {
        this.emotionExperience11 = emotionExperience11;
    }

    public boolean isEmotionExperience12() {
        return emotionExperience12;
    }

    public void setEmotionExperience12(boolean emotionExperience12) {
        this.emotionExperience12 = emotionExperience12;
    }
    public String convertToString(){
        return ReferUtil.convertBooleanToString(this,"emotionExperience",12);
    }
}

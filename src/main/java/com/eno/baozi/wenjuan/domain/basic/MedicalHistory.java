package com.eno.baozi.wenjuan.domain.basic;

import com.eno.baozi.wenjuan.common.util.ReferUtil;
import com.eno.baozi.wenjuan.common.util.TyperConvert;

import java.io.Serializable;

public class MedicalHistory implements Serializable {
    public boolean medicalHistory1;
    public boolean medicalHistory2;
    public boolean medicalHistory3;
    public boolean medicalHistory4;
    public boolean medicalHistory5;
    public boolean medicalHistory6;
    public boolean medicalHistory7;
    public boolean medicalHistory8;



    public boolean isMedicalHistory1() {
        return medicalHistory1;
    }

    public void setMedicalHistory1(boolean medicalHistory1) {
        this.medicalHistory1 = medicalHistory1;
    }

    public boolean isMedicalHistory2() {
        return medicalHistory2;
    }

    public void setMedicalHistory2(boolean medicalHistory2) {
        this.medicalHistory2 = medicalHistory2;
    }

    public boolean isMedicalHistory3() {
        return medicalHistory3;
    }

    public void setMedicalHistory3(boolean medicalHistory3) {
        this.medicalHistory3 = medicalHistory3;
    }

    public boolean isMedicalHistory4() {
        return medicalHistory4;
    }

    public void setMedicalHistory4(boolean medicalHistory4) {
        this.medicalHistory4 = medicalHistory4;
    }

    public boolean isMedicalHistory5() {
        return medicalHistory5;
    }

    public void setMedicalHistory5(boolean medicalHistory5) {
        this.medicalHistory5 = medicalHistory5;
    }

    public boolean isMedicalHistory6() {
        return medicalHistory6;
    }

    public void setMedicalHistory6(boolean medicalHistory6) {
        this.medicalHistory6 = medicalHistory6;
    }

    public boolean isMedicalHistory7() {
        return medicalHistory7;
    }

    public void setMedicalHistory7(boolean medicalHistory7) {
        this.medicalHistory7 = medicalHistory7;
    }

    public boolean isMedicalHistory8() {
        return medicalHistory8;
    }

    public void setMedicalHistory8(boolean medicalHistory8) {
        this.medicalHistory8 = medicalHistory8;
    }

    public String convertToString(){
//        StringBuffer sb  =new StringBuffer();
//        for (int i = 1; i<=8; i++){
//            sb.append(TyperConvert.boolean2String(ReferUtil.getFieldBooleanValueByFieldName("medicalHistory"+i,this)));
//        }
//        return sb.toString();
        return ReferUtil.convertBooleanToString(this,"medicalHistory",8);

    }
//    public String convertToShow(String medicalHistoryStr){
//        StringBuffer sb = new StringBuffer();
//        for (int i = 0; i<Math.min(medicalHistoryStr.length(),MEDICAL_HISTORY_SHOW.length); i++){
//            sb.append(MEDICAL_HISTORY_SHOW[i]).append("、");
//        }
//
//        return sb.toString();
//    }

    public static void main(String[] args) {
        MedicalHistory medicalHistory = new MedicalHistory();
        medicalHistory.setMedicalHistory1(false);
        medicalHistory.setMedicalHistory2(true);
        medicalHistory.setMedicalHistory3(false);
        medicalHistory.setMedicalHistory4(false);
        medicalHistory.setMedicalHistory5(true);
        medicalHistory.setMedicalHistory6(false);
        medicalHistory.setMedicalHistory7(false);
        medicalHistory.setMedicalHistory8(false);
        System.out.println(medicalHistory.convertToString());
    }
}

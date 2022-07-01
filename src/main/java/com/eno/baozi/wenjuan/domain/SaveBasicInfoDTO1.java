package com.eno.baozi.wenjuan.domain;

import com.eno.baozi.wenjuan.domain.basic.*;
import io.swagger.annotations.ApiModel;

import java.io.Serializable;
import java.util.List;


@ApiModel(value="个人信息具体内容")
public class SaveBasicInfoDTO1 implements Serializable {
    public String name;
    public String no;
    public String birthMonth;
    public String ethnicity;
    public String crime;
    public String imprisonDate;
    public String imprisonStartAndEnd;
    public String crimeInfo;
    //犯罪经历
    public String crimeType;
    public List<CrimeHistory> crimeHistory;
    public String economicStatus;
    public String belief;
//    public MedicalHistory medicalHistory;
    public String[] medicalHistory;
    public String health;
    public String[] defect;
//    public Rely rely;
    public String[] rely;
    public HealthOther healthOther;
    public Guilt guilt;
    public List<GrowupInfo> growupInfo;
    public String dropOptionValue;

//    public ParentHealth parentHealth;
    public String[] parentHealth;
//    public BrotherHealth brotherHealth;
    public String[] brotherHealth;
    public ParentBeat parentBeat;
    public List<WorkInfo> workInfo;
    public SpecialExperience specialExperience;
//    public SpecialFamily specialFamily;
    public String[] specialFamily;
//    public SpecialMarried specialMarried;
    public String[] specialMarried;
//    public SpecialWork specialWork;
//    public SpecialLife specialLife;
//    public SpecialEconomic specialEconomic;
//    public SpecialSocial specialSocial;
    public String[] specialWork;
    public String[] specialLife;
    public String[] specialEconomic;
    public String[] specialSocial;

    public String remark1;
    public String remark2;
    public String remark3;
    public String remark4;
    public String remark5;
    public String remark6;
    public String remark7;
    public String remark8;
    public String remark9;
    public String remark10;
    public String remark11;
    public String remark12;
    public String remark13;


    public String getRemark13() {
        return remark13;
    }

    public void setRemark13(String remark13) {
        this.remark13 = remark13;
    }

    public String getRemark1() {
        return remark1;
    }

    public void setRemark1(String remark1) {
        this.remark1 = remark1;
    }

    public String getRemark2() {
        return remark2;
    }

    public void setRemark2(String remark2) {
        this.remark2 = remark2;
    }

    public String getRemark3() {
        return remark3;
    }

    public void setRemark3(String remark3) {
        this.remark3 = remark3;
    }

    public String getRemark4() {
        return remark4;
    }

    public void setRemark4(String remark4) {
        this.remark4 = remark4;
    }

    public String getRemark5() {
        return remark5;
    }

    public void setRemark5(String remark5) {
        this.remark5 = remark5;
    }

    public String getRemark6() {
        return remark6;
    }

    public void setRemark6(String remark6) {
        this.remark6 = remark6;
    }

    public String getRemark7() {
        return remark7;
    }

    public void setRemark7(String remark7) {
        this.remark7 = remark7;
    }

    public String getRemark8() {
        return remark8;
    }

    public void setRemark8(String remark8) {
        this.remark8 = remark8;
    }

    public String getRemark9() {
        return remark9;
    }

    public void setRemark9(String remark9) {
        this.remark9 = remark9;
    }

    public String getRemark10() {
        return remark10;
    }

    public void setRemark10(String remark10) {
        this.remark10 = remark10;
    }

    public String getRemark11() {
        return remark11;
    }

    public void setRemark11(String remark11) {
        this.remark11 = remark11;
    }

    public String getRemark12() {
        return remark12;
    }

    public void setRemark12(String remark12) {
        this.remark12 = remark12;
    }

    public TransformExperience transformExperience;
//    public EmotionExperience emotionExperience;
    public String[] emotionExperience;

    public Maritalstatus maritalstatus;
    public List<FamilyStatus> familyStatus;

    public List<WorkInfo> getWorkInfo() {
        return workInfo;
    }

    public void setWorkInfo(List<WorkInfo> workInfo) {
        this.workInfo = workInfo;
    }

//    public List<SocialStatus> socialStatus;
    public String drop;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getBirthMonth() {
        return birthMonth;
    }

    public void setBirthMonth(String birthMonth) {
        this.birthMonth = birthMonth;
    }

    public String getEthnicity() {
        return ethnicity;
    }

    public void setEthnicity(String ethnicity) {
        this.ethnicity = ethnicity;
    }

    public String getCrime() {
        return crime;
    }

    public void setCrime(String crime) {
        this.crime = crime;
    }

    public String getImprisonDate() {
        return imprisonDate;
    }

    public void setImprisonDate(String imprisonDate) {
        this.imprisonDate = imprisonDate;
    }

    public String getImprisonStartAndEnd() {
        return imprisonStartAndEnd;
    }

    public void setImprisonStartAndEnd(String imprisonStartAndEnd) {
        this.imprisonStartAndEnd = imprisonStartAndEnd;
    }

    public String getCrimeInfo() {
        return crimeInfo;
    }

    public void setCrimeInfo(String crimeInfo) {
        this.crimeInfo = crimeInfo;
    }


    public List<CrimeHistory> getCrimeHistory() {
        return crimeHistory;
    }

    public void setCrimeHistory(List<CrimeHistory> crimeHistory) {
        this.crimeHistory = crimeHistory;
    }

    public String getEconomicStatus() {
        return economicStatus;
    }

    public void setEconomicStatus(String economicStatus) {
        this.economicStatus = economicStatus;
    }

    public String getBelief() {
        return belief;
    }

    public void setBelief(String belief) {
        this.belief = belief;
    }


    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public String[] getDefect() {
        return defect;
    }

    public void setDefect(String[] defect) {
        this.defect = defect;
    }

    public HealthOther getHealthOther() {
        return healthOther;
    }

    public void setHealthOther(HealthOther healthOther) {
        this.healthOther = healthOther;
    }

    public Guilt getGuilt() {
        return guilt;
    }

    public void setGuilt(Guilt guilt) {
        this.guilt = guilt;
    }

    public List<GrowupInfo> getGrowupInfo() {
        return growupInfo;
    }

    public void setGrowupInfo(List<GrowupInfo> growupInfo) {
        this.growupInfo = growupInfo;
    }

    public String getDropOptionValue() {
        return dropOptionValue;
    }

    public void setDropOptionValue(String dropOptionValue) {
        this.dropOptionValue = dropOptionValue;
    }

    public String[] getParentHealth() {
        return parentHealth;
    }

    public void setParentHealth(String[] parentHealth) {
        this.parentHealth = parentHealth;
    }

    public String[] getBrotherHealth() {
        return brotherHealth;
    }

    public void setBrotherHealth(String[] brotherHealth) {
        this.brotherHealth = brotherHealth;
    }

    public ParentBeat getParentBeat() {
        return parentBeat;
    }

    public void setParentBeat(ParentBeat parentBeat) {
        this.parentBeat = parentBeat;
    }



    public SpecialExperience getSpecialExperience() {
        return specialExperience;
    }

    public void setSpecialExperience(SpecialExperience specialExperience) {
        this.specialExperience = specialExperience;
    }


    public TransformExperience getTransformExperience() {
        return transformExperience;
    }

    public void setTransformExperience(TransformExperience transformExperience) {
        this.transformExperience = transformExperience;
    }

    public String[] getEmotionExperience() {
        return emotionExperience;
    }

    public void setEmotionExperience(String[] emotionExperience) {
        this.emotionExperience = emotionExperience;
    }

    public Maritalstatus getMaritalstatus() {
        return maritalstatus;
    }

    public void setMaritalstatus(Maritalstatus maritalstatus) {
        this.maritalstatus = maritalstatus;
    }

    public List<FamilyStatus> getFamilyStatus() {
        return familyStatus;
    }

    public void setFamilyStatus(List<FamilyStatus> familyStatus) {
        this.familyStatus = familyStatus;
    }

    public String getDrop() {
        return drop;
    }

    public void setDrop(String drop) {
        this.drop = drop;
    }

    public String getCrimeType() {
        return crimeType;
    }

    public void setCrimeType(String crimeType) {
        this.crimeType = crimeType;
    }

    public String[] getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(String[] medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public String[] getRely() {
        return rely;
    }

    public void setRely(String[] rely) {
        this.rely = rely;
    }

    public String[] getSpecialFamily() {
        return specialFamily;
    }

    public void setSpecialFamily(String[] specialFamily) {
        this.specialFamily = specialFamily;
    }

    public String[] getSpecialMarried() {
        return specialMarried;
    }

    public void setSpecialMarried(String[] specialMarried) {
        this.specialMarried = specialMarried;
    }

    public String[] getSpecialWork() {
        return specialWork;
    }

    public void setSpecialWork(String[] specialWork) {
        this.specialWork = specialWork;
    }

    public String[] getSpecialLife() {
        return specialLife;
    }

    public void setSpecialLife(String[] specialLife) {
        this.specialLife = specialLife;
    }

    public String[] getSpecialEconomic() {
        return specialEconomic;
    }

    public void setSpecialEconomic(String[] specialEconomic) {
        this.specialEconomic = specialEconomic;
    }

    public String[] getSpecialSocial() {
        return specialSocial;
    }

    public void setSpecialSocial(String[] specialSocial) {
        this.specialSocial = specialSocial;
    }
}

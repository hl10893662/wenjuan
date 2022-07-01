package com.eno.baozi.wenjuan.domain;

import com.eno.baozi.wenjuan.domain.basic.*;
import io.swagger.annotations.ApiModel;

import java.io.Serializable;
import java.util.List;


@ApiModel(value="个人信息具体内容")
public class SaveBasicInfoDTO implements Serializable {
    public String name;
    public String no;
    public String birthMonth;
    public String ethnicity;
    public String crime;
    public String imprisonDate;
    public String imprisonStartAndEnd;
    public String crimeInfo;
    public boolean crimeType1;
    public boolean crimeType2;
    public boolean crimeType3;
    public List<CrimeHistory> crimeHistory;
    public String economicStatus;
    public String belief;
    public MedicalHistory medicalHistory;
    public String health;
    public String defect;
    public Rely rely;
    public HealthOther healthOther;
    public Guilt guilt;
    public List<GrowupInfo> growupInfo;
    public String dropOptionValue;

    public ParentHealth parentHealth;
    public BrotherHealth brotherHealth;
    public ParentBeat parentBeat;
    public List<WorkInfo> workInfo;
    public SpecialExperience specialExperience;
    public SpecialFamily specialFamily;
    public SpecialMarried specialMarried;
    public SpecialWork specialWork;
    public SpecialLife specialLife;
    public SpecialEconomic specialEconomic;
    public SpecialSocial specialSocial;
    public TransformExperience transformExperience;
    public EmotionExperience emotionExperience;
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

    public boolean isCrimeType1() {
        return crimeType1;
    }

    public void setCrimeType1(boolean crimeType1) {
        this.crimeType1 = crimeType1;
    }

    public boolean isCrimeType2() {
        return crimeType2;
    }

    public void setCrimeType2(boolean crimeType2) {
        this.crimeType2 = crimeType2;
    }

    public boolean isCrimeType3() {
        return crimeType3;
    }

    public void setCrimeType3(boolean crimeType3) {
        this.crimeType3 = crimeType3;
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

    public MedicalHistory getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(MedicalHistory medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public String getDefect() {
        return defect;
    }

    public void setDefect(String defect) {
        this.defect = defect;
    }

    public Rely getRely() {
        return rely;
    }

    public void setRely(Rely rely) {
        this.rely = rely;
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

    public ParentHealth getParentHealth() {
        return parentHealth;
    }

    public void setParentHealth(ParentHealth parentHealth) {
        this.parentHealth = parentHealth;
    }

    public BrotherHealth getBrotherHealth() {
        return brotherHealth;
    }

    public void setBrotherHealth(BrotherHealth brotherHealth) {
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

    public SpecialFamily getSpecialFamily() {
        return specialFamily;
    }

    public void setSpecialFamily(SpecialFamily specialFamily) {
        this.specialFamily = specialFamily;
    }

    public SpecialMarried getSpecialMarried() {
        return specialMarried;
    }

    public void setSpecialMarried(SpecialMarried specialMarried) {
        this.specialMarried = specialMarried;
    }

    public SpecialWork getSpecialWork() {
        return specialWork;
    }

    public void setSpecialWork(SpecialWork specialWork) {
        this.specialWork = specialWork;
    }

    public SpecialLife getSpecialLife() {
        return specialLife;
    }

    public void setSpecialLife(SpecialLife specialLife) {
        this.specialLife = specialLife;
    }

    public SpecialEconomic getSpecialEconomic() {
        return specialEconomic;
    }

    public void setSpecialEconomic(SpecialEconomic specialEconomic) {
        this.specialEconomic = specialEconomic;
    }

    public TransformExperience getTransformExperience() {
        return transformExperience;
    }

    public void setTransformExperience(TransformExperience transformExperience) {
        this.transformExperience = transformExperience;
    }

    public EmotionExperience getEmotionExperience() {
        return emotionExperience;
    }

    public void setEmotionExperience(EmotionExperience emotionExperience) {
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

//    public List<SocialStatus> getSocialStatus() {
//        return socialStatus;
//    }
//
//    public void setSocialStatus(List<SocialStatus> socialStatus) {
//        this.socialStatus = socialStatus;
//    }

    public String getDrop() {
        return drop;
    }

    public void setDrop(String drop) {
        this.drop = drop;
    }

    public SpecialSocial getSpecialSocial() {
        return specialSocial;
    }

    public void setSpecialSocial(SpecialSocial specialSocial) {
        this.specialSocial = specialSocial;
    }
}

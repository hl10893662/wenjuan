package com.eno.baozi.wenjuan.domain;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import static org.junit.Assert.*;

public class SaveBasicInfoDTO1Test {

    @Test
    public void jsonToObject() {
        String  jsonStr = "{\"name\":\"1\",\"no\":\"2\",\"birthMonth\":\"3\",\"ethnicity\":\"4\",\"crime\":\"5\",\"imprisonDate\":\"6\",\"imprisonStartAndEnd\":\"7\",\"crimeInfo\":\"8\",\"crimeType\":\"累犯\",\"crimeHistory\":[{\"order\":1,\"name\":\"9\",\"imprisonDate\":\"10\",\"imprisonStartAndEnd\":\"11\",\"address\":\"12\",\"commutation\":\"13\"}],\"economicStatus\":\"14\",\"belief\":\"15\",\"medicalHistory\":[\"出生时早产\",\"癫痫\",\"脑膜炎\",\"其他\",\"中毒\",\"脑部外伤\"],\"health\":\"0\",\"defect\":\"16\",\"rely\":[\"毒品\",\"上网\",\"赌博\",\"其他\"],\"healthOther\":{\"healthOther1\":\"1\",\"healthOther2\":\"1\",\"healthOther3\":\"1\"},\"guilt\":{\"guilt1\":\"1\",\"guilt2\":\"2\",\"guilt3\":\"1\",\"guilt4\":\"1\",\"guilt5\":\"1\"},\"growupInfo\":[{\"stage\":\"1-6岁（幼年时期）\",\"training\":\"1\",\"feeling\":\"1\"},{\"stage\":\"7-12岁（小学时期）\",\"training\":\"1\",\"feeling\":\"1\"},{\"stage\":\"13-15岁（初中时期）\",\"training\":\"1\",\"feeling\":\"1\"},{\"stage\":\"16-18岁（高中时期） \",\"training\":\"1\",\"feeling\":\"1\"},{\"stage\":\"18岁以上（大学时期）\",\"training\":\"1\",\"feeling\":\"1\"}],\"drop\":\"1\",\"parentHealth\":[\"正常\"],\"brotherHealth\":[\"正常\"],\"parentBeat\":{\"parentBeat1\":\"1\",\"parentBeat2\":\"1\"},\"workInfo\":[{\"stage\":\"工作1\",\"occupation\":\"1\",\"feeling\":\"1\",\"workyear\":\"1\"}],\"specialExperience\":{\"specialExperience1\":\"1\",\"specialExperience2\":\"1\",\"specialExperience3\":\"1\",\"specialExperience4\":\"1\"},\"specialFamily\":[\"子女死亡\"],\"specialMarried\":[\"结婚\"],\"specialWork\":[\"失业\"],\"specialLife\":[\"受到惊吓\"],\"specialEconomic\":[\"遭受财产损失\"],\"specialSocial\":[\"好友去世\"],\"transformExperience\":{\"prisonEnv\":{\"prisonEnv1\":\"1\",\"prisonEnv2\":\"1\",\"prisonEnv3\":\"1\",\"prisonEnv4\":\"1\",\"prisonEnv5\":\"1\",\"prisonEnv6\":\"1\"},\"social\":{\"social1\":\"1\",\"social2\":\"1\",\"social3\":\"1\"},\"labour\":{\"labour1\":\"1\",\"labour2\":\"1\",\"labour3\":\"1\"},\"release\":{\"release1\":\"1\",\"release2\":\"1\",\"release3\":\"1\"}},\"emotionExperience\":[\"离婚\"],\"maritalstatus\":{\"unmarried\":{\"unmarried1\":\"1\",\"unmarried2\":\"1\",\"unmarried3\":\"1\"},\"married\":{\"married1\":\"1\",\"married2\":\"1\",\"married3\":\"1\",\"married4\":\"1\",\"married5\":\"1\"}},\"familyStatus\":[{\"stage\":\"1\",\"name\":\"17\",\"relation\":\"18\",\"feeling\":\"1\"}]}";
        SaveBasicInfoDTO1 dto = new SaveBasicInfoDTO1();
        dto = JSON.parseObject(jsonStr,SaveBasicInfoDTO1.class);
        System.out.println();
    }
}

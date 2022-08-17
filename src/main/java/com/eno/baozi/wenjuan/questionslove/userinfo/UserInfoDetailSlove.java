package com.eno.baozi.wenjuan.questionslove.userinfo;

import com.eno.baozi.wenjuan.domain.OutlineQuestionByUserInfoDTO;
import com.eno.baozi.wenjuan.domain.SaveBasicInfoDTO1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserInfoDetailSlove {
    public static Map<Integer,OutlineQuestionByUserInfoDTO> sloveUserInfo2SaveBasicInfoDTO1(SaveBasicInfoDTO1 dto){
        Map<Integer,OutlineQuestionByUserInfoDTO> map  = new HashMap<>();
        String conomicStatus = dto.getEconomicStatus();
        map.put(1,slove(1,1,conomicStatus));
        map.put(2,slove(1,2,dto.getBelief()));
        map.put(3,slove(2,3,dto.getMedicalHistory().toString()));
        map.put(6,slove(2,6,dto.getRely().toString()));
        map.put(7,slove(2,7,dto.getHealthOther().getHealthOther1()));
        map.put(8,slove(2,8,dto.getHealthOther().getHealthOther2()));
        map.put(9,slove(2,9,dto.getHealthOther().getHealthOther3()));
        map.put(10,slove(3,10,dto.getGuilt().getGuilt1()));
        map.put(11,slove(3,11,dto.getGuilt().getGuilt2()));
        map.put(14,slove(3,14,dto.getGuilt().getGuilt5()));
        map.put(20,slove(4,20,dto.getDrop()));
        map.put(21,slove(4,21,dto.getParentHealth().toString()));
        map.put(22,slove(4,22,dto.getBrotherHealth().toString()));
        map.put(23,slove(4,23,dto.getParentBeat().getParentBeat1()));
        map.put(24,slove(4,24,dto.getParentBeat().getParentBeat2()));
        map.put(25,slove(5,25,""));
        map.put(28,slove(6,28,dto.getSpecialExperience().getSpecialExperience3()));
        map.put(29,slove(6,29,dto.getSpecialExperience().getSpecialExperience4()));
        map.put(30,slove(7,30,dto.getSpecialFamily().toString()));
        map.put(31,slove(7,31,dto.getSpecialMarried().toString()));
        map.put(32,slove(7,32,dto.getSpecialWork().toString()));
        map.put(33,slove(7,33,dto.getSpecialLife().toString()));
        map.put(34,slove(7,34,dto.getSpecialEconomic().toString()));
        map.put(35,slove(7,35,dto.getSpecialSocial().toString()));
        map.put(51,slove(9,51,dto.getEmotionExperience().toString()));
        map.put(54,slove(10,54,dto.getMaritalstatus().getUnmarried().getUnmarried3()));
        map.put(56,slove(10,56,dto.getMaritalstatus().getMarried().getMarried2()));
        map.put(59,slove(10,59,dto.getMaritalstatus().getMarried().getMarried5()));
        return map;
    }

    private static OutlineQuestionByUserInfoDTO slove(int mainNo,int subNo,String result){
        OutlineQuestionByUserInfoDTO outlineQuestionByUserInfoDTO = new OutlineQuestionByUserInfoDTO();
        return outlineQuestionByUserInfoDTO;
    }
}

package com.eno.baozi.wenjuan.service.impl;

import com.eno.baozi.wenjuan.common.util.TyperConvert;
import com.eno.baozi.wenjuan.dao.OutlineQuestionMapper;
import com.eno.baozi.wenjuan.dao.UserInfoMapper;
import com.eno.baozi.wenjuan.domain.*;
import com.eno.baozi.wenjuan.questionslove.userinfo.UserInfoDetailSlove;
import com.eno.baozi.wenjuan.service.IOutlineQuestionService;
import com.eno.baozi.wenjuan.service.IQuestionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Primary
public class OutlineQuestionServiceImpl implements IOutlineQuestionService {
    private final Logger logger = LoggerFactory.getLogger(OutlineQuestionServiceImpl.class);

    @Autowired
    OutlineQuestionMapper outlineQuestionMapper;

    @Autowired
    IQuestionService questionService;

    @Autowired
    UserInfoMapper userInfoMapper;

    @Override
    public OutLineQuestionMain queryOutLineQuestion(CriminalInfo criminalInfo) {
        OutLineQuestionMain outLineQuestionMain = new OutLineQuestionMain();
        UserInfoDetail userInfoDetail = questionService.queryUserBasicInfoDetail(criminalInfo);

        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(criminalInfo.getNo());

        PersonalInfo personalInfo = new PersonalInfo();
        personalInfo.setName(userInfo.getName());
        personalInfo.setNo(criminalInfo.getNo());
        personalInfo.setAddress(userInfo.getAddress());
        personalInfo.setBelief(userInfoDetail.getBelief());
        personalInfo.setBirthMonth(userInfoDetail.getBirthmonth());
        personalInfo.setCrime(userInfo.getCrime());
        personalInfo.setEconomic(userInfoDetail.getEconomicStatus());
        personalInfo.setEducation("");
        personalInfo.setImprisonDate(TyperConvert.dateToString(userInfo.getImprisonBegin()));


        SaveBasicInfoDTO1 dto = questionService.userDetail2SaveBasicInfoDTO1(userInfoDetail);
        Map<Integer,OutlineQuestionByUserInfoDTO> outlineQuestionByUserInfoDTOMap =
                UserInfoDetailSlove.sloveUserInfo2SaveBasicInfoDTO1(dto);

        List<OutlineQuestion> outlineQuestionList = outlineQuestionMapper.selectByStatus(1);
        Map<String,List<String>> outlineQuestionDetailMap = new HashMap<>();
        Map<String,List<String>> outlineQuestionDetailMap1 = new HashMap<>();
        for (OutlineQuestion outlineQuestion : outlineQuestionList){
            OutlineQuestionByUserInfoDTO outlineQuestionByUserInfoDTO =
                    outlineQuestionByUserInfoDTOMap.get(outlineQuestion.getTemplateSubNo());
            if (isContainInfo(outlineQuestionByUserInfoDTO.getResult(),outlineQuestion.getClazzName(),outlineQuestion.getNotInClazz())){
                List<String> detailList = new ArrayList<>();
                List<String> detailList1 = new ArrayList<>();
                if (outlineQuestionDetailMap.get(outlineQuestion.getDivisionName()) != null){
                    detailList = outlineQuestionDetailMap.get(outlineQuestion.getDivisionName());
                }
                if (!StringUtils.isEmpty(outlineQuestion.getPreinstallQuestion())){
                    detailList.add(outlineQuestion.getPreinstallQuestion());
                }
//                if (!StringUtils.isEmpty(outlineQuestion.getCheckQuestion())){
//                    detailList.add(outlineQuestion.getCheckQuestion());
//                }
                outlineQuestionDetailMap.put(outlineQuestion.getDivisionName(),detailList);



                if (outlineQuestionDetailMap1.get(outlineQuestion.getDivisionName()) != null){
                    detailList1 = outlineQuestionDetailMap1.get(outlineQuestion.getDivisionName());
                }
                if (!StringUtils.isEmpty(outlineQuestion.getCheckQuestion())){
                    detailList1.add(outlineQuestion.getCheckQuestion());
                }
//                if (!StringUtils.isEmpty(outlineQuestion.getCheckQuestion())){
//                    detailList1.add(outlineQuestion.getCheckQuestion());
//                }
                outlineQuestionDetailMap1.put(outlineQuestion.getDivisionName(),detailList1);
            }
        }
//        outLineQuestionMain.setQuestionMap(outlineQuestionDetailMap);
        List<OutlineQuestionSub> outlineQuestionSubList = new ArrayList<>();
//        outlineQuestionDetailMap.forEach((k, v) ->{
//                    v = v.stream().distinct().collect(Collectors.toList());
//                    OutlineQuestionSub outlineQuestionSub = new OutlineQuestionSub();
//                    StringBuffer sb = new StringBuffer();
//                    v.stream().forEach(str ->sb.append(str).append("\n"));
//                    outlineQuestionSub.setQuestionDetail(sb.toString());
//                    outlineQuestionSub.setQuestiontype(k);
//                    outlineQuestionSubList.add(outlineQuestionSub);
//
//                }
//            );

        outlineQuestionDetailMap.forEach((k, v) ->{
                    v = v.stream().distinct().collect(Collectors.toList());
                    OutlineQuestionSub outlineQuestionSub = new OutlineQuestionSub();

                    StringBuffer sb = new StringBuffer();
                    for (int i = 1; i<=v.size(); i++){
                        sb.append(i+"、").append(v.get(i-1)).append("</br>");
                    }
                    outlineQuestionSub.setQuestionDetail(sb.toString());
                    outlineQuestionSub.setQuestiontype(k);

                    List<String> question1List = outlineQuestionDetailMap1.get(k);
                    if (question1List != null && question1List.size()>0){
                        StringBuffer sb1 = new StringBuffer();

                        for (int i = 1; i<=question1List.size(); i++){
                            sb1.append(i+"、").append(question1List.get(i-1)).append("</br>");
                        }
                        outlineQuestionSub.setQuestionDetail1(sb1.toString());
                    }

                     outlineQuestionSubList.add(outlineQuestionSub);
                }
        );

        outLineQuestionMain.setQuestionDetailList(outlineQuestionSubList);
        outLineQuestionMain.setPersonalInfo(personalInfo);
        return outLineQuestionMain;
    }

    private boolean isContainInfo(String result,String keyword,int flag){
        if(StringUtils.isEmpty(keyword)){
            return true;
        }
        if (flag == 1){
            if(!StringUtils.isEmpty(result) && result.contains(keyword)){
                return true;
            }
            return false;
        }else{
            if(StringUtils.isEmpty(result) || !result.contains(keyword)){
                return true;
            }
            return false;
        }

    }
}

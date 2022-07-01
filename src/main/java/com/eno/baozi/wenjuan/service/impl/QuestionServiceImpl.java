package com.eno.baozi.wenjuan.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.TypeReference;
import com.eno.baozi.wenjuan.common.domain.BusinessException;
import com.eno.baozi.wenjuan.common.util.JsonUtil;
import com.eno.baozi.wenjuan.common.util.ReferUtil;
import com.eno.baozi.wenjuan.common.util.ShowConvert;
import com.eno.baozi.wenjuan.common.util.TyperConvert;
import com.eno.baozi.wenjuan.dao.*;
import com.eno.baozi.wenjuan.domain.*;
import com.eno.baozi.wenjuan.domain.basic.*;
import com.eno.baozi.wenjuan.questionslove.copa.COPA;
import com.eno.baozi.wenjuan.questionslove.faceproblem.FaceProblem;
import com.eno.baozi.wenjuan.questionslove.personality.Personality;
import com.eno.baozi.wenjuan.service.IQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.*;

@Service
@Primary
public class QuestionServiceImpl implements IQuestionService {

    @Resource
    QuestionResultMapper questionResultMapper;

    @Resource
    UserInfoMapper userInfoMapper;

    @Resource
    UserInfoDetailMapper userInfoDetailMapper;

    @Resource
    QuestionMapper questionMapper;

    @Resource
    UserInfoTemplateMapper userInfoTemplateMapper;


    @Override
    public void saveQuestionResult(QuestionResultDTO questionResultDTO) throws BusinessException {

        //判断用户是否存在
        String criminalNo = questionResultDTO.getCirminalNo();
        UserInfo userInfo =  userInfoMapper.selectByPrimaryKey(criminalNo);
        if (userInfo == null){
            throw new BusinessException("学员不存在，请检查学员信息");
        }
//        if (questionResultDTO.getCirminalName() == null ||
//                !questionResultDTO.getCirminalName().equals(userInfo.getName())){
//            throw new BusinessException("学员编号与姓名不匹配，请检查输入信息");
//        }

        QuestionResult questionResult = new QuestionResult();
        questionResult.setQuestionNo(questionResultDTO.getQuestionNo());
        questionResult.setResult(questionResultDTO.getResult());
        questionResult.setCriminalName(userInfo.getName());
        questionResult.setCriminalId(questionResultDTO.getCirminalNo());
        questionResult.setCreateTime(new Date());
        questionResultMapper.insert(questionResult);
    }

    @Override
    public QuestionResultMain queryReport(CriminalInfo criminalInfo) {
        QuestionResultMain  main = new QuestionResultMain();
        for (int i = 1; i<=3; i ++){
            QuestionResultSub  sub = new QuestionResultSub();
                    main.addQuestionResultDesc("Q"+i,buildReportByQuestionNo(criminalInfo,i+""));
        }
        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(criminalInfo.getNo());
        UserInfoDetail userInfoDetail = userInfoDetailMapper.selectByPrimaryKey(criminalInfo.getNo());

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


        HealthShow health = new HealthShow();
//        health.setMedicalHistory(ShowConvert.convertToShow(userInfoDetail.getMedicalHistory(),ShowConvert.MEDICAL_HISTORY_SHOW));
        health.setMedicalHistory(ShowConvert.convertStringArr2String(JsonUtil.string2StringArr(userInfoDetail.getMedicalHistory())));
        health.setDefect(ShowConvert.convertStringArr2String(JsonUtil.string2StringArr(userInfoDetail.getDefect())));
        health.setRely(ShowConvert.convertToShow(userInfoDetail.getRely(),ShowConvert.RELY_SHOW));
        health.setOther(ShowConvert.convertToShow(userInfoDetail.getHealthOther(),ShowConvert.HEALTH_OTHER_SHOW));
        health.setOther(append(health.getOther(),userInfoDetail.getRemark4()));

        LifeEventShow lifeEvent = new LifeEventShow();
//        lifeEvent.setEconomic(ShowConvert.convertToShow(userInfoDetail.getLifeEventEconomic(),ShowConvert.SPECIAL_ECONOMIC_SHOW));
//        lifeEvent.setFamily(ShowConvert.convertToShow(userInfoDetail.getLifeEventFamily(),ShowConvert.SPECIAL_FAMILY_SHOW));
//        lifeEvent.setLive(ShowConvert.convertToShow(userInfoDetail.getLifeEventLive(),ShowConvert.SPECIAL_LIFE_SHOW));
//        lifeEvent.setMarried(ShowConvert.convertToShow(userInfoDetail.getLifeEventMarital(),ShowConvert.SPECIAL_MARRIED_SHOW));
//        lifeEvent.setSocial(ShowConvert.convertToShow(userInfoDetail.getLifeEventSocial(),ShowConvert.SPECIAL_SOCIAL_SHOW));
//        lifeEvent.setWork(ShowConvert.convertToShow(userInfoDetail.getLifeEventWork(),ShowConvert.SPECIAL_WORK_SHOW));
        lifeEvent.setEconomic(ShowConvert.convertStringArr2String(JsonUtil.string2StringArr(userInfoDetail.getLifeEventEconomic())));
        lifeEvent.setFamily(ShowConvert.convertStringArr2String(JsonUtil.string2StringArr(userInfoDetail.getLifeEventFamily())));
        lifeEvent.setLive(ShowConvert.convertStringArr2String(JsonUtil.string2StringArr(userInfoDetail.getLifeEventLive())));
        lifeEvent.setMarried(ShowConvert.convertStringArr2String(JsonUtil.string2StringArr(userInfoDetail.getLifeEventMarital())));
        lifeEvent.setSocial(ShowConvert.convertStringArr2String(JsonUtil.string2StringArr(userInfoDetail.getLifeEventSocial())));
        lifeEvent.setWork(ShowConvert.convertStringArr2String(JsonUtil.string2StringArr(userInfoDetail.getLifeEventWork())));


        PrisonShow prison = new PrisonShow();
        String transformExperience = userInfoDetail.getTransformExperience();
        String[] teArr = transformExperience.split(",");

        prison.setEnv(ShowConvert.convertToShow(teArr[0],ShowConvert.PRISON_ENV_SHOW));
        prison.setSocial(ShowConvert.convertToShow(teArr[1],ShowConvert.PRISON_SOCIAL_SHOW));
        prison.setLabour(ShowConvert.convertToShow(teArr[2],ShowConvert.PRISON_LABOUR_SHOW));
        prison.setRelease(ShowConvert.convertToShow(teArr[3],ShowConvert.PRISON_RELEASE_SHOW));
        GuiltShow guiltShow = new GuiltShow();
        userInfoDetail.getGuilt();
        guiltShow.setGuilt(ShowConvert.covertToShowByTypes(userInfoDetail.getGuilt(),ShowConvert.GUILT_SHOW));
        guiltShow.setGuilt(append(guiltShow.getGuilt(),userInfoDetail.getRemark5()));

        //todo
        List<WorkDetailShow> workDetailShowList  = new ArrayList<>();
        String workDetailStr = userInfoDetail.getWorkExperience();
        if (!StringUtils.isEmpty(workDetailStr)){
            List<WorkInfo> workInfoList = JSON.parseObject(workDetailStr,new TypeReference<ArrayList<WorkInfo>>(){});
            for (WorkInfo workInfo : workInfoList){
                WorkDetailShow workDetailShow = new WorkDetailShow();
                workDetailShow.setStage(workInfo.getStage());
                workDetailShow.setFeeling(ShowConvert.convertToShow(workInfo.getFeeling(),ShowConvert.LEVEL_SHOW));
                workDetailShow.setFeeling(ShowConvert.LEVEL_SHOW[Integer.parseInt(workInfo.getFeeling())]);
                workDetailShow.setWorkyear(ShowConvert.WORKYEAR_SHOW[Integer.parseInt(workInfo.getWorkyear())]);
                workDetailShow.setOccupation(workInfo.getOccupation());
                workDetailShowList.add(workDetailShow);
            }
        }
//        List<SocialDetailShow> socialDetailShowList  = new ArrayList<>();
//        String socailStatusStr = userInfoDetail.getSocialStatus();
//        if (!StringUtils.isEmpty(socailStatusStr)){
//            List<SocialStatus> socialStatusList = JSON.parseObject(socailStatusStr,new TypeReference<ArrayList<SocialStatus>>(){});
//            for (SocialStatus socialStatus: socialStatusList){
//                SocialDetailShow socialDetailShow =  new SocialDetailShow();
//                socialDetailShow.setName(socialStatus.getName());
//                socialDetailShow.setOccupation(ShowConvert.OCCUPATION_SHOW[Integer.parseInt(socialStatus.getSocialOccupation())]);
//                socialDetailShow.setFeeling(ShowConvert.LEVEL_SHOW[Integer.parseInt(socialStatus.getFeeling())]);
//                socialDetailShowList.add(socialDetailShow);
//            }
//        }
        List<FamilyDetailShow> familyDetailShowList  = new ArrayList<>();
        String familyStatusStr = userInfoDetail.getFamilyStatus();
        if (!StringUtils.isEmpty(familyStatusStr)){
            List<FamilyStatus> familyStatusList = JSON.parseObject(familyStatusStr,new TypeReference<ArrayList<FamilyStatus>>(){});
            for(FamilyStatus familyStatus :familyStatusList){
                FamilyDetailShow  familyDetailShow = new FamilyDetailShow();
//                familyDetailShow.setFamilyCall(ShowConvert.FAMILY_CALL_SHOW.get(familyStatus.getFamilyCall()));
                familyDetailShow.setName(familyStatus.getName());
                familyDetailShow.setRelation(familyStatus.getRelation());
//                familyDetailShow.setOccupation(ShowConvert.OCCUPATION_SHOW[Integer.parseInt(familyStatus.getFamilyOccupation())]);
                familyDetailShow.setFeeling(ShowConvert.LEVEL_SHOW[Integer.parseInt(familyStatus.getFeeling())]);
                familyDetailShowList.add(familyDetailShow);
            }
        }
        List<GrowupDetailShow> growupDetailShowList = new ArrayList<>();
        String groupInfoStr = userInfoDetail.getGrowupInfo();
        if (!StringUtils.isEmpty(groupInfoStr)){
            List<GrowupInfo> growupInfoList = JSON.parseObject(groupInfoStr,new TypeReference<ArrayList<GrowupInfo>>(){});
            for (GrowupInfo growupInfo:growupInfoList){
                GrowupDetailShow growupDetailShow = new GrowupDetailShow();
                growupDetailShow.setStage(growupInfo.getStage());
                growupDetailShow.setFeeling(ShowConvert.GROWUP_FEELING_SHOW[Integer.parseInt(growupInfo.getFeeling())]);
                growupDetailShow.setTraining(ShowConvert.GROWUP_TRAINING_SHOW[Integer.parseInt(growupInfo.getTraining())]);
                growupDetailShowList.add(growupDetailShow);
            }
        }
        StringBuffer growupOfFamily = new StringBuffer();
        String dropStr = ShowConvert.DROP_SHOW[Integer.parseInt(userInfoDetail.getDropInfo())];
        String parentHealthStr = ShowConvert.convertToShow(userInfoDetail.getParentHealth(),ShowConvert.PARENT_HEALTH_SHOW);
        String brotherHealthStr = ShowConvert.convertToShow(userInfoDetail.getBrotherHealth(),ShowConvert.BROTHER_HEALTH_SHOW);
        String parentBeatStr = ShowConvert.convertToShow(userInfoDetail.getParentBeat(),ShowConvert.PARENT_BEAT_SHOW);
        growupOfFamily.append(dropStr);
        if (!StringUtils.isEmpty(parentHealthStr)){ growupOfFamily.append(";").append(parentHealthStr);};
        if (!StringUtils.isEmpty(brotherHealthStr)){ growupOfFamily.append(";").append(brotherHealthStr);};
        if (!StringUtils.isEmpty(parentBeatStr)){ growupOfFamily.append(";").append(parentBeatStr);};

//        growupOfFamily.append("。");
        main.setPersonalInfo(personalInfo);
        main.setHealth(health);
        main.setLifeEvent(lifeEvent);
        main.setPrison(prison);
        main.setGuilt(guiltShow);
        main.setGrowupDetail(growupDetailShowList);
//        main.setSocialDetail(socialDetailShowList);
        main.setFamilyDetail(familyDetailShowList);
        main.setWorkDetail(workDetailShowList);
        main.setGrowupOfFamily(append(growupOfFamily.toString(),userInfoDetail.getRemark6()));
        main.setRemark1(userInfoDetail.getRemark1());
        main.setRemark2(userInfoDetail.getRemark2());
        main.setRemark3(userInfoDetail.getRemark3());
        main.setRemark4(userInfoDetail.getRemark4());
        main.setRemark5(userInfoDetail.getRemark5());
        main.setRemark6(userInfoDetail.getRemark6());
        main.setRemark7(userInfoDetail.getRemark7());
        main.setRemark8(userInfoDetail.getRemark8());
        main.setRemark9(userInfoDetail.getRemark9());
        main.setRemark10(userInfoDetail.getRemark10());
        main.setRemark11(userInfoDetail.getRemark11());
        main.setRemark12(userInfoDetail.getRemark12());
        main.setRemark13(userInfoDetail.getRemark13());
        return main;
    }

    //


    @Override
    public void saveUserBasicInfo(SaveBasicInfoDTO1 saveBasicInfoDTO){
        UserInfoDetail userInfoDetail =saveBasicInfoDTO1Convert2UserInfoDetail(saveBasicInfoDTO);
        userInfoDetailMapper.insert(userInfoDetail);
    }

    @Override
    public void updateUserBasicInfo(SaveBasicInfoDTO1 saveBasicInfoDTO) {
        UserInfoDetail userInfoDetail =saveBasicInfoDTO1Convert2UserInfoDetail(saveBasicInfoDTO);
        userInfoDetailMapper.updateByPrimaryKey(userInfoDetail);

    }
    private UserInfoDetail saveBasicInfoDTO1Convert2UserInfoDetail(SaveBasicInfoDTO1 saveBasicInfoDTO){
        UserInfoDetail userInfoDetail = new UserInfoDetail();
        userInfoDetail.setName(saveBasicInfoDTO.getName());
        userInfoDetail.setNo(saveBasicInfoDTO.getNo());
        userInfoDetail.setBirthmonth(saveBasicInfoDTO.getBirthMonth());
        userInfoDetail.setEthnicity(saveBasicInfoDTO.getEthnicity());
        userInfoDetail.setCrime(saveBasicInfoDTO.getCrime());
        userInfoDetail.setImprisonDate(saveBasicInfoDTO.getImprisonDate());
        userInfoDetail.setImprisonBeginEnd(saveBasicInfoDTO.getImprisonStartAndEnd());
        userInfoDetail.setCrimeInfo(saveBasicInfoDTO.getCrimeInfo());
//        userInfoDetail.setCrimeType(
//                TyperConvert.boolean2String(saveBasicInfoDTO.crimeType1)
//                +","+TyperConvert.boolean2String(saveBasicInfoDTO.crimeType2)
//                +","+TyperConvert.boolean2String(saveBasicInfoDTO.crimeType3));
        userInfoDetail.setCrimeType(saveBasicInfoDTO.getCrimeType());

        List<CrimeHistory> crimeHistoryList =  ReferUtil.removeEmpty(saveBasicInfoDTO.getCrimeHistory());
        userInfoDetail.setCrimeHistory(JSONArray.toJSON(crimeHistoryList).toString());
        userInfoDetail.setEconomicStatus(saveBasicInfoDTO.getEconomicStatus());
        userInfoDetail.setBelief(saveBasicInfoDTO.getBelief());
//        userInfoDetail.setMedicalHistory(saveBasicInfoDTO.getMedicalHistory().convertToString());
        userInfoDetail.setMedicalHistory(JSON.toJSONString(saveBasicInfoDTO.getMedicalHistory()));
        userInfoDetail.setHealth(saveBasicInfoDTO.getHealth());
        userInfoDetail.setDefect(JSON.toJSONString(saveBasicInfoDTO.getDefect()));
        userInfoDetail.setRely(JSON.toJSONString(saveBasicInfoDTO.getRely()));

        userInfoDetail.setHealthOther(saveBasicInfoDTO.getHealthOther().convertToString());
        userInfoDetail.setGuilt(saveBasicInfoDTO.getGuilt().convertToString());
        List<GrowupInfo> growupInfoList = ReferUtil.removeEmpty(saveBasicInfoDTO.getGrowupInfo());
        userInfoDetail.setGrowupInfo(JSONArray.toJSON(growupInfoList).toString());
        userInfoDetail.setDropInfo(saveBasicInfoDTO.getDrop());
//        userInfoDetail.setParentHealth(saveBasicInfoDTO.getParentHealth().convertToString());
//        userInfoDetail.setBrotherHealth(saveBasicInfoDTO.getBrotherHealth().convertToString());
        userInfoDetail.setParentHealth(JSON.toJSONString(saveBasicInfoDTO.getParentHealth()));
        userInfoDetail.setBrotherHealth(JSON.toJSONString(saveBasicInfoDTO.getBrotherHealth()));

        userInfoDetail.setParentBeat(saveBasicInfoDTO.getParentBeat().convertToString());
        List<WorkInfo> workInfoList = ReferUtil.removeEmpty(saveBasicInfoDTO.getWorkInfo());
        userInfoDetail.setWorkExperience(JSONArray.toJSON(workInfoList).toString());
        userInfoDetail.setSpecialExperience(saveBasicInfoDTO.getSpecialExperience().convertToString());


//        userInfoDetail.setLifeEventEconomic(saveBasicInfoDTO.getSpecialEconomic().convertToString());
//        userInfoDetail.setLifeEventFamily(saveBasicInfoDTO.getSpecialFamily().convertToString());
//        userInfoDetail.setLifeEventLive(saveBasicInfoDTO.getSpecialLife().convertToString());
//        userInfoDetail.setLifeEventMarital(saveBasicInfoDTO.getSpecialMarried().convertToString());
//        userInfoDetail.setLifeEventSocial(saveBasicInfoDTO.getSpecialSocial().convertToString());
//        userInfoDetail.setLifeEventWork(saveBasicInfoDTO.getSpecialWork().convertToString());
        userInfoDetail.setLifeEventEconomic(JSON.toJSONString(saveBasicInfoDTO.getSpecialEconomic()));
        userInfoDetail.setLifeEventFamily(JSON.toJSONString(saveBasicInfoDTO.getSpecialFamily()));
        userInfoDetail.setLifeEventLive(JSON.toJSONString(saveBasicInfoDTO.getSpecialLife()));
        userInfoDetail.setLifeEventMarital(JSON.toJSONString(saveBasicInfoDTO.getSpecialMarried()));
        userInfoDetail.setLifeEventSocial(JSON.toJSONString(saveBasicInfoDTO.getSpecialSocial()));
        userInfoDetail.setLifeEventWork(JSON.toJSONString(saveBasicInfoDTO.getSpecialWork()));

        userInfoDetail.setTransformExperience(saveBasicInfoDTO.getTransformExperience().convertToString());
//        userInfoDetail.setEmotionExperience(saveBasicInfoDTO.getEmotionExperience().convertToString());
        userInfoDetail.setEmotionExperience(JSON.toJSONString(saveBasicInfoDTO.getEmotionExperience()));
        userInfoDetail.setMaritalStatus(saveBasicInfoDTO.getMaritalstatus().convertToString());
        List<FamilyStatus> familyStatusList = ReferUtil.removeEmpty(saveBasicInfoDTO.getFamilyStatus());
        userInfoDetail.setFamilyStatus(JSONArray.toJSON(familyStatusList).toString());
//        List<SocialStatus> socialStatusList = ReferUtil.removeEmpty(saveBasicInfoDTO.getSocialStatus());
//        userInfoDetail.setSocialStatus(JSONArray.toJSON(socialStatusList).toString());
        userInfoDetail.setCreateTime(new Date());
        userInfoDetail.setUpdateTime(new Date());
        userInfoDetail.setRemark1(saveBasicInfoDTO.getRemark1());
        userInfoDetail.setRemark2(saveBasicInfoDTO.getRemark2());
        userInfoDetail.setRemark3(saveBasicInfoDTO.getRemark3());
        userInfoDetail.setRemark4(saveBasicInfoDTO.getRemark4());
        userInfoDetail.setRemark5(saveBasicInfoDTO.getRemark5());
        userInfoDetail.setRemark6(saveBasicInfoDTO.getRemark6());
        userInfoDetail.setRemark7(saveBasicInfoDTO.getRemark7());
        userInfoDetail.setRemark8(saveBasicInfoDTO.getRemark8());
        userInfoDetail.setRemark9(saveBasicInfoDTO.getRemark9());
        userInfoDetail.setRemark10(saveBasicInfoDTO.getRemark10());
        userInfoDetail.setRemark11(saveBasicInfoDTO.getRemark11());
        userInfoDetail.setRemark12(saveBasicInfoDTO.getRemark12());
        userInfoDetail.setRemark13(saveBasicInfoDTO.getRemark13());
        return userInfoDetail;
    }

    @Override
    public UserInfoDetail queryUserBasicInfoDetail(CriminalInfo criminalInfo) {
        UserInfoDetail userInfoDetail = userInfoDetailMapper.selectByPrimaryKey(criminalInfo.getNo());
        return userInfoDetail;
    }

    @Override
    public UserInfo queryUserBasicInfo(CriminalInfo criminalInfo){
        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(criminalInfo.getNo());
        return userInfo;
    }



    private QuestionResultSub buildReportByQuestionNo(CriminalInfo criminalInfo, String questionNo){
        QuestionResult questionResult = questionResultMapper.selectByCriminalIdAndQuestionNo(criminalInfo.getNo(),questionNo);
        if (questionResult != null){
            switch (questionNo){
                case "1":
                    return COPA.buildReport(questionResult);
                case "2":
                    return FaceProblem.buildReport(questionResult);
                case "3":
                    return Personality.buildReport(questionResult);
            }
        }
        return null;
    }


    @Override
    public List<QuestionDTO> queryQuestion(int mainNo) {
        List<Question> questionList = questionMapper.selectByMainNoAndSubNo(mainNo);
        List<QuestionDTO> questionDTOList = new ArrayList<>();
        for (Question question:questionList){
            QuestionDTO dto = new QuestionDTO();
            dto.setQuestionMainNumber(question.getMainNo());
            dto.setQuestionSubNumber(question.getSubNo());
            dto.setTitle(question.getTitle());
            List<Choice> list =  JSON.parseObject(question.getChoice(),new TypeReference<ArrayList<Choice>>(){});
            dto.setChoiceList(list);
            dto.setQuestionMainName(Question.MAIN_NAME.get(mainNo));
            questionDTOList.add(dto);
        }

        return questionDTOList;
    }

    @Override
    public Map<String, List<QuestionDTO>> queryAllQuestion() {
        Map<String, List<QuestionDTO>> map = new HashMap<>();
        for (int i =1 ; i <=3; i++){
            List<QuestionDTO> list = this.queryQuestion(i);
            map.put(i+"",list);
        }
        return map;
    }

    @Override
    public SaveBasicInfoDTO1 userDetail2SaveBasicInfoDTO1(UserInfoDetail detail){
        SaveBasicInfoDTO1 dto  = new SaveBasicInfoDTO1();
        dto.setBelief(detail.getBelief());
        dto.setBirthMonth(detail.getBirthmonth());
//        JSONArray jsonArray = JSON.parseArray(detail.getBrotherHealth());
//        Object[] os = jsonArray.toArray();
//        dto.setBrotherHealth((String[]) jsonArray.toArray());
        dto.setBrotherHealth(JsonUtil.string2StringArr(detail.getBrotherHealth()));

//        dto.setBrotherHealth(detail.getBrotherHealth());
        dto.setCrime(detail.getCrime());
//        dto.setCrimeHistory(detail.getCrimeHistory());
        dto.setCrimeHistory(JSON.parseObject(detail.getCrimeHistory(),new TypeReference<ArrayList<CrimeHistory>>(){}));
        dto.setCrimeInfo(detail.getCrimeInfo());
        dto.setCrimeType(detail.getCrimeType());
//        dto.setDefect(detail.getDefect());
        dto.setDefect(JsonUtil.string2StringArr(detail.getDefect()));
        dto.setDrop(detail.getDropInfo());
        //
        dto.setDropOptionValue(detail.getDropInfo());
        dto.setEconomicStatus(detail.getEconomicStatus());
//        dto.setEmotionExperience(detail.getEmotionExperience());
        dto.setEmotionExperience(JsonUtil.string2StringArr(detail.getEmotionExperience()));

        dto.setEthnicity(detail.getEthnicity());
//        dto.setFamilyStatus(detail.getFamilyStatus());
        dto.setFamilyStatus(JSON.parseObject(detail.getFamilyStatus(),new TypeReference<ArrayList<FamilyStatus>>(){}));

//        dto.setGrowupInfo(detail.getGrowupInfo());
        dto.setGrowupInfo(JSON.parseObject(detail.getGrowupInfo(),new TypeReference<ArrayList<GrowupInfo>>(){}));
//        dto.setGuilt(detail.getGuilt());
        dto.setGuilt(Guilt.convertToParam(detail.getGuilt()));
//        dto.setGuilt(JSON.parseObject(detail.getGuilt(),Guilt.class));

        dto.setHealth(detail.getHealth());
        dto.setHealthOther(HealthOther.convertToParam(detail.getHealthOther()));

        dto.setImprisonDate(detail.getImprisonDate());
        dto.setImprisonStartAndEnd(detail.getImprisonBeginEnd());
//        dto.setMaritalstatus(JSON.parseObject(detail.getMaritalStatus(),Maritalstatus.class));
        dto.setMaritalstatus(Maritalstatus.convertToParam(detail.getMaritalStatus()));
//        dto.setMedicalHistory(detail.getMedicalHistory());
        dto.setMedicalHistory(JsonUtil.string2StringArr(detail.getMedicalHistory()));
        dto.setName(detail.getName());
        dto.setNo(detail.getNo());
//        dto.setParentBeat(JSON.parseObject(detail.getParentBeat(),ParentBeat.class));
        dto.setParentBeat(ParentBeat.convertToParam(detail.getParentBeat()));

        dto.setParentHealth(JsonUtil.string2StringArr(detail.getParentHealth()));
        dto.setRely(JsonUtil.string2StringArr(detail.getRely()));
        dto.setSpecialEconomic(JsonUtil.string2StringArr(detail.getLifeEventEconomic()));
//        dto.setSpecialExperience(JSON.parseObject(detail.getSpecialExperience(),SpecialExperience.class));
        dto.setSpecialExperience(SpecialExperience.convertToParam(detail.getSpecialExperience()));

        dto.setSpecialFamily(JsonUtil.string2StringArr(detail.getLifeEventFamily()));
        dto.setSpecialLife(JsonUtil.string2StringArr(detail.getLifeEventLive()));
        dto.setSpecialMarried(JsonUtil.string2StringArr(detail.getLifeEventMarital()));
        dto.setSpecialSocial(JsonUtil.string2StringArr(detail.getLifeEventSocial()));
        dto.setSpecialWork(JsonUtil.string2StringArr(detail.getLifeEventWork()));
//        dto.setTransformExperience(JSON.parseObject(detail.getTransformExperience(),TransformExperience.class));
        dto.setTransformExperience(TransformExperience.convertToParam(detail.getTransformExperience()));

        dto.setWorkInfo(JSON.parseObject(detail.getWorkExperience(),new TypeReference<ArrayList<WorkInfo>>(){}));
        dto.setRemark1(detail.getRemark1());
        dto.setRemark2(detail.getRemark2());
        dto.setRemark3(detail.getRemark3());
        dto.setRemark4(detail.getRemark4());
        dto.setRemark5(detail.getRemark5());
        dto.setRemark6(detail.getRemark6());
        dto.setRemark7(detail.getRemark7());
        dto.setRemark8(detail.getRemark8());
        dto.setRemark9(detail.getRemark9());
        dto.setRemark10(detail.getRemark10());
        dto.setRemark11(detail.getRemark11());
        dto.setRemark12(detail.getRemark12());
        dto.setRemark13(detail.getRemark13());


        return dto;
    }

    @Override
    public List<UserInfoTemplate> queryUserInfoTemplate() {
        return userInfoTemplateMapper.selectAll();
    }

    private String append(String string1,String string2){
        if(StringUtils.isEmpty(string2)){
            return string1;
        }
        if(StringUtils.isEmpty(string1)){
            return string2;
        }else{
            return string1+"。"+string2;
        }

    }
}

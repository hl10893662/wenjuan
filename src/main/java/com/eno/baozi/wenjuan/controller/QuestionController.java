package com.eno.baozi.wenjuan.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.eno.baozi.wenjuan.common.util.JsonUtil;
import com.eno.baozi.wenjuan.common.util.TyperConvert;
import com.eno.baozi.wenjuan.domain.*;
import com.eno.baozi.wenjuan.service.IQuestionService;
import com.eno.baozi.wenjuan.service.impl.QuestionServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/api/question")
@Api(value = "问卷API", description="问卷信息")
public class QuestionController {
    private final Logger logger = LoggerFactory.getLogger(QuestionController.class);
    @Autowired
    IQuestionService questionService;

    @PostMapping("/queryQuestion")
    @ApiOperation(value = "根据问卷编码获取问题列表", notes = "参数：问卷编号，如1，2，3")
    @ResponseBody
    public ResponseDTO<List<QuestionDTO>> getQuestion(@RequestBody int questionMainNumber) {
        List<QuestionDTO> questionDTOS = questionService.queryQuestion(questionMainNumber);
        ResponseDTO dto = new ResponseDTO();
        dto.setData(questionDTOS);
        dto.setCode(20000);
//        List<QuestionDTO> list = new ArrayList<>();
//        QuestionDTO  dto1 = new QuestionDTO();
//        dto1.setTitle("我喜欢社交公关活动。");
//        dto1.setQuestionMainNumber(1);
//        dto1.setQuestionSubNumber(1);
//        dto1.setQuestionMainName("COPA");
//        List<Choice> choiceList1 = new ArrayList<>();
//        choiceList1.add(new Choice(0,"否"));
//        choiceList1.add(new Choice(1,"是"));
//        dto1.setChoiceList(choiceList1);
//        list.add(dto1);
//
//        QuestionDTO  dto2 = new QuestionDTO();
//        dto2.setTitle("即使是很复杂的问题，一般也难不倒我。");
//        dto2.setQuestionMainNumber(1);
//        dto2.setQuestionSubNumber(2);
//        List<Choice> choiceList2 = new ArrayList<>();
//        choiceList2.add(new Choice(0,"否"));
//        choiceList2.add(new Choice(1,"是"));
//        dto2.setChoiceList(choiceList2);
//        dto2.setQuestionMainName("COPA");
//        list.add(dto2);
//        ResponseDTO dto = new ResponseDTO();
//        dto.setData(list);
//        dto.setCode(20000);
        return dto;
    }


    @PostMapping("/queryAllQuestion")
    @ApiOperation(value = "获取问题列表", notes = "")
    @ResponseBody
    public ResponseDTO<Map<String, List<QuestionDTO>>> getAllQuestion() {
        Map<String, List<QuestionDTO>> questionDTOS = questionService.queryAllQuestion();
        ResponseDTO dto = new ResponseDTO();
        dto.setData(questionDTOS);
        dto.setCode(20000);
        return dto;
    }


    @ApiOperation(value = "个人信息是否存在", notes = "个人信息是否存在")
    @RequestMapping(value = "/isExistsBasicInfo", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ResponseDTO<Boolean> isExistsBasicInfo(@RequestBody CriminalInfo criminalInfo, @RequestHeader("X-Token") String token) {
        criminalInfo.setNo(token);
        UserInfoDetail userInfoDetail = questionService.queryUserBasicInfoDetail(criminalInfo);
        ResponseDTO dto = new ResponseDTO();

        if (userInfoDetail != null) {
            dto.setData(true);
        } else {
            dto.setData(false);
        }
        dto.setCode(20000);
        return dto;
    }


    @ApiOperation(value = "查询个人信息", notes = "查询个人信息")
    @RequestMapping(value = "/queryBasicInfo", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ResponseDTO<UserInfo> queryBasicInfo(@RequestBody CriminalInfo criminalInfo, @RequestHeader("X-Token") String token) {

        ResponseDTO dto = new ResponseDTO();
        try{
            criminalInfo.setNo(token);
            UserInfo userInfo = questionService.queryUserBasicInfo(criminalInfo);
            if (userInfo != null) {
                if (userInfo.getImprisonBegin() != null) {
                    userInfo.setImprisonBeginShow(TyperConvert.dateToString(userInfo.getImprisonBegin()));
                }
                if (userInfo.getImprisonEnd() != null) {
                    userInfo.setImprisonEndShow(TyperConvert.dateToString(userInfo.getImprisonEnd()));
                }
            }
            if (userInfo != null) {
                dto.setData(userInfo);
                dto.setCode(20000);

            }
        }catch(Exception e){
            dto.setCode(30001);

        }

        return dto;
    }

    @ApiOperation(value = "查询个人信息调查问题", notes = "查询个人信息调查问题")
    @RequestMapping(value = "/queryBasicQuestion", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ResponseDTO<List<UserInfoTemplateDTO>> queryBasicQuestion() {
        ResponseDTO responseDTO = new ResponseDTO();
        try {
            List<UserInfoTemplate> list = questionService.queryUserInfoTemplate();
            List<UserInfoTemplateDTO> dtoList = new ArrayList<>();
            for (UserInfoTemplate userInfoTemplate :list){
                UserInfoTemplateDTO dto = new UserInfoTemplateDTO();
//                dto.setChoice(JsonUtil.string2ObjectArr(userInfoTemplate.getChoice()));
                dto.setChoice(JSONArray.parseArray(userInfoTemplate.getChoice() , UserInfoTemplateChoiceDTO.class));
                dto.setChoiceName(userInfoTemplate.getChoiceName());
                dto.setId(userInfoTemplate.getId());
                dto.setMainNo(userInfoTemplate.getMainNo());
                dto.setMainTitle(userInfoTemplate.getMainTitle());
                dto.setSubNo(userInfoTemplate.getSubNo());
                dto.setTitle(userInfoTemplate.getTitle());
                dto.setType(userInfoTemplate.getType());
                dto.setValueName(userInfoTemplate.getValueName());
                dtoList.add(dto);
            }
            responseDTO.setData(dtoList);
        } catch (Exception e) {
            logger.error("查询个人信息调查问题", e);
            responseDTO.setCode(30001);
            responseDTO.setMessage("查询个人信息调查问题，请重试");
            return responseDTO;
        }
        responseDTO.setCode(20000);
        return responseDTO;

    }


//    @ApiOperation(value = "提交个人信息", notes = "提交个人信息，提交成功返回编码20000，否则为失败")
//    @RequestMapping(value = "/commitBasicInfo", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
//    @ResponseBody
//    public ResponseDTO<String> commitBasicInfo(@RequestBody SaveBasicInfoDTO1 saveBasicInfoDTO, @RequestHeader("X-Token") String token) {
//        ResponseDTO responseDTO = new ResponseDTO();
//        try {
//            if (StringUtils.isEmpty(saveBasicInfoDTO.getNo())){
//                saveBasicInfoDTO.setNo(token);
//            }
//            questionService.saveUserBasicInfo(saveBasicInfoDTO);
//        } catch (Exception e) {
//            logger.info("提交个人信息失败，请求内容：", JSON.toJSONString(saveBasicInfoDTO));
//            logger.error("提交个人信息失败，异常信息", e);
//            responseDTO.setCode(30001);
//            responseDTO.setMessage("提交个人信息失败，请检查录入信息");
//            return responseDTO;
//        }
//        responseDTO.setCode(20000);
//        return responseDTO;
//    }


    @ApiOperation(value = "更新个人备注信息", notes = "更新个人备注信息（民警），提交成功返回编码20000，否则为失败")
    @RequestMapping(value = "/commitBasicInfo", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ResponseDTO<String> commitBasicInfo(@RequestBody SaveBasicInfoDTO1 saveBasicInfoDTO, @RequestHeader("X-Token") String token) {

//        String  jsonStr = "{\"name\":\"翁宝文\",\"no\":\"3404006512\",\"birthMonth\":\"3\",\"ethnicity\":\"4\",\"crime\":\"5\",\"imprisonDate\":\"6\",\"imprisonStartAndEnd\":\"7\",\"crimeInfo\":\"8\",\"crimeType\":\"累犯\",\"crimeHistory\":[{\"order\":1,\"name\":\"9\",\"imprisonDate\":\"10\",\"imprisonStartAndEnd\":\"11\",\"address\":\"12\",\"commutation\":\"13\"}],\"economicStatus\":\"14\",\"belief\":\"15\",\"medicalHistory\":[\"出生时早产\",\"癫痫\",\"脑膜炎\",\"其他\",\"中毒\",\"脑部外伤\"],\"health\":\"0\",\"defect\":\"16\",\"rely\":[\"毒品\",\"上网\",\"赌博\",\"其他\"],\"healthOther\":{\"healthOther1\":\"1\",\"healthOther2\":\"1\",\"healthOther3\":\"1\"},\"guilt\":{\"guilt1\":\"1\",\"guilt2\":\"2\",\"guilt3\":\"1\",\"guilt4\":\"1\",\"guilt5\":\"1\"},\"growupInfo\":[{\"stage\":\"1-6岁（幼年时期）\",\"training\":\"1\",\"feeling\":\"1\"},{\"stage\":\"7-12岁（小学时期）\",\"training\":\"1\",\"feeling\":\"1\"},{\"stage\":\"13-15岁（初中时期）\",\"training\":\"1\",\"feeling\":\"1\"},{\"stage\":\"16-18岁（高中时期） \",\"training\":\"1\",\"feeling\":\"1\"},{\"stage\":\"18岁以上（大学时期）\",\"training\":\"1\",\"feeling\":\"1\"}],\"drop\":\"1\",\"parentHealth\":[\"正常\"],\"brotherHealth\":[\"正常\"],\"parentBeat\":{\"parentBeat1\":\"1\",\"parentBeat2\":\"1\"},\"workInfo\":[{\"stage\":\"工作1\",\"occupation\":\"1\",\"feeling\":\"1\",\"workyear\":\"1\"}],\"specialExperience\":{\"specialExperience1\":\"1\",\"specialExperience2\":\"1\",\"specialExperience3\":\"1\",\"specialExperience4\":\"1\"},\"specialFamily\":[\"子女死亡\"],\"specialMarried\":[\"结婚\"],\"specialWork\":[\"失业\"],\"specialLife\":[\"受到惊吓\"],\"specialEconomic\":[\"遭受财产损失\"],\"specialSocial\":[\"好友去世\"],\"transformExperience\":{\"prisonEnv\":{\"prisonEnv1\":\"1\",\"prisonEnv2\":\"1\",\"prisonEnv3\":\"1\",\"prisonEnv4\":\"1\",\"prisonEnv5\":\"1\",\"prisonEnv6\":\"1\"},\"social\":{\"social1\":\"1\",\"social2\":\"1\",\"social3\":\"1\"},\"labour\":{\"labour1\":\"1\",\"labour2\":\"1\",\"labour3\":\"1\"},\"release\":{\"release1\":\"1\",\"release2\":\"1\",\"release3\":\"1\"}},\"emotionExperience\":[\"离婚\"],\"maritalstatus\":{\"unmarried\":{\"unmarried1\":\"1\",\"unmarried2\":\"1\",\"unmarried3\":\"1\"},\"married\":{\"married1\":\"1\",\"married2\":\"1\",\"married3\":\"1\",\"married4\":\"1\",\"married5\":\"1\"}},\"familyStatus\":[{\"stage\":\"1\",\"name\":\"17\",\"relation\":\"18\",\"feeling\":\"1\"}]}";
//        SaveBasicInfoDTO1 saveBasicInfoDTO = new SaveBasicInfoDTO1();
//        saveBasicInfoDTO = JSON.parseObject(jsonStr,SaveBasicInfoDTO1.class);
        ResponseDTO responseDTO = new ResponseDTO();
        try {
            if (StringUtils.isEmpty(saveBasicInfoDTO.getNo())){
                saveBasicInfoDTO.setNo(token);
            }
            questionService.saveUserBasicInfo(saveBasicInfoDTO);
        } catch (Exception e) {
            logger.info("提交个人信息失败，请求内容：", JSON.toJSONString(saveBasicInfoDTO));
            logger.error("提交个人信息失败，异常信息", e);
            responseDTO.setCode(30001);
            responseDTO.setMessage("提交个人信息失败，请检查录入信息");
            return responseDTO;
        }
        responseDTO.setCode(20000);
        return responseDTO;
    }

    @ApiOperation(value = "查询个人信息（更新）", notes = "查询个人信息（更新）")
    @RequestMapping(value = "/queryUserDetailInfo", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ResponseDTO<SaveBasicInfoDTO1> queryUserDetailInfo(@RequestBody CriminalInfo criminalInfo) {

        ResponseDTO responseDTO = new ResponseDTO();
        UserInfoDetail userInfoDetail = questionService.queryUserBasicInfoDetail(criminalInfo);
        SaveBasicInfoDTO1 dto = questionService.userDetail2SaveBasicInfoDTO1(userInfoDetail);
        responseDTO.setData(dto);
        responseDTO.setCode(20000);
        return responseDTO;
    }



    @ApiOperation(value = "问卷结果提交", notes = "问卷结果提交")
    @RequestMapping(value = "/commitQuestionResult", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ResponseDTO<String> commitResult(@RequestBody QuestionResultDTO questionResultDTO, @RequestHeader("X-Token") String token) throws Exception {

//    public ResponseDTO<String>  commitResult(@RequestBody QuestionResultDTO questionResultDTO, @RequestHeader("X-Token") String token) throws Exception {
        ResponseDTO responseDTO = new ResponseDTO();
        try {
            questionResultDTO.setCirminalNo(token);
            questionService.saveQuestionResult(questionResultDTO);
        } catch (Exception e) {
            logger.info("问卷结果提交，请求内容：", JSON.toJSONString(questionResultDTO));
            logger.error("问卷结果提交，异常信息", e);
            responseDTO.setCode(30001);
            responseDTO.setMessage("问卷结果提交，请检查录入信息");
            return responseDTO;
        }
        responseDTO.setCode(20000);
        return responseDTO;
    }


    @ApiOperation(value = "所有问卷结果提交", notes = "所有问卷结果提交")
    @RequestMapping(value = "/commitAllQuestionResult", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ResponseDTO<String> commitResult(@RequestBody List<QuestionResultDTO> questionResultDTOList, @RequestHeader("X-Token") String token) throws Exception {

        ResponseDTO responseDTO = new ResponseDTO();
        try {
            for (QuestionResultDTO questionResultDTO : questionResultDTOList) {
                questionResultDTO.setCirminalNo(token);
                questionService.saveQuestionResult(questionResultDTO);
            }
        } catch (Exception e) {
            logger.info("问卷结果提交，请求内容：", JSON.toJSONString(questionResultDTOList));
            logger.error("问卷结果提交，异常信息", e);
            responseDTO.setCode(30001);
            responseDTO.setMessage("问卷结果提交，请检查录入信息");
            return responseDTO;
        }
        responseDTO.setCode(20000);
        return responseDTO;
    }

    @ApiOperation(value = "更新个人信息", notes = "更新个人信息")
    @RequestMapping(value = "/updateBasicInfo", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ResponseDTO<Boolean> updateBasicInfo(@RequestBody SaveBasicInfoDTO1 saveBasicInfoDTO) {
        ResponseDTO responseDTO = new ResponseDTO();
        try {
//            questionService.saveUserBasicInfo(saveBasicInfoDTO);
            questionService.updateUserBasicInfo(saveBasicInfoDTO);
        } catch (Exception e) {
            logger.info("提交个人信息失败，请求内容：", JSON.toJSONString(saveBasicInfoDTO));
            logger.error("提交个人信息失败，异常信息", e);
            responseDTO.setCode(30001);
            responseDTO.setMessage("提交个人信息失败，请检查录入信息");
            return responseDTO;
        }
        responseDTO.setCode(20000);
        responseDTO.setData(true);
        return responseDTO;
    }
}

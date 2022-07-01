package com.eno.baozi.wenjuan.controller;

import com.alibaba.fastjson.JSONObject;
import com.eno.baozi.wenjuan.common.util.TyperConvert;
import com.eno.baozi.wenjuan.domain.*;
import com.eno.baozi.wenjuan.service.IQuestionService;
import com.eno.baozi.wenjuan.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class WenjuanController {
    private  final Logger logger = LoggerFactory.getLogger(WenjuanController.class);
    @Autowired
    IQuestionService questionService;

    @Autowired
    IUserService userService;
    @PostMapping("/user/login")
    @ResponseBody
    public UserTokenInfo login(@RequestBody LoginDTO loginDTO ){
        logger.info("login info:"+loginDTO.toString());
        UserTokenInfo userTokenInfo = new UserTokenInfo();

        try{
        UserLoginInfo userLoginInfo =  userService.login(loginDTO);


//        UserLoginInfo userLoginInfo = new UserLoginInfo();
//        userLoginInfo.setNo("3403005030");
//        userLoginInfo.setUserName("江高生");
//        userLoginInfo.setToken("3403005030");
//        userLoginInfo.setRole("editor");


        userTokenInfo.setData(userLoginInfo);
        userTokenInfo.setCode(20000);

        }catch(Exception e){
            userTokenInfo.setMessage(e.getMessage());
            userTokenInfo.setCode(20001);
        }

        return userTokenInfo;
    }

    @GetMapping("/user/info")
    @ResponseBody
    public ResponseDTO login(@RequestParam Map<String, String> params,@RequestHeader("X-Token") String token){
        logger.info("login info:"+params.toString());
        logger.info("login token:"+token);
        LoginUserInfo loginUserInfo = new LoginUserInfo();

        LoginUserInfo userLoginInfo =  userService.queryUserInfo(params.get("token"));
////        loginUserInfo.setRoles(new String[]{"editor"});
////        loginUserInfo.setName(userLoginInfo.getUserName());
////        loginUserInfo.setIntroduction("");
////        loginUserInfo.setAvatar("");


//        loginUserInfo.setAvatar("https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
//        loginUserInfo.setIntroduction("this is a test");
//        loginUserInfo.setName("江高生");
//        loginUserInfo.setCode(20000);
//        loginUserInfo.setRoles(new String[]{"editor"});

        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setData(userLoginInfo);
        responseDTO.setCode(20000);
        return responseDTO;
    }

    @PostMapping("/user/logout")
    @ResponseBody
    public ResponseDTO logout(@RequestParam Map<String, String> params) {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setData("success");
        responseDTO.setCode(20000);
        return responseDTO;
    }


    @PostMapping("/test")
    @ResponseBody
    public String test(@RequestParam Map<String, String> params) {
        return "yes";
    }

    @RequestMapping(value = "/test1",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String test1(@RequestBody JSONObject jsonParam) {
        return "yes";
    }

    @GetMapping("/test2")
    public String test2(@RequestParam("param1") String param1,@RequestParam("param2") String param2) {
        System.out.println("aa");
        return "success";
    }

    @RequestMapping(value = "/test3",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String test3(@RequestBody CriminalInfo criminalInfo) {
        return "yes";
    }

    @RequestMapping(value = "/commitResult",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public void commitResult(@RequestBody QuestionResultDTO questionResultDTO,@RequestHeader("X-Token") String token) throws Exception {
        questionResultDTO.setCirminalNo(token);
        questionService.saveQuestionResult(questionResultDTO);
    }

    @RequestMapping(value = "/queryReport",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public QuestionResultMain queryReport(@RequestBody CriminalInfo criminalInfo,@RequestHeader("X-Token") String token) {
        try{
//            criminalInfo.setNo(token);
            return questionService.queryReport(criminalInfo);
        }catch(Exception e){
            e.printStackTrace();
            QuestionResultMain  main = new QuestionResultMain();
            main.setResult("查询异常，请检查查询条件或稍后再试");
            return main;
        }

    }
    @RequestMapping(value = "/queryBasicInfo",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public UserInfo queryBasicInfo(@RequestBody CriminalInfo criminalInfo,@RequestHeader("X-Token") String token) {
        criminalInfo.setNo(token);
        UserInfo userInfo = questionService.queryUserBasicInfo(criminalInfo);
        if(userInfo != null) {
            if (userInfo.getImprisonBegin() != null) {
                userInfo.setImprisonBeginShow(TyperConvert.dateToString(userInfo.getImprisonBegin()));
            }
            if (userInfo.getImprisonEnd() != null) {
                userInfo.setImprisonEndShow(TyperConvert.dateToString(userInfo.getImprisonEnd()));
            }
        }
        return userInfo;
    }
    @RequestMapping(value = "/commitBasicInfo",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public void commitBasicInfo(@RequestBody SaveBasicInfoDTO1 saveBasicInfoDTO) {
//        System.out.println(criminalInfo);
//        return null;
        questionService.saveUserBasicInfo(saveBasicInfoDTO);
//        return null;
    }

}

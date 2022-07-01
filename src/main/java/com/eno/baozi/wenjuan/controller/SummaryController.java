package com.eno.baozi.wenjuan.controller;

import com.eno.baozi.wenjuan.domain.*;
import com.eno.baozi.wenjuan.service.ISummaryService;
import com.eno.baozi.wenjuan.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/api/summary")
@Api(value = "report", description="首页")
public class SummaryController {
    private  final Logger logger = LoggerFactory.getLogger(SummaryController.class);

    @Autowired
    IUserService userService;

    @Autowired
    ISummaryService summaryService;

    @ApiOperation(value ="获取重点关注犯人", notes = "获取重点关注犯人")
    @PostMapping("/getFocusUserList")
    @ResponseBody
    public ResponseDTO<List<UserInfo>> getFocusUserList(@RequestHeader("X-Token") String token){
        ResponseDTO responseDTO = new ResponseDTO();
        List<UserInfo>  list = new ArrayList<>();
//        UserInfo userInfo1 = new UserInfo();
//        userInfo1.setPrison("武夷山监狱");
//        userInfo1.setBiggroupno("一监区");
//        userInfo1.setGroupno("一分监区");
//        userInfo1.setName("张三");
//        userInfo1.setNo("000000001");
//        list.add(userInfo1);
//
//        UserInfo userInfo2 = new UserInfo();
//        userInfo2.setPrison("武夷山监狱");
//        userInfo2.setBiggroupno("一监区");
//        userInfo2.setGroupno("一分监区");
//        userInfo2.setName("张三");
//        userInfo2.setNo("000000001");
//        list.add(userInfo1);
//
//
//
//        UserInfo userInfo3 = new UserInfo();
//        userInfo3.setPrison("武夷山监狱");
//        userInfo3.setBiggroupno("一监区");
//        userInfo3.setGroupno("一分监区");
//        userInfo3.setName("张三");
//        userInfo3.setNo("000000001");
//        list.add(userInfo3);
//
//        UserInfo userInfo4 = new UserInfo();
//        userInfo4.setPrison("武夷山监狱");
//        userInfo4.setBiggroupno("一监区");
//        userInfo4.setGroupno("一分监区");
//        userInfo4.setName("张三");
//        userInfo4.setNo("000000001");
//        list.add(userInfo4);
//
//
//
//        UserInfo userInfo5 = new UserInfo();
//        userInfo5.setPrison("武夷山监狱");
//        userInfo5.setBiggroupno("一监区");
//        userInfo5.setGroupno("一分监区");
//        userInfo5.setName("张三");
//        userInfo5.setNo("000000001");
//        list.add(userInfo5);
//
//        UserInfo userInfo7 = new UserInfo();
//        userInfo7.setPrison("武夷山监狱");
//        userInfo7.setBiggroupno("一监区");
//        userInfo7.setGroupno("一分监区");
//        userInfo7.setName("张三");
//        userInfo7.setNo("000000001");
//        list.add(userInfo7);
//
//        UserInfo userInfo8 = new UserInfo();
//        userInfo8.setPrison("武夷山监狱");
//        userInfo8.setBiggroupno("一监区");
//        userInfo8.setGroupno("一分监区");
//        userInfo8.setName("张三");
//        userInfo8.setNo("000000001");
//        list.add(userInfo8);
//
//        UserInfo userInfo9 = new UserInfo();
//        userInfo9.setPrison("武夷山监狱");
//        userInfo9.setBiggroupno("一监区");
//        userInfo9.setGroupno("一分监区");
//        userInfo9.setName("张三");
//        userInfo9.setNo("000000001");
//        list.add(userInfo9);
        list = summaryService.queryFocusList(token);
        responseDTO.setCode(20000);
        responseDTO.setData(list);
        return responseDTO;
    }

    @ApiOperation(value ="获取首页汇总信息", notes = "获取首页汇总信息")
    @PostMapping("/getSummaryInfo")
    @ResponseBody
    public ResponseDTO<SummaryInfo> getSummaryInfo(@RequestHeader("X-Token") String token){
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setCode(20000);
        SummaryInfo summaryInfo = summaryService.buildSummaryInfo(token);
//        SummaryInfo summaryInfo = new SummaryInfo();
//
//        PoliceInfo policeInfo = userService.queryPoliceInfo(token);
//        summaryInfo.setPrison(policeInfo.getPrisonName());
//        summaryInfo.setBigGroup(policeInfo.getBigGroupName());
//        summaryInfo.setGroup(policeInfo.getGroupName());
//        summaryInfo.setPrison("测试监狱");
//        summaryInfo.setBigGroup("二十监区");
//        summaryInfo.setGroup("六十分监区");
//        summaryInfo.setEstablished(80);
//        summaryInfo.setInPrison(100);
//
//
//
//        ChartData escape = new ChartData();
//        escape.add("安全",200);
//        escape.add("较危险",10);
//        escape.add("危险",10);
//
//        ChartData suicide = new ChartData();
//        suicide.add("安全",10);
//        suicide.add("较危险",100);
//        suicide.add("危险",10);
//
//
//        ChartData personality = new ChartData();
//        personality.add("安全",10);
//        personality.add("较危险",100);
//        personality.add("危险",310);
//
//
//        ChartData violence = new ChartData();
//        violence.add("安全",100);
//        violence.add("较危险",100);
//        violence.add("危险",120);
//
//
//        summaryInfo.setEscape(escape);
//        summaryInfo.setPersonality(personality);
//        summaryInfo.setViolence(violence);
//        summaryInfo.setSuicide(suicide);

        responseDTO.setData(summaryInfo);
        return responseDTO;
    }
}

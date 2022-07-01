package com.eno.baozi.wenjuan.controller;

import com.eno.baozi.wenjuan.domain.*;
import com.eno.baozi.wenjuan.service.IBasicService;
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

import java.util.List;

@Controller
@RequestMapping("/api/basic")
@Api(value = "basic" ,description="基础数据获取")
public class BasicController {
    private  final Logger logger = LoggerFactory.getLogger(BasicController.class);

    @Autowired
    IBasicService basicService;

    @ApiOperation(value ="获取监狱信息列表", notes = "获取监狱信息列表")
    @PostMapping("/queryPrisonList")
    @ResponseBody
    public ResponseDTO<List<PrisonInfo>> queryPrisonList( @RequestHeader("X-Token") String token){
        ResponseDTO dto = new ResponseDTO();
        dto.setCode(20000);
        List<PrisonInfo> list = basicService.queryPrisonInfoByPoliceNo(token);
//        PrisonInfo prisonInfo = new PrisonInfo();
//        prisonInfo.setPrisonName("武夷山监狱");
//        prisonInfo.setPrisonNo("350901");
//        List<PrisonInfo> list = new ArrayList();
//        list.add(prisonInfo);
        dto.setData(list);
        return dto;
    }

    @ApiOperation(value ="获取监区信息列表", notes = "获取监区信息列表")
    @PostMapping("/queryBigGroupList")
    @ResponseBody
    public ResponseDTO<List<PrisonBigGroupInfo>> queryBigGroupList( @RequestHeader("X-Token") String token){
        ResponseDTO dto = new ResponseDTO();
        dto.setCode(20000);
        List<PrisonBigGroupInfo> list = basicService.queryBigGroupInfoByPoliceNo(token);
//
//        List<PrisonBigGroupInfo> list = new ArrayList();
//
//        PrisonBigGroupInfo prisonBigGroupInfo = new PrisonBigGroupInfo();
//        prisonBigGroupInfo.setName("一监区");
//        prisonBigGroupInfo.setNo("001");
//        list.add(prisonBigGroupInfo);
//
//        PrisonBigGroupInfo prisonBigGroupInfo1 = new PrisonBigGroupInfo();
//        prisonBigGroupInfo1.setName("二监区");
//        prisonBigGroupInfo1.setNo("002");
//        list.add(prisonBigGroupInfo1);
        dto.setData(list);
        return dto;
    }

    @ApiOperation(value ="获取分监区信息列表", notes = "获取分监区信息列表")
    @PostMapping("/queryGroupList")
    @ResponseBody
    public ResponseDTO<List<PrisonGroupInfo>> queryGroupList( @RequestHeader("X-Token") String token){
        ResponseDTO dto = new ResponseDTO();
        dto.setCode(20000);
        List<PrisonGroupInfo> list = basicService.queryGroupInfoByPoliceNo(token);
//        List<PrisonGroupInfo> list = new ArrayList();
//
//        PrisonGroupInfo prisonGroupInfo = new PrisonGroupInfo();
//        prisonGroupInfo.setName("一分监区");
//        prisonGroupInfo.setNo("001");
//        list.add(prisonGroupInfo);
//
//        PrisonGroupInfo prisonGroupInfo1 = new PrisonGroupInfo();
//        prisonGroupInfo1.setName("二分监区");
//        prisonGroupInfo1.setNo("002");
//        list.add(prisonGroupInfo1);
        dto.setData(list);
        return dto;
    }

}

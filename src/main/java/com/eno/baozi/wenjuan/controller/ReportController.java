package com.eno.baozi.wenjuan.controller;

import com.eno.baozi.wenjuan.common.domain.PageRequest;
import com.eno.baozi.wenjuan.common.domain.PageResponse;
import com.eno.baozi.wenjuan.domain.*;
import com.eno.baozi.wenjuan.service.IQuestionService;
import com.eno.baozi.wenjuan.service.IReportService;
import com.eno.baozi.wenjuan.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/api/report")
@Api(value = "report", description="报告")
public class ReportController {
    private  final Logger logger = LoggerFactory.getLogger(ReportController.class);
    @Autowired
    IReportService reportService;

    @Autowired
    IQuestionService questionService;

    @Autowired
    IUserService userService;




    @ApiOperation(value = "queryUserByPage", notes = "根据条件查询用户列表（分页）")
    @PostMapping("/report/queryUserByPage")
    @ResponseBody
        public ResponseDTO<PageResponse<UserInfo>> queryUserByPage(@RequestBody PageRequest<QueryUserDTO> pageRequest, @RequestHeader("X-Token") String token){
        logger.info("分页查询，参数："+pageRequest.toString());
        QueryUserDTO queryUserDTO = pageRequest.getT();
        //如果查询条件为空（单位信息），根据当前用户进行查询
        if (queryUserDTO.isEmpty()){
            PoliceInfo policeInfo = userService.queryPoliceInfo(token);
            queryUserDTO.setBigGroup(policeInfo.getBigGroupNo());
            queryUserDTO.setPrison(policeInfo.getPrisonNo());
            queryUserDTO.setGroup(policeInfo.getGroupNo());
            pageRequest.setT(queryUserDTO);
        }
        ResponseDTO dto = new ResponseDTO();
        dto.setCode(20000);
//        PageResponse<UserInfo> pageResponse = new PageResponse<>();
//        pageResponse.setPageNum(1);
//        pageResponse.setPageSize(20);
//        pageResponse.setTotalPages(20);
//
//        List<UserInfo>  list = new ArrayList<>();
//        UserInfo userInfo1 = new UserInfo();
//        userInfo1.setName("江高生");
//        userInfo1.setNo("3403005030");
//        userInfo1.setGroupno("一分监区");
//        userInfo1.setBiggroupno("一监区");
//        userInfo1.setPrison("测试监狱");
//        list.add(userInfo1);
//
//        UserInfo userInfo2 = new UserInfo();
//        userInfo2.setName("张三");
//        userInfo2.setNo("000000001");
//        userInfo2.setGroupno("一分监区");
//        userInfo2.setBiggroupno("一监区");
//        userInfo2.setPrison("测试监狱");
//        list.add(userInfo1);
//        pageResponse.setContent(list);
//        dto.setData(pageResponse);
        dto.setData(reportService.queryUserByPage(pageRequest));
        return dto;
    }

    @ApiOperation(value = "queryReport", notes = "查询用户报告")
    @RequestMapping(value = "/queryReport",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ResponseDTO<QuestionResultMain> queryReport(@RequestBody CriminalInfo criminalInfo, @RequestHeader("X-Token") String token) {
        logger.info("请求参数:"+criminalInfo.toString());
        ResponseDTO dto = new ResponseDTO();

        try{
            dto.setCode(20000);
            QuestionResultMain questionResultMain =  questionService.queryReport(criminalInfo);
            dto.setData(questionResultMain);
            return dto;
        }catch(Exception e){
            e.printStackTrace();
            QuestionResultMain  main = new QuestionResultMain();
            main.setResult("查询异常，请检查查询条件或稍后再试");
            dto.setCode(30000);
            return dto;
        }

    }

}

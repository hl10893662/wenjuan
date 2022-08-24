package com.eno.baozi.sentiment.controller;


import com.eno.baozi.sentiment.domain.ResponseDTO;
import com.eno.baozi.sentiment.service.ISentimentService;
import com.eno.baozi.sentiment.service.impl.SentimentServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/api/sentiment")
@Api(value = "sentiment" ,description="狱情")
public class sentimentController {
    private  final Logger logger = LoggerFactory.getLogger(sentimentController.class);

    @Autowired
    ISentimentService sentimentService;

    @ApiOperation(value ="手动触发狱情分析", notes = "手动触发狱情分析")
    @GetMapping("/analyseSentiment")
    @ResponseBody
    public ResponseDTO<Boolean> analyseSentiment(){
        ResponseDTO dto = new ResponseDTO();
        try{
            sentimentService.analyse();
        }catch(Exception e){
            logger.error(e.getMessage(),e);
        }
        dto.setCode(20000);
        dto.setData(true);
        return dto;
    }
}

package com.eno.baozi.data.sync.controller;

import com.eno.baozi.data.sync.task.CriminalInfoSyncService1;
import com.eno.baozi.wenjuan.controller.BasicController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/api/sync")
@Api(value = "sync" ,description="同步信息")
public class SyncController {
    private  final Logger logger = LoggerFactory.getLogger(BasicController.class);

    @Autowired
    private CriminalInfoSyncService1 criminalInfoSyncService1;

    @ApiOperation(value ="同步罪犯信息", notes = "同步罪犯信息")
    @GetMapping("/criminalInfo")
    @ResponseBody
    public String syncCriminalInfo(){
        try{
            criminalInfoSyncService1.sync();
        }catch(Exception e){
            logger.error("同步criminal信息失败",e);
            return "手动同步失败";
        }
        return "手动同步成功";
    }
}

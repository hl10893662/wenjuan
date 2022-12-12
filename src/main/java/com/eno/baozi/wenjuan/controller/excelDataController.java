package com.eno.baozi.wenjuan.controller;

import com.alibaba.excel.EasyExcel;
import com.eno.baozi.wenjuan.domain.CriminalInfo;
import com.eno.baozi.wenjuan.domain.DangerousDataExportDTO;
import com.eno.baozi.wenjuan.domain.ExportDangerousInfoDTO;
import com.eno.baozi.wenjuan.service.IQuestionService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URLEncoder;

@Controller
@RequestMapping("/api/dangerous")
@Api(value = "/api/dangerous" )
public class excelDataController {
    private  final Logger logger = LoggerFactory.getLogger(excelDataController.class);

    @Autowired
    IQuestionService questionService;

    @PostMapping("/exportDangerousData")  //http://127.0.0.1:8081/downLoadExcel/download
    public void doDownLoad(HttpServletResponse response,@RequestBody ExportDangerousInfoDTO exportDangerousInfoDTO) throws IOException {
        String start = exportDangerousInfoDTO.getStart();
        String end = exportDangerousInfoDTO.getEnd();

        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        String fileName = URLEncoder.encode("危险评估", "UTF-8");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
        try {
            EasyExcel.write(response.getOutputStream(), DangerousDataExportDTO.class)
                    .sheet("用户数据")
                    .doWrite(questionService.exportDangerousDataByDate(start,end));
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}

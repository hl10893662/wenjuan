package com.eno.baozi.wenjuan.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.eno.baozi.dangerous.report.domain.Individuality;
import com.eno.baozi.dangerous.report.mapper.IndividualityMapper;
import com.eno.baozi.dangerous.report.service.IIndividualityService;
import com.eno.baozi.wenjuan.common.util.NameConvert;
import com.eno.baozi.wenjuan.domain.ChartData;
import com.eno.baozi.wenjuan.domain.PoliceInfo;
import com.eno.baozi.wenjuan.domain.SummaryInfo;
import com.eno.baozi.wenjuan.domain.UserInfo;
import com.eno.baozi.wenjuan.service.ISummaryService;
import com.eno.baozi.wenjuan.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Primary
public class SummaryServiceImpl implements ISummaryService {

    @Autowired
    IndividualityMapper individualityMapper;

    @Resource
    IIndividualityService individualityService;

    @Autowired
    IUserService userService;
    @Override
    public SummaryInfo buildSummaryInfo(String no) {
        SummaryInfo summaryInfo = new SummaryInfo();

        PoliceInfo policeInfo = userService.queryPoliceInfo(no);
        summaryInfo.setPrison(policeInfo.getPrisonName());
        summaryInfo.setBigGroup(policeInfo.getBigGroupName());
        summaryInfo.setGroup(policeInfo.getGroupName());

        //todo
        summaryInfo.setEstablished(80);
        summaryInfo.setInPrison(100);

        StringBuffer name = new StringBuffer(policeInfo.getPrisonName());
        List<Individuality> individualityList = individualityService.queryIndividualityByPolice(policeInfo.getPrisonName(),
                policeInfo.getBigGroupName(),policeInfo.getGroupName());
//        if (!StringUtils.isEmpty(policeInfo.getBigGroupName())){
//            name.append(policeInfo.getBigGroupName());
//            if (!StringUtils.isEmpty(policeInfo.getGroupName())){
//                name.append(policeInfo.getGroupName());
//                individualityList = individualityMapper.groupingByGroupName(name.toString());
//            }else{
//                individualityList = individualityMapper.groupingByBigGroupName(name.toString());
//            }
//        }else{
//            individualityList = individualityMapper.groupingByPrisonName(name.toString());
//
//        }

        Map<String,Double> escapeMap = new HashMap<>();
        Map<String,Double> suicideMap = new HashMap<>();
        Map<String,Double> personalityMap = new HashMap<>();
        Map<String,Double> violenceMap = new HashMap<>();

        for (Individuality individuality : individualityList){
            if (escapeMap.containsKey(individuality.getTtdj()) ){
                escapeMap.put(individuality.getTtdj(),escapeMap.get(individuality.getTtdj())+1);
            }else{
                escapeMap.put(individuality.getTtdj(),1.0);

            }
            if (suicideMap.containsKey(individuality.getZsdj()) ){
                suicideMap.put(individuality.getZsdj(),suicideMap.get(individuality.getZsdj())+1);
            }else{
                suicideMap.put(individuality.getZsdj(),1.0);

            }

            if (violenceMap.containsKey(individuality.getBldj()) ){
                violenceMap.put(individuality.getBldj(),violenceMap.get(individuality.getBldj())+1);
            }else{
                violenceMap.put(individuality.getBldj(),1.0);

            }
            String personalityTemp = "";
            if ("高分".equals(individuality.getFshrgjb())
                || "高分".equals(individuality.getPzxrgjb())
                    || "高分".equals(individuality.getCdxrgjb())
                    || "高分".equals(individuality.getByxrgjb())){
                personalityTemp = "高分";
            }else if ("中分".equals(individuality.getFshrgjb())
                    || "中分".equals(individuality.getPzxrgjb())
                    || "中分".equals(individuality.getCdxrgjb())
                    || "中分".equals(individuality.getByxrgjb())){
                personalityTemp = "中分";
            }else{
                personalityTemp = "低分";

            }

            if (personalityMap.containsKey(personalityTemp) ){
                personalityMap.put(personalityTemp,personalityMap.get(personalityTemp)+1);
            }else{
                personalityMap.put(personalityTemp,1.0);
            }

        }
        ChartData escape = map2ChartData(escapeMap);
        ChartData suicide = map2ChartData(suicideMap);
        ChartData personality = map2ChartData(personalityMap);
        ChartData violence = map2ChartData(violenceMap);
        summaryInfo.setSuicide(suicide);
        summaryInfo.setEscape(escape);
        summaryInfo.setPersonality(personality);
        summaryInfo.setViolence(violence);
        return summaryInfo;
    }

    @Override
    public List<UserInfo> queryFocusList(String no) {
        PoliceInfo policeInfo = userService.queryPoliceInfo(no);
        List<Individuality> individualityList  = individualityMapper.selectFocusList(policeInfo.getPrisonName(),policeInfo.getBigGroupName(),policeInfo.getGroupName());
        List<UserInfo> userInfoList = new ArrayList<>();
        for (Individuality individuality :individualityList){
            UserInfo userInfo  = new UserInfo();
            userInfo.setPrison(individuality.getJymc());
            userInfo.setBigGroupName(NameConvert.bigGroupFullName2Name(individuality.getJqmc()));
            userInfo.setGroupName(NameConvert.groupFullName2Name(individuality.getFjqmc()));
            userInfo.setName(individuality.getName());
            userInfo.setNo(individuality.getFh());
            userInfoList.add(userInfo);
        }
        return userInfoList;
    }

    private ChartData map2ChartData(Map<String,Double> map){
        ChartData chartData = new ChartData();
        for (Map.Entry<String, Double> entry : map.entrySet()) {
            String k = entry.getKey();
            Double v = entry.getValue();
            chartData.add(k,v);
        }
        return chartData;
    }



}

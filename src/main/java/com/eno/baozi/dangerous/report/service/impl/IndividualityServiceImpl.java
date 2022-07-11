package com.eno.baozi.dangerous.report.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.eno.baozi.dangerous.report.domain.Individuality;
import com.eno.baozi.dangerous.report.mapper.IndividualityMapper;
import com.eno.baozi.dangerous.report.service.IIndividualityService;
import com.eno.baozi.wenjuan.domain.QuestionResult;
import com.eno.baozi.wenjuan.domain.QuestionResultDesc;
import com.eno.baozi.wenjuan.domain.UserInfo;
import com.eno.baozi.wenjuan.questionslove.personality.Personality;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Primary
@Service
public class IndividualityServiceImpl implements IIndividualityService {

    @Resource
    IndividualityMapper individualityMapper;

    @Override
    public List<Individuality> queryIndividualityByPolice(String prisonName,String bigGroupName,String groupName) {
        StringBuffer name = new StringBuffer(prisonName);

        List<Individuality> individualityList = new ArrayList<>();
        if (!StringUtils.isEmpty(bigGroupName)){
            name.append(bigGroupName);
            if (!StringUtils.isEmpty(groupName)){
                name.append(groupName);
                individualityList = individualityMapper.groupingByGroupName(name.toString());
            }else{
                individualityList = individualityMapper.groupingByBigGroupName(name.toString());
            }
        }else{
            individualityList = individualityMapper.groupingByPrisonName(name.toString());

        }
        return individualityList;
    }

    @Override
    public void saveIndividuality(UserInfo userInfo, QuestionResult questionResult) {
        Individuality individuality = new Individuality();
        individuality.setFh(userInfo.getNo());
        individuality.setName(userInfo.getName());

        Map<String,QuestionResultDesc> personalityMap = Personality.calcIndividualScore(questionResult);


        //todo
//        individuality.setId(111111111);

        //反社会人格
        QuestionResultDesc p1Desc = personalityMap.get("P1");
        individuality.setFshrg((int) Math.round(p1Desc.getScore()));
        individuality.setFshrgjb(p1Desc.getLevel());
        //偏执型人格
        QuestionResultDesc p2Desc = personalityMap.get("P2");
        individuality.setPzxrg((int) Math.round(p2Desc.getScore()));
        individuality.setPzxrgjb(p2Desc.getLevel());
        //冲动型人格
        QuestionResultDesc p3Desc = personalityMap.get("P3");
        individuality.setCdxrg((int) Math.round(p3Desc.getScore()));
        individuality.setCdxrgjb(p3Desc.getLevel());
        //边缘型人格
        QuestionResultDesc p4Desc = personalityMap.get("P4");
        individuality.setByxrg((int) Math.round(p4Desc.getScore()));
        individuality.setByxrgjb(p4Desc.getLevel());
        //抑郁
        QuestionResultDesc p5Desc = personalityMap.get("P5");
        individuality.setYy((int) Math.round(p5Desc.getScore()));
        individuality.setYyjb(p5Desc.getLevel());
        //躁狂
        QuestionResultDesc p6Desc = personalityMap.get("P6");
        individuality.setZk((int) Math.round(p6Desc.getScore()));
        individuality.setZkjb(p6Desc.getLevel());
        //神经质
         QuestionResultDesc p7Desc = personalityMap.get("P7");
        individuality.setSjz((int) Math.round(p7Desc.getScore()));
        individuality.setSjzjb(p7Desc.getLevel());
        //精神病性
        QuestionResultDesc p8Desc = personalityMap.get("P8");
        individuality.setJsbx((int) Math.round(p8Desc.getScore()));
        individuality.setJsbxjb(p8Desc.getLevel());
        //说谎量表
        QuestionResultDesc LDesc = personalityMap.get("L");
        individuality.setShlb((int) Math.round(LDesc.getScore()));
        individuality.setShlbjb(LDesc.getLevel());
        //评估日期
        individuality.setPgrq(new Date());
        //评估耗时(自动生成，时间设置为0)
        individuality.setPghs(0);
//        //监狱编号
//        individuality.setJybh();
//        //监狱名称
//        individuality.setJymc();
//        //监区编号
//        individuality.setJqbh();
//        //监区名称
//        individuality.setJqmc();
//        //分监区编号
//        individuality.setFjqbh();
//        //分监区名称
//        individuality.setFjqmc();
//        //精神病hj
//        individuality.setJsbxHj();
//        individuality.setJsbxWx();
//        individuality.setJsbxQxza();
//        individuality.setJsbxRzza();
//        individuality.setJsbxJzzhz();
//        //暴力分数
//        individuality.setBlfs();
//        individuality.setBldj();
//        individuality.setJsbl();
//        //逃脱分数
//        individuality.setTtfs();
//        individuality.setTtdj();
//        individuality.setJstt();
//        //自杀分数
//        individuality.setZsfs();
//        individuality.setZsdj();
//        individuality.setJszs();
        individuality.setCreateName("system");
        individuality.setCreateTime(new Date());
        individuality.setUpdateName("system");
        individuality.setUpdateTime(new Date());
        individualityMapper.insert(individuality);
    }
}

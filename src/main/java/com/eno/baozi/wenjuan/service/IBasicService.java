package com.eno.baozi.wenjuan.service;

import com.eno.baozi.wenjuan.domain.PrisonBigGroupInfo;
import com.eno.baozi.wenjuan.domain.PrisonGroupInfo;
import com.eno.baozi.wenjuan.domain.PrisonInfo;

import java.util.List;

/**
 * 基础信息
 */
public interface IBasicService {

    List<PrisonInfo> queryPrisonInfoByPoliceNo(String policNo);
    List<PrisonInfo> queryPrisonByPrisonName(String prisonName);

    List<PrisonBigGroupInfo> queryBigGroupInfoByPoliceNo(String policeNo);
    List<PrisonBigGroupInfo> queryBigGroupInfoByPrisonName(String PrisonName);
    List<PrisonBigGroupInfo> queryBigGroupInfoByPrisonNo(String PrisonNo);


    List<PrisonGroupInfo> queryGroupInfoByPoliceNo(String policeNo);
    List<PrisonGroupInfo> queryGroupInfoByPrisonName(String PrisonName);
    List<PrisonGroupInfo> queryGroupInfoByPrisonNo(String PrisonNo);
    List<PrisonGroupInfo> queryGroupInfoByBigGroupNo(String bigGroupNo);
}

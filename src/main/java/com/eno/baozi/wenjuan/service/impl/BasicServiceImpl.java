package com.eno.baozi.wenjuan.service.impl;

import com.eno.baozi.wenjuan.consts.OrgCode;
import com.eno.baozi.wenjuan.dao.PoliceMapper;
import com.eno.baozi.wenjuan.dao.UnitsMapper;
import com.eno.baozi.wenjuan.domain.*;
import com.eno.baozi.wenjuan.service.IBasicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Primary
public class BasicServiceImpl implements IBasicService {
    @Autowired
    PoliceMapper policeMapper;
    @Autowired
    UnitsMapper unitsMapper;
    @Override
    /**
     *
     */
    public List<PrisonInfo> queryPrisonInfoByPoliceNo(String policeNo) {
        Units units = getUnitsByPoliceNo(policeNo);
        List<PrisonInfo> prisonInfoList = new ArrayList<>();
//        Units prison = unitsMapper.selectByPrimaryKey(Integer.parseInt(units.getPrisonId()));
        PrisonInfo prisonInfo = new PrisonInfo();
        prisonInfo.setPrisonNo(units.getPrisonId()+"");
        prisonInfo.setPrisonName(units.getPrisonName());
        prisonInfoList.add(prisonInfo);
        return prisonInfoList;
    }

    @Override
    public List<PrisonInfo> queryPrisonByPrisonName(String prisonName) {
        return null;
    }

    @Override
    public List<PrisonBigGroupInfo> queryBigGroupInfoByPoliceNo(String policeNo) {
        Units units = getUnitsByPoliceNo(policeNo);
        List<Units> unitsList = new ArrayList<>();
        switch (units.getType()) {
            case OrgCode.ORG_PROVINCE:
                break;
            case OrgCode.ORG_PRISON:
                unitsList = unitsMapper.selectBigGroupListByPrisonId(units.getId());
                break;
            case OrgCode.ORG_PRISON_DEPART:
                unitsList = unitsMapper.selectBigGroupListByPrisonId(units.getPrisonId());
                break;
            case OrgCode.ORG_PRISON_BIGGROUP:
            case OrgCode.ORG_PRISON_BIGTEAM:
                unitsList.add(units);
                break;
            case OrgCode.ORG_PRISON_GROUP:
            case OrgCode.ORG_PRISON_TEAM:
                Units pUnits = unitsMapper.selectByPrimaryKey(units.getPid());
                if (pUnits != null) {
                    unitsList.add(pUnits);
                }
                break;
        }
        return unitsListConvert2PrisonBigGroupInfoList(unitsList);

    }


    @Override
    public List<PrisonBigGroupInfo> queryBigGroupInfoByPrisonName(String prisonName) {
        return null;
    }

    @Override
    public List<PrisonBigGroupInfo> queryBigGroupInfoByPrisonNo(String prisonNo) {
        List<Units> unitsList = unitsMapper.selectBigGroupListByPrisonId(Integer.parseInt(prisonNo));
        return unitsListConvert2PrisonBigGroupInfoList(unitsList);
    }

    @Override
    public List<PrisonGroupInfo> queryGroupInfoByPoliceNo(String policeNo) {
        Units units = getUnitsByPoliceNo(policeNo);
        List<Units> unitsList = new ArrayList<>();
        switch (units.getType()) {
            case OrgCode.ORG_PROVINCE:
                break;
            case OrgCode.ORG_PRISON:
                unitsList = unitsMapper.selectBigGroupListByPrisonId(units.getId());
                List<PrisonGroupInfo> groupList = new ArrayList<>();
                if (unitsList != null){
                    for (Units unit :unitsList){
                        List<PrisonGroupInfo>  subGroupList = queryGroupInfoByBigGroupNo(unit.getId()+"");
                        groupList.addAll(subGroupList);
                    }
                }
                return groupList;
            case OrgCode.ORG_PRISON_DEPART:
                unitsList = unitsMapper.selectBigGroupListByPrisonId(units.getPrisonId());
                break;
            case OrgCode.ORG_PRISON_BIGGROUP:
            case OrgCode.ORG_PRISON_BIGTEAM:
                unitsList.add(units);
                break;
            case OrgCode.ORG_PRISON_GROUP:
            case OrgCode.ORG_PRISON_TEAM:
                Units pUnits = unitsMapper.selectByPrimaryKey(units.getPid());
                if (pUnits != null) {
                    unitsList = unitsMapper.selectGroupListByBigGroupId(units.getPid());
//                    unitsList.add(pUnits);
                }
                break;
        }

        return unitsListConvert2PrisonGroupInfoList(unitsList);
    }

    @Override
    public List<PrisonGroupInfo> queryGroupInfoByPrisonName(String prisonName) {
        return null;
    }

    @Override
    public List<PrisonGroupInfo> queryGroupInfoByPrisonNo(String prisonNo) {
        List<Units> unitsList = unitsMapper.selectGroupListByPrisonId(Integer.parseInt(prisonNo));
        return unitsListConvert2PrisonGroupInfoList(unitsList);
    }

    @Override
    public List<PrisonGroupInfo> queryGroupInfoByBigGroupNo(String bigGroupNo) {
        List<Units> unitsList = unitsMapper.selectByPid(Integer.parseInt(bigGroupNo));
        return unitsListConvert2PrisonGroupInfoList(unitsList);
    }

    private Units getUnitsByPoliceNo(String policeNo) {
        Police police  = policeMapper.selectByName(policeNo);
        int unitId = police.getUnitId();
        return unitsMapper.selectByPrimaryKey(unitId);
    }


    private List<PrisonBigGroupInfo> unitsListConvert2PrisonBigGroupInfoList(List<Units> unitsList){
        List<PrisonBigGroupInfo> prisonBigGroupInfoList = new ArrayList<>();
        for(Units tempUnits : unitsList){
            PrisonBigGroupInfo prisonBigGroupInfo = new PrisonBigGroupInfo();
            prisonBigGroupInfo.setNo(tempUnits.getId()+"");
            prisonBigGroupInfo.setName(tempUnits.getJgxtName());
            prisonBigGroupInfoList.add(prisonBigGroupInfo);
        }
        return prisonBigGroupInfoList;
    }
    private List<PrisonGroupInfo> unitsListConvert2PrisonGroupInfoList(List<Units> unitsList){
        List<PrisonGroupInfo> prisonGroupInfoList = new ArrayList<>();
        for(Units tempUnits : unitsList){
            PrisonGroupInfo prisonGroupInfo = new PrisonGroupInfo();
            prisonGroupInfo.setNo(tempUnits.getId()+"");
            prisonGroupInfo.setName(tempUnits.getName());
            prisonGroupInfoList.add(prisonGroupInfo);
        }
        return prisonGroupInfoList;
    }
}

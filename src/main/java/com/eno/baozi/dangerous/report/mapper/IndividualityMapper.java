package com.eno.baozi.dangerous.report.mapper;


import com.eno.baozi.dangerous.report.domain.Individuality;

import java.util.List;

public interface IndividualityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Individuality record);

    int insertSelective(Individuality record);

    Individuality selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Individuality record);

    int updateByPrimaryKey(Individuality record);

    /**
     * 查询最新的人格问卷结果
     * @param criminalId
     * @return
     */
    Individuality selectLastOneByCriminalId(String criminalId);

    /**
     * 按监狱全名查
     * @param prisonName
     * @return
     */
    List<Individuality> groupingByPrisonName(String prisonName);

    /**
     * 按监区全名查
     * @param bigGroupName
     * @return
     */
    List<Individuality> groupingByBigGroupName(String bigGroupName);

    /**
     * 按分监区全名查
     * @param groupName
     * @return
     */
    List<Individuality> groupingByGroupName(String groupName);

    List<Individuality> selectFocusList(String prisonName,String bigGroupName,String groupName);

}

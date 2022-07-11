package com.eno.baozi.dangerous.report.service;

import com.eno.baozi.dangerous.report.domain.Individuality;
import com.eno.baozi.wenjuan.domain.QuestionResult;
import com.eno.baozi.wenjuan.domain.UserInfo;

import java.util.List;

public interface IIndividualityService {
    List<Individuality> queryIndividualityByPolice(String prisonName,String bigGroupName,String groupName);

    void saveIndividuality(UserInfo userInfo, QuestionResult questionResult);

}

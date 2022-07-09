package com.eno.baozi.wenjuan.service;

import com.eno.baozi.wenjuan.domain.QuestionResult;
import com.eno.baozi.wenjuan.domain.UserInfo;

public interface IIndividualityService {
    void saveIndividuality(UserInfo userInfo, QuestionResult questionResult);
}

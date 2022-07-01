package com.eno.baozi.wenjuan.service;

import com.eno.baozi.wenjuan.domain.SummaryInfo;
import com.eno.baozi.wenjuan.domain.UserInfo;

import java.util.List;

public interface ISummaryService {
    SummaryInfo buildSummaryInfo(String no);

    List<UserInfo> queryFocusList(String no);


}

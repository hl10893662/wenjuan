package com.eno.baozi.wenjuan.service;

import com.eno.baozi.wenjuan.domain.CriminalInfo;
import com.eno.baozi.wenjuan.domain.OutLineQuestionMain;

public interface IOutlineQuestionService {
    /**
     * @param criminalInfo
     * @return
     */
    OutLineQuestionMain queryOutLineQuestion(CriminalInfo criminalInfo);
}

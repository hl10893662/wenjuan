package com.eno.baozi.wenjuan.service;

import com.eno.baozi.wenjuan.domain.*;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;
import java.util.Map;


public interface IQuestionService {
    /**
     * 保存
     * @param questionResultDTO
     * @throws Exception
     */
    void saveQuestionResult(QuestionResultDTO questionResultDTO) throws Exception;

    /**
     * 查询报告
     * @param criminalInfo
     * @return
     */
    QuestionResultMain queryReport(CriminalInfo criminalInfo);

    /**
     * 保存个人信息
     * @param saveBasicInfoDTO
     */
    void saveUserBasicInfo(SaveBasicInfoDTO1 saveBasicInfoDTO);

    /**
     * 更新个人信息
     * @param saveBasicInfoDTO
     */
    void updateUserBasicInfo(SaveBasicInfoDTO1 saveBasicInfoDTO);

    /**
     * 查询个人信息是
     * @param criminalInfo
     * @return
     */
    UserInfoDetail queryUserBasicInfoDetail(CriminalInfo criminalInfo);
    /**
     * 查询个人信息是否存在
     * @param criminalInfo
     * @return
     */
    UserInfo queryUserBasicInfo(CriminalInfo criminalInfo);
    /**
     * 按问卷编号查询问卷列表
     * @param mainNo
     * @return
     */
    List<QuestionDTO> queryQuestion(int mainNo);

    /**
     * 查询所有问卷列表
     * @return
     */
    Map<String, List<QuestionDTO>> queryAllQuestion();
    SaveBasicInfoDTO1 userDetail2SaveBasicInfoDTO1(UserInfoDetail detail);

    /**
     * 查询所有个人信息问题
     * @return
     */
    List<UserInfoTemplate> queryUserInfoTemplate();

    /**
     * 按起止日期导出危险评估信息（excel）
     */
    List<DangerousDataExportDTO> exportDangerousDataByDate(String start, String end) throws InvocationTargetException, IllegalAccessException;

    /**
     * 查询狱情信息
     * @param criminalInfo
     * @return
     */
    public CriminalInPrisonInfo queryCriminalInPrisonInfo(CriminalInfo criminalInfo);

}

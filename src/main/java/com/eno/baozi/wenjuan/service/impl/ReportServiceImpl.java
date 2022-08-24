package com.eno.baozi.wenjuan.service.impl;

import com.eno.baozi.sentiment.domain.PSentimentResult;
import com.eno.baozi.sentiment.service.ISentimentService;
import com.eno.baozi.wenjuan.common.domain.PageRequest;
import com.eno.baozi.wenjuan.common.domain.PageResponse;
import com.eno.baozi.wenjuan.common.util.PageUtils;
import com.eno.baozi.wenjuan.dao.UnitsMapper;
import com.eno.baozi.wenjuan.dao.UserInfoMapper;
import com.eno.baozi.wenjuan.domain.CriminalInfo;
import com.eno.baozi.wenjuan.domain.QueryUserDTO;
import com.eno.baozi.wenjuan.domain.Units;
import com.eno.baozi.wenjuan.domain.UserInfo;
import com.eno.baozi.wenjuan.service.IReportService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
@Primary
public class ReportServiceImpl implements IReportService {

    @Resource
    UserInfoMapper userInfoMapper;

    @Autowired
    UnitsMapper unitsMapper;

    @Autowired
    ISentimentService sentimentService;

    @Override
    public PageResponse<UserInfo> queryUserByPage(PageRequest<QueryUserDTO> pageRequest) {

        return PageUtils.getPageResult(pageRequest, getPageInfo(pageRequest));
    }

    /**
     * 调用分页插件完成分页
     * @param pageRequest
     * @return
     */
    private PageInfo<UserInfo> getPageInfo(PageRequest<QueryUserDTO> pageRequest) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        QueryUserDTO dto = pageRequest.getT();
        //由于前端传入的监区及分监区为编号，而user表中为名称，故需要转换为名称后进行查询
        if (!StringUtils.isEmpty(dto.getBigGroup())){
            Units units = unitsMapper.selectByPrimaryKey(Integer.parseInt(dto.getBigGroup()));
            if (units != null){
                dto.setBigGroup(units.getName());
            }
        }
        if (!StringUtils.isEmpty(dto.getGroup())){
            Units units = unitsMapper.selectByPrimaryKey(Integer.parseInt(dto.getGroup()));
            if (units != null){
                dto.setGroup(units.getName());
            }
        }
        List<UserInfo> users =  userInfoMapper.selectPage(dto);
        //增加狱情关键字查询
        for(UserInfo userInfo :users){
            List<PSentimentResult> pSentimentResultList = sentimentService.queryKeywordByCriminalNo(userInfo.getNo());
            if (pSentimentResultList != null  && pSentimentResultList.size()>0){
                StringBuffer keywordSb = new StringBuffer();
                for(PSentimentResult pSentimentResult :pSentimentResultList){
                    if (!StringUtils.isEmpty(pSentimentResult.getKeyword())){
                        keywordSb.append(pSentimentResult.getKeyword()).append("、");
                    }
                }
                userInfo.setKeyword(keywordSb.toString());
            }
        }

        return new PageInfo<UserInfo>(users);
    }
}

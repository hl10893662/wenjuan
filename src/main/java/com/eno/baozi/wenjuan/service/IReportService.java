package com.eno.baozi.wenjuan.service;

import com.eno.baozi.wenjuan.common.domain.PageRequest;
import com.eno.baozi.wenjuan.common.domain.PageResponse;
import com.eno.baozi.wenjuan.domain.QueryUserDTO;
import com.eno.baozi.wenjuan.domain.UserInfo;

public interface IReportService {
    /**
     * 查询用户列表（分页)
     * @return
     */
    PageResponse<UserInfo> queryUserByPage(PageRequest<QueryUserDTO> dto);
}

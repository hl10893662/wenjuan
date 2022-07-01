package com.eno.baozi.wenjuan.common.util;

import com.eno.baozi.wenjuan.common.domain.PageRequest;
import com.eno.baozi.wenjuan.common.domain.PageResponse;
import com.github.pagehelper.PageInfo;

public class PageUtils {
    /**
     * 将分页信息封装到统一的接口
     * @param pageRequest
     * @param pageInfo
     * @return
     */
    public static PageResponse getPageResult(PageRequest pageRequest, PageInfo<?> pageInfo) {
        PageResponse pageResult = new PageResponse();
        pageResult.setPageNum(pageInfo.getPageNum());
        pageResult.setPageSize(pageInfo.getPageSize());
        pageResult.setTotalSize(pageInfo.getTotal());
        pageResult.setTotalPages(pageInfo.getPages());
        pageResult.setContent(pageInfo.getList());
        return pageResult;
    }
}

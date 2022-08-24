package com.eno.baozi.sentiment.common.page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(value="分页参用封装")
public class PageRequest<T> implements Serializable {
    @ApiModelProperty(value="页码")
    private int pageNum;
    @ApiModelProperty(value="每页数量")
    private int pageSize;
    private T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "PageRequest{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", t=" + t.toString() +
                '}';
    }
}


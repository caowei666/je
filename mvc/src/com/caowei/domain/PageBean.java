package com.caowei.domain;

import java.util.List;

public class PageBean<T> {
    private Integer pageNum;
    private Integer pageSize;
    private Long totalSize;
    private Integer pageCount;
    private List<T> data;

    public PageBean(Integer pageNum, Integer pageSize, Long totalSize, List<T> data) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.totalSize = totalSize;
        this.pageCount =  (int)(this.totalSize%this.pageSize==0?this.totalSize/this.pageSize:(this.totalSize/this.pageSize+1));
        this.data = data;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Long getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(Long totalSize) {
        this.totalSize = totalSize;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}

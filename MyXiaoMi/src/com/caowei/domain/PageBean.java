package com.caowei.domain;

import java.util.List;

public class PageBean<T> {
    //页码
    private int pageNum;
    //页大小
    private int pageSize;
    //总数据个数
    private long totalSize;
    //总页数
    private int pageCount;
    //数据
    private List<T> data;
    //设置开始页和结束页
    private int startPage;
    private int endPage;

    public PageBean() {
    }

    public PageBean(int pageNum, int pageSize, long totalSize, List<T> data) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.totalSize = totalSize;
        this.data = data;
        this.pageCount = (int)(totalSize%pageSize==0?totalSize/pageSize:(totalSize/pageSize+1));
        //设置开始页码和结束页码
        this.startPage = pageNum-4;
        this.endPage = pageNum+5;
        if(pageNum<5){
            this.startPage=1;
            this.endPage=10;
        }
        if(pageNum>pageCount-5){
            this.startPage = pageCount-9;
            this.endPage = pageCount;
        }
        if(pageCount<10){
            this.startPage = 1;
            this.endPage = pageCount;
        }
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

    public long getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(long totalSize) {
        this.totalSize = totalSize;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}

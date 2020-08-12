package com.test.ssm.exam.util;

import lombok.Data;

import java.util.List;

@Data
public class TableData<T> {
    private int code=0;
    private String msg="";
    private long count;
    private List<T> data;

    public TableData() {
    }

    public TableData(long count, List<T> data) {
        this.count = count;
        this.data = data;
    }
}

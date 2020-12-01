package com.smu.edu.vo;

import lombok.Data;

import java.util.List;

@Data
public class PageList<T> {
    private Long total;

    private List<T> records;
}

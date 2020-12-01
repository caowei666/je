package com.smu.edu.vo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PageInfoList {
    private String id;
    private String title;
    private String teacherName;
    private BigDecimal price;
    private Integer lessonNum;
    private String cover;
    private Long buyCount;
    private String subjectParentName;
    private String subjectName;
    private long total;
}

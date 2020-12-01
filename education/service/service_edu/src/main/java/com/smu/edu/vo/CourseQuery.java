package com.smu.edu.vo;

import lombok.Data;

@Data
public class CourseQuery {
    private Integer current;
    private Integer size;
    private String title;
    private String teacherId;
    private String subjectParentId;
    private String subjectId;
    private String status;
    private boolean buyCountSort;
    private boolean gmtCreateSort;
    private boolean priceSort;
}

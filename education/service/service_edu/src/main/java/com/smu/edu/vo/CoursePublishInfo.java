package com.smu.edu.vo;

import lombok.Data;

@Data
public class CoursePublishInfo {
    private String id;
    private String title;
    private String cover;
    private Integer lessonNum;
    private String courseDescription;
    private String oneSubject;
    private String twoSubject;
    private String price;
}

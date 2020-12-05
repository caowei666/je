package com.smu.edu.vo;

import com.smu.edu.domain.Subject;
import com.smu.edu.domain.Teacher;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class PageInfoList {
    private String id;
    private String title;
    private Teacher teacherName;
    private BigDecimal price;
    private Integer lessonNum;
    private String cover;
    private Long buyCount;
    private Subject subjectParentName;
    private Subject subjectName;
}

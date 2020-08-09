package com.test.ssm.exam.pojo;

import lombok.Data;

@Data
public class Menu {
    private Integer id;
    private String name;
    private String url;
    private Integer parentId;
    private Integer sort;
}

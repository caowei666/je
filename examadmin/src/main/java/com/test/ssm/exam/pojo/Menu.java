package com.test.ssm.exam.pojo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Menu {
    private Integer id;
    private String name;
    private String url;
    private Integer parentId;
    private Integer sort;
    private List<Menu> children = new ArrayList<>();
}

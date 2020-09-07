package com.test.boot.pojo;

import lombok.Data;

@Data
public class Role {
    private Integer id;
    private String name;
    private String remark;
    private Integer status;
    public String getText(){
        return this.name;
    }
}

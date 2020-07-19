package com.caowei.domain;

public class GoodsType {
    private Integer id;
    private String name;
    private Integer level;
    private Integer parent;

    public GoodsType() {
    }

    public GoodsType(Integer id, String name, Integer level, Integer parent) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.parent = parent;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getParent() {
        return parent;
    }

    public void setParent(Integer parent) {
        this.parent = parent;
    }
}

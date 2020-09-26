package com.test.bike.pojo;

import java.io.Serializable;
import java.util.Date;

public class Record implements Serializable {
    private Integer id;
    private PlatForm platForm;
    private String num;
    private String detail;
    private Date createDate;
    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PlatForm getPlatForm() {
        return platForm;
    }

    public void setPlatForm(PlatForm platForm) {
        this.platForm = platForm;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}

package com.caowei.domain;

import java.util.Date;

public class Student {
    private Integer studentNo;
    private String loginPwd;
    private String studentName;
    private String sex;
    private Date bornDate;

    public Student() {
    }

    public Student(Integer studentNo, String loginPwd, String studentName, String sex, Date bornDate) {
        this.studentNo = studentNo;
        this.loginPwd = loginPwd;
        this.studentName = studentName;
        this.sex = sex;
        this.bornDate = bornDate;
    }

    public Integer getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(Integer studentNo) {
        this.studentNo = studentNo;
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBornDate() {
        return bornDate;
    }

    public void setBornDate(Date bornDate) {
        this.bornDate = bornDate;
    }
}

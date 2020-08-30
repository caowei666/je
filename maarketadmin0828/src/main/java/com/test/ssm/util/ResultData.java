package com.test.ssm.util;

public class ResultData {
    private boolean status;
    private String message;

    public ResultData(boolean status, String message) {
        this.status = status;
        this.message = message;
    }

    public ResultData(boolean status) {
        this.status = status;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

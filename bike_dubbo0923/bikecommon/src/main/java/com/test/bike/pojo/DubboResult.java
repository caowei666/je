package com.test.bike.pojo;

import java.io.Serializable;

public class DubboResult implements Serializable {
    private boolean success;
    private String message;

    public DubboResult(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

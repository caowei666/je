package com.test.boot.util;

import lombok.Data;

@Data
public class AjaxResult {
    private boolean status;
    private String message;
    private Object result;

    public AjaxResult() {
    }

    public AjaxResult(boolean status, String message, Object result) {
        this.status = status;
        this.message = message;
        this.result = result;
    }
}

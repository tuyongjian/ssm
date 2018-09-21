package com.ssm.exception;

/**
 * Created by tuyongjian on 2018/9/21.
 */

public class CustomException extends Exception {
    //异常信息
    public String message;

    public boolean success =false;

    public CustomException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
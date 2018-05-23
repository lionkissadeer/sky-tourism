package com.skytech.application.exceptionhandler;

/**
 * Created by Lianhong_ on 2018/05/21 13:24
 */

public class RestServiceError {

    private String code;
    private String message;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static RestServiceError build(String code, String message) {
        RestServiceError error = new RestServiceError();
        error.code = code;
        error.message = message;
        return error;
    }
}

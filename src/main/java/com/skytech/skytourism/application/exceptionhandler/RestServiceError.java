package com.skytech.skytourism.application.exceptionhandler;

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

    public static RestServiceError build(Type errorType, String message) {
        RestServiceError error = new RestServiceError();
        error.code = errorType.getCode();
        error.message = message;
        return error;
    }

    public enum Type {
        BAD_REQUEST_ERROR("error.badRequest", "Bad request error"),
        INTERNAL_SERVER_ERROR("error.internalServer", "Unexpected server error"),
        VALIDATION_ERROR("error.validation", "Found validation issues");

        private String code;
        private String message;

        Type(String code, String message) {
            this.code = code;
            this.message = message;
        }

        public String getCode() {
            return code;
        }

        public String getMessage() {
            return message;
        }
    }
}

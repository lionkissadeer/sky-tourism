package com.skytech.application.exceptionhandler.exception;

/**
 * Created by Lianhong_ on 2018/05/23 13:24
 */
public class ApplicationException extends RuntimeException {

    private String code;

    public String getCode() {
        return code;
    }

    /**
     * 构造函数
     *
     * @param code    异常码
     * @param message 异常消息
     */
    public ApplicationException(String code, String message) {
        this(message);
        this.code = code;
    }

    /**
     * 构造函数
     *
     * @param message 异常消息
     */
    public ApplicationException(String message) {
        super(message, null, true, false);
        this.code = "UNKNOWN";
    }
}

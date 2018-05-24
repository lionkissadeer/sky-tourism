package com.skytech.skytourism.usermanagement.domain.reponse;

/**
 * Created by Lianhong_ on 2018/05/23 18:29
 */
public enum ResultStatusCode {

    INVALID_CLIENTID(30003, "Invalid clientId"),
    INVALID_PASSWORD(30004, "User name or password is incorrect"),
    INVALID_CAPTCHA(30005, "Invalid captcha or captcha overdue"),
    INVALID_TOKEN(30006, "Invalid token"),
    SYSTEM_ERR(30007, "Server error"),
    OK(0, "OK");

    private int code;
    private String message;

    ResultStatusCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

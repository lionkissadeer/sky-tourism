package com.skytech.skytourism.usermanagement.domain.exception;

import com.skytech.application.exceptionhandler.exception.ApplicationException;

/**
 * Created by Lianhong_ on 2018/05/21 11:29
 */
public class UserException extends ApplicationException {

    public UserException(String code, String message) {
        super(code, message);
    }
}
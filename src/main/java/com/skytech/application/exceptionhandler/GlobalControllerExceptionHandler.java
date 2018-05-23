package com.skytech.application.exceptionhandler;

import com.skytech.application.exceptionhandler.exception.ApplicationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Set;

/**
 * Created by Lianhong_ on 2018/05/21 13:21
 */
@ControllerAdvice
public class GlobalControllerExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalControllerExceptionHandler.class);

    // 异常处理方法：
    // 根据特定的异常返回指定的 HTTP 状态码
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)  // 400
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    public RestServiceError handleValidationException(ConstraintViolationException ex) {
        Set<ConstraintViolation<?>> errors = ex.getConstraintViolations();
        StringBuilder strBuilder = new StringBuilder();
        for (ConstraintViolation<?> violation : errors) {
            strBuilder.append(violation.getMessage() + "\n");
        }
        return RestServiceError.build("BAD_REQUEST", strBuilder.toString());
    }

    // 通用异常的处理，返回500
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)  // 500
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public RestServiceError handleException(Exception ex) {
        logger.error("系统异常。", ex);
        return RestServiceError.build("INTERNAL_SERVER_ERROR", ex.getMessage());
    }

    // 业务异常的处理，返回200
    @ResponseStatus(value = HttpStatus.OK)  // 200
    @ExceptionHandler(ApplicationException.class)
    @ResponseBody
    public RestServiceError handleApplicationException(ApplicationException ex) {
        logger.error("业务异常。", ex);
        return RestServiceError.build(ex.getCode(), ex.getMessage());
    }
}

package org.community.api.controller;

import org.community.core.common.ReturnMsg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by frodo on 2016/11/18.
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(FileController.class);

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public ReturnMsg defaultErrorHandler(Exception ex, HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.error("defaultErrorHandler", ex);
        if (ex instanceof OAuth2Exception) {
            return ReturnMsg.fail(ReturnMsg.CODE_OAUTH2_ERROR, ex.getMessage());
        } else if (ex instanceof RuntimeException) {
            return ReturnMsg.fail(ReturnMsg.CODE_INTERNAL_ERROR, ex.getMessage());
        }
        return ReturnMsg.fail(ReturnMsg.CODE_UNKNOWN_ERROR, ex.getMessage());
    }

}

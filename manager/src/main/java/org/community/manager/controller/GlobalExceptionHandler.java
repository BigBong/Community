package org.community.manager.controller;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by frodo on 2016/11/18.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public void handleException(Exception ex, HttpServletRequest request, HttpServletResponse response) {
        StringBuffer sb = new StringBuffer();
        if (ex instanceof MaxUploadSizeExceededException) {
            sb.append("文件大小不应大于" + ((MaxUploadSizeExceededException) ex).getMaxUploadSize() / 1000 + "kb");
        } else {
            sb.append(ExceptionUtils.getFullStackTrace(ex));
        }
        logger.info(sb.toString());
        try {
            response.setContentType("text/html; charset=utf-8");
            response.getWriter().println(sb.toString());
            response.getWriter().flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

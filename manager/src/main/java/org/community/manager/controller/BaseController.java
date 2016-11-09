package org.community.manager.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.junit.internal.Throwables;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

/**
 * Created by frodo on 2015/4/9.
 */
public class BaseController {
    private static final Logger logger = LoggerFactory.getLogger(BaseController.class);

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

package org.community.api.service;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.codehaus.jackson.map.ObjectMapper;
import org.community.core.common.CommunityException;
import org.community.api.common.Secret;
import org.community.api.utils.DESUtils;
import org.community.api.utils.GZipUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by frodoking on 2014/12/23.
 */
@Aspect
public class SecurityAspect {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private ObjectMapper objectMapper = new ObjectMapper();

    @Around(value = "@annotation(org.community.api.service.EncryptResponse)", argNames = "proceedingJoinPoint")
    public Object aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object resObj = proceedingJoinPoint.proceed(proceedingJoinPoint.getArgs());
        byte[] resByte = new byte[0];
        try {
            resByte = objectMapper.writeValueAsBytes(resObj);
        } catch (Exception e) {
            throw new CommunityException("write error ." + e.getMessage());
        }
        return DESUtils.encryptString(resByte, Secret.DES_KEY);
    }


    @Around(value = "@annotation(org.community.api.service.EncryptCompressResponse)", argNames = "proceedingJoinPoint")
    public Object compressAroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object resObj = proceedingJoinPoint.proceed(proceedingJoinPoint.getArgs());
        byte[] resByte = new byte[0];
        try {
            resByte = objectMapper.writeValueAsBytes(resObj);
        } catch (Exception e) {
            throw new CommunityException("write error ." + e.getMessage());
        }
        return GZipUtils.compress(DESUtils.encryptString(resByte, Secret.DES_KEY));
    }
}

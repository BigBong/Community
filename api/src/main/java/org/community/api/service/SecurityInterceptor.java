package org.community.api.service;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.community.api.common.ApiConstant;
import org.community.core.common.CommunityException;
import org.community.api.common.Secret;
import org.community.api.model.EncryptionParams;
import org.community.api.utils.Coder;
import org.community.api.utils.DESUtils;
import org.community.api.utils.GZipUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by frodoking on 2014/12/23.
 */
public class SecurityInterceptor extends HandlerInterceptorAdapter {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        boolean decrypt = false;
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            MethodParameter[] methodParameters = handlerMethod.getMethodParameters();
            for (MethodParameter methodParameter : methodParameters) {
                if (methodParameter.getParameterType().getName().equals(EncryptionParams.class.getName())) {
                    decrypt = true;
                    break;
                }

            }
        }

        if (!decrypt) {
            return true;
        }
        logger.debug("decompress and decrypt ...");
        String compress = request.getParameter("c");
        String data = request.getParameter("data");
        String urlDecodeParam = request.getParameter("urlDecode");
        int urlDecode = Integer.parseInt(urlDecodeParam == null ? "1" : urlDecodeParam);
        if ("1".equals(compress)) {
            data = GZipUtils.decompress(data);
        }
        String sign = request.getParameter("sign");
        if (data == null || data.length() == 0 || sign == null || sign.length() == 0) {
            throw new IllegalArgumentException("param null");
        }
        String localSign = DigestUtils.md5Hex(data + Secret.SIGNATURE);
        if (!sign.equals(localSign)) {
            throw new SecurityException("Forbidden");
        }
        byte[] decryptData = null;
        try {
            decryptData = DESUtils.decrypt(Coder.decryptBASE64(data), Secret.DES_KEY);
        } catch (Exception e) {
            throw new CommunityException("signature verify error." + e.getMessage());
        }

        if (decryptData == null || decryptData.length == 0) {
            throw new CommunityException("decrypt data error.");
        }

        String paramString = new String(decryptData);
        logger.debug("encrypt params:{}", paramString);
        if (ApiConstant.URL_DECODE != urlDecode) {
            request.setAttribute(ApiConstant.PARAMS_DATA, paramString);  // value ==json
        } else {
            Map<String, String> paramMap = new HashMap<String, String>();
            List<NameValuePair> nameValuePairList = URLEncodedUtils.parse(paramString, Charset.forName("UTF-8"));
            for (NameValuePair nameValuePair : nameValuePairList) {
                paramMap.put(nameValuePair.getName(), nameValuePair.getValue());
            }
            request.setAttribute(ApiConstant.PARAMS_DATA, paramMap);  //value== map
        }
        return true;
    }
}

package org.community.api.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by frodoking on 2014/12/23.
 */
public class EncryptionParams {
    private String data;  //数据
    private String sign; //签名
    private String c;   //是否压缩  1==压缩
    private int urlDecode=1;   //是否url decode ,  1==decode 为需要urlDeEncoding
    private boolean debug=false;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public int getUrlDecode() {
        return urlDecode;
    }

    public void setUrlDecode(int urlDecode) {
        this.urlDecode = urlDecode;
    }

    public boolean isDebug() {
        return debug;
    }

    public void setDebug(boolean debug) {
        this.debug = debug;
    }

    public Map<String,Object> buildParams(){
        Map<String,Object> rsMap =new HashMap<String, Object>();
        rsMap.put("data",data);
        rsMap.put("sign",sign);
        rsMap.put("urlDecode",urlDecode);
        rsMap.put("debug",debug);
        if(c!=null){
            rsMap.put("c",c);
        }
        return rsMap;
    }
}

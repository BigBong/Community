package org.community.core.common;

public class ReturnMsg {

    public static final int CODE_SUCCESS = 200;
    public static final int CODE_OAUTH2_ERROR = 300;
    public static final int CODE_INTERNAL_ERROR = 400;
    public static final int CODE_UNKNOWN_ERROR = 500;
    private int code;
    private String message;
    private Object data;

    public ReturnMsg(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }


    public static ReturnMsg error(String errorMessage) {
        return new ReturnMsg(CODE_UNKNOWN_ERROR, errorMessage, "");
    }

    public static  ReturnMsg fail(int errorCode, String message) {
        switch (errorCode) {
            case CODE_OAUTH2_ERROR:
                return new ReturnMsg(errorCode, "无访问权限", message);
            case CODE_INTERNAL_ERROR:
                return new ReturnMsg(errorCode, "内部处理出错", message);
            case CODE_UNKNOWN_ERROR:
                return new ReturnMsg(errorCode, "内部处理出错", message);
        }
        return new ReturnMsg(errorCode, "fail", message);
    }

    public static  ReturnMsg  success(String successMessage) {
        return success(successMessage, "");
    }

    public static ReturnMsg success(String successMessage, Object data) {
        return new ReturnMsg(CODE_SUCCESS, successMessage, data);
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
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

package org.community.core.common;

public class ReturnMsg {

    public static int CODE_SUCCESS = 200;
    public static int CODE_FAIL = 400;
    public static int CODE_UNKNOWN_ERROR = 300;
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

    public static  ReturnMsg fail() {
        return new ReturnMsg(CODE_FAIL, "fail", "");
    }

    public static  ReturnMsg fail(String message) {
        return new ReturnMsg(CODE_FAIL, message, "");
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

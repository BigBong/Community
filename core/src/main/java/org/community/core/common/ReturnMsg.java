package org.community.core.common;

public class ReturnMsg<T> {

    public static int CODE_SUCCESS = 200;
    public static int CODE_FAIL = 400;
    public static int CODE_UNKNOWN_ERROR = 300;
    private int code;
    private String message;
    private T data;

    public void setCode(int code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static ReturnMsg error(String errorMessage) {
        ReturnMsg returnMsg = new ReturnMsg();
        returnMsg.setCode(CODE_UNKNOWN_ERROR);
        returnMsg.setMessage(errorMessage);
        return returnMsg;
    }

    public static ReturnMsg fail() {
        ReturnMsg returnMsg = new ReturnMsg();
        returnMsg.setCode(CODE_FAIL);
        returnMsg.setMessage("fail");
        return returnMsg;
    }

    public static <T> ReturnMsg<T> success(T data) {
        ReturnMsg<T> returnMsg = new ReturnMsg<T>();
        returnMsg.setCode(CODE_SUCCESS);
        returnMsg.setMessage("success");
        returnMsg.setData(data);
        return returnMsg;
    }

    public static ReturnMsg success(String successMessage) {
        ReturnMsg returnMsg = new ReturnMsg();
        returnMsg.setCode(CODE_SUCCESS);
        returnMsg.setMessage(successMessage);
        return returnMsg;
    }
}

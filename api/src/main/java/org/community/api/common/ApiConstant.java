package org.community.api.common;

/**
 * Created by frodoking on 2014/12/23.
 */
public interface ApiConstant {
    public static final String DATETIME_FORMAT = "YYYY-MM-dd HH:mm:ss";

    public static final String APPLICATION_JSON_VALUE = "application/json;charset=UTF-8";

    public static final String PARAMS_DATA = "paramsData";

    public static final int FLAG_NONE = 0x00;    // No flags
    public static final int FLAG_SSL = 0x01;    // Use SSL
    public static final int FLAG_TLS = 0x02;    // Use TLS
    public static final int FLAG_AUTHENTICATE = 0x04;    // Use name/password for authentication
    public static final int FLAG_TRUST_ALL = 0x08;

    public static final String POP3 = "pop3";
    public static final String IMAP = "imap";
    public static final String EXCHANGE = "eas";
    public static final String SMTP = "smtp";


    public static final String TASK_CODE_EVENT = "A101";
    public static final String TASK_CODE_COLLECT = "A102";
    public static final String TASK_CODE_FEEDBACK = "A103";
    public static final String TASK_CODE_EVENT_ACCOUNT = "A104";

    public static final int URL_DECODE= 1;
}
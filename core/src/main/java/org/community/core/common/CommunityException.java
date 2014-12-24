package org.community.core.common;

/**
 * 异常统一封装
 * Created by frodoking on 2014/12/23.
 */
public class CommunityException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public CommunityException() {
        super();
    }

    public CommunityException(String message) {
        super(message);
    }

    public CommunityException(String message, Throwable cause) {
        super(message, cause);
    }

    public CommunityException(Throwable cause) {
        super(cause);
    }

    public Throwable getRootCause() {
        Throwable t = this;
        while (true) {
            Throwable cause = t.getCause();
            if (cause!=null) {
                t = cause;
            } else {
                break;
            }
        }
        return t;
    }
}
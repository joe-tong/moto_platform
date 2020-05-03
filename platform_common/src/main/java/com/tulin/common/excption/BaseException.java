package com.tulin.common.excption;


import com.tulin.common.base.enumeration.ResponseCode;

/**
 * @author User
 */
public class BaseException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private int code;
    private String msg;

    public BaseException(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public BaseException(int code, String msg, Throwable cause) {
        super(msg, cause);
        this.code = code;
        this.msg = msg;
    }

    public BaseException(ResponseCode responseCode) {
        this(responseCode, responseCode.getMsg(), (Throwable) null);
    }

    public BaseException(ResponseCode responseCode, String msg) {
        this(responseCode, msg, (Throwable) null);
    }

    public BaseException(ResponseCode responseCode, String msg, Throwable cause) {
        this(responseCode.getCode(), msg, cause);
    }

    public int getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }
}
package com.tulin.common.enums;

/**
 * 10000表示用户错误码
 */
public enum UserErrorEnum  {

    用户不存在(10000);
    private int code;
    private String msg;

    private UserErrorEnum(int code) {
        this.code = code;
        this.msg = this.name();
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }
}

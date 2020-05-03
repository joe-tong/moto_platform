package com.tulin.common.base.enumeration;//


/**
 * @author tpp
 */

public enum ResponseCode implements BaseEnum<Integer> {
    /**
     * 响应状态数据
     */
    SUCCESS(200),
    ERROR(500),
    图片格式不对(501),
    视频格式不对(502),
    不允许为空(503),
    重新登录(504),
    库存为空(505),
    超出库存(506);
    private int code;
    private String msg;

    private ResponseCode(int code) {
        this.code = code;
        this.msg = this.name();
    }

    private ResponseCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public Integer code() {
        return this.code;
    }


    public int getCode() {
        return this.code;
    }
}

package com.tulin.common.enums;

public enum OrderStateEnum {
    UNHANDLED(0),
    HANDLED(1);
    private int state;

    OrderStateEnum(int state) {
        this.state = state;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}

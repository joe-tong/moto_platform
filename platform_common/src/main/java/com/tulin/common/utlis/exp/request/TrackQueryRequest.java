package com.tulin.common.utlis.exp.request;

/**
 * @author TPP
 * @Desciption 即时查询请求参数
 * @date 2018/12/5
 */

public class TrackQueryRequest {
    /**
     * 订单编号(可不传)
     */
    private String OrderCode;
    /**
     * 快递公司编码(必传)
     */
    private String ShipperCode;
    /**
     * 物流单号(必传)
     */
    private String LogisticCode;

    public TrackQueryRequest(String orderCode, String shipperCode, String logisticCode) {
        OrderCode = orderCode;
        ShipperCode = shipperCode;
        LogisticCode = logisticCode;
    }

    public String getOrderCode() {
        return OrderCode;
    }

    public void setOrderCode(String orderCode) {
        OrderCode = orderCode;
    }

    public String getShipperCode() {
        return ShipperCode;
    }

    public void setShipperCode(String shipperCode) {
        ShipperCode = shipperCode;
    }

    public String getLogisticCode() {
        return LogisticCode;
    }

    public void setLogisticCode(String logisticCode) {
        LogisticCode = logisticCode;
    }
}

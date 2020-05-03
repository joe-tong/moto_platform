package com.tulin.common.utlis.exp.response;

import java.util.List;

/**
 * @author TPP
 * @Desciption 即时查询响应数据
 * @date 2018/12/5
 */
public class TrackQueryResponse {

    /**
     * EBusinessID : 1109259
     * OrderCode :
     * ShipperCode : SF
     * LogisticCode : 118461988807
     * Success : true
     * State : 3
     * Reason : null
     * Traces : [{"AcceptTime":"2014/06/25 08:05:37","AcceptStation":"正在派件..(派件人:邓裕富,电话:18718866310)[深圳 市]","Remark":null},{"AcceptTime":"2014/06/25 04:01:28","AcceptStation":"快件在 深圳集散中心 ,准备送往下一站 深圳 [深圳市]","Remark":null},{"AcceptTime":"2014/06/25 01:41:06","AcceptStation":"快件在 深圳集散中心 [深圳市]","Remark":null},{"AcceptTime":"2014/06/24 20:18:58","AcceptStation":"已收件[深圳市]","Remark":null},{"AcceptTime":"2014/06/24 20:55:28","AcceptStation":"快件在 深圳 ,准备送往下一站 深圳集散中心 [深圳市]","Remark":null},{"AcceptTime":"2014/06/25 10:23:03","AcceptStation":"派件已签收[深圳市]","Remark":null},{"AcceptTime":"2014/06/25 10:23:03","AcceptStation":"签收人是：已签收[深圳市]","Remark":null}]
     */

    private String EBusinessID;
    private String OrderCode;
    private String ShipperCode;
    private String LogisticCode;
    private boolean Success;
    private int State;
    private Object Reason;
    private List<TracesBean> Traces;

    public String getEBusinessID() {
        return EBusinessID;
    }

    public void setEBusinessID(String EBusinessID) {
        this.EBusinessID = EBusinessID;
    }

    public String getOrderCode() {
        return OrderCode;
    }

    public void setOrderCode(String OrderCode) {
        this.OrderCode = OrderCode;
    }

    public String getShipperCode() {
        return ShipperCode;
    }

    public void setShipperCode(String ShipperCode) {
        this.ShipperCode = ShipperCode;
    }

    public String getLogisticCode() {
        return LogisticCode;
    }

    public void setLogisticCode(String LogisticCode) {
        this.LogisticCode = LogisticCode;
    }

    public boolean isSuccess() {
        return Success;
    }

    public void setSuccess(boolean Success) {
        this.Success = Success;
    }

    public int getState() {
        return State;
    }

    public void setState(int State) {
        this.State = State;
    }

    public Object getReason() {
        return Reason;
    }

    public void setReason(Object Reason) {
        this.Reason = Reason;
    }

    public List<TracesBean> getTraces() {
        return Traces;
    }

    public void setTraces(List<TracesBean> Traces) {
        this.Traces = Traces;
    }

    public static class TracesBean {
        /**
         * AcceptTime : 2014/06/25 08:05:37
         * AcceptStation : 正在派件..(派件人:邓裕富,电话:18718866310)[深圳 市]
         * Remark : null
         */

        private String AcceptTime;
        private String AcceptStation;
        private Object Remark;

        public String getAcceptTime() {
            return AcceptTime;
        }

        public void setAcceptTime(String AcceptTime) {
            this.AcceptTime = AcceptTime;
        }

        public String getAcceptStation() {
            return AcceptStation;
        }

        public void setAcceptStation(String AcceptStation) {
            this.AcceptStation = AcceptStation;
        }

        public Object getRemark() {
            return Remark;
        }

        public void setRemark(Object Remark) {
            this.Remark = Remark;
        }
    }
}

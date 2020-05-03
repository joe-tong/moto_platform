package com.tulin.platform_model.vo.response;

import lombok.Data;

@Data
public class UnHandledOrderDTO {
    private String publishTime;
    private String tel;
    private String address;
    private String longitude;
    private String latitude;
    private int distance;
}

package com.tulin.common.utlis.exp.url;


import com.alibaba.fastjson.JSON;
import com.tulin.common.utlis.exp.request.TrackQueryRequest;
import com.tulin.common.utlis.exp.util.CheckSignature;
import com.tulin.common.utlis.exp.util.ExpSendPost;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

import static com.tulin.common.utlis.exp.util.CheckSignature.urlEncoder;


/**
 * @author TPP
 * @Desciption
 * @date 2018/12/5
 * <p>
 * 快递鸟物流轨迹即时查询接口
 * DEMO中的电商ID与私钥仅限测试使用，正式环境请单独注册账号
 * 单日超过500单查询量，建议接入我方物流轨迹订阅推送接口
 * <p>
 * ID和Key请到官网申请：http://www.kdniao.com/ServiceApply.aspx
 */
@Component
@PropertySource(value = "classpath:exp.properties", encoding = "utf-8")
public class KdniaoTrackQueryAPI {

    @Value("${EBusinessID}")
    private static String EBusinessID;

    @Value("${AppKey}")
    private static String AppKey;

    @Value("${TrackQueryReqURL}")
    private static String TrackQueryReqURL;


    public static void main(String[] args) {
        try {
            TrackQueryRequest trackQueryRequest = new TrackQueryRequest("1", "ANE", "210001633605");
            String result = KdniaoTrackQueryAPI.getOrderTraces(trackQueryRequest);
            System.out.print(result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param request
     *            即时查询物流的请求参数
     * @return
     * @throws Exception
     */
    public static String getOrderTraces(TrackQueryRequest request) throws Exception {
        String requestData = JSON.toJSONString(request);
        Map<String, String> params = new HashMap<>();
        params.put("RequestData", urlEncoder(requestData, "UTF-8"));
        params.put("EBusinessID", EBusinessID);
        params.put("RequestType", "1002");
        String dataSign = CheckSignature.encrypt(requestData, AppKey, "UTF-8");
        params.put("DataSign", urlEncoder(dataSign, "UTF-8"));
        params.put("DataType", "2");
        String result = ExpSendPost.sendPost(TrackQueryReqURL, params);
        return result;
    }





}

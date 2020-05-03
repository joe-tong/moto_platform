package com.tulin.platform_system.wx;

/**
 * @author joe
 */
public interface WeChatService {
    /**
     * 微信扫码登录请求地址的生成
     * @return
     */
    String getQRCodeUrl();

    /**
     * 微信扫码后的回调处理
     * @param input
     * @return
     */
    Boolean wxCallBack(LoginProtocol.WeChatQrCodeCallBack.Input input);
}

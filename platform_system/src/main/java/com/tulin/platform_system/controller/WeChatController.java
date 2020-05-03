package com.tulin.platform_system.controller;


import com.tulin.common.base.controller.ServerResponse;
import com.tulin.platform_system.wx.LoginProtocol;
import com.tulin.platform_system.wx.WeChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author joe
 */
@RestController
public class WeChatController {

    @Autowired
    private WeChatService weChatService;

    /**
     * 获取微信登陆二维码地址
     * @return
     */
    @GetMapping("/getQRCodeUrl")
    public ServerResponse getQRCodeUrl() {
       return ServerResponse.createBySuccess(weChatService.getQRCodeUrl());
    }

    /**
     * 微信扫码回调处理
     * 使用 @Valid + BindingResult 进行 controller 参数校验，实现断路器。大家可以根据自己的喜好来，不必跟我这样做
     * @param input
     * @param bindingResult
     * @return
     */
    @GetMapping("/wxCallBack")
    public String wxCallBack(@RequestBody @Valid LoginProtocol.WeChatQrCodeCallBack.Input input, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "failedPage";
        }

        if (weChatService.wxCallBack(input)) {
            return "successPage";
        } else {
            return "failedPage";
        }
    }
}

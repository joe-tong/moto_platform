package com.tulin.platform_system.wx;

/**
 * @author joe
 */
public interface Message {
    class WeChatQrCode {
        public static final String USER_UNAUTHORIZED = "wechat.qrcode.user.no.authorized";
        public static final String REQUEST_INVALID = "wechat.qrcode.request.invalid";
        public static final String USER_UNBINDING = "wechat.qrcode.user.no.binding";
        public static final String STATE_NOT_NULL = "wechat.qrcode.callback.state.not.null";
        public static final String THIRD_ID_NOT_NULL = "wechat.qrcode.bind.third.id.not.null";
        public static final String MOBILE_NOT_NULL = "wechat.qrcode.bind.mobile.not.null";
        public static final String MOBILE_NOT_EXIST = "wechat.qrcode.bind.mobile.not.exist";
    }
}

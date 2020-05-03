package com.tulin.common.base;

/**
 * @author TPP
 * @Desciption 常量
 * @date 2018/12/3
 */
public class Const {
    /**
     * 文件上传相对路径
     */
    public static final String FILE_UPLOAD_RELATIVE_PATH = "UPLOAD/";
    /**
     * 图片相对地址
     */
    public static final String IMAGE_UPLOAD_RELATIVE_PATH = FILE_UPLOAD_RELATIVE_PATH + "image/";
    /**
     * 视频相对地址
     */
    public static final String VIDEO_UPLOAD_RELATIVE_PATH = FILE_UPLOAD_RELATIVE_PATH + "video/";
    /**
     * app的token
     */
    public static final String LOGIN_TOKEN_KEY = "x-shop-token";

    /**
     * 是否启动商品规格
     */
    public interface IsSpecification {
        int open = 1;//启动
        int close = 0;//关闭
    }

    /**
     * 是否货到付款
     */
    public interface GoodsPay {
        int yes = 1;//是
        int no = 0;//否
    }

    /**
     * 是否立即上架
     */
    public interface OnShelf {
        int yes = 1;//是
        int no = 0;//否
    }
    /**
     * 是否开启自动上架
     */

    public interface AutoUpShelf {
        int yes = 0;//是
        int no = 1;//否
    }

    /**
     * 是否开启自动上架
     */

    public interface AutoDownShelf {
        int yes = 0;//是
        int no = 1;//否
    }


}

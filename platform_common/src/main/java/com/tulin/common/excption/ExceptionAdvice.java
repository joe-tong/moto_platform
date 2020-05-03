package com.tulin.common.excption;

import com.tulin.common.base.controller.ServerResponse;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理切面
 *
 * @author ShiXian
 */
@RestControllerAdvice
public class ExceptionAdvice {


    /**
     * 400 - Bad Request
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ServerResponse handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        return ServerResponse.createByErrorCodeMessage("could_not_read_json", 400);
    }


    /**
     * 405 - Method Not Allowed
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ServerResponse handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        return ServerResponse.createByErrorCodeMessage("request_method_not_supported", 405);
    }

    /**
     * 415 - Unsupported Media Type
     */
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public ServerResponse handleHttpMediaTypeNotSupportedException(Exception e) {
        return ServerResponse.createByErrorCodeMessage("content_type_not_supported", 415);
    }

    /**
     * 500 - Internal Server Error
     */
    @ExceptionHandler(Exception.class)
    public ServerResponse handleException(Exception e) {
        return ServerResponse.createByErrorCodeMessage("服务运行异常", 500);
    }

    @ExceptionHandler(DuplicateKeyException.class)
    public ServerResponse handleDuplicateKeyException(DuplicateKeyException e) {
        return ServerResponse.createByErrorCodeMessage("数据库中已存在该记录", 417);
    }


    /**
     * 基础异常异常
     */
    @ExceptionHandler(BaseException.class)
    public ServerResponse handleBaseException(BaseException e) {
        return ServerResponse.createByErrorCodeMessage(e.getMsg(), e.getCode());
    }

    /**
     * 自定义异常
     * @param e
     * @return
     */
    @ExceptionHandler(WrapException.class)
    public ServerResponse handleRRException(WrapException e) {
        return ServerResponse.createByErrorCodeMessage(e.getMsg(), e.getCode());
    }





}

package com.tulin.platform_system.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "前端用户模块")
@RequestMapping("/user/font")
@RestController
public class FontUserController {


    @ApiOperation("门户用户登录")
    @PostMapping("/login")
    public void login(){

    }
}

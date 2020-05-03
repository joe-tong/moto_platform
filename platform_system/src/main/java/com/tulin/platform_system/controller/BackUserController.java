package com.tulin.platform_system.controller;

import com.tulin.api.user.UserService;
import com.tulin.common.base.controller.BaseController;
import com.tulin.common.base.controller.ServerResponse;
import com.tulin.platform_model.vo.request.UserLoginRequest;
import com.tulin.platform_model.vo.UserLoginVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

@Api(tags = "后台用户模块")
@RequestMapping("/user/back")
@RestController
public class BackUserController extends BaseController {

//    @Resource
//    private UserService userService;
//
//    @ApiOperation("后台用户登录")
//    @PostMapping("/login")
//    public ServerResponse<UserLoginVO> login(@RequestBody @Valid UserLoginRequest request){
//
//       return userService.login(request);
//    }
}

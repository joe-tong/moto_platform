package com.tulin.platform_model.vo.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@ApiModel
@Data
@Setter
@Getter
public class UserLoginRequest {
    @NotBlank
    @ApiModelProperty(name = "电话号码")
    private String tel;
    @ApiModelProperty(name = "昵称")
    private String nickName;
    @ApiModelProperty(name = "真实名称")
    private String realName;
    @ApiModelProperty(name = "验证码")
    private String code;
}

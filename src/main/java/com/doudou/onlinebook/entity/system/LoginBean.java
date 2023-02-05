package com.doudou.onlinebook.entity.system;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.*;

/**
 * @author ：zhuyk
 * @date ：Created in 2023-1-31 14:29
 * @modified By：
 * @version: $
 */
@ToString
@Setter
@Getter
@ApiModel(value = "用户登录信息")
public class LoginBean {

    //@Pattern(regexp="^[a-zA-Z0-9|_]+$",message="密码必须由字母、数字、下划线组成！")
    @NotEmpty(message = "用户密码不能为空！")
    @Size(min=6, max=15,message="密码长度必须在 6 ~ 15 字符之间！")
    private String userPwd;

    @NotBlank(message = "用户NO不能为空")
    @Size(min=2, max=20,message="用户NO必须在 2 ~ 20 字符之间！")
    private String userNo;
}

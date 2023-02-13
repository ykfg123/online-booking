package com.doudou.onlinebook.entity.system;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;


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
    @NotEmpty(message = "密码不能为空！")
    private String userPwd;

    @NotEmpty(message = "用户名不能为空！")
    private String userNo;
}

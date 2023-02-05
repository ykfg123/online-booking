package com.doudou.onlinebook.controller;

import com.doudou.onlinebook.entity.UserInfoBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户测试用例
 * @author 程就人生
 * @Date
 */
@Api(tags = "用户信息", description = "UserInfoController")
@RestController
@Log4j2
@RequestMapping("/userInfo")
public class UserInfoController {


    @PostMapping("/fssf")
    @ApiOperation(value = "新增",notes="用户信息", httpMethod="POST")
    public UserInfoBean addUserInfo(@Validated UserInfoBean userInfoBean, BindingResult errors){
        //对表单进行验证
        if (errors.hasErrors()){
            //对错误集合进行遍历,有的话,直接放入map集合中
            errors.getFieldErrors().forEach(p->{
                throw new RuntimeException(p.getDefaultMessage());
            });
        }
        log.info("全部验证通过~！");
        return userInfoBean;
    }
}

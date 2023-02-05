package com.doudou.onlinebook.controller;

import com.alibaba.fastjson.JSONObject;
import com.doudou.onlinebook.entity.RequestVo;
import com.doudou.onlinebook.entity.StaffManageBean;
import com.doudou.onlinebook.entity.system.LoginBean;
import com.doudou.onlinebook.service.UserManagerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：zhuyk
 * @date ：Created in 2021/12/4 15:50
 * @modified By：
 * @version: $
 */
@RestController
@RequestMapping("/user")
@Log4j2
@Api(tags = "登录接口", description = "LoginController")
public class LoginController {

    @Autowired
    private UserManagerService userManagerService;
    @ApiOperation(value = "新增",notes="用户信息", httpMethod="POST")
    @PostMapping(value = "/login", produces = "text/html;charset=UTF-8")
    public String login(@RequestBody RequestVo requestVo){

        JSONObject obj = new JSONObject();
        int i =0;
        try {
            userManagerService.login(requestVo);
            obj.put("code",i+"");
            obj.put("data","0");
            obj.put("mgc","Login Success");
        }catch (Exception e){
            log.error("登录报错",e);
            obj.put("code","-1");
            obj.put("data","-1");
            obj.put("mgc","Login Failed");
            return obj.toString();
        }
        return  obj.toString();
    }
    @ApiOperation(value = "系统登录",notes="用户登录", httpMethod="POST")
    @PostMapping(value = "/loginSys", produces = "text/html;charset=UTF-8")
    public String loginSys(@RequestBody LoginBean loginBean){

        JSONObject obj = new JSONObject();
        int i =0;
        try {
            StaffManageBean staffManageBean = userManagerService.loginSys(loginBean);
            obj.put("code",i+"");
            obj.put("data",staffManageBean);
            obj.put("mgc","Login Success");
        }catch (Exception e){
            log.error("登录报错",e);
            obj.put("code","-1");
            obj.put("data","-1");
            obj.put("mgc","Login Failed");
            return obj.toString();
        }
        return  obj.toString();
    }
}

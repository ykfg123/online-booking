package com.doudou.onlinebook.controller;

import com.alibaba.fastjson.JSONObject;
import com.doudou.onlinebook.entity.RequestVo;
import com.doudou.onlinebook.service.UserManagerService;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.core.Logger;
import org.slf4j.LoggerFactory;
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
public class LoginController {

    @Autowired
    private UserManagerService userManagerService;

    @PostMapping(value = "/login", produces = "text/html;charset=UTF-8")
    public String login(@RequestBody RequestVo requestVo){

        JSONObject obj = new JSONObject();
        int i =0;
        try {
            userManagerService.login(requestVo);
            obj.put("code",i+"");
            obj.put("data","0");
            obj.put("mgc","Booking Success");
        }catch (Exception e){
            log.error("登录报错",e);
            obj.put("code","-1");
            obj.put("data","-1");
            obj.put("mgc","Booking Failed");
            return obj.toString();
        }
        return  obj.toString();
    }
}

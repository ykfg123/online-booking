package com.doudou.onlinebook.controller;

import com.alibaba.fastjson.JSONObject;
import com.doudou.onlinebook.entity.RequestVo;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：zhuyk
 * @date ：Created in 2021/12/22 23:25
 * @description：服务功能模块
 * @modified By：
 * @version: 1.0.0$
 */
@RestController
@RequestMapping("/service")
@Log4j2
public class ServiceController {

    /*
    *
     * @功能描述: 添加服务
     * @author zhuyk
     * @date 2021/12/22 23:31
     * @param: [requestVo]
     * @return: java.lang.String
     */
    @PostMapping(value = "/add", produces = "text/html;charset=UTF-8")
    public String addService(@RequestBody RequestVo requestVo){
        JSONObject obj = new JSONObject();

        return obj.toString();
    }

}

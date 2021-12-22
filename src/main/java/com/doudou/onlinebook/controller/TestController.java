package com.doudou.onlinebook.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author ：zhuyk
 * @date ：Created in 2021/11/23 19:45
 * @modified By：
 * @version: $
 */

@RestController
@Log4j2
public class TestController {


    @RequestMapping("/")
    @ResponseBody
    public String index(){

        return "预定管理后台启动成功";
    }

}

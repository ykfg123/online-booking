package com.doudou.onlinebook.controller;

import com.alibaba.fastjson.JSONObject;
import com.doudou.onlinebook.entity.TestBean;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


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
    @RequestMapping("/test")
    @ResponseBody
    public String test(String address,
                       String name,
                       String pageIndex,
                       String pageSize){
        JSONObject obj = new JSONObject();
        List<TestBean> list = new ArrayList<>();
        TestBean testBean = new TestBean();
        testBean.setTitle("今天要修复100个bug");
        testBean.setStatus(true);
        list.add(testBean);
        obj.put("list",list);
        return obj.toString();
    }

}

package com.doudou.onlinebook.controller;

import com.alibaba.fastjson.JSONObject;
import com.doudou.onlinebook.entity.HotMailBean;
import com.doudou.onlinebook.entity.RequestVo;
import com.doudou.onlinebook.service.OrderShowService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ：zhuyk
 * @date ：Created in 2021/11/22 20:23
 * @modified By：工单显示
 * @version: $
 */
@RestController
@RequestMapping("/order")
@Log4j2
public class OrderShowController {

    @Autowired
    private OrderShowService orderShowService;

    @PostMapping(value = "/show", produces = "text/html;charset=UTF-8")
    public String show(@RequestBody RequestVo vo){

        JSONObject obj = new JSONObject();
        List<HotMailBean> list =null;
        try {
            list = orderShowService.show(vo);
            obj.put("data",list);
            obj.put("code","0");
            obj.put("mgc","Booking Success");
        }catch (Exception e){
            log.error("工单显示 vo{}",vo,e);
            obj.put("code","-1");
            obj.put("mgc","Booking Failed");
            return obj.toString();
        }
        return obj.toString();
    }
}

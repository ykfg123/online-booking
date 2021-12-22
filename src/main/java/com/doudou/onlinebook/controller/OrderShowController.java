package com.doudou.onlinebook.controller;

import com.alibaba.fastjson.JSONObject;
import com.doudou.onlinebook.entity.HotMailBean;
import com.doudou.onlinebook.entity.RequestVo;
import com.doudou.onlinebook.service.OrderShowService;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.core.Logger;
import org.slf4j.LoggerFactory;
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
        Integer total = 0;
        try {
            list = orderShowService.show(vo);
            total =orderShowService.getTotal(vo);
            obj.put("data",list);
            obj.put("total",total);
            obj.put("code","0");
            obj.put("mgc","Show order success");
        }catch (Exception e){
            log.error("获取订单列表报错",e);
            obj.put("code","-1");
            obj.put("mgc","Show order failed");
            return obj.toString();
        }
        return obj.toString();
    }
    @PostMapping(value = "/details", produces = "text/html;charset=UTF-8")
    public String showDetails(@RequestBody RequestVo vo){

        JSONObject obj = new JSONObject();
        HotMailBean hotMailBean =null;
        try {
            hotMailBean = orderShowService.showDetails(vo);
            obj.put("data",hotMailBean);
            obj.put("code","0");
            obj.put("mgc","Get details Success");
        }catch (Exception e){
            log.error("获取订单详情报错",e);
            obj.put("code","-1");
            obj.put("mgc","Booking Failed");
            return obj.toString();
        }
        return obj.toString();
    }

}

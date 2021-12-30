package com.doudou.onlinebook.controller.monitor;

import com.alibaba.fastjson.JSONObject;
import com.doudou.onlinebook.entity.monitor.LargeScreenMonitorBean;
import com.doudou.onlinebook.entity.RequestVo;
import com.doudou.onlinebook.service.monitor.LargeScreenMonitorService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：zhuyk
 * @date ：Created in 2021/12/29 15:01
 * @modified By：首页监控模块
 * @version: 1.0.0$
 */
@RestController
@RequestMapping("/monitor")
@Log4j2
public class LargeScreenMonitorController {

    @Autowired
    public LargeScreenMonitorService largeScreenMonitorService;

    @PostMapping(value = "/homepage", produces = "text/html;charset=UTF-8")
    public String homePage(@RequestBody RequestVo vo){
        JSONObject obj = new JSONObject();
        try {
            LargeScreenMonitorBean  list = largeScreenMonitorService.getMonitorData(vo);
            obj.put("data",list);
            obj.put("code","0");
            obj.put("mgc","Get home page data success");
        } catch (Exception e) {
            log.error("获取首页监控报错 RequestVo{}",vo,e);
            obj.put("code","-1");
            obj.put("mgc","Get home page data failed");
            return obj.toString();
        }
        return obj.toString();
    }
}

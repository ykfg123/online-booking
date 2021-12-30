package com.doudou.onlinebook.controller;

import com.alibaba.fastjson.JSONObject;
import com.doudou.onlinebook.entity.RequestVo;
import com.doudou.onlinebook.entity.system.SystemBean;
import com.doudou.onlinebook.service.system.SystemService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ：zhuyk
 * @date ：Created in 2021/12/23 22:30
 * @description：系统设置模块
 * @modified By：
 * @version: 1.0.0$
 */
@RestController
@RequestMapping("/system")
@Log4j2
public class SystemController {

    @Autowired
    public SystemService systemService;

    @PostMapping(value = "/set", produces = "text/html;charset=UTF-8")
    public String setSystem(@RequestBody List<SystemBean> list){
        JSONObject obj = new JSONObject();
        Integer result =0;
        try {
            result = systemService.setSystem(list);
            obj.put("data",result);
            obj.put("code","0");
            obj.put("mgc","Set system Success");
        } catch (Exception e) {
            obj.put("code","-1");
            obj.put("mgc","Set system failed");
            log.error("系统设置错误，list{}",list,e);
        }
        return obj.toString();
    }

    @PostMapping(value = "/delete", produces = "text/html;charset=UTF-8")
    public String deleteSystem(@RequestBody RequestVo vo){
        JSONObject obj = new JSONObject();
        Integer result =0;
        try {
            result = systemService.deleteSystem(vo);
            obj.put("data",result);
            obj.put("code","0");
            obj.put("mgc","Delete system Success");
        } catch (Exception e) {
            obj.put("code","-1");
            obj.put("mgc","Delete system failed");
            log.error("系统设置删除错误，RequestVo{}",vo,e);
        }
        return obj.toString();
    }
    @PostMapping(value = "/details", produces = "text/html;charset=UTF-8")
    public String showDetails(@RequestBody RequestVo vo){
        JSONObject obj = new JSONObject();
        SystemBean systemBean = null;
        try {
            systemBean = systemService.showDetails(vo);
            obj.put("data",systemBean);
            obj.put("code","0");
            obj.put("mgc","Delete system Success");
        } catch (Exception e) {
            obj.put("code","-1");
            obj.put("mgc","Delete system failed");
            log.error("获取系统设置详情错误，RequestVo{}",vo,e);
        }
        return obj.toString();
    }

}

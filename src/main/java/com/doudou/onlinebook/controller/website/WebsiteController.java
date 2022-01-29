package com.doudou.onlinebook.controller.website;

import com.alibaba.fastjson.JSONObject;
import com.doudou.onlinebook.entity.website.WebsiteTemplateBean;
import com.doudou.onlinebook.service.website.WebsiteTemplateService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ：zhuyk
 * @date ：Created in 2022/1/19 11:34
 * @modified By：网站模板模块
 * @version: 1.0.0$
 */
@RestController
@RequestMapping("/website")
@Log4j2
public class WebsiteController {

    @Autowired
    private WebsiteTemplateService websiteTemplateService;
    @PostMapping(value = "/template/{typeId}", produces = "text/html;charset=UTF-8")
    public String show(@PathVariable String typeId){
        JSONObject obj = new JSONObject();
        List<WebsiteTemplateBean> list =null;
       try{
           list = websiteTemplateService.show(typeId);
        obj.put("data",list);
        obj.put("code","0");
        obj.put("mgc","Show template success");
    }catch (Exception e){
        log.error("获取模板列表报错",e);
        obj.put("code","-1");
        obj.put("mgc","Show template failed");
        return obj.toString();
    }
        return obj.toString();
    }
}

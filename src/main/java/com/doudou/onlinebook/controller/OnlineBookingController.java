package com.doudou.onlinebook.controller;

import com.alibaba.fastjson.JSONObject;
import com.doudou.onlinebook.entity.BookingServicesBean;
import com.doudou.onlinebook.entity.HotMailBean;
import com.doudou.onlinebook.service.OnlineBookingService;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.core.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Value;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.List;
import java.util.Properties;

/**
 * @author ：zhuyk
 * @date ：Created in 2021/11/12 21:18
 * @modified By：
 * @version: $
 */
@RestController
@RequestMapping("/insalonhair/online")
@Log4j2
public class OnlineBookingController {

    @Autowired
    JavaMailSender jsm;
    @Value("${spring.mail.username}")
    private String username;
    @Autowired
    public OnlineBookingService onlineBookingService;

    @RequestMapping("/booking")
    public JSONObject booking(String str){
        JSONObject obj = new JSONObject();
        obj.put("data",str);
        //建立邮箱消息
        SimpleMailMessage message = new SimpleMailMessage();
        //发送者
        message.setFrom(username);
        //接收者
        message.setTo("ykfg123@163.com");
        //发送标题
        message.setSubject("测试");
        //发送内容
        message.setText("测试数据");

        jsm.send(message);
        return obj;
    }

    @PostMapping(value = "/hotmail", produces = "text/html;charset=UTF-8")
    public String hotmail(@RequestBody  HotMailBean hotMailBean){

        JSONObject obj = new JSONObject();
        int i =0;
        try {
         i = onlineBookingService.sendHotmail(hotMailBean);
            obj.put("code",i+"");
            obj.put("data","0");
            obj.put("mgc","Booking Success");
        }catch (Exception e){
            log.error("预定报错",e);
            obj.put("code","-1");
            obj.put("data","-1");
            obj.put("mgc","Booking Failed");
            return obj.toString();
        }
        return  obj.toString();
    }
}

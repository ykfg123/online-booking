package com.doudou.onlinebook.controller.system;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：zhuyk
 * @date ：Created in 2019/8/27 10:39
 * @modified 安全认证 错误返回
 * @version: 1.0.0$
 */
@RestController
@RequestMapping("/error")
public class SecurityAuthFailedController {

    @RequestMapping("/timeout")
    @ResponseBody
    public JSONObject timeOut(){
        JSONObject obj = new JSONObject();
        obj.put("code","00005");
        obj.put("msg","请求的timestamp超过20分钟");
        return obj;
    }
    @RequestMapping("/signerror")
    @ResponseBody
    public JSONObject signError(){
        JSONObject obj = new JSONObject();
        obj.put("code","00006");
        obj.put("msg","签名错误");
        return obj;
    }
    @RequestMapping("/appkeyerror")
    @ResponseBody
    public JSONObject appKeyError(){
        JSONObject obj = new JSONObject();
        obj.put("code","00007");
        obj.put("msg","appKey不存在");
        return obj;
    }
    @RequestMapping("/parametererror")
    @ResponseBody
    public JSONObject parameterError(){
        JSONObject obj = new JSONObject();
        obj.put("code","00008");
        obj.put("msg","系统参数不能为空");
        return obj;
    }

}
package com.doudou.onlinebook.controller;

import com.alibaba.fastjson.JSONObject;
import com.doudou.onlinebook.entity.HotMailBean;
import com.doudou.onlinebook.entity.RequestVo;
import com.doudou.onlinebook.entity.StaffManageBean;
import com.doudou.onlinebook.service.StaffManageService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ：zhuyk
 * @date ：Created in 2021/12/23 10:46
 * @modified By：员工管理功能
 * @version: 1.0.0$
 */
@RestController
@RequestMapping("/staff")
@Log4j2
public class StaffManageController {

    @Autowired
    private StaffManageService staffManageService;

    /**
     * create by: zhuyk
     * description: 展示员工列表
     * create time: 2021/12/23 10:49
     * @params：  * @Param: vo
     * @return java.lang.String
     */
    @PostMapping(value = "/show", produces = "text/html;charset=UTF-8")
    public String show(@RequestBody RequestVo vo){
        JSONObject obj = new JSONObject();
        Integer total = 0;
        try {
            List<StaffManageBean> list = staffManageService.show(vo);
            total =staffManageService.getTotal(vo);
            obj.put("data",list);
            obj.put("total",total);
            obj.put("code","0");
            obj.put("mgc","Show order list success");
        } catch (Exception e) {
            log.error("获取员工列表报错 RequestVo{}",vo,e);
            obj.put("code","-1");
            obj.put("mgc","Show order list failed");
            return obj.toString();
        }
        return obj.toString();
    }

    /**
     * create by: zhuyk
     * description: 添加员工
     * create time: 2021/12/23 10:51
     *
     * @return a
     * @params： * @Parm: null
     */
    @PostMapping(value = "/add", produces = "text/html;charset=UTF-8")
    public String add(@RequestBody StaffManageBean staffManageBean){
        JSONObject obj = new JSONObject();
        try {
            Integer result =staffManageService.add(staffManageBean);
            obj.put("data",result);
            obj.put("code","0");
            obj.put("mgc","Add to staff success");
        } catch (Exception e) {
            log.error("添加员工报错 staffManageBean{}",staffManageBean,e);
            obj.put("code","-1");
            obj.put("mgc","Add to staff failed");
            return obj.toString();
        }
        return obj.toString();
    }

    /**
     * create by: zhuyk
     * description: 删除员工
     * create time: 2021/12/23 11:04
     * params：  * @Paam: null
     *
     * @return a
     */
    @PostMapping(value = "/delete/{id}", produces = "text/html;charset=UTF-8")
    public String deleteStaff(@PathVariable Integer id){
        JSONObject obj = new JSONObject();
        try {
            Integer result = staffManageService.deleteStaff(id);
            obj.put("data",result);
            obj.put("code","0");
            obj.put("mgc","Delete staff success");
        } catch (Exception e) {
            log.error("删除员工报错 id{}",id,e);
            obj.put("code","-1");
            obj.put("mgc","Delete staff failed");
            return obj.toString();
        }
        return obj.toString();
    }

    /**
     * create by: zhuyk
     * description: 员工详情
     * create time: 2021/12/23 11:07
     * params：  * @Param: null
     *
     * @return
     */
    @PostMapping(value = "/details/{id}", produces = "text/html;charset=UTF-8")
    public String showDetails(@PathVariable Integer id){
        JSONObject obj = new JSONObject();
        try {
        StaffManageBean staffManageBean = staffManageService.showDetails(id);
        obj.put("data",staffManageBean);
        obj.put("code","0");
        obj.put("mgc","Get details success");
    } catch (Exception e) {
        log.error("获取员工详情报错 id{}",id,e);
        obj.put("code","-1");
        obj.put("mgc","Get details failed");
        return obj.toString();
    }
        return obj.toString();
    }

}

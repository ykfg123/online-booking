package com.doudou.onlinebook.service;

import com.alibaba.fastjson.JSONObject;
import com.doudou.onlinebook.entity.alexandradebooking.AlexAndradeBookingBean;
import com.doudou.onlinebook.entity.alexandradebooking.InvalidFieldBean;

import java.util.List;

/**
 * @author ：zhuyk
 * @date ：Created in 2022-10-13 11:31
 * @modified By：
 * @version: $
 */
public interface AlexAndradeService {

    boolean checkField(AlexAndradeBookingBean alexAndradeBookingBean, JSONObject obj, List<InvalidFieldBean> list);
}

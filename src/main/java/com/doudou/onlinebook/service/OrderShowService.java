package com.doudou.onlinebook.service;

import com.doudou.onlinebook.entity.HotMailBean;
import com.doudou.onlinebook.entity.RequestVo;

import java.util.List;

public interface OrderShowService {

    List<HotMailBean> show(RequestVo vo)throws Exception;
}

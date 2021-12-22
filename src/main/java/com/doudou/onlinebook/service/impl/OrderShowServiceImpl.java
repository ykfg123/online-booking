package com.doudou.onlinebook.service.impl;

import com.doudou.onlinebook.dao.OrderShowMapper;
import com.doudou.onlinebook.entity.HotMailBean;
import com.doudou.onlinebook.entity.RequestVo;
import com.doudou.onlinebook.service.OrderShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：zhuyk
 * @date ：Created in 2021/11/22 20:53
 * @modified By：
 * @version: $
 */
@Service
public class OrderShowServiceImpl implements OrderShowService {
    @Autowired
    private OrderShowMapper orderShowMapper;
    @Override
    public List<HotMailBean> show(RequestVo vo) throws Exception {
        return orderShowMapper.show(vo);
    }
}

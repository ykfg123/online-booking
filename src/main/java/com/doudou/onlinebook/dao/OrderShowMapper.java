package com.doudou.onlinebook.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.doudou.onlinebook.entity.HotMailBean;
import com.doudou.onlinebook.entity.RequestVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author ：zhuyk
 * @date ：Created in 2021/11/22 21:00
 * @modified By：
 * @version: $
 */
@Mapper
public interface OrderShowMapper extends BaseMapper<HotMailBean> {
    List<HotMailBean> show(RequestVo vo);
}

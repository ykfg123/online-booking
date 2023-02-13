package com.doudou.onlinebook.dao.rightManage;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.doudou.onlinebook.entity.rightManage.MenuItemBean;
import com.doudou.onlinebook.entity.rightManage.RightBean;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MenuItemMapper extends BaseMapper<MenuItemBean> {
}

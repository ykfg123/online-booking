package com.doudou.onlinebook.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.doudou.onlinebook.entity.RequestVo;
import com.doudou.onlinebook.entity.StaffManageBean;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StaffManageMapper extends BaseMapper<StaffManageBean> {
    public int addStaffInfo(StaffManageBean staffManageBean);
    public StaffManageBean getStaffInfo(RequestVo requestVo);
}

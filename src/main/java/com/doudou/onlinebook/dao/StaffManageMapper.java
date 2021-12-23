package com.doudou.onlinebook.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.doudou.onlinebook.entity.RequestVo;
import com.doudou.onlinebook.entity.StaffManageBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StaffManageMapper extends BaseMapper<StaffManageBean> {

    public int addStaffInfo(StaffManageBean staffManageBean) throws Exception;

    public StaffManageBean getStaffInfo(RequestVo vo) throws Exception;

    public List<StaffManageBean> show(RequestVo vo) throws Exception;

    public  Integer deleteStaff(Integer staffId) throws Exception;

    public  Integer getTotal(RequestVo vo) throws Exception;

    public  StaffManageBean showDetails(@Param("staffId")Integer staffId) throws Exception;
}

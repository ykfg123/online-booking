package com.doudou.onlinebook.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.doudou.onlinebook.entity.RequestVo;
import com.doudou.onlinebook.entity.StaffManageBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StaffManageMapper extends BaseMapper<StaffManageBean> {

    public int addStaffInfo(StaffManageBean staffManageBean) ;

    public StaffManageBean getStaffInfo(RequestVo vo) ;

    public List<StaffManageBean> show(RequestVo vo) ;

    public  Integer deleteStaff(Integer staffId) ;

    public  Integer getTotal(RequestVo vo) ;

    public  StaffManageBean showDetails(@Param("staffId")Integer staffId);
}

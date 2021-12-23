package com.doudou.onlinebook.service;

import com.doudou.onlinebook.entity.RequestVo;
import com.doudou.onlinebook.entity.StaffManageBean;

import java.util.List;

public interface StaffManageService {

    public List<StaffManageBean> show(RequestVo vo) throws Exception;

    public Integer add(StaffManageBean staffManageBean) throws Exception;

    public Integer deleteStaff(Integer staffId) throws Exception;

    public StaffManageBean showDetails(Integer staffId) throws Exception;

    public Integer getTotal(RequestVo vo) throws Exception;
}

package com.doudou.onlinebook.service.impl;

import com.doudou.onlinebook.dao.StaffManageMapper;
import com.doudou.onlinebook.entity.RequestVo;
import com.doudou.onlinebook.entity.StaffManageBean;
import com.doudou.onlinebook.service.StaffManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：zhuyk
 * @date ：Created in 2021/12/23 11:43
 * @modified By：
 * @version: 1.0.0$
 */
@Service
public class StaffManageServiceImpl implements StaffManageService {
    @Autowired
    public StaffManageMapper staffManageMapper;
    @Override
    public List<StaffManageBean> show(RequestVo vo)  throws Exception{

        return staffManageMapper.show(vo);
    }

    @Override
    public Integer add(StaffManageBean staffManageBean)  throws Exception{
        return staffManageMapper.addStaffInfo(staffManageBean);
    }

    @Override
    public Integer deleteStaff(Integer staffId)  throws Exception{
        return staffManageMapper.deleteStaff(staffId);
    }

    @Override
    public StaffManageBean showDetails(Integer staffId)  throws Exception{
        return staffManageMapper.showDetails(staffId);
    }

    @Override
    public Integer getTotal(RequestVo vo)  throws Exception{
        return staffManageMapper.getTotal(vo);
    }
}

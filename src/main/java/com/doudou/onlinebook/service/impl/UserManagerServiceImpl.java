package com.doudou.onlinebook.service.impl;

import com.doudou.onlinebook.dao.StaffManageMapper;
import com.doudou.onlinebook.entity.RequestVo;
import com.doudou.onlinebook.entity.StaffManageBean;
import com.doudou.onlinebook.entity.system.LoginBean;
import com.doudou.onlinebook.service.UserManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ：zhuyk
 * @date ：Created in 2021/12/4 22:43
 * @modified By：
 * @version: $
 */
@Service
public class UserManagerServiceImpl implements UserManagerService {

    @Autowired
    public StaffManageMapper staffManageMapper;
    @Override
    public StaffManageBean login(RequestVo requestVo) throws Exception {

        return staffManageMapper.getStaffInfo(requestVo);
    }

    @Override
    public StaffManageBean loginSys(LoginBean loginBean) throws Exception {
        return staffManageMapper.loginSys(loginBean);
    }
}

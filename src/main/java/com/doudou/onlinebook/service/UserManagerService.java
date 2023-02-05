package com.doudou.onlinebook.service;

import com.doudou.onlinebook.entity.RequestVo;
import com.doudou.onlinebook.entity.StaffManageBean;
import com.doudou.onlinebook.entity.system.LoginBean;

public interface UserManagerService {

    public StaffManageBean login(RequestVo requestVo) throws Exception;

    public StaffManageBean loginSys(LoginBean loginBean)throws Exception;
}

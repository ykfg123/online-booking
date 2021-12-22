package com.doudou.onlinebook.service;

import com.doudou.onlinebook.entity.RequestVo;
import com.doudou.onlinebook.entity.StaffManageBean;

public interface UserManagerService {

    public StaffManageBean login(RequestVo requestVo);

}

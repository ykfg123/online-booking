package com.doudou.onlinebook.service.rightManage;

import com.doudou.onlinebook.entity.rightManage.MenuItemBean;
import com.doudou.onlinebook.entity.rightManage.RightBean;
import com.doudou.onlinebook.entity.rightManage.RightInfoBean;
import com.doudou.onlinebook.entity.rightManage.RightVo;

import java.util.List;

public interface RightManageService {
    public int createRightInfo(RightBean rightBean) throws Exception;

   public Integer getCount(RightVo rightVo) throws Exception;

    public List<RightInfoBean> getRightList(RightVo rightVo) throws Exception;

    public List<MenuItemBean> getMenuList();
}

package com.doudou.onlinebook.service.menuManage;

import com.doudou.onlinebook.entity.menuManage.MenuItemBean;
import com.doudou.onlinebook.entity.menuManage.MenuItemVo;
import com.doudou.onlinebook.entity.rightManage.RightVo;

import java.util.List;

public interface MenuManageService {


   public int createMenuInfo(MenuItemBean menuItemBean) throws Exception;

   public List<MenuItemBean> getMenuList(MenuItemVo rightVo) throws Exception;

   public Integer getCount(MenuItemVo rightVo) throws Exception;

   public List<MenuItemBean> getMenuOption() throws Exception;
}

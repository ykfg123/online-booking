package com.doudou.onlinebook.service.impl.menuManage;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.doudou.onlinebook.dao.menuManage.MenuItemMapper;
import com.doudou.onlinebook.entity.company.CompanyBean;
import com.doudou.onlinebook.entity.menuManage.MenuItemBean;
import com.doudou.onlinebook.entity.menuManage.MenuItemVo;
import com.doudou.onlinebook.service.menuManage.MenuManageService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
@Log4j2
public class MenuManageServiceImpl implements MenuManageService {

    @Autowired
    private MenuItemMapper menuItemMapper;

    @Override
    public int createMenuInfo(MenuItemBean menuItemBean) throws Exception {

        return menuItemMapper.insert(menuItemBean);
    }

    @Override
    public List<MenuItemBean> getMenuList(MenuItemVo menuItemVo) throws Exception {
        QueryWrapper<MenuItemBean> queryWrapper = new QueryWrapper<>();
        Page<MenuItemBean> page = new Page<>(1,10);
        if (!"".equals(menuItemVo.getPageIndex())&&menuItemVo.getPageIndex()>0){
            page.setCurrent(menuItemVo.getPageIndex());
            page.setSize(menuItemVo.getPageSize());
        }
        queryWrapper.like(StringUtils.hasText(menuItemVo.getMenuName()),"menuName",menuItemVo.getMenuName());

        return menuItemMapper.selectPage(page,queryWrapper).getRecords();
    }

    @Override
    public Integer getCount(MenuItemVo menuItemVo) throws Exception {
        QueryWrapper<MenuItemBean> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(StringUtils.hasText(menuItemVo.getMenuName()),"menuName",menuItemVo.getMenuName());

        return menuItemMapper.selectCount(queryWrapper);
    }

    @Override
    public List<MenuItemBean> getMenuOption() throws Exception {

        return menuItemMapper.selectList(null);
    }
}

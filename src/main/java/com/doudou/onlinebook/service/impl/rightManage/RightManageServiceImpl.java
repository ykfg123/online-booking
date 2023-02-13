package com.doudou.onlinebook.service.impl.rightManage;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.doudou.onlinebook.dao.rightManage.MenuItemMapper;
import com.doudou.onlinebook.dao.rightManage.RightManageMapper;
import com.doudou.onlinebook.entity.company.CompanyBean;
import com.doudou.onlinebook.entity.rightManage.MenuItemBean;
import com.doudou.onlinebook.entity.rightManage.RightBean;
import com.doudou.onlinebook.entity.rightManage.RightInfoBean;
import com.doudou.onlinebook.entity.rightManage.RightVo;
import com.doudou.onlinebook.service.rightManage.RightManageService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
@Log4j2
public class RightManageServiceImpl implements RightManageService {

    @Autowired
    private RightManageMapper rightManageMapper;

    @Autowired
    private MenuItemMapper menuItemMapper;
    /**
     * @param rightBean
     * @return
     */
    @Override
    public int createRightInfo(RightBean rightBean) throws Exception{

        return rightManageMapper.insert(rightBean);
    }

    /**
     * @param rightVo
     * @return
     */
    @Override
    public Integer getCount(RightVo rightVo)  throws Exception{
        QueryWrapper<RightBean> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(StringUtils.hasText(rightVo.getRightName()),"right_name",rightVo.getRightName());

        return rightManageMapper.selectCount(queryWrapper);
    }

    /**
     * @param rightVo
     * @return
     */
    @Override
    public List<RightInfoBean> getRightList(RightVo rightVo)  throws Exception{


        return rightManageMapper.getRightList(rightVo);
    }

    /**
     * @return
     */
    @Override
    public List<MenuItemBean> getMenuList() {
        return menuItemMapper.selectList(null);
    }
}

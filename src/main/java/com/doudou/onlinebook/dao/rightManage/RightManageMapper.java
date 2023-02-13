package com.doudou.onlinebook.dao.rightManage;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.doudou.onlinebook.entity.rightManage.RightBean;
import com.doudou.onlinebook.entity.rightManage.RightInfoBean;
import com.doudou.onlinebook.entity.rightManage.RightVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author ：zhuyk
 * @date ：Created in 2021/11/16 16:07
 * @modified By：
 * @version: $
 */
@Mapper
public interface RightManageMapper extends BaseMapper<RightBean> {


   public List<RightInfoBean> getRightList(RightVo rightVo);
}

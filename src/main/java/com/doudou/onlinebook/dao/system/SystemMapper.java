package com.doudou.onlinebook.dao.system;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.doudou.onlinebook.entity.RequestVo;
import com.doudou.onlinebook.entity.system.SystemBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author ：zhuyk
 * @date ：Created in 2021/12/26 20:41
 * @description：系统设置
 * @modified By：
 * @version: 1.0.0$
 */
@Mapper
public interface SystemMapper extends BaseMapper<SystemBean> {

   public Integer setSystem(SystemBean systemBean) ;

   public Integer deleteSystem(RequestVo vo) ;

   public SystemBean showDetails(RequestVo vo) ;;
}

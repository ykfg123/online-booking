package com.doudou.onlinebook.dao.monitor;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.doudou.onlinebook.entity.RequestVo;
import com.doudou.onlinebook.entity.monitor.ServiceDataBean;
import com.doudou.onlinebook.entity.monitor.StaffDataBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author ：zhuyk
 * @date ：Created in 2021/12/30 9:14
 * @modified By：大屏数据
 * @version: 1.0.0$
 */
@Mapper
public interface LargeScreenMonitorMapper extends BaseMapper<StaffDataBean> {


    public Integer getDayNum(RequestVo vo) ;

    public Integer getMonthNum(RequestVo vo) ;

    public Integer getTotalNum(RequestVo vo) ;

    public List<StaffDataBean> getStaffList(RequestVo vo);

    public List<ServiceDataBean> getServiceList(RequestVo vo);
}

package com.doudou.onlinebook.dao.monitor;

import com.doudou.onlinebook.entity.monitor.LargeScreenMonitorBean;
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
public interface LargeScreenMonitorMapper {


    public Integer getDayNum(RequestVo vo) throws Exception;

    public Integer getMonthNum(RequestVo vo) throws Exception;

    public Integer getTotalNum(RequestVo vo) throws Exception;

    public List<StaffDataBean> getStaffList(RequestVo vo)throws Exception;

    public List<ServiceDataBean> getServiceList(RequestVo vo)throws Exception;
}

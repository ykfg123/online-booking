package com.doudou.onlinebook.service.impl.monitor;

import com.doudou.onlinebook.dao.monitor.LargeScreenMonitorMapper;
import com.doudou.onlinebook.entity.monitor.LargeScreenMonitorBean;
import com.doudou.onlinebook.entity.RequestVo;
import com.doudou.onlinebook.entity.monitor.ServiceDataBean;
import com.doudou.onlinebook.entity.monitor.StaffDataBean;
import com.doudou.onlinebook.service.monitor.LargeScreenMonitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：zhuyk
 * @date ：Created in 2021/12/29 15:18
 * @modified By：
 * @version: 1.0.0$
 */
@Service
public class LargeScreenMonitorServiceImpl implements LargeScreenMonitorService {

    @Autowired
    public LargeScreenMonitorMapper largeScreenMonitorMapper;
    @Override
    public LargeScreenMonitorBean getMonitorData(RequestVo vo) throws Exception{
        LargeScreenMonitorBean largeScreenMonitorBean = new LargeScreenMonitorBean();
        Integer dayNum = 0;
        Integer monthNum = 0;
        Integer totalNum = 0;
        List<StaffDataBean> staffList = null;
        List<ServiceDataBean> serviceList = null;
        dayNum = largeScreenMonitorMapper.getDayNum(vo);
        monthNum = largeScreenMonitorMapper.getMonthNum(vo);
        totalNum = largeScreenMonitorMapper.getTotalNum(vo);
        staffList =largeScreenMonitorMapper.getStaffList(vo);
        serviceList =largeScreenMonitorMapper.getServiceList(vo);
        if(dayNum==null||"null".equals(dayNum)){
            largeScreenMonitorBean.setDayNum("0");

        }else {
            largeScreenMonitorBean.setDayNum(dayNum.toString());
        }
        if(monthNum==null||"null".equals(monthNum)){
            largeScreenMonitorBean.setMonthNum("0");

        }else {
            largeScreenMonitorBean.setMonthNum(monthNum.toString());
        }
        if(totalNum==null||"null".equals(totalNum)){
            largeScreenMonitorBean.setTotalNum("0");

        }else {
            largeScreenMonitorBean.setTotalNum(totalNum.toString());
        }
        largeScreenMonitorBean.setStaffDatalist(staffList);
        largeScreenMonitorBean.setServiceDataList(serviceList);
        return largeScreenMonitorBean;
    }
}

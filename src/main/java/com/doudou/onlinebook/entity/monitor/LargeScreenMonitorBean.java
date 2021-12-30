package com.doudou.onlinebook.entity.monitor;

import com.doudou.onlinebook.entity.monitor.ServiceDataBean;
import com.doudou.onlinebook.entity.monitor.StaffDataBean;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * @author ：zhuyk
 * @date ：Created in 2021/12/29 15:24
 * @modified By：
 * @version: 1.0.0$
 */
@Getter
@Setter
@ToString
public class LargeScreenMonitorBean {

    public String monthNum;//月预定数量
    public String dayNum;//今日预定数量
    public String totalNum;//总预定数量
    public List<StaffDataBean> list;//今日员工预定数量
    public List<ServiceDataBean> serviceDataList;//今日服务预定数量

}

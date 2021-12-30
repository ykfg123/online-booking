package com.doudou.onlinebook.service.monitor;

import com.doudou.onlinebook.entity.monitor.LargeScreenMonitorBean;
import com.doudou.onlinebook.entity.RequestVo;

/**
 * @author ：zhuyk
 * @date ：Created in 2021/12/29 15:17
 * @modified By：
 * @version: 1.0.0$
 */
public interface LargeScreenMonitorService {

   public LargeScreenMonitorBean getMonitorData(RequestVo vo) throws Exception;
}

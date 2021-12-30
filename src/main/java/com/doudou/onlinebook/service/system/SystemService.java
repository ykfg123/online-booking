package com.doudou.onlinebook.service.system;

import com.doudou.onlinebook.entity.RequestVo;
import com.doudou.onlinebook.entity.system.SystemBean;

import java.util.List;

/**
 * @author ：zhuyk
 * @date ：Created in 2021/12/26 20:24
 * @description：系统设置
 * @modified By：
 * @version: 1.0.0$
 */
public interface SystemService {

    public Integer setSystem(List<SystemBean> list) throws Exception;

    public Integer deleteSystem(RequestVo vo) throws Exception;

    public SystemBean showDetails(RequestVo vo) throws Exception;
}

package com.doudou.onlinebook.service.impl.system;

import com.doudou.onlinebook.dao.system.SystemMapper;
import com.doudou.onlinebook.entity.RequestVo;
import com.doudou.onlinebook.entity.system.SystemBean;
import com.doudou.onlinebook.service.system.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：zhuyk
 * @date ：Created in 2021/12/26 20:25
 * @description：系统设置实现类
 * @modified By：
 * @version: 1.0.0$
 */
@Service
public class SystemServiceImpl implements SystemService {

    @Autowired
    private SystemMapper systemMapper;
    @Override
    public Integer setSystem(List<SystemBean> list) throws Exception {
        Integer result = 0;
        for (SystemBean systemBean : list) {
           result = systemMapper.setSystem(systemBean);
        }
        return result;
    }

    @Override
    public Integer deleteSystem(RequestVo vo) throws Exception {

        return systemMapper.deleteSystem(vo);
    }

    @Override
    public SystemBean showDetails(RequestVo vo) throws Exception {

        return systemMapper.showDetails(vo);
    }


}

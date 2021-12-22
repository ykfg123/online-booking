package com.doudou.onlinebook.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.doudou.onlinebook.entity.ServiceInfoBean;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ServiceInfoMapper extends BaseMapper<ServiceInfoBean>{
    public ServiceInfoBean getServiceInfo(String serviceId);
}

package com.doudou.onlinebook.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.doudou.onlinebook.entity.StaffBookingLogBean;
import com.doudou.onlinebook.entity.company.CompanyBean;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author ：zhuyk
 * @date ：Created in 2023-8-16 11:31
 * @modified By：
 * @version: 1.0.0$
 */
@Mapper
public interface SendEmailMapper extends BaseMapper<StaffBookingLogBean> {

    int sendEmailLog(StaffBookingLogBean staffBookingLogBean);

    CompanyBean getCompany(String companyId);
}

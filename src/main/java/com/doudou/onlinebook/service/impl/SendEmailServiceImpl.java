package com.doudou.onlinebook.service.impl;

import com.doudou.onlinebook.dao.SendEmailMapper;
import com.doudou.onlinebook.dao.company.CompanyMapper;
import com.doudou.onlinebook.entity.StaffBookingLogBean;
import com.doudou.onlinebook.entity.company.CompanyBean;
import com.doudou.onlinebook.service.SendEmailService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ：zhuyk
 * @date ：Created in 2023-8-16 11:29
 * @modified By：
 * @version: 1.0.0$
 */
@Service
@Log4j2
public class SendEmailServiceImpl implements SendEmailService {

    @Autowired
    private SendEmailMapper sendEmailMapper;
    @Autowired
    private CompanyMapper companyMapper;

    @Override
    public int sendEmail(StaffBookingLogBean staffBookingLogBean) {
        int redult = sendEmailMapper.sendEmailLog(staffBookingLogBean);
        return 0;
    }

    @Override
    public CompanyBean getCompany(StaffBookingLogBean staffBookingLogBean) {
        return companyMapper.getCompanyInfo(staffBookingLogBean.getCompanyId());
    }
}

package com.doudou.onlinebook.service;

import com.doudou.onlinebook.entity.StaffBookingLogBean;
import com.doudou.onlinebook.entity.company.CompanyBean;

/**
 * @author ：zhuyk
 * @date ：Created in 2023-8-16 11:28
 * @modified By：
 * @version: 1.0.0$
 */
public interface SendEmailService {
    int sendEmail(StaffBookingLogBean staffBookingLogBean);

    CompanyBean getCompany(StaffBookingLogBean staffBookingLogBean);
}

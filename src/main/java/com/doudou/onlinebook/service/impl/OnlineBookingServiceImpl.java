package com.doudou.onlinebook.service.impl;

import com.doudou.onlinebook.common.thread.MailSendThread;
import com.doudou.onlinebook.dao.CompanyMapper;
import com.doudou.onlinebook.dao.OnlineBookingMapper;
import com.doudou.onlinebook.entity.BookingServicesBean;
import com.doudou.onlinebook.entity.CompanyBean;
import com.doudou.onlinebook.entity.HotMailBean;
import com.doudou.onlinebook.service.OnlineBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.Random;

/**
 * @author ：zhuyk
 * @date ：Created in 2021/11/12 21:19
 * @modified By：
 * @version: $
 */
@Service
public class OnlineBookingServiceImpl implements OnlineBookingService {
    @Autowired
    JavaMailSender jsm;

    @Value("${spring.mail.username}")
    private String username;

    @Autowired
    public OnlineBookingService onlineBookingService;
    @Autowired
    public OnlineBookingMapper onlineBookingMapper;
    @Autowired
    public CompanyMapper companyMapper;
    @Override
    public int sendHotmail(HotMailBean hotMailBean) throws Exception{
        int result = 0;
        Random random = new Random();
        int ren = random.nextInt(1000000) - 1;
        hotMailBean.setRen(ren+"");
        CompanyBean companyInfo = companyMapper.getCompanyInfo(hotMailBean.getCompanyId());
        new Thread(new MailSendThread(hotMailBean,companyInfo,true,jsm)).start();
        new Thread(new MailSendThread(hotMailBean,companyInfo,false,jsm)).start();
        int sendBooking = onlineBookingMapper.sendBooking(hotMailBean);
        for (BookingServicesBean bsb :hotMailBean.getFormList()) {
            bsb.setBookingId(hotMailBean.getSeqId());
            onlineBookingMapper.sendBookingServices(bsb);
        }
        result = sendBooking>0?0:-1;
        return result;
    }

}

package com.doudou.onlinebook.common.thread;

import com.doudou.onlinebook.entity.BookingServicesBean;
import com.doudou.onlinebook.entity.CompanyBean;
import com.doudou.onlinebook.entity.HotMailBean;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * @author ：zhuyk
 * @date ：Created in 2021/11/21 16:35
 * @modified By：
 * @version: $
 */
@Log4j2
public class MailSendThread implements Runnable {

    private JavaMailSender jsm;
    private HotMailBean hotMailBean;
    private CompanyBean companyInfo;
    private Boolean type;
    public MailSendThread(HotMailBean hotMailBean,CompanyBean companyInfo,Boolean type,JavaMailSender jsm){
        this.hotMailBean = hotMailBean;
        this.companyInfo = companyInfo;
        this.type = type;
        this.jsm = jsm;
    }
    @Override
    public void run() {
        String host = "smtp.office365.com";
        String mailStoreType = "smtp";
        String popPort = "587";
        final Properties props = new Properties();

        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.store.protocol", mailStoreType);
        props.put( "mail.smtp.port", popPort );
        //开启SSL
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.socketFactory.port",popPort);
        props.put("mail.smtp.socketFactory.fallback","false");
/*

        Session session = Session.getDefaultInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("Insalonhair@hotmail.com", "Welcome@123");//账号密码
            }
        });
        session.setDebug(true);
        // 创建邮件消息
        MimeMessage message = new MimeMessage(session);

       try {
           // 设置发件人
           InternetAddress form = new InternetAddress("Insalonhair@hotmail.com");
           message.setFrom(form);
           // 设置收件人
           InternetAddress toAddress = new InternetAddress(type?companyInfo.getCompanyEmail():hotMailBean.getBookingEmail());
           message.setRecipient(Message.RecipientType.TO, toAddress);
           // 设置邮件标题
           message.setSubject(companyInfo.getCompanyName()+":Reservation has been submitted:Reference number "+hotMailBean.getRen());
           // 设置邮件的内容体
           String initContent = initContent(hotMailBean,companyInfo,type);
           message.setContent(initContent, "text/html;charset=UTF-8");
           // 发送邮件
          Transport.send(message);
       }catch (Exception e){
           log.error("MailSendThread",e);
       }
*/


    }
    private String initContent(HotMailBean hotMailBean,CompanyBean companyInfo,boolean type){
        StringBuffer sb = new StringBuffer();
        sb.append(companyInfo.getCompanyName()+":<br>");
        sb.append("Confirmation Appointment.<br>" +
                "Appointment Date: ");
        sb.append(hotMailBean.getBookingTime()+"<br>");
        for (BookingServicesBean bsb: hotMailBean.getFormList()) {
            sb.append("Time: "+bsb.getServiceTime()+"<br>");
            sb.append("Service: "+bsb.getServiceName()+"<br>");
            sb.append("Staff: "+bsb.getStaffName()+"<br>");
        }
        sb.append("Business Number: "+(type?hotMailBean.getBusinessNumber():companyInfo.getCompanyTel())+"(Ref #:"+hotMailBean.getRen()+").. To CANCEL call us at "+(type?hotMailBean.getBusinessNumber():companyInfo.getCompanyTel())+".");

        return sb.toString();
    }
}

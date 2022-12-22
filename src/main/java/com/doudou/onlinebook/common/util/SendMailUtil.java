package com.doudou.onlinebook.common.util;


import com.sun.media.jfxmedia.logging.Logger;
import lombok.extern.log4j.Log4j2;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.URLDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

/**
 * @author :yanjun.hou
 * @description : 邮件工具类(包含发送附件 和html模板)
 * @create :2022-09-16 09:09:00
 */
@Log4j2
public class SendMailUtil {
    /**
     * @param subject       主题
     * @param content       内容
     * @param htmlContent   邮件html内容
     * @param email         收件人
     * @param attachmentUrl 附件路径--需要是网络地址
     * @param fileName      文件名称
     * @throws Exception
     */
    public static String sendMail(String subject, String content, String htmlContent, String email, String attachmentUrl, String fileName) {
        try {
            //设置不是草稿
            int draft = 0;
            //普通邮件  优先级(1:紧急 3:普通 5:低)
            int priority = 3;
            //是否需要回执  默认是0，不需要回执
            int receiptFlag = 0;

            Properties props = new Properties();
            String host = "smtp.yeah.net";
            props.setProperty("mail.transport.protocol", "smtp");
            props.setProperty("mail.smtp.host", host);
            props.setProperty("mail.smtp.port", "465");

            props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.setProperty("mail.smtp.socketFactory.fallback", "false");

            //设置了附件名过长问题，从而导致附件名显示带bin的错误，造成附件异常
            System.setProperty("mail.mime.splitlongparameters", "false");

            Session session = Session.getDefaultInstance(props);
            //发件人邮箱
            String from = "netwok8@yeah.net";
            String passWord = "MOFLRFSCGKDDIIJN";
            Message message = new MimeMessage(session);
            message.setSentDate(new Date());
            // 设置发件人地址
            ((MimeMessage) message).setFrom("netwok8<netwok8@yeah.net>");
            // 设置主题
            message.setSubject(subject);
            // 设置收件人
            message.addRecipients(Message.RecipientType.TO, InternetAddress.parse(MimeUtility.encodeText(email)));
            // 设置抄送人
            message.addRecipients(Message.RecipientType.CC, InternetAddress.parse(MimeUtility.encodeText("")));//选填
            // 设置密送人
            message.addRecipients(Message.RecipientType.BCC, InternetAddress.parse(MimeUtility.encodeText("")));//选填

            // 如果是草稿
            if (draft == 1) {
                message.setFlag(Flags.Flag.DRAFT, true);
            }
            // 设置优先级(1:紧急 3:普通 5:低)
            if (priority == 1) {
                message.setHeader("X-Priority", "1");
            }
            // 如果receiptFlag=1 代表需要回执
            if (receiptFlag == 1) {
                message.setHeader("Disposition-Notification-To", from);
            }
            /**
             * 设置邮件内容
             */
            Multipart multipart = new MimeMultipart();
            MimeBodyPart txtPart = new MimeBodyPart();
            txtPart.setContent(content, "text/html;charset=utf-8");
            multipart.addBodyPart(txtPart);

            MimeBodyPart part = new MimeBodyPart();
            /**
             * 附件
             */
            if (StringUtils.isNotEmpty(attachmentUrl)) {
                URL url = new URL(attachmentUrl);
                DataSource dataSource = new URLDataSource(url);
                part.setDataHandler(new DataHandler(dataSource));
            }
            part.setFileName(MimeUtility.encodeText(fileName));

            /**
             * 支持html内容
             */
            MimeBodyPart html = new MimeBodyPart();
            html.setContent(htmlContent, "text/html;charset=utf-8");
            multipart.addBodyPart(html);

            multipart.addBodyPart(part);
            message.setContent(multipart);
            message.setFlag(Flags.Flag.RECENT, true);

            message.saveChanges();

            /**
             * 不是草稿的情况下进行发送
             */
            if (draft == 0) {
                Transport transport = session.getTransport("smtp");
                transport.connect(host, from, passWord);
                transport.sendMessage(message, message.getAllRecipients());
                transport.close();
            }
            return "success";
        } catch (Exception e) {
            log.error(e);
            return null;
        }
    }

    public static void main(String[] args) {

        try {
            String s = sendMail("您有1张电子发票", "测试电子发票", "<h1>测试html</h1>", "xxx@qq.com", "https://xxx.pdf", "电子发票.pdf");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



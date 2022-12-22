package com.doudou.onlinebook.controller;

import com.alibaba.fastjson.JSONObject;
import com.doudou.onlinebook.common.util.Md5Digest;
import com.doudou.onlinebook.common.util.SendMailUtil;
import com.doudou.onlinebook.entity.alexandradebooking.AlexAndradeBookingBean;
import com.doudou.onlinebook.entity.alexandradebooking.InvalidFieldBean;
import com.doudou.onlinebook.service.AlexAndradeService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.security.provider.MD5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ：zhuyk
 * @date ：Created in 2022-10-12 10:56
 * @modified By：
 * @version: $
 */
@RestController
@RequestMapping("/wp-json/contact-form-7/v1/contact-forms")
@Log4j2
public class AlexAndradeController {

    @Value("${email.alex-andrade}")
    private String username;
    @Autowired
    private AlexAndradeService alexAndradeService;

    @RequestMapping(value = "/{id}/feedback")
    public String feedback(AlexAndradeBookingBean alexAndradeBookingBean){
        JSONObject obj = new JSONObject();
        List<InvalidFieldBean> list = new ArrayList<>();
        obj.put("contact_form_id",alexAndradeBookingBean.getId());
        boolean isOk = alexAndradeService.checkField(alexAndradeBookingBean,obj,list);
        obj.put("posted_data_hash",Md5Digest.encrypt32(Long.toString(System.currentTimeMillis())));
        obj.put("into","#"+alexAndradeBookingBean.get_wpcf7_unit_tag());
        //建立邮箱消息
        if(!isOk){
            return obj.toString();
        }
        String[] str = {"First Name",alexAndradeBookingBean.getFirstName(),
                "Last Name",alexAndradeBookingBean.getLastName(),
                "Is This your first experience with Perspective Contracting?",alexAndradeBookingBean.getExperience(),
                "Phone Number",alexAndradeBookingBean.getPhoneNumber(),
                "Email Address",alexAndradeBookingBean.getEmail(),
                "City",alexAndradeBookingBean.getCity(),
                "Street Address",alexAndradeBookingBean.getStreetAddress(),
                "Service Type",alexAndradeBookingBean.getServiceType(),
                "Are You a New Client?",alexAndradeBookingBean.getClient()};
        String[] str1 = {"Name",alexAndradeBookingBean.getName(),
                "Message",alexAndradeBookingBean.getMessage(),
                "Phone",alexAndradeBookingBean.getPhone(),
                "Email",alexAndradeBookingBean.getEmail()};
        if("15106".equals(alexAndradeBookingBean.getId())){
            SendMailUtil.sendMail("New Inquiries come from your website visitors www.alexandradecustomconstruction.com",buildContent("AlexAndrade.html",str),"",username,"https://alexandradecustomconstruction.com/wp-content/uploads/2020/07/PC-Logo-with-Name-Site-Head-1.png","PC-Logo-with-Name-Site-Head-1.png");
        }else {
            SendMailUtil.sendMail("New Inquiries come from your website visitors www.alexandradecustomconstruction.com",buildContent("AlexAndradeSimp.html",str1),"",username,"https://alexandradecustomconstruction.com/wp-content/uploads/2020/07/PC-Logo-with-Name-Site-Head-1.png","PC-Logo-with-Name-Site-Head-1.png");
        }
        return obj.toString();
    }
    @RequestMapping(value = "/{id}/refill")
    public String refill(AlexAndradeBookingBean alexAndradeBookingBean){

        return "[]";
    }
    /**
     * 构建邮件模板信息
     *
     * @param htmlPath    email模板文件路径
     * @param param
     * @return
     */
    public String buildContent(String htmlPath, String[] param) {
        //获取文件路径
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(htmlPath);
        BufferedReader fileReader = null;
        StringBuffer buffer = new StringBuffer();
        String line = "";
        try {
            fileReader = new BufferedReader(new InputStreamReader(inputStream));
            while ((line = fileReader.readLine()) != null) {
                buffer.append(line);
            }
        } catch (Exception e) {
            log.error(String.format("发送邮件读取模板失败，错误堆栈信息：%s", e.getMessage()));
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        //使用动态参数替换html模板中的占位符参数
        String htmlText = MessageFormat.format(buffer.toString(), param);
        return htmlText;
    }
}

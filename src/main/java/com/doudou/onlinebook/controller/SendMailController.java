package com.doudou.onlinebook.controller;

import com.alibaba.fastjson.JSONObject;
import com.doudou.onlinebook.common.util.Md5Digest;
import com.doudou.onlinebook.common.util.Result;
import com.doudou.onlinebook.common.util.SendMailUtil;
import com.doudou.onlinebook.entity.StaffBookingLogBean;
import com.doudou.onlinebook.entity.alexandradebooking.AlexAndradeBookingBean;
import com.doudou.onlinebook.entity.alexandradebooking.InvalidFieldBean;
import com.doudou.onlinebook.entity.company.CompanyBean;
import com.doudou.onlinebook.entity.company.CompanyInfoBean;
import com.doudou.onlinebook.entity.rightManage.RightBean;
import com.doudou.onlinebook.service.SendEmailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ：zhuyk
 * @date ：Created in 2023-8-16 10:01
 * @modified By：
 * @version: 1.0.0$
 */
@RestController
@RequestMapping("/send")
@Log4j2
@Api(tags = "邮件发送", description = "sendMailController")
public class SendMailController {

    @Autowired
    private SendEmailService sendEmailService;

    @ApiOperation(value = "Booking", notes = "BookingService", httpMethod = "POST")
    @PostMapping("/email")
    public Result sendEmail(@Validated StaffBookingLogBean staffBookingLogBean) {
        //对表单进行验证
        try {
            CompanyBean companyBean = sendEmailService.getCompany(staffBookingLogBean);
            int result = sendEmailService.sendEmail(staffBookingLogBean);
            if(result>0){
                String sendEmailInfo = sendEmailInfo(staffBookingLogBean,companyBean);
                if("success".equals(sendEmailInfo)){
                    return Result.success("Success Booking Service !");
                }
            }
        } catch (Exception e) {
            log.error("创建公司失败，请联系管理员！",e);
            return Result.error("Fail Booking Service !");
        }
        return Result.success("Success Booking Service !");
    }
    public String sendEmailInfo(StaffBookingLogBean staffBookingLogBean,CompanyBean companyBean){
        List<InvalidFieldBean> list = new ArrayList<>();
        //建立邮箱消息
        String[] str = {"First Name",staffBookingLogBean.getBookingName(),
                "Phone Number",staffBookingLogBean.getBusinessNumber(),
                "Email Address",staffBookingLogBean.getBookingEmail(),};

        String s = SendMailUtil.sendMail("New Inquiries come from your website visitors ", buildContent("EmailTemplate.html", str), "", companyBean.getCompanyEmail(), companyBean.getCompanyLogo(), "Logo.png");

        return s;
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
        String htmlText = null;
        try {
            htmlText = MessageFormat.format(buffer.toString(), param);
        } catch (Exception e) {
            log.error("使用动态参数替换html模板中的占位符失败", e);
        }
        return htmlText;
    }
}

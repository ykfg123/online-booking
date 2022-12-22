package com.doudou.onlinebook.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.doudou.onlinebook.common.util.StringUtils;
import com.doudou.onlinebook.entity.alexandradebooking.AlexAndradeBookingBean;
import com.doudou.onlinebook.entity.alexandradebooking.InvalidFieldBean;
import com.doudou.onlinebook.service.AlexAndradeService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.MessageFormat;
import java.util.List;

/**
 * @author ：zhuyk
 * @date ：Created in 2022-10-13 11:32
 * @modified By：
 * @version: $
 */
@Service
@Log4j2
public class AlexAndradeServiceImpl implements AlexAndradeService {

    @Override
    public boolean checkField(AlexAndradeBookingBean alexAndradeBookingBean, JSONObject obj, List<InvalidFieldBean> list) {
       boolean isCheck = true;
       boolean isUnSimp = "15106".equals(alexAndradeBookingBean.getId());

        if(isUnSimp&&StringUtils.isEmpty(alexAndradeBookingBean.getLastName())){
            InvalidFieldBean invalidFieldBean = new InvalidFieldBean();
            invalidFieldBean.setField("lastName");
            invalidFieldBean.setMessage("The field is required.");
            invalidFieldBean.setError_id(alexAndradeBookingBean._wpcf7_unit_tag+"-ve-lastName");
            list.add(invalidFieldBean);
            isCheck=false;
        }
        if(isUnSimp&&StringUtils.isEmpty(alexAndradeBookingBean.getFirstName())){
            InvalidFieldBean invalidFieldBean = new InvalidFieldBean();
            invalidFieldBean.setField("firstName");
            invalidFieldBean.setMessage("The field is required.");
            invalidFieldBean.setError_id(alexAndradeBookingBean._wpcf7_unit_tag+"-ve-firstName");
            list.add(invalidFieldBean);
            isCheck=false;
        }
        if(isUnSimp&&StringUtils.isEmpty(alexAndradeBookingBean.getEmail())){
            InvalidFieldBean invalidFieldBean = new InvalidFieldBean();
            invalidFieldBean.setField("email");
            invalidFieldBean.setMessage("The field is required.");
            invalidFieldBean.setError_id(alexAndradeBookingBean._wpcf7_unit_tag+"-ve-email");
            list.add(invalidFieldBean);
            isCheck=false;
        }else if(isUnSimp&&!StringUtils.isEmail(alexAndradeBookingBean.getEmail())){
            InvalidFieldBean invalidFieldBean = new InvalidFieldBean();
            invalidFieldBean.setField("email");
            invalidFieldBean.setMessage("The e-mail address entered is invalid.");
            invalidFieldBean.setError_id(alexAndradeBookingBean._wpcf7_unit_tag+"-ve-email");
            list.add(invalidFieldBean);
            isCheck=false;
        }
        if(isUnSimp&&StringUtils.isEmpty(alexAndradeBookingBean.getPhoneNumber())){
            InvalidFieldBean invalidFieldBean = new InvalidFieldBean();
            invalidFieldBean.setField("phoneNumber");
            invalidFieldBean.setMessage("The field is required.");
            invalidFieldBean.setError_id(alexAndradeBookingBean._wpcf7_unit_tag+"-ve-phoneNumber");
            list.add(invalidFieldBean);
            isCheck=false;
        }else if(isUnSimp&&!StringUtils.isNumber(alexAndradeBookingBean.getPhoneNumber())){
            InvalidFieldBean invalidFieldBean = new InvalidFieldBean();
            invalidFieldBean.setField("phoneNumber");
            invalidFieldBean.setMessage("The telephone number is invalid.");
            invalidFieldBean.setError_id(alexAndradeBookingBean._wpcf7_unit_tag+"-ve-phoneNumber");
            list.add(invalidFieldBean);
            isCheck=false;
        }
        if(isUnSimp&&StringUtils.isEmpty(alexAndradeBookingBean.getStreetAddress())){
            InvalidFieldBean invalidFieldBean = new InvalidFieldBean();
            invalidFieldBean.setField("streetAddress");
            invalidFieldBean.setMessage("The field is required.");
            invalidFieldBean.setError_id(alexAndradeBookingBean._wpcf7_unit_tag+"-ve-streetAddress");
            list.add(invalidFieldBean);
            isCheck=false;
        }
        if(isUnSimp&&StringUtils.isEmpty(alexAndradeBookingBean.getCity())){
            InvalidFieldBean invalidFieldBean = new InvalidFieldBean();
            invalidFieldBean.setField("city");
            invalidFieldBean.setMessage("The field is required.");
            invalidFieldBean.setError_id(alexAndradeBookingBean._wpcf7_unit_tag+"-ve-city");
            list.add(invalidFieldBean);
            isCheck=false;
        }
        if(!isUnSimp&&StringUtils.isEmpty(alexAndradeBookingBean.getName())){
            InvalidFieldBean invalidFieldBean = new InvalidFieldBean();
            invalidFieldBean.setField("Name");
            invalidFieldBean.setMessage("The field is required.");
            invalidFieldBean.setError_id(alexAndradeBookingBean._wpcf7_unit_tag+"-ve-Name");
            list.add(invalidFieldBean);
            isCheck=false;
        }
        if(!isUnSimp&&StringUtils.isEmpty(alexAndradeBookingBean.getEmail())){
            InvalidFieldBean invalidFieldBean = new InvalidFieldBean();
            invalidFieldBean.setField("Email");
            invalidFieldBean.setMessage("The field is required.");
            invalidFieldBean.setError_id(alexAndradeBookingBean._wpcf7_unit_tag+"-ve-Email");
            list.add(invalidFieldBean);
            isCheck=false;
        }else if(!isUnSimp&&!StringUtils.isEmail(alexAndradeBookingBean.getEmail())){
            InvalidFieldBean invalidFieldBean = new InvalidFieldBean();
            invalidFieldBean.setField("Email");
            invalidFieldBean.setMessage("The e-mail address entered is invalid.");
            invalidFieldBean.setError_id(alexAndradeBookingBean._wpcf7_unit_tag+"-ve-Email");
            list.add(invalidFieldBean);
            isCheck=false;
        }
        if(!isUnSimp&&StringUtils.isEmpty(alexAndradeBookingBean.getPhone())){
            InvalidFieldBean invalidFieldBean = new InvalidFieldBean();
            invalidFieldBean.setField("Phone");
            invalidFieldBean.setMessage("The field is required.");
            invalidFieldBean.setError_id(alexAndradeBookingBean._wpcf7_unit_tag+"-ve-Phone");
            list.add(invalidFieldBean);
            isCheck=false;
        }else if(!isUnSimp&&!StringUtils.isNumber(alexAndradeBookingBean.getPhone())){
            InvalidFieldBean invalidFieldBean = new InvalidFieldBean();
            invalidFieldBean.setField("Phone");
            invalidFieldBean.setMessage("The telephone number is invalid.");
            invalidFieldBean.setError_id(alexAndradeBookingBean._wpcf7_unit_tag+"-ve-Phone");
            list.add(invalidFieldBean);
            isCheck=false;
        }
        if(!isCheck){
            obj.put("status","validation_failed");
            obj.put("message","One or more fields have an error. Please check and try again.");
        }else {
            obj.put("status","mail_sent");
            obj.put("message","Thank you for your message. It has been sent.");
        }
        obj.put("invalid_fields",list);

        return isCheck;
    }

}

package com.doudou.onlinebook.common.util;

import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {


    /**
     * ʱ���ʽ��
     * @param date
     * @param pattern
     * @return
     */
    public static String dateToStr(Date date,String pattern){
        try{
            if(StringUtils.hasText(pattern)){
                SimpleDateFormat sdf = new SimpleDateFormat(pattern);
                return sdf.format(date);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Date strToDate(String dateStr,String pattern){
        try{
            if(StringUtils.hasText(pattern)){
                SimpleDateFormat sdf = new SimpleDateFormat(pattern);
                return sdf.parse(dateStr);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //ָ��ʱ��ͽ������ʱ��
    public static Long DifferenceInDays(String a) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");// �Զ���ʱ���ʽ

        Calendar calendar_a = Calendar.getInstance();// ��ȡ��������
        Calendar calendar_b = Calendar.getInstance();

        Date date_a = null;
        Date date_b = new Date();

        try {
            date_a = simpleDateFormat.parse(a);//�ַ���תDate
//            date_b = simpleDateFormat.parse(b);
            calendar_a.setTime(date_a);// ��������
            calendar_b.setTime(date_b);
        } catch (ParseException e) {
            e.printStackTrace();//��ʽ���쳣
            return -1L;
        }

        long time_a = calendar_a.getTimeInMillis();
        long time_b = calendar_b.getTimeInMillis();

        long between_days = (time_b - time_a) / (1000 * 3600 * 24);//�����������

        return Math.abs(between_days);
    }

    //����ʱ������
    public static Long TwoDaysDifference(String a, String b) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");// �Զ���ʱ���ʽ

        Calendar calendar_a = Calendar.getInstance();// ��ȡ��������
        Calendar calendar_b = Calendar.getInstance();

        Date date_a = null;
        Date date_b = null;

        try {
            date_a = simpleDateFormat.parse(a);//�ַ���תDate
            date_b = simpleDateFormat.parse(b);
            calendar_a.setTime(date_a);// ��������
            calendar_b.setTime(date_b);
        } catch (ParseException e) {
            e.printStackTrace();//��ʽ���쳣
            return -1L;
        }

        long time_a = calendar_a.getTimeInMillis();
        long time_b = calendar_b.getTimeInMillis();

        long between_days = (time_b - time_a) / (1000 * 3600 * 24);//�����������

        return Math.abs(between_days);
    }

}

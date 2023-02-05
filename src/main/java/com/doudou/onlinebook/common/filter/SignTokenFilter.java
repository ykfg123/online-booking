package com.doudou.onlinebook.common.filter;


import com.doudou.onlinebook.common.util.StringUtils;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
/**
 * @author ：zhuyk
 * @date ：Created in 2019/8/27 10:39
 * @modified 安全认证 过滤器
 * @version: 1.0.0$
 */
@WebFilter(filterName = "signFilter",urlPatterns = {"/user/*"})
@Log4j2
public class SignTokenFilter implements Filter {


    private String appSecret = null;
    @Autowired
    private static Map<String,String> APP_SECRET_MAP=new HashMap<>();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request= (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String timestamp = request.getHeader("timestamp");
        String sign = request.getHeader("sign");
        String appKey = request.getHeader("app_key");
        //String format = servletRequest.getParameter("format");
        String data = servletRequest.getParameter("data");
        if(isCheckEmpty(timestamp,sign,appKey)){
            servletRequest.getRequestDispatcher("/error/parametererror").forward(servletRequest, servletResponse);
        }else {
            Map<String,String> map = new  HashMap<String,String>();
            map.put("app_key",appKey);
            map.put("data",data);
            map.put("timestamp",timestamp);
            //map.put("format",format);
            try {
                if(StringUtils.isEmpty(appKey)){
                    log.info("安全认证参数为: " + "timestamp " + timestamp + " sign " + sign + " app_key " + appKey + " data " + data);
                    servletRequest.getRequestDispatcher("/error/appkeyerror").forward(servletRequest, servletResponse);
                }else if(isCheckTimeOut(timestamp)){
                    log.info("安全认证参数为: " + "timestamp " + timestamp + " sign " + sign + " app_key " + appKey + " data " + data);
                    servletRequest.getRequestDispatcher("/error/timeout").forward(servletRequest, servletResponse);
                }else if(!sign.equals(signTopRequest(map,appSecret))){
                    log.info("安全认证参数为: " + "timestamp " + timestamp + " sign " + sign + " app_key " + appKey + " data " + data);
                    servletRequest.getRequestDispatcher("/error/signerror").forward(servletRequest, servletResponse);
                }else{
                    filterChain.doFilter(request,response);
                }
            } catch (Exception e) {
                log.info("认证报错",e);
                log.info("安全认证参数为: " + "timestamp " + timestamp + " sign " + sign + " app_key " + appKey + " data " + data);
            }
        }
    }
    @Override
    public void destroy() {

    }
    private boolean isCheckTimeOut(String timeString){
        Long timestamp = Long.valueOf(timeString);
        long time = new Date().getTime();
        return time-timestamp>1200000;
    }
    private boolean isCheckEmpty(String... parameter){
        for (String s:parameter) {
            if(StringUtils.isEmpty(s)) return true;
        }
        return false;
    }
    private boolean isCheckAppKey(String appKey){
        if(StringUtils.isEmpty(appKey)){ return true;}
        return false;
    }
    private  String signTopRequest(Map<String, String> params, String secret) throws Exception{

        Map<String, String> sortMapByKey = sortMapByKey(params,true);
        String query = secret;

        for (String key : sortMapByKey.keySet()) {
            String value = params.get(key);
            if (!isAllEmpty(key, value)) {
                query += key + value;
            }
        }
        query += secret;
        //log.info("query:{}",query);
        String md5Encode = DigestUtils.md5DigestAsHex(query.getBytes("UTF8"));
        //log.info("md5Encode:{}",md5Encode);
        return md5Encode.toUpperCase(Locale.ENGLISH);
    }

    private  Map<String, String> sortMapByKey(Map<String, String> oriMap, final boolean isRise) {
        if (oriMap == null || oriMap.isEmpty()) {
            return null;
        }

        Map<String, String> sortMap = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (isRise) {
                    // 升序排序
                    return o1.compareTo(o2);
                } else {
                    // 降序排序
                    return o2.compareTo(o1);
                }
            }
        });
        sortMap.putAll(oriMap);
        return sortMap;
    }
    private  boolean isAllEmpty(String... strings) {
        String[] arr$ = strings;
        int len$ = strings.length;

        for(int i$ = 0; i$ < len$; ++i$) {
            String string = arr$[i$];
            if (!isEmpty(string)) {
                return false;
            }
        }

        return true;
    }
    private  boolean isEmpty(String string) {
        return string == null || string.length() == 0;
    }

}

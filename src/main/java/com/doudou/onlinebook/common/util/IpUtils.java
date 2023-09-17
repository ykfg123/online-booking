package com.doudou.onlinebook.common.util;

import lombok.extern.log4j.Log4j2;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.regex.Pattern;

@Log4j2
public class IpUtils {
    public static String getIpAddr(HttpServletRequest request) {
        String ipAddress = "127.0.0.1";
        try {
            ipAddress = request.getHeader("x-forwarded-for");
            if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getHeader("Proxy-Client-IP");
            }
            if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getHeader("WL-Proxy-Client-IP");
            }
            if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getRemoteAddr();
                if (ipAddress.equals("127.0.0.1")) {
                    // 根据网卡取本机配置的IP
                    InetAddress inet = null;
                    try {
                        inet = InetAddress.getLocalHost();
                    } catch (UnknownHostException e) {
                        e.printStackTrace();
                    }
                    ipAddress = inet.getHostAddress();
                }
            }
            // 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
            if (ipAddress != null && ipAddress.length() > 15) {
                if (ipAddress.indexOf(",") > 0) {
                    ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
                }
            }
        } catch (Exception e) {
            ipAddress="";
            log.error("IP获取异常",e);
        }

        return ipAddress;
    }

    public static boolean  validIPAddress(String IP) {
        log.info("IP地址IP{}"+IP);
        String pattern_IPv4 = "([1-9]?\\d|1\\d\\d|2[0-4]\\d|25[0-5])(\\.([1-9]?\\d|1\\d\\d|2[0-4]\\d|25[0-5])){3}$";
        String pattern_IPv6 = "([\\dA-Fa-f]{1,4}\\:){7}[\\dA-Fa-f]{1,4}$";
        if(StringUtils.isNotEmpty(IP)){
            return Pattern.matches(pattern_IPv4,IP)||Pattern.matches(pattern_IPv6,IP);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("validIPAddress(\"172.16.254.1\") = " + validIPAddress("172.16.254.1"));
        System.out.println("validIPAddress(\"110.86.209.110\") = " + validIPAddress("110.86.209.110"));
        System.out.println("validIPAddress(\"172.16.254.1\") = " + validIPAddress("1.1.1.01"));
        System.out.println("validIPAddress(\"172.16.254.1\") = " + validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334"));
        System.out.println("validIPAddress(\"172.16.254.1\") = " + validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:73340"));
        System.out.println("validIPAddress(\"172.16.254.1\") = " + validIPAddress("2001:0db8::0:0:8A2E:0370:7334"));
    }
}

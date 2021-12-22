package com.doudou.onlinebook.common.util;

import java.util.regex.Pattern;

/**
 * @author Administrator
 * @create 2021-06-22-17:32
 */

public class FileNameFilter {

    //private static Pattern FilePattern = Pattern.compile("[\\\\/:*?\"<>|]");

    private static Pattern FilePattern = Pattern.compile("[\\s\\.:?<>|]"); //过滤规则

    public static String filenameFilter(String str) {
        return str==null?null:FilePattern.matcher(str).replaceAll("");
    }


   /* private static Pattern FilePattern1 = Pattern.compile("[\\\\/:*?\"<>|]");

    *//**
     * 路径遍历 漏洞修复
     * @param
     * @return
     *//*
    public static String filenameFilter1(String str) {
        return str == null ? null : FilePattern1.matcher(str).replaceAll("");

    }*/

    public static void main(String[] args) {
        String str="home/..  <>|logs/../:edata?";
        str="/home/nccapp/tomcat/server5/fs/../rec1/sealInfo96110/20210622173901123.mp3";
        /*String filenameFilter1 = filenameFilter1(str);
        System.out.println(filenameFilter1);*/
        String filenameFilter = fileNameValidate(str);
        System.out.println(str);
        System.out.println(filenameFilter);
    }



    public static String fileNameValidate(String str) {
        String strInjectListStr ="../|./|/..| |<|>|?";
        if(null!=strInjectListStr && !"".equals(strInjectListStr))
        {
            //str = str.toLowerCase();
            String[] badStrs = strInjectListStr.split("\\|");
            for (int i = 0; i < badStrs.length; i++) {
                if (str.indexOf(badStrs[i]) >= 0) {
                    str= str.replace(badStrs[i], "");
                }
            }
        }
        return str;
    }
}


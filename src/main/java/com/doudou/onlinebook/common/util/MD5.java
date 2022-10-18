package com.doudou.onlinebook.common.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

/**
 * Created by cjd on 2017/12/8.
 */
public class MD5 {



    /**
     * MD5 32加密（大写）
     * @param readyEncryptStr ready encrypt string
     * @return String encrypt result string
     * @throws NoSuchAlgorithmException
     * */
    public static String MD5_32Upper(String readyEncryptStr){
        if(readyEncryptStr != null){
            //Get MD5 digest algorithm's MessageDigest's instance.
            MessageDigest md = null;
            try{
                md = MessageDigest.getInstance("MD5");
            }catch(Exception e){
                return null;
            }
            //Use specified byte update digest.
            md.update(readyEncryptStr.getBytes());
            //Get cipher text
            byte [] b = md.digest();
            //The cipher text converted to hexadecimal string
            StringBuilder su = new StringBuilder();
            //byte array switch hexadecimal number.
            for(int offset = 0,bLen = b.length; offset < bLen; offset++){
                String haxHex = Integer.toHexString(b[offset] & 0xFF);
                if(haxHex.length() < 2){
                    su.append("0");
                }
                su.append(haxHex);
            }
            return su.toString().toUpperCase(Locale.ENGLISH);
        }else{
            return null;
        }
    }


    public static String bytesToHexString(byte[] src) {
        StringBuilder stringBuilder = new StringBuilder("");
        if (src == null || src.length <= 0) {
            return null;
        }
        for (int i = 0; i < src.length; i++) {
            int v = src[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }

    /**
     * 解析
     * @param hexString
     * @return
     */
    public static byte[] hexStringToBytes(String hexString) {
        if (hexString == null || hexString.equals("")) {
            return null;
        }
        hexString = hexString.toUpperCase(Locale.ENGLISH);
        int length = hexString.length() / 2;
        char[] hexChars = hexString.toCharArray();
        byte[] d = new byte[length];
        for (int i = 0; i < length; i++) {
            int pos = i * 2;
            d[i] = (byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));
        }
        return d;
    }

    /**
     * 将指定byte数组以16进制的形式打印到控制台
     * @param b
     */
    public static void printHexString(byte[] b) {
        for (int i = 0; i < b.length; i++) {
            String hex = Integer.toHexString(b[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            System.out.print(hex.toUpperCase(Locale.ENGLISH));
        }

    }

    /**
     * Convert char to byte
     * @param c char
     * @return byte
     */
    private static byte charToByte(char c) {
        return (byte) "0123456789abcdef".indexOf(c);
    }

    /**
     * 加密
     * @param str
     * @return
     */
    public static String encode(String str) {
        String strDigest = "";
        try {
            // 此 MessageDigest 类为应用程序提供信息摘要算法的功能，必须用try,catch捕获
            MessageDigest md5 = MessageDigest.getInstance("MD5");

            byte[] data;
            data = md5.digest(str.getBytes("utf-8"));// 转换为MD5码
            strDigest = bytesToHexString(data);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        return strDigest;
    }

    /**
     * MD5 32加密（小写）
     * @param readyEncryptStr ready encrypt string
     * @return String encrypt result string
     * @throws NoSuchAlgorithmException
     * */
    public static String encrypt32(String readyEncryptStr) {
        MessageDigest md5;
        try {
            md5 = MessageDigest.getInstance("MD5");
            byte[] md5Bytes = md5.digest(readyEncryptStr.getBytes());
            StringBuffer hexValue = new StringBuffer();
            for (int i = 0; i < md5Bytes.length; i++) {
                int val = ((int) md5Bytes[i]) & 0xff;
                if (val < 16)
                    hexValue.append("0");
                hexValue.append(Integer.toHexString(val));
            }
            readyEncryptStr = hexValue.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return readyEncryptStr;
    }


}

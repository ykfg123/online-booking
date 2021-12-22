package com.doudou.onlinebook.common.util;


import lombok.extern.log4j.Log4j2;

@Log4j2
public class FormatUtils {




    /**
     * 16进制字符串转为字符数组
     * @param hexStr
     * @return
     */
    public static byte[] hexStr2ByteArr(String hexStr) {
        byte[] resultArr = new byte[hexStr.length() / 2];
        try {
            char[] originCharArr = hexStr.toCharArray();
            String swap = null;
            for (int i = 0; i < hexStr.length(); i += 2) {
                swap = new String(originCharArr, i, 2);
                resultArr[i/2] = (byte)Integer.parseInt(swap, 16);
            }
        } catch (NumberFormatException e) {
            log.error("16进制字符串转为字符数组异常，参数：hexStr="+hexStr,e);
        }
        return resultArr;
    }


    /**
     * 字符数组转为16进制字符串
     * @param originByteArr
     * @return
     */

    public static String byteArr2HexStr(byte[] originByteArr) {
        String tmpStr = null;
        StringBuffer retVal = new StringBuffer();

        try {
            for(int n = 0; n < originByteArr.length; n++){
                tmpStr = Integer.toHexString(originByteArr[n] & 0xFF);
                if(tmpStr.length() == 1) {
                    retVal.append("0" + tmpStr);
                }
                else {
                    retVal.append(tmpStr);
                }
            }
        } catch (Exception e) {
            log.error("字符数组转为16进制字符串异常，参数：originByteArr="+originByteArr.toString(),e);
        }
        return retVal.toString();
    }

}

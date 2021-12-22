package com.doudou.onlinebook.common.util;



import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class PhoneUtils {
    //用于匹配手机号码
    private final static String REGEX_MOBILEPHONE = "^0?1[3458]\\d{9}$";

    //用于匹配固定电话号码
    private final static String REGEX_FIXEDPHONE = "^(010|02\\d|0[3-9]\\d{2})?\\d{6,8}$";

    private static Pattern PATTERN_MOBILEPHONE;
    private static Pattern PATTERN_FIXEDPHONE;


    static {
        PATTERN_FIXEDPHONE = Pattern.compile(REGEX_FIXEDPHONE);
        PATTERN_MOBILEPHONE = Pattern.compile(REGEX_MOBILEPHONE);
    }

    /**
     * 判断是否为手机号码
     *
     * @param number
     *            手机号码
     * @return
     */
    public static boolean isCellPhone(String number) {
        Matcher match = PATTERN_MOBILEPHONE.matcher(number);
        return match.matches();
    }

    /**
     * 判断是否为固定电话号码
     *
     * @param number
     *            固定电话号码
     * @return
     */
    public static boolean isFixedPhone(String number) {
        Matcher match = PATTERN_FIXEDPHONE.matcher(number);
        return match.matches();
    }

    /** //电信号段133、149、153、173、177、180、181、189、199  新增 191、162、193
     * 中国电信号码格式验证 手机段： 133,153,180,181,189,177,1700
     * **/
    private static final String CHINA_TELECOM_PATTERN = "(^1(33|49|53|73|77|99|91|93|62|8[019])\\d{8}$)|(^1700\\d{7}$)";



    private static final String CHINA_MOBILE_PATTERN = "(^1(3[4-9]|4[7]|5[0-27-9]|7[8]|8[2-478]|98|95)\\d{8}$)|(^1705\\d{7}$)|(^1703\\d{7}$)|(^1706\\d{7}$)";



    private static final String CHINA_UNICOM_PATTERN = "(^1(3[0-2]|4[5]|5[56]|7[156]|8[56]|66)\\d{8}$)|(^1709\\d{7}$)|(^1704\\d{7}$)|(^1707\\d{7}$)|(^1708\\d{7}$)";

    /**
     * 执行正则表达式
     *
     * @param pat
     *            表达式
     * @param str
     *            待验证字符串
     * @return 返回true,否则为false
     */
    private static boolean match(String pat, String str) {
        Pattern pattern = Pattern.compile(pat);
        Matcher match = pattern.matcher(str);
        return match.find();
    }

    /**
     * 验证【电信】手机号码的格式
     *
     * @author LinBilin
     * @param str
     *            校验手机字符串
     * @return 返回true,否则为false
     */
    public static boolean isChinaTelecomPhoneNum(String str) {

        return str == null || str.trim().equals("") ? false : match(
                CHINA_TELECOM_PATTERN, str);
    }

    /**
     * 检查号码类型，并获取号码前缀，手机获取前7位，固话获取区号
     * @param _number
     * @return
     */
    public static String checkNumber(String _number){
        String number = _number;
        Number rtNum = null;
        String result = null;
        //判断是否为固话
        if(isFixedPhone(number)){
            result = "FIXEDPHONE";
        }else{
            //判断是否为电信号码
            result = isChinaTelecomPhoneNum(number)?"ChinaTelecomPhone":"OtherPhone";
        }
        return result;
    }


    /**
     * 验证【移动】手机号码的格式
     *
     * @author LinBilin
     * @param str
     *            校验手机字符串
     * @return 返回true,否则为false
     */
    public static boolean isChinaMobilePhoneNum(String str) {
        return str == null || str.trim().equals("") ? false : match(
                CHINA_MOBILE_PATTERN, str);
    }

    /**
     * 验证【联通】手机号码的格式
     *
     * @author LinBilin
     * @param str
     *            校验手机字符串
     * @return 返回true,否则为false
     */
    public static boolean isChinaUnicomPhoneNum(String str) {
        return str == null || str.trim().equals("") ? false : match(
                CHINA_UNICOM_PATTERN, str);
    }


    /**
     * 检查号码运营商，并获取号码前缀，手机获取前7位，固话获取区号
     * @param _number
     * @return
     */
    public static String checkNumberNet(String _number){
        String number = _number;
        Number rtNum = null;
        String result = null;
        //判断是否为固话
        if(isFixedPhone(number)){
            result = "FIXEDPHONE";
        }else if(isChinaTelecomPhoneNum(number)){
            //判断是否为电信号码
            result = "ChinaTelecomPhone";
        }else if(isChinaUnicomPhoneNum(number)){
            //判断是否为电信号码
            result = "ChinaUnicomPhone";
        }else if(isChinaMobilePhoneNum(number)){
            //判断是否为电信号码
            result = "ChinaMobilePhone";
        }else{
            result = "OtherPhone";
        }
        return result;
    }


    /* public static void main(String[] args){
    	 String num = "13359432018";
    	 String callerAresult = checkNumber(num);
    	 System.out.println(checkNumber(num));

    	 if(!"FIXEDPHONE".equals(callerAresult)){
    		 if(!"95".equals(num.substring(0,2))){
 				System.out.println("no way");
 			}
		}


     }*/
//

}


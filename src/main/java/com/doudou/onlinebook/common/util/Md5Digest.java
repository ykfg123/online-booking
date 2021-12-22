package com.doudou.onlinebook.common.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class Md5Digest {
    @SuppressWarnings("unused")
    private Log log = LogFactory.getLog(Md5Digest.class);

    private MessageDigest messageDigest = null;//

    public Md5Digest() {
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        }
        catch(NoSuchAlgorithmException ex) {
            log.error("Md5Digest instance error!", ex);
        }
    }

    private static Md5Digest instance = new Md5Digest();

    public static Md5Digest getInstance() {
        return instance;
    }
    //
    public Md5Digest(String args) {
        this();
        this.update(args);
    }

    public Md5Digest(String args[]) {
        this();
        this.update(args);
    }
    //
    private void update(String updateStr) {
        messageDigest.update(updateStr.getBytes());
    }

    private void update(String[] updateStrArr) {
        if(updateStrArr != null) {
            for (int i = 0; i < updateStrArr.length; i++) {
                update(updateStrArr[i]);
            }
        }
    }

    private String getHexStr() {
        byte[] digestByteArr = messageDigest.digest();
        return FormatUtils.byteArr2HexStr(digestByteArr);
    }


    public String getEncryptedPwd(String arg) {
        return getEncryptedPwd(new String[]{arg});
    }

    public String getEncryptedPwd(String args[]) {
        update(args);
        return getHexStr();
    }


}

package com.mkmk.student.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 采用网上的一些方法将字符串用MD5加密
 * 用于简单的加密效果
 */
public class getMD5 {

    public static String getMD5Str(String str){

        byte [] bytes =null;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            bytes = messageDigest.digest(str.getBytes("UTF-8"));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return bytesTo16BString(bytes);
    }

    private static String bytesTo16BString(byte[] bytes) {
        StringBuffer res = new StringBuffer();
        int num = 0;
        for(int i=0;i<bytes.length;i++) {
            num = bytes[i]>0?bytes[i]:255+bytes[i];
            String hex = Integer.toHexString(num);
            res.append(hex.length()<2?0+hex:hex);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String no = "1";
        int a=Integer.parseInt(no);
        System.out.println(a);
    }
}

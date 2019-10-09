package com.demo.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Utils {
    private final static String[] hexDigits = {"0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

    public static String byteArrayToHexString(byte[] b) {
        StringBuffer resultSb = new StringBuffer();
        for (int i = 0; i < b.length; i++) {
            resultSb.append(byteToHexString(b[i]));
        }
        return resultSb.toString();
    }

    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0) {
            n = 256 + n;
        }
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }

    public static String encrypt(String strSrc) throws Exception {
        if (null == strSrc || strSrc.length() == 0) {
            return "";
        }
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        return byteArrayToHexString(md5.digest(strSrc.getBytes()));
    }

    public static String encryptWithSalt(String strSrc, String salt)
            throws Exception {
        if (null == strSrc || strSrc.length() == 0) {
            return "";
        }
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        return byteArrayToHexString(md5.digest((salt + strSrc).getBytes()));
    }

    /**
     * 32位MD5加密的大写字符串
     *
     * @param s
     * @return
     */
    public static String encryptWithCapital(String s) {
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'A', 'B', 'C', 'D', 'E', 'F'};

        byte[] btInput = s.getBytes();
        // 获得MD5摘要算法的 MessageDigest 对象
        MessageDigest mdInst = null;
        try {
            mdInst = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
        // 使用指定的字节更新摘要
        mdInst.update(btInput);
        // 获得密文
        byte[] md = mdInst.digest();
        // 把密文转换成十六进制的字符串形式
        int j = md.length;
        char str[] = new char[j * 2];
        int k = 0;
        for (int i = 0; i < j; i++) {
            byte byte0 = md[i];
            str[k++] = hexDigits[byte0 >>> 4 & 0xf];
            str[k++] = hexDigits[byte0 & 0xf];
        }
        return new String(str);

    }

    public static void main(String[] args) {
        try {
            System.out.println(MD5Utils.encryptWithCapital("aaa"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

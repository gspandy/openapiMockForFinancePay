/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * zhouxi@yiji.com 2015-03-11 19:34 创建
 *
 */
package com.yiji.openapimock.utils;

import com.yjf.common.lang.exception.Exceptions;
import com.yjf.common.lang.security.DigestUtil;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author aleishus@yiji.com
 */
public class SignUtil {

    private static final String MD5 = "MD5";
    private static final String Sha1 = "Sha1Hex";
    private static final String Sha256 = "Sha256Hex";
    private static final String HmacSHA1 = "HmacSha1Hex";


    public static String digest(Map<String, Object> dataMap, String signType, String key, String encoding) {


        if(signType.equals(MD5)){
            return DigestUtils.md5Hex(makeStr(dataMap)+key) ;
        }
        if(signType.equals(Sha1)){
            return DigestUtils.sha1Hex(makeStr(dataMap) + key) ;
        }
        if(signType.equals(Sha256)){
            return DigestUtils.sha256Hex(makeStr(dataMap) + key) ;
        }
        if(signType.equals(HmacSHA1)){
            return hmacSha1Hex(makeStr(dataMap),encoding,key);
        }
        /*throw new IllegalArgumentException(signType + " 不支持的signType");*/
        //如果都不匹配使用MD5
        return DigestUtils.md5Hex(makeStr(dataMap)+key) ;
    }


    public static byte[] hmacSha1(byte[] input, byte[] key) {
        try {
            SecretKey secretKey = new SecretKeySpec(key, "HmacSha1");
            Mac mac = Mac.getInstance(secretKey.getAlgorithm());
            mac.init(secretKey);
            return mac.doFinal(input);
        } catch (GeneralSecurityException e) {
            throw Exceptions.newRuntimeExceptionWithoutStackTrace(e);
        }
    }


    public static String hmacSha1Hex(String input, String encode, String key) {
        byte[] inputBytes = null;
        byte[] keyBytes = null;
        try {
            inputBytes = input.getBytes(encode);
            keyBytes = key.getBytes(encode);
        } catch (Exception e) {
            throw Exceptions.newRuntimeExceptionWithoutStackTrace(e);
        }
        return new String(Hex.encodeHex(hmacSha1(inputBytes, keyBytes))) ;
    }

    public static <T> String makeStr(Map<String, T> dataMap){
        TreeMap<String, T> treeMap = new TreeMap<String, T>(dataMap);
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, T> entry : treeMap.entrySet()) {
            if (entry.getValue() == null) {
                throw new IllegalArgumentException(entry.getKey() + " 待签名值不能为空");
            }
            if (entry.getKey().equals("sign")) {
                continue;
            }
            sb.append(entry.getKey()).append("=").append(entry.getValue().toString()).append("&");
        }
        sb.deleteCharAt(sb.length() - 1);
        return  sb.toString() ;
    }

    public static void main(String... args){
        Map<String ,Object> data = new HashMap<>() ;
        data.put("213","erwe");
        data.put("werw","erq");
        data.put("we",4);
        data.put("ewqrqe",1);
        System.out.println(SignUtil.digest(data, "MD5", "hello", "utf-8")) ;
        System.out.println(DigestUtil.digest(data, "hello",
                DigestUtil.DigestALGEnum.getByName("MD5"), "utf-8"));
    }
}
/*
 * www.yiji.com Inc.
 * Copyright (c) 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * husheng@yiji.com 2016-05-02 07:43 创建
 *
 */
package com.yiji.openapimock.utils;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import com.yjf.common.net.HttpUtil;
import com.yjf.common.util.ToString;
import java.util.HashMap;
import java.util.Map;

/**
 * @author husheng@yiji.com
 */
public class NotifyUtils {

    private static Map<String, String> headerMap = Maps.newHashMapWithExpectedSize(1);

    static {
        headerMap.put("User-Agent", "www.yiji.com");
    }

    private static final String mockNotifyUrl = "http://localhost:8080/mocknotify.html";

    /**
     * Mock通知工具类，用于在测试代码中主动发起调用openapi通知
     * @param gid 原始请求生成的GID
     * @param partnerId 商户ID
     * @param merchOrderNo 商户订单号
     * @param notify 通知参数，具体参数可定义子类的属性
     * @return
     */
    public static Result notify(String gid, String partnerId, String merchOrderNo, Notify notify) {
        try {
            Map<String, String> dataMap = new HashMap();
            dataMap.put("partnerId", partnerId);
            dataMap.put("merchOrderNo", merchOrderNo);
            dataMap.put("gid", gid);
            dataMap.put("data", JSON.toJSONString(notify));
            HttpUtil.HttpResult result = HttpUtil.getInstance().post(mockNotifyUrl, dataMap, headerMap, "utf-8");
            String msg = result.getBody();
            return JSON.parseObject(msg, Result.class);
        } catch (Exception e) {
            Result result = new Result();
            result.setSuccess(false);
            result.setDescription(e.getMessage());
            return result;
        }
    }

    public static class Result {
        private String code;
        private String description;
        private String resultCode;
        private String resultMessage;
        private String status;
        private boolean success;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getResultCode() {
            return resultCode;
        }

        public void setResultCode(String resultCode) {
            this.resultCode = resultCode;
        }

        public String getResultMessage() {
            return resultMessage;
        }

        public void setResultMessage(String resultMessage) {
            this.resultMessage = resultMessage;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public boolean isSuccess() {
            return success;
        }

        public void setSuccess(boolean success) {
            this.success = success;
        }

        @Override
        public String toString() {
            return ToString.toString(this);
        }
    }

    public static class Notify {

    }

    public static void main(String[] args) {
        String gid = "003y0000020000000001605010928390000";
        String partnerId = "20160304020000708949";
        String merchOrderNo = "1111111111111111";
        Result result = NotifyUtils.notify(gid, partnerId, merchOrderNo, new TestNotify());
        System.out.println("result = " + result);
    }

    private static class TestNotify extends Notify {
        private String test = "this is test result.";

        public String getTest() {
            return test;
        }

        public void setTest(String test) {
            this.test = test;
        }
    }
}

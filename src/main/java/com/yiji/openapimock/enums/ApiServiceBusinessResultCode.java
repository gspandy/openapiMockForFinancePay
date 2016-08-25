/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */
package com.yiji.openapimock.enums;

import com.yiji.openapi.arch.exception.ResultCode;

/**
 * openApi 业务错误码定义
 * 
 * 可直接传入ApiServcieException
 * @author zhangpu
 * @date 2014年8月5日
 */
public enum ApiServiceBusinessResultCode implements ResultCode {
	
	DEMO_BUSINESS_CODE("DEMO_BUSINESS_CODE", "测试用CODE"),
	
	EXECUTE_FAIL("EXECUTE_FAIL", "执行失败"),
	
	//短信验证码&手机绑定
	SMS_SUFFIX_CONFIG_NOT_FOUND("SMS_POSTFIX_CONFIG_NOT_FOUND", "短信后缀配置未找到"),
	
	SEND_SMS_CAPTCHA_FAIL("SEND_SMS_CAPTCHA_FAIL", "发送手机验证码失败"),
	
	SEND_SMS_FAIL("SEND_SMS_FAIL", "发送短信失败"),
	
	BIND_MOBILE_NOT_FOUND("BIND_MOBILE_NOT_FOUND", "该用户没有绑定手机信息"),
	
	SMS_CAPTCHA_VERIFY_EXECUTE_FAIL("SMS_CAPTCHA_VERIFY_EXECUTE_FAIL", "校验执行失败"),
	
	SMS_CAPTCHA_NOT_MATCH("SMS_CAPTCHA_NOT_MATCH", "验证码不匹配"),
	
	OLD_MOBILE_CAPTCHA_NOT_MATCH("OLD_MOBILE_CAPTCHA_NOT_MATCH", "旧手机验证码不匹配"),
	
	//银行卡
	BIND_BANK_CARD_NOT_FOUND("BIND_BANK_CARD_NOT_FOUND", ""),
	
	//通用担保交易
	TRADE_CREATE_FAIL("TRADE_CREATE_FAIL", "交易创建失败"),
	
	DATA_NOT_FOUND("DATA_NOT_FOUND", "数据查询失败"),
	
	//移动支付返回码
	MPAY_SUCCESS("SUCCESS", "执行成功"),
	
	USER_EXISTS("USER_EXISTS", "用户已存在"),
	
	INSTALLMENT_NO_DATA("INSTALLMENT_NO_DATA", "未查询到任何签约收款信息！"),
	INSTALLMENT_QUERY_DATA_ERROR("INSTALLMENT_QUERY_DATA_ERROR", "查询签约收款信息异常！"),
	INSTALLMENT_NO_ORDER_INFO("INSTALLMENT_NO_ORDER_INFO", "未查询到任何签约订单信息！"),
	INSTALLMENT_QUERY_ORDER_INFO_ERROR("INSTALLMENT_QUERY_ORDER_INFO_ERROR", "查询签约订单信息异常！"),
	INSTALLMENT_ERROR("INSTALLMENT_ERROR", "签约收款失败");
	
	private String resultCode;
	private String resultMessage;
	
	/**
	 * @param resultCode
	 * @param resultMessage
	 */
	private ApiServiceBusinessResultCode(String resultCode, String resultMessage) {
		this.resultCode = resultCode;
		this.resultMessage = resultMessage;
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
	
}

/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved.
 */

/*
 * 修订记录：
 * husheng@yiji.com 2014年8月5日 上午10:40:15创建
 */
package com.yiji.openapimock.service.bankCardBinQuery;

import org.hibernate.validator.constraints.Length;

import com.yiji.openapi.arch.meta.OpenApiField;
import com.yiji.openapi.arch.service.entity.ApiResponse;

/**
 * 
 * 
 * @author damo@yiji.com
 * 
 */
public class BankCardBINQueryResponse extends ApiResponse {
	@Length(max = 16)
	@OpenApiField(desc = "银行英文简称", constraint = "银行英文简称",demo = "ABC")
	private String bankId;
	
	@Length(max = 32)
	@OpenApiField(desc = "银行中文全称", constraint = "银行中文全称",demo = "中国农业银行")
	private String bankName;
	
	@Length(max = 32)
	@OpenApiField(desc = "银行卡产品名称", constraint = "银行卡产品名称",demo = "借记卡")
	private String bankCardName;
	
	@Length(max = 16)
	@OpenApiField(desc = "银行卡类型编码", constraint = "银行卡类型编码",demo = "DEBIT")
	private String bankCardTypeCode;
	
	@Length(max = 32)
	@OpenApiField(desc = "银行卡类型名称", constraint = "银行卡类型名称，如储蓄卡、信用卡",demo = "借记卡")
	private String bankCardTypeName;
	
	public String getBankId() {
		return this.bankId;
	}
	
	public void setBankId(String bankId) {
		this.bankId = bankId;
	}
	
	public String getBankName() {
		return this.bankName;
	}
	
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	
	public String getBankCardName() {
		return this.bankCardName;
	}
	
	public void setBankCardName(String bankCardName) {
		this.bankCardName = bankCardName;
	}
	
	public String getBankCardTypeCode() {
		return this.bankCardTypeCode;
	}
	
	public void setBankCardTypeCode(String bankCardTypeCode) {
		this.bankCardTypeCode = bankCardTypeCode;
	}
	
	public String getBankCardTypeName() {
		return this.bankCardTypeName;
	}
	
	public void setBankCardTypeName(String bankCardTypeName) {
		this.bankCardTypeName = bankCardTypeName;
	}
}

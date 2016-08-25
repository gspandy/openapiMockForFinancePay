/*
 * www.yiji.com Inc.
 * Copyright (c) 2015 All Rights Reserved.
 */

/*
 * 修订记录：
 * zhike 2015年9月8日 下午4:44:31 创建
 */
package com.yiji.openapimock.service.commonTransfersInterface;

import com.yjf.common.payengine.enums.BankCardTypeEnum;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.yiji.openapi.arch.meta.OpenApiField;

/**
 *
 *
 * @author damo@yiji.com
 *
 */

public class OpenapiTransferBankOrder {
	
	@NotBlank
	@Length(max = 20)
	@OpenApiField(desc = "银行编码",constraint = "银行简称",demo = "BKCHCNBJ")
	private String bankCode;

	@NotBlank
	@Length(max = 30)
	@OpenApiField(desc = "银行名称",constraint = "银行名称",demo = "中信银行")
	private String bankName;

	@NotBlank
	@Length(max = 30)
	@OpenApiField(desc = "银行帐号",constraint = "银行帐号",demo = "2121012800056205")
	private String bankAccountNo;

	@NotBlank
	@Length(max = 20)
	@OpenApiField(desc = "户主名称",constraint = "户主名称",demo = "小明")
	private String bankAccountName;

	@NotBlank
	@Length(max = 2)
	@OpenApiField(desc = "对公对私标志",constraint = "Y对公<br>N对私<br>NY对公对私",demo = "Y")
	private String publicTag;

	@Length(max = 16)
	@OpenApiField(desc = "省名",constraint = "省名",demo = "四川省")
	private String provName;

	@Length(max = 32)
	@OpenApiField(desc = "市名",constraint = "银行所在的市名",demo = "重庆市")
	private String cityName;

	@Length(max = 64)
	@OpenApiField(desc = "银行地址",constraint = "银行所在的具体地址",demo = "黄山大道中段5号水星B区中部")
	private String bankAddress;

	@OpenApiField(desc = "银行卡类型",demo = "DEBIT_CARD")
	private BankCardTypeEnum bankCardType = BankCardTypeEnum.DEBIT_CARD ;

	public String getBankCode() {
		return this.bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	public String getBankName() {
		return this.bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankAccountNo() {
		return this.bankAccountNo;
	}

	public void setBankAccountNo(String bankAccountNo) {
		this.bankAccountNo = bankAccountNo;
	}

	public String getBankAccountName() {
		return this.bankAccountName;
	}

	public void setBankAccountName(String bankAccountName) {
		this.bankAccountName = bankAccountName;
	}

	public String getPublicTag() {
		return this.publicTag;
	}

	public void setPublicTag(String publicTag) {
		this.publicTag = publicTag;
	}

	public String getProvName() {
		return this.provName;
	}

	public void setProvName(String provName) {
		this.provName = provName;
	}

	public String getCityName() {
		return this.cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getBankAddress() {
		return this.bankAddress;
	}

	public void setBankAddress(String bankAddress) {
		this.bankAddress = bankAddress;
	}

	public BankCardTypeEnum getBankCardType() {
		return bankCardType;
	}

	public void setBankCardType(BankCardTypeEnum bankCardType) {
		this.bankCardType = bankCardType;
	}
}

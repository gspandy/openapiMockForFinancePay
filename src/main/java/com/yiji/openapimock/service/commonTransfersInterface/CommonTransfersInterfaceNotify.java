/*
 * www.yiji.com Inc.
 * Copyright (c) 2015 All Rights Reserved.
 */

/*
 * 修订记录：
 * zhike 2015年9月8日 下午5:38:53 创建
 */
package com.yiji.openapimock.service.commonTransfersInterface;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.yiji.openapi.arch.meta.OpenApiField;
import com.yiji.openapi.arch.service.entity.ApiNotify;
import com.yjf.common.lang.util.money.Money;

/**
 *
 *
 * @author zhike@yiji.com
 *
 */

public class CommonTransfersInterfaceNotify extends ApiNotify{
	
	@NotBlank
	@Length(min = 20,max = 40)
	@OpenApiField(desc = "流水号",constraint = "汇付或转账流水号",demo = "254154515154151")
	private String bizNo;
	
	@NotBlank
	@OpenApiField(desc = "金额",constraint = "汇付或转账金额且金额大于0",demo = "66.66")
	private Money amount;
	
	@Length(max = 256)
	@OpenApiField(desc = "备注",constraint = "备注",demo = "转账成功")
	private String memo;

	public String getBizNo() {
		return this.bizNo;
	}

	public void setBizNo(String bizNo) {
		this.bizNo = bizNo;
	}

	public Money getAmount() {
		return this.amount;
	}

	public void setAmount(Money amount) {
		this.amount = amount;
	}

	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}
}

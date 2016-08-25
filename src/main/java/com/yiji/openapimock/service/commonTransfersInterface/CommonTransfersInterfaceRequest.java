/*
 * www.yiji.com Inc.
 * Copyright (c) 2015 All Rights Reserved.
 */

/*
 * 修订记录：
 * zhike 2015年9月8日 下午4:18:44 创建
 */
package com.yiji.openapimock.service.commonTransfersInterface;

import com.yiji.openapi.arch.meta.OpenApiField;
import com.yiji.openapi.arch.service.entity.ApiRequest;
import com.yjf.common.lang.util.money.Money;
import com.yjf.common.service.OrderCheckException;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 *
 *
 * @author damo@yiji.com
 *
 */

public class CommonTransfersInterfaceRequest extends ApiRequest {
	
	@NotNull(message = "金额不能为空")
	@OpenApiField(desc = "金额", constraint = "汇付或转账金额且金额大于0", demo = "66.66")
	private Money amount;
	
	@NotBlank
	@Length(max = 20)
	@OpenApiField(desc = "易极付用户ID", constraint = "易极付用户ID", demo = "2541254698412563214")
	private String userId;
	
	@Length(max = 20)
	@OpenApiField(desc = "收款人ID", constraint = "汇付或转账收款人ID", demo = "2541254698412563214")
	private String sellerUserId;
	
	@OpenApiField(desc = "延迟时间", constraint = "延迟处理时间，以小时为单位;0表示立即报送", demo = "24")
	private int delayHours;
	
	@Length(max = 256)
	@OpenApiField(desc = "备注", constraint = "备注", demo = "转账成功")
	private String memo;
	
	@OpenApiField(desc = "收款人银行信息", constraint = "收款人银行信息", demo = "")
	private OpenapiTransferBankOrder transferBankOrder;
	
	@OpenApiField(desc = "自定义收费规则", constraint = "自定义收费规则，在收费规则中配置后使用", demo = "sadas")
	private String chargeExtends;
	
	/**
	 * @throws OrderCheckException
	 * @see com.yiji.openapi.arch.service.entity.ApiRequest#check()
	 */
	@Override
	public void check() throws OrderCheckException {
		if (getTransferBankOrder() == null && sellerUserId == null) {
			throw new IllegalArgumentException("收款人ID和收款人银行信息不能同时为空！");
		}
	}
	
	public Money getAmount() {
		return this.amount;
	}
	
	public void setAmount(Money amount) {
		this.amount = amount;
	}
	
	public String getUserId() {
		return this.userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getSellerUserId() {
		return this.sellerUserId;
	}
	
	public void setSellerUserId(String sellerUserId) {
		this.sellerUserId = sellerUserId;
	}
	
	public int getDelayHours() {
		return this.delayHours;
	}
	
	public void setDelayHours(int delayHours) {
		this.delayHours = delayHours;
	}
	
	public String getMemo() {
		return this.memo;
	}
	
	public void setMemo(String memo) {
		this.memo = memo;
	}
	
	public OpenapiTransferBankOrder getTransferBankOrder() {
		return this.transferBankOrder;
	}
	
	public void setTransferBankOrder(OpenapiTransferBankOrder transferBankOrder) {
		this.transferBankOrder = transferBankOrder;
	}
	
	public String getChargeExtends() {
		return this.chargeExtends;
	}
	
	public void setChargeExtends(String chargeExtends) {
		this.chargeExtends = chargeExtends;
	}
	
}

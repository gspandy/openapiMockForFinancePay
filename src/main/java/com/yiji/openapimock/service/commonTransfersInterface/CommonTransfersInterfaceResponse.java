/*
 * www.yiji.com Inc.
 * Copyright (c) 2015 All Rights Reserved.
 */

/*
 * 修订记录：
 * zhike 2015年9月8日 下午4:19:01 创建
 */
package com.yiji.openapimock.service.commonTransfersInterface;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.esotericsoftware.kryo.NotNull;
import com.yiji.openapi.arch.meta.OpenApiField;
import com.yiji.openapi.arch.service.entity.ApiResponse;
import com.yjf.common.lang.result.Status;

/**
 *
 *
 * @author damo@yiji.com
 *
 */

public class CommonTransfersInterfaceResponse extends ApiResponse{
	
	@NotBlank
	@Length(min = 20,max = 40)
	@OpenApiField(desc = "流水号",constraint = "汇付或转账流水号",demo = "254154515154151")
	private String bizNo;
	
	@NotNull
	@OpenApiField(desc = "结果状态",constraint = "SUCCESS(成功)、FAIL(失败)、PROCESSING(处理中)",demo = "SUCCESS")
	private Status status;

	public String getBizNo() {
		return this.bizNo;
	}

	public void setBizNo(String bizNo) {
		this.bizNo = bizNo;
	}

	public Status getStatus() {
		return this.status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
}

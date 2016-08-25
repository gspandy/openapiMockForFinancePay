/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 
 * mdaheng@yiji.com 2016-04-22 17:47 创建
 *
 */
package com.yiji.openapimock.service.queryAsynVerifyCardThree;

import com.yiji.openapi.arch.meta.OpenApiField;
import com.yiji.openapi.arch.service.entity.ApiResponse;

import javax.validation.constraints.NotNull;

/**
 * @author damo
 */
public class QueryAsynVerifyCardThreeResponse extends ApiResponse {

    @NotNull
    @OpenApiField(desc = "通用签约流状态" , demo = "6151421051514" , constraint = "流水号")
    private String verifyStatus;
    
    @NotNull
    @OpenApiField(desc = "备注" , demo = "备注" , constraint = "备注号")
    private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getVerifyStatus() {
		return verifyStatus;
	}

	public void setVerifyStatus(String verifyStatus) {
		this.verifyStatus = verifyStatus;
	}

   
}

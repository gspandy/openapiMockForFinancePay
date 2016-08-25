/*
 * www.yiji.com Inc.
 * Copyright (c) 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * husheng@yiji.com 2016-04-30 16:42 创建
 *
 */
package com.yiji.openapimock.service.commonBindCard;

import com.yiji.openapi.arch.meta.OpenApiField;
import com.yiji.openapi.arch.service.entity.ApiResponse;

/**
 * @author damo@yiji.com
 */
public class CommonBindCardResponse extends ApiResponse {
	/** 协议号 */
    @OpenApiField(desc = "协议号")
	private String protocolNo ;
    /** 子协议号 */
    @OpenApiField(desc = "子协议号")
  	private String protocolChildNo ;

	public String getProtocolNo() {
		return protocolNo;
	}

	public void setProtocolNo(String protocolNo) {
		this.protocolNo = protocolNo;
	}

	public String getProtocolChildNo() {
		return protocolChildNo;
	}

	public void setProtocolChildNo(String protocolChildNo) {
		this.protocolChildNo = protocolChildNo;
	}
	
    
}

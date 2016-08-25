/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved.
 */

/*
 * 修订记录：
 * xiyang@yiji.com 2014年9月3日 下午2:13:37 创建
 */
package com.yiji.openapimock.service.bankCardElementsCheck;

import com.yiji.openapi.arch.service.entity.ApiResponse;

/**
 *
 *
 * @author xiyang
 *
 */
public class BankCardElementsCheckResponse extends ApiResponse {
	/**
     * 验卡失败时，用于存放错误码
     */
    private String code;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}

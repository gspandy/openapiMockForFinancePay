/*
 * www.yiji.com Inc.
 * Copyright (c) 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * husheng@yiji.com 2016-05-01 08:30 创建
 *
 */
package com.yjf.core.bus.result;

/**
 * @author husheng@yiji.com
 */
public class ProductCheckSingleResult {
	private boolean success;
	
	public ProductCheckSingleResult() {
	}
	
	public ProductCheckSingleResult(boolean success) {
		this.success = success;
	}
	
	public boolean isSuccess() {
		return success;
	}
	
	public void setSuccess(boolean success) {
		this.success = success;
	}
}

/*
 * www.yiji.com Inc.
 * Copyright (c) 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * husheng@yiji.com 2016-04-30 17:01 创建
 *
 */
package com.yjf.customer.service.result.merchant;

import com.yjf.customer.service.info.merchant.MerchantInfo;

/**
 * @author husheng@yiji.com
 */
public class MerchantInfoResult {
	private boolean isSuccess = true;
	private MerchantInfo merchantInfo = new MerchantInfo();

	public MerchantInfoResult(){
	}
	public MerchantInfoResult(boolean isSuccess, String securityCheckCode){
		isSuccess = true;
		merchantInfo.setSecurityCheckCode(securityCheckCode);
	}

	public boolean isSuccess() {
		return isSuccess;
	}
	
	public MerchantInfo getMerchantInfo() {
		return merchantInfo;
	}
	
}

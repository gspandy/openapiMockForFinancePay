/*
 * www.yiji.com Inc.
 * Copyright (c) 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * husheng@yiji.com 2016-04-30 17:35 创建
 *
 */
package com.yjf.customer.service.info.merchant;

/**
 * @author husheng@yiji.com
 */
public class MerchantInfo {
	private String strategyCode;
	private String securityCheckCode = "1234";

    public String getStrategyCode() {
        return strategyCode;
    }

    public void setStrategyCode(String strategyCode) {
        this.strategyCode = strategyCode;
    }

    public String getSecurityCheckCode() {
        return securityCheckCode;
    }

    public void setSecurityCheckCode(String securityCheckCode) {
        this.securityCheckCode = securityCheckCode;
    }
}

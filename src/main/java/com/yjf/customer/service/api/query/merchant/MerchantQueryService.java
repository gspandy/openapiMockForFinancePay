/*
 * www.yiji.com Inc.
 * Copyright (c) 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * husheng@yiji.com 2016-04-30 16:28 创建
 *
 */
package com.yjf.customer.service.api.query.merchant;

import com.yjf.customer.service.result.merchant.MerchantInfoResult;

/**
 * @author husheng@yiji.com
 */
public interface MerchantQueryService {
	
	MerchantInfoResult findMerchantInfoByCardNo(String partnerId);
}

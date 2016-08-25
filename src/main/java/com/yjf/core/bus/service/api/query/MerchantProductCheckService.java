/*
 * www.yiji.com Inc.
 * Copyright (c) 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * husheng@yiji.com 2016-04-30 16:29 创建
 *
 */
package com.yjf.core.bus.service.api.query;

import com.yjf.core.bus.result.ProductCheckSingleResult;
import com.yjf.core.bus.service.order.MerchantProductCheckOrder;

/**
 * @author husheng@yiji.com
 */
public interface MerchantProductCheckService {
	ProductCheckSingleResult checkProductService(MerchantProductCheckOrder order);
}

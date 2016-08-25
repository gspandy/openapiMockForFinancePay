/*
 * www.yiji.com Inc.
 * Copyright (c) 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * husheng@yiji.com 2016-05-01 08:30 创建
 *
 */
package com.yjf.core.bus.service.api.query;

import com.yjf.core.bus.result.ProductCheckSingleResult;
import com.yjf.core.bus.service.order.MerchantProductCheckOrder;

/**
 * @author husheng@yiji.com
 */
public class MerchantProductCheckServiceImpl implements MerchantProductCheckService {
    @Override
    public ProductCheckSingleResult checkProductService(MerchantProductCheckOrder order) {
        return new ProductCheckSingleResult(true);
    }
}

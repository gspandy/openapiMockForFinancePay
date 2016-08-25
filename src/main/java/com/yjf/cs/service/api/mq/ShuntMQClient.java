/*
 * www.yiji.com Inc.
 * Copyright (c) 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * husheng@yiji.com 2016-04-30 16:36 创建
 *
 */
package com.yjf.cs.service.api.mq;

import com.yjf.cs.service.order.ShunMessageOrder;

/**
 * @author husheng@yiji.com
 */
public interface ShuntMQClient {

   void notify(ShunMessageOrder order);
}

/*
 * www.yiji.com Inc.
 * Copyright (c) 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * husheng@yiji.com 2016-05-06 21:24 创建
 *
 */
package com.yiji.openapimock.notify;

import com.yiji.openapi.arch.facade.OpenApiArchServcie;
import com.yiji.openapi.arch.facade.order.ApiNotifyOrder;
import com.yiji.openapi.arch.facade.result.ApiArchCommonResult;
import com.yiji.openapi.arch.marshall.HttpNotifyMarshall;
import com.yiji.openapi.arch.service.base.ApiContext;
import com.yiji.openapi.arch.service.base.InternalApiContextHolder;
import com.yiji.openapi.arch.service.entity.ApiNotify;
import com.yiji.openapi.arch.service.entity.ApiRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author husheng@yiji.com
 */
@Component
public class AsyncNotifier {
    private static final Logger logger = LoggerFactory.getLogger(AsyncNotifier.class);

    private static final int DEFAULT_DELAY_TIME_IN_SECOND = 5;
    @Autowired
    private OpenApiArchServcie openApiArchServcie;
    @Autowired
    private HttpNotifyMarshall httpNotifyMarshall;

    private ExecutorService service = Executors.newFixedThreadPool(10);

    /**
     * 发送异步通知
     * @param delayTimeInSecond 几秒后发送
     * @param request
     * @param notify
     */
    public void asyncNotify(int delayTimeInSecond, ApiRequest request, ApiNotify notify) {
        ApiContext  apiContext = InternalApiContextHolder.getApiContext();

        service.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(delayTimeInSecond);
                } catch (Exception e) {
                }

                InternalApiContextHolder.setApiContext(apiContext);

                ApiNotifyOrder order = new ApiNotifyOrder();
                order.setPartnerId(request.getPartnerId());
                order.setMerchOrderNo(StringUtils.isNotEmpty(request.getMerchOrderNo())?request.getMerchOrderNo():request.getOrderNo());
                order.setGid(apiContext.getGid());
                Map<String, String> notifyData = httpNotifyMarshall.marshall(notify);
                order.setData(notifyData);

                logger.info("通知参数：{}", order);
                ApiArchCommonResult apiArchCommonResult = openApiArchServcie.asyncNotify(order);
                logger.info("通知结果：{}", apiArchCommonResult);

                InternalApiContextHolder.clear();
            }
        });

    }

    /**
     * 发送异步通知
     * @param request
     * @param notify
     * @see AsyncNotifier#DEFAULT_DELAY_TIME_IN_SECOND
     */
    public void asyncNotify(ApiRequest request, ApiNotify notify) {
        asyncNotify(DEFAULT_DELAY_TIME_IN_SECOND, request, notify);
    }
}

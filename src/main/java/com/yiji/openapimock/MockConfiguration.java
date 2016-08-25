/*
 * www.yiji.com Inc.
 * Copyright (c) 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * husheng@yiji.com 2016-04-30 16:26 创建
 *
 */
package com.yiji.openapimock;

import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import com.yiji.openapi.arch.servlet.OpenAPIDispatchServlet;
import com.yjf.core.bus.service.api.query.MerchantProductCheckService;
import com.yjf.core.bus.service.api.query.MerchantProductCheckServiceImpl;
import com.yjf.cs.service.api.mq.ShuntMQClient;
import com.yjf.cs.service.api.mq.ShuntMQClientImpl;
import com.yjf.customer.service.api.query.merchant.MerchantQueryService;
import com.yjf.customer.service.api.query.merchant.MerchantQueryServiceImpl;

/**
 * @author husheng@yiji.com
 */
@Configuration
@ImportResource("classpath:spring/openapi-arch-core.xml")
public class MockConfiguration {
	
	@Bean
	public MerchantProductCheckService merchantProductCheckService() {
		return new MerchantProductCheckServiceImpl();
	}
	
	@Bean
	public MerchantQueryService merchantQueryService() {
		return new MerchantQueryServiceImpl();
	}
	
	@Bean
	public ShuntMQClient shuntMQClient() {
		return new ShuntMQClientImpl();
	}
	
	@Bean
	public ServletRegistrationBean mockGateway() {
		return new ServletRegistrationBean(new OpenAPIDispatchServlet(), "/gateway.html");
	}

}

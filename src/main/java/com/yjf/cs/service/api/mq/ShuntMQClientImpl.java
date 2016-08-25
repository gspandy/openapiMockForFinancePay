/*
 * www.yiji.com Inc.
 * Copyright (c) 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * husheng@yiji.com 2016-05-01 09:18 创建
 *
 */
package com.yjf.cs.service.api.mq;

import com.google.common.base.Throwables;
import com.google.common.collect.Maps;
import com.yiji.openapimock.utils.SignUtil;
import com.yjf.common.lang.exception.Exceptions;
import com.yjf.common.lang.security.DigestUtil;
import com.yjf.common.lang.util.DateUtil;
import com.yjf.common.net.HttpUtil;
import com.yjf.cs.service.order.ShunMessageOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.net.ConnectException;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author husheng@yiji.com
 */
public class ShuntMQClientImpl implements ShuntMQClient {
	private static final Logger logger = LoggerFactory.getLogger(ShuntMQClientImpl.class);
	private static Map<String, String> headerMap = Maps.newHashMapWithExpectedSize(1);
	
	static {
		headerMap.put("User-Agent", "www.yiji.com");
	}
	
	@Override
	public void notify(ShunMessageOrder order) {
		try {
			logger.info("代签名串：message", order);
			String securityCheckCode = order.getSecurityCheckCode();
			String url = order.getUrl();
			String charset = order.getCharset();
			Map<String, Object> dataMap = new HashMap<>();
			
			dataMap.putAll(order.getContent());
			
			String signType = order.getSignType();
			//安全校验码不能作为参数传入到客户端
			dataMap.remove("securityCheckCode");
			dataMap.put("notifyTime", DateUtil.simpleFormat(new Date()));
			logger.info("代签名串：dataMap{}", dataMap);
			//没有securityCheckCode就不签名
			if (securityCheckCode != null && signType != null) {
				/*dataMap.put(
					DigestUtil.SIGN_KEY,
					DigestUtil.digest(dataMap, securityCheckCode,
						DigestUtil.DigestALGEnum.getByName(signType), charset));*/
				
				String signReslult = SignUtil.digest(dataMap, signType, securityCheckCode, charset);
				logger.info("通过签名方式 {} 签名后的值 {}。", signType, signReslult);
				dataMap.put(DigestUtil.SIGN_KEY, signReslult);
				
			}
			
			HttpUtil.HttpResult result = HttpUtil.getInstance().post(url, dataMap, headerMap, charset);
			String msg = result.getBody();
			if (msg == null) {
				logger.info("http请求{}成功，返回数据为:null", url);
				throw Exceptions.newRuntimeExceptionWithoutStackTrace("请求成功，返回状态码为：" + result.getStatusCode()
																		+ " ,返回数据为空");
			} else {
				String tmpMessage = msg;
				if (tmpMessage.length() > 100) {
					tmpMessage = tmpMessage.substring(0, 99) + "...";
				}
				logger.info("http请求{}成功 返回状态码 {} 返回数据为:{}", url, result.getStatusCode(), tmpMessage);
			}
			
		} catch (Exception e) {
			Throwable throwable = Throwables.getRootCause(e);
			if (throwable instanceof java.net.SocketTimeoutException || throwable instanceof ConnectException) {
				logger.error("通知失败:{}", e.getMessage());
			} else if (throwable instanceof UnknownHostException) {
				logger.error("通知失败: java.net.UnknownHostException:{}", e.getMessage());
			} else {
				logger.error("通知失败", e);
			}
			
			throw Exceptions.newRuntimeExceptionWithoutStackTrace("通知失败，异常为：" + e.getMessage());
		}
	}
}

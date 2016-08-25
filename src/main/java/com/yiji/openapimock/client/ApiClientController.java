/*
 * www.yiji.com Inc.
 * Copyright (c) 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * husheng@yiji.com 2016-05-09 15:42 创建
 *
 */
package com.yiji.openapimock.client;

import com.yiji.openapi.arch.util.Https;
import com.yjf.common.lang.security.DigestUtil;
import com.yjf.common.util.StringUtils;
import com.yjf.common.util.ToString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;

/**
 * @author husheng@yiji.com
 */
@Controller
public class ApiClientController {
	
	private static final Logger logger = LoggerFactory.getLogger(ApiClientController.class);
	
	private static final List<KV> URLS = new ArrayList<>();
	private static final List<KV>  SERVICES = new ArrayList<>();
	private static final List<KV> PARTNER_IDS = new ArrayList<>();
	
	static {
		URLS.add(new KV("http://apitest.yxtweb.com/gateway.html", "https://apitest.yxtweb.com/gateway.html(线上易行通)"));
		URLS.add(new KV("https://api.yxtweb.com/gateway.html", "https://api.yxtweb.com/gateway.html(线上易行通)"));
		URLS.add(new KV("https://api.yiji.com/gateway.html", "https://api.yiji.com/gateway.html(线上易极付)"));
		URLS.add(new KV("https://openapi.yiji.com/gateway.html", "https://openapi.yiji.com/gateway.html(线上易极付)"));
		URLS.add(new KV("http://localhost:8630/gateway.html", "https://localhost:8630/gateway.html(本机)"));

		SERVICES.add(new KV("yxtQuicklyRemittance","yxtQuicklyRemittance(快捷代发)"));
		SERVICES.add(new KV("installmentRemittance","installmentRemittance(代发)"));
		SERVICES.add(new KV("installmentSign", "installmentSign(签约分期收款)"));
		SERVICES.add(new KV("installmentQuerySign", "installmentQuerySign(查询签约信息)"));
		SERVICES.add(new KV("installmentChangeBankCard", "installmentChangeBankCard(修改银行卡)"));
		SERVICES.add(new KV("installmentModifySchedule", "installmentModifySchedule(修改还款计划)"));
		SERVICES.add(new KV("installmentOfflineRepaid", "installmentOfflineRepaid(线下分期还款)"));
		SERVICES.add(new KV("installmentBankCardVerify", "installmentBankCardVerify(分期银行卡验证)"));
		SERVICES.add(new KV("yxtBankCardVerifyQuery", "yxtBankCardVerifyQuery(易行通查询银行卡验证结果)"));
		SERVICES.add(new KV("yxtRemindSms", "yxtRemindSms(短信提醒)"));
		SERVICES.add(new KV("installmentQueryOrder", "installmentQueryOrder(查询订单信息)"));
		SERVICES.add(new KV("installmentPrepaymentQueryOrder", "installmentPrepaymentQueryOrder(分期提前款查询)"));
		SERVICES.add(new KV("installmentOfflinePrepayment", "installmentOfflinePrepayment(线下提前还款)"));
		SERVICES.add(new KV("installmentRetryWithhold", "installmentRetryWithhold(重试代扣)"));
		SERVICES.add(new KV("installmentPrepayment", "installmentPrepayment(提前还款)"));
		SERVICES.add(new KV("installmentRetryPrepayment", "installmentRetryPrepayment(重试提前还款)"));
		SERVICES.add(new KV("yxtRetrySelfRepay", "yxtRetrySelfRepay(重试自助还款)"));
		SERVICES.add(new KV("installmentSelfRepay", "installmentSelfRepay(分期自助还款)"));
		SERVICES.add(new KV("installmentSelfRepayQueryOrder", "installmentSelfRepayQueryOrder(分期自助还款查询)"));
		SERVICES.add(new KV("yxtDeductSignModify", "yxtDeductSignModify(易行通签约代扣)"));
		SERVICES.add(new KV("yxtDeductSignQuery", "yxtDeductSignQuery(易行通代扣签约查询)"));
		SERVICES.add(new KV("yxtBatchDeduct", "yxtBatchDeduct(批量代扣)"));
		SERVICES.add(new KV("yxtDeductQuery", "yxtDeductQuery(代扣查询)"));
		SERVICES.add(new KV("yxtDeduct", "yxtDeduct(代扣)"));
		SERVICES.add(new KV("yxtDeductSign", "yxtDeductSign(代扣签约)"));
		SERVICES.add(new KV("yxtDeductEncrypt", "yxtDeductEncrypt(易行通通用服务)"));
		SERVICES.add(new KV("installmentRemittance", "installmentRemittance(代发)"));
		SERVICES.add(new KV("installmentRemittanceQuery", "installmentRemittanceQuery(代发记录查询)"));
		SERVICES.add(new KV("yxtQuicklyRemittance", "yxtQuicklyRemittance(易行通快捷代发)"));
		SERVICES.add(new KV("ping", "ping(PING服务)"));

		PARTNER_IDS.add(new KV("20120918100000006549", "20120918100000006549(重庆易极付科技有限公司)"));
		PARTNER_IDS.add(new KV("20141105020002400177", "20141105020002400177(分期收款-线上)"));
		PARTNER_IDS.add(new KV("20141105020002400309", "20141105020002400309(物业缴费-线上)"));
		PARTNER_IDS.add(new KV("20151105020009085082", "20151105020009085082(分期收款2-线上)"));
		PARTNER_IDS.add(new KV("20150115020000063632", "20150115020000063632(测试outside)"));
		
		
	}
	
	@RequestMapping("/client")
	public String client(ModelMap modelMap) throws IOException {
		modelMap.put("urls", URLS);
		modelMap.put("services", SERVICES);
		modelMap.put("partnerIds", PARTNER_IDS);
		return "client";
	}
	
	@RequestMapping("/client.json")
	@ResponseBody
	public Https.HttpResult client(ClientForm form) throws IOException {
		
		logger.info("请求参数：{}", form);

		Properties prop = new Properties();
		prop.load(new ByteArrayInputStream(form.getData().getBytes()));

		Map<String, String> dataMap = new HashMap<>();
		for (Map.Entry<Object, Object> entry : prop.entrySet()) {
			dataMap.put(StringUtils.trim(entry.getKey().toString()), StringUtils.trim(new String(entry.getValue().toString().getBytes("ISO-8859-1"), "utf-8")));
		}
		
		dataMap.put("partnerId", form.getPartnerId());
		dataMap.put("protocol", "httpPost");
		dataMap.put("version", "1.0");
		dataMap.put("signType", "MD5");
		dataMap.put("orderNo", UUID.randomUUID().toString());
		dataMap.put("service", form.getService());
		
		String sign = DigestUtil.digest(dataMap, form.getSecurityCode(), DigestUtil.DigestALGEnum.MD5);
		dataMap.put("sign", sign);
		
		logger.info("签约后参数：{}", dataMap);
		Https.HttpResult result = Https.post(form.getUrl(), dataMap, "utf-8");
		logger.info("请求响应：{}", result);
		
		return result;
	}
	
	public static class ClientForm {
		private String url;
		private String partnerId;
		private String securityCode;
		private String service;
		private String data;
		
		public String getUrl() {
			return url;
		}
		
		public void setUrl(String url) {
			this.url = url;
		}
		
		public String getPartnerId() {
			return partnerId;
		}
		
		public void setPartnerId(String partnerId) {
			this.partnerId = partnerId;
		}
		
		public String getSecurityCode() {
			return securityCode;
		}
		
		public void setSecurityCode(String securityCode) {
			this.securityCode = securityCode;
		}
		
		public String getService() {
			return service;
		}
		
		public void setService(String service) {
			this.service = service;
		}
		
		public String getData() {
			return data;
		}
		
		public void setData(String data) {
			this.data = data;
		}
		
		@Override
		public String toString() {
			return ToString.toString(this);
		}
	}
	
	public static class KV {
		private String key;
		private String value;
		
		public KV(String key, String value) {
			this.key = key;
			this.value = value;
		}
		
		public String getKey() {
			return key;
		}
		
		public void setKey(String key) {
			this.key = key;
		}
		
		public String getValue() {
			return value;
		}
		
		public void setValue(String value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return "KV{" +
					"key='" + key + '\'' +
					", value='" + value + '\'' +
					'}';
		}
	}
}

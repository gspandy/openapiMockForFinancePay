/*
 * www.yiji.com Inc.
 * Copyright (c) 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * husheng@yiji.com 2016-05-01 09:13 创建
 *
 */
package com.yjf.cs.service.order;

import com.yjf.cs.service.model.MessageType;
import java.util.Map;

/**
 * @author husheng@yiji.com
 */
public class ShunMessageOrder {
	private MessageType type;
	private String gid;
	private String partnerId;
	private String merchOrderNo;
	private String charset;
	private String url;
	private String signType;
	private String securityCheckCode;
	private Map<String, String> content;
	
	public MessageType getType() {
		return type;
	}
	
	public void setType(MessageType type) {
		this.type = type;
	}
	
	public String getGid() {
		return gid;
	}
	
	public void setGid(String gid) {
		this.gid = gid;
	}
	
	public String getPartnerId() {
		return partnerId;
	}
	
	public void setPartnerId(String partnerId) {
		this.partnerId = partnerId;
	}
	
	public String getMerchOrderNo() {
		return merchOrderNo;
	}
	
	public void setMerchOrderNo(String merchOrderNo) {
		this.merchOrderNo = merchOrderNo;
	}
	
	public String getCharset() {
		return charset;
	}
	
	public void setCharset(String charset) {
		this.charset = charset;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getSignType() {
		return signType;
	}
	
	public void setSignType(String signType) {
		this.signType = signType;
	}
	
	public String getSecurityCheckCode() {
		return securityCheckCode;
	}
	
	public void setSecurityCheckCode(String securityCheckCode) {
		this.securityCheckCode = securityCheckCode;
	}
	
	public Map<String, String> getContent() {
		return content;
	}
	
	public void setContent(Map<String, String> content) {
		this.content = content;
	}
}

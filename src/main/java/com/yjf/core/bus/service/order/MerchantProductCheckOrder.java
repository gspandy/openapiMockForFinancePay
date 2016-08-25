/*
 * www.yiji.com Inc.
 * Copyright (c) 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * husheng@yiji.com 2016-05-01 08:27 创建
 *
 */
package com.yjf.core.bus.service.order;

/**
 * @author husheng@yiji.com
 */
public class MerchantProductCheckOrder {
	private String servCode;
	private String cardNo;
	private String gid;
	private String partnerId;
	private String merchOrderNo;
	
	public String getServCode() {
		return servCode;
	}
	
	public void setServCode(String servCode) {
		this.servCode = servCode;
	}
	
	public String getCardNo() {
		return cardNo;
	}
	
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
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
}

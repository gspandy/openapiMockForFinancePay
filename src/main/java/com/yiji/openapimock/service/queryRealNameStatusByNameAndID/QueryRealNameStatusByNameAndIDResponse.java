/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved.
 */

/*
 * 修订记录：
 * husheng@yiji.com 2014年8月8日 上午10:22:36创建
 */
package com.yiji.openapimock.service.queryRealNameStatusByNameAndID;

import com.yiji.openapi.arch.meta.OpenApiField;
import com.yiji.openapi.arch.service.entity.ApiResponse;

/**
 * 
 * 
 * @author damo@yiji.com
 * 
 */
public class QueryRealNameStatusByNameAndIDResponse extends ApiResponse {
	
	@OpenApiField(desc = "真实姓名", constraint = "真实姓名",demo = "易极付")
	private String realName;
	
	@OpenApiField(desc = "身份证号", constraint = "身份证号",demo = "123456798012345678")
	private String certNo;
	
	@OpenApiField(desc = "是否通过公安部认证", constraint = "true/false",demo = "true")
	private boolean isPass;
	
	@OpenApiField(desc = "公安部返回图片", constraint = "公网可访问的图片地址",demo = "http://www.yiji.com/1.jpg")
	private String auditpic;
	
	@OpenApiField(desc = "公安部返回认证失败的信息", demo = "失败信息")
	private String errorMessage;
	
	public String getRealName() {
		return this.realName;
	}
	
	public void setRealName(String realName) {
		this.realName = realName;
	}
	
	public String getCertNo() {
		return this.certNo;
	}
	
	public void setCertNo(String certNo) {
		this.certNo = certNo;
	}
	
	public boolean isPass() {
		return this.isPass;
	}
	
	public void setIsPass(boolean isPass) {
		this.isPass = isPass;
	}
	
	public String getAuditpic() {
		return this.auditpic;
	}
	
	public void setAuditpic(String auditpic) {
		this.auditpic = auditpic;
	}
	
	public String getErrorMessage() {
		return this.errorMessage;
	}
	
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
}

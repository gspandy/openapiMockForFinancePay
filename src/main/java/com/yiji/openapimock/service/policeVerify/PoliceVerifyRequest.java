package com.yiji.openapimock.service.policeVerify;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.yiji.openapi.arch.meta.OpenApiField;
import com.yiji.openapi.arch.service.entity.ApiRequest;

public class PoliceVerifyRequest extends ApiRequest {
	@NotBlank
	@OpenApiField(desc = "真实姓名", constraint = "真实姓名",demo = "易极付")
	private String realName;
	
	@NotBlank
	@OpenApiField(desc = "身份证号", constraint = "身份证号",demo = "123465978012345678")
	private String certNo;
	
	@OpenApiField(desc = "证件类型", constraint = "证件类型",demo = "ID")
	private String certType;

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getCertNo() {
		return certNo;
	}

	public void setCertNo(String certNo) {
		this.certNo = certNo;
	}

	public String getCertType() {
		return certType;
	}

	public void setCertType(String certType) {
		this.certType = certType;
	}

}

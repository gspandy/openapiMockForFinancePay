/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 
 * mdaheng@yiji.com 2016-04-22 15:00 创建
 *
 */
package com.yiji.openapimock.service.asynVerifyCardThree;


import com.yiji.openapi.arch.meta.OpenApiField;
import com.yiji.openapi.arch.service.entity.ApiResponse;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author damo
 */
public class AsynVerifyCardThreeResponse extends ApiResponse {

    @NotBlank
    @OpenApiField(desc = "校验流水号" , demo = "6151421051514" , constraint = "流水号")
    private String pactNo;

    @OpenApiField(desc = "校验状态" , demo = "VERIFY_SUCCESS")
    private String verifyStatus;

    /**
     * 验卡失败时，用于存放错误码
     */
    private String code;
    
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getPactNo() {
		return pactNo;
	}

	public void setPactNo(String pactNo) {
		this.pactNo = pactNo;
	}

	public String getVerifyStatus() {
		return verifyStatus;
	}

	public void setVerifyStatus(String verifyStatus) {
		this.verifyStatus = verifyStatus;
	}

   
    

}

/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 
 * mdaheng@yiji.com 2016-04-22 17:07 创建
 *
 */
package com.yiji.openapimock.service.asynVerifyCardThree;

import com.sun.javafx.collections.MappingChange.Map;
import com.yiji.openapi.arch.meta.OpenApiField;
import com.yiji.openapi.arch.service.entity.ApiNotify;

import org.hibernate.validator.constraints.NotBlank;

/**
 * @author xzhengyu
 * @email mdaheng@yiji.com
 * @since 2016-04-22
 */
public class AsynVerifyCardThreeNotify extends ApiNotify {
    @NotBlank
    @OpenApiField(desc = "通用签约流水号", demo = "6151421051514", constraint = "流水号")
    private String pactNo;

    @NotBlank
    @OpenApiField(desc = "校验状态", demo = "BC")
    private String verifyStatus;

    /**
     * 验卡失败时，用于存放错误码
     */
    @NotBlank
    @OpenApiField(desc = "错误码", demo = "S_100_100")
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

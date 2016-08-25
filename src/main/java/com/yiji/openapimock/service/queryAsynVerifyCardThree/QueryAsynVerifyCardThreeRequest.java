/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 
 * mdaheng@yiji.com 2016-04-22 17:46 创建
 *
 */
package com.yiji.openapimock.service.queryAsynVerifyCardThree;

import com.yiji.openapi.arch.exception.ApiServiceException;
import com.yiji.openapi.arch.exception.ApiServiceResultCode;
import com.yiji.openapi.arch.meta.OpenApiField;
import com.yiji.openapi.arch.service.entity.ApiRequest;
import com.yjf.common.service.OrderCheckException;
import com.yjf.common.util.StringUtils;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author xzhengyu
 * @email mdaheng@yiji.com
 * @since 2016-04-22
 */
public class QueryAsynVerifyCardThreeRequest extends ApiRequest {

    @NotBlank
    @OpenApiField(desc = "校验流水号" , demo = "6151421051514" , constraint = "流水号")
    private String pactNo;

    public String getPactNo() {
        return pactNo;
    }

    public void setPactNo(String pactNo) {
        this.pactNo = pactNo;
    }

    @Override
    public void check() throws OrderCheckException {
        if(StringUtils.isBlank(getMerchOrderNo())) {
            throw new ApiServiceException(ApiServiceResultCode.PARAMETER_ERROR, "MerchOrderNo不能为空！");
        }
    }
}

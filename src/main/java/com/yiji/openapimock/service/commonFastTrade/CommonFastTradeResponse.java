package com.yiji.openapimock.service.commonFastTrade;

import com.yiji.openapi.arch.meta.OpenApiField;
import com.yiji.openapi.arch.service.entity.ApiResponse;

/**
 * @author damo@yiji.com
 * @since 2016-03-11 11:08.
 */
public class CommonFastTradeResponse extends ApiResponse {

    /**
     * 业务流水号
     */
    @OpenApiField(desc = "业务流水号",demo = "1265123.4156")
    private String bizNo;

    public String getBizNo() {
        return bizNo;
    }

    public void setBizNo(String bizNo) {
        this.bizNo = bizNo;
    }
}

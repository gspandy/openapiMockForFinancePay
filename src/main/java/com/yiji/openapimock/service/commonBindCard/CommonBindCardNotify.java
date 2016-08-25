package com.yiji.openapimock.service.commonBindCard;

import com.yiji.openapi.arch.meta.OpenApiField;
import com.yiji.openapi.arch.service.entity.ApiNotify;

/**
 * @author hgeshu@yiji.com
 * @since 2016-03-11 18:52.
 */
public class CommonBindCardNotify extends ApiNotify {
    /** 协议号 */
    @OpenApiField(desc = "协议号",demo = "5456454658")
    private String protocolNo;
    /** 子协议号 */
    @OpenApiField(desc = "子协议号",demo = "1256346534861232")
    private String protocolChildNo;

    /** 签约状态 */
    @OpenApiField(desc = "签约状态")
    private String pactStatus;

    public String getProtocolNo() {
        return protocolNo;
    }

    public void setProtocolNo(String protocolNo) {
        this.protocolNo = protocolNo;
    }

    public String getProtocolChildNo() {
        return protocolChildNo;
    }

    public void setProtocolChildNo(String protocolChildNo) {
        this.protocolChildNo = protocolChildNo;
    }

    public String getPactStatus() {
        return pactStatus;
    }

    public void setPactStatus(String pactStatus) {
        this.pactStatus = pactStatus;
    }
}

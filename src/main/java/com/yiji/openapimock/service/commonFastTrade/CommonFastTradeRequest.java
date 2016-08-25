package com.yiji.openapimock.service.commonFastTrade;

import com.yiji.openapi.arch.meta.OpenApiField;
import com.yiji.openapi.arch.service.entity.ApiRequest;
import com.yjf.common.lang.util.money.Money;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * @author damo@yiji.com
 * @since 2016-03-11 11:08.
 */
public class CommonFastTradeRequest extends ApiRequest {

    /** 协议号 */
    @NotBlank
    @OpenApiField(desc = "协议号",demo = "15423647321")
    private String protocolNo;

    /** 子协议号 */
    @NotBlank
    @OpenApiField(desc = "子协议号",demo = "135246531")
    private String protocolChildNo;

    /** 交易金额 */
    @NotNull
    @OpenApiField(desc = "交易金额",demo = "88.66")
    private Money tradeAmount;

    /** 卖家会员id */
    @NotBlank
    @Length(max = 20, min = 20)
    @OpenApiField(desc = "卖家会员id",demo = "12345678901234657890")
    private String sellerUserId;

    @Length(max = 128)
    @OpenApiField(desc = "备注",demo = "备注")
    private String memo;

    @NotBlank
    @Length(max = 32, min = 1)
    @OpenApiField(desc = "商户订单号",demo = "215354632165")
    private String outOrderNo;

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

    public Money getTradeAmount() {
        return tradeAmount;
    }

    public void setTradeAmount(Money tradeAmount) {
        this.tradeAmount = tradeAmount;
    }

    public String getSellerUserId() {
        return sellerUserId;
    }

    public void setSellerUserId(String sellerUserId) {
        this.sellerUserId = sellerUserId;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getOutOrderNo() {
        return outOrderNo;
    }

    public void setOutOrderNo(String outOrderNo) {
        this.outOrderNo = outOrderNo;
    }
}

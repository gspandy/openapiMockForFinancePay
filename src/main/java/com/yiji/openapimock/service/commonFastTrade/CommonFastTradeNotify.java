package com.yiji.openapimock.service.commonFastTrade;

import com.yiji.openapi.arch.meta.OpenApiField;
import com.yiji.openapi.arch.service.entity.ApiNotify;

/**
 * @author hgeshu@yiji.com
 * @since 2016-03-14 9:47.
 */
public class CommonFastTradeNotify extends ApiNotify {

    /**
     * 业务流水号
     */
    @OpenApiField(desc = "业务流水号",demo = "1265123.4156")
    private String bizNo;

    @OpenApiField(desc = "商户订单号",demo = "12567842134")
    private String outOrderNo;

    @OpenApiField(desc = "交易金额",demo = "88.66")
    private String tradeAmount;

    @OpenApiField(desc = "买家手续费",demo = "8.66")
    private String buyerChargeAmount;

    @OpenApiField(desc = "卖家手续费",demo = "8.66")
    private String sellerChargeAmount;

    @OpenApiField(desc = "商户手续费",demo = "8.66")
    private String merchantChargeAmount;

    @OpenApiField(desc = "收款状态",demo = "success",constraint = "{\"data\":[\"success:收款成功\",\"fail:收款失败\"],\"name\":\"收款状态\"}")
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBizNo() {
        return bizNo;
    }

    public void setBizNo(String bizNo) {
        this.bizNo = bizNo;
    }

    public String getOutOrderNo() {
        return outOrderNo;
    }

    public void setOutOrderNo(String outOrderNo) {
        this.outOrderNo = outOrderNo;
    }

    public String getTradeAmount() {
        return tradeAmount;
    }

    public void setTradeAmount(String tradeAmount) {
        this.tradeAmount = tradeAmount;
    }

    public String getBuyerChargeAmount() {
        return buyerChargeAmount;
    }

    public void setBuyerChargeAmount(String buyerChargeAmount) {
        this.buyerChargeAmount = buyerChargeAmount;
    }

    public String getSellerChargeAmount() {
        return sellerChargeAmount;
    }

    public void setSellerChargeAmount(String sellerChargeAmount) {
        this.sellerChargeAmount = sellerChargeAmount;
    }

    public String getMerchantChargeAmount() {
        return merchantChargeAmount;
    }

    public void setMerchantChargeAmount(String merchantChargeAmount) {
        this.merchantChargeAmount = merchantChargeAmount;
    }

}

/*
 * www.yiji.com Inc.
 * Copyright (c) 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * husheng@yiji.com 2016-04-30 16:42 创建
 *
 */
package com.yiji.openapimock.service.commonBindCard;

import com.yiji.openapi.arch.meta.OpenApiField;
import com.yiji.openapi.arch.service.entity.ApiRequest;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author damo@yiji.com
 */
public class CommonBindCardRequest extends ApiRequest {
	 /**
     *  协议号 大概表示是用户。 用户第一次申请时可以不填，而用户后期想绑定卡在同一个用户下， 必须填写这个相同的值，不然产生多个用户
     *
     * */
    @OpenApiField(desc = "签约协议号")
    private String protocolNo;
    /**
     * 卡号
     */
    @NotEmpty
    @OpenApiField(desc = "银行卡号")
    private String cardNo;

    /**
     * 证件号
     */
    @NotEmpty
    @OpenApiField(desc = "证件号码")
    private String certNo;
    /**
     * 持卡人姓名
     */
    @NotEmpty
    @OpenApiField(desc = "持卡人姓名")
    private String cardName;
    /**
     * 四要素验证时必填
     */
    @OpenApiField(desc = "银行预留手机号")
    private String mobileNo;

	public String getProtocolNo() {
		return protocolNo;
	}

	public void setProtocolNo(String protocolNo) {
		this.protocolNo = protocolNo;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getCertNo() {
		return certNo;
	}

	public void setCertNo(String certNo) {
		this.certNo = certNo;
	}

	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
    
    
    
}

/**
 * 
 */
package com.yiji.openapimock.service.userBalanceQuery;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.yiji.openapi.arch.meta.OpenApiField;
import com.yiji.openapi.arch.service.entity.ApiRequest;

/**
 * @author damo
 *
 */
public class UserBalanceQueryRequest extends ApiRequest {
	
	@OpenApiField(desc = "资金账户编码",demo = "1345614")
	private String accountNo;
	
	@NotBlank
	@Length(max = 20)
	@OpenApiField(desc = "用户id",demo = "12345678901234567980")
	private String userId;
	
	public String getAccountNo() {
		return this.accountNo;
	}
	
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	
	public String getUserId() {
		return this.userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
}

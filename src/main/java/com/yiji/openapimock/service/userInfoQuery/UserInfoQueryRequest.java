/**
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */
package com.yiji.openapimock.service.userInfoQuery;

import org.hibernate.validator.constraints.Length;

import com.yiji.openapi.arch.meta.OpenApiField;
import com.yiji.openapi.arch.service.entity.ApiRequest;
import com.yjf.common.service.OrderCheckException;
import com.yjf.common.util.StringUtils;

/**
 * 通用注册请求
 * @author damo
 * @date 2014年8月5日
 */
public class UserInfoQueryRequest extends ApiRequest {
	
	@Length(max = 20)
	@OpenApiField(desc = "易极付用户id",demo = "12345678901324567890")
	private String userId;
	
	@Length(max = 128)
	@OpenApiField(desc = "易极付用户名",demo = "易极付")
	private String userName;
	
	public UserInfoQueryRequest() {
		super();
	}
	
	public UserInfoQueryRequest(String userId) {
		super();
		this.userId = userId;
	}
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getUserName() {
		return this.userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	/**
	 * @throws OrderCheckException
	 * @see com.yiji.openapi.arch.service.entity.ApiRequest#check()
	 */
	@Override
	public void check() throws IllegalArgumentException {
		//用户id和用户名不能同时为空
		if (StringUtils.isEmpty(userId) && StringUtils.isEmpty(userName)) {
			throw new IllegalArgumentException("用户id和用户名不能同时为空");
		}
	}
}

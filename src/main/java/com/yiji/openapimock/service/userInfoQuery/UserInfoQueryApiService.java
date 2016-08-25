package com.yiji.openapimock.service.userInfoQuery;

import com.yiji.openapi.arch.exception.ApiServiceUniformCodeException;
import com.yiji.openapi.arch.meta.OpenApiService;
import com.yiji.openapi.arch.service.base.BaseApiService;
import com.yiji.openapi.arch.service.enums.ResponseType;
import com.yiji.openapimock.enums.ApiServiceBusinessResultCode;
import com.yjf.common.lang.enums.CertTypeEnum;

@OpenApiService(name = "userInfoQuery", desc = "查询用户信息", responseType = ResponseType.SYN)
public class UserInfoQueryApiService extends BaseApiService<UserInfoQueryRequest, UserInfoQueryResponse> {
	
	@Override
	protected void doService(UserInfoQueryRequest request, UserInfoQueryResponse response) {
		
		//20150204020000065523------未注册会员
		// userId 20151028010000082185---------未知异常
		//其他-----商户易极付账户存在
		
		if (request.getUserId().equals("20150204020000065523")) {
			throw new ApiServiceUniformCodeException("BK60011",
				ApiServiceBusinessResultCode.EXECUTE_FAIL.getResultCode(), "商户未注册会员");
		}

		if (request.getUserId().equals("20151028010000082185")) {
			throw new ApiServiceUniformCodeException("BK50011",
				ApiServiceBusinessResultCode.EXECUTE_FAIL.getResultCode(), "未知异常");
		} else {
			response.setUserId(request.getUserId());
			response.setUserName(request.getUserName());
			response.setEmail("qincangkeji@yiji.com");
			response.setMobileNo("131950810073120");
			response.setRealName("秦苍科技有限公司");
			response.setCertType(CertTypeEnum.BUSINESS_LICENSE);
			response.setCertNo("123456789021");
			response.setVerifyCode("sdfs");
			response.setBankCardCount(1);
			response.setUserType("BUSINESS");
			response.setCertifyStatus("AUTHERIZED");
			response.setCertifyLevel("NORMAL_BUSINESS_RANK");
			response.setUserStatus("ACTIVATED");
			response.setRuntimeStatus("NORMAL");
			
		}
	}
	
}

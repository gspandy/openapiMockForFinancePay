package com.yiji.openapimock.service.queryRealNameStatusByNameAndID;

import com.yiji.openapi.arch.exception.ApiServiceUniformCodeException;
import com.yiji.openapi.arch.meta.OpenApiService;
import com.yiji.openapi.arch.service.base.BaseApiService;
import com.yiji.openapi.arch.service.enums.ResponseType;
import com.yiji.openapimock.enums.ApiServiceBusinessResultCode;

@OpenApiService(name = "queryRealNameStatusByNameAndID", desc = "查询实名认证状态", responseType = ResponseType.SYN)
public class QueryRealNameStatusByNameAndIDApiService
														extends
														BaseApiService<QueryRealNameStatusByNameAndIDRequest, QueryRealNameStatusByNameAndIDResponse> {
	
	@Override
	protected void doService(QueryRealNameStatusByNameAndIDRequest request,
								QueryRealNameStatusByNameAndIDResponse response) {
		
		//身份证号500106199005085487实名认证失败
		// 500101198902029848 重复申请实名
		// 其他实名认证成功
		
		if (request.getCertNo().equals("500106199005085487")) {
			throw new ApiServiceUniformCodeException("BK40011",
				ApiServiceBusinessResultCode.EXECUTE_FAIL.getResultCode(), "实名认证失败");
		}
		
		if (request.getCertNo().equals("500101198902029848")) {
			throw new ApiServiceUniformCodeException("N0B0_00_0002",
				ApiServiceBusinessResultCode.EXECUTE_FAIL.getResultCode(), "重复申请");
		} else {
			response.setRealName(request.getRealName());
			response.setCertNo(request.getCertNo());
			response.setIsPass(true);
			response.setAuditpic("http://www.yiji.com/1.jpg");
			response.setErrorMessage("");
		}
	}
	
}

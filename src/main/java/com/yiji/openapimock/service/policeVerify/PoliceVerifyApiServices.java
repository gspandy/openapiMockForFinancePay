package com.yiji.openapimock.service.policeVerify;

import com.yiji.openapi.arch.exception.ApiServiceUniformCodeException;
import com.yiji.openapi.arch.meta.OpenApiService;
import com.yiji.openapi.arch.service.base.BaseApiService;
import com.yiji.openapi.arch.service.enums.ResponseType;
import com.yiji.openapimock.enums.ApiServiceBusinessResultCode;

@OpenApiService(name = "policeVerify", desc = "查询实名认证状态", responseType = ResponseType.SYN)
public class PoliceVerifyApiServices extends
								BaseApiService<PoliceVerifyRequest, PoliceVerifyResponse>{

			@Override
			protected void doService(PoliceVerifyRequest request,
					PoliceVerifyResponse response) {
				//身份证号500106199005085487,330101198108133791实名认证失败
				// 500101198902029848 重复申请实名
				// 其他实名认证成功

				if (request.getCertNo().equals("522635198708184662")||request.getCertNo().equals("330101198108133791")) {
					throw new ApiServiceUniformCodeException("BK40011",
						ApiServiceBusinessResultCode.EXECUTE_FAIL.getResultCode(), "实名认证失败");
				}
				if (request.getCertNo().equals("52263519830114890X")) {
					throw new ApiServiceUniformCodeException("N0B0_00_0002",
						ApiServiceBusinessResultCode.EXECUTE_FAIL.getResultCode(), "重复申请");
				}
				
				 else {
					 
				 }	
			}
}
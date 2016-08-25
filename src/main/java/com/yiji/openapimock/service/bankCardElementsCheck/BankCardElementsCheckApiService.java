package com.yiji.openapimock.service.bankCardElementsCheck;

import com.yiji.openapi.arch.exception.ApiServiceResultCode;
import com.yiji.openapi.arch.exception.ApiServiceUniformCodeException;
import com.yiji.openapi.arch.meta.OpenApiService;
import com.yiji.openapi.arch.service.base.BaseApiService;
import com.yiji.openapi.arch.service.enums.ResponseType;
import com.yiji.openapimock.enums.ApiServiceBusinessResultCode;
import com.yjf.common.util.StringUtils;

@OpenApiService(name = "bankCardElementsCheck", desc = "银行卡三要素验证", version = "1.0", responseType = ResponseType.SYN)
public class BankCardElementsCheckApiService extends
											BaseApiService<BankCardElementsCheckRequest, BankCardElementsCheckResponse> {
	
	@Override
	protected void doService(BankCardElementsCheckRequest request, BankCardElementsCheckResponse response) {
		//4367423761580233350  非法参数
		//4367423761580233340  同步验卡失败
		//其他--验卡成功
		if (request.getCardNo().equals("4367423761580233350")) {
			throw new ApiServiceUniformCodeException("BK70011",
				ApiServiceBusinessResultCode.EXECUTE_FAIL.getResultCode(), "非法参数");
		}
		if (request.getCardNo().equals("4367423761580233340")) {		
			
			throw new ApiServiceUniformCodeException("BK70040","BK70040", "同步验卡失败");
		} 
		else {
			response.setPartnerId(request.getPartnerId());
		}
	}
	
}

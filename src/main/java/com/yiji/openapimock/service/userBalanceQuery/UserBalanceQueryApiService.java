package com.yiji.openapimock.service.userBalanceQuery;

import com.yiji.openapi.arch.exception.ApiServiceUniformCodeException;
import com.yiji.openapi.arch.meta.OpenApiService;
import com.yiji.openapi.arch.service.base.BaseApiService;
import com.yiji.openapi.arch.service.enums.ResponseType;
import com.yiji.openapimock.enums.ApiServiceBusinessResultCode;
import com.yjf.common.lang.util.money.Money;

@OpenApiService(name = "userBalanceQuery", desc = "查询用户余额", responseType = ResponseType.SYN, version = "1.0")
public class UserBalanceQueryApiService extends BaseApiService<UserBalanceQueryRequest, UserBalanceQueryResponse> {
	
	@Override
	protected void doService(UserBalanceQueryRequest request, UserBalanceQueryResponse response) {
		//userId 20150410010000068621 查询余额失败 
		//userId  20150410010000068622 模拟账户余额为1元
		// 其他查询成功
		if (request.getUserId().equals("20150410010000068621")) {
			throw new ApiServiceUniformCodeException("BK80011",
				ApiServiceBusinessResultCode.EXECUTE_FAIL.getResultCode(), "查询余额失败");
		}else if(request.getUserId().equals("20150410010000068622")){
			//查询金额<收费金额时，余额不足
			response.setBalance(new Money(1));
			response.setAvailableBalance(new Money(1));
			response.setFreezenBalance(new Money(0));
		} 
		else {
			response.setBalance(new Money(1000000));
			response.setAvailableBalance(new Money(1000000));
			response.setFreezenBalance(new Money(0));
		}
		
	}
	
}

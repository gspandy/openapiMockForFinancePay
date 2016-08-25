package com.yiji.openapimock.service.queryAsynVerifyCardThree;

import com.yiji.openapi.arch.meta.OpenApiService;
import com.yiji.openapi.arch.service.base.BaseApiService;
import com.yiji.openapi.arch.service.enums.ResponseType;


@OpenApiService(name = "queryAsynVerifyCardThree" , desc = "三要素异步验卡查询", responseType = ResponseType.SYN)
public class QueryAsynVerifyCardThreeApiService extends BaseApiService<QueryAsynVerifyCardThreeRequest,QueryAsynVerifyCardThreeResponse>{

	@Override
	protected void doService(QueryAsynVerifyCardThreeRequest request, QueryAsynVerifyCardThreeResponse response) {
		
		//pactNo =32547821245655555555   模拟查询验卡状态返回处理中
		//pactNo =32547821245677777777   模拟查询验卡状态返回失败
	   // 其他情况，模拟查询 验卡返回成功
		if(request.getPactNo().equals("32547821245655555555")){
			
			response.setVerifyStatus("VERIFY_PROCESSING");
			response.setDescription("处理中");
			
		}else if(request.getPactNo().equals("32547821245677777777")){
			
			response.setVerifyStatus("VERIFY_FAIL");
			response.setDescription("失败");
			
		}else {
			
			response.setVerifyStatus("VERIFY_SUCCESS");
			response.setDescription("成功");
			
		}
	}

}

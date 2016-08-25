package com.yiji.openapimock.service.commonBindCard;

import com.yiji.openapi.arch.exception.ApiServiceResultCode;
import com.yiji.openapi.arch.exception.ApiServiceUniformCodeException;
import com.yiji.openapi.arch.meta.OpenApiService;
import com.yiji.openapi.arch.service.base.BaseApiService;
import com.yiji.openapi.arch.service.entity.ApiNotify;
import com.yiji.openapi.arch.service.enums.ResponseType;
import com.yiji.openapimock.enums.ApiServiceBusinessResultCode;
import com.yiji.openapimock.notify.AsyncNotifier;
import com.yjf.common.id.OID;

import org.springframework.beans.factory.annotation.Autowired;

@OpenApiService(name = "commonBindCard", version = "1.0", desc = "测试服务", responseType = ResponseType.ASNY)
public class CommonBindCardApiService extends BaseApiService<CommonBindCardRequest, CommonBindCardResponse> {

	@Autowired
	private AsyncNotifier asyncNotifier;
	
	@Override
	protected void doService(CommonBindCardRequest request, CommonBindCardResponse response) {
		// 6228480470888823411------同步失败 
		//6228480470888823412----- 签约处理中
		// 6228480470888823413------异步失败
		//6228480470888823414-------同步签约成功
		// 其他-----------------------异步成功   
		
		if (request.getCardNo().equals("6228480470888823411")) {
			//同步返回失败
			throw new ApiServiceUniformCodeException("BK0021",
				ApiServiceBusinessResultCode.EXECUTE_FAIL.getResultCode(), "同步签约失败");
		}
		else if (request.getCardNo().equals("6228480470888823412")){
			//签约处理中
			String number = OID.newID();
			response.setProtocolNo(request.getProtocolNo());
			response.setProtocolChildNo(number);
			response.setResultCode(ApiServiceResultCode.PROCESSING.getResultCode());
			response.setResultMessage("签约处理中");
		}
		
		else if (request.getCardNo().equals("6228480470888823413")) {
			//异步返回失败
			String number = OID.newID();
			response.setProtocolNo(request.getProtocolNo());
			response.setProtocolChildNo(number);
			response.setResultCode(ApiServiceResultCode.PROCESSING.getResultCode());
			response.setResultMessage("签约处理中");
			//发送异步通知
			CommonBindCardNotify commonBindCardNotify = new CommonBindCardNotify();
			commonBindCardNotify.setProtocolNo(request.getProtocolNo());
			commonBindCardNotify.setProtocolChildNo(number);
			commonBindCardNotify.setPactStatus("PACT_FAIL");
			commonBindCardNotify.setResultCode(ApiServiceBusinessResultCode.EXECUTE_FAIL.getResultCode());
			asyncNotifier.asyncNotify(request, commonBindCardNotify);
			
		} 
		else if (request.getCardNo().equals("6228480470888823414")){
			//同步返回成功，表示签约系统有这个数据
			String number = OID.newID();
			response.setProtocolNo(request.getProtocolNo());
			response.setProtocolChildNo(number);
			response.setResultMessage("同步签约成功");
			
		}else {
			//异步成功
			response.setProtocolNo(request.getProtocolNo());
			String number = OID.newID();
			response.setProtocolChildNo(number);
			response.setResultCode(ApiServiceResultCode.PROCESSING.getResultCode());
			response.setResultMessage("签约处理中");
			// 发送异步通知
			CommonBindCardNotify commonBindCardNotify = new CommonBindCardNotify();
			commonBindCardNotify.setProtocolNo(request.getProtocolNo());
			commonBindCardNotify.setProtocolChildNo(number);
			commonBindCardNotify.setPactStatus("PACT");
			asyncNotifier.asyncNotify(request, commonBindCardNotify);
		}
		
	}

	@Override
	public ApiNotify getApiNotifyBean() {
		return new CommonBindCardNotify();
	}
}

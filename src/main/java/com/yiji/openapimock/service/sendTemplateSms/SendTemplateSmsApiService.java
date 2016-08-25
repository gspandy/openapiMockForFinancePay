package com.yiji.openapimock.service.sendTemplateSms;

import com.yiji.openapi.arch.meta.OpenApiService;
import com.yiji.openapi.arch.service.base.BaseApiService;
import com.yiji.openapi.arch.service.enums.ResponseType;

@OpenApiService(name = "sendTemplateSms", desc = "发送模板短信", responseType = ResponseType.SYN)
public class SendTemplateSmsApiService extends BaseApiService<SendTemplateSmsRequest, SendTemplateSmsResponse> {
	
	@Override
	protected void doService(SendTemplateSmsRequest request, SendTemplateSmsResponse response) {
		//发送模板短信成功
		response.setPartnerId(request.getPartnerId());
	}
	
}

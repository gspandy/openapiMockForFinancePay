package com.yiji.openapimock.service.asynVerifyCardThree;

import org.springframework.beans.factory.annotation.Autowired;

import com.yiji.openapi.arch.exception.ApiServiceResultCode;
import com.yiji.openapi.arch.exception.ApiServiceUniformCodeException;
import com.yiji.openapi.arch.meta.OpenApiService;
import com.yiji.openapi.arch.service.base.BaseApiService;
import com.yiji.openapi.arch.service.entity.ApiNotify;
import com.yiji.openapi.arch.service.enums.ResponseType;
import com.yiji.openapimock.enums.ApiServiceBusinessResultCode;
import com.yiji.openapimock.notify.AsyncNotifier;
import com.yjf.common.id.OID;

@OpenApiService(name = "asynVerifyCardThree", desc = "三要素异步验卡", responseType = ResponseType.ASNY)
public class AsynVerifyCardThreeApiService
		extends BaseApiService<AsynVerifyCardThreeRequest, AsynVerifyCardThreeResponse> {

	@Autowired
	private AsyncNotifier asyncNotifier;

	@Override
	protected void doService(AsynVerifyCardThreeRequest request, AsynVerifyCardThreeResponse response) {
		// 4367423761580233341   同步失败
		//4367423761580233342     异步失败, 错误码为空
		//4367423761580233343     异步失败，   错误码不为空
		//4367423761580233344     异步失败,  错误码为不收费情况
		//4367423761580233345  模拟一直没有异步通知，处理中状态
		// 其他 --异步验卡成功
		if (request.getCardNo().equals("4367423761580233341")) {
			throw new ApiServiceUniformCodeException("BK80011",
					ApiServiceBusinessResultCode.EXECUTE_FAIL.getResultCode(), "验卡失败");
			
		} else if (request.getCardNo().equals("4367423761580233342")) {
			response.setResultCode(ApiServiceResultCode.PROCESSING.getResultCode());
			response.setResultMessage("异步验卡处理中");
			response.setPactNo("32547821245611111111");
			response.setVerifyStatus("VERIFY_PROCESSING");
			// 发送异步通知
			AsynVerifyCardThreeNotify verifyCardNotify = new AsynVerifyCardThreeNotify();
			verifyCardNotify.setPactNo("32547821245611111111");
			verifyCardNotify.setVerifyStatus("VERIFY_FAIL");
			verifyCardNotify.setResultCode("");
			asyncNotifier.asyncNotify(request, verifyCardNotify);

		}else if (request.getCardNo().equals("4367423761580233343")) {
			response.setResultCode(ApiServiceResultCode.PROCESSING.getResultCode());
			response.setResultMessage("异步验卡处理中");
			response.setPactNo("32547821245622222222");
			response.setVerifyStatus("VERIFY_PROCESSING");
			// 发送异步通知
			AsynVerifyCardThreeNotify verifyCardNotify = new AsynVerifyCardThreeNotify();
			verifyCardNotify.setPactNo("32547821245622222222");
			verifyCardNotify.setVerifyStatus("VERIFY_FAIL");
			verifyCardNotify.setCode("BK10001");
			asyncNotifier.asyncNotify(request, verifyCardNotify);

		}
		else if (request.getCardNo().equals("4367423761580233344")) {
			response.setResultCode(ApiServiceResultCode.PROCESSING.getResultCode());
			response.setResultMessage("异步验卡处理中");
			response.setPactNo("32547821245633333333");
			response.setVerifyStatus("VERIFY_PROCESSING");
			// 发送异步通知
			AsynVerifyCardThreeNotify verifyCardNotify = new AsynVerifyCardThreeNotify();
			verifyCardNotify.setPactNo("32547821245633333333");
			verifyCardNotify.setVerifyStatus("VERIFY_FAIL");
			verifyCardNotify.setResultCode("S024_02_0301");
			verifyCardNotify.setCode("S024_02_0301");
			verifyCardNotify.setResultMessage("没有支持的验证渠道");
			asyncNotifier.asyncNotify(request, verifyCardNotify);

		}else if(request.getCardNo().equals("4367423761580233345")){
			// 模拟一直没有异步通知，处理中状态
			response.setResultCode(ApiServiceResultCode.PROCESSING.getResultCode());
			response.setResultMessage("异步验卡处理中");
			response.setPactNo("32547821245655555555");
			response.setVerifyStatus("VERIFY_PROCESSING");
			
			
		}else {
			response.setResultCode(ApiServiceResultCode.PROCESSING.getResultCode());
			response.setResultMessage("异步验卡处理中");
			response.setPactNo("32547821244444444444");
			response.setVerifyStatus("VERIFY_PROCESSING");
			// 发送异步通知
			AsynVerifyCardThreeNotify verifyCardNotify = new AsynVerifyCardThreeNotify();
			verifyCardNotify.setPactNo("32547821244444444444");
			verifyCardNotify.setVerifyStatus("VERIFY_SUCCESS");
			verifyCardNotify.setCode("BK10004");
			asyncNotifier.asyncNotify(request, verifyCardNotify);
		}

	}

	@Override
	public ApiNotify getApiNotifyBean() {

		return new AsynVerifyCardThreeNotify();
	}

}

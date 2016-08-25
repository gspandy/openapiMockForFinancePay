package com.yiji.openapimock.service.commonFastTrade;

import org.springframework.beans.factory.annotation.Autowired;

import com.yiji.openapi.arch.exception.ApiServiceUniformCodeException;
import com.yiji.openapi.arch.meta.OpenApiService;
import com.yiji.openapi.arch.service.base.BaseApiService;
import com.yiji.openapi.arch.service.entity.ApiNotify;
import com.yiji.openapi.arch.service.enums.ResponseType;
import com.yiji.openapimock.enums.ApiServiceBusinessResultCode;
import com.yiji.openapimock.notify.AsyncNotifier;
import com.yjf.common.id.OID;
import com.yjf.common.lang.result.Status;

@OpenApiService(name = "commonFastTrade", version = "1.0", desc = "即时收款", responseType = ResponseType.ASNY)
public class CommonFastTradeApiService extends BaseApiService<CommonFastTradeRequest, CommonFastTradeResponse> {
	
	@Autowired
	private AsyncNotifier asyncNotifier;
	
	@Override
	protected void doService(CommonFastTradeRequest request, CommonFastTradeResponse response) {
		
		// 50以内代扣成功，
		// 50--100银行卡未开通认证支付
		// 100--150余额不足
		// 150-300以上模拟异步代扣失败
		//等于300模拟代扣处理中
		//400模拟openapi直接返回TIME_OUT
		//500模拟70秒以后没有返回结果，socket超时
		//600卡无效
		//10000以上人工审核，模拟代扣成功
		if (request.getTradeAmount().getCent() <= 5000) {
			String number = OID.newID();
			response.setBizNo(number);
			//发送异步通知
			CommonFastTradeNotify fastTradeNotify=new CommonFastTradeNotify();
			fastTradeNotify.setBizNo(number);
			fastTradeNotify.setOutOrderNo(request.getOutOrderNo());
			fastTradeNotify.setTradeAmount(request.getTradeAmount().toString());
			fastTradeNotify.setBuyerChargeAmount(null);
			fastTradeNotify.setSellerChargeAmount(null);
			fastTradeNotify.setMerchantChargeAmount("1.00");
			fastTradeNotify.setStatus(Status.SUCCESS.getCode());
			asyncNotifier.asyncNotify(request, fastTradeNotify);
			
		}
		else if (request.getTradeAmount().getCent() < 10000 && request.getTradeAmount().getCent() > 5000) {
			String number = OID.newID();
			response.setBizNo(number);
			//发送异步通知
			CommonFastTradeNotify fastTradeNotify=new CommonFastTradeNotify();
			fastTradeNotify.setBizNo(number);
			fastTradeNotify.setOutOrderNo(request.getOutOrderNo());
			fastTradeNotify.setTradeAmount(request.getTradeAmount().toString());
			fastTradeNotify.setBuyerChargeAmount(null);
			fastTradeNotify.setSellerChargeAmount(null);
			fastTradeNotify.setMerchantChargeAmount("1.00");
			fastTradeNotify.setStatus(Status.FAIL.getCode());
			fastTradeNotify.setResultCode("BK20011");
			fastTradeNotify.setResultMessage("银行卡未开通认证支付");
			asyncNotifier.asyncNotify(request, fastTradeNotify);
		}
		else if (request.getTradeAmount().getCent() < 15000 && request.getTradeAmount().getCent() >= 10000) {
			String number = OID.newID();
			response.setBizNo(number);
			//发送异步通知
			CommonFastTradeNotify fastTradeNotify=new CommonFastTradeNotify();
			fastTradeNotify.setBizNo(number);
			fastTradeNotify.setOutOrderNo(request.getOutOrderNo());
			fastTradeNotify.setTradeAmount(request.getTradeAmount().toString());
			fastTradeNotify.setBuyerChargeAmount(null);
			fastTradeNotify.setSellerChargeAmount(null);
			fastTradeNotify.setMerchantChargeAmount("1.00");
			fastTradeNotify.setStatus(Status.FAIL.getCode());
			fastTradeNotify.setResultCode("BK20012");
			fastTradeNotify.setResultMessage("代扣失败:余额不足");
			asyncNotifier.asyncNotify(request, fastTradeNotify);
		} 
		else if(request.getTradeAmount().getCent() == 30000){
			String number = OID.newID();
			response.setBizNo(number);
			
		}else if(request.getTradeAmount().getCent() == 40000){
			//模拟调openapi超时
			String number = OID.newID();
			response.setBizNo(number);
			response.setResultCode("TIME_OUT");
			response.setResultMessage("调openapi超时");
		}
		
		else if(request.getTradeAmount().getCent() == 50000){
			try {
				Thread.sleep(72000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		else if(request.getTradeAmount().getCent() == 60000){
				
			String number = OID.newID();
			response.setBizNo(number);
			//发送异步通知
			CommonFastTradeNotify fastTradeNotify=new CommonFastTradeNotify();
			fastTradeNotify.setBizNo(number);
			fastTradeNotify.setOutOrderNo(request.getOutOrderNo());
			fastTradeNotify.setTradeAmount(request.getTradeAmount().toString());
			fastTradeNotify.setBuyerChargeAmount(null);
			fastTradeNotify.setSellerChargeAmount(null);
			fastTradeNotify.setMerchantChargeAmount("1.00");
			fastTradeNotify.setStatus(Status.FAIL.getCode());
			fastTradeNotify.setResultCode("invalidCard");
			fastTradeNotify.setResultMessage("代扣失败:卡无效");
			asyncNotifier.asyncNotify(request, fastTradeNotify);
			
		}
		else if(request.getTradeAmount().getCent() >= 15000 && request.getTradeAmount().getCent() < 30000){
			String number = OID.newID();
			response.setBizNo(number);
			//发送异步通知
			CommonFastTradeNotify fastTradeNotify=new CommonFastTradeNotify();
			fastTradeNotify.setBizNo(number);
			fastTradeNotify.setOutOrderNo(request.getOutOrderNo());
			fastTradeNotify.setTradeAmount(request.getTradeAmount().toString());
			fastTradeNotify.setBuyerChargeAmount(null);
			fastTradeNotify.setSellerChargeAmount(null);
			fastTradeNotify.setMerchantChargeAmount("1.00");
			fastTradeNotify.setStatus(Status.FAIL.getCode());
			fastTradeNotify.setResultCode("BK20013");
			fastTradeNotify.setResultMessage("代扣失败");
			asyncNotifier.asyncNotify(request, fastTradeNotify);
		}
		else {
			String number = OID.newID();
			response.setBizNo(number);
			//发送异步通知
			CommonFastTradeNotify fastTradeNotify=new CommonFastTradeNotify();
			fastTradeNotify.setBizNo(number);
			fastTradeNotify.setOutOrderNo(request.getOutOrderNo());
			fastTradeNotify.setTradeAmount(request.getTradeAmount().toString());
			fastTradeNotify.setBuyerChargeAmount(null);
			fastTradeNotify.setSellerChargeAmount(null);
			fastTradeNotify.setMerchantChargeAmount("1.00");
			fastTradeNotify.setStatus(Status.SUCCESS.getCode());
			asyncNotifier.asyncNotify(request, fastTradeNotify);
		}
	}
	
	@Override
	public ApiNotify getApiNotifyBean() {
		
		return new CommonFastTradeNotify();
	}
	
}

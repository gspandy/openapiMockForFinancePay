package com.yiji.openapimock.service.bankCardBinQuery;

import com.yiji.openapi.arch.exception.ApiServiceException;
import com.yiji.openapi.arch.meta.OpenApiService;
import com.yiji.openapi.arch.service.base.BaseApiService;
import com.yiji.openapi.arch.service.enums.ResponseType;

@OpenApiService(name = "bankCardBinQuery", desc = "查询银行卡BIN", version = "1.0", responseType = ResponseType.SYN)
public class BankCardBINQueryApiService extends BaseApiService<BankCardBINQueryRequest, BankCardBINQueryResponse> {
	
	@Override
	protected void doService(BankCardBINQueryRequest request, BankCardBINQueryResponse response) {
		String bankCardNo=request.getBankCardNo();
		
		if (bankCardNo.startsWith("555555")) {
			throw new ApiServiceException("UNSUPPORTED_BANK_TYPE", "暂不支持的银行卡类型");
		}else if(bankCardNo.startsWith("666666")){
			throw new ApiServiceException("UNSUPPORTED_BANK_TYPE", "暂不支持的银行卡类型");
		}else if(bankCardNo.startsWith("621098")){
			response.setBankId("PSBC");
			response.setBankName("邮政储蓄银行");
			response.setBankCardName("借记卡");
		}else if(bankCardNo.startsWith("622150")){
			response.setBankId("PSBC");
			response.setBankName("邮政储蓄银行");
			response.setBankCardName("借记卡");
			response.setBankCardTypeCode("DEBIT");
			response.setBankCardTypeName("绿卡银联标准卡");
		}else if(bankCardNo.startsWith("622261")){
			response.setBankId("COMM");
			response.setBankName("交通银行");
			response.setBankCardName("借记卡");
			response.setBankCardTypeCode("DEBIT");
			response.setBankCardTypeName("太平洋DEBIT");
		}else if(bankCardNo.startsWith("621660")){
			response.setBankId("BOC");
			response.setBankName("中国银行");
			response.setBankCardName("借记卡");
			response.setBankCardTypeCode("DEBIT");
			response.setBankCardTypeName("联名卡");
		}else if(bankCardNo.startsWith("621081")){
			response.setBankId("CCB");
			response.setBankName("建设银行");
			response.setBankCardName("借记卡");
			response.setBankCardTypeCode("DEBIT");
			response.setBankCardTypeName("金融IC卡");
		}else{
			response.setBankId("ICBC");
			response.setBankName("中国工商银行");
			response.setBankCardName("借记卡");
			response.setBankCardTypeCode("DEBIT");
			response.setBankCardTypeName("E时代卡");
		}
	}
	
}

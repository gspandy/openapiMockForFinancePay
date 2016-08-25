package com.yiji.openapimock.service.commonTransfersInterface;

import org.apache.commons.lang3.StringUtils;
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
import com.yjf.common.lang.result.Status;
import com.yjf.common.lang.util.money.Money;

@OpenApiService(name = "commonTransfersInterface", desc = "通用转账", responseType = ResponseType.ASNY)
public class CommonTransfersInterfaceApiService
												extends
												BaseApiService<CommonTransfersInterfaceRequest, CommonTransfersInterfaceResponse> {
	
	@Autowired
	private AsyncNotifier asyncNotifier;
	
	@Override
	protected void doService(CommonTransfersInterfaceRequest request, CommonTransfersInterfaceResponse response) {
		
		// 转账到易极付账户，同步返回
		// 621105123456789000  转账到卡，异步返回
		//621105123456789002   转账到卡,异步返回成功
		//621105123456789001  转账到卡,异步返回失败
		//621105123456789022 转账到卡，返回超时
		//4367423761580233333 企业账户，转账到卡，异步成功
		//4367423761580244444 企业账户，转账到卡，异步失败
		//userId=20141202020000060319,模拟转账失败
		//sellerUserId=20141202020000060310,模拟转账超时
		//转账金额为700块钱时，模拟转账超时
		//转账金额为5块手续费时，模拟转账超时
		//转账手续费金额为2块钱时，模拟转账失败
	   if(request.getTransferBankOrder()!=null && request.getTransferBankOrder().getBankAccountNo().equals("621105123456789002")){
		   String number = OID.newID();
		   response.setBizNo(number);
			response.setStatus(Status.SUCCESS);
			//发送异步通知
			try {
				Thread.sleep(6000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			CommonTransfersInterfaceNotify commonTransferNotify=new CommonTransfersInterfaceNotify();
			
			commonTransferNotify.setBizNo(number);
			commonTransferNotify.setAmount(request.getAmount());
			commonTransferNotify.setMemo(request.getMemo());
			asyncNotifier.asyncNotify(request, commonTransferNotify);
			
		}
	   else if(request.getTransferBankOrder()!=null && request.getTransferBankOrder().getBankAccountNo().equals("4367423761580233333")){
		   String number = OID.newID();
		   response.setBizNo(number);
			response.setStatus(Status.SUCCESS);
			//发送异步通知
			try {
				Thread.sleep(6000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			CommonTransfersInterfaceNotify commonTransferNotify=new CommonTransfersInterfaceNotify();
			
			commonTransferNotify.setBizNo(number);
			commonTransferNotify.setAmount(request.getAmount());
			commonTransferNotify.setMemo(request.getMemo());
			asyncNotifier.asyncNotify(request, commonTransferNotify);
			
		}
	   else if(request.getTransferBankOrder()!=null && request.getTransferBankOrder().getBankAccountNo().equals("621105123456789001")){
		   String number = OID.newID();
		   response.setBizNo(number);
			response.setStatus(Status.SUCCESS);
			//发送异步通知
			try {
				Thread.sleep(6000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//发送异步通知
			CommonTransfersInterfaceNotify commonTransferNotify=new CommonTransfersInterfaceNotify();
			commonTransferNotify.setResultCode("FAIL");
			commonTransferNotify.setBizNo(number);
			commonTransferNotify.setAmount(request.getAmount());
			commonTransferNotify.setMemo(request.getMemo());
			asyncNotifier.asyncNotify(request, commonTransferNotify);
	   }
	   else if(request.getTransferBankOrder()!=null && request.getTransferBankOrder().getBankAccountNo().equals("4367423761580244444")){
		   String number = OID.newID();
		   response.setBizNo(number);
			response.setStatus(Status.SUCCESS);
			//发送异步通知
			try {
				Thread.sleep(6000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//发送异步通知
			CommonTransfersInterfaceNotify commonTransferNotify=new CommonTransfersInterfaceNotify();
			commonTransferNotify.setResultCode("FAIL");
			commonTransferNotify.setBizNo(number);
			commonTransferNotify.setAmount(request.getAmount());
			commonTransferNotify.setMemo(request.getMemo());
			asyncNotifier.asyncNotify(request, commonTransferNotify);
	   }
	   else if(request.getTransferBankOrder()!=null && request.getTransferBankOrder().getBankAccountNo().equals("621105123456789022")){
		  //转账到卡，模拟超时
		   String number = OID.newID();
		   response.setBizNo(number);
		   response.setResultCode("TIME_OUT");
		   response.setResultMessage("通用转账到卡超时");
		   response.setStatus(Status.FAIL);
		   
	   }
	   else if (request.getUserId().equals("20141202020000060319")){
		   //模拟转账失败
		   throw new ApiServiceUniformCodeException("BK0020",
					ApiServiceBusinessResultCode.EXECUTE_FAIL.getResultCode(), "转账失败");
	   }
	   
	   else if(request.getAmount().equals(new Money(700))){
		    String number = OID.newID();
			response.setBizNo(number);
			response.setResultCode("TIME_OUT");
			response.setResultMessage("通用转账超时");
			response.setStatus(Status.FAIL);
	   }
	   else if(request.getAmount().equals(new Money(5))){
		   String number = OID.newID();
			response.setBizNo(number);
			response.setResultCode("TIME_OUT");
			response.setResultMessage("通用转账超时");
			response.setStatus(Status.FAIL);
	   }
	   else if(request.getAmount().equals(new Money(2))){
		   //模拟转账失败
		   throw new ApiServiceUniformCodeException("BK0022",
					ApiServiceBusinessResultCode.EXECUTE_FAIL.getResultCode(), "余额不足，转账失败");
	   }
	   
	   else if(StringUtils.equals(request.getSellerUserId(), "20141202020000060310")){
		   //sellerUserId=20141202020000060310,模拟转账超时
		    String number = OID.newID();
			response.setBizNo(number);
			response.setResultCode("TIME_OUT");
			response.setResultMessage("转账超时");
			response.setStatus(Status.FAIL);
	   }
	  
	   else {
			response.setBizNo(OID.newID());	
			response.setStatus(Status.SUCCESS);	
		
		}
	}
	@Override
	public ApiNotify getApiNotifyBean() {	
	return new CommonTransfersInterfaceNotify();
	
	}
	
}

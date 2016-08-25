/*
 * www.yiji.com Inc.
 * Copyright (c) 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * husheng@yiji.com 2016-04-30 17:05 创建
 *
 */
package com.yjf.customer.service.api.query.merchant;

import java.util.List;

import com.google.common.collect.Lists;
import com.yjf.customer.service.result.merchant.MerchantInfoResult;

/**
 * @author husheng@yiji.com
 */
public class MerchantQueryServiceImpl implements MerchantQueryService {
	
	public static final List<String> merchantInfo = Lists.newArrayList("20150409922615030001","20150409922615030002","20150409922615030003","20150409922615030004","20150409922615030005");
	
	@Override
	public MerchantInfoResult findMerchantInfoByCardNo(String partnerId) {
		
		if (partnerId.equals("20160309020000710221")) {
			return new MerchantInfoResult(true, "c9cef22553af973d4b04a012f9cb8ea8");
		}
		
		if(merchantInfo.contains(partnerId)){
			return new MerchantInfoResult(true, "5a9cd27cb3128f198f9f25a369d50bc26e437a3e");
		}
		
		
		return new MerchantInfoResult(false, "");
	}
}

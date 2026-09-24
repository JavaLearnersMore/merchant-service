package com.example.service;

import com.example.dto.MerchantResponse;

public interface SuspendMerchantService {

	MerchantResponse getAllMerchant(long merchantId);

	MerchantResponse suspendMerchant(long merchantId);

}

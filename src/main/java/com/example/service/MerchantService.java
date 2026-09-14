package com.example.service;

import com.example.dto.MerchantRegisterRequest;
import com.example.dto.MerchantResponse;

public interface MerchantService {

	MerchantResponse registerMerchant(MerchantRegisterRequest request);

}

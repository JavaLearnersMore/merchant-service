package com.example.service;

import com.example.dto.KycApprovedResponse;
import com.example.dto.KycRequest;
import com.example.dto.KycResponse;

public interface AdminKycService {

	KycResponse updateKycStatus(Long merchantId, KycRequest request);

	KycApprovedResponse approveMerchant(Long merchantId);

	KycApprovedResponse updateMerchantStatus(Long merchantId, String status);

}

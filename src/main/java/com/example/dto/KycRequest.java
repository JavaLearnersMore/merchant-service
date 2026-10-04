package com.example.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class KycRequest {
	
    @NotNull(message = "Merchant ID is required")
    @Positive(message = "Merchant ID must be greater than 0")
    private Long merchantId;


	@NotBlank(message = "KYC status is required")
    @Size(min = 3, max = 20, message = "KYC status must be between 3 and 20 characters")
    private String kycStatus;

    @NotBlank(message = "Remarks are required")
    @Size(min = 3, max = 200, message = "Remarks must be between 3 and 200 characters")
    private String remarks;
    
    
    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }
    
    
    public String getKycStatus() {
        return kycStatus;
    }

    public void setKycStatus(String kycStatus) {
        this.kycStatus = kycStatus;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}

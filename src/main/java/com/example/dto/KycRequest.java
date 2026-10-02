package com.example.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class KycRequest {

	@NotBlank(message = "KYC status is required")
    @Size(min = 3, max = 20, message = "KYC status must be between 3 and 20 characters")
    private String kycStatus;

    @NotBlank(message = "Remarks are required")
    @Size(min = 3, max = 200, message = "Remarks must be between 3 and 200 characters")
    private String remarks;
    
    
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

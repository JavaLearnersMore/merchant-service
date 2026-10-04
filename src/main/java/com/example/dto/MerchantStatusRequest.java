package com.example.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

public class MerchantStatusRequest {
	
	
	@NotNull(message = "Merchant ID is required")
    @Positive(message = "Merchant ID must be greater than 0")
    private Long merchantId;

    @NotBlank(message = "Status is required")
    @Pattern(
        regexp = "ACTIVE|INACTIVE",
        message = "Status must be ACTIVE or INACTIVE"
    )
    private String status;


    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}

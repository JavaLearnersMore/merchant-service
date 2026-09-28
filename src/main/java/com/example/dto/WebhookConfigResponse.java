package com.example.dto;

public class WebhookConfigResponse {

    private Long merchantId;
    private String url;
    private Boolean active;
    private String message;

    public WebhookConfigResponse(
            Long merchantId,
            String url,
            Boolean active,
            String message) {

        this.merchantId = merchantId;
        this.url = url;
        this.active = active;
        this.message = message;
    }

    public Long getMerchantId() {
        return merchantId;
    }

    public String getUrl() {
        return url;
    }

    public Boolean getActive() {
        return active;
    }

    public String getMessage() {
        return message;
    }
}
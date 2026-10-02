package com.example.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class WebhookConfigRequest {

	 @NotBlank(message = "Webhook URL is required")
	    @Pattern(
	        regexp = "^https://.*",
	        message = "Webhook URL must start with https://"
	    )
	    private String url;

	    @NotNull(message = "Active status is required")
	    private Boolean active;
	    
	    
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
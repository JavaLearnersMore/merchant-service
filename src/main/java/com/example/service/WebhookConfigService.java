package com.example.service;

import com.example.dto.WebhookConfigRequest;
import com.example.dto.WebhookConfigResponse;

public interface WebhookConfigService {

	WebhookConfigResponse saveOrUpdate(Long merchantId, WebhookConfigRequest request);

}

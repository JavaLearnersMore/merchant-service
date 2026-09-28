package com.example.dao;

import com.example.model.WebhookConfig;

public interface WebhookConfigDao {

	void update(WebhookConfig webhookConfig);

	void save(WebhookConfig webhookConfig);

	WebhookConfig findByMerchantId(Long merchantId);

}

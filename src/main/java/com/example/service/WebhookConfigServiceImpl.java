package com.example.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.WebhookConfigDao;
import com.example.dto.WebhookConfigRequest;
import com.example.dto.WebhookConfigResponse;
import com.example.model.WebhookConfig;

@Service
public class WebhookConfigServiceImpl implements WebhookConfigService {

    private final WebhookConfigDao webhookConfigDao;

    public WebhookConfigServiceImpl(
            WebhookConfigDao webhookConfigDao) {

        this.webhookConfigDao = webhookConfigDao;
    }

    @Override
    @Transactional
    public WebhookConfigResponse saveOrUpdate(Long merchantId,WebhookConfigRequest request) {

        // 1. Validate merchant ID
        if (merchantId == null) {
            throw new RuntimeException("Merchant ID is required");
        }

        // 2. Validate request
        if (request == null ||
                request.getUrl() == null ||
                request.getUrl().trim().isEmpty()) {

            throw new RuntimeException("Callback URL is required");
        }

        String url = request.getUrl().trim();

        // 3. Check whether merchant already has webhook config
        WebhookConfig existingConfig =webhookConfigDao.findByMerchantId(merchantId);

        // 4. First time configuration
        if (existingConfig == null) {

            WebhookConfig config =new WebhookConfig();

            config.setMerchantId(merchantId);
            config.setUrl(url);

            // Local development secret
            config.setSecret("devsecret" + merchantId);

            if (request.getActive() != null) {
                config.setActive(request.getActive());
            } else {
                config.setActive(true);
            }

            // INSERT
            webhookConfigDao.save(config);

            return new WebhookConfigResponse(
                    config.getMerchantId(),
                    config.getUrl(),
                    config.isActive(),
                    "Webhook configuration saved successfully"
            );
        }

        // 5. Existing configuration
        existingConfig.setUrl(url);

        if (request.getActive() != null) {
            existingConfig.setActive(
                    request.getActive());
        }

        // UPDATE
        webhookConfigDao.update(existingConfig);

        return new WebhookConfigResponse(
                existingConfig.getMerchantId(),
                existingConfig.getUrl(),
                existingConfig.isActive(),
                "Webhook configuration updated successfully"
        );
    }
}
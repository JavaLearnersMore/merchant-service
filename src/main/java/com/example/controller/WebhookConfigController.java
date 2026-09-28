package com.example.controller;

import javax.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.dto.WebhookConfigRequest;
import com.example.dto.WebhookConfigResponse;
import com.example.service.WebhookConfigService;

@RestController
@RequestMapping("/api/v1/webhook-config")
public class WebhookConfigController {

    private final WebhookConfigService webhookConfigService;

    public WebhookConfigController(
            WebhookConfigService webhookConfigService) {

        this.webhookConfigService = webhookConfigService;
    }

    @PutMapping
    public ResponseEntity<?> updateWebhookConfig(
            @RequestBody WebhookConfigRequest request,
            HttpSession session) {

        try {
            Object merchantIdObject = session.getAttribute("merchantId");

            if (merchantIdObject == null) {
                return ResponseEntity.badRequest().body("Please login as merchant first.");
            }

            Long merchantId = Long.valueOf(merchantIdObject.toString());

            WebhookConfigResponse response =webhookConfigService.saveOrUpdate(merchantId, request);

            return ResponseEntity.ok(response);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
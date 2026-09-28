package com.example.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.dto.WebhookConfigRequest;
import com.example.dto.WebhookConfigResponse;
import com.example.service.WebhookConfigService;

@Controller
@RequestMapping("/merchant")
public class MerchantWebhookUiController {

    private final WebhookConfigService webhookConfigService;

    public MerchantWebhookUiController(
            WebhookConfigService webhookConfigService) {

        this.webhookConfigService = webhookConfigService;
    }

    @PostMapping("/ui-webhook-config")
    public String saveWebhookConfig(
            @RequestParam("url") String url,
            Model model,
            HttpSession session) {

        try {

            Object merchantIdObject =session.getAttribute("merchantId");

            if (merchantIdObject == null) {

                model.addAttribute("webhookError","Please login as merchant first.");

                return "registration";
            }

            Long merchantId =Long.valueOf(merchantIdObject.toString());

            WebhookConfigRequest request = new WebhookConfigRequest();

            request.setUrl(url);
            request.setActive(true);

            WebhookConfigResponse response =webhookConfigService.saveOrUpdate( merchantId,request);

            model.addAttribute("webhookResponse",response);

        } catch (Exception e) {

            model.addAttribute("webhookError",e.getMessage());
        }

        return "registration";
    }
}
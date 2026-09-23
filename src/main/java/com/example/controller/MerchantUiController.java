package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.dto.MerchantRegisterRequest;
import com.example.dto.MerchantResponse;
import com.example.service.MerchantService;

@Controller
@RequestMapping("/api/v1/merchants")
public class MerchantUiController {

    private final MerchantService merchantService;

    public MerchantUiController( MerchantService merchantService) {
        this.merchantService = merchantService;
    }

    @PostMapping("/ui-register")
    public String registerFromUi(
            @RequestParam String legalName,
            @RequestParam String email,
            @RequestParam String phone,
            @RequestParam String panNumber,
            @RequestParam String gstNumber,
            @RequestParam String settlementAccountId,
            @RequestParam String adminUsername,
            @RequestParam String adminPassword,
            @RequestParam String role,
            Model model) {

        MerchantRegisterRequest request =new MerchantRegisterRequest();
        request.setLegalName(legalName);
        request.setEmail(email);
        request.setPhone(phone);
        request.setPanNumber(panNumber);
        request.setGstNumber(gstNumber);
        request.setSettlementAccountId(settlementAccountId);
        request.setAdminUsername(adminUsername);
        request.setAdminPassword(adminPassword);
        request.setRole(role);
        
        System.out.println("Selected Role = " + role);
        System.out.println("Request Role = " + request.getRole());

        // Register merchant
        MerchantResponse response =merchantService.registerMerchant(request);

        // Send response to JSP
        model.addAttribute("registrationResponse", response);

        // Stay on same JSP
        return "registration";
    }
}
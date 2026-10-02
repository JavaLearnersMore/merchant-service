package com.example.controller;

import javax.validation.Valid;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
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
            @Valid @ModelAttribute("merchantRegisterRequest") MerchantRegisterRequest request,
            BindingResult result,
            Model model) {

        // ==========================================
        // 1. Check validation errors
        // ==========================================
        if (result.hasErrors()) {

            result.getFieldErrors().forEach(error -> {
                System.out.println(
                    error.getField() + " = " + error.getDefaultMessage()
                );
            });

            return "registration";
        }

        
        try {

            MerchantResponse response =merchantService.registerMerchant(request);

            // SUCCESS
            model.addAttribute("registrationResponse", response);

        } catch (DuplicateKeyException e) {

            // DUPLICATE DATABASE ERROR
            model.addAttribute(
                "registrationError",
                "Email already exists. Please use a different email."
            );

            System.out.println(
                "Duplicate merchant registration: " + e.getMessage()
            );
        }


        // Stay on same JSP
        return "registration";
    }
}
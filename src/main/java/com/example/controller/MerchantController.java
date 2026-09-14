package com.example.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.MerchantRegisterRequest;
import com.example.dto.MerchantResponse;
import com.example.service.MerchantService;

@RestController
@RequestMapping("/api/v1/merchants")
public class MerchantController {

    private final MerchantService merchantService;

    public MerchantController(MerchantService merchantService) {
        this.merchantService = merchantService;
    }

    //register API
    @PostMapping("/register")
    public ResponseEntity<MerchantResponse> registerMerchant(
            @RequestBody MerchantRegisterRequest request) {

        MerchantResponse response = merchantService.registerMerchant(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}

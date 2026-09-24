package com.example.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.dto.MerchantResponse;
import com.example.service.SuspendMerchantService;


@Controller
@RequestMapping("/api/v1/admin/")
public class SuspendMerchantController {

	@Autowired
	private final SuspendMerchantService suspendMerchantService;
	
	public SuspendMerchantController(SuspendMerchantService suspendMerchantService) {
		this.suspendMerchantService=suspendMerchantService;
	}
	
	
	// =========================
    // API - GET MERCHANT
    // =========================

    @GetMapping("/Getmerchant/{merchantId}")
    @ResponseBody
    public ResponseEntity<MerchantResponse> getMerchant(
            @PathVariable long merchantId) {

        MerchantResponse response =suspendMerchantService.getAllMerchant(merchantId);
        return ResponseEntity.ok(response);
    }


    
    // API - SUSPEND MERCHANT
   
    @PostMapping("/SuspendMerchant/{merchantId}")
    @ResponseBody
    public ResponseEntity<MerchantResponse> suspendMerchant(
            @PathVariable long merchantId) {

        MerchantResponse response =suspendMerchantService.suspendMerchant(merchantId);
        return ResponseEntity.ok(response);
    }


    
    // UI - GET MERCHANT

    @GetMapping("/merchants/ui-get")
    public String getMerchantFromUi(
            @RequestParam long merchantId,
            Model model,
            HttpSession session) {

        try {

            MerchantResponse response =suspendMerchantService.getAllMerchant(merchantId);
            model.addAttribute("merchantResponse", response);

        } catch (Exception e) {
            model.addAttribute("merchantError",e.getMessage());
        }

        return "registration";
    }


    
    // UI - SUSPEND MERCHANT

    @PostMapping("/merchants/ui-suspend")
    public String suspendMerchantFromUi(
            @RequestParam long merchantId,
            Model model,
            HttpSession session) {

        try {

            MerchantResponse response = suspendMerchantService.suspendMerchant(merchantId);

            model.addAttribute("suspendResponse",response);

        } catch (Exception e) {

            model.addAttribute("suspendError",e.getMessage());
        }

        return "registration";
    }
}
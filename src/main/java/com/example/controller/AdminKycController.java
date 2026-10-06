package com.example.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.KycApprovedResponse;
import com.example.dto.KycRequest;
import com.example.dto.KycResponse;
import com.example.dto.MerchantRegisterRequest;
import com.example.dto.MerchantResponse;
import com.example.dto.MerchantStatusRequest;
import com.example.service.AdminKycService;
import com.example.service.AdminKycServiceImpl;

@RestController
@RequestMapping("/api/v1/admin/merchants")
public class AdminKycController {
	
	private final AdminKycService adminKycService;
	
	public AdminKycController(AdminKycServiceImpl adminKycServiceImpl) {
		this.adminKycService=adminKycServiceImpl;
	}
	
	
//	@PutMapping("{merchantId}/kyc")
//	@ResponseBody
//	public ResponseEntity<KycResponse> updateKyc(@RequestBody KycRequest request,
//			 @Valid @PathVariable long merchantId,
//			Model model){
//		
//	KycResponse response=adminKycService.updateKycStatus(merchantId,request);		
//	return ResponseEntity.ok(response);
//	}
	
	@PutMapping("/kyc")
	public ResponseEntity<KycResponse> updateKyc(@RequestBody KycRequest request){
		System.out.println("Inside kyc updateKyc");
	KycResponse response=adminKycService.updateKycStatus(request);		
	return ResponseEntity.ok(response);
	}
	
	
	@PostMapping("/ui-kyc")
	public String updateKycFromUi(
	        @RequestParam Long merchantId,
	        @Valid @ModelAttribute("kycRequest") KycRequest request,
	        BindingResult result,
	        Model model) {
		
		if (result.hasErrors()) {
	        return "registration";
	    }

        try {
            KycResponse response =
                    adminKycService.updateKycStatus(request);

            model.addAttribute("kycResponse", response);

        } catch (Exception e) {
            model.addAttribute("kycError", e.getMessage());
        }

        return "registration";
    }
	
	//merchant approve status
	@PutMapping("/{merchantId}/approve")
    @ResponseBody
    public ResponseEntity<KycApprovedResponse> approveMerchant(
            @Valid @PathVariable Long merchantId) {

        KycApprovedResponse response =adminKycService.approveMerchant(merchantId);

        return ResponseEntity.ok(response);
    }
	
	@PostMapping("/ui-approve")
	public String approveMerchantFromUi(
	        @Valid @ModelAttribute("merchantStatusRequest")
	        MerchantStatusRequest request,
	        BindingResult result,
	        Model model) {

	    if (result.hasErrors()) {
	        return "registration";
	    }


        try {
            KycApprovedResponse response =adminKycService.updateMerchantStatus(request.getMerchantId(),request.getStatus());
            model.addAttribute("approveResponse",response);

        } catch (Exception e) {
            model.addAttribute("approveError",e.getMessage());
        }

        return "registration";
    }
}
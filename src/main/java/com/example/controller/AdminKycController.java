package com.example.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.dto.KycApprovedResponse;
import com.example.dto.KycRequest;
import com.example.dto.KycResponse;
import com.example.dto.MerchantRegisterRequest;
import com.example.dto.MerchantResponse;
import com.example.service.AdminKycService;
import com.example.service.AdminKycServiceImpl;

@Controller
@RequestMapping("/api/v1/admin/merchants")
public class AdminKycController {
	
	private final AdminKycService adminKycService;
	
	public AdminKycController(AdminKycServiceImpl adminKycServiceImpl) {
		this.adminKycService=adminKycServiceImpl;
	}
	
	
	@PutMapping("{merchantId}/kyc")
	@ResponseBody
	public ResponseEntity<KycResponse> updateKyc(@RequestBody KycRequest request,
			@PathVariable long merchantId,
			Model model){
		
	KycResponse response=adminKycService.updateKycStatus(merchantId,request);		
	return ResponseEntity.ok(response);
	}
	
	
	@PostMapping("/ui-kyc")
    public String updateKycFromUi(
            @RequestParam Long merchantId,
            @RequestParam String kycStatus,
            @RequestParam String remarks,
            Model model) {

        KycRequest request = new KycRequest();

        request.setKycStatus(kycStatus);
        request.setRemarks(remarks);

        KycResponse response =adminKycService.updateKycStatus(merchantId,request);

        model.addAttribute("kycResponse",response);
        return "registration";
    }
	
	//merchant approve status
	@PutMapping("/{merchantId}/approve")
    @ResponseBody
    public ResponseEntity<KycApprovedResponse> approveMerchant(
            @PathVariable Long merchantId) {

        KycApprovedResponse response =adminKycService.approveMerchant(merchantId);

        return ResponseEntity.ok(response);
    }
	
	@PostMapping("/ui-approve")
    public String approveMerchantFromUi(
            @RequestParam Long merchantId,
            @RequestParam String status,
            Model model) {

        try {
            KycApprovedResponse response =adminKycService.updateMerchantStatus(merchantId,status);
            model.addAttribute("approveResponse",response);

        } catch (Exception e) {
            model.addAttribute("approveError",e.getMessage());
        }

        return "registration";
    }
}
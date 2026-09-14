package com.example.service;

import org.springframework.stereotype.Service;

import com.example.dao.MerchantDao;
import com.example.dto.KycApprovedResponse;
import com.example.dto.KycRequest;
import com.example.dto.KycResponse;
import com.example.model.Merchant;

@Service
public class AdminKycServiceImpl implements AdminKycService{
	
	private final MerchantDao merchantDao;

	public AdminKycServiceImpl(MerchantDao merchantDao) {
        this.merchantDao = merchantDao;       
    }

	public KycResponse updateKycStatus(Long merchantId, KycRequest request) {
		// 1. Merchant find 
        Merchant merchant = merchantDao.findById(merchantId);

        // 2. KYC status update
        merchantDao.UpdatekycStatus(merchantId,request.getKycStatus());

        // 3. Updated merchant 
        Merchant updatedMerchant =merchantDao.findById(merchantId);

        // 4. create Response 
        KycResponse response = new KycResponse();

        response.setId(updatedMerchant.getId());
        response.setLegalName(updatedMerchant.getLegalName());
        response.setEmail(updatedMerchant.getEmail());
        response.setPhone(updatedMerchant.getPhone());
        response.setPanNumber(updatedMerchant.getPanNumber());
        response.setGstNumber(updatedMerchant.getGstNumber());
        response.setKycStatus(updatedMerchant.getKycStatus());
        response.setStatus(updatedMerchant.getStatus());
        
		return response;
	}
	
	
	@Override
    public KycApprovedResponse approveMerchant(Long merchantId) {

        // 1. Find merchant
        Merchant merchant =merchantDao.findById(merchantId);


        // 2. Check KYC status
        if (!"APPROVED".equalsIgnoreCase(
                merchant.getKycStatus())) {

            throw new IllegalStateException(
                "Merchant KYC is not APPROVED"
            );
        }


        // 3. Approve merchant
        // API contract says approved merchant becomes ACTIVE
        merchantDao.UpdateStatus(merchantId,"ACTIVE");

        // 4. Get updated merchant
        Merchant updatedMerchant =merchantDao.findById(merchantId);

        // 5. Create response
        KycApprovedResponse response =new KycApprovedResponse();

        response.setId(updatedMerchant.getId());
        response.setLegalName(updatedMerchant.getLegalName());
        response.setEmail(updatedMerchant.getEmail());
        response.setPhone(updatedMerchant.getPhone());
        response.setPanNumber(updatedMerchant.getPanNumber());
        response.setGstNumber(updatedMerchant.getGstNumber());
        response.setKycStatus(updatedMerchant.getKycStatus());
        response.setStatus(updatedMerchant.getStatus());
        return response;
    }


    // ==============================
    // UI STATUS UPDATE
    // ==============================

    @Override
    public KycApprovedResponse updateMerchantStatus(Long merchantId,String status) {

        // 1. Find merchant
        Merchant merchant =merchantDao.findById(merchantId);

        // 2. Status validation
        if (!"ACTIVE".equalsIgnoreCase(status)
                && !"INACTIVE".equalsIgnoreCase(status)) {

            throw new IllegalArgumentException(
                "Status must be ACTIVE or INACTIVE"
            );
        }

        // 3. Update status
        merchantDao.UpdateStatus(merchantId,status.toUpperCase());

        // 4. Get updated merchant
        Merchant updatedMerchant =merchantDao.findById(merchantId);

        // 5. Create response
        KycApprovedResponse response =new KycApprovedResponse();

        response.setId(updatedMerchant.getId());
        response.setLegalName(updatedMerchant.getLegalName());
        response.setEmail(updatedMerchant.getEmail());
        response.setPhone(updatedMerchant.getPhone());
        response.setPanNumber(updatedMerchant.getPanNumber());
        response.setGstNumber(updatedMerchant.getGstNumber());
        response.setKycStatus(updatedMerchant.getKycStatus());
        response.setStatus(updatedMerchant.getStatus());
        return response;
    }
  
}
	


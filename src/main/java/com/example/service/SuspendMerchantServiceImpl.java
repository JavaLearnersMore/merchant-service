package com.example.service;

import org.springframework.stereotype.Service;

import com.example.dao.MerchantDao;
import com.example.dto.MerchantResponse;
import com.example.exception.ApiException;
import com.example.model.Merchant;

@Service
public class SuspendMerchantServiceImpl implements SuspendMerchantService{

	private final MerchantDao merchantDao;

	public SuspendMerchantServiceImpl(MerchantDao merchantDao) {
        this.merchantDao = merchantDao;       
    }
	
	
    // GET MERCHANT
   
	@Override
	public MerchantResponse getAllMerchant(long merchantId) {

	    Merchant merchant = merchantDao.findById(merchantId);

	    if (merchant == null) {
	        throw new ApiException(
	        		404,
	                "Merchant not found with ID: " + merchantId
	        );
	    }

	    MerchantResponse response = new MerchantResponse();

	    response.setId(merchant.getId());
	    response.setLegalName(merchant.getLegalName());
	    response.setEmail(merchant.getEmail());
	    response.setPhone(merchant.getPhone());
	    response.setPanNumber(merchant.getPanNumber());
	    response.setGstNumber(merchant.getGstNumber());
	    response.setSettlementAccountId(
	            merchant.getSettlementAccountId());
	    response.setKycStatus(merchant.getKycStatus());
	    response.setStatus(merchant.getStatus());

	    return response;
	}


    
    // SUSPEND MERCHANT
    
	@Override
	public MerchantResponse suspendMerchant(long merchantId) {

	    Merchant merchant = merchantDao.findById(merchantId);

	    if (merchant == null) {
	        throw new ApiException(
	        		404,
	                "Merchant not found with ID: " + merchantId
	        );
	    }

	    if ("SUSPENDED".equalsIgnoreCase(merchant.getStatus())) {
	        throw new ApiException(
	        		409,
	                "Merchant is already suspended"
	        );
	    }

	    merchantDao.UpdateStatus(merchantId, "SUSPENDED");

	    Merchant updatedMerchant = merchantDao.findById(merchantId);

	    MerchantResponse response = new MerchantResponse();

	    response.setId(updatedMerchant.getId());
	    response.setLegalName(updatedMerchant.getLegalName());
	    response.setEmail(updatedMerchant.getEmail());
	    response.setPhone(updatedMerchant.getPhone());
	    response.setPanNumber(updatedMerchant.getPanNumber());
	    response.setGstNumber(updatedMerchant.getGstNumber());
	    response.setSettlementAccountId(
	            updatedMerchant.getSettlementAccountId());
	    response.setKycStatus(updatedMerchant.getKycStatus());
	    response.setStatus(updatedMerchant.getStatus());

	    return response;
	}
}
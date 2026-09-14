package com.example.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.MerchantDao;
import com.example.dto.MerchantRegisterRequest;
import com.example.dto.MerchantResponse;
import com.example.model.Merchant;
import com.example.model.MerchantUser;

@Service
public class MerchantServiceImpl implements MerchantService {

    private final MerchantDao merchantDao;
    private final PasswordEncoder passwordEncoder;

    public MerchantServiceImpl(MerchantDao merchantDao,PasswordEncoder passwordEncoder) {
        this.merchantDao = merchantDao;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public MerchantResponse registerMerchant(MerchantRegisterRequest request) {

        // 1. Create Merchant

        Merchant merchant = new Merchant();
        merchant.setLegalName(request.getLegalName());
        merchant.setEmail(request.getEmail());
        merchant.setPhone(request.getPhone());
        merchant.setPanNumber(request.getPanNumber());
        merchant.setGstNumber(request.getGstNumber());
        merchant.setSettlementAccountId(request.getSettlementAccountId());
        merchant.setKycStatus("PENDING");
        merchant.setStatus("INACTIVE");

        // 2. Save merchant

        Long merchantId = merchantDao.saveMerchant(merchant);

        // 3. Create ADMIN user

        MerchantUser user = new MerchantUser();
        user.setMerchantId(merchantId);
        user.setUsername(request.getAdminUsername());

        // NEVER store plain password
        user.setPasswordHash( passwordEncoder.encode( request.getAdminPassword()));
        user.setRole("ADMIN");
        user.setActive(true);

        // 4. Save ADMIN user
        merchantDao.saveMerchantUser(user);

        // 5. Get saved merchant
        Merchant savedMerchant =merchantDao.findById(merchantId);

        // 6. Convert to response
        return convertToResponse(savedMerchant);
    }

    private MerchantResponse convertToResponse(Merchant merchant) {

        MerchantResponse response = new MerchantResponse();
        response.setId(merchant.getId());
        response.setLegalName(merchant.getLegalName());
        response.setEmail(merchant.getEmail());
        response.setPhone(merchant.getPhone());
        response.setPanNumber(merchant.getPanNumber());
        response.setGstNumber(merchant.getGstNumber());
        response.setSettlementAccountId(merchant.getSettlementAccountId());
        response.setKycStatus(merchant.getKycStatus());
        response.setStatus(merchant.getStatus());
        return response;
    }
}
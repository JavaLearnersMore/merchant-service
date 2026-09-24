package com.example.dao;

import com.example.model.Merchant;
import com.example.model.MerchantUser;

public interface MerchantDao {

	MerchantUser findUserByUsername(String username);

	Merchant findById(Long id);

	void saveMerchantUser(MerchantUser user);

	Long saveMerchant(Merchant merchant);

	void UpdatekycStatus(long merchantId, String kycStatus);

	void UpdateStatus(long merchantId, String status);

	void deleteMerchant(long merchantId);

	//void updateStatus(long merchantId, String status);

}

package com.example.dao;


import java.util.List;

import com.example.model.Merchant_Order;

public interface MerchantOrderDao {

	void saveOrders(Merchant_Order merchant_order);

	boolean existsByOrderRef(String orderRef);

	Merchant_Order getMerchantOrderRef(String orderRef);

	Long getMerchantIdByUsername(String username);

	List<Merchant_Order> getAllMerchantOrders();

	
	

}

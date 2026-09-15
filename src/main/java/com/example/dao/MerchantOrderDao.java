package com.example.dao;


import com.example.model.Merchant_Order;

public interface MerchantOrderDao {

	void saveOrders(Merchant_Order merchant_order);

	boolean existsByOrderRef(String orderRef);

	
	

}

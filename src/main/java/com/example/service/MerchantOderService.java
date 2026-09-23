package com.example.service;

import java.util.List;

import com.example.dto.OrderRequest;
import com.example.dto.OrderResponse;
import com.example.model.Merchant_Order;

public interface MerchantOderService {

	//OrderResponse createOrders(OrderRequest request);

	OrderResponse createOrders(OrderRequest request, long merchant_id);

	List<Merchant_Order> getMyOrders(long merchant_id);

	OrderResponse getMyOrderByRef(String order_ref);

	

}

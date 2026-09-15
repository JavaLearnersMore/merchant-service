package com.example.service;

import com.example.dto.OrderRequest;
import com.example.dto.OrderResponse;

public interface MerchantOderService {

	//OrderResponse createOrders(OrderRequest request);

	OrderResponse createOrders(OrderRequest request, long merchant_id);

}

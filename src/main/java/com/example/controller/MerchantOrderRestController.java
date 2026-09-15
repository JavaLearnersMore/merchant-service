package com.example.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.OrderRequest;
import com.example.dto.OrderResponse;
import com.example.service.MerchantOderService;

@RestController
@RequestMapping("/api/v1/")
public class MerchantOrderRestController {
	
	private MerchantOderService merchantOrderService;
	
	public MerchantOrderRestController(MerchantOderService merchantOrderService) {
		this.merchantOrderService=merchantOrderService;
	}
	
	@PostMapping("/orders")
	public ResponseEntity<OrderResponse> createMerchantOrder(@RequestBody OrderRequest request){
		
		long merchant_id = 1001L;
		
		OrderResponse response=merchantOrderService.createOrders(request,merchant_id);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

}

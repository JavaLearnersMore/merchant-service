package com.example.service;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.stereotype.Service;
import com.example.dao.MerchantOrderDao;
import com.example.dto.OrderRequest;
import com.example.dto.OrderResponse;
import com.example.model.Merchant_Order;

@Service
public class MerchantOderServiceImpl implements MerchantOderService{
	
	private MerchantOrderDao merchantOrderDao;
	
	
	public MerchantOderServiceImpl(MerchantOrderDao merchantOrderDao) {
		this.merchantOrderDao=merchantOrderDao;
		
	}

	
	@Override
	public OrderResponse createOrders(OrderRequest request,long merchant_id) {
		
		if (merchantOrderDao.existsByOrderRef(
                request.getOrderRef())) {

            throw new RuntimeException(
                    "Order reference already exists: "
                            + request.getOrderRef()
            );
        }
		
		LocalDateTime now = LocalDateTime.now();
		
		
		 Merchant_Order order = new Merchant_Order();

	        order.setId(System.currentTimeMillis());
	        order.setMerchant_id(merchant_id);
	        order.setOrder_ref(request.getOrderRef());
	        order.setAmount(request.getAmount());
	        order.setCurrency(request.getCurrency());
	        order.setStatus("INITIATED");
	        order.setCustomer_email(request.getCustomerEmail());
		
		// Temporary PG values for API testing
        String pgTxnRef = "PGTXN"
                + System.currentTimeMillis()
                + UUID.randomUUID()
                        .toString()
                        .substring(0, 6)
                        .toUpperCase();

        order.setPg_txn_ref(pgTxnRef);
        order.setCreated_at(now);
        order.setUpdated_at(now);
		
		merchantOrderDao.saveOrders(order);
		
		OrderResponse response=new OrderResponse();
		response.setOrderRef(order.getOrder_ref());
		response.setMerchantId(order.getMerchant_id());
		response.setAmount(order.getAmount());
		response.setCurrency(order.getCurrency());
		response.setStatus(order.getStatus());
		response.setPgTxnRef(order.getPg_txn_ref());
		
		response.setCheckoutUrl(
                "/pg/api/v1/authenticate/"
                        + order.getPg_txn_ref());
		
		response.setCreatedAt(order.getCreated_at());
		response.setUpdatedAt(order.getUpdated_at());
		return response;
		
		
		
		
	}
	
	
	
}

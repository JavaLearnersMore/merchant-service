package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.dto.OrderRequest;
import com.example.dto.OrderResponse;
import com.example.service.MerchantOderService;

@Controller
@RequestMapping("/merchant")
public class MerchantOrderUiController {

    private final MerchantOderService merchantOrderService;

    public MerchantOrderUiController(
            MerchantOderService merchantOrderService) {
        this.merchantOrderService = merchantOrderService;
    }

    @PostMapping("/create-order")
    public String createOrder(
            @RequestParam String orderRef,
            @RequestParam Double amount,
            @RequestParam String currency,
            @RequestParam String customerEmail,
            Model model) {

        OrderRequest request = new OrderRequest();

        request.setOrderRef(orderRef);
        request.setAmount(amount);
        request.setCurrency(currency);
        request.setCustomerEmail(customerEmail);

        OrderResponse response = merchantOrderService.createOrders(request, 1001L);

        model.addAttribute("orderResponse", response);

        return "registration";
    }
}

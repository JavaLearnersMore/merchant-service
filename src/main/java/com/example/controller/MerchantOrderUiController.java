
package com.example.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.model.Merchant_Order;
import com.example.service.MerchantOderService;

@Controller
@RequestMapping("/merchant")
public class MerchantOrderUiController {

    private final MerchantOderService merchantOrderService;

    public MerchantOrderUiController(MerchantOderService merchantOrderService) {
        this.merchantOrderService = merchantOrderService;
    }

    @GetMapping("/my-orders")
    @ResponseBody
    public List<Merchant_Order> listOfMyOrders() {

        List<Merchant_Order> orders = merchantOrderService.getAllOrders();

        System.out.println("Total orders found = " + orders.size());

        return orders;
    }
}

   
//    @GetMapping("merchant/my-orders")
//    public String listOfMyOrders(Model model) {
//
//        List<Merchant_Order> orders =merchantOrderService.getMyOrders(1001L);
//        model.addAttribute("order", orders);
//        return "registration";
//    }
//    }
//    

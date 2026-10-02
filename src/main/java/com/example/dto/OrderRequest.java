package com.example.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

public class OrderRequest {
	
	
	 @NotBlank(message = "Order reference is required")
	 @Pattern(
	        regexp = "^ORD-\\d{4}-\\d{6}$",
	        message = "Order reference must be in format ORD-2026-000123"
	    )
	  private String orderRef;

	  @NotNull(message = "Amount is required")
	  @Positive(message = "Amount must be greater than 0")
	  private Double amount;

	    @NotBlank(message = "Currency is required")
	    private String currency;

	    @NotBlank(message = "Customer email is required")
	    @Email(message = "Enter a valid email address")
	    private String customerEmail;

    public String getOrderRef() {
        return orderRef;
    }

    public void setOrderRef(String orderRef) {
        this.orderRef = orderRef;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

}

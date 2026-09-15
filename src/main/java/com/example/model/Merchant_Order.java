package com.example.model;

import java.time.LocalDateTime;

public class Merchant_Order {
	
	private long id;
	private long merchant_id;
	private String order_ref;
	private Double amount; 
	private String currency; 
	private String status; 
	private String customer_email; 
	private String pg_txn_ref; 
	private LocalDateTime  created_at; 
	private LocalDateTime updated_at;
	
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	
	public long getMerchant_id() {
		return merchant_id;
	}
	public void setMerchant_id(long merchant_id) {
		this.merchant_id = merchant_id;
	}
	
	
	public String getOrder_ref() {
		return order_ref;
	}
	public void setOrder_ref(String order_ref) {
		this.order_ref = order_ref;
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
	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	public String getCustomer_email() {
		return customer_email;
	}
	public void setCustomer_email(String customer_email) {
		this.customer_email = customer_email;
	}
	
	
	public String getPg_txn_ref() {
		return pg_txn_ref;
	}
	public void setPg_txn_ref(String pg_txn_ref) {
		this.pg_txn_ref = pg_txn_ref;
	}
	
	
	public LocalDateTime getCreated_at() {
		return created_at;
	}
	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}
	
	
	public LocalDateTime getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(LocalDateTime updated_at) {
		this.updated_at = updated_at;
	}
	
	
	
	

}

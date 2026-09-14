package com.example.model;

public class MerchantUser {
	
	 private Long id;
	    private Long merchantId;
	    private String username;
	    private String passwordHash;
	    private String role;
	    private boolean active;

	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public Long getMerchantId() {
	        return merchantId;
	    }

	    public void setMerchantId(Long merchantId) {
	        this.merchantId = merchantId;
	    }

	    public String getUsername() {
	        return username;
	    }

	    public void setUsername(String username) {
	        this.username = username;
	    }

	    public String getPasswordHash() {
	        return passwordHash;
	    }

	    public void setPasswordHash(String passwordHash) {
	        this.passwordHash = passwordHash;
	    }

	    public String getRole() {
	        return role;
	    }

	    public void setRole(String role) {
	        this.role = role;
	    }

	    public boolean isActive() {
	        return active;
	    }

	    public void setActive(boolean active) {
	        this.active = active;
	    }
	}

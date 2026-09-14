package com.example.dto;

public class MerchantRegisterRequest {
	
	 private String legalName;
	    private String email;
	    private String phone;
	    private String panNumber;
	    private String gstNumber;
	    private String settlementAccountId;

	    private String adminUsername;
	    private String adminPassword;

	    public String getLegalName() {
	        return legalName;
	    }

	    public void setLegalName(String legalName) {
	        this.legalName = legalName;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    public String getPhone() {
	        return phone;
	    }

	    public void setPhone(String phone) {
	        this.phone = phone;
	    }

	    public String getPanNumber() {
	        return panNumber;
	    }

	    public void setPanNumber(String panNumber) {
	        this.panNumber = panNumber;
	    }

	    public String getGstNumber() {
	        return gstNumber;
	    }

	    public void setGstNumber(String gstNumber) {
	        this.gstNumber = gstNumber;
	    }

	    public String getSettlementAccountId() {
	        return settlementAccountId;
	    }

	    public void setSettlementAccountId(String settlementAccountId) {
	        this.settlementAccountId = settlementAccountId;
	    }

	    public String getAdminUsername() {
	        return adminUsername;
	    }

	    public void setAdminUsername(String adminUsername) {
	        this.adminUsername = adminUsername;
	    }

	    public String getAdminPassword() {
	        return adminPassword;
	    }

	    public void setAdminPassword(String adminPassword) {
	        this.adminPassword = adminPassword;
	    }

}

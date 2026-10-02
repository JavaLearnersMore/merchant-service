package com.example.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class MerchantRegisterRequest {
	
	
	@NotBlank(message = "Legal name is required")
    @Size(min = 2, max = 100, message = "Legal name must be between 2 and 100 characters")
	 private String legalName;
	
	
	@NotBlank(message = "Email is required")
    @Email(message = "Please enter a valid email address")
    private String email;

    @NotBlank(message = "Phone number is required")
    @Pattern(
        regexp = "^[6-9][0-9]{9}$",
        message = "Phone number must be a valid 10-digit Indian mobile number"
    )
    private String phone;

    @NotBlank(message = "PAN number is required")
    @Pattern(
        regexp = "^[A-Z]{5}[0-9]{4}[A-Z]$",
        message = "PAN must be in format ABCDE1234F"
    )
    private String panNumber;

    @NotBlank(message = "GST number is required")
    @Pattern(
        regexp = "^[0-9]{2}[A-Z]{5}[0-9]{4}[A-Z][1-9A-Z]Z[0-9A-Z]$",
        message = "GST number must be in valid format"
    )
    private String gstNumber;

    @NotBlank(message = "Settlement account ID is required")
    @Size(min = 5, max = 50, message = "Settlement Account ID must be between 5 and 50 characters")
    private String settlementAccountId;

    @NotBlank(message = "Admin username is required")
    @Size(min = 4, max = 30, message = "Admin username must be between 4 and 30 characters")
    private String adminUsername;

    @NotBlank(message = "Admin password is required")
    @Size(min = 8, max = 50, message = "Admin password must be between 8 and 50 characters")
    private String adminPassword;
	
    @NotBlank(message = "Role is required")
	private String role;

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

	    
	    public String getRole() {
	        return role;
	    }

	    public void setRole(String role) {
	        this.role = role;
	    }
}

package com.example.dto;

public class LoginResponse {
	
	private String accessToken;
    private String tokenType;
    private long expiresInSeconds;
    private Long merchantId;
    private String role;

 public LoginResponse(String accessToken,String tokenType,long expiresInSeconds,Long merchantId, String role) {
        this.accessToken = accessToken;
        this.tokenType = tokenType;
        this.expiresInSeconds = expiresInSeconds;
        this.merchantId = merchantId;
        this.role = role;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public long getExpiresInSeconds() {
        return expiresInSeconds;
    }

    public Long getMerchantId() {
        return merchantId;
    }

    public String getRole() {
        return role;
    }

}

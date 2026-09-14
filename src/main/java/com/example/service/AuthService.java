package com.example.service;

import com.example.dto.LoginRequest;
import com.example.dto.LoginResponse;

public interface AuthService {

	LoginResponse login(LoginRequest request);

}

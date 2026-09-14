package com.example.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.dto.LoginRequest;
import com.example.dto.LoginResponse;
import com.example.service.AuthService;

@Controller
public class AuthController {
	
	@Autowired
	private final AuthService authService;
	
	public AuthController(AuthService authService) {
		this.authService=authService;
	}
	
	//login
	@GetMapping("/login")
    public String login() {
        return "login";
    }

	//api 
	@PostMapping("/api/v1/auth/login")
	@ResponseBody
	public ResponseEntity<LoginResponse> loginMerchant(@RequestBody LoginRequest request) {
	
	LoginResponse response=authService.login(request);
	return ResponseEntity.ok(response);
		
		
	}
	
	@PostMapping("/login")
	public String loginFromUi(
	        @RequestParam String username,
	        @RequestParam String password,
	        Model model) {

	    LoginRequest request = new LoginRequest();
	    request.setUsername(username);
	    request.setPassword(password);
	    LoginResponse response = authService.login(request);
	    model.addAttribute("loginResponse",response);
	    return "registration";
	}
}
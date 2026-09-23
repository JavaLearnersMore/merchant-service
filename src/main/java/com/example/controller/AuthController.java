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
	
	
	//login ui response
	@PostMapping("/login")
	public String loginFromUi(
	        @RequestParam String username,
	        @RequestParam String password,
	        Model model,
	        HttpSession session) {

	    LoginRequest request = new LoginRequest();
	    request.setUsername(username);
	    request.setPassword(password);
	    try {
	        LoginResponse response = authService.login(request);

	        model.addAttribute("loginResponse", response);

	        session.setAttribute("loginResponse", response);
	        session.setAttribute("adminUsername", username);
	        session.setAttribute("adminRole", response.getRole());
	        session.setAttribute("adminMerchantId", response.getMerchantId());

	    } catch (RuntimeException e) {

	        model.addAttribute("loginError", e.getMessage());
	    }

	    return "registration";
	}
	
	
	
    // ==============================
    // MERCHANT LOGIN API
    // ==============================

    @PostMapping("/api/v1/merchant/auth/login")
    @ResponseBody
    public ResponseEntity<LoginResponse> merchantLogin(
            @RequestBody LoginRequest request) {

        LoginResponse response =authService.merchantLogin(request);

        return ResponseEntity.ok(response);
    }


    // ==============================
    // MERCHANT LOGIN UI
    // ==============================

    @PostMapping("/merchant/login")
    public String merchantLoginFromUi(
            @RequestParam String username,
            @RequestParam String password,
            Model model,
            HttpSession session) {

        LoginRequest request = new LoginRequest();

        request.setUsername(username);
        request.setPassword(password);
        try {
            LoginResponse response = authService.merchantLogin(request);

            model.addAttribute("merchantLoginResponse", response);

            // Store merchant login in session
            session.setAttribute("merchantLoginResponse", response);
            session.setAttribute("merchantId", response.getMerchantId());
            session.setAttribute("merchantRole", response.getRole());
            session.setAttribute("merchantUsername", username);

        } catch (RuntimeException e) {

            model.addAttribute("merchantLoginError", e.getMessage());
        }

        return "registration";
    
}
}
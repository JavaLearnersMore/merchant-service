package com.example.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	public String login(Model model) {

	    model.addAttribute("loginRequest", new LoginRequest());

	    return "login";
	}
	
	

	//API 
	@PostMapping("/api/v1/auth/login")
	@ResponseBody
	public ResponseEntity<LoginResponse> loginMerchant(@RequestBody LoginRequest request) {
	
	LoginResponse response=authService.login(request);
	return ResponseEntity.ok(response);
		
		
	}
	
	
	//loginUI response
	@PostMapping("/login")
	public String loginFromUi(
	   @Valid @ModelAttribute("loginRequest") LoginRequest request,
	   BindingResult result,
	   Model model,
	   HttpSession session) {

//	    LoginRequest request = new LoginRequest();
//	    request.setUsername(username);
//	    request.setPassword(password);
		
		//  Check validation errors 
		if (result.hasErrors()) { 
			result.getFieldErrors().forEach(error -> {
				System.out.println( error.getField() + " = " + error.getDefaultMessage() );
				}
			);
			return "registration";
		}
		
		
	    try {
	        LoginResponse response = authService.login(request);

	        model.addAttribute("loginResponse", response);

	        session.setAttribute("loginResponse", response);
	        session.setAttribute("adminUsername",request.getUsername());
	        session.setAttribute("adminRole", response.getRole());
	        session.setAttribute("adminMerchantId", response.getMerchantId());

	    } catch (RuntimeException e) {

	        model.addAttribute("loginError", e.getMessage());
	    }

	    return "registration";
	}
	
	
	//merchant login api
	
	@PostMapping("/api/v1/merchant/auth/login")
	@ResponseBody
	public ResponseEntity<LoginResponse> merchantLogin(
	        @RequestBody LoginRequest request,
	        HttpSession session) {

	    LoginResponse response = authService.merchantLogin(request);

	    // Store merchant details in session
	    session.setAttribute("merchantLoginResponse", response);
	    session.setAttribute("merchantId", response.getMerchantId());
	    session.setAttribute("merchantRole", response.getRole());
	    session.setAttribute("merchantUsername", request.getUsername());

	    return ResponseEntity.ok(response);
	}  
	

    // ==============================
    // MERCHANT LOGIN UI
    // ==============================

    @PostMapping("/merchant/login")
    public String merchantLoginFromUi(
    		@Valid @ModelAttribute("merchantLoginRequest") LoginRequest request,
    		BindingResult result,
            Model model,
            HttpSession session) {

//        LoginRequest request = new LoginRequest();
//
//        request.setUsername(username);
//        request.setPassword(password);
    	
    	if (result.hasErrors()) {
    		
    		result.getFieldErrors().forEach(error -> { 
    			System.out.println( error.getField() + " = " + error.getDefaultMessage() );
    			}
    		); 
    		
    		return "registration"; 
    	}
    	
    	
        try {
            LoginResponse response = authService.merchantLogin(request);

            model.addAttribute("merchantLoginResponse", response);

            // Store merchant login in session
            session.setAttribute("merchantLoginResponse", response);
            session.setAttribute("merchantId", response.getMerchantId());
            model.addAttribute("merchantLoginResponse", response);
            session.setAttribute("merchantRole", response.getRole());
            session.setAttribute("merchantUsername",request.getUsername());

        } catch (RuntimeException e) {

            model.addAttribute("merchantLoginError", e.getMessage());
        }

        return "registration";
    
}
}
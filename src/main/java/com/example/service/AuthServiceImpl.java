package com.example.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.dao.MerchantDao;
import com.example.dto.LoginRequest;
import com.example.dto.LoginResponse;
import com.example.model.Merchant;
import com.example.model.MerchantUser;
import com.example.security.config.JwtService;

@Service
public class AuthServiceImpl implements AuthService{
	
	private final MerchantDao merchantDao;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthServiceImpl(MerchantDao merchantDao,PasswordEncoder passwordEncoder,JwtService jwtService) {
        this.merchantDao = merchantDao;
        this.passwordEncoder = passwordEncoder;
        this.jwtService=jwtService;
    }


    @Override
    public LoginResponse login(LoginRequest request) {

     // 1. Find user
     MerchantUser user =merchantDao.findUserByUsername(request.getUsername());


      // 2. Check password
      boolean passwordMatches =passwordEncoder.matches(request.getPassword(),user.getPasswordHash());

        if (!passwordMatches) {
            throw new RuntimeException("Invalid username or password");
        }


        // 3. Check user active
        if (!user.isActive()) {
            throw new RuntimeException("User is inactive");
        }


        // 4. Get merchant
        Merchant merchant = merchantDao.findById(user.getMerchantId());


//        // 5. Check KYC
//        if (!"APPROVED".equalsIgnoreCase(
//                merchant.getKycStatus())) {
//
//            throw new RuntimeException(
//                    "KYC is not approved yet"
//            );
//        }
//
//
//        // 6. Check merchant status
//        if (!"ACTIVE".equalsIgnoreCase(
//                merchant.getStatus())) {
//
//            throw new RuntimeException(
//                    "Merchant is not active yet"
//            );
//        }


        // 7. JWT for accesstoken
        String accessToken =
                jwtService.generateToken(
                        user.getMerchantId(),
                        user.getUsername(),
                        user.getRole()
                );


        // 8. Create response
        return new LoginResponse(
                accessToken,
                "Bearer",
                3600,
                user.getMerchantId(),
                user.getRole()
        );
    }
    
    
    
 // =====================================================
    // MERCHANT LOGIN
    // =====================================================

    @Override
    public LoginResponse merchantLogin(LoginRequest request) {

        // 1. Find merchant user
        MerchantUser user = merchantDao.findUserByUsername(request.getUsername());

        // 2. Check password
        boolean passwordMatches =passwordEncoder.matches(
        		request.getPassword(),user.getPasswordHash());

        if (!passwordMatches) {
            throw new RuntimeException("Invalid username or password");
        }

        // 3. Check merchant user active
        if (!user.isActive()) {
            throw new RuntimeException("Merchant user is inactive");
        }

        // 4. Get merchant
        Merchant merchant =merchantDao.findById(user.getMerchantId());
        
        // We are explicitly passing MERCHANT as role.
        String accessToken =jwtService.generateToken(user.getMerchantId(), user.getUsername(),"MERCHANT");

        // 6. Return merchant response
        return new LoginResponse(
                accessToken,
                "Bearer",
                3600,
                user.getMerchantId(),
                "MERCHANT"
        );
    }
	
}

package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

  @SpringBootApplication
	class MerchantServiceApplication extends SpringBootServletInitializer {

	    public static void main(String[] args) {
	        SpringApplication.run(MerchantServiceApplication.class, args);
	    }

	    @Override
	    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	        return application.sources(MerchantServiceApplication.class);
	    }
	}
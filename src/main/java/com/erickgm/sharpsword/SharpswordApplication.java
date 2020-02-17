package com.erickgm.sharpsword;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SharpswordApplication {

	public static void main(String[] args) {
		SpringApplication.run(SharpswordApplication.class, args);
		//System.out.print(new BCryptPasswordEncoder().encode("JA2fth82")); 
		
		// http://localhost:8080/swagger-ui.html
	}

}

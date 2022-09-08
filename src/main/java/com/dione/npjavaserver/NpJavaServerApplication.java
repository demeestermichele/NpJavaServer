package com.dione.npjavaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class NpJavaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(NpJavaServerApplication.class, args);
	}


}

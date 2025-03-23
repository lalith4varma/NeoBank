package com.NeoBank.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.NeoBank"})
public class NeoBankApplication {

	public static void main(String[] args) {
		SpringApplication.run(NeoBankApplication.class, args);
	}
}

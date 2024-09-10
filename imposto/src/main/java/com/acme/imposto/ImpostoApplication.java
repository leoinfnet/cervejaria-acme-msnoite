package com.acme.imposto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ImpostoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImpostoApplication.class, args);
	}

}

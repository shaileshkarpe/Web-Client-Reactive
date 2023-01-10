package com.reactiveresttemplate.webclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class webclientApplication {

	public static void main(String[] args) {
		SpringApplication.run(webclientApplication.class, args);
	}
	@Bean

	public WebClient webClient() {
		return WebClient.builder().build();
	}

}

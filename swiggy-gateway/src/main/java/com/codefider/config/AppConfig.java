package com.codefider.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration

public class AppConfig {

	@Bean
	public RestTemplate template() {
		return new RestTemplate();
	}

	
	/*
	 * @Bean public SecurityFilterChain securityFilterChain(HttpSecurity http)
	 * throws Exception { return http.csrf().disable().build(); }
	 */
	 
	
}

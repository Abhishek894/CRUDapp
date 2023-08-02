package com.customerManagement.security;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SpringSecurityConfiguration {

	@Bean
	public InMemoryUserDetailsManager creatUserDetailsManager() {
		
		Function<String, String> PasswordEncoder
		         = input->passwordEncoder().encode(input);
		UserDetails userDetails= org.springframework.security.core.userdetails.User.builder()
				.passwordEncoder(PasswordEncoder)
		.username("test@sunbasedata.com")
		.password("Test@123")
		.roles("USER","ADMIN")
		.build();
		return new InMemoryUserDetailsManager(userDetails);
	}
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}

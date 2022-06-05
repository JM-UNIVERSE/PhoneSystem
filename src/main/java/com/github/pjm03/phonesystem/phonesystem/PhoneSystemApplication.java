package com.github.pjm03.phonesystem.phonesystem;

import com.google.gson.Gson;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PhoneSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhoneSystemApplication.class, args);
	}

	@Bean
	public Gson gson() {
		return new Gson();
	}
}

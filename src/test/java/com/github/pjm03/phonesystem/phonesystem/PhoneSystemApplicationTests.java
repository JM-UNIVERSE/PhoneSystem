package com.github.pjm03.phonesystem.phonesystem;

import com.google.gson.JsonElement;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedHashMap;

class PhoneSystemApplicationTests {

	@Test
	void contextLoads() {
		RestTemplate template = new RestTemplate();
		String response = template.getForObject("http://localhost:8080" + "/human/deserialize/" + "AAnrsJXrs5HsmrEACDE5NzIwMjIwAAYxOTI3MDAAAAAALlN4G9NtQfRsvij7ag3Ir6vX3df-ABhEzRjkXOZgCiU", String.class);
		System.out.println(response);
	}
}

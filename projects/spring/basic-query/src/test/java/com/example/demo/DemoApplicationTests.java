package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	UserRepo userRepo;

	@Test
	void contextLoads() {
		assertNotNull(userRepo);
	}

	@Test
	void queries() {
		assertEquals(1, userRepo.findByFirstName("Jane").size());
		assertEquals(1, userRepo.findByFirstName("John").size());
		assertEquals(2, userRepo.findByLastName("Doe").size());
		assertEquals(1, userRepo.findByLastNameAndFirstNameIgnoreCase("Doe", "john").size());
	}
}

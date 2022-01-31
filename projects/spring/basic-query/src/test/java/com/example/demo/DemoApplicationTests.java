package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	UserRepo userRepo;

	@Test
	void contextLoads() {
	}

	@Test
	void queries() {
		User john = new User();
		john.setFirstName("John");
		john.setLastName("Doe");

		User jane = new User();
		jane.setFirstName("Jane");
		jane.setLastName("Doe");

    	userRepo.saveAll(Arrays.asList(john, jane));

		userRepo.findByFirstName("Jane").forEach(result -> System.out.println(result));

	}

}

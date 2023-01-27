package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	UserRepo userRepo;

	@Autowired
	AddressRepo addressRepo;

	@Test
	void contextLoads() {
	}

	@Test
	void queries() {
		User john = new User();
		john.setFirstName("John");
		john.setLastName("Doe");
		Address address = new Address();
		address.setCity("Testcity");
		address.setStreet("Teststreet");
		address.setZipCode("12345");
		address.setNr("1a");
		address.setUser(john);
		john.setAddresses(List.of(address));

		User jane = new User();
		jane.setFirstName("Jane");
		jane.setLastName("Doe");

    	userRepo.saveAll(Arrays.asList(john, jane));

		List<User> usersFromCity = userRepo.findByAddresses_City("Testcity");
		assertEquals("John", usersFromCity.stream().findFirst().get().getFirstName());

		List<AddressView> addressesWithZipcode = addressRepo.findByZipCode("12345");
		assertEquals("John", addressesWithZipcode.get(0).getUser().getFirstName());
	}

}

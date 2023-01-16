package de.dhbw.retrydb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

@SpringBootApplication
@EnableRetry
public class RetryDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(RetryDbApplication.class, args);
	}

}

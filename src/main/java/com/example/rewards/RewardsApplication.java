package com.example.rewards;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RewardsApplication {

	public static void main(String[] args) {
		System.out.println("Reward Service Loading");
		SpringApplication.run(RewardsApplication.class, args);
		System.out.println("Reward Service Loaded");
	}

}

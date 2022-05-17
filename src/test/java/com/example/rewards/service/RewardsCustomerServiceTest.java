package com.example.rewards.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.rewards.entity.RewardsCustomer;
import com.example.rewards.repo.RewardsCustomerRepo;
import com.example.rewards.service.impl.RewardsCustomerServiceImpl;

public class RewardsCustomerServiceTest {

	@InjectMocks
	RewardsCustomerServiceImpl rewardsCustomerService;
	
	@Mock
	RewardsCustomerRepo rewardsCustomerRepo;

	@BeforeEach
	void setUpBeforeClass() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void getRewardsCustomer_valid_custId() {
		String custId="1001";
		
		RewardsCustomer rewardsCustomer = new RewardsCustomer();
		rewardsCustomer.setCustId(custId);
		rewardsCustomer.setCustNm("Cust 1001");
		
		when(rewardsCustomerRepo.findById(custId)).thenReturn(Optional.of(rewardsCustomer));
		
		RewardsCustomer returnRewardsCustomer =  rewardsCustomerService.getRewardsCustomer(custId);
		
		assertNotNull(returnRewardsCustomer);
		assertEquals(returnRewardsCustomer.getCustId(), custId);
	}
	
	@Test
	void getRewardsCustomer_invalid_custId() {
		String custId="1002";
		
		when(rewardsCustomerRepo.findById(custId)).thenReturn(null);
		RewardsCustomer returnRewardsCustomer =  rewardsCustomerService.getRewardsCustomer(custId);
		
		assertNull(returnRewardsCustomer);
	}
	
	@Test
	void getRewardsCustomer_exception() {
		String custId="1002";
		
		when(rewardsCustomerRepo.findById(custId)).thenThrow(new RuntimeException());		
		assertThrows(RuntimeException.class, ()->{rewardsCustomerService.getRewardsCustomer(custId);});
	}
	
}

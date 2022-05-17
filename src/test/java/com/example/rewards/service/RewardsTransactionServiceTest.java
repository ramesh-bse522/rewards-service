/**
 * 
 */
package com.example.rewards.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.rewards.repo.RewardsTransactionRepo;
import com.example.rewards.service.impl.RewardsTransactionServiceImpl;

/**
 * @author rbonigi
 *
 */
class RewardsTransactionServiceTest {
	
	@InjectMocks
	RewardsTransactionServiceImpl rewardsTransactionService;
	
	@Mock
	RewardsTransactionRepo rewardsTransactionRepo;


	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void fetchPurchaseAmt_valid_custId() {
		String custId="1001";
		when(rewardsTransactionRepo.getPurchaseAmtByCustId(custId)).thenReturn(90.00);
		assertEquals(rewardsTransactionService.fetchPurchaseAmt(custId), 90.00);	
	}
	
	@Test
	void fetchPurchaseAmt_invalid_custId() {
		String custId="1002";
		when(rewardsTransactionRepo.getPurchaseAmtByCustId(custId)).thenReturn(0.00);
		assertEquals(rewardsTransactionService.fetchPurchaseAmt(custId), 0.00);	
	}
	
	@Test
	void fetchPurchaseAmt_exception() {
		String custId="1003";
		when(rewardsTransactionRepo.getPurchaseAmtByCustId(custId))
		.thenThrow(new RuntimeException("Mock Runtime Exception"));
		assertThrows(RuntimeException.class, ()->{rewardsTransactionService.fetchPurchaseAmt(custId);});
	}
	
}

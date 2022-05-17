package com.example.rewards.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rewards.repo.RewardsTransactionRepo;
import com.example.rewards.service.RewardsTransactionService;

/**
 * @author rbonigi
 *
 */
@Service
public class RewardsTransactionServiceImpl implements RewardsTransactionService {

	@Autowired
	RewardsTransactionRepo rewardsTransactionRepo;

	@Override
	public double fetchPurchaseAmt(String custId) {
		return rewardsTransactionRepo.getPurchaseAmtByCustId(custId);
	}
}

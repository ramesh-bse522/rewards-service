package com.example.rewards.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static final Logger log = LoggerFactory.getLogger(RewardsTransactionServiceImpl.class);

	@Autowired
	RewardsTransactionRepo rewardsTransactionRepo;

	@Override
	public double fetchPurchaseAmt(String custId) {
		log.debug("Entered in RewardsTransactionServiceImpl fetchPurchaseAmt method for custId :{"+custId+"}");
		return rewardsTransactionRepo.getPurchaseAmtByCustId(custId);
	}
}


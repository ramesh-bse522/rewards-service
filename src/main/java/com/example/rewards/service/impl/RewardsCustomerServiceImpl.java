package com.example.rewards.service.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rewards.entity.RewardsCustomer;
import com.example.rewards.repo.RewardsCustomerRepo;
import com.example.rewards.service.RewardsCustomerService;

@Service
public class RewardsCustomerServiceImpl implements RewardsCustomerService{
    private static final Logger log = LoggerFactory.getLogger(RewardsCustomerServiceImpl.class);

	@Autowired
	RewardsCustomerRepo rewardsCustomerRepo;

	@Override
	public RewardsCustomer getRewardsCustomer(String custId) {
		log.debug("Entered in RewardsCustomerServiceImpl getRewardsCustomer method for custId :{"+custId+"}");
		Optional<RewardsCustomer> optRewardsCustomer=rewardsCustomerRepo.findById(custId);
		if(optRewardsCustomer==null|| !optRewardsCustomer.isPresent()) {
			log.warn("Invalid Customer for custId :{"+custId+"}");
			return null;
		}
		log.info("Valid Customer for custId :{"+custId+"}");

		return optRewardsCustomer.get();
	}

}


package com.example.rewards.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rewards.entity.RewardsCustomer;
import com.example.rewards.repo.RewardsCustomerRepo;
import com.example.rewards.service.RewardsCustomerService;

@Service
public class RewardsCustomerServiceImpl implements RewardsCustomerService{
	
	@Autowired
	RewardsCustomerRepo rewardsCustomerRepo;

	@Override
	public RewardsCustomer getRewardsCustomer(String custId) {	
		Optional<RewardsCustomer> optRewardsCustomer=rewardsCustomerRepo.findById(custId);
		if(optRewardsCustomer==null|| !optRewardsCustomer.isPresent()) 
			return null;
		return optRewardsCustomer.get();
	}

}

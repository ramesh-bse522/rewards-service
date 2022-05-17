package com.example.rewards.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.rewards.model.Rewards;
import com.example.rewards.model.RewardsResponse;
import com.example.rewards.service.RewardsCustomerService;
import com.example.rewards.service.RewardsTransactionService;
import com.example.rewards.util.RewardsConstants;
import com.example.rewards.util.RewardsUtil;

/**
 * @author rbonigi
 *
 */
@RestController
public class RewardsController {
	
	@Autowired(required=true)
	RewardsCustomerService rewardsCustomerService;
	
	@Autowired(required=true)
	RewardsTransactionService rewardsTransactionService;
	
	@GetMapping("/rewards/{custId}")
	public ResponseEntity<RewardsResponse> getCustomerRewards(@PathVariable String custId) {
		RewardsResponse rewardsResponse = new RewardsResponse();
		
		try {
			if(StringUtils.isBlank(custId)) {
				rewardsResponse.setStatus(HttpStatus.BAD_REQUEST.getReasonPhrase());
				rewardsResponse.setMessage(RewardsConstants.INVALID_ARG_EMP_NULL);
				return ResponseEntity.badRequest().body(rewardsResponse);
			}
			
			if(rewardsCustomerService.getRewardsCustomer(custId.trim())==null) {
				rewardsResponse.setStatus(HttpStatus.BAD_REQUEST.getReasonPhrase());
				rewardsResponse.setMessage(RewardsConstants.INVALID_CUST_ID);
				return ResponseEntity.badRequest().body(rewardsResponse);
			}
		
			double putchaseAmt = rewardsTransactionService.fetchPurchaseAmt(custId);
			int rewardsPoints = RewardsUtil.computeRewardsPoints(putchaseAmt);
			Rewards rewards = new Rewards();
			rewards.setPoints(rewardsPoints);
			
			rewardsResponse.setStatus(HttpStatus.OK.getReasonPhrase());
			rewardsResponse.setMessage(RewardsConstants.SUCCESS);
			rewardsResponse.setRewards(rewards);
			
			return ResponseEntity.ok().body(rewardsResponse);
		}catch(Exception e) {
			rewardsResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
			rewardsResponse.setMessage(RewardsConstants.INTERNAL_SERVER_ERROR);
			return ResponseEntity.internalServerError().body(rewardsResponse);
		}
	}

}

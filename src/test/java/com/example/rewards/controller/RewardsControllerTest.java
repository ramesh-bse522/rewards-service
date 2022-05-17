package com.example.rewards.controller;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.example.rewards.entity.RewardsCustomer;
import com.example.rewards.service.RewardsCustomerService;
import com.example.rewards.service.RewardsTransactionService;
import com.example.rewards.util.RewardsConstants;

@WebMvcTest(RewardsController.class)
public class RewardsControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	RewardsCustomerService rewardsCustomerService;
	
	@MockBean
	RewardsTransactionService rewardsTransactionService;
	
	@Test
	public void getCustomerRewards_Empty_CustId() throws Exception{
		String custId="";
		this.mockMvc.perform(get("/rewards/"+custId))
		.andDo(print())
		.andExpect(status().isNotFound());		
	}
	
	@Test
	public void getCustomerRewards_Blank_CustId() throws Exception{
		String custId=" ";
		
		this.mockMvc.perform(get("/rewards/"+custId))
		.andDo(print())
		.andExpect(status().isBadRequest())
		.andExpect(content().string(containsString(RewardsConstants.INVALID_ARG_EMP_NULL)));
		
	}
	
	@Test
	public void getCustomerRewards_Invalid_CustId() throws Exception{
		String custId="1000";
		
		when(rewardsCustomerService.getRewardsCustomer(custId)).thenReturn(null);
		
		this.mockMvc.perform(get("/rewards/"+custId))
		.andDo(print())
		.andExpect(status().isBadRequest())
		.andExpect(content().string(containsString(RewardsConstants.INVALID_CUST_ID)));
	}
	
	@Test
	public void getCustomerRewards_Valid_CustId_1001() throws Exception{
		String custId="1001";
		
		RewardsCustomer rewardsCustomer = new RewardsCustomer();
		rewardsCustomer.setCustId(custId);
		rewardsCustomer.setCustNm("Cust 1001");
		
		when(rewardsCustomerService.getRewardsCustomer(custId)).thenReturn(rewardsCustomer);
		when(rewardsTransactionService.fetchPurchaseAmt(custId)).thenReturn((120.00));
		
		this.mockMvc.perform(get("/rewards/"+custId))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().string(containsString(RewardsConstants.SUCCESS)));
	}
	
	@Test
	public void getCustomerRewards_Valid_CustId_1002() throws Exception{
		String custId="1002";
		double purchaseAmount = 120.00;
		
		RewardsCustomer rewardsCustomer = new RewardsCustomer();
		rewardsCustomer.setCustId(custId);
		rewardsCustomer.setCustNm("Cust 1002");
		
		when(rewardsCustomerService.getRewardsCustomer(custId)).thenReturn(rewardsCustomer);
		when(rewardsTransactionService.fetchPurchaseAmt(custId)).thenReturn((purchaseAmount));
		
		this.mockMvc.perform(get("/rewards/"+custId))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().string(containsString(RewardsConstants.SUCCESS)))
		.andExpect(content().string(containsString("rewards")))
		.andExpect(content().string(containsString("points")))
		.andExpect(content().string(containsString("90")))
		;
	}
	
	@Test
	public void getCustomerRewards_Valid_CustId_1003() throws Exception{
		String custId="1003";
		double purchaseAmount = 220.00;
		
		RewardsCustomer rewardsCustomer = new RewardsCustomer();
		rewardsCustomer.setCustId(custId);
		rewardsCustomer.setCustNm("Cust 1003");
		
		when(rewardsCustomerService.getRewardsCustomer(custId)).thenReturn(rewardsCustomer);
		when(rewardsTransactionService.fetchPurchaseAmt(custId)).thenReturn(purchaseAmount);
		
		this.mockMvc.perform(get("/rewards/"+custId))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().string(containsString(RewardsConstants.SUCCESS)))
		.andExpect(content().string(containsString("rewards")))
		.andExpect(content().string(containsString("points")))
		.andExpect(content().string(containsString("290")))
		;
	}
	
	@Test
	public void getCustomerRewards_Valid_CustId_Exception_Customer() throws Exception{
		String custId="1003";
		double purchaseAmount = 220.00;
		
		RewardsCustomer rewardsCustomer = new RewardsCustomer();
		rewardsCustomer.setCustId(custId);
		rewardsCustomer.setCustNm("Cust 1003");
		
		when(rewardsCustomerService.getRewardsCustomer(custId)).thenThrow(new RuntimeException());
		when(rewardsTransactionService.fetchPurchaseAmt(custId)).thenReturn(purchaseAmount);
		
		this.mockMvc.perform(get("/rewards/"+custId))
		.andDo(print())
		.andExpect(status().isInternalServerError())
		.andExpect(content().string(containsString(RewardsConstants.INTERNAL_SERVER_ERROR)))
		;
	}
	
	@Test
	public void getCustomerRewards_Valid_CustId_Exception_Trans() throws Exception{
		String custId="1003";
		
		RewardsCustomer rewardsCustomer = new RewardsCustomer();
		rewardsCustomer.setCustId(custId);
		rewardsCustomer.setCustNm("Cust 1003");
		
		when(rewardsCustomerService.getRewardsCustomer(custId)).thenReturn(rewardsCustomer);
		when(rewardsTransactionService.fetchPurchaseAmt(custId)).thenThrow(new RuntimeException());
		
		this.mockMvc.perform(get("/rewards/"+custId))
		.andDo(print())
		.andExpect(status().isInternalServerError())
		.andExpect(content().string(containsString(RewardsConstants.INTERNAL_SERVER_ERROR)))
		;
	}
	
	

}

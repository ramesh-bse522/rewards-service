package com.example.rewards.repo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.example.rewards.entity.RewardsCustomer;

@DataJpaTest
class RewardsCustomerRepoTest {
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	RewardsCustomerRepo rewardsCustomerRepo;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		
		rewardsCustomerRepo.deleteAll();
		entityManager.flush();
		
		RewardsCustomer rewardsCustomer1 = new RewardsCustomer();
		rewardsCustomer1.setCustId("1001");
		rewardsCustomer1.setCustNm("Cust 1001");
		
		entityManager.persist(rewardsCustomer1);
		
		RewardsCustomer rewardsCustomer2 = new RewardsCustomer();
		rewardsCustomer2.setCustId("1002");
		rewardsCustomer2.setCustNm("Cust 1002");
		
		entityManager.persist(rewardsCustomer2);

		RewardsCustomer rewardsCustomer3 = new RewardsCustomer();		
		rewardsCustomer3.setCustId("1003");
		rewardsCustomer3.setCustNm("Cust 1003");
		
		entityManager.persist(rewardsCustomer3);
		
		entityManager.flush();
	}
	
	@AfterEach
	void delete() throws Exception{
		rewardsCustomerRepo.deleteAll();
		entityManager.flush();
	}
	
	@Test
	void findById_valid_custId() {
		RewardsCustomer rewardsCustomer1 = rewardsCustomerRepo.findById("1001").get();
		assertNotNull(rewardsCustomer1);
		assertEquals(rewardsCustomer1.getCustId(), "1001");
		assertEquals(rewardsCustomer1.getCustNm(), "Cust 1001");
		
		RewardsCustomer rewardsCustomer2 = rewardsCustomerRepo.findById("1002").get();
		assertNotNull(rewardsCustomer2);
		assertEquals(rewardsCustomer2.getCustId(), "1002");
		assertEquals(rewardsCustomer2.getCustNm(), "Cust 1002");
		
		RewardsCustomer rewardsCustomer3 = rewardsCustomerRepo.findById("1003").get();
		assertNotNull(rewardsCustomer3);
		assertEquals(rewardsCustomer3.getCustId(), "1003");
		assertEquals(rewardsCustomer3.getCustNm(), "Cust 1003");
		
		Optional<RewardsCustomer> rewardsCustomer4 = rewardsCustomerRepo.findById("1004");
		assertFalse(rewardsCustomer4.isPresent());
	}

}

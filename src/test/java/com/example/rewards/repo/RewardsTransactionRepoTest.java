package com.example.rewards.repo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.example.rewards.entity.RewardsTransaction;

@DataJpaTest
class RewardsTransactionRepoTest {
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	RewardsTransactionRepo rewardsTransactionRepo;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		
		rewardsTransactionRepo.deleteAll();
		entityManager.flush();
		
		RewardsTransaction rewardsTransaction11= new RewardsTransaction();
		//rewardsTransaction11.setId(1L);
		rewardsTransaction11.setCustId("1001");
		rewardsTransaction11.setPurchaseAmt(120D);
		
		entityManager.persist(rewardsTransaction11);
		
		RewardsTransaction rewardsTransaction12= new RewardsTransaction();
		//rewardsTransaction12.setId(2L);
		rewardsTransaction12.setCustId("1001");
		rewardsTransaction12.setPurchaseAmt(130D);
		
		entityManager.persist(rewardsTransaction12);

		RewardsTransaction rewardsTransaction13= new RewardsTransaction();
		//rewardsTransaction11.setId(3L);
		rewardsTransaction13.setCustId("1001");
		rewardsTransaction13.setPurchaseAmt(140D);
		
		entityManager.persist(rewardsTransaction13);

		RewardsTransaction rewardsTransaction21= new RewardsTransaction();
		//rewardsTransaction21.setId(4L);
		rewardsTransaction21.setCustId("1002");
		rewardsTransaction21.setPurchaseAmt(220D);
		
		entityManager.persist(rewardsTransaction21);
		
		RewardsTransaction rewardsTransaction22= new RewardsTransaction();
		//rewardsTransaction22.setId(5L);
		rewardsTransaction22.setCustId("1002");
		rewardsTransaction22.setPurchaseAmt(230D);
		
		entityManager.persist(rewardsTransaction22);
		
		RewardsTransaction rewardsTransaction31= new RewardsTransaction();
		//rewardsTransaction31.setId(6L);
		rewardsTransaction31.setCustId("1003");
		rewardsTransaction31.setPurchaseAmt(320D);
		
		entityManager.persist(rewardsTransaction31);
		
		RewardsTransaction rewardsTransaction32= new RewardsTransaction();
		//rewardsTransaction32.setId(7L);
		rewardsTransaction32.setCustId("1003");
		rewardsTransaction32.setPurchaseAmt(330D);
		
		entityManager.persist(rewardsTransaction32);
		
		entityManager.flush();
	}
	
	@AfterEach
	void delete() throws Exception{
		rewardsTransactionRepo.deleteAll();
		entityManager.flush();
	}

	@Test
	void test() {
		Double purchaseAmt1001=rewardsTransactionRepo.getPurchaseAmtByCustId("1001");
		assertEquals(purchaseAmt1001,390d);
		
		Double purchaseAmt1002=rewardsTransactionRepo.getPurchaseAmtByCustId("1002");
		assertEquals(purchaseAmt1002,450d);

		Double purchaseAmt1003=rewardsTransactionRepo.getPurchaseAmtByCustId("1003");
		assertEquals(purchaseAmt1003,650d);
		
		Double purchaseAmt1004=rewardsTransactionRepo.getPurchaseAmtByCustId("1004");
		assertEquals(purchaseAmt1004,null);

	}

}

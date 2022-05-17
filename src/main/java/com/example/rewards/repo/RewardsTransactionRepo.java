package com.example.rewards.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.rewards.entity.RewardsTransaction;

@Repository
public interface RewardsTransactionRepo extends JpaRepository<RewardsTransaction, Long> {
	
	@Query(value="select sum(purchase_amt) from rewards_transaction where cust_id=:custId group by cust_id", nativeQuery = true)
	public Double getPurchaseAmtByCustId(String custId);

}

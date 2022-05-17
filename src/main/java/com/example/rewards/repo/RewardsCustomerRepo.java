package com.example.rewards.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.rewards.entity.RewardsCustomer;

@Repository
public interface RewardsCustomerRepo extends JpaRepository<RewardsCustomer, String>{

}

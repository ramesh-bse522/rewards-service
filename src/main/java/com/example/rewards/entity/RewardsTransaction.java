package com.example.rewards.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="REWARDS_TRANSACTION")
@Getter
@Setter
public class RewardsTransaction {
	
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	
	@Column(name = "CUST_ID")
	String custId;
	
	@Column(name = "PURCHASE_AMT")
	Double purchaseAmt;

}

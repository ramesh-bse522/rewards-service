package com.example.rewards.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="REWARDS_CUSTOMER")
@Getter
@Setter
public class RewardsCustomer {
	@Id
	@Column(name = "CUST_ID")
	String custId;
	@Column(name = "CUST_NM")
	String custNm;

}

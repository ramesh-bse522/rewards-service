/**
 * 
 */
package com.example.rewards.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.example.rewards.util.RewardsUtil;

/**
 * @author rbonigi
 *
 */
class RewardsUtilTest {
	
	@Test
	void computeRewardsPoints_0() {
		assertEquals(RewardsUtil.computeRewardsPoints(0),0);
	}
	
	@Test
	void computeRewardsPoints_Negative() {
		assertEquals(RewardsUtil.computeRewardsPoints(-1),0);
	}
	
	@Test
	void computeRewardsPoints_Negative_100() {
		assertEquals(RewardsUtil.computeRewardsPoints(-100),0);
	}
	
	@Test
	void computeRewardsPoints_120() {
		assertEquals(RewardsUtil.computeRewardsPoints(120),90);
	}
	
	@Test
	void computeRewardsPoints_220() {
		assertEquals(RewardsUtil.computeRewardsPoints(220),290);
	}
	
}

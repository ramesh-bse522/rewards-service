package com.example.rewards.util;

/**
 * @author rbonigi
 *
 */
public class RewardsUtil {
	
	public static int computeRewardsPoints(double purchaseAmt) {
		return  ((purchaseAmt-100)>0?(int)(purchaseAmt-100)*2:0)+
				(purchaseAmt>50?50:0);
	}

}

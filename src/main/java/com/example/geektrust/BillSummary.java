package com.example.geektrust;

import java.util.Map;
import java.util.Set;

public class BillSummary {

	public static int getCost(String[] result, Map<String, Integer> map1, Set<String> checkIn) {
		int balance = map1.get(result[0]);
		int cost = PassengerType.valueOf(result[1]).price;
		if(checkIn.contains(result[0])) {
			cost = cost * 50 / 100;
		}
		
		if(balance >= cost) {
			map1.put(result[0], balance - cost);
		}
		else {
//			System.out.println("need to focus here  ");
			return cost + ((cost - balance) * 2 / 100);
		}
		return cost;
	}
}

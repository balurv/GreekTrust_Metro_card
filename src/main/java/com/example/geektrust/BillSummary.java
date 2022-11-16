package com.example.geektrust;

import java.util.Map;

public class BillSummary {

	public static double getCostCentral(String[] result, Map<String, Integer> map1) {
		int balance = map1.get(result[0]);
		int cost = PassengerType.valueOf(result[1]).price;
		if(balance > cost) {
			map1.put(result[0], balance - cost);
		}
		else {
			System.out.println("need to focus here  ");
			return cost - balance;
		}
		return cost;
	}

	public static double getCostAirport(String[] result, Map<String, Integer> map1) {
		int balance = map1.get(result[0]);
		int cost = PassengerType.valueOf(result[1]).price;
		if(balance>= cost) {
			map1.put(result[0], balance - cost);
		}
		else {
			System.out.print("need of focus here  ");
			return cost + ((cost - balance) * 2 / 100);
		}
		return cost;
	}
}

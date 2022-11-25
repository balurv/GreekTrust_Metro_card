package com.example.geektrust;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class PrintPassengerSummary {
	static class Pair{
		String name;
		int num;
		public Pair(String name, int num){
			this.name = name;
			this.num = num;
		}
	}
	public static void printPassenger(int[] passenger, Map<String, List<PassengerSource>> metroCardPassengerSource, String source) {
		int totalCollection = calculateCollection(source, metroCardPassengerSource);
		int discount = calculateDiscount(source,metroCardPassengerSource);
		System.out.println(totalCollection+" "+discount);
		List<Pair> list = new ArrayList<>();
		PassengerType[] passengerTypesValue = PassengerType.values();
		for(int i = 0; i < passenger.length; i++) {
			list.add(new Pair(passengerTypesValue[i].toString(),passenger[i]));
		}
		Collections.sort(list, new Comparator<Pair>() {

			@Override
			public int compare(Pair p1, Pair p2) {
				if(p2.num == p1.num) {
					return p1.name.compareTo(p2.name);
				}
				return p2.num - p1.num;
			}
		});
		System.out.println("PASSENGER_TYPE_SUMMARY");
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).num > 0) {
				System.out.println(list.get(i).name+" "+ list.get(i).num);
			}
		}
	}
	
	private static int calculateCollection(String source, Map<String, List<PassengerSource>> metroCardPassengerSource) {
		return 0;
	}

	private static int calculateDiscount(String source, Map<String, List<PassengerSource>> metroCardPassengerSource) {
//		if()
//		System.out.println(metroCardPassengerSource);
		return 0;
	}
}

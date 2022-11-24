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
	public static void print(int kid, int adult, int senior) {
		List<Pair> list = new ArrayList<>();
		list.add(new Pair("KID", kid));
		list.add(new Pair("ADULT", adult));
		list.add(new Pair("SENIOR_CITIZEN", senior));
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
	public static void print(int[] centralPassenger, Map<String, List<PassengerSource>> metroCardPassengerSource) {
		List<Pair> list = new ArrayList<>();
		PassengerType[] passengerTypesValue = PassengerType.values();
		for(int i = 0; i < centralPassenger.length; i++) {
			list.add(new Pair(passengerTypesValue[i].toString(),centralPassenger[i]));
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
}

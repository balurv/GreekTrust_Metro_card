package com.example.geektrust;

public class Pair {
	PassengerType passengerType;
	String source;
	
	Pair(PassengerType passengerType,String source){
		this.passengerType = passengerType;
		this.source = source;
	}

	@Override
	public String toString() {
		return "Pair [passengerType=" + passengerType + ", source=" + source + "]";
	}
	
}

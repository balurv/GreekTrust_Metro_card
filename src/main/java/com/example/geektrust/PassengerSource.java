package com.example.geektrust;

public class PassengerSource {
	PassengerType passengerType;
	String source;
	
	PassengerSource(PassengerType passengerType,String source){
		this.passengerType = passengerType;
		this.source = source;
	}

	@Override
	public String toString() {
		return "Pair [passengerType=" + passengerType + ", source=" + source + "]";
	}
	
}

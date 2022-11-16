package com.example.geektrust;

public enum PassengerType {
	KID(50),
	ADULT(200),
	SENIOR_CITIZEN(100);
	
	int price;
	PassengerType(int price){
		this.price = price;
	}
	int getPrice() {
		return price;
	}
}
		
		
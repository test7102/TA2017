package com.javatask;

public enum Manufacturer {
	AIRBUS("Airbus", "EU"), BOEING("Boeing", "USA"), ANTONOV("Antonov", "RUS"), SUKHOI("Sukhoi", "RUS"),
	MIL("Mil", "RUS");
	
	private String company;
	private String manufacturingCountry;
	
	Manufacturer(String company, String manufacturingCountry) {
		this.company = company;
		this.manufacturingCountry = manufacturingCountry;
	}
}

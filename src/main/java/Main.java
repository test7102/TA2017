package main.java;

import main.java.util.PrintDelimeter;
import main.java.util.CompanyPlanesFiller;

public class Main {
	
	public static void main(String[] args) {
		
		AirCompany aeroflot = new AirCompany("Aeroflot", Headquarters.RUSSIA);
		AirCompany rossiya = new AirCompany("Rossiya", Headquarters.RUSSIA);
		AirCompany s7 = new AirCompany("S7 Airlines", Headquarters.RUSSIA);
		AirCompany utair = new AirCompany("UTair", Headquarters.RUSSIA);
		AirCompany emirates = new AirCompany("Emirates", Headquarters.UAE);
		AirCompany delta = new AirCompany("Delta Airlines", Headquarters.USA);
		AirCompany lufthansa = new AirCompany("Lufthansa", Headquarters.GERMANY);
		
		CompanyPlanesFiller.fill(aeroflot);
		CompanyPlanesFiller.fill(utair);
		
		utair.addAircraft(99001, new Helicopter("Mi-8p", Manufacturer.MIL, 3, 37, 590, false));
		utair.addAircraft(99002, new Helicopter("Mi-8p", Manufacturer.MIL, 3, 37, 590, false));
		
//		utair.addAircraft(10000, new Helicopter("Mi-8p", Manufacturer.MIL, 3, 37, 590, false)); // throws BoardNumberFormatException
		
		
		
		aeroflot.sortPlanesByRange();
		PrintDelimeter.print();
		aeroflot.sumCarryingCapacity();
		PrintDelimeter.print();
		utair.sortPlanesByRange();
		PrintDelimeter.print();
		utair.sumCarryingCapacity();
		
	}
}

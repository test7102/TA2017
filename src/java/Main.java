package java;

import java.util.PrintDelimeter;

public class Main {
	
	public static void main(String[] args) {
		// Integer.toString(rand.nextInt(99999) + 1);
		
		AirCompany aeroflot = new AirCompany("Aeroflot", Headquarters.RUSSIA);
		AirCompany rossiya = new AirCompany("Rossiya", Headquarters.RUSSIA);
		AirCompany s7 = new AirCompany("S7 Airlines", Headquarters.RUSSIA);
		AirCompany utair = new AirCompany("UTair", Headquarters.RUSSIA);
		AirCompany emirates = new AirCompany("Emirates", Headquarters.UAE);
		AirCompany delta = new AirCompany("Delta Airlines", Headquarters.USA);
		AirCompany lufthansa = new AirCompany("Lufthansa", Headquarters.GERMANY);
		
		
		Plane b777300er = new Plane("777-300ER", Manufacturer.BOEING, 2, 550, 10190);
		Plane b737800 = new Plane("737-800", Manufacturer.BOEING, 2, 189, 5765);
		Plane b767300er = new Plane("767-300ER", Manufacturer.BOEING, 2, 290, 10550);
		Plane b747400 = new Plane("747-400", Manufacturer.BOEING, 2, 624, 11440);
		Plane a320200 = new Plane("A320-200", Manufacturer.AIRBUS, 2, 180, 6150);
		Plane a319100 = new Plane("A319-100", Manufacturer.AIRBUS, 2, 156, 6850);
		Plane a380800 = new Plane("A380-800", Manufacturer.AIRBUS, 2, 700, 15000);
		Plane a330300 = new Plane("A330-300", Manufacturer.AIRBUS, 2, 440, 10400);
		Plane an148100 = new Plane("AN-148-100", Manufacturer.ANTONOV, 3, 75, 3600);
		Plane an74tk100 = new Plane("AN-74TK-100", Manufacturer.ANTONOV, 3, 52, 2750);
		Plane superjet100 = new Plane("SuperJet-100", Manufacturer.SUKHOI, 3, 98, 4578);
		
		aeroflot.addAircraft("99999",b777300er);
		aeroflot.addAircraft("99997",a330300);
		aeroflot.addAircraft("99998",b777300er);
		aeroflot.addAircraft("99991",superjet100);
		
		
		
//		b737800.printAircraftInfo();
		aeroflot.sumCarryingCapacity();
		PrintDelimeter.print();
		aeroflot.sortPlanesByRange();
		
	}
}

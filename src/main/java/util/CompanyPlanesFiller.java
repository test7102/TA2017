package main.java.util;

import main.java.AirCompany;
import main.java.Manufacturer;
import main.java.Plane;
import main.java.exceptions.RegistrationException;

public class CompanyPlanesFiller {
	/**
	 *  Utility method, that populates airCompany with planes(hardcoded).
	 * @param airCompany
	 */
	public static void fill(AirCompany airCompany) {
		if ("Aeroflot".equals(airCompany.getName())) {
			airCompany.addAircraft(56999, new Plane("777-300ER", Manufacturer.BOEING, 2, 550, 10190));
			airCompany.addAircraft(56998, new Plane("737-800", Manufacturer.BOEING, 2, 189, 5765));
			airCompany.addAircraft(56997, new Plane("A330-300", Manufacturer.AIRBUS, 2, 440, 10400));
			airCompany.addAircraft(56996, new Plane("A320-200", Manufacturer.AIRBUS, 2, 180, 6150));
			airCompany.addAircraft(56994, new Plane("SuperJet-100", Manufacturer.SUKHOI, 3, 98, 4578));
		}
		
		if ("Rossiya".equals(airCompany.getName())) {
			airCompany.addAircraft(16781, new Plane("747-400", Manufacturer.BOEING, 2, 624, 11440));
			airCompany.addAircraft(16782, new Plane("777-300ER", Manufacturer.BOEING, 2, 550, 10190));
			airCompany.addAircraft(16782, new Plane("767-300ER", Manufacturer.BOEING, 2, 290, 10550));
			airCompany.addAircraft(16783, new Plane("737-800", Manufacturer.BOEING, 2, 189, 5765));
			airCompany.addAircraft(16784, new Plane("A319-100", Manufacturer.AIRBUS, 2, 156, 6850));
			airCompany.addAircraft(16785, new Plane("A320-200", Manufacturer.AIRBUS, 2, 180, 6150));
			airCompany.addAircraft(16785, new Plane("AN-148-100", Manufacturer.ANTONOV, 3, 75, 3600));
		}
		
		if ("UTair".equals(airCompany.getName())) {
			airCompany.addAircraft(99291, new Plane("767-300ER", Manufacturer.BOEING, 2, 290, 10550));
			airCompany.addAircraft(99292, new Plane("737-800", Manufacturer.BOEING, 2, 189, 5765));
			airCompany.addAircraft(99293, new Plane("AN-74TK-100", Manufacturer.ANTONOV, 3, 52, 2750));
		}
		
		if ("S7 Airlines".equals(airCompany.getName())) {
			airCompany.addAircraft(16784, new Plane("A319-100", Manufacturer.AIRBUS, 2, 156, 6850));
			airCompany.addAircraft(16785, new Plane("A320-200", Manufacturer.AIRBUS, 2, 180, 6150));
			airCompany.addAircraft(99292, new Plane("737-800", Manufacturer.BOEING, 2, 189, 5765));
			airCompany.addAircraft(99291, new Plane("767-300ER", Manufacturer.BOEING, 2, 290, 10550));
		}
		if ("Emirates".equals(airCompany.getName())) {
			airCompany.addAircraft(74121, new Plane("777-300ER", Manufacturer.BOEING, 2, 550, 10190));
			airCompany.addAircraft(74122, new Plane("777-200LR", Manufacturer.BOEING, 2, 440, 17000));
			airCompany.addAircraft(74123, new Plane("A380-800", Manufacturer.AIRBUS, 2, 700, 15000));
			
		}
		if ("Lufthansa".equals(airCompany.getName())) {
			airCompany.addAircraft(45101, new Plane("A380-800", Manufacturer.AIRBUS, 2, 700, 15000));
			airCompany.addAircraft(45102, new Plane("747-400", Manufacturer.BOEING, 2, 624, 11440));
			airCompany.addAircraft(45103, new Plane("A330-300", Manufacturer.AIRBUS, 2, 440, 10400));
			airCompany.addAircraft(45104, new Plane("A320-200", Manufacturer.AIRBUS, 2, 180, 6150));
			airCompany.addAircraft(45105, new Plane("A319-100", Manufacturer.AIRBUS, 2, 156, 6850));
			
		}
		
		if ("Delta Airlines".equals(airCompany.getName())) {
			airCompany.addAircraft(10001, new Plane("A380-800", Manufacturer.AIRBUS, 2, 700, 15000));
			airCompany.addAircraft(10002, new Plane("747-400", Manufacturer.BOEING, 2, 624, 11440));
			airCompany.addAircraft(10003, new Plane("777-300ER", Manufacturer.BOEING, 2, 550, 10190));
			airCompany.addAircraft(10004, new Plane("737-800", Manufacturer.BOEING, 2, 189, 5765));
			airCompany.addAircraft(10005, new Plane("767-300ER", Manufacturer.BOEING, 2, 290, 10550));
			airCompany.addAircraft(10006, new Plane("A330-300", Manufacturer.AIRBUS, 2, 440, 10400));
			airCompany.addAircraft(10007, new Plane("A320-200", Manufacturer.AIRBUS, 2, 180, 6150));
			airCompany.addAircraft(10008, new Plane("A319-100", Manufacturer.AIRBUS, 2, 156, 6850));
			
		}
		
		
	}
	
}

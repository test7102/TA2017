package main.java;

import main.java.annotations.ByPassengers;
import main.java.annotations.ByRange;
import main.java.util.PrintDelimeter;
import main.java.util.CompanyPlanesFiller;

import java.lang.reflect.InvocationTargetException;

public class Main {
	
	public static void main(String[] args) {
		System.out.println("Создание авиакомпаний");
		AirCompany aeroflot = new AirCompany("Aeroflot", Headquarters.RUSSIA);
		AirCompany rossiya = new AirCompany("Rossiya", Headquarters.RUSSIA);
		AirCompany s7 = new AirCompany("S7 Airlines", Headquarters.RUSSIA);
		AirCompany utair = new AirCompany("UTair", Headquarters.RUSSIA);
		AirCompany emirates = new AirCompany("Emirates", Headquarters.UAE);
		AirCompany delta = new AirCompany("Delta Airlines", Headquarters.USA);
		AirCompany lufthansa = new AirCompany("Lufthansa", Headquarters.GERMANY);
		
		System.out.println("Заполнение авиакомпании самолетами, через оберточный класс");
		CompanyPlanesFiller.fill(aeroflot);
		CompanyPlanesFiller.fill(utair);
		
		System.out.println("Добавление отдельного воздушного судна");
		aeroflot.addAircraft(99001, new Helicopter("Mi-8p", Manufacturer.MIL, 3, 37, 590, false));
		utair.addAircraft(99002, new Helicopter("Mi-8p", Manufacturer.MIL, 3, 37, 590, false));
		
//		utair.addAircraft(10000, new Helicopter("Mi-8p", Manufacturer.MIL, 3, 37, 590, false)); // пример unchecked  RegistrationCodeFormatException
//		utair.addAircraft(99002, new Plane("A319-100", Manufacturer.AIRBUS, 2, 156, 6850)); // пример checked  RegistrationException
		
		
		System.out.println("Сортировка самолетов компании по дальности полета ->");
		aeroflot.sortPlanesByRange();
		PrintDelimeter.print();
		System.out.println("Подсчёт общей вместимости ->");
		aeroflot.sumCarryingCapacity();
		PrintDelimeter.print();
		
		
		try {
			
			aeroflot.findAircraft(100,190);
		} catch (ReflectiveOperationException e) {
			e.printStackTrace();
		}
		
		
	}
}

package com.javatask;

import com.javatask.annotations.*;
import com.javatask.exceptions.*;
import com.javatask.interfaces.*;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class AirCompany implements IAircraftInfo {
	private String name;
	private Headquarters headquarters;
	
	private HashMap<String, Aircraft> airFleet = new HashMap<String, Aircraft>();
	
	
	public AirCompany(String name, Headquarters headquarters) {
		this.name = name;
		this.headquarters = headquarters;
	}
	
	/**
	 * Static inner class, holds up all aircraft registration codes  of companies and checks for its uniqueness.
	 */
	private static class AirCraftRegistrator {
		
		private static final ArrayList<String> TAILNUMBERS = new ArrayList<String>();
		
		
		public static boolean isBoardnumberAllowed(String registrationCode) {
			return !TAILNUMBERS.contains(registrationCode);
			
			
		}
		
		
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Headquarters getHeadquarters() {
		return headquarters;
	}
	
	
	public void setHeadquarters(Headquarters headquarters) {
		this.headquarters = headquarters;
	}
	
	/**
	 * Method, adds  aircraft  to airFeet list.
	 * <p>It has checked exception {@link RegistrationException} and
	 * unchecked exception {@link RegistrationCodeFormatException}<p/>
	 *
	 * @param registrationNumber is unique registration code of aircraft
	 * @param aircraft           is Aircraft object , i.e., Plane or Helicopter
	 * @throws RegistrationCodeFormatException
	 */
	public void addAircraft(int registrationNumber, Aircraft aircraft) {
		String registrationCode;
		
		if (registrationNumber < 0 || registrationNumber > 99999) {
			throw new RegistrationCodeFormatException("Wrong board number format, should be 0-99999 only");
		}
		
		// "RA-99999";
		if (headquarters.equals(Headquarters.RUSSIA)) {
			registrationCode = "RA-" + registrationNumber;
		} else if (headquarters.equals(Headquarters.USA)) {
			registrationCode = "N-" + registrationNumber;
		} else if (headquarters.equals(Headquarters.GERMANY)) {
			registrationCode = "D-" + registrationNumber;
		} else if (headquarters.equals(Headquarters.UAE)) {
			registrationCode = "A6-" + registrationNumber;
		} else registrationCode = "I-" + registrationNumber;
		
		try {
			if (AirCraftRegistrator.isBoardnumberAllowed(registrationCode)) {
				AirCraftRegistrator.TAILNUMBERS.add(registrationCode);
				airFleet.put(registrationCode, aircraft);
			} else throw new RegistrationException("Board number already exists");
		} catch (RegistrationException e) {
			e.printStackTrace();
		}
		
		
	}
	
	/**
	 * Method, sums up aircrafts  carrying capacity.
	 */
	public void sumCarryingCapacity() {
		int sum = 0;
		for (Map.Entry<String, Aircraft> entry : airFleet.entrySet()) {
			sum += entry.getValue().getPassengers();
		}
		System.out.println("Total Carrying Capacity is " + sum + " passengers");
	}
	
	/**
	 * Method, sorts airfleet list of company by flight range.
	 */
	public void sortPlanesByRange() {
		List<Aircraft> aircraftsByRange = new ArrayList<Aircraft>(airFleet.values());
		Collections.sort(aircraftsByRange, new Comparator<Aircraft>() {
			
			public int compare(Aircraft t1, Aircraft t2) {
				return t1.getRange() - t2.getRange();
			}
		});
		
		System.out.printf("%-13s |%-12s |%-5s |%-10s |%-10s", "model", "manufacturer", "crew", "passengers", "range(km)\n");
		for (Aircraft aircraft : aircraftsByRange) {
			aircraft.printAircraftInfo();
		}
		
	}
	
	/**
	 * Method, finds aircraft airfleet within given params.
	 * Uses com.javatask.annotations to specify  parameter type.
	 *
	 * @param min minimum value
	 * @param max maximum value
	 * @throws IllegalArgumentException
	 * @see ByRange
	 * @see ByPassengers
	 */
	@ByPassengers
	public void findAircraft(int min, int max)     {
		if ((max < min) || (max < 0) || (min < 0)) {
			throw new IllegalArgumentException("Please enter valid params only");
		}
		int coutResults = 0;
		String methodName = "";
		System.out.println();
		Annotation[] annotations = new Annotation[0];
		try {
			annotations = this.getClass().getMethod("findAircraft", new Class[]{int.class, int.class}).getAnnotations();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		Annotation annotation = annotations[0];
		if (annotation.annotationType().getSimpleName().equals("ByPassengers")) {
			methodName = "getPassengers";
			
		} else if (annotation.annotationType().getSimpleName().equals("ByRange")) {
			methodName = "getRange";
		}
		
		System.out.println("finding aircraft by " + annotation.annotationType().getSimpleName().substring(2));
		System.out.printf("%-13s |%-12s |%-5s |%-10s |%-10s", "model", "manufacturer", "crew", "passengers", "range(km)\n");
		for (Aircraft aircraft : airFleet.values()) {
			Method mtd = null;
			try {
				mtd = aircraft.getClass().getMethod(methodName);
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			}
			int methodReturnValue = 0;
			try {
				methodReturnValue = (Integer) mtd.invoke(aircraft);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
			if (methodReturnValue >= min && methodReturnValue <= max) {
				aircraft.printAircraftInfo();
				coutResults++;
			}
			
		}
		System.out.println((coutResults == 0) ? "did not match any aircraft" : coutResults + " was found");
	}
	
	/**
	 * Method, prints all airfleet of that aircompany.
	 * This is implementation of following interface:
	 */
	public void printAircraftInfo() {
		System.out.printf("%-18s |%-13s |%-12s |%-5s |%-10s |%-10s", "registration code", "model", "manufacturer", "crew", "passengers", "range(km)\n");
		for (Map.Entry<String, Aircraft> entry : airFleet.entrySet()) {
			System.out.printf("%-18s |", entry.getKey());
			entry.getValue().printAircraftInfo();
		}
	}
	
}

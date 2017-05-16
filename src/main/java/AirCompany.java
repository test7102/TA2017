package main.java;

import main.java.exceptions.BoardNumberFormatException;
import main.java.exceptions.BoardNumberRegistrationException;

import java.util.*;

public class AirCompany {
	private String name;
	private Headquarters headquarters;
	
	private HashMap<String, Aircraft> airFleet = new HashMap<>();
	
	
	public AirCompany(String name, Headquarters headquarters) {
		this.name = name;
		this.headquarters = headquarters;
	}
	
	private static class AirCraftRegistrator {
		
		private static final ArrayList<String> BOARDNUMBERS = new ArrayList();
		
		public static boolean isBoardnumberAllowed(String registrationCode) {
			return !BOARDNUMBERS.contains(registrationCode);
			
			
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
	
	public void addAircraft(String boardNumber, Aircraft aircraft) {
		Random rand = new Random();
		int boardnumber = 0;
		try {
			boardnumber = Integer.parseInt(boardNumber);
		} catch (NumberFormatException e) {
			throw new BoardNumberFormatException("Wrong board  format, should be numbers only");
		}
		if (boardnumber < 0 || boardnumber > 99999) {
			throw new BoardNumberFormatException("Wrong board number format, should be 0-99999 only");
		}
		
		// "RA-99999";
		if (headquarters.equals(Headquarters.RUSSIA)) {
			boardNumber = "RA-" + boardnumber;
		} else if (headquarters.equals(Headquarters.USA)) {
			boardNumber = "N-" + boardnumber;
		} else if (headquarters.equals(Headquarters.GERMANY)) {
			boardNumber = "D-" + boardnumber;
		} else if (headquarters.equals(Headquarters.UAE)) {
			boardNumber = "A6-" + boardnumber;
		}
		try {
			if (AirCraftRegistrator.isBoardnumberAllowed(boardNumber)) {
				AirCraftRegistrator.BOARDNUMBERS.add(boardNumber);
				airFleet.put(boardNumber, aircraft);
			} else throw new BoardNumberRegistrationException("Board number already exists");
		} catch (BoardNumberRegistrationException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public void sumCarryingCapacity() {
		int sum = 0;
		for (Map.Entry<String, Aircraft> entry : airFleet.entrySet()) {
			sum += entry.getValue().getPassengers();
		}
		System.out.println("Total Carrying Capacity is " + sum + " passengers");
	}
	
	public void sortPlanesByRange() {
		List<Aircraft> aircraftsByRange = new ArrayList<Aircraft>(airFleet.values());
		Collections.sort(aircraftsByRange, new Comparator<Aircraft>() {
			
			public int compare(Aircraft t1, Aircraft t2) {
				return t1.getRange() - t2.getRange();
			}
		});
		
		System.out.printf("%-13s |%-12s |%-5s |%-10s |%-10s", "model", "manufacturer", "crew", "passengers", "range(km)\n");
		for (Aircraft p : aircraftsByRange) {
			p.printAircraftInfo();
		}
		
	}
	
	//TODO findPlane()
}

import exceptions.BoardNumberRegistrationException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class AirCompany {
	private String name;
	private Headquarters headquarters;
	
	private HashMap<String, AbstractAircraft> airFleet;
	
	
	private static class AirCraftRegistrator {
		private static ArrayList Boardnumbers;
		
		public static boolean isBoardnumberAllowed(String registrationCode) {
			if (Boardnumbers.contains(registrationCode)) {
				return false;
			} else return true;
			
			
		}
	}
	
	private enum Headquarters {
		RUSSIA, GERMANY, USA, UAE
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
	
	
	public void addAircraft(String registrationCode, AbstractAircraft aircraft) throws BoardNumberRegistrationException {
		Random rand = new Random();
		if (registrationCode.equals("")) {
			throw new BoardNumberRegistrationException();
		}
		
		
		if (headquarters.equals(Headquarters.RUSSIA)) {
			registrationCode = "RA-" + registrationCode;
		} else if (headquarters.equals(Headquarters.USA)) {
			registrationCode = "N-" + registrationCode;
		} else if (headquarters.equals(Headquarters.GERMANY)) {
			registrationCode = "D-" + registrationCode;
		} else if (headquarters.equals(Headquarters.UAE)) {
			registrationCode = "A6-" + registrationCode;
		}
		
		if (AirCraftRegistrator.isBoardnumberAllowed(registrationCode)) {
			airFleet.put(registrationCode, aircraft);
		} else throw new BoardNumberRegistrationException();
		
		
	}
	
}

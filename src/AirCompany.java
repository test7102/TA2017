import exceptions.BoardNumberRegistrationException;

import java.util.*;

public class AirCompany {
	private String name;
	private Headquarters headquarters;
	
	private HashMap<String, AbstractAircraft> airFleet = new HashMap<>();
	
	
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
	
	
	public void addAircraft(String registrationCode, AbstractAircraft aircraft) {
		try {
			Random rand = new Random();
			if ("".equals(registrationCode)) {
				throw new BoardNumberRegistrationException("Please enter board number for the plane");
			}
			// "RA-99999";
			
			
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
			} else throw new BoardNumberRegistrationException("Board number already exists");
		} catch (BoardNumberRegistrationException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		
	}
	
	public AirCompany(String name, Headquarters headquarters) {
		this.name = name;
		this.headquarters = headquarters;
	}
}

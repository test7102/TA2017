import interfaces.IAircraftInfo;

public abstract class AbstractAircraft implements IAircraftInfo {
	private String ModelName;
	private Manufacturer Manufacturer;
	private int crewSize;
	private int passengers;
	private int range;
	private boolean inFlight = false;
	private boolean inExploitation = true;
	
	public AbstractAircraft(String modelName, Manufacturer manufacturer, int crewSize, int passengers, int range) {
		ModelName = modelName;
		Manufacturer = manufacturer;
		this.crewSize = crewSize;
		this.passengers = passengers;
		this.range = range;
	}
	
	public void flyAway() {
		if (!inFlight) {
			System.out.println(ModelName + "flies away");
		} else {
			System.out.println("Aircraft already in a flight");
		}
		
	}
	
	public void checkEngines() {
		this.setInExploitation(false);
		System.out.println("checking " + ModelName + "engines");
	}
	
	
	public void setInExploitation(boolean inExploitation) {
		this.inExploitation = inExploitation;
	}
	
	public void setInFlight(boolean inFlight) {
		this.inFlight = inFlight;
	}
	
	public String getModelName() {
		return ModelName;
	}
	
	public Manufacturer getManufacturer() {
		return Manufacturer;
	}
	
	public int getCrewSize() {
		return crewSize;
	}
	
	public int getPassengers() {
		return passengers;
	}
	
	public int getRange() {
		return range;
	}
	
	public boolean isInFlight() {
		return inFlight;
	}
	
	public boolean isInExploitation() {
		return inExploitation;
	}
}

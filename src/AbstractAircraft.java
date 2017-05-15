import interfaces.IPrintInfo;

public abstract class AbstractAircraft implements IPrintInfo {
	String ModelName;
	Manufacturer Manufacturer;
	String registrationCode; // "RA-99999";
	int crewSize;
	int passengers;
	
	
	
	int range;
	
	boolean inExploitation = true;
	
	public void setInExploitation(boolean inExploitation) {
		this.inExploitation = inExploitation;
	}
	
}

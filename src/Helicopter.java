public class Helicopter extends AbstractAircraft {
	private Boolean isMultiPurposeModel;
	
	public void checkHeliRotor() {
		this.setInExploitation(false);
		System.out.println("Checking " + super.getModelName() + " rotor and rotor blades");
		
	}
	
	public Helicopter(String modelName, Manufacturer manufacturer, int crewSize, int passengers, int range, Boolean multiPurposeModel) {
		super(modelName, manufacturer, crewSize, passengers, range);
		this.isMultiPurposeModel = multiPurposeModel;
	}
	
	@Override
	public void printAircraftInfo() {
		
	}
	
}

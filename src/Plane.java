public class Plane extends AbstractAircraft {
	
	public void checkWings () {
		this.setInExploitation(false);
		System.out.println("Checking "+super.getModelName()+" wings");
	}
	
	public Plane(String modelName, Manufacturer manufacturer, int crewSize, int passengers, int range) {
		super(modelName, manufacturer, crewSize, passengers, range);
		
	}
	
	@Override
	public void printAircraftInfo() {
		
	}
}

package java;

public class Plane extends Aircraft {
	
	public void checkWings () {
		this.setInExploitation(false);
		System.out.println("Checking "+super.getModelName()+" wings");
	}
	
	public Plane(String modelName, Manufacturer manufacturer, int crewSize, int passengers, int range) {
		super(modelName, manufacturer, crewSize, passengers, range);
		
	}
	
	
}

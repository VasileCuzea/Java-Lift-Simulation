package model;

public class Floor {

	private int location;
	Button button;
	Door door;

	
	//Constructor
	public Floor (int location) {		
		this.location = location;
		button = new Button(location);
		door = new Door(location);
	}	
	
	
	//getters and setters for location
	public int getLocation() {	
		return location;
	}
	

	public void setLocation(int location) {		
		this.location = location;
	}		
}

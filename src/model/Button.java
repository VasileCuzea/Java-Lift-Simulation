package model;
import java.util.ArrayList;


public class Button implements Subject{

	private int status;
	private int location;	
	private ArrayList<Observer> observers = new ArrayList<Observer>();

	
	//Constructor
	public Button(int location) {		
		this.location = location;
		status = 0; //0 = not pressed, 1 = pressed;		
	}
	
	
	//getters and setters for status
	public int getStatus() {
		return status;
	}


	public void setStatus(int s) {		
		this.status = s;
	}

	
	//getters and setters for location
	public int getLocation() {
		return location;
	}
	
	public void setLocation(int location) {
		this.location = location;
	}

	
	public void buttonPressed() {
		setStatus(1);
		notifyObserver(1);
	}

	
	public void buttonNotPressed() {
		setStatus(0);
		notifyObserver(0);
	}

	
	public void registerObserver(Observer newObserver) {		
		observers.add(newObserver);
	}
	

	public void notifyObserver(int event) {	
		for (Observer observer : observers) {			
			observer.update(this, event); 
		}		
	}

	
	public Button getButton() {		
		return this;
	}
}

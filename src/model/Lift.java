package model;
import java.util.ArrayList;


public class Lift implements Runnable, Subject {
	
	private int liftLocation;
	private int liftStatus; //lift moving or standing
	private ArrayList<Observer> observers = new ArrayList<Observer>();
	
	
	
	//Constructor	
	public Lift() {		
		setLiftStatus(0);
		setLiftLocation(0);	
	}

	
	//getters and setters for location
	public int getLiftLocation() {
		return liftLocation;
	}


	public void setLiftLocation(int liftLocation) {
		this.liftLocation = liftLocation;
	}


	//getters and setters for status
	public int getLiftStatus() {
		return liftStatus;
	}


	public void setLiftStatus(int liftStatus) {
		this.liftStatus = liftStatus;
	}
	
	
	
	public void registerObserver(Observer newObserver) {		
		observers.add(newObserver);
	}


	public void removeObserver(Observer deleteObserver) {
		
		int observerIndex = observers.indexOf(deleteObserver);
		
		System.out.println("Observer " + (observerIndex + 1) + " removed");
		
		observers.remove(observerIndex);
	}


	public void notifyObserver(int event) {		
		for (Observer observer : observers) {			
			observer.update(this, event);
		}		
	}
	
	
	//run method
	public void run() {		
		notifyObserver(3);
	}
}

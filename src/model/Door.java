package model;
import java.util.ArrayList;


public class Door implements Runnable, Subject{
	private int doorStatus;
	private int location;
	private ArrayList<Observer> observers = new ArrayList<Observer>();
	
	
	//Constructor
	public Door (int location){
		this.location = location;
	}
	
	
	//get method for door status
	public int getDoorStatus(){
		if(doorStatus == 0) {
			setDoorStatus(0);
		}
		
		else {
			setDoorStatus(1);
		}
		return doorStatus;
	}

	
	//set method for door status
	public void setDoorStatus(int doorStatus) {	
		 this.doorStatus = doorStatus;
	}
	

	//set door location
	public void setLocation(int location) {
		this.location = location;
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
			notifyObserver(0);		
		}
			
}

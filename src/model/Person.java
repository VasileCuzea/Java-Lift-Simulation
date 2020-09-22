package model;
import java.util.ArrayList;


public class Person implements Runnable, Subject{

	private ArrayList<Observer> observers = new ArrayList<Observer>();
	private int personId;
	private int personLocation;
	
	
	 //Constructor
	public Person(int personLocation, int totalPeople) {
		this.personId = totalPeople;
		this.setPersonLocation(personLocation); 		
	}
	
	
	//getters and setters for Id
	public int getpersonId(){
		return personId;
	}
	
	public void setPersonId(int personId){	
		this.personId = personId;
	}

	
	//getters and setters for location
	public int getPersonLocation(int personLocation) {		
		return personLocation;
	}
	
	
	public void setPersonLocation(int personLocation) {
			this.personLocation = personLocation;
	}


	
	public void registerObserver(Observer newObserver) {		
		observers.add(newObserver);
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


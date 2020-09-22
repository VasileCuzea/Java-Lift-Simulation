package model;
import view.Gui;
import java.util.ArrayList;

public class LiftModel implements Subject, Observer {
	
	Gui gui = new Gui();
	private int totalPeople = 1;
	private ArrayList<Observer> observers = new ArrayList<Observer>();
	
	Floor floor0;
	Floor floor1;
	Lift lift;
	Button button0;
	Button button1;
	Button button2;
	Door door0;
	Door door1;
	
	
	//Constructor
	public LiftModel () {
		button0 = new Button(0);// Ground Floor		
		button1 = new Button(1);// First Floor	
		button2 = new Button(2);// Lift Floor	
		door0 = new Door(0);
		door1 = new Door(1);
	}

	
	//create person method
	public void createPerson(int personLocation){		
		Person p = new Person(personLocation, totalPeople++) ;
		p.registerObserver(gui);
		new Thread(p).run();
	}

	
	
	//create lift method
	public void createLift(int lift){		
		Lift l = new Lift() ;
		l.registerObserver(gui);
		new Thread(l).run();
	}
	
	
	
	//get location of the door
	public Door getDoor(int location){	
		if (location == 0){
			return door0;
		}		
		else{
			return door1;
		}		
	}
	
	
	//create ground method
	public void createGroundFloor(int floor){		
		floor0 = new Floor(0);
		getDoor(0);
	}
	
	
	//create first floor method
	public void createFirstFloor(int floor){	
		floor1 = new Floor(1);
		getDoor(1);
	}
	

	
	public void registerObserver(Observer o) {
		observers.add(o);	
	}

	
	public void notifyObserver(int e) {	
	}

	
	public void update(Object o, int event) {		
	}	
	
}
